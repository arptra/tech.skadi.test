package com.upuphone.starrynet.core.ble.event;

public class DisconnectRingEvent {
    private String bleMac;

    public DisconnectRingEvent(String str) {
        this.bleMac = str;
    }

    public String getBleMac() {
        return this.bleMac;
    }
}
