package com.platform.tool;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName：Tools
 * Description：通用方法实现
 */
public class Tools {

    private static Logger log4j = LoggerFactory.getLogger(Tools.class);
    private static DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");


    /**
     * 获取字符串MD5
     *
     * @param str
     * @return
     */
    public static String getStringMD5(String str) {

        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * 返回UUID
     *
     * @return
     */
    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Integer getCurUnixTime(){

        Long time = System.currentTimeMillis()/1000;

        return Integer.valueOf(String.valueOf(time));

    }

    public static Integer getUnixTime(Date date) {
        Long time = date.getTime() / 1000;
        return Integer.valueOf(String.valueOf(time));
    }

    public static Date parser(String dTime) {
        try {
            return formatter.parse(dTime);
        } catch (ParseException e) {
            log4j.error("{} 解析异常，使用当前时间", dTime);
            return new Date();
        }
    }

    public static boolean isListNotNull(List list){

        if (null!=list&&list.size()>0){
            return true;
        }else{
            return false;
        }

    }


}
