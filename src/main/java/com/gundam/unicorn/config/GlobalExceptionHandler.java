package com.gundam.unicorn.config;

import com.gundam.unicorn.utils.exception.IsNullException;
import com.gundam.unicorn.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 公用异常抓取类，用于后期自定义标签给页面返回
 * @author kampf
 * @date 2019/8/16 19:39
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IsNullException.class)
    public Result returnAnno(IsNullException e){
        return Result.error(Result.SERVER_ERROR, e.getMessage());
    }
}
