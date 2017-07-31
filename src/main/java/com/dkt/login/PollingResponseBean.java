package com.dkt.login;

/**
 * Created by linkd on 2017/7/11.
 */
public class PollingResponseBean {

    private String doctorPhoto;
    private String ticket;
    private String doctorId;
    private String roles;
    private String casUuid;
    private String hyUserId;

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCasUuid() {
        return casUuid;
    }

    public void setCasUuid(String casUuid) {
        this.casUuid = casUuid;
    }

    public String getHyUserId() {
        return hyUserId;
    }

    public void setHyUserId(String hyUserId) {
        this.hyUserId = hyUserId;
    }
}
