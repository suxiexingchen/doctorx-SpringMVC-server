package com.dkt.consultation.bean;

/**
 * Created by GD on 2017/6/17.
 */
public class Img {
    /**
     * 原始图片地址.
     */
    private String normalUrl;
    /**
     * 缩略图,预留.
     */
    private String thumbnailUrl;

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
