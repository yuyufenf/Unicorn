package com.gundam.unicorn.utils.annotation;

import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author kampf
 * @date 2019/8/19 19:31
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldNotBlank {

    /**
     * 设置回传类名称，并设置默认值
     * @return
     */
    String name() default "value";

    /**
     * 设置回传消息接口，并设置默认值
     * @return
     */
    String message() default "属性值为null或空字符串";

    /**
     * 判断是否启动非空判断
     * @return
     */
    boolean isNotBlank() default true;

    /**
     * 必要继承接口
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 必要继承接口
     * @return
     */
    Class<? extends Payload>[] payload() default {};
}
