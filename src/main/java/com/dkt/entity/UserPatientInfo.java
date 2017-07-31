package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 患者表.
 *
 * Created by GD on 2017/6/14.
 */
@Entity
@Table(name = "user_patient_info")
public class UserPatientInfo implements Serializable {

    /**
     * 患者ID, 主键.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "EmpiId", length = 36)
    private String empiId;

    /**
     * 患者姓名.
     */
    @Column(name = "PatientName", length = 32)
    private String patientName;

    /**
     * 患者性别 1-男，2-女，3-保密.
     */
    @Column(name = "PatientSex", length = 1, nullable = false)
    private String patientSex;

    /**
     * 病人出生日期 YYYYMMDD.
     */
    @Column(name = "PatientBirthday", length = 8)
    private String patientBirthday;

    /**
     * 患者手机号.
     */
    @Column(name = "PatientMobile", length = 16)
    private String patientMobile;

    /**
     * 证件类型.
     */
    @Column(name = "PatientCertificateType", length = 2)
    private String patientCertificateType;

    /**
     * 证件号码.
     */
    @Column(name = "PatientCertificateNum", length = 32)
    private String patientCertificateNum;

    /**
     * 录入时间.
     */
    @Column(name = "InputTime", length = 11)
    private Integer inputTime;

    /**
     * 录入医生ID.
     */
    @Column(name = "InputDoctorId", length = 36)
    private String inputDoctorId;

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

    public String getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(String patientBirthday) {
        this.patientBirthday = patientBirthday;
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

    public Integer getInputTime() {
        return inputTime;
    }

    public void setInputTime(Integer inputTime) {
        this.inputTime = inputTime;
    }

    public String getInputDoctorId() {
        return inputDoctorId;
    }

    public void setInputDoctorId(String inputDoctorId) {
        this.inputDoctorId = inputDoctorId;
    }
}
