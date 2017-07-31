package com.dkt.consultation.dao;

import com.dkt.entity.BizConsultationImage;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
public interface BizConImgDao {
    void saveImg(BizConsultationImage bci);
    List<BizConsultationImage> findByConsultationId(String consultationId);
}
