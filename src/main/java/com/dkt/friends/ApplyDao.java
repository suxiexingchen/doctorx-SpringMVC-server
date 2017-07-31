package com.dkt.friends;

import com.dkt.entity.UserContactApply;
import com.platform.bean.PageInfo;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by litai on 2017/6/18.
 */
public interface ApplyDao extends IBaseDao<UserContactApply> {
    public List<UserContactApply> getListPage(RequestBeanP10015 bean, PageInfo pageInfo);
    public List<UserContactApply> getListByTwoId(RequestBeanP10016 bean,String type);
}
