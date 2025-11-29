package com.upuphone.starrynet.strategy.data;

import com.upuphone.starrynet.api.bean.StDevice;

class AuthMessage {
    private byte[] data;
    private StDevice device;

    public AuthMessage(StDevice stDevice, byte[] bArr) {
        this.device = stDevice;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public StDevice getDevice() {
        return this.device;
    }
}
