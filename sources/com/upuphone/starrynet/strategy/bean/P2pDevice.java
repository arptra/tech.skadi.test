package com.upuphone.starrynet.strategy.bean;

public class P2pDevice {
    private String address;
    private int port;

    public P2pDevice(int i, String str) {
        this.port = i;
        this.address = str;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }
}
