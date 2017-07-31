package com.dkt.consultation.bean.p02;

/**
 * Created by GD on 2017/6/17.
 */
public class Request02 {
    /**
     * 当前用户ID.
     */
    private String userId;
    /**
     * 当前用户所在机构ID.
     */
    private String clinicId;

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
}
