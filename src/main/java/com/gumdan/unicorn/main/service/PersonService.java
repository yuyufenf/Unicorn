package com.gumdan.unicorn.main.service;

import com.gumdan.unicorn.entity.Person;
import com.gumdan.unicorn.utils.Result;

/**
 * @author kampf
 * @date 2019/7/19 11:29
 */
public interface PersonService {

    Result findPerson(Person person);

    Result savePerson(Person person);

    Result deletePerson(String personId);
}
