package com.dkt.online;

/**
 * Created by litai on 2017/6/21.
 */
public class RequestBeanP10019 {

    private String userId;
    private String numberValue;
    private Integer deviceType = 2;
    private String deviceMacAddr;
    private String clinicId;
    private String clinicName;
    private String recId;
    private Integer lastHeartBeat;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(String numberValue) {
        this.numberValue = numberValue;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceMacAddr() {
        return deviceMacAddr;
    }

    public void setDeviceMacAddr(String deviceMacAddr) {
        this.deviceMacAddr = deviceMacAddr;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public Integer getLastHeartBeat() {
        return lastHeartBeat;
    }

    public void setLastHeartBeat(Integer lastHeartBeat) {
        this.lastHeartBeat = lastHeartBeat;
    }
}
