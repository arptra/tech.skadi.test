package com.upuphone.runasone.channel.proxy.client.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public interface IPackHandler {
    int getPort();

    InetSocketAddress parseRemoteData(ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress);

    void sendToRemote(DatagramChannel datagramChannel, ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress);

    void setProxyAddress(InetSocketAddress inetSocketAddress);
}
