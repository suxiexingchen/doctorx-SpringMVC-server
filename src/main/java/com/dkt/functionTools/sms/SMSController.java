package com.dkt.functionTools.sms;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.platform.sms.SMSClient;
import com.platform.sms.SMSException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-30
 */
public class SMSController {

    @RequestMapping("/external/startSMS")
    public CommonResponse startSMS(@RequestBody SMSBeanP0001 request){
        CommonResponse wr = new CommonResponse<>();
        List<String> list=new ArrayList<>();
                list.add("18638725710");
                list.add("18539902046");
        try {
            SMSClient.getInstance().init()
                    .withMessage(request.getMessage())
                    .withParams(request.getParams())
                    .withReceiver(request.getPhoneNumbers())
                    .send();
        } catch (SMSException e) {
            e.printStackTrace();
            wr.setStatus(SysConst.STATUS_ERROR);
        }

        return null;
    }
}
