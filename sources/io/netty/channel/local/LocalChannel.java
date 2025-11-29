package io.netty.channel.local;

import com.honey.account.i.a;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.ConnectException;
import java.net.SocketAddress;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class LocalChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater<LocalChannel, Future> FINISH_READ_FUTURE_UPDATER;
    private static final int MAX_READER_STACK_DEPTH = 8;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final InternalLogger logger;
    private final ChannelConfig config;
    /* access modifiers changed from: private */
    public volatile ChannelPromise connectPromise;
    private volatile Future<?> finishReadFuture;
    final Queue<Object> inboundBuffer = PlatformDependent.newSpscQueue();
    private volatile LocalAddress localAddress;
    /* access modifiers changed from: private */
    public volatile LocalChannel peer;
    private volatile boolean readInProgress;
    private final Runnable readTask = new Runnable() {
        public void run() {
            if (!LocalChannel.this.inboundBuffer.isEmpty()) {
                LocalChannel.this.readInbound();
            }
        }
    };
    private volatile LocalAddress remoteAddress;
    private final Runnable shutdownHook = new Runnable() {
        public void run() {
            LocalChannel.this.unsafe().close(LocalChannel.this.unsafe().voidPromise());
        }
    };
    /* access modifiers changed from: private */
    public volatile State state;
    private volatile boolean writeInProgress;

    /* renamed from: io.netty.channel.local.LocalChannel$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$local$LocalChannel$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.channel.local.LocalChannel$State[] r0 = io.netty.channel.local.LocalChannel.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$channel$local$LocalChannel$State = r0
                io.netty.channel.local.LocalChannel$State r1 = io.netty.channel.local.LocalChannel.State.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$channel$local$LocalChannel$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.channel.local.LocalChannel$State r1 = io.netty.channel.local.LocalChannel.State.BOUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$channel$local$LocalChannel$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.channel.local.LocalChannel$State r1 = io.netty.channel.local.LocalChannel.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$channel$local$LocalChannel$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.channel.local.LocalChannel$State r1 = io.netty.channel.local.LocalChannel.State.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.local.LocalChannel.AnonymousClass6.<clinit>():void");
        }
    }

    public class LocalUnsafe extends AbstractChannel.AbstractUnsafe {
        private LocalUnsafe() {
            super();
        }

        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                if (LocalChannel.this.state == State.CONNECTED) {
                    AlreadyConnectedException alreadyConnectedException = new AlreadyConnectedException();
                    safeSetFailure(channelPromise, alreadyConnectedException);
                    LocalChannel.this.pipeline().fireExceptionCaught(alreadyConnectedException);
                } else if (LocalChannel.this.connectPromise == null) {
                    ChannelPromise unused = LocalChannel.this.connectPromise = channelPromise;
                    if (LocalChannel.this.state != State.BOUND && socketAddress2 == null) {
                        socketAddress2 = new LocalAddress((Channel) LocalChannel.this);
                    }
                    if (socketAddress2 != null) {
                        try {
                            LocalChannel.this.doBind(socketAddress2);
                        } catch (Throwable th) {
                            safeSetFailure(channelPromise, th);
                            close(voidPromise());
                            return;
                        }
                    }
                    Channel channel = LocalChannelRegistry.get(socketAddress);
                    if (!(channel instanceof LocalServerChannel)) {
                        safeSetFailure(channelPromise, new ConnectException("connection refused: " + socketAddress));
                        close(voidPromise());
                        return;
                    }
                    LocalChannel localChannel = LocalChannel.this;
                    LocalChannel unused2 = localChannel.peer = ((LocalServerChannel) channel).serve(localChannel);
                } else {
                    throw new ConnectionPendingException();
                }
            }
        }
    }

    public enum State {
        OPEN,
        BOUND,
        CONNECTED,
        CLOSED
    }

    static {
        Class<LocalChannel> cls = LocalChannel.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        FINISH_READ_FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(cls, Future.class, "finishReadFuture");
    }

    public LocalChannel() {
        super((Channel) null);
        DefaultChannelConfig defaultChannelConfig = new DefaultChannelConfig(this);
        this.config = defaultChannelConfig;
        config().setAllocator(new PreferHeapByteBufAllocator(defaultChannelConfig.getAllocator()));
    }

    private void finishPeerRead(LocalChannel localChannel) {
        if (localChannel.eventLoop() != eventLoop() || localChannel.writeInProgress) {
            runFinishPeerReadTask(localChannel);
        } else {
            finishPeerRead0(localChannel);
        }
    }

    /* access modifiers changed from: private */
    public void finishPeerRead0(LocalChannel localChannel) {
        Future<?> future = localChannel.finishReadFuture;
        if (future != null) {
            if (!future.isDone()) {
                runFinishPeerReadTask(localChannel);
                return;
            }
            a.a(FINISH_READ_FUTURE_UPDATER, localChannel, future, (Object) null);
        }
        if (localChannel.readInProgress && !localChannel.inboundBuffer.isEmpty()) {
            localChannel.readInProgress = false;
            localChannel.readInbound();
        }
    }

    /* access modifiers changed from: private */
    public void readInbound() {
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.reset(config());
        ChannelPipeline pipeline = pipeline();
        do {
            Object poll = this.inboundBuffer.poll();
            if (poll == null) {
                break;
            }
            pipeline.fireChannelRead(poll);
        } while (recvBufAllocHandle.continueReading());
        recvBufAllocHandle.readComplete();
        pipeline.fireChannelReadComplete();
    }

    private void releaseInboundBuffers() {
        this.readInProgress = false;
        Queue<Object> queue = this.inboundBuffer;
        while (true) {
            Object poll = queue.poll();
            if (poll != null) {
                ReferenceCountUtil.release(poll);
            } else {
                return;
            }
        }
    }

    private void runFinishPeerReadTask(final LocalChannel localChannel) {
        AnonymousClass5 r0 = new Runnable() {
            public void run() {
                LocalChannel.this.finishPeerRead0(localChannel);
            }
        };
        try {
            if (localChannel.writeInProgress) {
                localChannel.finishReadFuture = localChannel.eventLoop().submit((Runnable) r0);
            } else {
                localChannel.eventLoop().execute(r0);
            }
        } catch (Throwable th) {
            logger.warn("Closing Local channels {}-{} because exception occurred!", this, localChannel, th);
            close();
            localChannel.close();
            PlatformDependent.throwException(th);
        }
    }

    /* access modifiers changed from: private */
    public void tryClose(boolean z) {
        if (z) {
            unsafe().close(unsafe().voidPromise());
        } else {
            releaseInboundBuffers();
        }
    }

    public ChannelConfig config() {
        return this.config;
    }

    public void doBeginRead() throws Exception {
        if (!this.readInProgress) {
            if (this.inboundBuffer.isEmpty()) {
                this.readInProgress = true;
                return;
            }
            InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
            int localChannelReaderStackDepth = internalThreadLocalMap.localChannelReaderStackDepth();
            if (localChannelReaderStackDepth < 8) {
                internalThreadLocalMap.setLocalChannelReaderStackDepth(localChannelReaderStackDepth + 1);
                try {
                    readInbound();
                } finally {
                    internalThreadLocalMap.setLocalChannelReaderStackDepth(localChannelReaderStackDepth);
                }
            } else {
                try {
                    eventLoop().execute(this.readTask);
                } catch (Throwable th) {
                    logger.warn("Closing Local channels {}-{} because exception occurred!", this, this.peer, th);
                    close();
                    this.peer.close();
                    PlatformDependent.throwException(th);
                }
            }
        }
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, socketAddress);
        this.state = State.BOUND;
    }

    public void doClose() throws Exception {
        EventLoop eventLoop;
        final LocalChannel localChannel = this.peer;
        State state2 = this.state;
        try {
            State state3 = State.CLOSED;
            if (state2 != state3) {
                if (this.localAddress != null) {
                    if (parent() == null) {
                        LocalChannelRegistry.unregister(this.localAddress);
                    }
                    this.localAddress = null;
                }
                this.state = state3;
                if (this.writeInProgress && localChannel != null) {
                    finishPeerRead(localChannel);
                }
                ChannelPromise channelPromise = this.connectPromise;
                if (channelPromise != null) {
                    channelPromise.tryFailure(new ClosedChannelException());
                    this.connectPromise = null;
                }
            }
            if (localChannel != null) {
                this.peer = null;
                eventLoop = localChannel.eventLoop();
                final boolean isActive = localChannel.isActive();
                eventLoop.execute(new Runnable() {
                    public void run() {
                        localChannel.tryClose(isActive);
                    }
                });
            }
        } catch (Throwable th) {
            if (!(state2 == null || state2 == State.CLOSED)) {
                releaseInboundBuffers();
            }
            throw th;
        }
        if (state2 != null && state2 != State.CLOSED) {
            releaseInboundBuffers();
        }
    }

    public void doDeregister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    public void doDisconnect() throws Exception {
        doClose();
    }

    public void doRegister() throws Exception {
        if (!(this.peer == null || parent() == null)) {
            final LocalChannel localChannel = this.peer;
            State state2 = State.CONNECTED;
            this.state = state2;
            localChannel.remoteAddress = parent() == null ? null : parent().localAddress();
            localChannel.state = state2;
            localChannel.eventLoop().execute(new Runnable() {
                public void run() {
                    ChannelPromise access$200 = localChannel.connectPromise;
                    if (access$200 != null && access$200.trySuccess()) {
                        localChannel.pipeline().fireChannelActive();
                    }
                }
            });
        }
        ((SingleThreadEventExecutor) eventLoop()).addShutdownHook(this.shutdownHook);
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int i = AnonymousClass6.$SwitchMap$io$netty$channel$local$LocalChannel$State[this.state.ordinal()];
        if (i == 1 || i == 2) {
            throw new NotYetConnectedException();
        } else if (i != 3) {
            LocalChannel localChannel = this.peer;
            this.writeInProgress = true;
            ClosedChannelException closedChannelException = null;
            while (true) {
                try {
                    Object current = channelOutboundBuffer.current();
                    if (current == null) {
                        this.writeInProgress = false;
                        finishPeerRead(localChannel);
                        return;
                    } else if (localChannel.state == State.CONNECTED) {
                        localChannel.inboundBuffer.add(ReferenceCountUtil.retain(current));
                        channelOutboundBuffer.remove();
                    } else {
                        if (closedChannelException == null) {
                            closedChannelException = new ClosedChannelException();
                        }
                        channelOutboundBuffer.remove(closedChannelException);
                    }
                } catch (Throwable th) {
                    this.writeInProgress = false;
                    throw th;
                }
            }
        } else {
            throw new ClosedChannelException();
        }
    }

    public boolean isActive() {
        return this.state == State.CONNECTED;
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof SingleThreadEventLoop;
    }

    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    public SocketAddress localAddress0() {
        return this.localAddress;
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new LocalUnsafe();
    }

    public SocketAddress remoteAddress0() {
        return this.remoteAddress;
    }

    public LocalAddress localAddress() {
        return (LocalAddress) super.localAddress();
    }

    public LocalServerChannel parent() {
        return (LocalServerChannel) super.parent();
    }

    public LocalAddress remoteAddress() {
        return (LocalAddress) super.remoteAddress();
    }

    public LocalChannel(LocalServerChannel localServerChannel, LocalChannel localChannel) {
        super(localServerChannel);
        DefaultChannelConfig defaultChannelConfig = new DefaultChannelConfig(this);
        this.config = defaultChannelConfig;
        config().setAllocator(new PreferHeapByteBufAllocator(defaultChannelConfig.getAllocator()));
        this.peer = localChannel;
        this.localAddress = localServerChannel.localAddress();
        this.remoteAddress = localChannel.localAddress();
    }
}
