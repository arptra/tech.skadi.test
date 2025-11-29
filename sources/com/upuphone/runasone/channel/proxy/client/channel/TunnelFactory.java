package com.upuphone.runasone.channel.proxy.client.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TunnelFactory {
    public static Tunnel createTunnelByConfig(InetSocketAddress inetSocketAddress, Selector selector) throws IOException {
        return new RemoteTunnel(inetSocketAddress, selector);
    }

    public static Tunnel wrap(SocketChannel socketChannel, Selector selector) {
        return new RawTunnel(socketChannel, selector);
    }
}
