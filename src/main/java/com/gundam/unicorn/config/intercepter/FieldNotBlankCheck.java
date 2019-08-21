package com.gundam.unicorn.config.intercepter;

import com.gundam.unicorn.utils.annotation.FieldNotBlank;
import com.gundam.unicorn.utils.exception.IsNullException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 用于在从前端接受到对象时获取对象中添加了标签的属性进行操作
 * @author kampf
 * @date 2019/8/19 20:06
 */
public class FieldNotBlankCheck implements ConstraintValidator<FieldNotBlank, String> {

    /**
     * 用于传递标签中的是否启动非空判断
     */
    boolean flag = false;
    /**
     * 用于传递标签中的name和message以组成返回页面信息的一部分
     */
    String  msg = new String();

    /**
     * 初始化
     * @param fieldNotBlank
     */
    @Override
    public void initialize(FieldNotBlank fieldNotBlank) {
        /**
         * 从标签中获取信息
         */
        flag = fieldNotBlank.isNotBlank();
        msg = fieldNotBlank.name()
                + fieldNotBlank.message();
    }

    /**
     * 对加了标签的属性值进行操作
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        //判断属性值是否为空
        if(flag) {
            if (value.equals("") || value == null) {
                //这里我们创建一个我们之前设定的异常好让抓取类抓住
                throw new IsNullException(msg);
            } else {
                //没有问题则让他通过
                return true;
            }
        }
        //如果isNotBlank设置为false则判断不做非空校验
        return true;
    }
}
