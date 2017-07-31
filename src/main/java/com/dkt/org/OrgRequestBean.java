package com.dkt.org;

/**
 * Created by litai on 2017/6/17.
 */
public class OrgRequestBean {

    /**
     * -1:所有，1:医院, 2:诊所
     */
    private String clinicLevel;

    private Integer currentPage = 0;

    private Integer pageSize = 5;

    public String getClinicLevel() {
        return clinicLevel;
    }

    public void setClinicLevel(String clinicLevel) {
        this.clinicLevel = clinicLevel;
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
}
