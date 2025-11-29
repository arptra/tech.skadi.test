package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ChannelHandler.Sharable
public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelInitializer.class);
    /* access modifiers changed from: private */
    public final Set<ChannelHandlerContext> initMap = Collections.newSetFromMap(new ConcurrentHashMap());

    private boolean initChannel(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.initMap.add(channelHandlerContext)) {
            return false;
        }
        try {
            initChannel(channelHandlerContext.channel());
            if (channelHandlerContext.isRemoved()) {
                return true;
            }
        } catch (Throwable th) {
            if (!channelHandlerContext.isRemoved()) {
                channelHandlerContext.pipeline().remove((ChannelHandler) this);
            }
            throw th;
        }
        channelHandlerContext.pipeline().remove((ChannelHandler) this);
        return true;
    }

    private void removeState(final ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.isRemoved()) {
            this.initMap.remove(channelHandlerContext);
        } else {
            channelHandlerContext.executor().execute(new Runnable() {
                public void run() {
                    ChannelInitializer.this.initMap.remove(channelHandlerContext);
                }
            });
        }
    }

    public final void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (initChannel(channelHandlerContext)) {
            channelHandlerContext.pipeline().fireChannelRegistered();
            removeState(channelHandlerContext);
            return;
        }
        channelHandlerContext.fireChannelRegistered();
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        InternalLogger internalLogger = logger;
        if (internalLogger.isWarnEnabled()) {
            internalLogger.warn("Failed to initialize a channel. Closing: " + channelHandlerContext.channel(), th);
        }
        channelHandlerContext.close();
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isRegistered() && initChannel(channelHandlerContext)) {
            removeState(channelHandlerContext);
        }
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.initMap.remove(channelHandlerContext);
    }

    public abstract void initChannel(C c) throws Exception;
}
