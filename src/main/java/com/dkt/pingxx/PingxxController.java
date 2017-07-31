package com.dkt.pingxx;

import com.dkt.common.CommonResponse;
import com.google.gson.Gson;
import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.Charge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by liuhuanchao on 2017/7/3.
 */
@RestController
@Scope("session")
public class PingxxController {

    private static final Logger log = LoggerFactory.getLogger(PingxxController.class);

    private final String APP_ID = "app_HaH4yLOWTe94vXfn";
    private final String TEST_KEY = "sk_test_9unX54nP80yDyrLiz54ejrD4";
    private final String LIVE_KEY = "sk_live_LqjX90r5Gu5S9CeD04TyPuTG";

    @RequestMapping("/payment/getcharge")
    public String getCharge(@RequestBody PingxxRequestBean request){

        try{
            return makeCharge(request.getChannel(), request.getAmount());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 生成Charge订单
     * @param channel
     * @param amount
     * @return
     */
    private String makeCharge(String channel, int amount){
        Pingpp.apiKey = LIVE_KEY;
        Pingpp.privateKeyPath = "C://Users//linkd//Documents//rsa_private_key.pem";
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("order_no",  makeOrderNumber());
        chargeParams.put("amount", amount);//订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100）
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", APP_ID);
        chargeParams.put("app", app);
        chargeParams.put("channel",  channel);
        chargeParams.put("currency", "cny");
        chargeParams.put("client_ip",  getHostIP());
        chargeParams.put("subject",  "头牌帅熊过夜费");
        chargeParams.put("body",  "让你飞！");
        try {
            Charge charge = Charge.create(chargeParams);
            return charge.toString();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (ChannelException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String makeOrderNumber(){
        return UUID.randomUUID().toString().replace("-","");
    }

    private String getHostIP(){
        String ip = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            ip = "";
        }
        return ip;
    }

    /**
     * 查询 Charge
     *
     * 该接口根据 charge Id 查询对应的 charge 。
     * 参考文档：https://www.pingxx.com/api#api-c-inquiry
     *
     * 参考文档： https://www.pingxx.com/api#api-expanding
     * @param id
     */
    public Charge retrieve(String id) {
        Charge charge = null;
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            charge = Charge.retrieve(id, params);
            System.out.println(charge);
        } catch (PingppException e) {
            e.printStackTrace();
        }

        return charge;
    }
}
