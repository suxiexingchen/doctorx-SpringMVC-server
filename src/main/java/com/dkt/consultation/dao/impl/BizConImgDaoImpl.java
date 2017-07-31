package com.dkt.consultation.dao.impl;

import com.dkt.consultation.dao.BizConImgDao;
import com.dkt.entity.BizConsultationImage;
import com.google.common.collect.Lists;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
@Repository
public class BizConImgDaoImpl extends BaseDao<BizConsultationImage> implements BizConImgDao {
    @Override
    public void saveImg(BizConsultationImage bci) {
        save(bci);
    }

    @Override
    public List<BizConsultationImage> findByConsultationId(String consultationId) {
        StringBuilder hql = new StringBuilder(" from BizConsultationImage where consultationId=? ");
        return getListByHQL(hql.toString(), null, new String[]{consultationId});
    }
}
