package com.dkt.entity;

import jdk.Exported;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:新闻表
 * @create 2017-09-14
 */
@Entity
@Table(name = "news")
public class News implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "newsid", length = 11)
    private Integer newsid;

    /**
     * 标题
     */
    @Column(name = "title", length = 45)
    private String title;

    /**
     * 内容
     */
    @Column(name = "content", length = 5000)
    private String content;

    /**
     * 发布时间
     */
    @Column(name = "commitTime", length = 45)
    private Date commitTime;

    /**
     * 发布机构
     */
    @Column(name = "company", length = 45)
    private String company;

    /**
     * 发布地区
     */
    @Column(name = "areaId", length = 11)
    private Integer areaId;

    /**
     * 类型 0文本  1png 2url'
     */
    @Column(name = "type", length = 11)
    private Integer type;

    /**
     * 图片地址
     */
    @Column(name = "imgUrl", length = 200)
    private String imgUrl;

    /**
     * 地址
     */
    @Column(name = "url", length = 200)
    private String url;

    /**
     * 是否发布：0-未发布 1-发布
     */
    @Column(name = "isPublish", length = 11)
    private Integer isPublish;

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

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }
}
