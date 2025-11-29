package io.netty.handler.codec.http2;

import com.upuphone.runasone.relay.api.IntentKey;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Http2StreamChannelBootstrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
    private static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY = new Map.Entry[0];
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2StreamChannelBootstrap.class);
    private final Map<AttributeKey<?>, Object> attrs = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Channel channel;
    private volatile ChannelHandler handler;
    private volatile ChannelHandlerContext multiplexCtx;
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();

    public Http2StreamChannelBootstrap(Channel channel2) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel2, "channel");
    }

    private ChannelHandlerContext findCtx() throws ClosedChannelException {
        ChannelHandlerContext channelHandlerContext = this.multiplexCtx;
        if (channelHandlerContext != null && !channelHandlerContext.isRemoved()) {
            return channelHandlerContext;
        }
        ChannelPipeline pipeline = this.channel.pipeline();
        Class<Http2MultiplexCodec> cls = Http2MultiplexCodec.class;
        ChannelHandlerContext context = pipeline.context((Class<? extends ChannelHandler>) cls);
        Class<Http2MultiplexHandler> cls2 = Http2MultiplexHandler.class;
        if (context == null) {
            context = pipeline.context((Class<? extends ChannelHandler>) cls2);
        }
        if (context != null) {
            this.multiplexCtx = context;
            return context;
        } else if (this.channel.isActive()) {
            throw new IllegalStateException(StringUtil.simpleClassName((Class<?>) cls) + " or " + StringUtil.simpleClassName((Class<?>) cls2) + " must be in the ChannelPipeline of Channel " + this.channel);
        } else {
            throw new ClosedChannelException();
        }
    }

    private void init(Channel channel2) {
        Map.Entry[] entryArr;
        ChannelPipeline pipeline = channel2.pipeline();
        ChannelHandler channelHandler = this.handler;
        if (channelHandler != null) {
            pipeline.addLast(channelHandler);
        }
        synchronized (this.options) {
            entryArr = (Map.Entry[]) this.options.entrySet().toArray(EMPTY_OPTION_ARRAY);
        }
        setChannelOptions(channel2, entryArr);
        setAttributes(channel2, (Map.Entry[]) this.attrs.entrySet().toArray(EMPTY_ATTRIBUTE_ARRAY));
    }

    private static void setAttributes(Channel channel2, Map.Entry<AttributeKey<?>, Object>[] entryArr) {
        for (Map.Entry<AttributeKey<?>, Object> entry : entryArr) {
            channel2.attr(entry.getKey()).set(entry.getValue());
        }
    }

    private static void setChannelOption(Channel channel2, ChannelOption<?> channelOption, Object obj) {
        try {
            if (!channel2.config().setOption(channelOption, obj)) {
                logger.warn("Unknown channel option '{}' for channel '{}'", channelOption, channel2);
            }
        } catch (Throwable th) {
            logger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", channelOption, obj, channel2, th);
        }
    }

    private static void setChannelOptions(Channel channel2, Map.Entry<ChannelOption<?>, Object>[] entryArr) {
        for (Map.Entry<ChannelOption<?>, Object> entry : entryArr) {
            setChannelOption(channel2, entry.getKey(), entry.getValue());
        }
    }

    public <T> Http2StreamChannelBootstrap attr(AttributeKey<T> attributeKey, T t) {
        ObjectUtil.checkNotNull(attributeKey, IntentKey.ACTIVITY.ACTION_KEY);
        if (t == null) {
            this.attrs.remove(attributeKey);
        } else {
            this.attrs.put(attributeKey, t);
        }
        return this;
    }

    public Http2StreamChannelBootstrap handler(ChannelHandler channelHandler) {
        this.handler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "handler");
        return this;
    }

    public Future<Http2StreamChannel> open() {
        return open(this.channel.eventLoop().newPromise());
    }

    @Deprecated
    public void open0(ChannelHandlerContext channelHandlerContext, final Promise<Http2StreamChannel> promise) {
        if (promise.setUncancellable()) {
            try {
                final Http2StreamChannel newOutboundStream = channelHandlerContext.handler() instanceof Http2MultiplexCodec ? ((Http2MultiplexCodec) channelHandlerContext.handler()).newOutboundStream() : ((Http2MultiplexHandler) channelHandlerContext.handler()).newOutboundStream();
                try {
                    init(newOutboundStream);
                    channelHandlerContext.channel().eventLoop().register((Channel) newOutboundStream).addListener(new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (channelFuture.isSuccess()) {
                                promise.setSuccess(newOutboundStream);
                            } else if (channelFuture.isCancelled()) {
                                promise.cancel(false);
                            } else {
                                if (newOutboundStream.isRegistered()) {
                                    newOutboundStream.close();
                                } else {
                                    newOutboundStream.unsafe().closeForcibly();
                                }
                                promise.setFailure(channelFuture.cause());
                            }
                        }
                    });
                } catch (Exception e) {
                    newOutboundStream.unsafe().closeForcibly();
                    promise.setFailure(e);
                }
            } catch (Exception e2) {
                promise.setFailure(e2);
            }
        }
    }

    public <T> Http2StreamChannelBootstrap option(ChannelOption<T> channelOption, T t) {
        ObjectUtil.checkNotNull(channelOption, "option");
        synchronized (this.options) {
            if (t == null) {
                try {
                    this.options.remove(channelOption);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                this.options.put(channelOption, t);
            }
        }
        return this;
    }

    public Future<Http2StreamChannel> open(final Promise<Http2StreamChannel> promise) {
        try {
            final ChannelHandlerContext findCtx = findCtx();
            EventExecutor executor = findCtx.executor();
            if (executor.inEventLoop()) {
                open0(findCtx, promise);
            } else {
                executor.execute(new Runnable() {
                    public void run() {
                        if (Http2StreamChannelBootstrap.this.channel.isActive()) {
                            Http2StreamChannelBootstrap.this.open0(findCtx, promise);
                        } else {
                            promise.setFailure(new ClosedChannelException());
                        }
                    }
                });
            }
        } catch (Throwable th) {
            promise.setFailure(th);
        }
        return promise;
    }
}
