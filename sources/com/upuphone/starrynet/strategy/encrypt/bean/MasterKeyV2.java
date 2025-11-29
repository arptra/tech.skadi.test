package com.upuphone.starrynet.strategy.encrypt.bean;

public class MasterKeyV2 {
    private String key;
    private String mac;
    private int state;

    public MasterKeyV2() {
    }

    public String getKey() {
        return this.key;
    }

    public String getMac() {
        return this.mac;
    }

    public int getState() {
        return this.state;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setState(int i) {
        this.state = i;
    }

    public String toString() {
        return "MasterKeyV2{mac='" + this.mac + '\'' + ", state=" + this.state + ", key='" + this.key + '\'' + '}';
    }

    public MasterKeyV2(String str, int i, String str2) {
        this.mac = str;
        this.state = i;
        this.key = str2;
    }
}
