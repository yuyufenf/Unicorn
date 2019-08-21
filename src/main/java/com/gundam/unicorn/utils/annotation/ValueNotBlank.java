package com.gundam.unicorn.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kampf
 * @date 2019/8/21 10:28
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueNotBlank {

    /**
     * 设置回传消息接口，并设置默认值
     * @return
     */
    String message() default "Params Missing";

    /**
     * 判断是否启动非空判断
     * @return
     */
    boolean notNull() default true;
}
