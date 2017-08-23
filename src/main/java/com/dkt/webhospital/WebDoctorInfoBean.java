package com.dkt.webhospital;

/**
 * @author 馒头花卷儿
 * @create 2017-08-16
 */
public class WebDoctorInfoBean {
    private String doctorId;

    /**
     * 医生姓名.
     */
    private String doctorName;

    /**
     * 性别：1-男，2-女，3-保密.
     */
    private String gender;

    /**
     * 医生头像URL.
     */
    private String doctorHeadIcon;

    /**
     * 医生职称.
     */
    private String doctorPostName;

    /**
     * 医生职务.
     */
    private String doctorTechpostName;


    /**
     * 系统内医生类别 0-值班医生，1-专家,2-网络医生.
     */
    private String doctorWay;
    /**
     * 医生介绍
     */
    private String doctorArea;

    /**
     * 医生在线状态，0-不在线，1-在线
     * @return
     */
    private String onlinestatus;

    /**
     * 医生TVN号（盒子号）
     */
    private String tvn;

    public String getOnlinestatus() {
        return onlinestatus;
    }

    public void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    public String getTvn() {
        return tvn;
    }

    public void setTvn(String tvn) {
        this.tvn = tvn;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDoctorHeadIcon() {
        return doctorHeadIcon;
    }

    public void setDoctorHeadIcon(String doctorHeadIcon) {
        this.doctorHeadIcon = doctorHeadIcon;
    }

    public String getDoctorPostName() {
        return doctorPostName;
    }

    public void setDoctorPostName(String doctorPostName) {
        this.doctorPostName = doctorPostName;
    }

    public String getDoctorTechpostName() {
        return doctorTechpostName;
    }

    public void setDoctorTechpostName(String doctorTechpostName) {
        this.doctorTechpostName = doctorTechpostName;
    }

    public String getDoctorWay() {
        return doctorWay;
    }

    public void setDoctorWay(String doctorWay) {
        this.doctorWay = doctorWay;
    }

    public String getDoctorArea() {
        return doctorArea;
    }

    public void setDoctorArea(String doctorArea) {
        this.doctorArea = doctorArea;
    }
}
