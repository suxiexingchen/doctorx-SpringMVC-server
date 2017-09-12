package com.dkt.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:节目表
 * @create 2017-09-09
 */
@Entity
@Table(name = "tv_act")
public class TVAct implements Serializable{

    /**
     * 节目ID, 主键.
     */
    @Id
    @Column(name = "actId", length = 11)
    private Integer actId;

    /**
     * 节目标题
     */
    @Column(name = "actTitle", length = 45)
    private String actTitle;

    /**
     * 节目简介
     */
    @Column(name = "actDes", length = 45)
    private String actDes;

    /**
     * 视频地址
     */
    @Column(name = "actURL", length = 45)
    private String actURL;

    /**
     * 缩略图
     */
    @Column(name = "actPic", length = 45)
    private String actPic;

    /**
     * 栏目ID
     */
    @Column(name = "programId", length = 45)
    private Integer programId;

    /**
     * 创建时间
     */
    @Column(name = "commitTime")

    private Date commitTime;

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }

    public String getActDes() {
        return actDes;
    }

    public void setActDes(String actDes) {
        this.actDes = actDes;
    }

    public String getActURL() {
        return actURL;
    }

    public void setActURL(String actURL) {
        this.actURL = actURL;
    }

    public String getActPic() {
        return actPic;
    }

    public void setActPic(String actPic) {
        this.actPic = actPic;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
