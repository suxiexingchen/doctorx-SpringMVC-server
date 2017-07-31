package com.dkt.org;

import javax.persistence.Column;

/**
 * Created by litai on 2017/6/17.
 */
public class OrgListBean {

    private String clinicId;

    /**
     * 机构名称.
     */
    private String clinicName;

    /**
     * 机构类型 1-综合医院 2-诊所.
     */
    private String clinicLevel;

    /**
     * 机构图片URL.
     */
    private String clinicIcon;

    /**
     * 机构介绍.
     */
    private String clinicIntroduce;

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
}
