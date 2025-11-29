package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.channel.socket.ChannelOutputShutdownException;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.LongCompanionObject;

public abstract class AbstractChannel extends DefaultAttributeMap implements Channel {
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractChannel.class);
    /* access modifiers changed from: private */
    public final CloseFuture closeFuture = new CloseFuture(this);
    /* access modifiers changed from: private */
    public boolean closeInitiated;
    /* access modifiers changed from: private */
    public volatile EventLoop eventLoop;
    private final ChannelId id;
    /* access modifiers changed from: private */
    public Throwable initialCloseCause;
    /* access modifiers changed from: private */
    public volatile SocketAddress localAddress;
    private final Channel parent;
    /* access modifiers changed from: private */
    public final DefaultChannelPipeline pipeline;
    /* access modifiers changed from: private */
    public volatile boolean registered;
    /* access modifiers changed from: private */
    public volatile SocketAddress remoteAddress;
    private String strVal;
    private boolean strValActive;
    private final Channel.Unsafe unsafe;
    /* access modifiers changed from: private */
    public final VoidChannelPromise unsafeVoidPromise = new VoidChannelPromise(this, false);

    public static final class AnnotatedConnectException extends ConnectException {
        private static final long serialVersionUID = 3901958112696433556L;

        public AnnotatedConnectException(ConnectException connectException, SocketAddress socketAddress) {
            super(connectException.getMessage() + ": " + socketAddress);
            initCause(connectException);
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class AnnotatedNoRouteToHostException extends NoRouteToHostException {
        private static final long serialVersionUID = -6801433937592080623L;

        public AnnotatedNoRouteToHostException(NoRouteToHostException noRouteToHostException, SocketAddress socketAddress) {
            super(noRouteToHostException.getMessage() + ": " + socketAddress);
            initCause(noRouteToHostException);
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class AnnotatedSocketException extends SocketException {
        private static final long serialVersionUID = 3896743275010454039L;

        public AnnotatedSocketException(SocketException socketException, SocketAddress socketAddress) {
            super(socketException.getMessage() + ": " + socketAddress);
            initCause(socketException);
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class CloseFuture extends DefaultChannelPromise {
        public CloseFuture(AbstractChannel abstractChannel) {
            super(abstractChannel);
        }

        public boolean setClosed() {
            return super.trySuccess();
        }

        public ChannelPromise setSuccess() {
            throw new IllegalStateException();
        }

        public boolean tryFailure(Throwable th) {
            throw new IllegalStateException();
        }

        public boolean trySuccess() {
            throw new IllegalStateException();
        }

        public ChannelPromise setFailure(Throwable th) {
            throw new IllegalStateException();
        }
    }

    public AbstractChannel(Channel channel) {
        this.parent = channel;
        this.id = newId();
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        return this.pipeline.bind(socketAddress);
    }

    public long bytesBeforeUnwritable() {
        ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        if (outboundBuffer != null) {
            return outboundBuffer.bytesBeforeUnwritable();
        }
        return 0;
    }

    public long bytesBeforeWritable() {
        ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        return outboundBuffer != null ? outboundBuffer.bytesBeforeWritable() : LongCompanionObject.MAX_VALUE;
    }

    public ChannelFuture close() {
        return this.pipeline.close();
    }

    public ChannelFuture closeFuture() {
        return this.closeFuture;
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        return this.pipeline.connect(socketAddress);
    }

    public ChannelFuture deregister() {
        return this.pipeline.deregister();
    }

    public ChannelFuture disconnect() {
        return this.pipeline.disconnect();
    }

    public abstract void doBeginRead() throws Exception;

    public abstract void doBind(SocketAddress socketAddress) throws Exception;

    public abstract void doClose() throws Exception;

    public void doDeregister() throws Exception {
    }

    public abstract void doDisconnect() throws Exception;

    public void doRegister() throws Exception {
    }

    public void doShutdownOutput() throws Exception {
        doClose();
    }

    public abstract void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception;

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public EventLoop eventLoop() {
        EventLoop eventLoop2 = this.eventLoop;
        if (eventLoop2 != null) {
            return eventLoop2;
        }
        throw new IllegalStateException("channel not registered to an event loop");
    }

    public Object filterOutboundMessage(Object obj) throws Exception {
        return obj;
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    public final ChannelId id() {
        return this.id;
    }

    @Deprecated
    public void invalidateLocalAddress() {
        this.localAddress = null;
    }

    @Deprecated
    public void invalidateRemoteAddress() {
        this.remoteAddress = null;
    }

    public abstract boolean isCompatible(EventLoop eventLoop2);

    public boolean isRegistered() {
        return this.registered;
    }

    public boolean isWritable() {
        ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        return outboundBuffer != null && outboundBuffer.isWritable();
    }

    public SocketAddress localAddress() {
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress localAddress2 = unsafe().localAddress();
            this.localAddress = localAddress2;
            return localAddress2;
        } catch (Error e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract SocketAddress localAddress0();

    public final int maxMessagesPerWrite() {
        ChannelConfig config = config();
        if (config instanceof DefaultChannelConfig) {
            return ((DefaultChannelConfig) config).getMaxMessagesPerWrite();
        }
        Integer num = (Integer) config.getOption(ChannelOption.MAX_MESSAGES_PER_WRITE);
        if (num == null) {
            return Integer.MAX_VALUE;
        }
        return num.intValue();
    }

    public DefaultChannelPipeline newChannelPipeline() {
        return new DefaultChannelPipeline(this);
    }

    public ChannelFuture newFailedFuture(Throwable th) {
        return this.pipeline.newFailedFuture(th);
    }

    public ChannelId newId() {
        return DefaultChannelId.newInstance();
    }

    public ChannelProgressivePromise newProgressivePromise() {
        return this.pipeline.newProgressivePromise();
    }

    public ChannelPromise newPromise() {
        return this.pipeline.newPromise();
    }

    public ChannelFuture newSucceededFuture() {
        return this.pipeline.newSucceededFuture();
    }

    public abstract AbstractUnsafe newUnsafe();

    public Channel parent() {
        return this.parent;
    }

    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    public SocketAddress remoteAddress() {
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress remoteAddress2 = unsafe().remoteAddress();
            this.remoteAddress = remoteAddress2;
            return remoteAddress2;
        } catch (Error e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract SocketAddress remoteAddress0();

    public String toString() {
        String str;
        boolean isActive = isActive();
        if (this.strValActive == isActive && (str = this.strVal) != null) {
            return str;
        }
        SocketAddress remoteAddress2 = remoteAddress();
        SocketAddress localAddress2 = localAddress();
        if (remoteAddress2 != null) {
            StringBuilder sb = new StringBuilder(96);
            sb.append("[id: 0x");
            sb.append(this.id.asShortText());
            sb.append(", L:");
            sb.append(localAddress2);
            sb.append(isActive ? " - " : " ! ");
            sb.append("R:");
            sb.append(remoteAddress2);
            sb.append(']');
            this.strVal = sb.toString();
        } else if (localAddress2 != null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("[id: 0x");
            sb2.append(this.id.asShortText());
            sb2.append(", L:");
            sb2.append(localAddress2);
            sb2.append(']');
            this.strVal = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder(16);
            sb3.append("[id: 0x");
            sb3.append(this.id.asShortText());
            sb3.append(']');
            this.strVal = sb3.toString();
        }
        this.strValActive = isActive;
        return this.strVal;
    }

    public Channel.Unsafe unsafe() {
        return this.unsafe;
    }

    public void validateFileRegion(DefaultFileRegion defaultFileRegion, long j) throws IOException {
        DefaultFileRegion.validate(defaultFileRegion, j);
    }

    public final ChannelPromise voidPromise() {
        return this.pipeline.voidPromise();
    }

    public ChannelFuture write(Object obj) {
        return this.pipeline.write(obj);
    }

    public ChannelFuture writeAndFlush(Object obj) {
        return this.pipeline.writeAndFlush(obj);
    }

    public abstract class AbstractUnsafe implements Channel.Unsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean inFlush0;
        private boolean neverRegistered = true;
        private volatile ChannelOutboundBuffer outboundBuffer;
        private RecvByteBufAllocator.Handle recvHandle;

        public AbstractUnsafe() {
            this.outboundBuffer = new ChannelOutboundBuffer(AbstractChannel.this);
        }

        private void assertEventLoop() {
        }

        private void closeOutboundBufferForShutdown(ChannelPipeline channelPipeline, ChannelOutboundBuffer channelOutboundBuffer, Throwable th) {
            channelOutboundBuffer.failFlushed(th, false);
            channelOutboundBuffer.close(th, true);
            channelPipeline.fireUserEventTriggered(ChannelOutputShutdownEvent.INSTANCE);
        }

        /* access modifiers changed from: private */
        public void doClose0(ChannelPromise channelPromise) {
            try {
                AbstractChannel.this.doClose();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetSuccess(channelPromise);
            } catch (Throwable th) {
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        /* access modifiers changed from: private */
        public void fireChannelInactiveAndDeregister(boolean z) {
            deregister(voidPromise(), z && !AbstractChannel.this.isActive());
        }

        /* access modifiers changed from: private */
        public void invokeLater(Runnable runnable) {
            try {
                AbstractChannel.this.eventLoop().execute(runnable);
            } catch (RejectedExecutionException e) {
                AbstractChannel.logger.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e);
            }
        }

        private ClosedChannelException newClosedChannelException(Throwable th, String str) {
            StacklessClosedChannelException newInstance = StacklessClosedChannelException.newInstance(AbstractUnsafe.class, str);
            if (th != null) {
                newInstance.initCause(th);
            }
            return newInstance;
        }

        /* access modifiers changed from: private */
        public void register0(ChannelPromise channelPromise) {
            try {
                if (!channelPromise.setUncancellable()) {
                    return;
                }
                if (ensureOpen(channelPromise)) {
                    boolean z = this.neverRegistered;
                    AbstractChannel.this.doRegister();
                    this.neverRegistered = false;
                    boolean unused = AbstractChannel.this.registered = true;
                    AbstractChannel.this.pipeline.invokeHandlerAddedIfNeeded();
                    safeSetSuccess(channelPromise);
                    AbstractChannel.this.pipeline.fireChannelRegistered();
                    if (!AbstractChannel.this.isActive()) {
                        return;
                    }
                    if (z) {
                        AbstractChannel.this.pipeline.fireChannelActive();
                    } else if (AbstractChannel.this.config().isAutoRead()) {
                        beginRead();
                    }
                }
            } catch (Throwable th) {
                closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        public final Throwable annotateConnectException(Throwable th, SocketAddress socketAddress) {
            return th instanceof ConnectException ? new AnnotatedConnectException((ConnectException) th, socketAddress) : th instanceof NoRouteToHostException ? new AnnotatedNoRouteToHostException((NoRouteToHostException) th, socketAddress) : th instanceof SocketException ? new AnnotatedSocketException((SocketException) th, socketAddress) : th;
        }

        public final void beginRead() {
            assertEventLoop();
            try {
                AbstractChannel.this.doBeginRead();
            } catch (Exception e) {
                invokeLater(new Runnable() {
                    public void run() {
                        AbstractChannel.this.pipeline.fireExceptionCaught((Throwable) e);
                    }
                });
                close(voidPromise());
            }
        }

        public final void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            assertEventLoop();
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                if (Boolean.TRUE.equals(AbstractChannel.this.config().getOption(ChannelOption.SO_BROADCAST)) && (socketAddress instanceof InetSocketAddress) && !((InetSocketAddress) socketAddress).getAddress().isAnyLocalAddress() && !PlatformDependent.isWindows() && !PlatformDependent.maybeSuperUser()) {
                    InternalLogger access$300 = AbstractChannel.logger;
                    access$300.warn("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (" + socketAddress + ") anyway as requested.");
                }
                boolean isActive = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doBind(socketAddress);
                    if (!isActive && AbstractChannel.this.isActive()) {
                        invokeLater(new Runnable() {
                            public void run() {
                                AbstractChannel.this.pipeline.fireChannelActive();
                            }
                        });
                    }
                    safeSetSuccess(channelPromise);
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    closeIfClosed();
                }
            }
        }

        public void close(ChannelPromise channelPromise) {
            assertEventLoop();
            StacklessClosedChannelException newInstance = StacklessClosedChannelException.newInstance(AbstractChannel.class, "close(ChannelPromise)");
            close(channelPromise, newInstance, newInstance, false);
        }

        public final void closeForcibly() {
            assertEventLoop();
            try {
                AbstractChannel.this.doClose();
            } catch (Exception e) {
                AbstractChannel.logger.warn("Failed to close a channel.", (Throwable) e);
            }
        }

        public final void closeIfClosed() {
            if (!AbstractChannel.this.isOpen()) {
                close(voidPromise());
            }
        }

        public final void deregister(ChannelPromise channelPromise) {
            assertEventLoop();
            deregister(channelPromise, false);
        }

        public final void disconnect(ChannelPromise channelPromise) {
            assertEventLoop();
            if (channelPromise.setUncancellable()) {
                boolean isActive = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doDisconnect();
                    SocketAddress unused = AbstractChannel.this.remoteAddress = null;
                    SocketAddress unused2 = AbstractChannel.this.localAddress = null;
                    if (isActive && !AbstractChannel.this.isActive()) {
                        invokeLater(new Runnable() {
                            public void run() {
                                AbstractChannel.this.pipeline.fireChannelInactive();
                            }
                        });
                    }
                    safeSetSuccess(channelPromise);
                    closeIfClosed();
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    closeIfClosed();
                }
            }
        }

        public final boolean ensureOpen(ChannelPromise channelPromise) {
            if (AbstractChannel.this.isOpen()) {
                return true;
            }
            safeSetFailure(channelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause, "ensureOpen(ChannelPromise)"));
            return false;
        }

        public final void flush() {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer != null) {
                channelOutboundBuffer.addFlush();
                flush0();
            }
        }

        public void flush0() {
            ChannelOutboundBuffer channelOutboundBuffer;
            if (!this.inFlush0 && (channelOutboundBuffer = this.outboundBuffer) != null && !channelOutboundBuffer.isEmpty()) {
                this.inFlush0 = true;
                if (!AbstractChannel.this.isActive()) {
                    try {
                        if (!channelOutboundBuffer.isEmpty()) {
                            if (AbstractChannel.this.isOpen()) {
                                channelOutboundBuffer.failFlushed(new NotYetConnectedException(), true);
                            } else {
                                channelOutboundBuffer.failFlushed(newClosedChannelException(AbstractChannel.this.initialCloseCause, "flush0()"), false);
                            }
                        }
                    } finally {
                        this.inFlush0 = false;
                    }
                } else {
                    try {
                        AbstractChannel.this.doWrite(channelOutboundBuffer);
                    } catch (Throwable th) {
                        this.inFlush0 = false;
                        throw th;
                    }
                    this.inFlush0 = false;
                }
            }
        }

        public final void handleWriteError(Throwable th) {
            if (!(th instanceof IOException) || !AbstractChannel.this.config().isAutoClose()) {
                try {
                    shutdownOutput(voidPromise(), th);
                } catch (Throwable th2) {
                    Throwable unused = AbstractChannel.this.initialCloseCause = th;
                    close(voidPromise(), th2, newClosedChannelException(th, "flush0()"), false);
                }
            } else {
                Throwable unused2 = AbstractChannel.this.initialCloseCause = th;
                close(voidPromise(), th, newClosedChannelException(th, "flush0()"), false);
            }
        }

        public final SocketAddress localAddress() {
            return AbstractChannel.this.localAddress0();
        }

        public final ChannelOutboundBuffer outboundBuffer() {
            return this.outboundBuffer;
        }

        public Executor prepareToClose() {
            return null;
        }

        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                this.recvHandle = AbstractChannel.this.config().getRecvByteBufAllocator().newHandle();
            }
            return this.recvHandle;
        }

        public final void register(EventLoop eventLoop, final ChannelPromise channelPromise) {
            ObjectUtil.checkNotNull(eventLoop, "eventLoop");
            if (AbstractChannel.this.isRegistered()) {
                channelPromise.setFailure(new IllegalStateException("registered to an event loop already"));
            } else if (!AbstractChannel.this.isCompatible(eventLoop)) {
                channelPromise.setFailure(new IllegalStateException("incompatible event loop type: " + eventLoop.getClass().getName()));
            } else {
                EventLoop unused = AbstractChannel.this.eventLoop = eventLoop;
                if (eventLoop.inEventLoop()) {
                    register0(channelPromise);
                    return;
                }
                try {
                    eventLoop.execute(new Runnable() {
                        public void run() {
                            AbstractUnsafe.this.register0(channelPromise);
                        }
                    });
                } catch (Throwable th) {
                    AbstractChannel.logger.warn("Force-closing a channel whose registration task was not accepted by an event loop: {}", AbstractChannel.this, th);
                    closeForcibly();
                    AbstractChannel.this.closeFuture.setClosed();
                    safeSetFailure(channelPromise, th);
                }
            }
        }

        public final SocketAddress remoteAddress() {
            return AbstractChannel.this.remoteAddress0();
        }

        public final void safeSetFailure(ChannelPromise channelPromise, Throwable th) {
            if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.tryFailure(th)) {
                AbstractChannel.logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
            }
        }

        public final void safeSetSuccess(ChannelPromise channelPromise) {
            if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.trySuccess()) {
                AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", (Object) channelPromise);
            }
        }

        public final void shutdownOutput(ChannelPromise channelPromise) {
            assertEventLoop();
            shutdownOutput(channelPromise, (Throwable) null);
        }

        public final ChannelPromise voidPromise() {
            assertEventLoop();
            return AbstractChannel.this.unsafeVoidPromise;
        }

        public final void write(Object obj, ChannelPromise channelPromise) {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                try {
                    ReferenceCountUtil.release(obj);
                } finally {
                    safeSetFailure(channelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause, "write(Object, ChannelPromise)"));
                }
            } else {
                try {
                    Object filterOutboundMessage = AbstractChannel.this.filterOutboundMessage(obj);
                    int size = AbstractChannel.this.pipeline.estimatorHandle().size(filterOutboundMessage);
                    if (size < 0) {
                        size = 0;
                    }
                    channelOutboundBuffer.addMessage(filterOutboundMessage, size, channelPromise);
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    throw th;
                }
            }
        }

        private void deregister(final ChannelPromise channelPromise, final boolean z) {
            if (channelPromise.setUncancellable()) {
                if (!AbstractChannel.this.registered) {
                    safeSetSuccess(channelPromise);
                } else {
                    invokeLater(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
                            if (io.netty.channel.AbstractChannel.access$000(r4.this$1.this$0) == false) goto L_0x0033;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
                            if (io.netty.channel.AbstractChannel.access$000(r4.this$1.this$0) != false) goto L_0x0021;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
                            io.netty.channel.AbstractChannel.access$002(r4.this$1.this$0, false);
                            io.netty.channel.AbstractChannel.access$500(r4.this$1.this$0).fireChannelUnregistered();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
                            r4.this$1.safeSetSuccess(r2);
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r4 = this;
                                r0 = 0
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this     // Catch:{ all -> 0x003b }
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this     // Catch:{ all -> 0x003b }
                                r1.doDeregister()     // Catch:{ all -> 0x003b }
                                boolean r1 = r3
                                if (r1 == 0) goto L_0x0017
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r1 = r1.pipeline
                                r1.fireChannelInactive()
                            L_0x0017:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                boolean r1 = r1.registered
                                if (r1 == 0) goto L_0x0033
                            L_0x0021:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                boolean unused = r1.registered = r0
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r0 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r0 = r0.pipeline
                                r0.fireChannelUnregistered()
                            L_0x0033:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.ChannelPromise r4 = r2
                                r0.safeSetSuccess(r4)
                                goto L_0x005f
                            L_0x003b:
                                r1 = move-exception
                                io.netty.util.internal.logging.InternalLogger r2 = io.netty.channel.AbstractChannel.logger     // Catch:{ all -> 0x0060 }
                                java.lang.String r3 = "Unexpected exception occurred while deregistering a channel."
                                r2.warn((java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0060 }
                                boolean r1 = r3
                                if (r1 == 0) goto L_0x0054
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r1 = r1.pipeline
                                r1.fireChannelInactive()
                            L_0x0054:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r1 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r1 = io.netty.channel.AbstractChannel.this
                                boolean r1 = r1.registered
                                if (r1 == 0) goto L_0x0033
                                goto L_0x0021
                            L_0x005f:
                                return
                            L_0x0060:
                                r1 = move-exception
                                boolean r2 = r3
                                if (r2 == 0) goto L_0x0070
                                io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r2 = r2.pipeline
                                r2.fireChannelInactive()
                            L_0x0070:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                                boolean r2 = r2.registered
                                if (r2 == 0) goto L_0x008c
                                io.netty.channel.AbstractChannel$AbstractUnsafe r2 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r2 = io.netty.channel.AbstractChannel.this
                                boolean unused = r2.registered = r0
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.AbstractChannel r0 = io.netty.channel.AbstractChannel.this
                                io.netty.channel.DefaultChannelPipeline r0 = r0.pipeline
                                r0.fireChannelUnregistered()
                            L_0x008c:
                                io.netty.channel.AbstractChannel$AbstractUnsafe r0 = io.netty.channel.AbstractChannel.AbstractUnsafe.this
                                io.netty.channel.ChannelPromise r4 = r2
                                r0.safeSetSuccess(r4)
                                throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractChannel.AbstractUnsafe.AnonymousClass7.run():void");
                        }
                    });
                }
            }
        }

        private void shutdownOutput(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise.setUncancellable()) {
                ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
                if (channelOutboundBuffer == null) {
                    channelPromise.setFailure(new ClosedChannelException());
                    return;
                }
                this.outboundBuffer = null;
                ChannelOutputShutdownException channelOutputShutdownException = th == null ? new ChannelOutputShutdownException("Channel output shutdown") : new ChannelOutputShutdownException("Channel output shutdown", th);
                try {
                    AbstractChannel.this.doShutdownOutput();
                    channelPromise.setSuccess();
                } catch (Throwable th2) {
                    closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer, channelOutputShutdownException);
                    throw th2;
                }
                closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer, channelOutputShutdownException);
            }
        }

        private void close(final ChannelPromise channelPromise, Throwable th, ClosedChannelException closedChannelException, boolean z) {
            if (channelPromise.setUncancellable()) {
                if (!AbstractChannel.this.closeInitiated) {
                    boolean unused = AbstractChannel.this.closeInitiated = true;
                    final boolean isActive = AbstractChannel.this.isActive();
                    final ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
                    this.outboundBuffer = null;
                    Executor prepareToClose = prepareToClose();
                    if (prepareToClose != null) {
                        final ChannelPromise channelPromise2 = channelPromise;
                        final Throwable th2 = th;
                        final boolean z2 = z;
                        final ClosedChannelException closedChannelException2 = closedChannelException;
                        prepareToClose.execute(new Runnable() {
                            public void run() {
                                try {
                                    AbstractUnsafe.this.doClose0(channelPromise2);
                                } finally {
                                    AbstractUnsafe.this.invokeLater(new Runnable() {
                                        public void run() {
                                            AnonymousClass5 r0 = AnonymousClass5.this;
                                            ChannelOutboundBuffer channelOutboundBuffer = channelOutboundBuffer;
                                            if (channelOutboundBuffer != null) {
                                                channelOutboundBuffer.failFlushed(th2, z2);
                                                AnonymousClass5 r02 = AnonymousClass5.this;
                                                channelOutboundBuffer.close(closedChannelException2);
                                            }
                                            AnonymousClass5 r3 = AnonymousClass5.this;
                                            AbstractUnsafe.this.fireChannelInactiveAndDeregister(isActive);
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                    try {
                        doClose0(channelPromise);
                        if (this.inFlush0) {
                            invokeLater(new Runnable() {
                                public void run() {
                                    AbstractUnsafe.this.fireChannelInactiveAndDeregister(isActive);
                                }
                            });
                        } else {
                            fireChannelInactiveAndDeregister(isActive);
                        }
                    } finally {
                        if (channelOutboundBuffer != null) {
                            channelOutboundBuffer.failFlushed(th, z);
                            channelOutboundBuffer.close(closedChannelException);
                        }
                    }
                } else if (AbstractChannel.this.closeFuture.isDone()) {
                    safeSetSuccess(channelPromise);
                } else if (!(channelPromise instanceof VoidChannelPromise)) {
                    AbstractChannel.this.closeFuture.addListener((GenericFutureListener) new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            channelPromise.setSuccess();
                        }
                    });
                }
            }
        }
    }

    public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.pipeline.bind(socketAddress, channelPromise);
    }

    public ChannelFuture close(ChannelPromise channelPromise) {
        return this.pipeline.close(channelPromise);
    }

    public final int compareTo(Channel channel) {
        if (this == channel) {
            return 0;
        }
        return id().compareTo(channel.id());
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return this.pipeline.connect(socketAddress, socketAddress2);
    }

    public ChannelFuture deregister(ChannelPromise channelPromise) {
        return this.pipeline.deregister(channelPromise);
    }

    public ChannelFuture disconnect(ChannelPromise channelPromise) {
        return this.pipeline.disconnect(channelPromise);
    }

    public Channel flush() {
        this.pipeline.flush();
        return this;
    }

    public Channel read() {
        this.pipeline.read();
        return this;
    }

    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        return this.pipeline.write(obj, channelPromise);
    }

    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        return this.pipeline.writeAndFlush(obj, channelPromise);
    }

    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, channelPromise);
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, socketAddress2, channelPromise);
    }

    public AbstractChannel(Channel channel, ChannelId channelId) {
        this.parent = channel;
        this.id = channelId;
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }
}
