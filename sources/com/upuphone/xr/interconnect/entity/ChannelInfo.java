package com.upuphone.xr.interconnect.entity;

public class ChannelInfo {
    private boolean isAutoChangeChannel;
    private boolean isUseP2pChannel;

    public ChannelInfo(boolean z, boolean z2) {
        this.isAutoChangeChannel = z;
        this.isUseP2pChannel = z2;
    }

    public boolean isAutoChangeChannel() {
        return this.isAutoChangeChannel;
    }

    public boolean isUseP2pChannel() {
        return this.isUseP2pChannel;
    }

    public void setAutoChangeChannel(boolean z) {
        this.isAutoChangeChannel = z;
    }

    public void setUseP2pChannel(boolean z) {
        this.isUseP2pChannel = z;
    }
}
