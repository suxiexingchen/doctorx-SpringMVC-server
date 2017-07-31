package com.dkt.online;

import com.dkt.entity.SysHuaweiAccount;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by litai on 2017/6/23.
 */
public interface SysHuaweiAccountDao extends IBaseDao<SysHuaweiAccount> {
    public List<SysHuaweiAccount> getList();
    public List<SysHuaweiAccount> getListByAccountAndRecId(String account, String recId);
}
