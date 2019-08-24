package com.gundam.unicorn.utils;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author kampf
 * @date 2019/8/24 11:20
 */
public class FilePathUtils {

    /**
     * 将文件名添加4位纯数字uuid以防止文件名重复
     * @param fileName
     * @return
     */
    public static String makeFileName(String fileName){
        int hashCode = UUID.randomUUID().hashCode();
        if(hashCode < 0){
            hashCode = -hashCode;
        }

        String uuid = String.format("%04d", hashCode);
        fileName = uuid + fileName;

        return fileName;
    }

    /**
     * 制作文件储存路径，返回相对路径和绝对路径
     * @return
     */
    public static Map<String, String> makePath(String filePath){

        Map<String, String> map = new HashMap<String, String>();

        Calendar date = Calendar.getInstance();
        //根据年月日创建目录并分割
        String path = date.get(Calendar.YEAR) + File.separator
                + (date.get(Calendar.MONTH) + 1) + File.separator
                + date.get(Calendar.DAY_OF_MONTH);
        //将所有的双右斜杠替换成单左斜杠
        path = path.replaceAll("\\\\", "/");
        File up = new File(filePath + "/" + path);
        //判断目录是否存在
        if(!up.exists()){
            up.mkdirs();
        }

        map.put("relPath",path);
        map.put("absPath",filePath + "/" + path);

        return map;
    }
}
