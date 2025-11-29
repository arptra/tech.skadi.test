package com.upuphone.runasone.relay.error;

import java.util.HashMap;
import java.util.Map;

public class RelayErrorCode {
    public static final int APP_NOT_INSTALL = 203007;
    public static final String APP_NOT_INSTALL_TEXT = "对端设备未安装应用或应用未集成sdk";
    public static final int APP_UNINSTALL = 203008;
    public static final String APP_UNINSTALL_TEXT = "对端设备应用被卸载";
    public static final int BINDER_DIED = 203017;
    public static final String BINDER_DIED_TEXT = "binder调用失败，进程假死或binder传输超限";
    public static final int BINDER_ERROR = 203010;
    public static final String BINDER_ERROR_TEXT = "binder未连接";
    public static final int BINDER_UN_CONNECT = 203002;
    public static final String BINDER_UN_CONNECT_TEXT = "对端应用已关闭";
    public static final int DEVICE_DISCONNECT = 203006;
    public static final String DEVICE_DISCONNECT_TEXT = "设备断开连接";
    public static final int DEVICE_ERROR = 203101;
    public static final String DEVICE_ERROR_TEXT = "未找到设备,请查看设备连接状态";
    public static final int EMERGENCY_TOO_LONG = 203015;
    public static final String EMERGENCY_TOO_LONG_TEXT = "紧急消息太大，超过上限";
    public static final int MAPPING_ERROR = 203013;
    public static final String MAPPING_ERROR_TEXT = "AppUnitCode映射数据未找到";
    public static final int MESSAGE_IS_NULL = 203011;
    public static final String MESSAGE_IS_NULL_TEXT = "发送的消息为空";
    public static final int MSG_OVER_POOL = 203016;
    public static final String MSG_OVER_POOL_TEXT = "异步发送消息，缓存数量超限";
    public static final int MSG_TOO_LONG = 203009;
    public static final String MSG_TOO_LONG_TEXT = "消息过长，请先连接P2P";
    public static final int NOT_FOUND_ACTIVITY = 203004;
    public static final String NOT_FOUND_ACTIVITY_TEXT = "没有找到对应的activity";
    public static final int NOT_FOUND_SERVICE = 203014;
    public static final String NOT_FOUND_SERVICE_TEXT = "没有找到对应的service，或service启动失败";
    public static final int SEND_MESSAGE_TIMEOUT = 203005;
    public static final String SEND_MESSAGE_TIMEOUT_TEXT = "发送消息超时，请检查连接状态";
    public static final int STARRY_TAG_IS_NULL = 203012;
    public static final String STARRY_TAG_IS_NULL_TEXT = "StarryTag对象为空";
    public static final int START_REMOTE_TIMEOUT = 203003;
    public static final String START_REMOTE_TIMEOUT_TEXT = "开启超时，请检查连接状态";
    public static final int UN_INIT = 203001;
    public static final String UN_INIT_TEXT = "对端设备回调接口未注册";
    private static final Map<Integer, String> map;

    static {
        HashMap hashMap = new HashMap();
        map = hashMap;
        hashMap.put(Integer.valueOf(UN_INIT), UN_INIT_TEXT);
        hashMap.put(Integer.valueOf(BINDER_UN_CONNECT), BINDER_UN_CONNECT_TEXT);
        hashMap.put(Integer.valueOf(DEVICE_ERROR), DEVICE_ERROR_TEXT);
        hashMap.put(Integer.valueOf(START_REMOTE_TIMEOUT), START_REMOTE_TIMEOUT_TEXT);
        hashMap.put(Integer.valueOf(NOT_FOUND_ACTIVITY), NOT_FOUND_ACTIVITY_TEXT);
        hashMap.put(Integer.valueOf(SEND_MESSAGE_TIMEOUT), SEND_MESSAGE_TIMEOUT_TEXT);
        hashMap.put(Integer.valueOf(DEVICE_DISCONNECT), DEVICE_DISCONNECT_TEXT);
        hashMap.put(Integer.valueOf(APP_NOT_INSTALL), APP_NOT_INSTALL_TEXT);
        hashMap.put(Integer.valueOf(APP_UNINSTALL), APP_UNINSTALL_TEXT);
        hashMap.put(Integer.valueOf(MSG_TOO_LONG), MSG_TOO_LONG_TEXT);
        hashMap.put(Integer.valueOf(BINDER_ERROR), BINDER_ERROR_TEXT);
        hashMap.put(Integer.valueOf(MESSAGE_IS_NULL), MESSAGE_IS_NULL_TEXT);
        hashMap.put(Integer.valueOf(STARRY_TAG_IS_NULL), STARRY_TAG_IS_NULL_TEXT);
        hashMap.put(Integer.valueOf(MAPPING_ERROR), MAPPING_ERROR_TEXT);
        hashMap.put(Integer.valueOf(NOT_FOUND_SERVICE), NOT_FOUND_SERVICE_TEXT);
        hashMap.put(Integer.valueOf(EMERGENCY_TOO_LONG), EMERGENCY_TOO_LONG_TEXT);
    }

    public static String getErrorText(int i) {
        return map.get(Integer.valueOf(i));
    }
}
