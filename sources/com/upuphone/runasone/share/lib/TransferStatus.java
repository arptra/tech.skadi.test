package com.upuphone.runasone.share.lib;

public @interface TransferStatus {
    public static final int BLE_RECEIVER_ACK_TIME_OUT = 6;
    public static final int BLE_SEND_TIMEOUT = 4;
    public static final int BLE_START_SEND_TIME_OUT = 5;
    public static final int RECEIVER_END_TIMEOUT = 2;
    public static final int RECEIVER_TIME_OUT_DISCONNECT = 8;
    public static final int SEND_SUCCESS_TIME_OUT = 7;
    public static final int START_RECEIVER_TIMEOUT = 3;
    public static final int START_SEND_TIMEOUT = 1;
}
