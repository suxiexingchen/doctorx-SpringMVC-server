package com.dkt.consultation.dao;

import com.dkt.entity.UserPatientInfo;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
public interface PatientDao {
    List<UserPatientInfo> findByMobile(String mobile);
    String saveOne(UserPatientInfo userPatientInfo);
    UserPatientInfo findOne(String empiId);
}
