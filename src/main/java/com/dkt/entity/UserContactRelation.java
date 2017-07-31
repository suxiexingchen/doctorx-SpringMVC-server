package com.dkt.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 好友关系表.
 *
 * Created by GD on 2017/6/14.
 */
@Entity
@Table(name = "user_contact_relation")
public class UserContactRelation implements Serializable {

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id", length = 11)
    private Integer id;

    /**
     * 当前用户ID.
     */
    @Column(name = "UserId", length = 36)
    private String userId;

    /**
     * 当前用户类型 1-医生 2-患者.
     */
    @Column(name = "UserType", length = 1)
    private String userType;

    /**
     * 好友ID.
     */
    @Column(name = "ContactUserId", length = 36)
    private String contactUserId;

    /**
     * 好友用户类型 1-医生 2-患者.
     */
    @Column(name = "ContactUserType", length = 1)
    private String contactUserType;

    /**
     * 好友建立时间.
     */
    @Column(name = "InputTime", length = 11)
    private Integer inputTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getInputTime() {
        return inputTime;
    }

    public void setInputTime(Integer inputTime) {
        this.inputTime = inputTime;
    }
}
