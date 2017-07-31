package com.dkt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by litai on 2017/6/14.
 */
@Entity
@Table(name = "sys_huawei_account")
public class SysHuaweiAccount implements Serializable {

    @Id
    @Column(name = "Id", length = 36)
    private Integer id;

    @Column(name = "Account", length = 32)
    private String account;

    @Column(name = "Password", length = 32)
    private String password;

    @Column(name = "CurrentRecId", length = 36)
    private String currentRecId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentRecId() {
        return currentRecId;
    }

    public void setCurrentRecId(String currentRecId) {
        this.currentRecId = currentRecId;
    }
}
