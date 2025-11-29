package com.xjsd.ai.assistant.protocol.sys;

public class SyncSysInfoReq {
    private String glassSN;
    private boolean isOtaFeature;
    private boolean isStar;
    private int roundTimes;
    private int versionCode;
    private String versionName;

    public String getGlassSN() {
        return this.glassSN;
    }

    public int getRoundTimes() {
        return this.roundTimes;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean isOtaFeature() {
        return this.isOtaFeature;
    }

    public boolean isStar() {
        return this.isStar;
    }

    public void setGlassSN(String str) {
        this.glassSN = str;
    }

    public void setOtaFeature(boolean z) {
        this.isOtaFeature = z;
    }

    public void setRoundTimes(int i) {
        this.roundTimes = i;
    }

    public void setStar(boolean z) {
        this.isStar = z;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
