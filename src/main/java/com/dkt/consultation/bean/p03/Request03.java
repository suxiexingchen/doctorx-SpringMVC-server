package com.dkt.consultation.bean.p03;

/**
 * Created by GD on 2017/6/17.
 */
public class Request03 {
    /**
     * 当前用户 ID.
     */
    private String userId;
    /**
     * 当前用户所在机构 ID.
     */
    private String clinicId;
    /**
     * 当前页码，默认为 0.
     */
    private Integer currentPage = 1;
    /**
     * 每页条数，默认为 5.
     */
    private Integer pageSize = 5;
    /**
     * 状态选择: 0:待确认,5:待会诊,10:会诊中 -1 则返回上述三种状态的记录.
     */
    private String status;

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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
