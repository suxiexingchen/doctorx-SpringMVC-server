package com.dkt.online;

import com.dkt.entity.SysOnlineList;
import com.platform.common.dao.impl.BaseDao;
import com.platform.tool.Tools;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/21.
 */
@Repository
public class OnlineDaoImpl extends BaseDao<SysOnlineList> implements OnlineDao {

    public List<SysOnlineList> getListByUserId(String userId) {

        List<SysOnlineList> list = new ArrayList<SysOnlineList>();
        StringBuilder whereSql = new StringBuilder("from SysOnlineList ui where ui.userId =? ");

        List<String> params = new ArrayList<>();
        params.add(userId);

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }

    @Override
    public void add(String userId, String devType) {
        SysOnlineList sol = new SysOnlineList();
        sol.setUserId(userId);
        sol.setDeviceType(devType);
        sol.setUserType(devType);
        sol.setLastHeartBeatTime(Tools.getCurUnixTime());
        save(sol);
    }
}
