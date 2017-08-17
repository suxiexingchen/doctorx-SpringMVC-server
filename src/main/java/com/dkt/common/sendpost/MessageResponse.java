package com.dkt.common.sendpost;

/**
 * 推送消息结构
 */
public class MessageResponse {

    /**
     * groupId  | 分组id，用于组播,如若取值0，则依靠clientId来判别广播、单播
     */
    private String groupId;

    /**
     * clientId | 客户端唯一标识，用于单播, 若取值为0，则为广播或组播
     */
    private String clientId;

    /**
     * notifyCount | 用于标识本次推送相关的消息未读个数
     */
    private String notifyCount;

    /**
     * content | 推送正文，包含客户端内容显示及逻辑控制等信息
     */
    private ContentResponse content;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(String notifyCount) {
        this.notifyCount = notifyCount;
    }

    public ContentResponse getContent() {
        return content;
    }

    public void setContent(ContentResponse content) {
        this.content = content;
    }
}
