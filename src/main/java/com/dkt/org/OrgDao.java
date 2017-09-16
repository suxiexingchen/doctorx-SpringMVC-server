package com.dkt.org;

import com.dkt.entity.UserOrgInfo;
import com.platform.bean.PageInfo;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
public interface OrgDao extends IBaseDao<UserOrgInfo> {

    public List<UserOrgInfo> getList(OrgRequestBean bean, PageInfo pageInfo);
    public List<UserOrgInfo> getDoctorOrg(String doctorId);
    public List<UserOrgInfo> getDoctorOrgByCommunityId(Integer communityId);
    public List<UserOrgInfo> getDoctorOrgHasDoctor(String doctorWay);
}
