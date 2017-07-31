package com.dkt.login;

/**
 * Created by linkd on 2017/7/11.
 */
public class QRLoginRequestBean {

    private String qrCodeKey;
    private String ticket;
    private String casUuid;
    private String appType;

    public String getQrCodeKey() {
        return qrCodeKey;
    }

    public void setQrCodeKey(String qrCodeKey) {
        this.qrCodeKey = qrCodeKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCasUuid() {
        return casUuid;
    }

    public void setCasUuid(String casUuid) {
        this.casUuid = casUuid;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }
}
