package com.dkt.login.TV;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-20
 */
public class TV0001DoctorBean {

    /**
     * 医生ID, 主键.
     */
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
     * 医生联系方式（手机号）.
     */
    private String doctorMobile;

    /**
     * 医生介绍.
     */
    private String doctorArea;

    /**
     * 系统内医生类别 2-值班医生，1-专家.
     */
    private String doctorWay;

    /**
     * 医生在线状态，0-不在线，1-在线
     * @return
     */
    private String onlinestatus;

    /**
     * 医生TVN号（盒子号）
     */
    private String tvn;

    /**
     * 是否是家庭医生 0不是 1是
     */
    private Integer isFamilyDoctor;

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

    public String getDoctorMobile() {
        return doctorMobile;
    }

    public void setDoctorMobile(String doctorMobile) {
        this.doctorMobile = doctorMobile;
    }

    public String getDoctorArea() {
        return doctorArea;
    }

    public void setDoctorArea(String doctorArea) {
        this.doctorArea = doctorArea;
    }

    public String getDoctorWay() {
        return doctorWay;
    }

    public void setDoctorWay(String doctorWay) {
        this.doctorWay = doctorWay;
    }

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

    public Integer getIsFamilyDoctor() {
        return isFamilyDoctor;
    }

    public void setIsFamilyDoctor(Integer isFamilyDoctor) {
        this.isFamilyDoctor = isFamilyDoctor;
    }
}
