package com.dkt.news;

import com.dkt.common.CommonResponse;
import com.dkt.common.SysConst;
import com.dkt.common.SysException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:新闻
 * @create 2017-09-14
 */
@RestController
@Scope("session")
public class NewsController {

    private static final Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @RequestMapping("/external/getNewList")
    public CommonResponse<List<NewsResponseR0001>> getNewList(){
        log.debug("开始获取news信息");
        CommonResponse<List<NewsResponseR0001>> wr=new CommonResponse<>();
        try {
            List<NewsResponseR0001> newsList = newsService.getNewsList();
            wr.setResult(newsList);
        } catch (Exception e) {
            e.printStackTrace();
            wr.setStatus(SysConst.STATUS_ERROR);
        }

        return wr;
    }
}
