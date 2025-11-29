package com.upuphone.starrynet.core.ble.event;

public class ClientConnectChangeEvent {
    private int gattStatus;
    private boolean isConnected;
    private String mac;

    public ClientConnectChangeEvent(boolean z, String str) {
        this.isConnected = z;
        this.mac = str;
    }

    public int getGattStatus() {
        return this.gattStatus;
    }

    public String getMac() {
        return this.mac;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public ClientConnectChangeEvent(boolean z, String str, int i) {
        this.isConnected = z;
        this.mac = str;
        this.gattStatus = i;
    }
}
