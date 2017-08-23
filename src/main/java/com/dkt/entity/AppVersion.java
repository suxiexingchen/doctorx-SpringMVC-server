package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:版本表
 * @create 2017-08-20
 */
@Entity
@Table(name = "app_version")
public class AppVersion implements Serializable {

    /**
     * 主键ID
     */
    @Id
    @Column(name = "versionId", length = 11)
    private Integer versionId;

    /**
     * 版本编号 用于计算版本升级
     */
    @Column(name = "code", length = 11)
    private Integer code;
    /**
     * 版本号 字符串形式版本号
     */
    @Column(name = "version", length = 45)
    private String version;

    /**
     * 设备类型 1:tv盒子 2:ios 3:安卓手机
     */
    @Column(name = "devType", length = 11)
    private Integer devType;

    /**
     * 渠道 henancatv(河南广电)
     */
    @Column(name = "channel", length = 45)
    private String channel;

    /**
     * app下载地址
     */
    @Column(name = "url", length = 225)
    private String url;

    /**
     * 是否强制更新 0不强制 1强制
     */
    @Column(name = "isForced", length = 11)
    private Integer isForced;

    /**
     * 版本介绍
     */
    @Column(name = "des", length = 255)
    private String des;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 是否发行 0不发行 1发行
     */
    @Column(name = "isIssue", length = 11)
    private Integer isIssue;

    /**
     * 所属app类型 1 医生端 2 大众版
     */
    @Column(name = "app", length = 11)
    private Integer app;

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsForced() {
        return isForced;
    }

    public void setIsForced(Integer isForced) {
        this.isForced = isForced;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsIssue() {
        return isIssue;
    }

    public void setIsIssue(Integer isIssue) {
        this.isIssue = isIssue;
    }

    public Integer getApp() {
        return app;
    }

    public void setApp(Integer app) {
        this.app = app;
    }
}
