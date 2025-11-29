package com.upuphone.starrynet.core.ble.event;

public class RingBackgroundStateChangeEvent {
    public static final int RING_ACL_ACTIVE_DISCONNECT = 6;
    private String mac;
    private int state;

    public RingBackgroundStateChangeEvent(int i, String str) {
        this.state = i;
        this.mac = str;
    }

    public String getMac() {
        return this.mac;
    }

    public int getState() {
        return this.state;
    }
}
