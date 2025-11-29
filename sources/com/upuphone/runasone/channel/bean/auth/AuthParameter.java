package com.upuphone.runasone.channel.bean.auth;

public class AuthParameter {
    private String authInfo;
    private boolean bLocalServer;
    private long deltaSysTime;
    private boolean isTlv;
    private VpnParameter vpnParameter;

    public String getAuthInfo() {
        return this.authInfo;
    }

    public long getDeltaSysTime() {
        return this.deltaSysTime;
    }

    public VpnParameter getVpnParameter() {
        return this.vpnParameter;
    }

    public boolean isRemoteServer() {
        return this.bLocalServer;
    }

    public boolean isTlv() {
        return this.isTlv;
    }

    public void setAuthInfo(String str) {
        this.authInfo = str;
    }

    public void setDeltaSysTime(long j) {
        this.deltaSysTime = j;
    }

    public void setRemoteServer(boolean z) {
        this.bLocalServer = z;
    }

    public void setTlv(boolean z) {
        this.isTlv = z;
    }

    public void setVpnParameter(VpnParameter vpnParameter2) {
        this.vpnParameter = vpnParameter2;
    }
}
