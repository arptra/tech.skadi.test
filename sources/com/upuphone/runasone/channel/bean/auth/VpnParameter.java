package com.upuphone.runasone.channel.bean.auth;

import android.text.TextUtils;

public class VpnParameter {
    private String ip = "";
    private int tcpPort = 0;
    private int udpPort = 0;

    public String getIp() {
        return this.ip;
    }

    public int getTcpPort() {
        return this.tcpPort;
    }

    public int getUdpPort() {
        return this.udpPort;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.ip) && this.tcpPort > 0 && this.udpPort > 0;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setTcpPort(int i) {
        this.tcpPort = i;
    }

    public void setUdpPort(int i) {
        this.udpPort = i;
    }

    public String toString() {
        return "VpnParameter{ip='" + this.ip + '\'' + ", tcpPort=" + this.tcpPort + ", udpPort=" + this.udpPort + '}';
    }
}
