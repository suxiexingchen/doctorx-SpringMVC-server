package com.dkt.webhospital;



import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @create 2017-08-16
 */
public class DepartmentBean<T> {

    private String departmentId;
    private String departmentName;
    private List<T> doctorList
            = new ArrayList<>() ;

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

    public List<T> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<T> doctorList) {
        this.doctorList = doctorList;
    }
}
