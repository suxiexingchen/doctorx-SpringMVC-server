package com.dkt.news;

import com.dkt.common.SysException;
import com.dkt.entity.News;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-14
 */
@Service
public class NewsServiceImpl implements NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsDao newsDao;

    public List<NewsResponseR0001> getNewsList(){
        List<NewsResponseR0001> lists=new ArrayList<>();
        List<News> listNews = newsDao.getListNews();

        if (null!=listNews&&listNews.size()>0){
            log.debug("已获取news信息");
            for (News ns:listNews) {
                NewsResponseR0001 newsResponseR0001=new NewsResponseR0001();
                BeanUtils.copyProperties(ns,newsResponseR0001);

                try {
                    newsResponseR0001.setCommitTime(ns.getCommitTime().getTime());
                } catch (Exception e) {
                    e.printStackTrace();
                    newsResponseR0001.setCommitTime(null);
                    log.debug("时间转换异常");
                }

                lists.add(newsResponseR0001);
            }

        }
        return lists;
    }
}
