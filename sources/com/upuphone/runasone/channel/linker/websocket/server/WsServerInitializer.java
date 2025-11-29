package com.upuphone.runasone.channel.linker.websocket.server;

import com.upuphone.runasone.channel.linker.websocket.WsHandlerOps;
import com.upuphone.runasone.utils.LogUtil;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;

public class WsServerInitializer extends ChannelInitializer<SocketChannel> {
    private static final String TAG = "WsServerInitializer";
    private WsHandlerOps.OnEvent mServerListener;

    public WsServerInitializer(WsHandlerOps.OnEvent onEvent) {
        this.mServerListener = onEvent;
    }

    public void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        String str = TAG;
        LogUtil.d(str, (Object) "initChannel --> " + socketChannel.remoteAddress());
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(10000000));
        pipeline.addLast(new WebSocketServerCompressionHandler());
        WsServerHandler wsServerHandler = new WsServerHandler(socketChannel);
        wsServerHandler.setOnEventListener(this.mServerListener);
        pipeline.addLast(wsServerHandler);
    }
}
