package com.upuphone.ar.navi.lite.protocol;

import java.io.Serializable;

public class NaviTtsText implements Serializable {
    private long ack;
    private String identity;
    private int naviTtsType;
    private String ttsText;

    public NaviTtsText(int i, String str) {
        this.naviTtsType = i;
        this.ttsText = str;
    }

    public long getAck() {
        return this.ack;
    }

    public String getIdentity() {
        return this.identity;
    }

    public int getNaviTtsType() {
        return this.naviTtsType;
    }

    public String getTtsText() {
        return this.ttsText;
    }

    public void setAck(long j) {
        this.ack = j;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public void setNaviTtsType(int i) {
        this.naviTtsType = i;
    }

    public void setTtsText(String str) {
        this.ttsText = str;
    }
}
