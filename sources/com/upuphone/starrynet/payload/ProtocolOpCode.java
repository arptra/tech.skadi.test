package com.upuphone.starrynet.payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ProtocolOpCode {
    public static final int HID_CLOSE_HID = 52;
    public static final int HID_OPEN_HID = 50;
    public static final int HID_OPEN_HID_CALLBACK = 51;
    public static final int RING_INDICATE_START_OTA = 3;
    public static final int RING_NOTIFY_UPDATE_OTA_STATUS = 4;
    public static final int RING_REQUEST_ALGO_STATE = 21;
    public static final int RING_REQUEST_DEVICE_INFO = 1;
    public static final int RING_REQUEST_DEVICE_MODEL = 23;
    public static final int RING_REQUEST_NAME = 19;
    public static final int RING_REQUEST_REMOTE_MOUSE_STATUS = 5;
    public static final int RING_REQUEST_RING_VERSION = 13;
    public static final int RING_RESPONSE_ALGO_STATE = 22;
    public static final int RING_RESPONSE_DEVICE_INFO = 2;
    public static final int RING_RESPONSE_NAME = 20;
    public static final int RING_RESPONSE_REMOTE_MOUSE_STATUS = 6;
    public static final int RING_RESPONSE_RING_VERSION = 14;
    public static final int RING_SET_BLE_DISCONNECT = 11;
    public static final int RING_SET_IMU_OPERATION = 7;
    public static final int RING_SET_NAME = 17;
    public static final int RING_SET_WORK_MODE = 15;
}
