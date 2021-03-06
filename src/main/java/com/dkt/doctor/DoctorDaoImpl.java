package com.dkt.doctor;

import com.dkt.entity.UserDoctorInfo;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
@Repository
public class DoctorDaoImpl extends BaseDao<UserDoctorInfo> implements DoctorDao {

    public List<UserDoctorInfo> getList(RequestBeanP10012 bean) {

        List<UserDoctorInfo> list = new ArrayList<UserDoctorInfo>();
        StringBuilder whereSql = new StringBuilder("from UserDoctorInfo ui where ui.doctorId in (select ud.doctorId from UserDoctorRelation ud where ud.departmentId = ?) ");
        List<String> params = new ArrayList<String>();

        params.add(bean.getDeptId());

        if (!bean.getAllDoctor()) {

            whereSql.append(" and ui.doctorWay = ? ");
            params.add("1");
        }

        whereSql.append(" order by ui.doctorWay desc ");

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }

    @Override
    public List<DoctorBeanP10009> getList(String account) {

        List<DoctorBeanP10009> dbList = new ArrayList<>();
        List<String> params = new ArrayList<>();
        params.add(account);
        List<Object[]> resultList
                =  getListBySQLName("sql_getp10009_1",null, params.toArray());
        DoctorBeanP10009 db09 = new DoctorBeanP10009();
        if(resultList.get(0) != null){
            Object[] objects = resultList.get(0);
            if(objects[0] != null)
                db09.setDoctorId(objects[0].toString());
            if(objects[1] != null)
                db09.setDoctorPhoto(objects[1].toString());
            if(objects[2] != null)
                db09.setRealName(objects[2].toString());
            if(objects[3] != null)
                db09.setMedicineTitle(objects[3].toString());
        }
        params.clear();
        resultList.clear();
        params.add(db09.getDoctorId());
        resultList = getListBySQLName("sql_getp10009_2",null,params.toArray());
        for(int i =0; i < resultList.size(); i++){
            if(resultList.get(i) != null){
                Object[] objects = resultList.get(i);
                db09.addClinic(objects[1].toString(), objects[0].toString(), "0");
            }
        }
        dbList.add(db09);
        return dbList;
    }

}
