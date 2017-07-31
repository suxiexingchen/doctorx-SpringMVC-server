package com.dkt.consultation.bean.p10;

/**
 * Created by GD on 2017/6/23.
 */
public class Request10 {
    private String userId;
    private String clinicId;
    private String consultationId;
    /**
     * yyyyMMddHHmmss
     */
    private String apptTime;

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

    public String getApptTime() {
        return apptTime;
    }

    public void setApptTime(String apptTime) {
        this.apptTime = apptTime;
    }
}
