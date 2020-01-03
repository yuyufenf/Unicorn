package com.gundam.unicorn.main.controller;

import com.gundam.unicorn.entity.Person;
import com.gundam.unicorn.main.service.PersonService;
import com.gundam.unicorn.utils.Result;
import com.gundam.unicorn.utils.annotation.ValueNotBlank;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 账号管理controller
 * @author kampf
 * @date 2019/7/19 11:24
 */
@RestController
@RequestMapping(value = "/person")
@Api(tags = "人员信息处理处理controller")
public class PersonController {

    @Resource
    private PersonService personService;

    @ApiOperation(value = "用户登录")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @PostMapping(value = "/login")
    public Result login(@RequestBody @ValueNotBlank String personName, @RequestBody @ValueNotBlank String password){
        return personService.login(personName, password);
    }

    @ApiOperation(value = "用户登出")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @PostMapping(value = "/logout")
    public Result logout(){
        return null;
    }

    /**
     * 查询账号列表接口
     * @return
     */
    @ApiOperation(value = "查询人员列表")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 503, message = "Token异常"),
            @ApiResponse(code = 504, message = "非法请求"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @GetMapping(value = "/personList")
    public Result list(int page, int pageNum){
        return personService.get(page, pageNum);
    }

    @ApiOperation(value = "根据条件查询人员信息")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 503, message = "Token异常"),
            @ApiResponse(code = 504, message = "非法请求"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @PostMapping(value = "/personList")
    public Result search(@RequestBody Person person){
        return personService.search(person);
    }

    /**
     * 根据人员id查询相关人员信息,多用于信息返显
     * @return
     */
    @ApiOperation(value = "根据id查询人员信息")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 503, message = "Token异常"),
            @ApiResponse(code = 504, message = "非法请求"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @GetMapping(value = "/getPerson")
    public Result getPerson(@RequestBody @ValueNotBlank String personId){
        return personService.findById(personId);
    }

    /**
     * 保存账号信息接口
     * @param person
     * @return
     */
    @ApiOperation(value = "人员信息保存")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 501, message = "参数校验异常"),
            @ApiResponse(code = 503, message = "Token异常"),
            @ApiResponse(code = 504, message = "非法请求"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @PostMapping(value = "/personSave")
    public Result add(@RequestBody @Valid Person person){
        return personService.add(person);
    }

    /**
     * 修改账号信息接口
     * 本质上和保存没有区别，只是为了前端调用接口清晰特意写了两个接口
     * @param person
     * @return
     */
    @ApiOperation(value = "更新人员信息")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 501, message = "参数校验异常"),
            @ApiResponse(code = 503, message = "Token异常"),
            @ApiResponse(code = 504, message = "非法请求"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @PostMapping(value = "/personUpdate")
    public Result update(@RequestBody @Valid Person person){
        return personService.update(person);
    }


    /**
     * 删除接口,不是物理删除,标签删除
     * @param personId
     * @return
     */
    @ApiOperation(value = "删除人员信息")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 503, message = "Token异常"),
            @ApiResponse(code = 504, message = "非法请求"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @DeleteMapping(value = "/personDelete")
    public Result delete(@RequestBody @ValueNotBlank String personId){
        return personService.delete(personId);
    }

}
