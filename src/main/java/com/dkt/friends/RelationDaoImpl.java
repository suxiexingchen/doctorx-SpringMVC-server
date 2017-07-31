package com.dkt.friends;

import com.dkt.entity.UserContactRelation;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/18.
 */
@Repository
public class RelationDaoImpl extends BaseDao<UserContactRelation> implements RelationDao {

    public List<UserContactRelation> getList(String userId) {

        List<UserContactRelation> list = new ArrayList<UserContactRelation>();
        StringBuilder whereSql = new StringBuilder("from UserContactRelation ui where ui.userId =?");
        List<String> params = new ArrayList<String>();

        params.add(userId);

        whereSql.append(" order by ui.inputTime desc ");

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }


}
