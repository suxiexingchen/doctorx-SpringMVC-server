package com.dkt.friends;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by litai on 2017/6/19.
 */
public class RequestBeanP10016 {

    private String userId;

    private String contactsId;

    @JsonProperty
    private boolean isAgree = false;

    private String operationRemark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public boolean isAgree() {
        return isAgree;
    }

    public void setAgree(boolean agree) {
        isAgree = agree;
    }

    public String getOperationRemark() {
        return operationRemark;
    }

    public void setOperationRemark(String operationRemark) {
        this.operationRemark = operationRemark;
    }
}
