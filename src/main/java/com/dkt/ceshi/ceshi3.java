package com.dkt.ceshi;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-18
 */
public class ceshi3 {
    public static void main(String[] args) {
        long time = new Date().getTime();
        System.out.println(time);

        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date dt = new Date(time);
        String sDateTime = sdf.format(dt);
        System.out.println(sDateTime);
    }
}
