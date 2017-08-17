package com.dkt.ceshi;

import java.util.HashMap;
import java.util.Map;
//对接口进行测试
public class TestMain {
    private String url = "http://192.168.31.78:8082/";
    private String charset = "utf-8";
    private HttpClientUtil httpClientUtil = null;

    public TestMain(){
        httpClientUtil = new HttpClientUtil();
    }

    public void test(){
        String httpOrgCreateTest = url + "login/ceshi.wjys";
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("username","zhangsan");
        createMap.put("password","123");

        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
        System.out.println("result:"+httpOrgCreateTestRtn);
    }

    public static void main(String[] args){
        TestMain main = new TestMain();
        main.test();
    }
}