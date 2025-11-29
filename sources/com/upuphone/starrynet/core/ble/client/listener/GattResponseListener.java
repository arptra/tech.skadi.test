package com.upuphone.starrynet.core.ble.client.listener;

public interface GattResponseListener {
    public static final int GATT_RESP_CHARACTER_READ = 3;
    public static final int GATT_RESP_CHARACTER_WRITE = 4;
    public static final int GATT_RESP_CONNECT_STATUS_CHANGED = 1;
    public static final int GATT_RESP_DESCRIPTOR_WRITE = 5;
    public static final int GATT_RESP_DISCONNECT = 7;
    public static final int GATT_RESP_READ_RSSI = 6;
    public static final int GATT_RESP_SERVICE_DISCOVER = 2;

    boolean onConnectStatusChanged(boolean z);
}
