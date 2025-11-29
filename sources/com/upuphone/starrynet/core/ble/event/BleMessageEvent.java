package com.upuphone.starrynet.core.ble.event;

public class BleMessageEvent {
    private byte[] data;

    public BleMessageEvent(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }
}
