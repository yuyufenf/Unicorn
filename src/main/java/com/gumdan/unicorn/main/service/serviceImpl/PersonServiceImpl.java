package com.gumdan.unicorn.main.service.serviceImpl;

import com.gumdan.unicorn.entity.Person;
import com.gumdan.unicorn.main.dao.PersonDao;
import com.gumdan.unicorn.main.service.PersonService;
import com.gumdan.unicorn.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kampf
 * @date 2019/7/19 11:30
 */
@Service
public class PersonServiceImpl implements PersonService {
    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Resource
    private PersonDao personDao;

    @Override
    public Result findPerson(Person person){

        List list = personDao.selectBySearch(person);
        //TODO 分页尚未完成
        return Result.success(list);
    }

    @Override
    public Result savePerson(Person person){
        if(person.getPersonName() == null || "".equals(person.getPersonName())){
            return Result.error(Result.SERVER_ERROR, "没有填写必要信息");
        }

        int result;

        if(person.getId() != null || "".equals(person.getId())){
            result = personDao.updateByPrimaryKey(person);
        }else {
            result = personDao.insert(person);
        }

        if(result > 0){
            return Result.success("用户保存成功");
        } else {
            return Result.error(Result.SERVER_ERROR, "用户保存失败");
        }
    }

    @Override
    public Result deletePerson(String personId){
        if(personId == null || "".equals(personId)){
            return Result.error(Result.SERVER_ERROR, "无法获取需要删除人员Id");
        }

        int result = personDao.deleteByPrimaryKey(personId);

        if (result > 0){
            return Result.success("用户删除成功");
        }
        return Result.error(Result.SERVER_ERROR, "用户删除失败");
    }
}
