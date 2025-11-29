package com.here.sdk.trafficbroadcast;

public final class RDSEncryptionKey {
    public short encryptionId;
    public short rotateRight;
    public short startBit;
    public short xorValue;

    public RDSEncryptionKey(short s, short s2, short s3, short s4) {
        this.encryptionId = s;
        this.rotateRight = s2;
        this.startBit = s3;
        this.xorValue = s4;
    }
}
