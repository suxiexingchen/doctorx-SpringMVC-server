package com.dkt.login;

import com.dkt.entity.UserOper;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/14.
 */
@Repository
public class T0001DaoImpl extends BaseDao<UserOper> implements T0001Dao {

    @Override
    public UserOper findByUp(String userName, String passwd) {
        StringBuilder hql = new StringBuilder(" from UserOper where 1=1 ");
        List<String> params = new ArrayList();
        if (!StringUtils.isEmpty(userName)) {
            hql.append(" and account=? ");
            params.add(userName);
        }
        if (!StringUtils.isEmpty(passwd)) {
            hql.append(" and password=? ");
            params.add(passwd);
        }
        return getByHQL(hql.toString(), params.toArray());
    }
}
