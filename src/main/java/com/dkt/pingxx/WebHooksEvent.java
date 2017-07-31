package com.dkt.pingxx;

/**
 * Created by linkd on 2017/7/5.
 */
public class WebHooksEvent {
    //事件对象  id ，由 Ping++ 生成，28 位长度字符串
    private String id;
    //事件发生的时间
    private long created;
    //事件是否发生在生产环境
    private boolean livemode;
    //事件类型
    /**
     * summary.daily.available	上一天 0 点到 23 点 59 分 59 秒的交易金额和交易量统计，在每日 04:00 点左右触发。
     summary.weekly.available	上周一 0 点至上周日 23 点 59 分 59 秒的交易金额和交易量统计，在每周一 04:00 点左右触发。
     summary.monthly.available	上月一日 0 点至上月末 23 点 59 分 59 秒的交易金额和交易量统计，在每月一日 04:00 点左右触发。
     charge.succeeded	支付对象，支付成功时触发。
     refund.succeeded	退款对象，退款成功时触发。
     transfer.succeeded	企业支付对象，支付成功时触发。
     red_envelope.sent	红包对象，红包发送成功时触发。
     red_envelope.received	红包对象，红包接收成功时触发。
     batch_transfer.succeeded	批量企业付款对象，批量企业付款成功时触发。
     customs.succeeded	报关对象，报关成功时触发。
     batch_refund.succeeded	批量退款对象，批量退款成功时触发
     */
    private String type;
    //绑定在事件上的数据对象
    private Data data;
    //值为 "event"
    private String object;
    //推送未成功的 webhooks 数量
    private int pending_webhooks;
    //API Request ID。值 "null" 表示该事件不是由 API 请求触发的
    private String request;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public void setLivemode(boolean livemode) {
        this.livemode = livemode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getPending_webhooks() {
        return pending_webhooks;
    }

    public void setPending_webhooks(int pending_webhooks) {
        this.pending_webhooks = pending_webhooks;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    private class Data{
        private Object object;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }

    private class Object{
        //应用  ID
        private String app_id;
        //对象类型
        private String object;
        //应用名称
        private String app_display_name;
        //创建时间（timestamp）
        private long created;
        //统计起始时间（timestamp）
        private long summary_from;
        //统计终止时间（timestamp）
        private long summary_to;
        //交易金额（单位：分）
        private int charges_amount;
        //交易量（笔）
        private int charges_count;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getApp_display_name() {
            return app_display_name;
        }

        public void setApp_display_name(String app_display_name) {
            this.app_display_name = app_display_name;
        }

        public long getCreated() {
            return created;
        }

        public void setCreated(long created) {
            this.created = created;
        }

        public long getSummary_from() {
            return summary_from;
        }

        public void setSummary_from(long summary_from) {
            this.summary_from = summary_from;
        }

        public long getSummary_to() {
            return summary_to;
        }

        public void setSummary_to(long summary_to) {
            this.summary_to = summary_to;
        }

        public int getCharges_amount() {
            return charges_amount;
        }

        public void setCharges_amount(int charges_amount) {
            this.charges_amount = charges_amount;
        }

        public int getCharges_count() {
            return charges_count;
        }

        public void setCharges_count(int charges_count) {
            this.charges_count = charges_count;
        }
    }
}
