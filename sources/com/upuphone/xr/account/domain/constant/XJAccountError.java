package com.upuphone.xr.account.domain.constant;

public class XJAccountError {
    public static final int ERROR_AUTH_TOKEN = 10011;
    public static final String ERROR_CLIENT = "A0001";
    public static final String ERROR_CUR_VERSION = "A0800";
    public static final String ERROR_DATABASE = "C0300";
    public static final int ERROR_DATA_ERROR = 10015;
    public static final String ERROR_DEVICE = "A1000";
    public static final String ERROR_EXECUTE = "B0001";
    public static final String ERROR_EXECUTE_TIMEOUT = "B0100";
    public static final String ERROR_FAULT_TOLERANCE_TRIGGER = "B0200";
    public static final String ERROR_HTTP = "C0600";
    public static final String ERROR_LOGIN = "A0200";
    public static final String ERROR_MID_SERVICE = "C0100";
    public static final int ERROR_NET_REQUEST = 10014;
    public static final String ERROR_NONE = "00000";
    public static final String ERROR_NOTIFICATION = "C0500";
    public static final int ERROR_PARAM_EMPTY = 10018;
    public static final int ERROR_PASSWORD_STATE = 10016;
    public static final String ERROR_PRIVACY_NOT_AUTH = "A0900";
    public static final String ERROR_REGISTER = "A0100";
    public static final String ERROR_REQUEST_PARAMS = "A0400";
    public static final String ERROR_REQUEST_SERVICE = "A0500";
    public static final String ERROR_RESOURCE = "A0600";
    public static final int ERROR_SERVER = 10017;
    public static final String ERROR_SYSTEM_RESOURCE = "B0300";
    public static final String ERROR_THIRD_FAULT_TOLERANCE_TRIGGER = "C0400";
    public static final String ERROR_THIRD_SERVICE = "C0001";
    public static final String ERROR_THIRD_TIMEOUT = "C0200";
    public static final int ERROR_TOKEN_EMPTY = 10012;
    public static final int ERROR_TOKEN_INVALID = 10013;
    public static final String ERROR_UPLOAD_FILE = "A0700";
    public static final String ERROR_VISIT_PERMISSION = "A0300";

    public static String info(int i, String str) {
        switch (i) {
            case 10011:
                return "SDK授权出现异常，错误信息:" + str;
            case 10012:
                return "SDK请求TOKEN为空";
            case ERROR_TOKEN_INVALID /*10013*/:
                return "SDK请求TOKEN过期";
            case ERROR_NET_REQUEST /*10014*/:
                return "SDK请求异常，错误信息：" + str;
            case ERROR_DATA_ERROR /*10015*/:
                return "SDK数据异常，错误信息：" + str;
            case ERROR_PASSWORD_STATE /*10016*/:
                return "SDK获取是否设置密码异常，错误信息：" + str;
            case ERROR_SERVER /*10017*/:
                return "系统服务异常，错误信息：" + str;
            default:
                return "错误未定义";
        }
    }
}
