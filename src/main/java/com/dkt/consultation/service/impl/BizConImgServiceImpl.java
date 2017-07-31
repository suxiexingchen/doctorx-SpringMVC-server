package com.dkt.consultation.service.impl;

import com.dkt.consultation.bean.Img;
import com.dkt.consultation.dao.BizConImgDao;
import com.dkt.consultation.service.BizConImgService;
import com.dkt.entity.BizConsultationImage;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
@Service
public class BizConImgServiceImpl implements BizConImgService {

    @Autowired
    private BizConImgDao bizConImgDao;

    @Override
    public void saveImg(String conId, String normalUrl) {
        BizConsultationImage bci = new BizConsultationImage();
        bci.setConsultationId(conId);
        bci.setNormalUrl(normalUrl);
        bizConImgDao.saveImg(bci);
    }

    @Override
    public List<Img> findByConId(String conId) {
        List<BizConsultationImage> bciList = bizConImgDao.findByConsultationId(conId);
        List<Img> imgs = Lists.newArrayList();
        if(!CollectionUtils.isEmpty(bciList)) {
            Img img;
            for (BizConsultationImage one : bciList) {
                img = new Img();
                BeanUtils.copyProperties(one, img);
                imgs.add(img);
            }
        }
        return imgs;
    }
}
