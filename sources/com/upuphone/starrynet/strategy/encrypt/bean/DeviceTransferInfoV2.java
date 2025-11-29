package com.upuphone.starrynet.strategy.encrypt.bean;

public class DeviceTransferInfoV2 {
    private int freq;
    private String id;
    private String key;
    private String mac;
    private int port;
    private String psk;
    private String ssid;

    public DeviceTransferInfoV2() {
    }

    public int getFreq() {
        return this.freq;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getMac() {
        return this.mac;
    }

    public int getPort() {
        return this.port;
    }

    public String getPsk() {
        return this.psk;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setFreq(int i) {
        this.freq = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPsk(String str) {
        this.psk = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String toString() {
        return "ClientKeyV2{id='" + this.id + '\'' + ", mac='" + this.mac + '\'' + ", port=" + this.port + ", freq=" + this.freq + ", ssid='" + this.ssid + '\'' + ", psk='" + this.psk + '\'' + ", key='" + this.key + '\'' + '}';
    }

    public DeviceTransferInfoV2(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        this.id = str;
        this.mac = str2;
        this.port = i;
        this.freq = i2;
        this.ssid = str3;
        this.psk = str4;
        this.key = str5;
    }
}
