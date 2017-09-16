package com.dkt.internetCollege;

import com.dkt.entity.TVProgram;
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
public class TVProgramDaoImpl extends BaseDao<TVProgram> implements TVProgramDao {
    @Override
    public List<TVProgram> getProgramList(String programType) {
        List<TVProgram> list = new ArrayList<TVProgram>();
        StringBuilder whereSql = new StringBuilder("from TVProgram tv where 1=1 ");
        List<String> params = new ArrayList<String>();

        whereSql.append(" and tv.programType = ? ");
        params.add(programType);

        list = getListByHQL(whereSql.toString(), null, params.toArray());
        return list;
    }
}
