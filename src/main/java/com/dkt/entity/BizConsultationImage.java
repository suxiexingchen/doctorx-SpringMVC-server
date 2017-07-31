package com.dkt.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by litai on 2017/6/14.
 */
@Entity
@Table(name = "biz_consultation_image")
public class BizConsultationImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", length = 11)
    private Integer id;

    @Column(name = "ConsultationId", length = 36)
    private String consultationId;

    @Column(name = "NormalUrl", length = 255)
    private String normalUrl;

    @Column(name = "ThumbnailUrl", length = 255)
    private String thumbnailUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
    }

    public String getNormalUrl() {
        return normalUrl;
    }

    public void setNormalUrl(String normalUrl) {
        this.normalUrl = normalUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
