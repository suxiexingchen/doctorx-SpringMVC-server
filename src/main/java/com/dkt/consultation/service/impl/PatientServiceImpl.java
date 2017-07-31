package com.dkt.consultation.service.impl;

import com.dkt.consultation.dao.PatientDao;
import com.dkt.consultation.service.PatientService;
import com.dkt.entity.UserPatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public String exist(String patientMobile) {
        List<UserPatientInfo> upList = patientDao.findByMobile(patientMobile);
        if (!CollectionUtils.isEmpty(upList)) {
            return upList.get(0).getEmpiId();
        }
        return null;
    }

    @Override
    public String save(UserPatientInfo upi) {
        return patientDao.saveOne(upi);
    }

    @Override
    public UserPatientInfo findOne(String empiId) {
        return patientDao.findOne(empiId);
    }
}
