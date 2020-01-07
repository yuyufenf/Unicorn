package com.gundam.unicorn.main.service.serviceImpl;

import com.gundam.unicorn.main.dao.BaseDao;
import com.gundam.unicorn.main.service.BaseService;
import com.gundam.unicorn.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通用实现类封装
 * @author kampf
 * @date 2019/8/16 19:42
 */
@Slf4j
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    private static final String INSERT = "保存";
    private static final String FETCH = "更新";

    @Resource
    BaseDao<T> baseDao;

    @Override
    public Result add(T t) {
        return storage(t, INSERT);
    }

    @Override
    public Result update(T t) {
        return storage(t, FETCH);
    }

    @Override
    public Result delete(Long id) {
        int result = baseDao.delete(id);
        if(result > 0){
            return Result.success(null, 0, "删除成功！");
        }
        return Result.error(Result.SERVER_ERROR, "删除失败！");
    }

    @Override
    public Result get(int page, int pageNum) {
        try{
            List<T> result = baseDao.get(page * pageNum, pageNum);
            int num = baseDao.selectCount();
            return Result.success(result, num, "数据获取成功");
        }catch(Exception e){
            log.error("获取失败报错信息:[{}]", e.getMessage(), e);
            return Result.error(Result.SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public Result findById(Long id) {
        try{
            T result = baseDao.findById(id);
            return Result.success(result, 0, "数据获取成功");
        }catch(Exception e){
            log.error("获取失败,报错信息:[{}]", e.getMessage(), e);
            return Result.error(Result.SERVER_ERROR, e.getMessage());
        }
    }

    //TODO 考虑是否和get合用一个dao方法
    @Override
    public Result search(T t) {
        List<T> result = baseDao.selectBySearch(t);
        return Result.success(result, 0, "OK!");
    }

    /**
     * 存储通用方法
     * @param t
     * @param type
     * @return
     */
    private Result storage(T t, String type){
        int result = 0;

        try {
            if(INSERT.equals(type)){
                result = baseDao.add(t);
            } else {
                result = baseDao.modify(t);
            }

            //返回储存状态
            if (result > 0){
                return Result.success(null, 0,type + "成功");
            } else {
                return Result.error(Result.SERVER_ERROR, type + "数据时失败");
            }
        } catch (Exception e){
            log.error(type + "失败,报错信息:[{}]", e.getMessage(), e);
            return Result.error(Result.SERVER_ERROR, e.getMessage());
        }

    }
}
