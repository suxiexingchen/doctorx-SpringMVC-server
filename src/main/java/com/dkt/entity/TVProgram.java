package com.dkt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 馒头花卷儿
 * @Description:栏目表
 * @create 2017-09-09
 */
@Entity
@Table(name = "tv_program")
public class TVProgram implements Serializable {

    /**
     * 栏目ID, 主键.
     */
    @Id
    @Column(name = "programId", length = 11)
    private Integer programId;


    /**
     * 栏目名称
     */
    @Column(name = "programName", length = 45)
    private String programName;

    /**
     * programType栏目类型：1-网络学院，2-慢性病管理
     */
    @Column(name = "programType", length = 11)
    private String programType;


    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }
}
