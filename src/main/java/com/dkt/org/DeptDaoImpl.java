package com.dkt.org;

import com.dkt.entity.UserDeptInfo;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
@Repository
public class DeptDaoImpl extends BaseDao<UserDeptInfo> implements DeptDao {

    public List<UserDeptInfo> getListByClinicId(String clinicId) {

        List<UserDeptInfo> list = new ArrayList<UserDeptInfo>();
        StringBuilder whereSql = new StringBuilder("from UserDeptInfo ui where ui.clinicId = ? ");
        List<String> params = new ArrayList<String>();

        params.add(clinicId);

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }

    public List<UserDeptInfo> getListByClinicIdAndDoctorId(String clinicId,String doctorId) {

        List<UserDeptInfo> list = new ArrayList<UserDeptInfo>();
        StringBuilder whereSql = new StringBuilder("from UserDeptInfo ui where ui.departmentId in (select ud.departmentId from UserDoctorRelation ud where ud.doctorId = ? and ud.clinicId = ?) ");
        List<String> params = new ArrayList<String>();

        params.add(doctorId);
        params.add(clinicId);

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }
}
