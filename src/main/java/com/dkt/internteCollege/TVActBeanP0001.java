package com.dkt.internteCollege;

import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-09
 */
public class TVActBeanP0001 {

    /**
     * 节目ID, 主键.
     */
    private Integer actId;

    /**
     * 节目标题
     */
    private String actTitle;

    /**
     * 节目简介
     */
    private String actDes;

    /**
     * 视频地址
     */
    private String actURL;

    /**
     * 缩略图
     */
    private String actPic;

    /**
     * 栏目ID
     */
    private Integer programId;

    /**
     * 创建时间
     */
    private Long commitTime;

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

    public Long getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Long commitTime) {
        this.commitTime = commitTime;
    }
}
