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
}
