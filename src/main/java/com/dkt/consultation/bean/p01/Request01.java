package com.dkt.consultation.bean.p01;

import com.dkt.consultation.bean.Img;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by GD on 2017/6/17.
 */
@ApiModel( description = "提交预约申请", value = "r01")
public class Request01 {
    /**
     * 当前用户ID.
     */
    @ApiModelProperty(value = "当前用户ID", required = true, dataType = "String")
    private String userId;
    /**
     * 当前用户所在机构ID.
     */
    @ApiModelProperty(value = "当前用户所在机构ID", required = true, dataType = "String")
    private String clinicId;
    /**
     * 废弃.
     */
    @ApiModelProperty(value = "患者ID", notes = "废弃,暂不使用")
    private String empiId;
    /**
     * 患者姓名.
     */
    @ApiModelProperty(value = "患者姓名", required = true, dataType = "String")
    private String patientName;
    /**
     * 患者性别，取值: 1=男 2=女 3=保密.
     */
    @ApiModelProperty(value = "患者性别", dataType = "String", example = "1:男;2:女;3:保密")
    private String patientSex;
    /**
     * 患者手机.
     */
    @ApiModelProperty(value = "患者手机", required = true, dataType = "String", notes = "由于患者滤重目前采用手机,暂要求填写")
    private String patientMobile;
    /**
     * 患者证件类型.
     */
    @ApiModelProperty(value = "患者证件类型", dataType = "String")
    private String patientCertificateType;
    /**
     * 患者证件号码.
     */
    @ApiModelProperty(value = "患者证件号码", dataType = "String")
    private String patientCertificateNum;
    /**
     * 患者症状述.
     */
    @ApiModelProperty(value = "患者症状描述", dataType = "String")
    private String patientDescription;
    /**
     * 会诊理由及目的.
     */
    @ApiModelProperty(value = "会诊理由及目的", dataType = "String")
    private String consultationReason;
    /**
     * 预约方式，取值:0=值班医生，1=专家.
     */
    @ApiModelProperty(value = "预约方式", dataType = "String", example = "0:值班医生;1:专家")
    private String doctorWay;
    /**
     * 被预约医生 ID.
     */
    @ApiModelProperty(value = "被预约医生ID", required = true, dataType = "String")
    private String destUserId;
    /**
     * 被预约医生所在机构 ID.
     */
    @ApiModelProperty(value = "被预约医生所在机构ID", required = true, dataType = "String")
    private String destClinicId;
    /**
     * 被预约医生所在机构科室 ID.
     */
    @ApiModelProperty(value = "被预约医生所在机构科室ID", required = true, dataType = "String")
    private String destDepartmentId;
    /**
     * 图片附件.
     */
    @ApiModelProperty(value = "图片附件", notes = "图片列表")
    private List<Img> images;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getEmpiId() {
        return empiId;
    }

    public void setEmpiId(String empiId) {
        this.empiId = empiId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getPatientCertificateType() {
        return patientCertificateType;
    }

    public void setPatientCertificateType(String patientCertificateType) {
        this.patientCertificateType = patientCertificateType;
    }

    public String getPatientCertificateNum() {
        return patientCertificateNum;
    }

    public void setPatientCertificateNum(String patientCertificateNum) {
        this.patientCertificateNum = patientCertificateNum;
    }

    public String getPatientDescription() {
        return patientDescription;
    }

    public void setPatientDescription(String patientDescription) {
        this.patientDescription = patientDescription;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }

    public String getDoctorWay() {
        return doctorWay;
    }

    public void setDoctorWay(String doctorWay) {
        this.doctorWay = doctorWay;
    }

    public String getDestUserId() {
        return destUserId;
    }

    public void setDestUserId(String destUserId) {
        this.destUserId = destUserId;
    }

    public String getDestClinicId() {
        return destClinicId;
    }

    public void setDestClinicId(String destClinicId) {
        this.destClinicId = destClinicId;
    }

    public String getDestDepartmentId() {
        return destDepartmentId;
    }

    public void setDestDepartmentId(String destDepartmentId) {
        this.destDepartmentId = destDepartmentId;
    }

    public List<Img> getImages() {
        return images;
    }

    public void setImages(List<Img> images) {
        this.images = images;
    }
}
