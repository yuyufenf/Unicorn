package com.gundam.unicorn.main.service;

import com.gundam.unicorn.entity.Person;

import java.util.List;

/**
 * @author kampf
 * @date 2019/7/19 11:29
 */
public interface PersonService extends BaseService<Person> {

    /**
     * 进行Token验证
     * @param staffNum
     * @return
     */
    String findUserByUserName(String staffNum);
}
