package com.dkt.doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
public class ResponseClinicC0001<T> {
    /**
     * 科室List
     */
    private List<T> departmentList
            = new ArrayList<>();

    /**
     * 机构ID, 主键.
     */
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

    /**
     * 录入时间.
     */
    private Integer inputTime;

    /**
     * 录入操作员ID.
     */
    private String inputOperId;

    /**
     * 医院LOGO
     * @return
     */
    private String logolcon;

    /**
     * 医院 所属社区ID  所属那个社区
     * @return
     */
    private Integer communityId;

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

    public String getLogolcon() {
        return logolcon;
    }

    public void setLogolcon(String logolcon) {
        this.logolcon = logolcon;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public List<T> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<T> departmentList) {
        this.departmentList = departmentList;
    }
}
