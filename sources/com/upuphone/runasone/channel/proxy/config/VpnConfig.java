package com.upuphone.runasone.channel.proxy.config;

import android.text.TextUtils;

public class VpnConfig {
    public int allowMode = -1;
    public String ip = "";
    public int tcpPort = 0;
    public int udpPort = 0;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.ip) && this.tcpPort > 0 && this.udpPort > 0;
    }

    public String toString() {
        return "VpnConfig{ip='" + this.ip + '\'' + ", tcpPort=" + this.tcpPort + ", udpPort=" + this.udpPort + ", allowMode=" + this.allowMode + '}';
    }
}
