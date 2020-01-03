package com.gundam.unicorn.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gundam.unicorn.entity.Person;
import com.gundam.unicorn.entity.User;

import java.util.Date;

/**
 * @author kampf
 * @date 2020/1/3 下午2:47
 */
public class TokenUtils {

    public static String getToken(User user) {
        long currentTime = System.currentTimeMillis();
        Date loginTime = new Date(currentTime);
        Date validTime = new Date(currentTime + 2 * 60 * 60 * 1000);

        return JWT.create().withAudience(user.getUserName())
                .withIssuedAt(loginTime).withExpiresAt(validTime)
                .sign(Algorithm.HMAC256(user.getUserPassword()));
    }
}
