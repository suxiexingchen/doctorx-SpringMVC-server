package com.dkt.doctor;

import com.dkt.entity.UserDoctorInfo;
import com.dkt.webhospital.WebDoctorInfoBean;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
public interface DoctorDao extends IBaseDao<UserDoctorInfo> {
    public List<UserDoctorInfo> getList(RequestBeanP10012 bean);

    public List<DoctorBeanP10009> getList(String account);

    //根据departmentId获取网络医生
    public List<UserDoctorInfo> getWebDoctorList(String departmentId);
}
