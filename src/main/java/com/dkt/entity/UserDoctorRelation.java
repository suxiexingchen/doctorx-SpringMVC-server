package com.dkt.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 医生科室关联表.
 *
 * Created by GD on 2017/6/14.
 */
@Entity
@Table(name = "user_doctor_relation")
public class UserDoctorRelation implements Serializable {

    /**
     * 主键.
     */
    @Id
    @Column(name = "Id", length = 11)
    private Integer id;

    /**
     * 医生ID.
     */
    @Column(name = "DoctorId", length = 36)
    private String doctorId;

    /**
     * 机构ID.
     */
    @Column(name = "ClinicId", length = 36)
    private String clinicId;

    /**
     * 科室ID.
     */
    @Column(name = "DepartmentId", length = 36)
    private String departmentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
