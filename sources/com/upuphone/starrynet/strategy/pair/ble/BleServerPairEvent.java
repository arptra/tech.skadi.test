package com.upuphone.starrynet.strategy.pair.ble;

public class BleServerPairEvent {
    private String mBleMac;
    private byte[] mData;

    public BleServerPairEvent(byte[] bArr, String str) {
        this.mData = bArr;
        this.mBleMac = str;
    }

    public String getBleMac() {
        return this.mBleMac;
    }

    public byte[] getData() {
        return this.mData;
    }
}
