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
}