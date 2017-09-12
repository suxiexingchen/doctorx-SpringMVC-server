package com.dkt.internteCollege;

import com.dkt.entity.TVAct;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-09
 */
public interface TVActDao extends IBaseDao<TVAct> {

 public List<TVAct> getTVActListByProgramId(Integer programId);
}
