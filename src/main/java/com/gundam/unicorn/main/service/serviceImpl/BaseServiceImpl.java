package com.gundam.unicorn.main.service.serviceImpl;

import com.gundam.unicorn.main.dao.BaseDao;
import com.gundam.unicorn.main.service.BaseService;
import com.gundam.unicorn.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        int result = baseDao.add(t);
        if(result > 0){
            return Result.success(null, "存储成功！");
        }
        return Result.error(Result.SERVER_ERROR, "储存失败！");
    }

    @Override
    public Result update(T t) {
        int result = baseDao.modify(t);
        if(result > 0){
            return Result.success(null, "更新成功！");
        }
        return Result.error(Result.SERVER_ERROR, "更新失败！");
    }

    @Override
    public Result delete(String id) {
        int result = baseDao.delete(id);
        if(result > 0){
            return Result.success(null, "删除成功！");
        }
        return Result.error(Result.SERVER_ERROR, "删除失败！");
    }

    @Override
    public Result get() {
        List list = baseDao.get();
        return Result.success(list, "OK!");
    }

    @Override
    public Result findById(String id) {
        Object object = baseDao.findById(id);
        return Result.success(object, "OK!");
    }

    @Override
    public Result findNumById(String value) {
        int result = baseDao.findNumById(value);
        return Result.success(result, "OK!");
    }
}
