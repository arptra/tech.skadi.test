package com.upuphone.starrynet.core.ble.event;

public class OpenGattServerEvent {
    private boolean isReady;

    public OpenGattServerEvent(boolean z) {
        this.isReady = z;
    }

    public boolean isReady() {
        return this.isReady;
    }
}
