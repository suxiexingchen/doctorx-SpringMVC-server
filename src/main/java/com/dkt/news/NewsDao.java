package com.dkt.news;

import com.dkt.entity.News;
import com.platform.common.dao.IBaseDao;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
public interface NewsDao extends IBaseDao<News> {

    public List<News> getListNews();
}
