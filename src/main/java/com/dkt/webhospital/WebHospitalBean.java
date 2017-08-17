package com.dkt.webhospital;

import java.util.ArrayList;
import java.util.List;

/**
 *医院
 * @author 馒头花卷儿
 * @create 2017-08-16
 */
public class WebHospitalBean<T> {


    private String clinicName;
    private String clinicId;
    private String clinicIcon;
    private String clinicIntroduce;
    private List<T> departmentList
            = new ArrayList<>();

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
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

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public List<T> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<T> departmentList) {
        this.departmentList = departmentList;
    }
}
