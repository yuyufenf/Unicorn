package com.gundam.unicorn.config.intercepter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gundam.unicorn.main.service.PersonService;
import com.gundam.unicorn.utils.IpUtils;
import com.gundam.unicorn.utils.StringUtils;
import com.gundam.unicorn.utils.annotation.Authority;
import com.gundam.unicorn.utils.annotation.PassLogin;
import com.gundam.unicorn.utils.annotation.PassToken;
import com.gundam.unicorn.utils.exception.PermissionDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 登陆拦截器（可能会包含一部分非登陆用拦截）
 * @author kampf
 * @date 2019/8/16 19:34
 */
@Component
public class UnicornInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(UnicornInterceptor.class);

    @Autowired
    PersonService personService;

    /**
     * 此方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        //从请求头中取出token
        String token = request.getHeader("Token");

        //如果不是映射到方法
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //获得请求头方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        log.info("############User Interceptor Start############");
        log.info("############Request Real IP:" + IpUtils.getIpAddr(request));
        log.info("############Request URL:" + request.getRequestURL().toString());
        log.info("############Request Method:" + request.getMethod());
        log.info("############Request Token:" + request.getHeader("Token"));
        log.info("############User Interceptor End##############");

        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        if(method.isAnnotationPresent(PassLogin.class)){
            PassLogin passLogin = method.getAnnotation(PassLogin.class);
            if(passLogin.required()){
                loginCheck(token, method);
            }
        }

        return false;
    }

    private boolean loginCheck(String token, Method method){
        // 执行认证
        if (token == null) {
            new PermissionDeniedException("无token，请重新登录");
            return false;
        }

        String staffNum;
        try {
            staffNum = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            log.error("############User Interceptor Exception,Reason:" + j.getMessage());
            new PermissionDeniedException("非法token，请重新登录");
            return false;
        }
        String pwd = personService.findUserByUserName(staffNum);
        if (pwd == null) {
            new PermissionDeniedException("用户不存在");
            return false;
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(pwd)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            log.error("############User Interceptor Exception,Reason:" + e.getMessage());
            new PermissionDeniedException("token已失效,请重新登录");
            return false;
        }

        // 验证token通过后，再检查是否有PowerPrivilege注解
        if (method.isAnnotationPresent(Authority.class)) {
            Authority authority = method.getAnnotation(Authority.class);
            // 如果注解参数是角色
            if (authority.roles().length > 0) {
                // 获取注解中的角色
                String[] roles = authority.roles();
                List<String> roleList = new ArrayList<>();
                // 将角色加入一个list集合中
                Collections.addAll(roleList, roles);
                // 使用用户名与数据库中该用户的角色进行匹对,返回角色key
                String roleKey = personService.getUserRole(staffNum);
                if (roleList.contains(roleKey)) {
                    return true;
                }
            }

            // 验证token通过后，再检查是否有PowerPrivilege注解
            if (method.isAnnotationPresent(Authority.class)) {
                Authority Authority = method.getAnnotation(Authority.class);
                // 如果注解参数是权限
                if (Authority.authorities().length > 0) {
                    // 获取注解中的权限
                    String[] authorities = Authority.authorities();
                    // 使用用户名与数据库中该用户的角色进行匹对,返回角色key
                    String authorityName = personService.getUserRolePowers(staffNum).toString();
                    //去除两端方括号
                    authorityName = authorityName.replaceAll("[\\[\\]]", "");
                    authorityName = authorityName.replaceAll("\"", "");
                    System.out.println(authorityName);
                    String[] authorityNames = authorityName.split(",");
                    if (StringUtils.containArr(authorityNames, authorities)) {
                        return true;
                    }
                }
            }

            new PermissionDeniedException("没有权限访问");
            return false;
        }
        return true;
    }
}
