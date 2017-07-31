package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 科室表.
 *
 * Created by GD on 2017/6/14.
 */
@Entity
@Table(name = "user_dept_info")
public class UserDeptInfo implements Serializable {

    /**
     * 科室ID, 主键.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "DepartmentId", length = 36)
    private String departmentId;

    /**
     * 机构ID.
     */
    @Column(name = "ClinicId", length = 36)
    private String clinicId;

    /**
     * 科室名称.
     */
    @Column(name = "DepartmentName", length = 32)
    private String departmentName;

    /**
     * 科室介绍.
     */
    @Column(name = "DepartmentIntroduce", columnDefinition = "TEXT")
    private String departmentIntroduce;

    /**
     * 录入时间时间戳.
     */
    @Column(name = "InputTime", length = 11)
    private Integer inputTime;

    /**
     * 录入操作员ID.
     */
    @Column(name = "InputOperId", length = 36)
    private String inputOperId;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentIntroduce() {
        return departmentIntroduce;
    }

    public void setDepartmentIntroduce(String departmentIntroduce) {
        this.departmentIntroduce = departmentIntroduce;
    }

    public Integer getInputTime() {
        return inputTime;
    }

    public void setInputTime(Integer inputTime) {
        this.inputTime = inputTime;
    }

    public String getInputOperId() {
        return inputOperId;
    }

    public void setInputOperId(String inputOperId) {
        this.inputOperId = inputOperId;
    }
}
