package com.upuphone.starrynet.core.ap;

public class WiFiApInfo {
    private String ip;
    private byte[] peerId;
    private int port;
    private final String pwd;
    private final String ssid;

    public WiFiApInfo(String str, String str2) {
        this.ssid = str;
        this.pwd = str2;
    }

    public String getIp() {
        return this.ip;
    }

    public byte[] getPeerId() {
        return this.peerId;
    }

    public int getPort() {
        return this.port;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setPeerId(byte[] bArr) {
        this.peerId = bArr;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public String toString() {
        return "WiFiApInfo{ssid='" + this.ssid + '\'' + ", pwd='" + this.pwd + '\'' + ", port=" + this.port + '}';
    }

    public WiFiApInfo(String str, String str2, int i) {
        this.ssid = str;
        this.pwd = str2;
        this.port = i;
    }
}
