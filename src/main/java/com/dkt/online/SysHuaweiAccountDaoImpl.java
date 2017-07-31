package com.dkt.online;

import com.dkt.entity.SysHuaweiAccount;
import com.platform.common.dao.IBaseDao;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/23.
 */
@Repository
public class SysHuaweiAccountDaoImpl extends BaseDao<SysHuaweiAccount> implements SysHuaweiAccountDao {

    public List<SysHuaweiAccount> getList() {

        List<SysHuaweiAccount> list = new ArrayList<SysHuaweiAccount>();
        StringBuilder whereSql = new StringBuilder("from SysHuaweiAccount ui where ui.currentRecId ='' or ui.currentRecId is null ");

        list = getListByHQL(whereSql.toString(), null, null);

        return list;
    }

    public List<SysHuaweiAccount> getListByAccountAndRecId(String account, String recId) {

        List<SysHuaweiAccount> list = new ArrayList<SysHuaweiAccount>();
        StringBuilder whereSql = new StringBuilder("from SysHuaweiAccount ui where ui.currentRecId =? and ui.account = ? ");
        List<String> params = new ArrayList<>();
        params.add(recId);
        params.add(account);

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }
}
