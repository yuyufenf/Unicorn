package com.gundam.unicorn.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kampf
 * @date 2019/8/21 18:38
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {

    /**
     * 权限集合
     * @return
     */
    String[] authorities() default {};

    /**
     * 角色集合
     * @return
     */
    String[] roles() default {};
}
