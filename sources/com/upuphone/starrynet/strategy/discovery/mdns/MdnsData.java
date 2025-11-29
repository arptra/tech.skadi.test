package com.upuphone.starrynet.strategy.discovery.mdns;

import com.google.gson.annotations.SerializedName;

public class MdnsData {
    @SerializedName("b")
    private String deviceName;
    @SerializedName("a")
    private String identifier;
    @SerializedName("d")
    private int ip;
    @SerializedName("c")
    private byte terminalType;

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getIp() {
        return this.ip;
    }

    public byte getTerminalType() {
        return this.terminalType;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setIp(int i) {
        this.ip = i;
    }

    public void setTerminalType(byte b) {
        this.terminalType = b;
    }
}
