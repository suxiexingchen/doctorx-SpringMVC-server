package com.dkt.common.sendpost;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class SendPost {

    private static final Logger LOG = LoggerFactory.getLogger(SendPost.class);


    public void HttpSendPost(String jsonStr){

        String baseUrl=SendConstant.SEND_URL;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        //以请求的url地址创建httppost请求对象
        HttpPost httppost=new HttpPost(baseUrl);
        httppost.addHeader(HTTP.CONTENT_TYPE, "application/json");


        //HttpEntity 封装消息的对象 可以发送和接受服务器的消息  可以通过客户端请求或者是服务器端的响应获取其对象
        //HttpEntity entity=new UrlEncodedFormEntity(listPair);//创建httpEntity对象

        StringEntity stringEntity = new StringEntity(jsonStr,"utf-8");

        stringEntity.setContentType("text/json");

        stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));



        httppost.setEntity(stringEntity);//将发送消息的载体对象封装到httppost对象中


        HttpResponse response= null;
        try {
                response = httpclient.execute(httppost);

            int responseCode=response.getStatusLine().getStatusCode();
            if(responseCode==200){
                LOG.debug("推送消息成功");
                //得到服务器响应的消息对象
                HttpEntity httpentity=response.getEntity();
                LOG.debug("服务器响应结果是:"+ EntityUtils.toString(httpentity, "utf-8"));
            }else{
                LOG.debug("推送消息失败");
            }
        } catch (IOException e) {
            //推送，POST请求失败
            LOG.debug("推送消息失败");
            e.printStackTrace();
        }
    }


    }


