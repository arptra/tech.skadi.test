package com.upuphone.xr.interconnect.entity;

public class SyncTimeResponseInfo {
    private long syncTimeData;
    private String syncTimeZone;

    public SyncTimeResponseInfo(long j, String str) {
        this.syncTimeData = j;
        this.syncTimeZone = str;
    }

    public long getSyncTimeData() {
        return this.syncTimeData;
    }

    public String getSyncTimeZone() {
        return this.syncTimeZone;
    }

    public void setSyncTimeData(long j) {
        this.syncTimeData = j;
    }

    public void setSyncTimeZone(String str) {
        this.syncTimeZone = str;
    }
}
