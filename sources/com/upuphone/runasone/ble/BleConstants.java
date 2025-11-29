package com.upuphone.runasone.ble;

import java.util.UUID;

public class BleConstants {
    public static final String ACTION = "starrynet.intent.action.BLE";
    private static final int BASE_CODE = 206000;
    public static final int BLUETOOTH_DISABLED = 206017;
    public static final int CANCEL_REQUEST = 206016;
    public static final UUID DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final int DISCOVERY_GATT_SERVICE_FAIL = 206018;
    public static final String EXTRA_DEVICE = "BleDevice";
    public static final String EXTRA_MESSAGE = "BleMessage";
    public static final String EXTRA_MESSAGE1 = "NotifyUUID";
    public static final String EXTRA_MESSAGE2 = "Value";
    public static final String EXTRA_TYPE = "BleType";
    public static final int GATT_CHARACTER_NOTIFICATION_FAIL = 206009;
    public static final int GATT_CHARACTER_NOTIFY_DESCRIPTOR_FAIL = 206010;
    public static final int GATT_CHARACTER_NOT_SUPPORT_NOTIFY = 206006;
    public static final int GATT_CHARACTER_NOT_SUPPORT_READ = 206005;
    public static final int GATT_CHARACTER_NOT_SUPPORT_WRITE = 206004;
    public static final int GATT_CHARACTER_READ_FAIL = 206008;
    public static final int GATT_CHARACTER_WRITE_FAIL = 206007;
    public static final int GATT_NOT_CONNECTED = 206011;
    public static final int GATT_NOT_EXIST = 206001;
    public static final int GATT_NOT_EXIST_CHARACTER = 206003;
    public static final int GATT_REQUEST_TIMEOUT = 206002;
    public static final int INVALID_MTU_SIZE = 206015;
    public static final int NOT_SET_DEFAULT_SERVICE_UUID = 206013;
    public static final int NOT_SUPPORT_BLE = 206012;
    public static final int REQUEST_MTU_FAIL = 206014;
    public static final UUID SERVICE_DATA_UUID1 = UUID.fromString("00000001-0000-1000-8000-00805f9b34fb");
    public static final UUID SERVICE_DATA_UUID2 = UUID.fromString("00000002-0000-1000-8000-00805f9b34fb");
    public static final UUID SERVICE_UUID = UUID.fromString("00000bd3-0000-1000-8000-00805f9b34fb");
    public static final String URL = "starrynet://com.flyme.auto/";
    public static final int WRITE_DATA_IS_EMPTY = 206020;
    public static final int WRITE_DATA_LENGTH_OUT_OF_MTU_SIZE = 206019;
}
