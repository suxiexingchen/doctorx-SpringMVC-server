package com.dkt.common;

/**
 * Created by litai on 2017/6/14.
 */
public interface SysConst {

    String STATUS_SUCCESS = "SUCCESS";

    String STATUS_ERROR = "ERROR";

    /**登录用户角色*/
    /**
     * 医生.
     */
    String ROLE_DOCTOR = "2";

    /**账号锁定状态*/
    /**
     * 锁定.
     */
    String OPER_STATUS_LOCKED = "0";

    /**登录异常-暂定*/
    /**
     * 用户名密码不存在.
     */
    String LOGIN_ERROR_UNEXIST = "userUnExist";
    /**
     * 账号永久锁定.
     */
    String LOGIN_ERROR_LOCKED_FOREVER = "accountLockedForever";
    /**
     * 未知异常
     */
    String LOGIN_ERROR_UNKNOW = "error";

    /**
     * 待确认.
     */
    String CONSULTATION_STATUS_WAIT = "0";

    /**会诊状态*/
    /**
     * 待确认.
     */
    String CONSULTATION_STATUS_WAIT_CHECK = "0";
    /**
     * 5-待会诊
     */
    String CONSULTATION_STATUS_WAIT_CONSULTATION ="5";
    /**
     * 会诊中.
     */
    String CONSULTATION_STATUS_ING = "10";
    /**
     * 已完成.
     */
    String CONSULTATION_STATUS_FINISH = "15";

    /**会诊意见读取状态*/
    /**
     * 未读.
     */
    String CONSULTATION_VIEW_FLAG_NO = "0";

    /**会诊读取状态*/
    /**
     * 未读.
     */
    String CONSULTATION_APPT_VIEW_FLAG_NO = "0";
    /**
     * 已读.
     */
    String CONSULTATION_APPT_VIEW_FLAG_YES = "1";

    /**终端类型*/
    /**
     * 手机APP
     */
    String DEV_TYPE_APP = "1";
    /**
     * TV
     */
    String DEV_TYPE_TV = "2";
    /**
     * 应用程序是否发行 0不发行
     */
    Integer ISSUE_FALSE=0;
    /**
     * 应用程序是否发行 1发行
     */
    Integer ISSUE_TRUE=1;

    /**
     * 需要创建的视频类型：xy：小鱼易连；
     */
    String VIDEOTYPE_XY="xy";

    /**
     * programType栏目类型：1-网络学院，2-慢性病管理
     */
     String programType_INTERNETCollege="1";
     String programType_CHRONICDISEASE="2";


    /**
     * 推送服务的notification_title标题
     */
    String JPUSH_NOTIFICATION_TITLE="万家医视";

    /**
     * 此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
     */
    Boolean APNS_ENVIRONMENT=true;

    /**
     * 环境地址配置
     */
    //String  PREFIX_URL="http://10.63.64.70:8099/dkt/";//河南有线地址
    //String  PREFIX_URL="http://192.168.31.78:8080/";//本地测试地址
    String  PREFIX_URL="http://api.wanjiayishi.com/dkt/";//本地测试地址
}
