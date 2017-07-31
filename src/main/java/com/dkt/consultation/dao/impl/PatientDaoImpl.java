package com.dkt.consultation.dao.impl;

import com.dkt.consultation.dao.PatientDao;
import com.dkt.entity.UserPatientInfo;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
@Repository
public class PatientDaoImpl extends BaseDao<UserPatientInfo> implements PatientDao {
    @Override
    public List<UserPatientInfo> findByMobile(String mobile) {
        StringBuilder hql = new StringBuilder(" from UserPatientInfo where patientMobile=? ");
        return getListByHQL(hql.toString(), null, new String[]{mobile});
    }

    @Override
    public String saveOne(UserPatientInfo userPatientInfo) {
        save(userPatientInfo);
        return userPatientInfo.getEmpiId();
    }

    @Override
    public UserPatientInfo findOne(String empiId) {
        return get(UserPatientInfo.class, empiId);
    }
}
