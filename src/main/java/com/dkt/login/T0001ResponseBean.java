package com.dkt.login;

/**
 * Created by litai on 2017/6/14.
 */
public class T0001ResponseBean {

    private String ticket;
    private String casUuid;
    private String hyUserId;
    private String roles;
    private String doctorId;
    private String doctorPhoto;
    private String clinicId;
    private String clinicLogo;
    private String pwdAvaiCount;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicLogo() {
        return clinicLogo;
    }

    public void setClinicLogo(String clinicLogo) {
        this.clinicLogo = clinicLogo;
    }

    public String getPwdAvaiCount() {
        return pwdAvaiCount;
    }

    public void setPwdAvaiCount(String pwdAvaiCount) {
        this.pwdAvaiCount = pwdAvaiCount;
    }
}
