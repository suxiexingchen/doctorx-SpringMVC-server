package com.dkt.consultation.bean.p06;

/**
 * Created by GD on 2017/6/21.
 */
public class Request06 {
    private String userId;
    private String clinicId;
    private String consultationId;
    /**
     * yyyyMMddHHmmss
     */
    private String vedioDate;

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

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
    }

    public String getVedioDate() {
        return vedioDate;
    }

    public void setVedioDate(String vedioDate) {
        this.vedioDate = vedioDate;
    }
}
