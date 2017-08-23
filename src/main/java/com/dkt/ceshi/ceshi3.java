package com.dkt.ceshi;

import com.platform.tool.Tools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-18
 */
public class ceshi3 {
    public static void main(String[] args) throws ParseException {
        /*SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date time=new Date();
        String times=timeFormat.format(time);*/

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeStart=sdf.parse("2011-09-20 12:30:45").getTime();
        System.out.println(timeStart);
        Date date = new Date(timeStart);
        System.out.println(sdf.format(date));

    }
}
