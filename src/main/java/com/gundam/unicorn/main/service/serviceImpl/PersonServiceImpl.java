package com.gundam.unicorn.main.service.serviceImpl;

import com.gundam.unicorn.entity.Person;
import com.gundam.unicorn.main.mapper.PersonMapper;
import com.gundam.unicorn.main.service.PersonService;
import com.gundam.unicorn.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kampf
 * @date 2019/7/19 11:30
 */
@Slf4j
@Service
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
}
