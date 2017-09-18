package com.dkt.user;

import com.dkt.entity.UserInfo;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
public interface UserDao extends IBaseDao<UserInfo> {

    public List<UserInfo> getUserInfoByCommunityId(Integer communityId);
    //根据TVN的值找到
    public List<UserInfo> getUserByTVN(String TVN);

}
