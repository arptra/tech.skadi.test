package com.upuphone.ai.ttsengine.protocol.bean;

import androidx.annotation.Keep;

@Keep
public class LicenceBean {
    private int length;
    private String md5;
    private long version;

    public int getLength() {
        return this.length;
    }

    public String getMd5() {
        return this.md5;
    }

    public long getVersion() {
        return this.version;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public String toString() {
        return "LicenceBean{version=" + this.version + ", length=" + this.length + ", md5='" + this.md5 + '\'' + '}';
    }
}
