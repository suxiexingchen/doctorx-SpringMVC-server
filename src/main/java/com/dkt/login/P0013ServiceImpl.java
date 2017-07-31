package com.dkt.login;

import com.dkt.entity.UserDoctorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GD on 2017/6/15.
 */
@Service
public class P0013ServiceImpl implements P0013Service {

    @Autowired
    private P0013Dao p0013Dao;
    @Override
    public UserDoctorInfo findOne(String id) {
        return p0013Dao.get(UserDoctorInfo.class, id);
    }
}
