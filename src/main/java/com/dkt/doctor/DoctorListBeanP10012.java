package com.dkt.doctor;

import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
public class DoctorListBeanP10012 {

    private String departmentId;
    private String departmentName;
    private List<DoctorBeanP10012> teleDoctorInfoList;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<DoctorBeanP10012> getTeleDoctorInfoList() {
        return teleDoctorInfoList;
    }

    public void setTeleDoctorInfoList(List<DoctorBeanP10012> teleDoctorInfoList) {
        this.teleDoctorInfoList = teleDoctorInfoList;
    }
}
