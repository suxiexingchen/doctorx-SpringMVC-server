package com.dkt.version;

import com.dkt.common.SysConst;
import com.dkt.entity.AppVersion;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-21
 */
@Repository
public class VersionDaoImpl extends BaseDao<AppVersion> implements VersionDao {

    public AppVersion upGrade(RequestBeanV0001 request){

        StringBuilder whereSql = new StringBuilder("from AppVersion av where 1=1");

        List<String> params = new ArrayList<String>();


        whereSql.append(" and av.app = ? ");
        params.add(request.getApp().toString());

        whereSql.append(" and av.code > ? ");
        params.add(request.getCode().toString());

        whereSql.append(" and av.devType = ? ");
        params.add(request.getDevType().toString());

        whereSql.append(" and av.channel = ? ");
        params.add(request.getChannel());

        whereSql.append(" and av.isIssue = ? ");
        params.add(SysConst.ISSUE_TRUE.toString());

        AppVersion byHQL = getByHQL(whereSql.toString(), params.toArray());

        return byHQL;
    }
}
