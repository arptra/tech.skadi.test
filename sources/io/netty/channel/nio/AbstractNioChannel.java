package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.TimeUnit;

public abstract class AbstractNioChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractNioChannel.class);
    private final SelectableChannel ch;
    private final Runnable clearReadPendingRunnable = new Runnable() {
        public void run() {
            AbstractNioChannel.this.clearReadPending0();
        }
    };
    /* access modifiers changed from: private */
    public ChannelPromise connectPromise;
    /* access modifiers changed from: private */
    public Future<?> connectTimeoutFuture;
    protected final int readInterestOp;
    boolean readPending;
    /* access modifiers changed from: private */
    public SocketAddress requestedRemoteAddress;
    volatile SelectionKey selectionKey;

    public interface NioUnsafe extends Channel.Unsafe {
        SelectableChannel ch();

        void finishConnect();

        void forceFlush();

        void read();
    }

    public AbstractNioChannel(Channel channel, SelectableChannel selectableChannel, int i) {
        super(channel);
        this.ch = selectableChannel;
        this.readInterestOp = i;
        try {
            selectableChannel.configureBlocking(false);
        } catch (IOException e) {
            try {
                selectableChannel.close();
            } catch (IOException e2) {
                logger.warn("Failed to close a partially initialized socket.", (Throwable) e2);
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e);
        }
    }

    /* access modifiers changed from: private */
    public void clearReadPending0() {
        this.readPending = false;
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    /* access modifiers changed from: private */
    public void setReadPending0(boolean z) {
        this.readPending = z;
        if (!z) {
            ((AbstractNioUnsafe) unsafe()).removeReadOp();
        }
    }

    public final void clearReadPending() {
        if (isRegistered()) {
            NioEventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                clearReadPending0();
            } else {
                eventLoop.execute(this.clearReadPendingRunnable);
            }
        } else {
            this.readPending = false;
        }
    }

    public void doBeginRead() throws Exception {
        SelectionKey selectionKey2 = this.selectionKey;
        if (selectionKey2.isValid()) {
            this.readPending = true;
            int interestOps = selectionKey2.interestOps();
            int i = this.readInterestOp;
            if ((interestOps & i) == 0) {
                selectionKey2.interestOps(i | interestOps);
            }
        }
    }

    public void doClose() throws Exception {
        ChannelPromise channelPromise = this.connectPromise;
        if (channelPromise != null) {
            channelPromise.tryFailure(new ClosedChannelException());
            this.connectPromise = null;
        }
        Future<?> future = this.connectTimeoutFuture;
        if (future != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    public abstract boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception;

    public void doDeregister() throws Exception {
        eventLoop().cancel(selectionKey());
    }

    public abstract void doFinishConnect() throws Exception;

    public void doRegister() throws Exception {
        boolean z = false;
        while (true) {
            try {
                this.selectionKey = javaChannel().register(eventLoop().unwrappedSelector(), 0, this);
                return;
            } catch (CancelledKeyException e) {
                if (!z) {
                    eventLoop().selectNow();
                    z = true;
                } else {
                    throw e;
                }
            }
        }
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof NioEventLoop;
    }

    public boolean isOpen() {
        return this.ch.isOpen();
    }

    @Deprecated
    public boolean isReadPending() {
        return this.readPending;
    }

    public SelectableChannel javaChannel() {
        return this.ch;
    }

    public final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(byteBuf);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuffer = alloc.directBuffer(readableBytes);
            directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(byteBuf);
            return directBuffer;
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer == null) {
            return byteBuf;
        }
        threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(byteBuf);
        return threadLocalDirectBuffer;
    }

    public SelectionKey selectionKey() {
        return this.selectionKey;
    }

    @Deprecated
    public void setReadPending(final boolean z) {
        if (isRegistered()) {
            NioEventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                setReadPending0(z);
            } else {
                eventLoop.execute(new Runnable() {
                    public void run() {
                        AbstractNioChannel.this.setReadPending0(z);
                    }
                });
            }
        } else {
            this.readPending = z;
        }
    }

    public NioEventLoop eventLoop() {
        return (NioEventLoop) super.eventLoop();
    }

    public NioUnsafe unsafe() {
        return (NioUnsafe) super.unsafe();
    }

    public abstract class AbstractNioUnsafe extends AbstractChannel.AbstractUnsafe implements NioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public AbstractNioUnsafe() {
            super();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z) {
            if (channelPromise != null) {
                boolean isActive = AbstractNioChannel.this.isActive();
                boolean trySuccess = channelPromise.trySuccess();
                if (!z && isActive) {
                    AbstractNioChannel.this.pipeline().fireChannelActive();
                }
                if (!trySuccess) {
                    close(voidPromise());
                }
            }
        }

        private boolean isFlushPending() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            return selectionKey.isValid() && (selectionKey.interestOps() & 4) != 0;
        }

        public final SelectableChannel ch() {
            return AbstractNioChannel.this.javaChannel();
        }

        public final void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractNioChannel.this.connectPromise == null) {
                        boolean isActive = AbstractNioChannel.this.isActive();
                        if (AbstractNioChannel.this.doConnect(socketAddress, socketAddress2)) {
                            fulfillConnectPromise(channelPromise, isActive);
                            return;
                        }
                        ChannelPromise unused = AbstractNioChannel.this.connectPromise = channelPromise;
                        SocketAddress unused2 = AbstractNioChannel.this.requestedRemoteAddress = socketAddress;
                        int connectTimeoutMillis = AbstractNioChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractNioChannel abstractNioChannel = AbstractNioChannel.this;
                            Future unused3 = abstractNioChannel.connectTimeoutFuture = abstractNioChannel.eventLoop().schedule((Runnable) new Runnable() {
                                public void run() {
                                    ChannelPromise access$200 = AbstractNioChannel.this.connectPromise;
                                    if (access$200 != null && !access$200.isDone()) {
                                        if (access$200.tryFailure(new ConnectTimeoutException("connection timed out: " + socketAddress))) {
                                            AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                            abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                                        }
                                    }
                                }
                            }, (long) connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        channelPromise.addListener(new ChannelFutureListener() {
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isCancelled()) {
                                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    ChannelPromise unused = AbstractNioChannel.this.connectPromise = null;
                                    AbstractNioUnsafe abstractNioUnsafe = AbstractNioUnsafe.this;
                                    abstractNioUnsafe.close(abstractNioUnsafe.voidPromise());
                                }
                            }
                        });
                        return;
                    }
                    throw new ConnectionPendingException();
                } catch (Throwable th) {
                    channelPromise.tryFailure(annotateConnectException(th, socketAddress));
                    closeIfClosed();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (io.netty.channel.nio.AbstractNioChannel.access$400(r5.this$0) == null) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
            if (io.netty.channel.nio.AbstractNioChannel.access$400(r5.this$0) != null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
            io.netty.channel.nio.AbstractNioChannel.access$400(r5.this$0).cancel(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
            io.netty.channel.nio.AbstractNioChannel.access$202(r5.this$0, (io.netty.channel.ChannelPromise) null);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void finishConnect() {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this     // Catch:{ all -> 0x002d }
                boolean r2 = r2.isActive()     // Catch:{ all -> 0x002d }
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this     // Catch:{ all -> 0x002d }
                r3.doFinishConnect()     // Catch:{ all -> 0x002d }
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this     // Catch:{ all -> 0x002d }
                io.netty.channel.ChannelPromise r3 = r3.connectPromise     // Catch:{ all -> 0x002d }
                r5.fulfillConnectPromise((io.netty.channel.ChannelPromise) r3, (boolean) r2)     // Catch:{ all -> 0x002d }
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.util.concurrent.Future r2 = r2.connectTimeoutFuture
                if (r2 == 0) goto L_0x0027
            L_0x001e:
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.util.concurrent.Future r2 = r2.connectTimeoutFuture
                r2.cancel(r1)
            L_0x0027:
                io.netty.channel.nio.AbstractNioChannel r5 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.channel.ChannelPromise unused = r5.connectPromise = r0
                goto L_0x004a
            L_0x002d:
                r2 = move-exception
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this     // Catch:{ all -> 0x004b }
                io.netty.channel.ChannelPromise r3 = r3.connectPromise     // Catch:{ all -> 0x004b }
                io.netty.channel.nio.AbstractNioChannel r4 = io.netty.channel.nio.AbstractNioChannel.this     // Catch:{ all -> 0x004b }
                java.net.SocketAddress r4 = r4.requestedRemoteAddress     // Catch:{ all -> 0x004b }
                java.lang.Throwable r2 = r5.annotateConnectException(r2, r4)     // Catch:{ all -> 0x004b }
                r5.fulfillConnectPromise((io.netty.channel.ChannelPromise) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x004b }
                io.netty.channel.nio.AbstractNioChannel r2 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.util.concurrent.Future r2 = r2.connectTimeoutFuture
                if (r2 == 0) goto L_0x0027
                goto L_0x001e
            L_0x004a:
                return
            L_0x004b:
                r2 = move-exception
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.util.concurrent.Future r3 = r3.connectTimeoutFuture
                if (r3 == 0) goto L_0x005d
                io.netty.channel.nio.AbstractNioChannel r3 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.util.concurrent.Future r3 = r3.connectTimeoutFuture
                r3.cancel(r1)
            L_0x005d:
                io.netty.channel.nio.AbstractNioChannel r5 = io.netty.channel.nio.AbstractNioChannel.this
                io.netty.channel.ChannelPromise unused = r5.connectPromise = r0
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe.finishConnect():void");
        }

        public final void flush0() {
            if (!isFlushPending()) {
                super.flush0();
            }
        }

        public final void forceFlush() {
            super.flush0();
        }

        public final void removeReadOp() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            if (selectionKey.isValid()) {
                int interestOps = selectionKey.interestOps();
                int i = AbstractNioChannel.this.readInterestOp;
                if ((interestOps & i) != 0) {
                    selectionKey.interestOps((~i) & interestOps);
                }
            }
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise != null) {
                channelPromise.tryFailure(th);
                closeIfClosed();
            }
        }
    }

    public final ByteBuf newDirectBuffer(ReferenceCounted referenceCounted, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            ByteBuf directBuffer = alloc.directBuffer(readableBytes);
            directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return directBuffer;
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer != null) {
            threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return threadLocalDirectBuffer;
        }
        if (referenceCounted != byteBuf) {
            byteBuf.retain();
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
        return byteBuf;
    }
}
