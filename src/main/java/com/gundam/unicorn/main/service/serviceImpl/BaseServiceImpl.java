package com.gundam.unicorn.main.service.serviceImpl;

import com.gundam.unicorn.main.dao.BaseDao;
import com.gundam.unicorn.main.service.BaseService;
import com.gundam.unicorn.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通用实现类封装
 * @author kampf
 * @date 2019/8/16 19:42
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    BaseDao baseDao;

    @Override
    public Result add(T t) {
        return null;
    }

    @Override
    public Result update(T t) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public Result get() {
        return null;
    }

    @Override
    public Result findById(String id) {
        return null;
    }

    @Override
    public Result findNumById(String value) {
        return null;
    }
}
