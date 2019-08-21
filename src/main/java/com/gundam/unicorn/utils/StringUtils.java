package com.gundam.unicorn.utils;

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

    /**
     *
     * @param object
     * @param target
     * @return
     */
    public static boolean containArr(String[] object, String[] target) {
        boolean flag = false;
        for (int i = 0; i < target.length; i++) {
            System.out.println(target[i]);
            for (int j = 0; j < object.length; j++) {
                System.out.println(object[j]);
                if (target[i].equals(object[j])) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }
}
