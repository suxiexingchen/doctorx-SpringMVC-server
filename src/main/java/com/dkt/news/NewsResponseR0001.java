package com.dkt.news;

import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:相应参数
 * @create 2017-09-14
 */
public class NewsResponseR0001 {

    /**
     * 主键
     */
    private Integer newsid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布时间
     */
    private Long commitTime;

    /**
     * 发布机构
     */
    private String company;

    /**
     * 发布地区
     */
    private Integer areaId;

    /**
     * 类型 0文本  1png 2url'
     */
    private Integer type;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 地址
     */
    private String url;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Long commitTime) {
        this.commitTime = commitTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
