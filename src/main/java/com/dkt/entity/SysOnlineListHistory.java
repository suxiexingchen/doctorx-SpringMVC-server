package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by litai on 2017/6/14.
 */
@Entity
@Table(name = "sys_online_list_history")
public class SysOnlineListHistory implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "RecId", length = 36)
    private String recId;

    @Column(name = "UserId", length = 36)
    private String userId;

    @Column(name = "UserType", length = 1)
    private String userType;

    @Column(name = "NumberValue", length = 32)
    private String numberValue;

    @Column(name = "DeviceType", length = 1)
    private String deviceType;

    @Column(name = "DeviceMacAddr", length = 255)
    private String deviceMacAddr;

    @Column(name = "LastHeartBeatTime", length = 11)
    private Integer lastHeartBeatTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
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

    public String getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(String numberValue) {
        this.numberValue = numberValue;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceMacAddr() {
        return deviceMacAddr;
    }

    public void setDeviceMacAddr(String deviceMacAddr) {
        this.deviceMacAddr = deviceMacAddr;
    }

    public Integer getLastHeartBeatTime() {
        return lastHeartBeatTime;
    }

    public void setLastHeartBeatTime(Integer lastHeartBeatTime) {
        this.lastHeartBeatTime = lastHeartBeatTime;
    }
}
