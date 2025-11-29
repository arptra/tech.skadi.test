package com.upuphone.runasone.channel.proxy.server.socks;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.socksx.SocksPortUnificationServerHandler;

public final class SocksServerInitializer extends ChannelInitializer<SocketChannel> {
    public void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new SocksPortUnificationServerHandler(), SocksServerHandler.INSTANCE);
    }
}
