package com.dkt.consultation.dao.impl;

import com.dkt.common.SysConst;
import com.dkt.consultation.dao.BizConDao;
import com.dkt.entity.BizConsultation;
import com.google.common.collect.Lists;
import com.platform.bean.PageInfo;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
@Repository
public class BizConDaoImpl extends BaseDao<BizConsultation> implements BizConDao {
    @Override
    public String saveBc(BizConsultation bizConsultation) {
        save(bizConsultation);
        return bizConsultation.getConsultationId();
    }

    @Override
    public Long consultationCount(String userId, String clinicId) {
        StringBuilder hql = new StringBuilder(" select count(*) from BizConsultation where 1=1 ");
        List<String> params = new ArrayList();
        if (!StringUtils.isEmpty(userId)) {
            hql.append(" and destUserId = ? ");
            params.add(userId);
        }
        if (!StringUtils.isEmpty(clinicId)) {
            hql.append(" and destClinicId = ? ");
            params.add(clinicId);
        }
        hql.append(" and status = ? ");
        params.add(SysConst.CONSULTATION_STATUS_WAIT);
        return countByHql(hql.toString(), params.toArray());
    }

    @Override
    public List<BizConsultation> listNews(String userId, String clinicId, String status, PageInfo pageInfo) {
        StringBuilder hql = new StringBuilder(" from BizConsultation bc where 1=1 ");
        List<Object> params = Lists.newArrayList();

        if (!StringUtils.isEmpty(userId) || !StringUtils.isEmpty(clinicId)) {
            hql.append(" and (( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and bc.userId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and bc.clinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" ) or ( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and bc.destUserId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and bc.destClinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" )) ");
        }

        if (!StringUtils.isEmpty(status)) {
            if ("-1".equals(status)) {
                hql.append(" and bc.status in ('0','5','10')");
            } else {
                hql.append(" and bc.status = ? ");
                params.add(status);
            }
        }

        hql.append(" order by bc.consultationApptDate, bc.consultationCommitDate asc");
//        if (!StringUtils.isEmpty(userId)) {
//            hql.append(" and bc.destUserId = ? ");
//            params.add(userId);
//        }
//        if (!StringUtils.isEmpty(clinicId)) {
//            hql.append(" and bc.destClinicId = ? ");
//            params.add(clinicId);
//        }
//        hql.append(" and bc.status = ? ");
//        params.add(status);
        if (pageInfo != null) {
            pageInfo.setEntityAlias("bc");
        }
        return getListByHQL(hql.toString(), pageInfo, params.toArray());
    }

    @Override
    public Long newsCount(String userId, String clinicId, String status) {
        StringBuilder hql = new StringBuilder(" select count(*) from BizConsultation bc where 1=1 ");
        List<Object> params = Lists.newArrayList();

        if (!StringUtils.isEmpty(userId) || !StringUtils.isEmpty(clinicId)) {
            hql.append(" and (( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and bc.userId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and bc.clinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" ) or ( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and bc.destUserId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and bc.destClinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" )) ");
        }

        if (!StringUtils.isEmpty(status)) {
            if ("-1".equals(status)) {
                hql.append(" and bc.status in (?,?,?)");
                params.add("0");
                params.add("5");
                params.add("10");
            } else {
                hql.append(" and bc.status = ? ");
                params.add(status);
            }
        }
//        if (!StringUtils.isEmpty(userId)) {
//            hql.append(" and destUserId = ? ");
//            params.add(userId);
//        }
//        if (!StringUtils.isEmpty(clinicId)) {
//            hql.append(" and destClinicId = ? ");
//            params.add(clinicId);
//        }
//        hql.append(" and status = ? ");
//        params.add(status);
        return countByHql(hql.toString(), params.toArray());
    }

    @Override
    public BizConsultation findOne(String consultationId) {
        return get(BizConsultation.class, consultationId);
    }

    @Override
    public void updateApptViewFlag(String consultationId, String apptViewFlag) {
        BizConsultation bc = findOne(consultationId);
        bc.setApptViewFlag(apptViewFlag);
        update(bc);
    }

    @Override
    public void startVedio(String consultationId, int startDate) {
        BizConsultation bc = findOne(consultationId);
        bc.setStatus(SysConst.CONSULTATION_STATUS_ING);
        bc.setConsultationStartDate(startDate);
        bc.setVedioDateBegin(startDate);
        update(bc);
    }

    @Override
    public void finishVedio(String consultationId, int endDate) {
        BizConsultation bc = findOne(consultationId);
        bc.setVedioDateEnd(endDate);
        bc.setVedioTime(endDate - bc.getVedioDateBegin());
        update(bc);
    }

    @Override
    public void feedbackOpinion(String consultationId, String consultationDoctorSuggest) {
        BizConsultation bc = findOne(consultationId);
        bc.setConsultationDoctorSuggest(consultationDoctorSuggest);
        bc.setStatus(SysConst.CONSULTATION_STATUS_FINISH);
        update(bc);
    }

    @Override
    public Long finishNoticeCount(String userId, String clinicId) {
        StringBuilder hql = new StringBuilder("select count(*) from BizConsultation where status='15' and suggestViewFlag='0' ");
        List<Object> params = Lists.newArrayList();
        if (!StringUtils.isEmpty(userId)) {
            hql.append(" and userId=? ");
            params.add(userId);
        }
        if (!StringUtils.isEmpty(clinicId)) {
            hql.append(" and clinicId=? ");
            params.add(clinicId);
        }
        return countByHql(hql.toString(), params.toArray());
    }

    /**
     * 暂时处理包括预约请求方和接收方.
     *
     * @param userId
     * @param clinicId
     * @param status
     * @param pageInfo
     * @return
     */
    @Override
    public List<BizConsultation> listFinished(String userId, String clinicId, String status, PageInfo pageInfo) {
        StringBuilder hql = new StringBuilder(" from BizConsultation bc where 1=1 ");
        List<Object> params = Lists.newArrayList();
        if (!StringUtils.isEmpty(userId) || !StringUtils.isEmpty(clinicId)) {
            hql.append(" and (( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and bc.userId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and bc.clinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" ) or ( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and bc.destUserId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and bc.destClinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" )) ");
        }
        // 下面是只考虑一种情况
//        if (!StringUtils.isEmpty(userId)) {
//            hql.append(" and bc.destUserId = ? ");
//            params.add(userId);
//        }
//        if (!StringUtils.isEmpty(clinicId)) {
//            hql.append(" and bc.destClinicId = ? ");
//            params.add(clinicId);
//        }
/*        if (!StringUtils.isEmpty(status)) {
            hql.append(" and bc.status = ? ");
            params.add(status);
        }*/
        hql.append(" and bc.status = '15' ");
        if (pageInfo != null) {
            pageInfo.setEntityAlias("bc");
        }
        return getListByHQL(hql.toString(), pageInfo, params.toArray());
    }

    @Override
    public Long finishedCount(String userId, String clinicId, String status) {
        StringBuilder hql = new StringBuilder(" select count(*) from BizConsultation where 1=1 ");
        List<Object> params = Lists.newArrayList();
        if (!StringUtils.isEmpty(userId) || !StringUtils.isEmpty(clinicId)) {
            hql.append(" and (( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and userId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and clinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" ) or ( 1=1 ");
            if (!StringUtils.isEmpty(userId)) {
                hql.append(" and destUserId = ? ");
                params.add(userId);
            }
            if (!StringUtils.isEmpty(clinicId)) {
                hql.append(" and destClinicId = ? ");
                params.add(clinicId);
            }
            hql.append(" )) ");
        }
        // 下面是只考虑一种情况
//        if (!StringUtils.isEmpty(userId)) {
//            hql.append(" and bc.destUserId = ? ");
//            params.add(userId);
//        }
//        if (!StringUtils.isEmpty(clinicId)) {
//            hql.append(" and bc.destClinicId = ? ");
//            params.add(clinicId);
//        }
        if (!StringUtils.isEmpty(status)) {
            hql.append(" and status = ? ");
            params.add(status);
        }
        return countByHql(hql.toString(), params.toArray());
    }

    @Override
    public void updateApptTime(String consultationId, int apptTime) {
        BizConsultation bc = findOne(consultationId);
        bc.setConsultationApptDate(apptTime);
        update(bc);
    }

    @Override
    public void updateStatus(String consultationId, String status) {
        BizConsultation bc = findOne(consultationId);
        bc.setStatus(status);
        update(bc);
    }
}
