package com.upuphone.starrynet.core.p2p.bean;

public class GoInfo {
    private String address;
    private int freq;
    private String mac;
    private boolean needReport;
    private int port;
    private String pwd;
    private String ssid;

    public String getAddress() {
        return this.address;
    }

    public int getFreq() {
        return this.freq;
    }

    public String getMac() {
        return this.mac;
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

    public boolean isNeedReport() {
        return this.needReport;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setFreq(int i) {
        this.freq = i;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setNeedReport(boolean z) {
        this.needReport = z;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String toString() {
        return "GoInfo{ssid='" + this.ssid + '\'' + ", pwd='" + this.pwd + '\'' + ", port=" + this.port + ", freq=" + this.freq + ", address='" + this.address + '\'' + ", mac='" + this.mac + '\'' + '}';
    }
}
