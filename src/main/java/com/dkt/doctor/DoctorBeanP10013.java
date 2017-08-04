package com.dkt.doctor;

import javax.persistence.Column;

/**
 * Created by litai on 2017/6/17.
 */
public class DoctorBeanP10013 {

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

    private String doctorMobile;

    /**
     * 医生介绍.
     */
    private String doctorArea;


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

    public void setDoctorTechpostName(String doctorTechpostName) {
        this.doctorTechpostName = doctorTechpostName;
    }

}


