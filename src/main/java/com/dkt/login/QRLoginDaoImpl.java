package com.dkt.login;

import com.dkt.entity.UserDoctorInfo;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linkd on 2017/7/11.
 */
@Repository
public class QRLoginDaoImpl extends BaseDao<UserDoctorInfo> implements QRLoginDao {


    @Override
    public PollingResponseBean getInfo(String account) {

        List<String> params = new ArrayList<>();
        params.add(account);
        List<Object[]> list
                = getListBySQLName("sql_QRcodePolling", null, params.toArray());
        if(list == null) return null;
        PollingResponseBean bean = new PollingResponseBean();
        if(list.get(0) != null){
            Object[] objects = list.get(0);
            if(objects[0] != null){
                bean.setDoctorPhoto(objects[0].toString());
            }
            if(objects[1] != null){
                bean.setDoctorId(objects[1].toString());
            }
            if(objects[2] != null){
                bean.setRoles(objects[2].toString());
            }
            return bean;
        }
        return null;
    }
}
