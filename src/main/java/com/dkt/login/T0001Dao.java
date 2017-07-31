package com.dkt.login;

import com.dkt.entity.SysOnlineList;
import com.dkt.entity.UserOper;
import com.platform.common.dao.IBaseDao;

/**
 * Created by litai on 2017/6/14.
 */
public interface T0001Dao extends IBaseDao<UserOper> {
    UserOper findByUp(String userName, String passwd);
}
