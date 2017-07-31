package com.dkt.consultation.service;

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

/**
 * Created by GD on 2017/6/17.
 */
public interface BizConService {
    Response01 applyConsultation(Request01 request);
    Response02 consultationCount(Request02 request);
    Response03 listNews(Request03 request);
    Response04 getDetail(Request04 request);
    void startVedio(Request05 request);
    void finishVedio(Request06 request);
    void feedbackOpinion(Request07 request);
    Response08 getFinishedNotice(Request08 request);
    Response09 listFinished(Request09 request);
    void updateApptTime(Request10 request);
    void updateStatus(Request11 request);
}
