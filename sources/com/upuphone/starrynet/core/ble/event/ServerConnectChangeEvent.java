package com.upuphone.starrynet.core.ble.event;

public class ServerConnectChangeEvent {
    private boolean isConnected;
    private String mac;

    public ServerConnectChangeEvent(String str, boolean z) {
        this.mac = str;
        this.isConnected = z;
    }

    public String getMac() {
        return this.mac;
    }

    public boolean isConnected() {
        return this.isConnected;
    }
}
