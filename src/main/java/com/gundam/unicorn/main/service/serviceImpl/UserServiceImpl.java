package com.gundam.unicorn.main.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gundam.unicorn.entity.User;
import com.gundam.unicorn.main.mapper.UserMapper;
import com.gundam.unicorn.main.service.UserService;
import com.gundam.unicorn.utils.Result;
import com.gundam.unicorn.utils.StringUtils;
import com.gundam.unicorn.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author kampf
 * @date 2020/1/6 下午4:26
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    UserMapper userDao;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Result login(String userName, String password) {

        try {
            User user = userDao.findUserByUserName(userName);

            if(StringUtils.isBlank(user)){
                return Result.error(Result.REQUEST_ERROR,"当前用户不存在");
            }

            String token = TokenUtils.getToken(user);
            //将userName作为key,token储存,2小时时效性
            redisTemplate.opsForValue().set(user.getUserName(), token, 2, TimeUnit.HOURS);

            if(StringUtils.md5(password).equals(user.getUserPassword())){

                JSONObject json = (JSONObject) JSON.toJSON(user);
                json.put("token", token);
                return Result.success(json, 0, "登录成功");
            } else {
                return Result.error(Result.BIND_ERROR, "密码错误");
            }
        } catch (Exception e){
            log.error("查询失败,错误信息:[{}]", e.getMessage(), e);
            return Result.error(Result.SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public Result logout(String userName) {
        try {
            User user = userDao.findUserByUserName(userName);
            if(StringUtils.isBlank(user)){
                return Result.error(Result.REQUEST_ERROR,"用户不存在");
            }

            //手动删除rides记录
            redisTemplate.delete(user.getUserName());
            return Result.success(null, 0, "登出成功");
        } catch (Exception e){
            log.error("登出失败报错信息:[{}]", e.getMessage(), e);
            return Result.error(Result.SERVER_ERROR, e.getMessage());
        }
    }
}
