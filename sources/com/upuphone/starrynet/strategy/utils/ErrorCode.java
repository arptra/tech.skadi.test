package com.upuphone.starrynet.strategy.utils;

public final class ErrorCode {
    public static final int CHANNEL_WRITE_IS_NULL = 8;
    public static final int MESSAGE_CATEGORY_NOT_READY = 9;
    public static final int MESSAGE_CHANNEL_WRITER_NOT_READY = 2;
    public static final int MESSAGE_CLIENT_CANNOT_FIND_DEVICE = 5;
    public static final int MESSAGE_CONTENT_IS_EMPTY = 7;
    public static final int MESSAGE_GATT_CLIENT_NOT_READY = 4;
    public static final int MESSAGE_GATT_SERVER_IS_DISCONNECTED = 3;
    public static final int MESSAGE_IS_NULL = 6;
    public static final int MESSAGE_PARAMS_INVALID = 1;
    public static final int MESSAGE_SUCCESS = 0;
    public static final int SPP_CLIENT_BT_MAC_IS_EMPTY = 20;
    public static final int SPP_CLIENT_IS_EMPTY = 21;
    public static final int SPP_CLIENT_MESSAGE_CONTENT_IS_NULL = 23;
    public static final int SPP_CLIENT_NOT_CONNECTED = 22;
    public static final int SPP_CLIENT_SEND_MESSAGE_TIMEOUT = 24;
    public static final int SPP_MESSAGE_WRITE_HANDLER_NOT_READY = 40;
    public static final int SPP_MESSAGE_WRITE_IO_EXCEPTION = 42;
    public static final int SPP_MESSAGE_WRITE_OS_IS_NULL = 41;
    public static final int SPP_SERVER_IS_EMPTY = 30;
    public static final int SPP_SERVER_NOT_CONNECTED_BY_SPECIAL_BT_MAC = 31;
    public static final int SPP_SERVER_SEND_MESSAGE_CONTENT_IS_NULL = 32;
    public static final int SPP_SERVER_SEND_MESSAGE_TIMEOUT = 33;

    private ErrorCode() {
    }
}
