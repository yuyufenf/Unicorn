package com.gundam.unicorn.main.controller;

import com.gundam.unicorn.main.service.UserService;
import com.gundam.unicorn.utils.Result;
import com.gundam.unicorn.utils.annotation.ValueNotBlank;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @author kampf
 * @date 2020/1/3 下午4:35
 */
public class UserController {

    @Resource
    UserService userService;

    @ApiOperation(value = "用户登录")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @PostMapping(value = "/login")
    public Result login(@RequestBody @ValueNotBlank String userName, @RequestBody @ValueNotBlank String password){
        return userService.login(userName, password);
    }

    @ApiOperation(value = "用户登出")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 500, message = "系统异常"),
            @ApiResponse(code = 505, message = "请求次数过多")})
    @PostMapping(value = "/logout")
    public Result logout(@RequestBody @ValueNotBlank String userName){
        return userService.logout(userName);
    }
}
