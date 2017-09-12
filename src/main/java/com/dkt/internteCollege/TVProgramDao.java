package com.dkt.internteCollege;

import com.dkt.entity.TVProgram;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-09
 */
public interface TVProgramDao extends IBaseDao<TVProgram> {

    public List<TVProgram> getProgramList();
}
