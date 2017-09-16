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

    public List<News> getListNews() {

        List<News> list = new ArrayList<News>();
        StringBuilder whereSql = new StringBuilder("from News ns where 1=1");

             //List<String> params = new ArrayList<String>();
            //whereSql.append(" and ui.doctorWay = ? ");
            //params.add("1");
            //whereSql.append(" order by ui.doctorWay desc ");

        list = getListByHQL(whereSql.toString(), null, null);

        return list;
    }
}
