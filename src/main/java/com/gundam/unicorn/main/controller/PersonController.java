package com.gundam.unicorn.main.controller;

import com.gundam.unicorn.entity.Person;
import com.gundam.unicorn.main.service.PersonService;
import com.gundam.unicorn.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author kampf
 * @date 2019/7/19 11:24
 */
@RestController
@RequestMapping(value = "/person")
@Api(tags = "用户信息处理controller")
public class PersonController {
    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    /**
     * 查询用户列表接口
     * @param person
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "查询用户列表")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 503, message = "非法请求!"),
            @ApiResponse(code = 504, message = "请求次数过多!")})
    @PostMapping(value = "/personList")
    public Result list(Person person, HttpServletRequest request, HttpServletResponse response){
        return personService.get();
    }

    /**
     * 保存用户信息接口
     * @param person
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "保存用户")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 501, message = "参数校验异常"),
            @ApiResponse(code = 502, message = "没有SESSION!"),
            @ApiResponse(code = 503, message = "非法请求!"),
            @ApiResponse(code = 504, message = "请求次数过多!")})
    @PostMapping(value = "/personSave")
    public Result add(@RequestBody @Valid Person person, HttpServletRequest request, HttpServletResponse response){
        return personService.add(person);
    }

    /**
     * 修改用户信息接口
     * 本质上和保存没有区别，只是为了前端调用接口清晰特意写了两个接口
     * @param person
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "更新用户")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 501, message = "参数校验异常"),
            @ApiResponse(code = 502, message = "没有SESSION!"),
            @ApiResponse(code = 503, message = "非法请求!"),
            @ApiResponse(code = 504, message = "请求次数过多!")})
    @PostMapping(value = "/personUpdate")
    public Result update(@RequestBody @Valid Person person, HttpServletRequest request, HttpServletResponse response){
        return personService.update(person);
    }


    @ApiOperation(value = "删除用户")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 503, message = "非法请求!"),
            @ApiResponse(code = 504, message = "请求次数过多!")})
    @DeleteMapping(value = "/personDelete")
    public Result delete(@RequestBody String personId, HttpServletRequest request, HttpServletResponse response){
        return personService.delete(personId);
    }

}
