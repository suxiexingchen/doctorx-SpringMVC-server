package com.dkt.friends;

import com.dkt.entity.UserContactApply;
import com.platform.bean.PageInfo;
import com.platform.common.dao.impl.BaseDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/18.
 */
@Repository
public class ApplyDaoImpl extends BaseDao<UserContactApply> implements ApplyDao {

    public List<UserContactApply> getListPage(RequestBeanP10015 bean, PageInfo pageInfo) {

        List<UserContactApply> list = new ArrayList<UserContactApply>();
        StringBuilder whereSql = new StringBuilder("from UserContactApply ui where ui.contactUserId = ? and ui.isAgree = '0' order by ui.applyDate desc");
        List<String> params = new ArrayList<>();

        params.add(bean.getUserId());

        if (pageInfo != null) {
            pageInfo.setEntityAlias("ui");
        }

        list = getListByHQL(whereSql.toString(), pageInfo, params.toArray());

        return list;
    }

    public List<UserContactApply> getListByTwoId(RequestBeanP10016 bean,String type) {

        List<UserContactApply> list = new ArrayList<UserContactApply>();
        StringBuilder whereSql = new StringBuilder("from UserContactApply ui where ui.contactsId = ? ");
        List<String> params = new ArrayList<>();

        params.add(bean.getContactsId());

        if(StringUtils.isNotBlank(type)){
            whereSql.append(" and ui.isAgree = ? ");
            params.add(type);
        }

        whereSql.append(" order by ui.applyDate desc");

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }
}
