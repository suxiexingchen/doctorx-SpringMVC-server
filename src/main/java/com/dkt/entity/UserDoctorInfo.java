package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 医生表.
 *
 * Created by GD on 2017/6/14.
 */
@Entity
@Table(name = "user_doctor_info")
public class UserDoctorInfo implements Serializable {

    /**
     * 医生ID, 主键.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "DoctorId", length = 36)
    private String doctorId;

    /**
     * 医生姓名.
     */
    @Column(name = "DoctorName", length = 32)
    private String doctorName;

    /**
     * 性别：1-男，2-女，3-保密.
     */
    @Column(name = "Gender", length = 1)
    private String gender;

    /**
     * 医生头像URL.
     */
    @Column(name = "DoctorHeadIcon")
    private String doctorHeadIcon;

    /**
     * 医生职称.
     */
    @Column(name = "DoctorPostName", length = 32)
    private String doctorPostName;

    /**
     * 医生职务.
     */
    @Column(name = "DoctorTechpostName", length = 32)
    private String doctorTechpostName;

    /**
     * 医生联系方式（手机号）.
     */
    @Column(name = "DoctorMobile", length = 32)
    private String doctorMobile;

    /**
     * 医生介绍.
     */
    @Column(name = "DoctorArea", columnDefinition = "TEXT")
    private String doctorArea;

    /**
     * 系统内医生类别 2-值班医生，1-专家.
     */
    @Column(name = "DoctorWay", length = 1, nullable = false)
    private String doctorWay;

    /**
     * 录入时间时间戳.
     */
    @Column(name = "InputTime", length = 11)
    private Integer inputTime;

    /**
     * 录入操作员ID.
     */
    @Column(name = "InputOperId", length = 36)
    private String inputOperId;

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

    public Integer getInputTime() {
        return inputTime;
    }

    public void setInputTime(Integer inputTime) {
        this.inputTime = inputTime;
    }

    public String getInputOperId() {
        return inputOperId;
    }

    public void setInputOperId(String inputOperId) {
        this.inputOperId = inputOperId;
    }
}
