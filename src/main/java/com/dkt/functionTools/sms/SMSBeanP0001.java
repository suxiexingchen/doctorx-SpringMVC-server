package com.dkt.functionTools.sms;

import java.util.List;
import java.util.Map;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-30
 */
public class SMSBeanP0001 {

    private String message="body";
    private Map<String,String> params;
    private List<String> phoneNumbers;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
