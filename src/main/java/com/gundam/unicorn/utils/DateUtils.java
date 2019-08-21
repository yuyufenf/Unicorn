package com.gundam.unicorn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author kampf
 * @date 2019/7/18 10:55
 */
public class DateUtils {

    /**
     * 时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String TYPEONE = "1";
    /**
     * 时间格式 yyyy-MM-dd
     */
    public static final String TYPETWO = "2";
    /**
     * 时间格式 yyyy年MM月dd日
     */
    public static final String TYPETHREE = "3";
    /**
     * 时间格式 yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final String TYPEFOUR = "4";
    /**
     * DIY时间格式
     */
    public static final String TYPEDIY = "5";

    /**
     * 生成时间格式类
     * @param dateType
     * @return
     */
    private static SimpleDateFormat  dateFormat(String dateType, String diyType){
        SimpleDateFormat sdf;
        switch (dateType){
            case "1" :
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case "2" :
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case "3" :
                sdf = new SimpleDateFormat("yyyy年MM月dd日");
                break;
            case "4" :
                sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            default:
                sdf = new SimpleDateFormat(diyType);
        }

        return sdf;
    }

    /**
     * 字符串转日期
     * @param time 需要转换的字符串时间
     * @param dateType 转换时间类型，用本类下的枚举
     * @param diyType 如果没有匹配的时间类型可以自行添加类型
     * @return
     */
    public static Date string2Date(String time, String dateType, String diyType){

        SimpleDateFormat sdf = dateFormat(dateType, diyType);

        try {
            Date date = sdf.parse(time);

            return date;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 日期转字符串
     * @param date 需要转换的时间格式日期
     * @param dateType 转换时间类型，用本类下的枚举
     * @param diyType 如果没有匹配的时间类型可以自行添加类型
     * @return
     */
    public static String date2String(Date date, String dateType, String diyType){
        SimpleDateFormat sdf = dateFormat(dateType, diyType);
        String time = sdf.format(date);
        return time;
    }
}
