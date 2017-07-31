package com.dkt.consultation.bean.p04;

/**
 * Created by GD on 2017/6/17.
 */
public class Request04 {
    /**
     * 当前用户 ID.
     */
    private String userId;
    /**
     * 当前用户所在机构 ID.
     */
    private String clinicId;
    /**
     * 会诊事件 ID.
     */
    private String consultationId;

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
}
