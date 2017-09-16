package com.dkt.doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
public class ResponseDepartmentD0001<T> {
    /**
     * 科室ID, 主键.
     */
    private String departmentId;

    /**
     * 机构ID.
     */
    private String clinicId;

    /**
     * 科室名称.
     */
    private String departmentName;

    /**
     * 科室介绍.
     */
    private String departmentIntroduce;

    /**
     * 录入时间时间戳.
     */
    private Integer inputTime;

    /**
     * 录入操作员ID.
     */
    private String inputOperId;

    /**
     *医生
     */
    private List<T> doctorList
            = new ArrayList<>() ;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentIntroduce() {
        return departmentIntroduce;
    }

    public void setDepartmentIntroduce(String departmentIntroduce) {
        this.departmentIntroduce = departmentIntroduce;
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

    public List<T> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<T> doctorList) {
        this.doctorList = doctorList;
    }



}
