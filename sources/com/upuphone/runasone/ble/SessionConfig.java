package com.upuphone.runasone.ble;

import java.util.UUID;

public class SessionConfig {
    public static final long DEFAULT_REQUEST_TIMEOUT = 5000;
    private long requestTimeout = 5000;
    private String serviceUUID;

    public UUID getServiceUUID() {
        return UUID.fromString(this.serviceUUID);
    }

    public SessionConfig requestTimeout(long j) {
        this.requestTimeout = j;
        return this;
    }

    public SessionConfig serviceUUID(String str) {
        this.serviceUUID = str;
        return this;
    }

    public long requestTimeout() {
        return this.requestTimeout;
    }
}
