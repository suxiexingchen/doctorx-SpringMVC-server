package com.dkt.consultation.service.impl;

import com.dkt.common.SysConst;
import com.dkt.consultation.bean.ConInfo;
import com.dkt.consultation.bean.Img;
import com.dkt.consultation.bean.p01.Request01;
import com.dkt.consultation.bean.p01.Response01;
import com.dkt.consultation.bean.p02.Request02;
import com.dkt.consultation.bean.p02.Response02;
import com.dkt.consultation.bean.p03.Request03;
import com.dkt.consultation.bean.p03.Response03;
import com.dkt.consultation.bean.p04.Request04;
import com.dkt.consultation.bean.p04.Response04;
import com.dkt.consultation.bean.p05.Request05;
import com.dkt.consultation.bean.p06.Request06;
import com.dkt.consultation.bean.p07.Request07;
import com.dkt.consultation.bean.p08.Request08;
import com.dkt.consultation.bean.p08.Response08;
import com.dkt.consultation.bean.p09.Request09;
import com.dkt.consultation.bean.p09.Response09;
import com.dkt.consultation.bean.p10.Request10;
import com.dkt.consultation.bean.p11.Request11;
import com.dkt.consultation.dao.BizConDao;
import com.dkt.consultation.service.BizConImgService;
import com.dkt.consultation.service.BizConService;
import com.dkt.consultation.service.PatientService;
import com.dkt.entity.BizConsultation;
import com.dkt.entity.UserPatientInfo;
import com.google.common.collect.Lists;
import com.platform.bean.PageInfo;
import com.platform.sms.SMSClient;
import com.platform.sms.SMSException;
import com.platform.tool.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
@Service
public class BizConServiceImpl implements BizConService {

    private static final Logger LOG = LoggerFactory.getLogger(BizConServiceImpl.class);

    @Autowired
    private PatientService patientService;
    @Autowired
    private BizConImgService bizConImgService;
    @Autowired
    private BizConDao bizConDao;

    @Transactional
    @Override
    public Response01 applyConsultation(Request01 request) {
        BizConsultation bc = new BizConsultation();
        BeanUtils.copyProperties(request, bc);
        String empiId, consultationId;
        empiId = saveUpi(request);
        bc.setEmpiId(empiId);
        bc.setStatus(SysConst.CONSULTATION_STATUS_WAIT_CHECK);
        bc.setSuggestViewFlag(SysConst.CONSULTATION_VIEW_FLAG_NO);
        bc.setConsultationCommitDate(Tools.getCurUnixTime());
        bc.setVedioTime(0);
        bc.setApptViewFlag(SysConst.CONSULTATION_APPT_VIEW_FLAG_NO);
        consultationId = bizConDao.saveBc(bc);
        saveImg(consultationId, request);
        Response01 response = new Response01();
        response.setEmpiId(empiId);
        response.setConsultationId(consultationId);

        // 短信发送
        try {
            SMSClient.getInstance().init().withMessage("message").withTopic("topic")
                    .withParams("key", "value").withTemplateCode("templateCode")
                    .withReceiver("11111").send();
        } catch (SMSException e) {
            LOG.error("短信发送失败: {}, teleNo.{}", e.getMessage(), "1111");
        }
        return response;
    }

    @Transactional
    private String saveUpi(Request01 request) {
        UserPatientInfo upi = new UserPatientInfo();
        BeanUtils.copyProperties(request, upi);
        upi.setInputTime(Tools.getCurUnixTime());
        upi.setInputDoctorId(request.getUserId());
        String existId = null;
        if (!StringUtils.isEmpty(request.getPatientMobile())) {
            existId = patientService.exist(upi.getPatientMobile());
        }
        if (StringUtils.isEmpty(existId)) {
            existId = patientService.save(upi);
        }
        return existId;
    }

    @Transactional
    private void saveImg(String conId, Request01 request) {
        List<Img> imgs = request.getImages();
        for (Img one : imgs) {
            bizConImgService.saveImg(conId, one.getNormalUrl());
        }
    }

    @Override
    public Response02 consultationCount(Request02 request) {
        Response02 response = new Response02();
        response.setCount(bizConDao.consultationCount(request.getUserId(), request.getClinicId()));
        return response;
    }

    @Override
    public Response03 listNews(Request03 request) {
        PageInfo pageInfo = new PageInfo();
        int pageSize = request.getPageSize();
        pageInfo.setPageNo(request.getCurrentPage());
        pageInfo.setPageSize(pageSize);

        List<BizConsultation> bcList = bizConDao.listNews(request.getUserId(),
                request.getClinicId(), request.getStatus(), pageInfo);

        Long count = bizConDao.newsCount(request.getUserId(),
                request.getClinicId(), request.getStatus());

        List<ConInfo> conInfos = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(bcList)) {
            ConInfo conInfo;
            for (BizConsultation one : bcList) {
                conInfo = new ConInfo();
                BeanUtils.copyProperties(one, conInfo);
                UserPatientInfo upi = patientService.findOne(one.getEmpiId());
                BeanUtils.copyProperties(upi, conInfo);
                conInfos.add(conInfo);
            }
        }

        Response03 response = new Response03();
        response.setCurrentPage(request.getCurrentPage());
        response.setPageSize(request.getPageSize());
        response.setTotalRecord(count.intValue());
        response.setTotalPage(count%pageSize == 0 ? count.intValue()/pageSize : (count.intValue()/pageSize + 1));
        response.setDataSource(conInfos);
        return response;
    }

    @Transactional
    @Override
    public Response04 getDetail(Request04 request) {
        BizConsultation bizConsultation = bizConDao.findOne(request.getConsultationId());
        Response04 response = new Response04();
        if (null != bizConsultation) {
            BeanUtils.copyProperties(bizConsultation, response);
            UserPatientInfo upi = patientService.findOne(bizConsultation.getEmpiId());
            if (null != upi) {
                BeanUtils.copyProperties(upi, response);
            }
        }
        List<Img> imgs = bizConImgService.findByConId(request.getConsultationId());
        response.setImages(imgs);
        bizConDao.updateApptViewFlag(request.getConsultationId(), SysConst.CONSULTATION_APPT_VIEW_FLAG_YES);
        return response;
    }

    @Transactional
    @Override
    public void startVedio(Request05 request) {
        Date startDate = Tools.parser(request.getVedioDate());
        bizConDao.startVedio(request.getConsultationId(), Tools.getUnixTime(startDate));
    }

    @Transactional
    @Override
    public void finishVedio(Request06 request) {
        Date endDate = Tools.parser(request.getVedioDate());
        bizConDao.finishVedio(request.getConsultationId(), Tools.getUnixTime(endDate));
    }

    @Transactional
    @Override
    public void feedbackOpinion(Request07 request) {
        bizConDao.feedbackOpinion(request.getConsultationId(), request.getConsultationDoctorSuggest());
    }

    @Override
    public Response08 getFinishedNotice(Request08 request) {
        Response08 response = new Response08();
        Long count = bizConDao.finishNoticeCount(request.getUserId(), request.getClinicId());
        response.setCount(count.intValue());
        return response;
    }

    @Override
    public Response09 listFinished(Request09 request) {
        PageInfo pageInfo = new PageInfo();
        int pageSize = request.getPageSize();
        pageInfo.setPageNo(request.getCurrentPage());
        pageInfo.setPageSize(pageSize);

        List<BizConsultation> bcList = bizConDao.listFinished(request.getUserId(),
                request.getClinicId(), request.getStatus(), pageInfo);

        Long count = bizConDao.finishedCount(request.getUserId(),
                request.getClinicId(), request.getStatus());

        List<ConInfo> conInfos = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(bcList)) {
            ConInfo conInfo;
            for (BizConsultation one : bcList) {
                conInfo = new ConInfo();
                UserPatientInfo upi = patientService.findOne(one.getEmpiId());
                BeanUtils.copyProperties(upi, conInfo);
                BeanUtils.copyProperties(one, conInfo);
                conInfos.add(conInfo);
            }
        }

        Response09 response = new Response09();
        response.setCurrentPage(request.getCurrentPage());
        response.setPageSize(request.getPageSize());
        response.setTotalRecord(count.intValue());
        response.setTotalPage(count%pageSize == 0 ? count.intValue()/pageSize : (count.intValue()/pageSize + 1));
        response.setDataSource(conInfos);
        return response;
    }

    @Transactional
    @Override
    public void updateApptTime(Request10 request) {
        Date apptTime = Tools.parser(request.getApptTime());
        bizConDao.updateApptTime(request.getConsultationId(), Tools.getUnixTime(apptTime));
    }

    @Transactional
    @Override
    public void updateStatus(Request11 request) {
        bizConDao.updateStatus(request.getConsultationId(), request.getStatus());
    }
}
