package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by litai on 2017/6/14.
 */
@Entity
@Table(name = "biz_consultation")
public class BizConsultation implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ConsultationId", length = 36)
    private String consultationId;

    @Column(name = "UserId", length = 36)
    private String userId;

    @Column(name = "ClinicId", length = 36)
    private String clinicId;

    @Column(name = "EmpiId", length = 36)
    private String empiId;

    @Column(name = "PatientDescription", length = 500)
    private String patientDescription;

    @Column(name = "ConsultationReason", length = 500)
    private String consultationReason;

    @Column(name = "DoctorWay", length = 1)
    private String doctorWay;

    @Column(name = "DestUserId", length = 36)
    private String destUserId;

    @Column(name = "DestClinicId", length = 36)
    private String destClinicId;

    @Column(name = "DestDepartmentId", length = 36)
    private String destDepartmentId;

    @Column(name = "Status", length = 2)
    private String status;

    @Column(name = "ConsultationCommitDate", length = 11)
    private Integer consultationCommitDate;

    @Column(name = "ConsultationApptDate", length = 11)
    private Integer consultationApptDate;

    @Column(name = "ConsultationStartDate", length = 11)
    private Integer consultationStartDate;

    @Column(name = "VedioDateBegin", length = 11)
    private Integer vedioDateBegin;

    @Column(name = "VedioDateEnd", length = 11)
    private Integer vedioDateEnd;

    @Column(name = "VedioTime", length = 11)
    private Integer vedioTime;

    @Column(name = "ConsultationDoctorSuggest", length = 500)
    private String consultationDoctorSuggest;

    @Column(name = "ApptViewFlag", length = 1)
    private String apptViewFlag;

    @Column(name = "SuggestViewFlag", length = 1)
    private String suggestViewFlag;


    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
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

    public String getEmpiId() {
        return empiId;
    }

    public void setEmpiId(String empiId) {
        this.empiId = empiId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getConsultationCommitDate() {
        return consultationCommitDate;
    }

    public void setConsultationCommitDate(Integer consultationCommitDate) {
        this.consultationCommitDate = consultationCommitDate;
    }

    public Integer getConsultationApptDate() {
        return consultationApptDate;
    }

    public void setConsultationApptDate(Integer consultationApptDate) {
        this.consultationApptDate = consultationApptDate;
    }

    public Integer getConsultationStartDate() {
        return consultationStartDate;
    }

    public void setConsultationStartDate(Integer consultationStartDate) {
        this.consultationStartDate = consultationStartDate;
    }

    public Integer getVedioDateBegin() {
        return vedioDateBegin;
    }

    public void setVedioDateBegin(Integer vedioDateBegin) {
        this.vedioDateBegin = vedioDateBegin;
    }

    public Integer getVedioDateEnd() {
        return vedioDateEnd;
    }

    public void setVedioDateEnd(Integer vedioDateEnd) {
        this.vedioDateEnd = vedioDateEnd;
    }

    public Integer getVedioTime() {
        return vedioTime;
    }

    public void setVedioTime(Integer vedioTime) {
        this.vedioTime = vedioTime;
    }

    public String getConsultationDoctorSuggest() {
        return consultationDoctorSuggest;
    }

    public void setConsultationDoctorSuggest(String consultationDoctorSuggest) {
        this.consultationDoctorSuggest = consultationDoctorSuggest;
    }

    public String getApptViewFlag() {
        return apptViewFlag;
    }

    public void setApptViewFlag(String apptViewFlag) {
        this.apptViewFlag = apptViewFlag;
    }

    public String getSuggestViewFlag() {
        return suggestViewFlag;
    }

    public void setSuggestViewFlag(String suggestViewFlag) {
        this.suggestViewFlag = suggestViewFlag;
    }
}
