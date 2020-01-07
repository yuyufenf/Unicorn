package com.gundam.unicorn.main.service;

import com.gundam.unicorn.utils.Result;

/**
 * 通用service接口
 * @author kampf
 * @date 2019/8/16 18:56
 */
public interface BaseService<T> {

    /**
     * 添加对象方法
     * @param t
     * @return 成功信息或失败信息
     */
    Result add(T t);

    /**
     * 修改对象方法
     * @param t
     * @return 成功信息或失败信息
     */
    Result update(T t);

    /**
     * 删除对象方法
     * @param id
     * @return 成功信息或失败信息
     */
    Result delete(Long id);

    /**
     * 获取列表方法（后期添加page）
     * @return 所有对象组成的list集合
     */
    Result get(int page, int pageNum);

    /**
     * 根据id获得对象方法
     * @param id
     * @return 查找到的单一对象或空
     */
    Result findById(Long id);

    /**
     * 根据字段查询此字段存在于多少条数据中
     * @param t
     * @return 返回数据条目
     */
    Result search(T t);
}
