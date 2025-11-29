package com.upuphone.xr.interconnect.entity;

public class SyncStarryNetAppReq {
    private int type;
    private String version;

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "SyncStarryNetAppReq{type=" + this.type + ", version='" + this.version + '\'' + '}';
    }
}
