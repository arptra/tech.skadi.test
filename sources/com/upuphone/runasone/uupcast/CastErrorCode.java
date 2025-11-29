package com.upuphone.runasone.uupcast;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class CastErrorCode {
    public static final int BOTH_NOT_SUPPORT_FEATURE = -516;
    public static final int CHECK_NOT_SUPPORT_FEATURE = -517;
    private static final Map<Integer, String> ERROR_INFO_MAP;
    public static final int INTERNAL_ERROR_ILLEGAL_ARGUMENT = Integer.MIN_VALUE;
    public static final int OPERATION_FAILURE = -502;
    public static final int SESSION_STATE_ILLEGAL = -501;
    public static final int SINK_ALPHA_INIT_ERROR = -39;
    public static final int SINK_ALREADY_ON_GOING = -506;
    public static final int SINK_API_LEVEL_INCOMPATIBLE = -38;
    public static final int SINK_AUDIO_DECODER_INIT_ERROR = -33;
    public static final int SINK_AUDIO_DECODE_ERROR = -35;
    public static final int SINK_AUDIO_TRACK_INIT_ERROR = -32;
    public static final int SINK_DEVICE_DETACHED = -504;
    public static final int SINK_HEART_BEAT_TIMEOUT_ERROR = -37;
    public static final int SINK_IP_ADDRESS_MALFORMED = -510;
    public static final int SINK_MEDIA_SERVER_RECEIVE_ERROR = -31;
    public static final int SINK_NOT_SUPPORT_FEATURE = -515;
    public static final int SINK_SESSION_NOT_FOUND = -507;
    public static final int SINK_SOCKET_CLIENT_ERROR = -30;
    @Deprecated
    public static final int SINK_SURFACE_NOT_SET = -513;
    public static final int SINK_VIDEO_DECODER_INIT_ERROR = -34;
    public static final int SINK_VIDEO_DECODE_ERROR = -36;
    public static final int SINK_WIFI_NOT_ENABLED = -503;
    public static final int SOURCE_ALREADY_ON_GOING = -506;
    public static final int SOURCE_API_LEVEL_INCOMPATIBLE = -13;
    public static final int SOURCE_AUDIO_ENCODER_INIT_ERROR = -5;
    public static final int SOURCE_AUDIO_ENCODE_ERROR = -7;
    public static final int SOURCE_AUDIO_RECORD_READ_ERROR = -12;
    public static final int SOURCE_BINDER_DIED = -505;
    public static final int SOURCE_CAMERA_DISCONNECT_ERROR = -11;
    public static final int SOURCE_CREATE_AUDIO_RECORD_ERROR = -4;
    public static final int SOURCE_CREATE_VIRTUAL_DISPLAY_ERROR = -2;
    public static final int SOURCE_DEVICE_DETACHED = -504;
    @Deprecated
    public static final int SOURCE_DEVICE_NOT_ATTACHED = -504;
    public static final int SOURCE_HEART_BEAT_TIMEOUT_ERROR = -9;
    public static final int SOURCE_NOT_SUPPORT_FEATURE = -514;
    public static final int SOURCE_OPEN_CAMERA_ERROR = -3;
    public static final int SOURCE_PEER_ALREADY_ON_GOING = -509;
    public static final int SOURCE_PEER_CHECK_IP_ADDRESS_MALFORMED = -510;
    public static final int SOURCE_PEER_DEVICE_NOT_ATTACHED = -512;
    public static final int SOURCE_PEER_LISTENER_NOT_SET = -511;
    public static final int SOURCE_PEER_NO_MATCHED_SESSION_TAG = -508;
    public static final int SOURCE_SESSION_NOT_FOUND = -507;
    public static final int SOURCE_SOCKET_SERVER_ERROR = -1;
    public static final int SOURCE_VIDEO_ENCODER_INIT_ERROR = -6;
    public static final int SOURCE_VIDEO_ENCODE_ERROR = -8;
    public static final int SOURCE_WAIT_SINK_CONNECTION_TIMEOUT_ERROR = -10;
    public static final int SOURCE_WIFI_NOT_ENABLED = -503;
    public static final int SUCCESS = 0;

    static {
        HashMap hashMap = new HashMap();
        ERROR_INFO_MAP = hashMap;
        hashMap.put(0, "操作成功");
        hashMap.put(-1, "Source 端Socket服务错误");
        hashMap.put(-2, "Source 端创建VirtualDisplay错误");
        hashMap.put(-3, "Source 端打开相机错误");
        hashMap.put(-4, "Source 端创建AudioRecord错误");
        hashMap.put(-5, "Source 端音频编码器初始化错误");
        hashMap.put(-6, "Source 端视频编码器初始化错误");
        hashMap.put(-7, "Source 端音频编码错误");
        hashMap.put(-8, "Source 端视频编码错误");
        hashMap.put(-9, "Source 端投屏心跳超时");
        hashMap.put(-10, "Source 端Socket服务等待Sink端连接超时");
        hashMap.put(-11, "Source 端相机断开");
        hashMap.put(-12, "Source 端音频读取错误");
        hashMap.put(-13, "Source 端检测ApiLevel不兼容");
        hashMap.put(-30, "Sink 端Socket客户端错误");
        hashMap.put(-31, "Sink 端媒体服务接收数据错误");
        hashMap.put(-32, "Sink 端初始化AudioTrack错误");
        hashMap.put(-33, "Sink 端音频解码器初始化错误");
        hashMap.put(-34, "Sink 端视频解码器初始化错误");
        hashMap.put(-35, "Sink 端音频解码错误");
        hashMap.put(-36, "Sink 端视频解码错误");
        hashMap.put(-37, "Sink 端投屏心跳超时");
        hashMap.put(-38, "Sink 端检测ApiLevel不兼容");
        hashMap.put(-39, "Sink 端alpha通道渲染环境初始化错误");
        hashMap.put(Integer.valueOf(SESSION_STATE_ILLEGAL), "投屏会话状态非法");
        hashMap.put(Integer.valueOf(OPERATION_FAILURE), "操作失败");
        hashMap.put(-503, "wifi未打开");
        hashMap.put(-504, "设备断连");
        hashMap.put(Integer.valueOf(SOURCE_BINDER_DIED), "Source 端binder died");
        hashMap.put(-506, "正在投屏中");
        hashMap.put(-507, "投屏实例未找到");
        hashMap.put(Integer.valueOf(SOURCE_PEER_NO_MATCHED_SESSION_TAG), "Source 端实例标签Sink无匹配的投屏实例");
        hashMap.put(Integer.valueOf(SOURCE_PEER_ALREADY_ON_GOING), "Source 端发起投屏Sink端正在投屏中");
        hashMap.put(-510, "ip地址校验错误");
        hashMap.put(Integer.valueOf(SOURCE_PEER_LISTENER_NOT_SET), "Source 端错误，Sink端未设置投屏监听");
        hashMap.put(Integer.valueOf(SOURCE_PEER_DEVICE_NOT_ATTACHED), "Source 端错误，Sink端设备断连");
        hashMap.put(Integer.valueOf(SINK_SURFACE_NOT_SET), "Sink 端未设置Surface");
        hashMap.put(Integer.valueOf(SOURCE_NOT_SUPPORT_FEATURE), "Source 端不支持特性");
        hashMap.put(Integer.valueOf(SINK_NOT_SUPPORT_FEATURE), "Sink 端不支持特性");
        hashMap.put(Integer.valueOf(BOTH_NOT_SUPPORT_FEATURE), "双 端不支持特性");
        hashMap.put(Integer.valueOf(CHECK_NOT_SUPPORT_FEATURE), "检查不被支持的特性");
    }

    @NonNull
    public static String getErrorDesc(int i) {
        String str = ERROR_INFO_MAP.get(Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "未知错误码:" + i;
    }
}
