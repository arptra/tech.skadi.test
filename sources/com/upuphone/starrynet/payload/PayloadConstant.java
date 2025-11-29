package com.upuphone.starrynet.payload;

import java.util.UUID;

public class PayloadConstant {
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_OPCODE = "opcode";
    public static final String KEY_PARAMS = "params";
    public static final int OTA_STATE_ON_CANNOT_ENABLE_OTA = 6;
    public static final int OTA_STATE_ON_FILE_COMPLETED = 3;
    public static final int OTA_STATE_ON_SENDING_DATA = 2;
    public static final int OTA_STATE_ON_START = 1;
    public static final int OTA_STATE_ON_UPGRADE_FAIL = 4;
    public static final String PARAMS_KEY_BL_REMOTE_MOUSE_STATUS = "is_open";
    public static final String PARAMS_KEY_CALLBACK_CODE = "code";
    public static final String PARAMS_KEY_CALLBACK_MSG = "msg";
    public static final String PARAMS_KEY_DEVICE_MODEL = "model";
    public static final String PARAMS_KEY_HID_TYPE = "hid_type";
    public static final String PARAMS_KEY_IDENTIFIER = "identifier";
    public static final String PARAMS_KEY_INT_BATTERY = "battery";
    public static final String PARAMS_KEY_INT_HARD_VERSION = "hw_version";
    public static final String PARAMS_KEY_INT_IMU_OPERATION = "operate";
    public static final String PARAMS_KEY_INT_OTA_PROGRESS = "progress";
    public static final String PARAMS_KEY_INT_OTA_STATE = "ota_state";
    public static final String PARAMS_KEY_NAME = "name";
    public static final String PARAMS_KEY_STATE = "state";
    public static final String PARAMS_KEY_STR_DEVICE_ID = "device_id";
    public static final String PARAMS_KEY_STR_FW_VERSION = "fw_version";
    public static final String PARAMS_KEY_STR_OTA_FILE_URL = "file_url";
    public static final String PARAMS_KEY_STR_SN = "sn";
    public static final String PARAMS_KEY_WORK_MODE = "work_mode";
    public static final int PAYLOAD_MESSAGE_TYPE_HID_TOUCH = 2;
    public static final int PAYLOAD_MESSAGE_TYPE_NEED_WRAPPER = 1;
    public static final int PAYLOAD_MESSAGE_TYPE_WRITE_DIRECTLY = 0;
    public static final int RING_WORK_MODE_DRAG = 3;
    public static final int RING_WORK_MODE_FLY_MOUSE = 1;
    public static final int RING_WORK_MODE_NORMAL = 2;
    public static final UUID STARRY_NET_PAYLOAD_HID_CHARACTER_UUID = UUIDUtils.makeUUID(8224);
    public static final UUID STARRY_NET_PAYLOAD_HID_SERVICE_UUID = UUIDUtils.makeUUID(3024);
    public static final UUID STARRY_NET_PAYLOAD_RING_CHARACTER_UUID = UUIDUtils.makeUUID(65297);
    public static final UUID STARRY_NET_PAYLOAD_RING_SERVICE_UUID = UUIDUtils.makeUUID(65296);
}
