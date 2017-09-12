package com.dkt.login.TV;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-10
 */
public class TV0001RequestBean {

    private String userName;
    private String password;
    //TV端：2
    private String appType;
    private String requestId;
    //用小鱼的传：xy
    private String videoType;

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
