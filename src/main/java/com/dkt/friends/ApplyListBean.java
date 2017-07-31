package com.dkt.friends;

import java.util.List;

/**
 * Created by litai on 2017/6/18.
 */
public class ApplyListBean {

    private String headIcon;
    private String employeeName;
    private String applyRemark;
    private String contactsId;
    private Integer applyDate;
    private List<Object> clinicInfoVoList;

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public Integer getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Integer applyDate) {
        this.applyDate = applyDate;
    }

    public List<Object> getClinicInfoVoList() {
        return clinicInfoVoList;
    }

    public void setClinicInfoVoList(List<Object> clinicInfoVoList) {
        this.clinicInfoVoList = clinicInfoVoList;
    }
}
