package com.dkt.friends;

import com.dkt.entity.UserContactRelation;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by litai on 2017/6/18.
 */
public interface RelationDao extends IBaseDao<UserContactRelation> {

    public List<UserContactRelation> getList(String userId);
}
