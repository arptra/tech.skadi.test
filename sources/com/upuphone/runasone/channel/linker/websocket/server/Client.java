package com.upuphone.runasone.channel.linker.websocket.server;

import io.netty.channel.Channel;

public class Client {
    private Channel channel;
    private String deviceId;

    public Client(String str, Channel channel2) {
        this.deviceId = str;
        this.channel = channel2;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public String getDeviceId() {
        return this.deviceId;
    }
}
