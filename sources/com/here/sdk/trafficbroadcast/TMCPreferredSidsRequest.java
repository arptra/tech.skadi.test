package com.here.sdk.trafficbroadcast;

public final class TMCPreferredSidsRequest {
    public short countryCode;
    public short ltn;

    public TMCPreferredSidsRequest(short s, short s2) {
        this.countryCode = s;
        this.ltn = s2;
    }
}
