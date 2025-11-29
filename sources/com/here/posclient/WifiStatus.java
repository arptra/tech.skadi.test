package com.here.posclient;

public enum WifiStatus {
    Unknown(0),
    Disabled(1),
    Disconnected(2),
    Connected(3);
    
    public final int value;

    private WifiStatus(int i) {
        this.value = i;
    }

    public static WifiStatus fromInt(int i) {
        for (WifiStatus wifiStatus : values()) {
            if (wifiStatus.value == i) {
                return wifiStatus;
            }
        }
        throw new RuntimeException("Unknown Wi-Fi status: " + i);
    }
}
