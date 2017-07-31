package com.dkt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by GD on 2017/6/16.
 */
@Entity
@Table(name = "sys_login_qrcode")
public class SysLoginQrcode implements Serializable {
    /**
     * 主键.
     */
    @Id
    @Column(name = "Id", length = 11)
    private Integer id;
    /**
     * 客户端Id，用于生成二维码，并轮询有哪个用户登录成功.
     */
    @Column(name = "ClientId", length = 36)
    private String clientId;
    /**
     * 扫码后传入的登录操作员ID.
     */
    @Column(name = "OperId", length = 36)
    private String operId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }
}
