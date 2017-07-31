package com.dkt.friends;

/**
 * Created by litai on 2017/6/18.
 */
public class RequestBeanP10014 {

    private String userId;
    private String contactUserId;
    private String applyRemark;
    private String userType = "1";
    private String contactUserType = "1";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactUserId() {
        return contactUserId;
    }

    public void setContactUserId(String contactUserId) {
        this.contactUserId = contactUserId;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getContactUserType() {
        return contactUserType;
    }

    public void setContactUserType(String contactUserType) {
        this.contactUserType = contactUserType;
    }
}
