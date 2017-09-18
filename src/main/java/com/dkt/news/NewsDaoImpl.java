package com.dkt.news;

import com.dkt.entity.News;
import com.dkt.entity.UserDoctorInfo;
import com.platform.common.dao.impl.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
@Repository
public class NewsDaoImpl extends BaseDao<News> implements NewsDao{

    public List<News> getListNewsByIsPublish() {

        List<News> list = new ArrayList<News>();
        StringBuilder whereSql = new StringBuilder("from News ns where ns.isPublish = 1 order by ns.commitTime desc");


        list = getListByHQL(whereSql.toString(), null, null);

        return list;
    }
}
