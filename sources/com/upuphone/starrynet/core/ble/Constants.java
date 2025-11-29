package com.upuphone.starrynet.core.ble;

public class Constants {
    public static final int STATUS_DEVICE_CONNECTED = 2;
    public static final int STATUS_DEVICE_CONNECTING = 1;
    public static final int STATUS_DEVICE_DISCONNECTED = 0;
    public static final int STATUS_DEVICE_DISCONNECTING = 3;
    public static final int STATUS_DEVICE_SERVICE_READY = 19;

    private Constants() {
    }

    public static String getStatusText(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 19 ? String.format("Unknown %d", new Object[]{Integer.valueOf(i)}) : "Service Ready" : "Disconnecting" : "Connected" : "Connecting" : "Disconnected";
    }
}
