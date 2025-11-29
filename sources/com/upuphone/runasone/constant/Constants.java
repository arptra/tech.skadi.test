package com.upuphone.runasone.constant;

public class Constants {
    public static final String DEVICE_CONNECT_CHANGEDBR = "com.upuphone.starrynet.device.changed";
    public static final String DEVICE_ID = "deviceId";
    public static final String INVALID_SESSION = "invalid_session";
    public static final String INVALID_STR = "invalid_str";
    public static final String PROTOCOL_VERSION = "1.2";
    public static final long RPC_KEEP_ALIVE_TIME = 5;
    public static final String STARRYNET_LOG = "com.upuphone.starrynet.log";
    public static final String STR_TIMESTAMP = "timestamp-";
    public static final int TIMEOUT_AUTH = 5000;
    public static final int TIMEOUT_GRPC_ACK = 2000;

    public class ChannelErrorCode {
        public static final int ERROR_CHANNEL_INVALID = 204007;
        public static final int ERROR_MISS_DEVICE_INFO = 204008;
        public static final int ERROR_RPC_ALIVE_TIMEOUT = 204003;
        public static final int ERROR_RPC_AUTH_PARAMETER_ERROR = 204004;
        public static final int ERROR_RPC_AUTH_TIMEOUT = 204002;
        public static final int ERROR_RPC_HAND_SHAKER_ERROR = 204005;
        public static final int ERROR_RPC_LINK_ERROR = 204001;
        public static final int ERROR_RPC_UNREACHABLE_ERROR = 204006;
        public static final int ERROR_SLICE_OVER_LIMIT = 204100;
        public static final int SUCCESS = 0;
        public static final String TEXT_ERROR_CHANNEL_INVALID = "通道不存在";
        public static final String TEXT_ERROR_RPC_ALIVE_TIMEOUT = "通道心跳超时";
        public static final String TEXT_ERROR_RPC_AUTH_PARAMETER = "通道鉴权参数错误";
        public static final String TEXT_ERROR_RPC_AUTH_TIMEOUT = "通道鉴权超时";
        public static final String TEXT_ERROR_RPC_HAND_SHAKER = "通道握手失败";
        public static final String TEXT_ERROR_RPC_LINK = "通道连接异常";
        public static final String TEXT_ERROR_RPC_UNREACHABLE = "通道不可达";
        public static final String TEXT_ERROR_SLICE_OVER_LIMIT = "消息切片大小超出限制";
        public static final String TEXT_MISS_DEVICE_INFO = "对端设备信息不存在(一般由于onP2pGoConnected回调delay)";

        public ChannelErrorCode() {
        }
    }
}
