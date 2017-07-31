package com.dkt.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by litai on 2017/6/17.
 */
public class RequestBeanP10012 {

    private String clinicId;
    @JsonProperty
    private Boolean allDoctor = true;
    private String deptId;

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public Boolean getAllDoctor() {
        return allDoctor;
    }

    public void setAllDoctor(Boolean allDoctor) {
        this.allDoctor = allDoctor;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
