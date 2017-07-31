package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 医院表.
 *
 * Created by GD on 2017/6/14.
 */
@Entity
@Table(name = "user_org_info")
public class UserOrgInfo implements Serializable {

    /**
     * 机构ID, 主键.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ClinicId", length = 36)
    private String clinicId;

    /**
     * 机构名称.
     */
    @Column(name = "ClinicName")
    private String clinicName;

    /**
     * 机构类型 1-综合医院 2-诊所.
     */
    @Column(name = "ClinicLevel", length = 1)
    private String clinicLevel;

    /**
     * 机构图片URL.
     */
    @Column(name = "ClinicIcon")
    private String clinicIcon;

    /**
     * 机构介绍.
     */
    @Column(name = "ClinicIntroduce", columnDefinition = "TEXT")
    private String clinicIntroduce;

    /**
     * 录入时间.
     */
    @Column(name = "InputTime", length = 11)
    private Integer inputTime;

    /**
     * 录入操作员ID.
     */
    @Column(name = "InputOperId")
    private String inputOperId;

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

    public String getClinicLevel() {
        return clinicLevel;
    }

    public void setClinicLevel(String clinicLevel) {
        this.clinicLevel = clinicLevel;
    }

    public String getClinicIcon() {
        return clinicIcon;
    }

    public void setClinicIcon(String clinicIcon) {
        this.clinicIcon = clinicIcon;
    }

    public String getClinicIntroduce() {
        return clinicIntroduce;
    }

    public void setClinicIntroduce(String clinicIntroduce) {
        this.clinicIntroduce = clinicIntroduce;
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
