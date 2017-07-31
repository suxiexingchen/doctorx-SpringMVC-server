package com.dkt.consultation.service;

import com.dkt.consultation.bean.Img;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
public interface BizConImgService {
    void saveImg(String conId, String normalUrl);
    List<Img> findByConId(String conId);
}