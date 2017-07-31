package com.dkt.consultation.bean.p07;

/**
 * Created by GD on 2017/6/21.
 */
public class Request07 {
    private String userId;
    private String clinicId;
    private String consultationId;
    private String consultationDoctorSuggest;

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

    public String getConsultationDoctorSuggest() {
        return consultationDoctorSuggest;
    }

    public void setConsultationDoctorSuggest(String consultationDoctorSuggest) {
        this.consultationDoctorSuggest = consultationDoctorSuggest;
    }
}
