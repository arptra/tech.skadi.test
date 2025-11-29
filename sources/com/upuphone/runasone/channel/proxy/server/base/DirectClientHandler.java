package com.upuphone.runasone.channel.proxy.server.base;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Promise;

public final class DirectClientHandler extends ChannelInboundHandlerAdapter {
    private final Promise<Channel> promise;

    public DirectClientHandler(Promise<Channel> promise2) {
        this.promise = promise2;
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove((ChannelHandler) this);
        this.promise.setSuccess(channelHandlerContext.channel());
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        this.promise.setFailure(th);
    }
}
