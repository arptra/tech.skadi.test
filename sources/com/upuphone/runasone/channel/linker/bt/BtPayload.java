package com.upuphone.runasone.channel.linker.bt;

public class BtPayload {
    private byte[] byte1;
    private byte[] byte2;

    public BtPayload(byte[] bArr, byte[] bArr2) {
        this.byte1 = bArr;
        this.byte2 = bArr2;
    }

    public byte[] getBypass() {
        return this.byte2;
    }

    public byte[] getSenderId() {
        return this.byte1;
    }
}
