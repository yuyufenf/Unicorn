package com.gundam.unicorn.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kampf
 * @date 2019/8/16 19:43
 */
@Component
@Mapper
public interface BaseMapper<T> {

    /**
     * 添加接口
     * @param t
     * @return
     */
    int add(T t);

    /**
     * 修改接口
     * @param t
     * @return
     */
    int modify(T t);

    /**
     * 删除接口
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询所有接口（后面考虑再改一下和page整合）
     * @return
     */
    List<T> get(int page, int pageNum);

    int selectCount();

    /**
     * 根据id查找对象接口
     * @param id
     * @return
     */
    T findById(Long id);


    /**
     * 根据查询条件筛选数据(再考虑)
     * @param t
     * @return
     */
    List<T> selectBySearch(T t);
}
