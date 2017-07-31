package com.dkt.consultation.dao;

import com.dkt.entity.BizConsultation;
import com.platform.bean.PageInfo;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
public interface BizConDao {
    String saveBc(BizConsultation bizConsultation);
    Long consultationCount(String userId, String clinicId);
    List<BizConsultation> listNews(String userId, String clinicId, String status, PageInfo pageInfo);
    Long newsCount(String userId, String clinicId, String status);
    BizConsultation findOne(String consultationId);
    void updateApptViewFlag(String consultationId, String apptViewFlag);
    void startVedio(String consultationId, int startDate);
    void finishVedio(String consultationId, int endDate);
    void feedbackOpinion(String consultationId, String consultationDoctorSuggest);
    Long finishNoticeCount(String userId, String clinicId);
    List<BizConsultation> listFinished(String userId, String clinicId, String status, PageInfo pageInfo);
    Long finishedCount(String userId, String clinicId, String status);
    void updateApptTime(String consultationId, int apptTime);
    void updateStatus(String consultationId, String status);
}
