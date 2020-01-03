package com.gundam.unicorn.main.service.serviceImpl;

import com.gundam.unicorn.entity.Person;
import com.gundam.unicorn.main.dao.PersonDao;
import com.gundam.unicorn.main.service.PersonService;
import com.gundam.unicorn.utils.Result;
import com.gundam.unicorn.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kampf
 * @date 2019/7/19 11:30
 */
@Slf4j
@Service
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {

    @Resource
    private PersonDao personDao;


    @Override
    public Result login(String personName, String password) {

        try {
            Person person = personDao.findUserByUserName(personName);

            if(StringUtils.isBlank(person)){
                return Result.error(Result.REQUEST_ERROR,"当前用户不存在");
            }


        } catch (Exception e){

        }

        return null;
    }

    @Override
    public Result logout(String personId) {
        return null;
    }
}
