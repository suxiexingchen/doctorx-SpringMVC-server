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
    public List<UserDoctorInfo> getWebDoctorList(String departmentId,String doctorWay);

    //根据TVN的值找到
    public List<UserDoctorInfo> getDoctorByTVN(String TVN);

    //根据科室查找是家庭医生的医生
    public List<UserDoctorInfo> getDoctorIsFamily(String departmentId);

    //根据条件查询对应的医生
    public List<UserDoctorInfo> getDoctorByQuery(String doctorWay);
}
