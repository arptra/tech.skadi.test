package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.TimeUnit;

abstract class AbstractEpollChannel extends AbstractChannel implements UnixChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    protected volatile boolean active;
    /* access modifiers changed from: private */
    public ChannelPromise connectPromise;
    /* access modifiers changed from: private */
    public Future<?> connectTimeoutFuture;
    boolean epollInReadyRunnablePending;
    protected int flags;
    boolean inputClosedSeenErrorOnRead;
    private volatile SocketAddress local;
    /* access modifiers changed from: private */
    public volatile SocketAddress remote;
    /* access modifiers changed from: private */
    public SocketAddress requestedRemoteAddress;
    final LinuxSocket socket;

    public abstract class AbstractEpollUnsafe extends AbstractChannel.AbstractUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private EpollRecvByteAllocatorHandle allocHandle;
        private final Runnable epollInReadyRunnable = new Runnable() {
            public void run() {
                AbstractEpollUnsafe abstractEpollUnsafe = AbstractEpollUnsafe.this;
                AbstractEpollChannel.this.epollInReadyRunnablePending = false;
                abstractEpollUnsafe.epollInReady();
            }
        };
        boolean maybeMoreDataToRead;
        boolean readPending;

        public AbstractEpollUnsafe() {
            super();
        }

        private void clearEpollRdHup() {
            try {
                AbstractEpollChannel.this.clearFlag(Native.EPOLLRDHUP);
            } catch (IOException e) {
                AbstractEpollChannel.this.pipeline().fireExceptionCaught(e);
                close(voidPromise());
            }
        }

        private boolean doFinishConnect() throws Exception {
            if (AbstractEpollChannel.this.socket.finishConnect()) {
                AbstractEpollChannel.this.clearFlag(Native.EPOLLOUT);
                if (AbstractEpollChannel.this.requestedRemoteAddress instanceof InetSocketAddress) {
                    AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
                    SocketAddress unused = abstractEpollChannel.remote = UnixChannelUtil.computeRemoteAddr((InetSocketAddress) abstractEpollChannel.requestedRemoteAddress, AbstractEpollChannel.this.socket.remoteAddress());
                }
                SocketAddress unused2 = AbstractEpollChannel.this.requestedRemoteAddress = null;
                return true;
            }
            AbstractEpollChannel.this.setFlag(Native.EPOLLOUT);
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
            if (io.netty.channel.epoll.AbstractEpollChannel.access$300(r5.this$0) == null) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (io.netty.channel.epoll.AbstractEpollChannel.access$300(r5.this$0) != null) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
            io.netty.channel.epoll.AbstractEpollChannel.access$300(r5.this$0).cancel(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
            io.netty.channel.epoll.AbstractEpollChannel.access$102(r5.this$0, (io.netty.channel.ChannelPromise) null);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void finishConnect() {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch:{ all -> 0x002f }
                boolean r2 = r2.isActive()     // Catch:{ all -> 0x002f }
                boolean r3 = r5.doFinishConnect()     // Catch:{ all -> 0x002f }
                if (r3 != 0) goto L_0x000f
                return
            L_0x000f:
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch:{ all -> 0x002f }
                io.netty.channel.ChannelPromise r3 = r3.connectPromise     // Catch:{ all -> 0x002f }
                r5.fulfillConnectPromise((io.netty.channel.ChannelPromise) r3, (boolean) r2)     // Catch:{ all -> 0x002f }
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.util.concurrent.Future r2 = r2.connectTimeoutFuture
                if (r2 == 0) goto L_0x0029
            L_0x0020:
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.util.concurrent.Future r2 = r2.connectTimeoutFuture
                r2.cancel(r1)
            L_0x0029:
                io.netty.channel.epoll.AbstractEpollChannel r5 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.channel.ChannelPromise unused = r5.connectPromise = r0
                goto L_0x004c
            L_0x002f:
                r2 = move-exception
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch:{ all -> 0x004d }
                io.netty.channel.ChannelPromise r3 = r3.connectPromise     // Catch:{ all -> 0x004d }
                io.netty.channel.epoll.AbstractEpollChannel r4 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch:{ all -> 0x004d }
                java.net.SocketAddress r4 = r4.requestedRemoteAddress     // Catch:{ all -> 0x004d }
                java.lang.Throwable r2 = r5.annotateConnectException(r2, r4)     // Catch:{ all -> 0x004d }
                r5.fulfillConnectPromise((io.netty.channel.ChannelPromise) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x004d }
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.util.concurrent.Future r2 = r2.connectTimeoutFuture
                if (r2 == 0) goto L_0x0029
                goto L_0x0020
            L_0x004c:
                return
            L_0x004d:
                r2 = move-exception
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.util.concurrent.Future r3 = r3.connectTimeoutFuture
                if (r3 == 0) goto L_0x005f
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.util.concurrent.Future r3 = r3.connectTimeoutFuture
                r3.cancel(r1)
            L_0x005f:
                io.netty.channel.epoll.AbstractEpollChannel r5 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.channel.ChannelPromise unused = r5.connectPromise = r0
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.finishConnect():void");
        }

        private void fireEventAndClose(Object obj) {
            AbstractEpollChannel.this.pipeline().fireUserEventTriggered(obj);
            close(voidPromise());
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z) {
            if (channelPromise != null) {
                AbstractEpollChannel.this.active = true;
                boolean isActive = AbstractEpollChannel.this.isActive();
                boolean trySuccess = channelPromise.trySuccess();
                if (!z && isActive) {
                    AbstractEpollChannel.this.pipeline().fireChannelActive();
                }
                if (!trySuccess) {
                    close(voidPromise());
                }
            }
        }

        public final void clearEpollIn0() {
            try {
                this.readPending = false;
                AbstractEpollChannel.this.clearFlag(Native.EPOLLIN);
            } catch (IOException e) {
                AbstractEpollChannel.this.pipeline().fireExceptionCaught(e);
                AbstractEpollChannel.this.unsafe().close(AbstractEpollChannel.this.unsafe().voidPromise());
            }
        }

        public void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractEpollChannel.this.connectPromise == null) {
                        boolean isActive = AbstractEpollChannel.this.isActive();
                        if (AbstractEpollChannel.this.doConnect(socketAddress, socketAddress2)) {
                            fulfillConnectPromise(channelPromise, isActive);
                            return;
                        }
                        ChannelPromise unused = AbstractEpollChannel.this.connectPromise = channelPromise;
                        SocketAddress unused2 = AbstractEpollChannel.this.requestedRemoteAddress = socketAddress;
                        int connectTimeoutMillis = AbstractEpollChannel.this.config().getConnectTimeoutMillis();
                        if (connectTimeoutMillis > 0) {
                            AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
                            Future unused3 = abstractEpollChannel.connectTimeoutFuture = abstractEpollChannel.eventLoop().schedule((Runnable) new Runnable() {
                                public void run() {
                                    ChannelPromise access$100 = AbstractEpollChannel.this.connectPromise;
                                    if (access$100 != null && !access$100.isDone()) {
                                        if (access$100.tryFailure(new ConnectTimeoutException("connection timed out: " + socketAddress))) {
                                            AbstractEpollUnsafe abstractEpollUnsafe = AbstractEpollUnsafe.this;
                                            abstractEpollUnsafe.close(abstractEpollUnsafe.voidPromise());
                                        }
                                    }
                                }
                            }, (long) connectTimeoutMillis, TimeUnit.MILLISECONDS);
                        }
                        channelPromise.addListener(new ChannelFutureListener() {
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isCancelled()) {
                                    if (AbstractEpollChannel.this.connectTimeoutFuture != null) {
                                        AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
                                    }
                                    ChannelPromise unused = AbstractEpollChannel.this.connectPromise = null;
                                    AbstractEpollUnsafe abstractEpollUnsafe = AbstractEpollUnsafe.this;
                                    abstractEpollUnsafe.close(abstractEpollUnsafe.voidPromise());
                                }
                            }
                        });
                        return;
                    }
                    throw new ConnectionPendingException();
                } catch (Throwable th) {
                    closeIfClosed();
                    channelPromise.tryFailure(annotateConnectException(th, socketAddress));
                }
            }
        }

        public final void epollInBefore() {
            this.maybeMoreDataToRead = false;
        }

        public final void epollInFinally(ChannelConfig channelConfig) {
            boolean z;
            this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
            if (this.allocHandle.isReceivedRdHup() || ((z = this.readPending) && this.maybeMoreDataToRead)) {
                executeEpollInReadyRunnable(channelConfig);
            } else if (!z && !channelConfig.isAutoRead()) {
                AbstractEpollChannel.this.clearEpollIn();
            }
        }

        public abstract void epollInReady();

        public final void epollOutReady() {
            if (AbstractEpollChannel.this.connectPromise != null) {
                finishConnect();
            } else if (!AbstractEpollChannel.this.socket.isOutputShutdown()) {
                super.flush0();
            }
        }

        public final void epollRdHupReady() {
            recvBufAllocHandle().receivedRdHup();
            if (AbstractEpollChannel.this.isActive()) {
                epollInReady();
            } else {
                shutdownInput(true);
            }
            clearEpollRdHup();
        }

        public final void executeEpollInReadyRunnable(ChannelConfig channelConfig) {
            AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
            if (!abstractEpollChannel.epollInReadyRunnablePending && abstractEpollChannel.isActive() && !AbstractEpollChannel.this.shouldBreakEpollInReady(channelConfig)) {
                AbstractEpollChannel abstractEpollChannel2 = AbstractEpollChannel.this;
                abstractEpollChannel2.epollInReadyRunnablePending = true;
                abstractEpollChannel2.eventLoop().execute(this.epollInReadyRunnable);
            }
        }

        public final void flush0() {
            if (!AbstractEpollChannel.this.isFlagSet(Native.EPOLLOUT)) {
                super.flush0();
            }
        }

        public EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
            return new EpollRecvByteAllocatorHandle(extendedHandle);
        }

        public void shutdownInput(boolean z) {
            if (!AbstractEpollChannel.this.socket.isInputShutdown()) {
                if (AbstractEpollChannel.isAllowHalfClosure(AbstractEpollChannel.this.config())) {
                    try {
                        AbstractEpollChannel.this.socket.shutdown(true, false);
                    } catch (IOException unused) {
                        fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                        return;
                    } catch (NotYetConnectedException unused2) {
                    }
                    AbstractEpollChannel.this.clearEpollIn();
                    AbstractEpollChannel.this.pipeline().fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
                    return;
                }
                close(voidPromise());
            } else if (!z) {
                AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
                abstractEpollChannel.inputClosedSeenErrorOnRead = true;
                abstractEpollChannel.pipeline().fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
            }
        }

        public EpollRecvByteAllocatorHandle recvBufAllocHandle() {
            if (this.allocHandle == null) {
                this.allocHandle = newEpollHandle((RecvByteBufAllocator.ExtendedHandle) super.recvBufAllocHandle());
            }
            return this.allocHandle;
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise != null) {
                channelPromise.tryFailure(th);
                closeIfClosed();
            }
        }
    }

    public AbstractEpollChannel(LinuxSocket linuxSocket) {
        this((Channel) null, linuxSocket, false);
    }

    public static void checkResolvable(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    /* access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return channelConfig instanceof EpollDomainSocketChannelConfig ? ((EpollDomainSocketChannelConfig) channelConfig).isAllowHalfClosure() : (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    public static boolean isSoErrorZero(Socket socket2) {
        try {
            return socket2.getSoError() == 0;
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    private void modifyEvents() throws IOException {
        if (isOpen() && isRegistered()) {
            ((EpollEventLoop) eventLoop()).modify(this);
        }
    }

    private static ByteBuf newDirectBuffer0(Object obj, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, int i) {
        ByteBuf directBuffer = byteBufAllocator.directBuffer(i);
        directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
        ReferenceCountUtil.safeRelease(obj);
        return directBuffer;
    }

    public final void clearEpollIn() {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            final AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollUnsafe) unsafe();
            if (eventLoop.inEventLoop()) {
                abstractEpollUnsafe.clearEpollIn0();
            } else {
                eventLoop.execute(new Runnable() {
                    public void run() {
                        if (!abstractEpollUnsafe.readPending && !AbstractEpollChannel.this.config().isAutoRead()) {
                            abstractEpollUnsafe.clearEpollIn0();
                        }
                    }
                });
            }
        } else {
            this.flags &= ~Native.EPOLLIN;
        }
    }

    public void clearFlag(int i) throws IOException {
        if (isFlagSet(i)) {
            this.flags = (~i) & this.flags;
            modifyEvents();
        }
    }

    public abstract EpollChannelConfig config();

    public final void doBeginRead() throws Exception {
        AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollUnsafe) unsafe();
        abstractEpollUnsafe.readPending = true;
        setFlag(Native.EPOLLIN);
        if (abstractEpollUnsafe.maybeMoreDataToRead) {
            abstractEpollUnsafe.executeEpollInReadyRunnable(config());
        }
    }

    public void doBind(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress);
        }
        this.socket.bind(socketAddress);
        this.local = this.socket.localAddress();
    }

    public void doClose() throws Exception {
        this.active = false;
        this.inputClosedSeenErrorOnRead = true;
        try {
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
            if (isRegistered()) {
                EventLoop eventLoop = eventLoop();
                if (eventLoop.inEventLoop()) {
                    doDeregister();
                } else {
                    eventLoop.execute(new Runnable() {
                        public void run() {
                            try {
                                AbstractEpollChannel.this.doDeregister();
                            } catch (Throwable th) {
                                AbstractEpollChannel.this.pipeline().fireExceptionCaught(th);
                            }
                        }
                    });
                }
            }
        } finally {
            this.socket.close();
        }
    }

    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress2);
        }
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress != null) {
            checkResolvable(inetSocketAddress);
        }
        if (this.remote == null) {
            if (socketAddress2 != null) {
                this.socket.bind(socketAddress2);
            }
            boolean doConnect0 = doConnect0(socketAddress);
            if (doConnect0) {
                if (inetSocketAddress != null) {
                    socketAddress = UnixChannelUtil.computeRemoteAddr(inetSocketAddress, this.socket.remoteAddress());
                }
                this.remote = socketAddress;
            }
            this.local = this.socket.localAddress();
            return doConnect0;
        }
        throw new AlreadyConnectedException();
    }

    public boolean doConnect0(SocketAddress socketAddress) throws Exception {
        try {
            boolean connect = this.socket.connect(socketAddress);
            if (!connect) {
                setFlag(Native.EPOLLOUT);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    public void doDeregister() throws Exception {
        ((EpollEventLoop) eventLoop()).remove(this);
    }

    public void doDisconnect() throws Exception {
        doClose();
    }

    public final int doReadBytes(ByteBuf byteBuf) throws Exception {
        int i;
        int writerIndex = byteBuf.writerIndex();
        unsafe().recvBufAllocHandle().attemptedBytesRead(byteBuf.writableBytes());
        if (byteBuf.hasMemoryAddress()) {
            i = this.socket.recvAddress(byteBuf.memoryAddress(), writerIndex, byteBuf.capacity());
        } else {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, byteBuf.writableBytes());
            i = this.socket.recv(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
        }
        if (i > 0) {
            byteBuf.writerIndex(writerIndex + i);
        }
        return i;
    }

    public void doRegister() throws Exception {
        this.epollInReadyRunnablePending = false;
        ((EpollEventLoop) eventLoop()).add(this);
    }

    public final int doWriteBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        if (byteBuf.hasMemoryAddress()) {
            int sendAddress = this.socket.sendAddress(byteBuf.memoryAddress(), byteBuf.readerIndex(), byteBuf.writerIndex());
            if (sendAddress <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.removeBytes((long) sendAddress);
            return 1;
        }
        ByteBuffer internalNioBuffer = byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes()) : byteBuf.nioBuffer();
        int send = this.socket.send(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
        if (send <= 0) {
            return Integer.MAX_VALUE;
        }
        internalNioBuffer.position(internalNioBuffer.position() + send);
        channelOutboundBuffer.removeBytes((long) send);
        return 1;
    }

    public final long doWriteOrSendBytes(ByteBuf byteBuf, InetSocketAddress inetSocketAddress, boolean z) throws IOException {
        if (byteBuf.hasMemoryAddress()) {
            long memoryAddress = byteBuf.memoryAddress();
            return inetSocketAddress == null ? (long) this.socket.sendAddress(memoryAddress, byteBuf.readerIndex(), byteBuf.writerIndex()) : (long) this.socket.sendToAddress(memoryAddress, byteBuf.readerIndex(), byteBuf.writerIndex(), inetSocketAddress.getAddress(), inetSocketAddress.getPort(), z);
        } else if (byteBuf.nioBufferCount() > 1) {
            IovArray cleanIovArray = ((EpollEventLoop) eventLoop()).cleanIovArray();
            cleanIovArray.add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
            int count = cleanIovArray.count();
            return inetSocketAddress == null ? this.socket.writevAddresses(cleanIovArray.memoryAddress(0), count) : (long) this.socket.sendToAddresses(cleanIovArray.memoryAddress(0), count, inetSocketAddress.getAddress(), inetSocketAddress.getPort(), z);
        } else {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
            return inetSocketAddress == null ? (long) this.socket.send(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit()) : (long) this.socket.sendTo(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit(), inetSocketAddress.getAddress(), inetSocketAddress.getPort(), z);
        }
    }

    public final FileDescriptor fd() {
        return this.socket;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    public boolean isFlagSet(int i) {
        return (this.flags & i) != 0;
    }

    public boolean isOpen() {
        return this.socket.isOpen();
    }

    public SocketAddress localAddress0() {
        return this.local;
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        return newDirectBuffer(byteBuf, byteBuf);
    }

    public abstract AbstractEpollUnsafe newUnsafe();

    public SocketAddress remoteAddress0() {
        return this.remote;
    }

    public void resetCachedAddresses() {
        this.local = this.socket.localAddress();
        this.remote = this.socket.remoteAddress();
    }

    public void setFlag(int i) throws IOException {
        if (!isFlagSet(i)) {
            this.flags = i | this.flags;
            modifyEvents();
        }
    }

    public final boolean shouldBreakEpollInReady(ChannelConfig channelConfig) {
        return this.socket.isInputShutdown() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig));
    }

    public AbstractEpollChannel(Channel channel, LinuxSocket linuxSocket, boolean z) {
        super(channel);
        this.flags = Native.EPOLLET;
        this.socket = (LinuxSocket) ObjectUtil.checkNotNull(linuxSocket, "fd");
        this.active = z;
        if (z) {
            this.local = linuxSocket.localAddress();
            this.remote = linuxSocket.remoteAddress();
        }
    }

    public final ByteBuf newDirectBuffer(Object obj, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.release(obj);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer == null) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(obj);
        return threadLocalDirectBuffer;
    }

    public AbstractEpollChannel(Channel channel, LinuxSocket linuxSocket, SocketAddress socketAddress) {
        super(channel);
        this.flags = Native.EPOLLET;
        this.socket = (LinuxSocket) ObjectUtil.checkNotNull(linuxSocket, "fd");
        this.active = true;
        this.remote = socketAddress;
        this.local = linuxSocket.localAddress();
    }
}
