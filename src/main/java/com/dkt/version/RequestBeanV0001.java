package com.dkt.version;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-22
 */
public class RequestBeanV0001 {
    //版本编号
    private Integer code;
    //设备类型 1:tv盒子 2:ios 3:安卓手机
    private Integer devType;
    //渠道 henancatv(河南广电)
    private String channel;
    //所属app类型 1 医生端 2 大众版
    private Integer app;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getApp() {
        return app;
    }

    public void setApp(Integer app) {
        this.app = app;
    }
}
