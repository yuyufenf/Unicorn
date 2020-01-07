package com.gundam.unicorn.main.dao;

import com.gundam.unicorn.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kampf
 * @date 2020/1/6 16:34
 */
@Mapper
public interface UserDao extends BaseDao<User>{

    /**
     * 通过登录名查询用户密码
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);
}