package com.upuphone.starryshare.bean;

import java.io.Serializable;
import java.net.InetAddress;

public class IpPortInfo implements Serializable {
    InetAddress inetAddress;
    int port;

    public IpPortInfo(InetAddress inetAddress2, int i) {
        this.inetAddress = inetAddress2;
        this.port = i;
    }

    public InetAddress getInetAddress() {
        return this.inetAddress;
    }

    public int getPort() {
        return this.port;
    }

    public void setInetAddress(InetAddress inetAddress2) {
        this.inetAddress = inetAddress2;
    }

    public void setPort(int i) {
        this.port = i;
    }
}
