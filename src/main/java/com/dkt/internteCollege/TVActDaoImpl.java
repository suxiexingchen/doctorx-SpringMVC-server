package com.dkt.internteCollege;

import com.dkt.entity.TVAct;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-09
 */
@Repository
public class TVActDaoImpl extends BaseDao<TVAct> implements TVActDao{


    //通过programId获取TVAct
    public List<TVAct> getTVActListByProgramId(Integer programId) {


        List<TVAct> list = new ArrayList<TVAct>();
        StringBuilder whereSql = new StringBuilder("from TVAct act where 1=1 ");
        List<String> params = new ArrayList<String>();

        whereSql.append(" and act.programId = ? ");
        params.add(programId.toString());

        //whereSql.append(" order by act.commitTime desc ");

        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }
}
