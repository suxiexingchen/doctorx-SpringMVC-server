package com.dkt.user;

import com.dkt.common.SysException;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
public interface UserService {

    public List<UserResponseU0001> getUserInfoByCommunityId(Integer communityId)throws SysException;
    public void setTVN(UserRequestU0002 request)throws SysException;
}
