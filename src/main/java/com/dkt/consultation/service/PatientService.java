package com.dkt.consultation.service;

import com.dkt.entity.UserPatientInfo;

/**
 * Created by GD on 2017/6/17.
 */
public interface PatientService {
    String exist(String patientMobile);
    String save(UserPatientInfo upi);
    UserPatientInfo findOne(String empiId);
}
