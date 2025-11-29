package com.upuphone.starrynet.core.ble.event;

public class ExternalClientConnectionChangeEvent {
    private boolean isConnected;
    private String mac;

    public ExternalClientConnectionChangeEvent(boolean z, String str) {
        this.isConnected = z;
        this.mac = str;
    }

    public String getMac() {
        return this.mac;
    }

    public boolean isConnected() {
        return this.isConnected;
    }
}
