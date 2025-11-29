package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler> extends ChannelDuplexHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CombinedChannelDuplexHandler.class);
    private volatile boolean handlerAdded;
    private DelegatingChannelHandlerContext inboundCtx;
    private I inboundHandler;
    /* access modifiers changed from: private */
    public DelegatingChannelHandlerContext outboundCtx;
    /* access modifiers changed from: private */
    public O outboundHandler;

    public static class DelegatingChannelHandlerContext implements ChannelHandlerContext {
        /* access modifiers changed from: private */
        public final ChannelHandlerContext ctx;
        private final ChannelHandler handler;
        boolean removed;

        public DelegatingChannelHandlerContext(ChannelHandlerContext channelHandlerContext, ChannelHandler channelHandler) {
            this.ctx = channelHandlerContext;
            this.handler = channelHandler;
        }

        /* access modifiers changed from: private */
        public void remove0() {
            if (!this.removed) {
                this.removed = true;
                try {
                    this.handler.handlerRemoved(this);
                } catch (Throwable th) {
                    fireExceptionCaught((Throwable) new ChannelPipelineException(this.handler.getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
                }
            }
        }

        public ByteBufAllocator alloc() {
            return this.ctx.alloc();
        }

        public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
            return this.ctx.channel().attr(attributeKey);
        }

        public ChannelFuture bind(SocketAddress socketAddress) {
            return this.ctx.bind(socketAddress);
        }

        public Channel channel() {
            return this.ctx.channel();
        }

        public ChannelFuture close() {
            return this.ctx.close();
        }

        public ChannelFuture connect(SocketAddress socketAddress) {
            return this.ctx.connect(socketAddress);
        }

        public ChannelFuture deregister() {
            return this.ctx.deregister();
        }

        public ChannelFuture disconnect() {
            return this.ctx.disconnect();
        }

        public EventExecutor executor() {
            return this.ctx.executor();
        }

        public ChannelHandler handler() {
            return this.ctx.handler();
        }

        public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
            return this.ctx.channel().hasAttr(attributeKey);
        }

        public boolean isRemoved() {
            return this.removed || this.ctx.isRemoved();
        }

        public String name() {
            return this.ctx.name();
        }

        public ChannelFuture newFailedFuture(Throwable th) {
            return this.ctx.newFailedFuture(th);
        }

        public ChannelProgressivePromise newProgressivePromise() {
            return this.ctx.newProgressivePromise();
        }

        public ChannelPromise newPromise() {
            return this.ctx.newPromise();
        }

        public ChannelFuture newSucceededFuture() {
            return this.ctx.newSucceededFuture();
        }

        public ChannelPipeline pipeline() {
            return this.ctx.pipeline();
        }

        public final void remove() {
            EventExecutor executor = executor();
            if (executor.inEventLoop()) {
                remove0();
            } else {
                executor.execute(new Runnable() {
                    public void run() {
                        DelegatingChannelHandlerContext.this.remove0();
                    }
                });
            }
        }

        public ChannelPromise voidPromise() {
            return this.ctx.voidPromise();
        }

        public ChannelFuture write(Object obj) {
            return this.ctx.write(obj);
        }

        public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
            return this.ctx.writeAndFlush(obj, channelPromise);
        }

        public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.bind(socketAddress, channelPromise);
        }

        public ChannelFuture close(ChannelPromise channelPromise) {
            return this.ctx.close(channelPromise);
        }

        public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
            return this.ctx.connect(socketAddress, socketAddress2);
        }

        public ChannelFuture deregister(ChannelPromise channelPromise) {
            return this.ctx.deregister(channelPromise);
        }

        public ChannelFuture disconnect(ChannelPromise channelPromise) {
            return this.ctx.disconnect(channelPromise);
        }

        public ChannelHandlerContext fireChannelActive() {
            this.ctx.fireChannelActive();
            return this;
        }

        public ChannelHandlerContext fireChannelInactive() {
            this.ctx.fireChannelInactive();
            return this;
        }

        public ChannelHandlerContext fireChannelRead(Object obj) {
            this.ctx.fireChannelRead(obj);
            return this;
        }

        public ChannelHandlerContext fireChannelReadComplete() {
            this.ctx.fireChannelReadComplete();
            return this;
        }

        public ChannelHandlerContext fireChannelRegistered() {
            this.ctx.fireChannelRegistered();
            return this;
        }

        public ChannelHandlerContext fireChannelUnregistered() {
            this.ctx.fireChannelUnregistered();
            return this;
        }

        public ChannelHandlerContext fireChannelWritabilityChanged() {
            this.ctx.fireChannelWritabilityChanged();
            return this;
        }

        public ChannelHandlerContext fireExceptionCaught(Throwable th) {
            this.ctx.fireExceptionCaught(th);
            return this;
        }

        public ChannelHandlerContext fireUserEventTriggered(Object obj) {
            this.ctx.fireUserEventTriggered(obj);
            return this;
        }

        public ChannelHandlerContext flush() {
            this.ctx.flush();
            return this;
        }

        public ChannelHandlerContext read() {
            this.ctx.read();
            return this;
        }

        public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
            return this.ctx.write(obj, channelPromise);
        }

        public ChannelFuture writeAndFlush(Object obj) {
            return this.ctx.writeAndFlush(obj);
        }

        public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, channelPromise);
        }

        public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, socketAddress2, channelPromise);
        }
    }

    public CombinedChannelDuplexHandler() {
        ensureNotSharable();
    }

    private void checkAdded() {
        if (!this.handlerAdded) {
            throw new IllegalStateException("handler not added to pipeline yet");
        }
    }

    private void validate(I i, O o) {
        if (this.inboundHandler == null) {
            ObjectUtil.checkNotNull(i, "inboundHandler");
            ObjectUtil.checkNotNull(o, "outboundHandler");
            if (i instanceof ChannelOutboundHandler) {
                throw new IllegalArgumentException("inboundHandler must not implement " + ChannelOutboundHandler.class.getSimpleName() + " to get combined.");
            } else if (o instanceof ChannelInboundHandler) {
                throw new IllegalArgumentException("outboundHandler must not implement " + ChannelInboundHandler.class.getSimpleName() + " to get combined.");
            }
        } else {
            throw new IllegalStateException("init() can not be invoked if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with non-default constructor.");
        }
    }

    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.bind(delegatingChannelHandlerContext, socketAddress, channelPromise);
        } else {
            delegatingChannelHandlerContext.bind(socketAddress, channelPromise);
        }
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelActive(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelActive();
        }
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelInactive(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelInactive();
        }
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelRead(delegatingChannelHandlerContext, obj);
        } else {
            delegatingChannelHandlerContext.fireChannelRead(obj);
        }
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelReadComplete(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelReadComplete();
        }
    }

    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelRegistered(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelRegistered();
        }
    }

    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelUnregistered(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelUnregistered();
        }
    }

    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelWritabilityChanged(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelWritabilityChanged();
        }
    }

    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.close(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.close(channelPromise);
        }
    }

    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.connect(delegatingChannelHandlerContext, socketAddress, socketAddress2, channelPromise);
        } else {
            delegatingChannelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
        }
    }

    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.deregister(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.deregister(channelPromise);
        }
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.disconnect(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.disconnect(channelPromise);
        }
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.exceptionCaught(delegatingChannelHandlerContext, th);
        } else {
            delegatingChannelHandlerContext.fireExceptionCaught(th);
        }
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.flush(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.flush();
        }
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.inboundHandler != null) {
            this.outboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.outboundHandler);
            this.inboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.inboundHandler) {
                public ChannelHandlerContext fireExceptionCaught(Throwable th) {
                    if (!CombinedChannelDuplexHandler.this.outboundCtx.removed) {
                        try {
                            CombinedChannelDuplexHandler.this.outboundHandler.exceptionCaught(CombinedChannelDuplexHandler.this.outboundCtx, th);
                        } catch (Throwable th2) {
                            if (CombinedChannelDuplexHandler.logger.isDebugEnabled()) {
                                CombinedChannelDuplexHandler.logger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                            } else if (CombinedChannelDuplexHandler.logger.isWarnEnabled()) {
                                CombinedChannelDuplexHandler.logger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                            }
                        }
                    } else {
                        super.fireExceptionCaught(th);
                    }
                    return this;
                }
            };
            this.handlerAdded = true;
            try {
                this.inboundHandler.handlerAdded(this.inboundCtx);
            } finally {
                this.outboundHandler.handlerAdded(this.outboundCtx);
            }
        } else {
            throw new IllegalStateException("init() must be invoked before being added to a " + ChannelPipeline.class.getSimpleName() + " if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with the default constructor.");
        }
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            this.inboundCtx.remove();
        } finally {
            this.outboundCtx.remove();
        }
    }

    public final I inboundHandler() {
        return this.inboundHandler;
    }

    public final void init(I i, O o) {
        validate(i, o);
        this.inboundHandler = i;
        this.outboundHandler = o;
    }

    public final O outboundHandler() {
        return this.outboundHandler;
    }

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.read(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.read();
        }
    }

    public final void removeInboundHandler() {
        checkAdded();
        this.inboundCtx.remove();
    }

    public final void removeOutboundHandler() {
        checkAdded();
        this.outboundCtx.remove();
    }

    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.userEventTriggered(delegatingChannelHandlerContext, obj);
        } else {
            delegatingChannelHandlerContext.fireUserEventTriggered(obj);
        }
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.write(delegatingChannelHandlerContext, obj, channelPromise);
        } else {
            delegatingChannelHandlerContext.write(obj, channelPromise);
        }
    }

    public CombinedChannelDuplexHandler(I i, O o) {
        ensureNotSharable();
        init(i, o);
    }
}
