package com.upuphone.runasone.channel.linker.websocket.client;

import com.upuphone.runasone.utils.LogUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;

public class WsClientInitializer extends ChannelInitializer<SocketChannel> {
    private String mDeviceId;
    private WebSocketClientHandshaker mHandShaker;

    public WsClientInitializer(String str, WebSocketClientHandshaker webSocketClientHandshaker) {
        this.mDeviceId = str;
        this.mHandShaker = webSocketClientHandshaker;
    }

    public void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        LogUtil.d("WsClientInitializer initChannel");
        pipeline.addLast(new HttpClientCodec());
        pipeline.addLast(new HttpObjectAggregator(10000000));
        pipeline.addLast("hookedHandler", (ChannelHandler) new WsClientHandler(this.mDeviceId, this.mHandShaker));
    }
}
