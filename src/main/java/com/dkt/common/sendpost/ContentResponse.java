package com.dkt.common.sendpost;

/**
 * 推送正文
 */
public class ContentResponse {

    /**
     * pushTitle | 推送标题，用于客户端展示
     */
    private String pushTitle;

    /**
     *pushMessage | 推送内容，用户客户端展示
     */
    private String pushMessage;

    /**
     * control | 自定义协议体，用于扩充逻辑控制信息
     */
    private String control;

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle;
    }

    public String getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(String pushMessage) {
        this.pushMessage = pushMessage;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }
}
