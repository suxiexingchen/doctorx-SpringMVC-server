package com.dkt.consultation.bean;

/**
 * Created by GD on 2017/6/17.
 */
public class ConInfo {
    /**
     * 预约会诊事件 ID.
     */
    private String consultationId;
    /**
     * 患者 ID.
     */
    private String empiId;
    /**
     * 姓名.
     */
    private String patientName;
    /**
     * 性别.
     */
    private String patientSex;
    /**
     * 年龄.
     */
    private Integer patientBirthday;
    /**
     * 症状 述.
     */
    private String patientDescription;
    /**
     * 会诊预约时间(发起时间).
     */
    private Integer consultationApptDate;
    /**
     * 发起者 ID.
     */
    private String userId;
    /**
     * 发起者所在组织 ID.
     */
    private String clinicId;
    /**
     * 通话时长.
     */
    private int vedioTime;
    /**
     * 会诊意见.
     */
    private String consultationDoctorSuggest;
    /**
     * 记录状态，0:待确认,5:待会诊,10:会诊中,15:已完成.
     */
    private String status;

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
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

    public Integer getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(Integer patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientDescription() {
        return patientDescription;
    }

    public void setPatientDescription(String patientDescription) {
        this.patientDescription = patientDescription;
    }

    public Integer getConsultationApptDate() {
        return consultationApptDate;
    }

    public void setConsultationApptDate(Integer consultationApptDate) {
        this.consultationApptDate = consultationApptDate;
    }

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

    public int getVedioTime() {
        return vedioTime;
    }

    public void setVedioTime(int vedioTime) {
        this.vedioTime = vedioTime;
    }

    public String getConsultationDoctorSuggest() {
        return consultationDoctorSuggest;
    }

    public void setConsultationDoctorSuggest(String consultationDoctorSuggest) {
        this.consultationDoctorSuggest = consultationDoctorSuggest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
