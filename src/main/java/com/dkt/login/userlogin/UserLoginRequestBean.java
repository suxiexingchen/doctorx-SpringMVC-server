package com.dkt.login.userlogin;

/**
 * @author 馒头花卷儿
 * @Description:qing
 * @create 2017-09-18
 */
public class UserLoginRequestBean {

    private String userName;
    private String password;
    //用小鱼的传：xy
    private String videoType;

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

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }
}
