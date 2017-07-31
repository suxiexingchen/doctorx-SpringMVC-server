package com.platform.base;

public interface SysConst {

    /**
     * 日期格式 ：yyyyMM
     */
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    /**
     * 日期格式 ：yyyyMMdd
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    /**
     * 日期格式 :yyyyMMddHHmmss
     */
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**
     * 日期格式 : yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式 : yyyy-MM-dd HH:mm
     */
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /**
     * 日期格式 : yyyy-MM-dd
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 请求返回结果 成功
     */
    public static final String RESULT_BEAN_STATE_PASS = "1";

    /**
     * 请求返回结果 失败
     */
    public static final String RESULT_BEAN_STATE_FAIL = "0";

    /**
     * session中存储的用户信息key
     */
    public static final String SESSION_USER_NAME = "sysUserSessionInfo";

    /**
     * 系统根路径存储名称
     */
    public static final String SYSTEM_ROOT_PATH = "platform.root";

    /**
     * 系统用户默认密码
     * 111111
     */
    public static final String SYSTEM_DEFAULT_PASSWORD = "96e79218965eb72c92a549dd5a330112";

    /**
     * UTF-8编码
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 删除标志 删除
     */
    public static final String DICT_DELETE_YES = "0";

    /**
     * 删除标志 未删除
     */
    public static final String DICT_DELETE_NO = "1";

}
