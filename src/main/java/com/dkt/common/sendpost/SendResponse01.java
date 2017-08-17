package com.dkt.common.sendpost;

/**
 * 消息推送
 */
public class SendResponse01 {
    /**
     *   type | 类型说明
         -----|---------
         0    | 会诊相关推送
         1    | 好友相关推送
     */
    private String type;

    /**
     * message: 推送消息结构
     */
    private MessageResponse message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MessageResponse getMessage() {
        return message;
    }

    public void setMessage(MessageResponse message) {
        this.message = message;
    }
}
