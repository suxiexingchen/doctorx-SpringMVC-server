package com.dkt.online;

import com.dkt.entity.SysOnlineList;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by litai on 2017/6/21.
 */
public interface OnlineDao extends IBaseDao<SysOnlineList> {

    public List<SysOnlineList> getListByUserId(String userId);
    void add(String userId, String devType);
}
