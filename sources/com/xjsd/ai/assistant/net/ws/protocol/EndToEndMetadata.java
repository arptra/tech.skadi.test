package com.xjsd.ai.assistant.net.ws.protocol;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class EndToEndMetadata {
    @SerializedName("accountId")
    private String accountId;
    @SerializedName("appName")
    private String appName;
    @SerializedName("functionType")
    private int functionType;
    @SerializedName("glassDeviceId")
    private String glassDeviceId;
    @SerializedName("iotDeviceId")
    private String iotDeviceId;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("local")
    private String local;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("sessionId")
    private String sessionId;
    @SerializedName("terminalTraceId")
    private String terminalTraceId;
    @SerializedName("xjAccountId")
    private String xjAccountId;

    public String getAccountId() {
        return this.accountId;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getFunctionType() {
        return this.functionType;
    }

    public String getGlassDeviceId() {
        return this.glassDeviceId;
    }

    public String getIotDeviceId() {
        return this.iotDeviceId;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLocal() {
        return this.local;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTerminalTraceId() {
        return this.terminalTraceId;
    }

    public String getXjAccountId() {
        return this.xjAccountId;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setFunctionType(int i) {
        this.functionType = i;
    }

    public void setGlassDeviceId(String str) {
        this.glassDeviceId = str;
    }

    public void setIotDeviceId(String str) {
        this.iotDeviceId = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLocal(String str) {
        this.local = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTerminalTraceId(String str) {
        this.terminalTraceId = str;
    }

    public void setXjAccountId(String str) {
        this.xjAccountId = str;
    }
}
