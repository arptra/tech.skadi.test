package com.upuphone.runasone.channel.proxy.server.socks;

import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.server.base.ChannelServerUtils;
import com.upuphone.runasone.channel.proxy.server.base.DirectClientHandler;
import com.upuphone.runasone.channel.proxy.server.base.RelayHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.v5.DefaultSocks5CommandResponse;
import io.netty.handler.codec.socksx.v5.Socks5CommandRequest;
import io.netty.handler.codec.socksx.v5.Socks5CommandStatus;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;

@ChannelHandler.Sharable
public final class SocksServerConnectHandler extends SimpleChannelInboundHandler<SocksMessage> {
    private static final String TAG = "SocksServerConnectHandler";
    private final Bootstrap b = new Bootstrap();

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        ChannelServerUtils.closeOnFlush(channelHandlerContext.channel());
    }

    public void channelRead0(final ChannelHandlerContext channelHandlerContext, SocksMessage socksMessage) throws Exception {
        final Socks5CommandRequest socks5CommandRequest = (Socks5CommandRequest) socksMessage;
        Promise newPromise = channelHandlerContext.executor().newPromise();
        newPromise.addListener(new FutureListener<Channel>() {
            public void operationComplete(Future<Channel> future) throws Exception {
                final Channel now = future.getNow();
                if (future.isSuccess()) {
                    DebugLog.d("%s send CONNECT resp success", SocksServerConnectHandler.TAG);
                    channelHandlerContext.channel().writeAndFlush(new DefaultSocks5CommandResponse(Socks5CommandStatus.SUCCESS, socks5CommandRequest.dstAddrType(), socks5CommandRequest.dstAddr(), socks5CommandRequest.dstPort())).addListener(new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture) {
                            channelHandlerContext.pipeline().remove((ChannelHandler) SocksServerConnectHandler.this);
                            now.pipeline().addLast(new RelayHandler(channelHandlerContext.channel()));
                            channelHandlerContext.pipeline().addLast(new RelayHandler(now));
                        }
                    });
                    return;
                }
                DebugLog.e("%s send CONNECT resp fail", SocksServerConnectHandler.TAG);
                channelHandlerContext.channel().writeAndFlush(new DefaultSocks5CommandResponse(Socks5CommandStatus.FAILURE, socks5CommandRequest.dstAddrType()));
                ChannelServerUtils.closeOnFlush(channelHandlerContext.channel());
            }
        });
        ((Bootstrap) ((Bootstrap) ((Bootstrap) ((Bootstrap) this.b.group(channelHandlerContext.channel().eventLoop())).channel(NioSocketChannel.class)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)).option(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)).handler(new DirectClientHandler(newPromise));
        this.b.connect(socks5CommandRequest.dstAddr(), socks5CommandRequest.dstPort()).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (!channelFuture.isSuccess()) {
                    channelHandlerContext.channel().writeAndFlush(new DefaultSocks5CommandResponse(Socks5CommandStatus.FAILURE, socks5CommandRequest.dstAddrType()));
                    ChannelServerUtils.closeOnFlush(channelHandlerContext.channel());
                }
            }
        });
    }
}
