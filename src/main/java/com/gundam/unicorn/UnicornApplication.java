package com.gundam.unicorn;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动主方法
 * @author kampf
 * @date 2019/08/22 11:44
 */
@SpringBootApplication
@EnableEncryptableProperties
public class UnicornApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnicornApplication.class, args);
    }

}
