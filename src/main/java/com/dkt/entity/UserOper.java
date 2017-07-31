package com.dkt.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 操作员表.
 *
 * Created by GD on 2017/6/14.
 */
@Entity
@Table(name = "user_oper")
public class UserOper implements Serializable {

    /**
     * 操作员ID, 暂做主键.
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "OperId", length = 36)
    private String operId;

    /**
     * 用户名.
     */
    @Column(name = "Account", length = 32)
    private String account;

    /**
     * 密码（MD5+盐）.
     */
    @Column(name = "Password", length = 32)
    private String password;

    /**
     * 操作员级别 0-超管 1-普通用户 2-医生 3-机构管理员.
     */
    @Column(name = "Roles", length = 1)
    private String roles;

    /**
     * 积分
     */
    @Column(name = "Points", length = 12)
    private BigDecimal points;

    /**
     * 状态 0-锁定 1-正常.
     */
    @Column(name = "Status", length = 1)
    private String status;

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}
