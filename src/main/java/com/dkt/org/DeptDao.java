package com.dkt.org;

import com.dkt.entity.UserDeptInfo;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
public interface DeptDao extends IBaseDao<UserDeptInfo> {
    public List<UserDeptInfo> getListByClinicId(String clinicId);
    public List<UserDeptInfo> getListByClinicIdAndDoctorId(String clinicId,String doctorId);
}