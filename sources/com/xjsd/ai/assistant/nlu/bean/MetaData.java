package com.xjsd.ai.assistant.nlu.bean;

public class MetaData {
    private String accountId;
    private String configId = "config_123456";
    private String coordinateSystem = "GCJ02";
    private int debugFlagNum = 0;
    private String deviceId;
    private String latitude;
    private String longitude;
    private String msgId;
    private String nluLanguage = "mandarin";
    private int originType = 0;
    private boolean sessionFirstFlag = false;
    private String timeZone;
    private String traceId;

    public String getAccountId() {
        return this.accountId;
    }

    public String getConfigId() {
        return this.configId;
    }

    public String getCoordinateSystem() {
        return this.coordinateSystem;
    }

    public int getDebugFlagNum() {
        return this.debugFlagNum;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getNluLanguage() {
        return this.nluLanguage;
    }

    public int getOriginType() {
        return this.originType;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public boolean isSessionFirstFlag() {
        return this.sessionFirstFlag;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setConfigId(String str) {
        this.configId = str;
    }

    public void setCoordinateSystem(String str) {
        this.coordinateSystem = str;
    }

    public void setDebugFlagNum(int i) {
        this.debugFlagNum = i;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setNluLanguage(String str) {
        this.nluLanguage = str;
    }

    public void setOriginType(int i) {
        this.originType = i;
    }

    public void setSessionFirstFlag(boolean z) {
        this.sessionFirstFlag = z;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
