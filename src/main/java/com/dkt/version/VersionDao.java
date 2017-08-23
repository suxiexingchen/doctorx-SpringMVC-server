package com.dkt.version;

import com.dkt.entity.AppVersion;
import com.platform.common.dao.IBaseDao;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-21
 */

public interface VersionDao extends IBaseDao<AppVersion> {

    public AppVersion upGrade(RequestBeanV0001 request);
}
