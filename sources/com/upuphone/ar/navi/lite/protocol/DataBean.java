package com.upuphone.ar.navi.lite.protocol;

import java.io.Serializable;

public class DataBean implements Serializable {
    private long ack;
    private String data;
    private String identity;

    public long getAck() {
        return this.ack;
    }

    public String getData() {
        return this.data;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setAck(long j) {
        this.ack = j;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public String toString() {
        return "DataBean{identity='" + this.identity + '\'' + ", data='" + this.data + '\'' + ", ack=" + this.ack + '}';
    }
}
