package com.gumdan.unicorn.utils;

import java.util.UUID;

/**
 * @author kampf
 * @date 2019/7/18 14:18
 */
public class StringUtils {

    /**
     * 空校验
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 空校验
     * @param cs
     * @return
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /**
     * 创建一个16位纯数字UUID
     * @return
     */
    public static String mkUUID(){
        int random =(int)(Math.random()*9 + 1);
        String valueOf = String.valueOf(random);
        int hashCode = UUID.randomUUID().toString().hashCode();

        if(hashCode < 0){
            hashCode = -hashCode;
        }

        String uuid = valueOf + String.format("%015d", hashCode);

        return uuid;
    }

    /**
     * 判断是否为数字字符
     * @param charSequence
     * @return
     */
    public static boolean isNumeric(CharSequence charSequence){
        if(isEmpty(charSequence)){
            return false;
        } else {
            int size = charSequence.length();

            for(int i = 0; i <= size; ++i){
                if(!Character.isDigit(charSequence.charAt(i))){
                    return false;
                }
            }
        }

        return true;
    }
}
