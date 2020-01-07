package com.gundam.unicorn.main.service;

import com.gundam.unicorn.entity.User;
import com.gundam.unicorn.utils.Result;

/**
 * @author kampf
 * @date 2020/1/6 下午4:14
 */
public interface UserService extends BaseService<User>{

    Result login(String userName, String password);

    Result logout(String userName);
}
