package com.platform.sms;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhuanchao on 2017/6/19.
 * 短信工具类
 *
 * 使用示例
 * try {
 *      SMSClient.getInstance().init()
 *      .withMessage("body")
 *      .withParams("customer", "刘总")
 *      .withReceiver("18638725710", "18539902046")
 *      .send();
 *  } catch (SMSException e) {
 *      e.printStackTrace();
 *  }
 *
 */
public class SMSClient {

    private static SMSClient mInstance;


    /** AccessID*/
    private String accessId = "LTAISy3b5UwvpK0o";
    /** AccessKey*/
    private String accessKey = "P76LigYYMOyZQdrFm6bGBt6JR6Hzhc";
    /** EndPoint*/
    private String endpoint = "http://1911247222330631.mns.cn-hangzhou.aliyuncs.com/";

    /** 主题 */
    private String defaultTopic = "sms.topic-cn-hangzhou";
    /** 短信签名 */
    private String sighName = "万家医视";
    /** 短信模板code */
    private String defaultSMSTemplateCode = "SMS_71235686";

    /** 云账户信息 */
    private CloudAccount account;
    /** MNS客户端 */
    private MNSClient client;
    private RawTopicMessage msg;
    private CloudTopic cloudTopic;
    /** SMS消息属性 */
    private MessageAttributes messageAttributes;
    private BatchSmsAttributes batchSmsAttributes;
    private BatchSmsAttributes.SmsReceiverParams smsReceiverParams;

    /******** FLAG *********/

    private boolean isInit = false;
    private boolean isSetMessage = false;
    private boolean isSetParams = false;
    private boolean isSetReceiver = false;


    /***********************/

    private SMSClient(){}

    public static SMSClient getInstance(){
        return mInstance == null ? new SMSClient() : mInstance;
    }

    /**
     * 初始化
     * @return
     */
    public SMSClient init(){

        messageAttributes = null;
        batchSmsAttributes = null;
        smsReceiverParams = null;

        account  = new CloudAccount(accessId, accessKey, endpoint);
        client = account.getMNSClient();
        cloudTopic = client.getTopicRef(defaultTopic);

        messageAttributes = new MessageAttributes();
        batchSmsAttributes = new BatchSmsAttributes();
        // 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName(sighName);

        // 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(defaultSMSTemplateCode);

        isInit = true;
        return this;
    }

    /**
     * 设置短信消息体(必须)
     * @param message
     * @return
     */
    public SMSClient withMessage(String message) throws SMSException {
        if(!isInit) throw new SMSException("you must call init() before setMessage");
        smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        msg = new RawTopicMessage();
        msg.setMessageBody(message);
        isSetMessage = true;
        return this;
    }

    /**
     * 设置短信主题,不设置则用默认主题
     * @param topic
     * @return
     */
    public SMSClient withTopic(String topic) throws SMSException {
        if(!isInit) throw new SMSException("you must call init() before setTopic");
        cloudTopic = client.getTopicRef(defaultTopic);
        return this;
    }

    /**
     * 设置短信模板code,不设置则用默认模板
     * @param SMSTemplateCode
     * @return
     */
    public SMSClient withTemplateCode(String SMSTemplateCode) throws SMSException {
        if(!isInit) throw new SMSException("you must call init() before setTemplateCode");
        // 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(SMSTemplateCode);
        return this;
    }

    /**
     * 填充模板参数
     * @param kv
     * @return
     * @throws SMSException
     */
    public SMSClient withParams(Map<String,String> kv) throws SMSException {
        if(!isInit) throw new SMSException("you must call init() before setParams");
        if(kv == null) return this;

        // 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        Iterator<Map.Entry<String, String >> it =  kv.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String , String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            smsReceiverParams.setParam(key,value);
        }

        isSetParams = true;
        return this;
    }

    /**
     * 填充模板参数
     * @param key
     * @param value
     * @return
     * @throws SMSException
     */
    public SMSClient withParams(String key, String value) throws SMSException {
        if(!isInit) throw new SMSException("you must call init() before setParams");
        smsReceiverParams.setParam(key,value);
        isSetParams = true;
        return this;
    }

    /**
     * 增加号码
     * @param phoneNumbers
     * @return
     */
    public SMSClient withReceiver(List<String> phoneNumbers) throws SMSException {
        if(!isInit) throw new SMSException("you must call init() before setReceiver");
        if(!isSetParams) throw new SMSException("you must call withParams() before setReceiver");
        // 添加接受短信的号码
        for(String number :phoneNumbers){
            batchSmsAttributes.addSmsReceiver(number, smsReceiverParams);
        }
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        isSetReceiver = true;
        return this;
    }

    /**
     * 发送短信
     */
    public void send() throws SMSException {
        if(!isSetMessage) throw new SMSException("you must call setMessage() before send sms");
        if(!isSetReceiver) throw new SMSException("you must call setReceiver() before send sms");

        try{
            TopicMessage ret = cloudTopic.publishMessage(msg, messageAttributes);
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
        } catch (ServiceException se) {
            System.out.println(se.getErrorCode() + se.getRequestId());
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            isSetParams = false;
            isSetReceiver = false;
            isSetMessage = false;

            messageAttributes = null;
            batchSmsAttributes = null;
            smsReceiverParams = null;
        }
    }
}
