package com.upuphone.runasone.ble;

public class ConnectConfig {
    public static final long DEFAULT_CONNECT_TIMEOUT = 15000;
    public static final int DEFAULT_RETRY_COUNT = 2;
    private long retryCount = 2;
    private long timeout = 15000;

    public ConnectConfig connectTimeout(long j) {
        this.timeout = j;
        return this;
    }

    public long getRetryCount() {
        return this.retryCount;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public ConnectConfig retryCount(int i) {
        this.retryCount = (long) i;
        return this;
    }
}
