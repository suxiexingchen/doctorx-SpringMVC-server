package com.dkt.ceshi;

import com.dkt.common.sendpost.*;
import com.google.gson.Gson;

public class ceshi2 {
    public static void main(String[] args) {

        String clinicId="13800000001";

        SendResponse01 response=new SendResponse01();
        response.setType(SendConstant.TYPE_ZERO);

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setClientId(clinicId);
        messageResponse.setGroupId("0");

        ContentResponse contentResponse=new ContentResponse();
        contentResponse.setPushTitle("预约申请");
        contentResponse.setPushMessage("预约申请提交成功！");

        messageResponse.setContent(contentResponse);
        response.setMessage(messageResponse);


        Gson gson=new Gson();
        String  responseJson = gson.toJson(response);
        System.out.println(responseJson);

        SendPost sendPost=new SendPost();
        sendPost.HttpSendPost(responseJson);
    }
}
