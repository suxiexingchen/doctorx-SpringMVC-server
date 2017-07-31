package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by litai on 2017/6/14.
 */
@Entity
@Table(name = "user_contact_apply")
public class UserContactApply implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ContactsId", length = 36)
    private String contactsId;

    @Column(name = "UserId", length = 36)
    private String userId;

    @Column(name = "UserType", length = 1)
    private String userType;

    @Column(name = "ContactUserId", length = 36)
    private String contactUserId;

    @Column(name = "ContactUserType", length = 1)
    private String contactUserType;

    @Column(name = "ApplyRemark", length = 255)
    private String applyRemark;

    @Column(name = "ApplyDate", length = 11)
    private Integer applyDate;

    //好友是否同意 0-未处理 1-同意 2-拒绝
    @Column(name = "IsAgree", length = 1)
    private String isAgree;

    @Column(name = "OperationRemark", length = 255)
    private String operationRemark;

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getContactUserId() {
        return contactUserId;
    }

    public void setContactUserId(String contactUserId) {
        this.contactUserId = contactUserId;
    }

    public String getContactUserType() {
        return contactUserType;
    }

    public void setContactUserType(String contactUserType) {
        this.contactUserType = contactUserType;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public Integer getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Integer applyDate) {
        this.applyDate = applyDate;
    }

    public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree;
    }

    public String getOperationRemark() {
        return operationRemark;
    }

    public void setOperationRemark(String operationRemark) {
        this.operationRemark = operationRemark;
    }
}
