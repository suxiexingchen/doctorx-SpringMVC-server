package com.dkt.org;

import com.dkt.entity.TVAct;
import com.dkt.entity.UserOrgInfo;
import com.platform.bean.PageInfo;
import com.platform.common.dao.impl.BaseDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by litai on 2017/6/17.
 */
@Repository
public class OrgDaoImpl extends BaseDao<UserOrgInfo> implements OrgDao {

    public List<UserOrgInfo> getList(OrgRequestBean bean, PageInfo pageInfo) {

        List<UserOrgInfo> list = new ArrayList<UserOrgInfo>();
        StringBuilder whereSql = new StringBuilder("from UserOrgInfo ui where 1=1 ");
        List<String> params = new ArrayList<String>();
            if (bean!=null) {
                if (StringUtils.isNotBlank(bean.getClinicLevel()) && !bean.getClinicLevel().equals("-1")) {
                    whereSql.append(" and ui.clinicLevel =? ");
                    params.add(bean.getClinicLevel());
                }
            }

        whereSql.append(" order by ui.inputTime desc ");
        if (pageInfo != null) {
            pageInfo.setEntityAlias("ui");
        }
        list = getListByHQL(whereSql.toString(), pageInfo, params.toArray());

        return list;
    }

    public List<UserOrgInfo> getDoctorOrg(String doctorId){

        List<UserOrgInfo> list = new ArrayList<UserOrgInfo>();
        StringBuilder whereSql = new StringBuilder("from UserOrgInfo ui where ui.clinicId in (select ud.clinicId from UserDoctorRelation ud where ud.doctorId = ?)");
        List<String> params = new ArrayList<String>();
        params.add(doctorId);

        whereSql.append(" order by ui.inputTime desc ");
        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }

    public List<UserOrgInfo> getDoctorOrgByCommunityId(Integer communityId) {

        List<UserOrgInfo> list = new ArrayList<UserOrgInfo>();
        StringBuilder whereSql = new StringBuilder("from UserOrgInfo org where 1=1 ");
        List<String> params = new ArrayList<String>();
        if (null!=communityId) {
            whereSql.append(" and org.communityId = ? ");
            params.add(communityId.toString());

            //whereSql.append(" order by act.commitTime desc ");

            list = getListByHQL(whereSql.toString(), null, params.toArray());
        }
        return list;
    }

    public List<UserOrgInfo> getDoctorOrgHasDoctor(String doctorWay){

        List<UserOrgInfo> list = new ArrayList<UserOrgInfo>();
        StringBuilder whereSql = new StringBuilder("from UserOrgInfo ui where ui.clinicId in (select ud.clinicId from UserDoctorRelation ud where ud.doctorId in (select us.doctorId from UserDoctorInfo us where us.doctorWay = ?))");
        List<String> params = new ArrayList<String>();
        params.add(doctorWay);

        whereSql.append(" order by ui.inputTime desc ");
        list = getListByHQL(whereSql.toString(), null, params.toArray());

        return list;
    }


}