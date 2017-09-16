package com.dkt.user;

import com.dkt.entity.UserInfo;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
@Repository
public class UserDaoImpl extends BaseDao<UserInfo> implements UserDao {

    public List<UserInfo> getUserInfoByCommunityId(Integer communityId) {

        List<UserInfo> list = new ArrayList<UserInfo>();
        StringBuilder whereSql = new StringBuilder("from UserInfo ui where 1=1 ");
        List<String> params = new ArrayList<String>();
        if (null!=communityId&&!"".equals(communityId)) {
            whereSql.append(" and ui.communityId = ? ");
            params.add(communityId.toString());

            //whereSql.append(" order by ui.doctorWay desc ");

            list = getListByHQL(whereSql.toString(), null, params.toArray());
        }
        return list;
    }
}
