package com.here.sdk.trafficbroadcast;

public final class RDSEncryptionKeysRequest {
    public short countryCode;
    public short ltnBeforeEncryption;
    public short sid;

    public RDSEncryptionKeysRequest(short s, short s2, short s3) {
        this.countryCode = s;
        this.sid = s2;
        this.ltnBeforeEncryption = s3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RDSEncryptionKeysRequest)) {
            return false;
        }
        RDSEncryptionKeysRequest rDSEncryptionKeysRequest = (RDSEncryptionKeysRequest) obj;
        return this.countryCode == rDSEncryptionKeysRequest.countryCode && this.sid == rDSEncryptionKeysRequest.sid && this.ltnBeforeEncryption == rDSEncryptionKeysRequest.ltnBeforeEncryption;
    }

    public int hashCode() {
        return ((((217 + this.countryCode) * 31) + this.sid) * 31) + this.ltnBeforeEncryption;
    }
}
