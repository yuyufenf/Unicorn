package com.gundam.unicorn.main.dao;

import com.gundam.unicorn.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author kampf
 * @date 2019/8/21 10:01
 */
@Mapper
public interface PersonDao extends BaseDao<Person>{

    /**
     * 通过登录名查询用户密码
     * @param userName
     * @return
     */
    String findUserByUserName(String userName);

    /**
     * 根据登陆查询用户角色
     * @param userName
     * @return
     */
    String getUserRole(String userName);

    /**
     * 根据用户名协同用户角色查询用户权限级别
     * @param userName
     * @return
     */
    List<Map<String,String>> getUserRolePowers(String userName);
}