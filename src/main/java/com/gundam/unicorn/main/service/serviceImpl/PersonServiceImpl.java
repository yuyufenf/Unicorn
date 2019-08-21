package com.gundam.unicorn.main.service.serviceImpl;

import com.gundam.unicorn.entity.Person;
import com.gundam.unicorn.main.dao.PersonDao;
import com.gundam.unicorn.main.service.PersonService;
import com.gundam.unicorn.utils.Result;
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
@Service
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Resource
    private PersonDao personDao;


    /**
     * 进行Token验证
     */
    @Override
    public String findUserByUserName(String staffNum) {
        if (staffNum != null && !("").equals(staffNum)) {
            return personDao.findUserByUserName(staffNum);
        }
        return null;
    }

    /**
     * 获取用户角色
     */
    @Override
    public String getUserRole(String staffNum) {
        if (staffNum != null && !("").equals(staffNum)) {
            return personDao.getUserRole(staffNum);
        }
        return null;
    }

    /**
     * 获取用户拥有的权限
     */
    @Override
    public List< String> getUserRolePowers(String staffNum) {
        if (staffNum != null && !("").equals(staffNum)) {
            List<Map<String, String>> powers = personDao.getUserRolePowers(staffNum);
            List<String> powerList = new ArrayList<>();
            for (Map<String, String> power : powers){
                String powerName = power.get("pname");
                String powerLevel = power.get("plevel");
                if (!("1").equals(powerLevel)){
                    powerList.add(powerName);
                }
            }
            return powerList;
        }
        return null;
    }
}
