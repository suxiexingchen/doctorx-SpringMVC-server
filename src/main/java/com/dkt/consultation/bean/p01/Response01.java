package com.dkt.consultation.bean.p01;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by GD on 2017/6/17.
 */
@ApiModel(description = "预约申请回复")
public class Response01 {
    @ApiModelProperty(value = "图片附件", notes = "图片列表")
    private String empiId;
    @ApiModelProperty(value = "图片附件", notes = "图片列表")
    private String consultationId;

    public String getEmpiId() {
        return empiId;
    }

    public void setEmpiId(String empiId) {
        this.empiId = empiId;
    }

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
    }
}
