package com.upuphone.starrynet.strategy.pair.ble;

public class BleClientPairEvent {
    private String mMac;
    private byte[] mValue;

    public BleClientPairEvent(String str, byte[] bArr) {
        this.mMac = str;
        this.mValue = bArr;
    }

    public String getMac() {
        return this.mMac;
    }

    public byte[] getValue() {
        return this.mValue;
    }
}
