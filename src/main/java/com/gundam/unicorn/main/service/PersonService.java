package com.gundam.unicorn.main.service;

import com.gundam.unicorn.entity.Person;
import com.gundam.unicorn.utils.Result;

import java.util.List;

/**
 * @author kampf
 * @date 2019/7/19 11:29
 */
public interface PersonService extends BaseService<Person> {

    Result login(String personName, String password);

    Result logout(String personId);
}
