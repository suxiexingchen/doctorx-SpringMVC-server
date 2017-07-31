package com.dkt.doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linkd on 2017/6/28.
 */
public class DoctorListResult<T> {
    private List<T> doctorList
            = new ArrayList<>();

    public List<T> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<T> doctorList) {
        this.doctorList = doctorList;
    }
}
