package com.dkt.login.TV;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-20
 */
public class TV0001ResponseBean<TV0001DoctorBean> {

    private String ticket;
    private String casUuid;
    private String hyUserId;
    private String roles;
    private String doctorPhoto;
    private String clinicId;
    private String clinicLogo;
    private String pwdAvaiCount;
    private String doctorId;
    private TV0001DoctorBean doctor;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

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

    public TV0001DoctorBean getDoctor() {
        return doctor;
    }

    public void setDoctor(TV0001DoctorBean doctor) {
        this.doctor = doctor;
    }
}
