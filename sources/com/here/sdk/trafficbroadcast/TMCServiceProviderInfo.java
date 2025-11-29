package com.here.sdk.trafficbroadcast;

public final class TMCServiceProviderInfo {
    public short countryCode;
    public short encryptionId;
    public short encryptionTestMode;
    public short ltnBeforeEncryption;
    public short ltnNumber;
    public short sid;
    public short status;

    public TMCServiceProviderInfo(short s, short s2, short s3, short s4, short s5, short s6, short s7) {
        this.status = s;
        this.countryCode = s2;
        this.sid = s3;
        this.ltnNumber = s4;
        this.encryptionTestMode = s5;
        this.encryptionId = s6;
        this.ltnBeforeEncryption = s7;
    }
}
