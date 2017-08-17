package com.dkt.common.sendpost;

/**
 * post发送请求常量
 */
public interface SendConstant {
    /**
     * sendPost请求地址
     */
    String SEND_URL = "http://" +
            "192.168.31.128:8081/push";

    /**
     *   type | 类型说明
         -----|---------
         0    | 会诊相关推送
         1    | 好友相关推送
     */
    String TYPE_ZERO = "0";
    String TYPE_ONES = "1";
}
