package com.dkt.version;

import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-08-22
 */
public class VersionBeanV0001 {

    /**
     * 主键ID
     */
    private Integer versionId;

    /**
     * 版本编号 用于计算版本升级
     */
    private Integer code;
    /**
     * 版本号 字符串形式版本号
     */
    private Integer version;

    /**
     * 设备类型 1:tv盒子 2:ios 3:安卓手机
     */
    private Integer devType;

    /**
     * 渠道 henancatv(河南广电)
     */
    private String channel;

    /**
     * app下载地址
     */
    private String url;

    /**
     *是否强制更新 0不强制 1强制
     */
    private Integer isForced;

    /**
     * 版本介绍
     */
    private String des;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 是否发行 0不发行 1发行
     */
    private Integer isIssue;

    /**
     * 所属app类型 1 医生端 2 大众版
     */
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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
