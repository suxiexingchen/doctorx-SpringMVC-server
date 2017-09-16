package com.dkt.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 馒头花卷儿
 * @Description:community社区表
 * @create 2017-09-14
 */
@Entity
@Table(name = "community")
public class Community implements Serializable {

    @Id
    @Column(name = "communityId", length = 11)
    private Integer communityId;

    /**
     * 社区名字
     */
    @Column(name = "communityName", length = 45)
    private String communityName;

    /**
     * 地区ID
     */
    @Column(name = "areaId", length = 11)
    private Integer areaId;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
