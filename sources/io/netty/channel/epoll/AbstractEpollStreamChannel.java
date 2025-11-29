package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoop;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.Queue;
import java.util.concurrent.Executor;

public abstract class AbstractEpollStreamChannel extends AbstractEpollChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EXPECTED_TYPES = (" (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')');
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractEpollStreamChannel.class);
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    /* access modifiers changed from: private */
    public FileDescriptor pipeIn;
    /* access modifiers changed from: private */
    public FileDescriptor pipeOut;
    /* access modifiers changed from: private */
    public volatile Queue<SpliceInTask> spliceQueue;

    public final class EpollSocketWritableByteChannel extends SocketWritableByteChannel {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public EpollSocketWritableByteChannel() {
            super(AbstractEpollStreamChannel.this.socket);
        }

        public ByteBufAllocator alloc() {
            return AbstractEpollStreamChannel.this.alloc();
        }

        public int write(ByteBuffer byteBuffer, int i, int i2) throws IOException {
            return AbstractEpollStreamChannel.this.socket.send(byteBuffer, i, i2);
        }
    }

    public class EpollStreamUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        public EpollStreamUnsafe() {
            super();
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead(byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            epollRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof OutOfMemoryError) || (th instanceof IOException)) {
                shutdownInput(false);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
            r8.release();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0085, code lost:
            if (r7.lastBytesRead() >= 0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
            if (r5 == false) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r10.readPending = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
            r6 = r5;
         */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0096 A[SYNTHETIC, Splitter:B:39:0x0096] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0069 A[EDGE_INSN: B:71:0x0069->B:22:0x0069 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x007e A[EDGE_INSN: B:72:0x007e->B:27:0x007e ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void epollInReady() {
            /*
                r10 = this;
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.epoll.EpollChannelConfig r0 = r0.config()
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                boolean r1 = r1.shouldBreakEpollInReady(r0)
                if (r1 == 0) goto L_0x0012
                r10.clearEpollIn0()
                return
            L_0x0012:
                io.netty.channel.epoll.EpollRecvByteAllocatorHandle r7 = r10.recvBufAllocHandle()
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                int r2 = io.netty.channel.epoll.Native.EPOLLET
                boolean r1 = r1.isFlagSet(r2)
                r7.edgeTriggered(r1)
                io.netty.channel.epoll.AbstractEpollStreamChannel r1 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                r7.reset(r0)
                r10.epollInBefore()
                r2 = 0
                r4 = r2
            L_0x0033:
                r5 = 1
                r6 = 0
                if (r4 != 0) goto L_0x0046
                io.netty.channel.epoll.AbstractEpollStreamChannel r8 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch:{ all -> 0x0040 }
                java.util.Queue r4 = r8.spliceQueue     // Catch:{ all -> 0x0040 }
                if (r4 == 0) goto L_0x006b
                goto L_0x0046
            L_0x0040:
                r1 = move-exception
            L_0x0041:
                r5 = r1
                r1 = r4
                r4 = r2
                goto L_0x00cb
            L_0x0046:
                java.lang.Object r8 = r4.peek()     // Catch:{ all -> 0x0040 }
                io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceInTask r8 = (io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask) r8     // Catch:{ all -> 0x0040 }
                if (r8 == 0) goto L_0x006b
                boolean r8 = r8.spliceIn(r7)     // Catch:{ all -> 0x0040 }
                boolean r9 = r7.isReceivedRdHup()     // Catch:{ all -> 0x0040 }
                if (r9 == 0) goto L_0x005b
                r10.shutdownInput(r5)     // Catch:{ all -> 0x0040 }
            L_0x005b:
                if (r8 == 0) goto L_0x0069
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch:{ all -> 0x0040 }
                boolean r5 = r5.isActive()     // Catch:{ all -> 0x0040 }
                if (r5 == 0) goto L_0x00a7
                r4.remove()     // Catch:{ all -> 0x0040 }
                goto L_0x00a7
            L_0x0069:
                r5 = r6
                goto L_0x00ae
            L_0x006b:
                io.netty.buffer.ByteBuf r8 = r7.allocate(r1)     // Catch:{ all -> 0x0040 }
                io.netty.channel.epoll.AbstractEpollStreamChannel r9 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch:{ all -> 0x0091 }
                int r9 = r9.doReadBytes(r8)     // Catch:{ all -> 0x0091 }
                r7.lastBytesRead(r9)     // Catch:{ all -> 0x0091 }
                int r9 = r7.lastBytesRead()     // Catch:{ all -> 0x0091 }
                if (r9 > 0) goto L_0x0096
                r8.release()     // Catch:{ all -> 0x0091 }
                int r1 = r7.lastBytesRead()     // Catch:{ all -> 0x0040 }
                if (r1 >= 0) goto L_0x0088
                goto L_0x0089
            L_0x0088:
                r5 = r6
            L_0x0089:
                if (r5 == 0) goto L_0x00ae
                r10.readPending = r6     // Catch:{ all -> 0x008e }
                goto L_0x00ae
            L_0x008e:
                r1 = move-exception
                r6 = r5
                goto L_0x0041
            L_0x0091:
                r1 = move-exception
                r5 = r1
                r1 = r4
                r4 = r8
                goto L_0x00cb
            L_0x0096:
                r7.incMessagesRead(r5)     // Catch:{ all -> 0x0091 }
                r10.readPending = r6     // Catch:{ all -> 0x0091 }
                r3.fireChannelRead(r8)     // Catch:{ all -> 0x0091 }
                io.netty.channel.epoll.AbstractEpollStreamChannel r5 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch:{ all -> 0x0040 }
                boolean r5 = r5.shouldBreakEpollInReady(r0)     // Catch:{ all -> 0x0040 }
                if (r5 == 0) goto L_0x00a7
                goto L_0x0069
            L_0x00a7:
                boolean r5 = r7.continueReading()     // Catch:{ all -> 0x0040 }
                if (r5 != 0) goto L_0x0033
                goto L_0x0069
            L_0x00ae:
                r7.readComplete()     // Catch:{ all -> 0x008e }
                r3.fireChannelReadComplete()     // Catch:{ all -> 0x008e }
                if (r5 == 0) goto L_0x00b9
                r10.shutdownInput(r6)     // Catch:{ all -> 0x008e }
            L_0x00b9:
                if (r4 != 0) goto L_0x00bf
            L_0x00bb:
                r10.epollInFinally(r0)
                goto L_0x00d9
            L_0x00bf:
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L_0x00d9
            L_0x00c5:
                io.netty.channel.epoll.AbstractEpollStreamChannel r10 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                r10.clearEpollIn()
                goto L_0x00d9
            L_0x00cb:
                r2 = r10
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00da }
                if (r1 != 0) goto L_0x00d2
                goto L_0x00bb
            L_0x00d2:
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L_0x00d9
                goto L_0x00c5
            L_0x00d9:
                return
            L_0x00da:
                r2 = move-exception
                if (r1 == 0) goto L_0x00e9
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L_0x00ec
                io.netty.channel.epoll.AbstractEpollStreamChannel r10 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                r10.clearEpollIn()
                goto L_0x00ec
            L_0x00e9:
                r10.epollInFinally(r0)
            L_0x00ec:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.epollInReady():void");
        }

        public EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
            return new EpollRecvByteAllocatorStreamingHandle(extendedHandle);
        }

        public Executor prepareToClose() {
            return super.prepareToClose();
        }
    }

    public final class SpliceFdTask extends SpliceInTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final FileDescriptor fd;
        private int offset;
        private final ChannelPromise promise;

        public SpliceFdTask(FileDescriptor fileDescriptor, int i, int i2, ChannelPromise channelPromise) {
            super(i2, channelPromise);
            this.fd = fileDescriptor;
            this.promise = channelPromise;
            this.offset = i;
        }

        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            FileDescriptor fileDescriptor;
            FileDescriptor fileDescriptor2;
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor[] pipe = FileDescriptor.pipe();
                fileDescriptor = pipe[0];
                fileDescriptor2 = pipe[1];
                int spliceIn = spliceIn(fileDescriptor2, handle);
                if (spliceIn > 0) {
                    int i = this.len;
                    if (i != Integer.MAX_VALUE) {
                        this.len = i - spliceIn;
                    }
                    do {
                        int splice = Native.splice(fileDescriptor.intValue(), -1, this.fd.intValue(), (long) this.offset, (long) spliceIn);
                        this.offset += splice;
                        spliceIn -= splice;
                    } while (spliceIn > 0);
                    if (this.len == 0) {
                        this.promise.setSuccess();
                        AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                        AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                        return true;
                    }
                }
                AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                return false;
            } catch (Throwable th) {
                this.promise.setFailure(th);
                return true;
            }
        }
    }

    public final class SpliceInChannelTask extends SpliceInTask implements ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AbstractEpollStreamChannel ch;

        public SpliceInChannelTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, ChannelPromise channelPromise) {
            super(i, channelPromise);
            this.ch = abstractEpollStreamChannel;
        }

        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor access$500 = this.ch.pipeOut;
                if (access$500 == null) {
                    FileDescriptor[] pipe = FileDescriptor.pipe();
                    FileDescriptor unused = this.ch.pipeIn = pipe[0];
                    access$500 = this.ch.pipeOut = pipe[1];
                }
                int spliceIn = spliceIn(access$500, handle);
                if (spliceIn > 0) {
                    int i = this.len;
                    if (i != Integer.MAX_VALUE) {
                        this.len = i - spliceIn;
                    }
                    ChannelPromise addListener = this.len == 0 ? this.promise : this.ch.newPromise().addListener(this);
                    boolean isAutoRead = AbstractEpollStreamChannel.this.config().isAutoRead();
                    this.ch.unsafe().write(new SpliceOutTask(this.ch, spliceIn, isAutoRead), addListener);
                    this.ch.unsafe().flush();
                    if (isAutoRead && !addListener.isDone()) {
                        AbstractEpollStreamChannel.this.config().setAutoRead(false);
                    }
                }
                return this.len == 0;
            } catch (Throwable th) {
                this.promise.setFailure(th);
                return true;
            }
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (!channelFuture.isSuccess()) {
                this.promise.setFailure(channelFuture.cause());
            }
        }
    }

    public abstract class SpliceInTask {
        int len;
        final ChannelPromise promise;

        public SpliceInTask(int i, ChannelPromise channelPromise) {
            this.promise = channelPromise;
            this.len = i;
        }

        public final int spliceIn(FileDescriptor fileDescriptor, RecvByteBufAllocator.Handle handle) throws IOException {
            int min = Math.min(handle.guess(), this.len);
            int i = 0;
            while (true) {
                int splice = Native.splice(AbstractEpollStreamChannel.this.socket.intValue(), -1, fileDescriptor.intValue(), -1, (long) min);
                handle.lastBytesRead(splice);
                if (splice == 0) {
                    return i;
                }
                i += splice;
                min -= splice;
            }
        }

        public abstract boolean spliceIn(RecvByteBufAllocator.Handle handle);
    }

    public final class SpliceOutTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean autoRead;
        private final AbstractEpollStreamChannel ch;
        private int len;

        public SpliceOutTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, boolean z) {
            this.ch = abstractEpollStreamChannel;
            this.len = i;
            this.autoRead = z;
        }

        public boolean spliceOut() throws Exception {
            try {
                int splice = this.len - Native.splice(this.ch.pipeIn.intValue(), -1, this.ch.socket.intValue(), -1, (long) this.len);
                this.len = splice;
                if (splice != 0) {
                    return false;
                }
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                return true;
            } catch (IOException e) {
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                throw e;
            }
        }
    }

    public AbstractEpollStreamChannel(Channel channel, int i) {
        this(channel, new LinuxSocket(i));
    }

    private void addToSpliceQueue(SpliceInTask spliceInTask) {
        Queue<SpliceInTask> queue = this.spliceQueue;
        if (queue == null) {
            synchronized (this) {
                try {
                    queue = this.spliceQueue;
                    if (queue == null) {
                        queue = PlatformDependent.newMpscQueue();
                        this.spliceQueue = queue;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        queue.add(spliceInTask);
    }

    private void adjustMaxBytesPerGatheringWrite(long j, long j2, long j3) {
        if (j == j2) {
            long j4 = j << 1;
            if (j4 > j3) {
                config().setMaxBytesPerGatheringWrite(j4);
            }
        } else if (j > 4096) {
            long j5 = j >>> 1;
            if (j2 < j5) {
                config().setMaxBytesPerGatheringWrite(j5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void clearSpliceQueue() {
        Queue<SpliceInTask> queue = this.spliceQueue;
        if (queue != null) {
            ClosedChannelException closedChannelException = null;
            while (true) {
                SpliceInTask poll = queue.poll();
                if (poll != null) {
                    if (closedChannelException == null) {
                        closedChannelException = new ClosedChannelException();
                    }
                    poll.promise.tryFailure(closedChannelException);
                } else {
                    return;
                }
            }
        }
    }

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray cleanIovArray = ((EpollEventLoop) eventLoop()).cleanIovArray();
        cleanIovArray.maxBytes(maxBytesPerGatheringWrite);
        channelOutboundBuffer.forEachFlushedMessage(cleanIovArray);
        if (cleanIovArray.count() >= 1) {
            return writeBytesMultiple(channelOutboundBuffer, cleanIovArray);
        }
        channelOutboundBuffer.removeBytes(0);
        return 0;
    }

    private void failSpliceIfClosed(ChannelPromise channelPromise) {
        if (!isOpen() && channelPromise.tryFailure(new ClosedChannelException())) {
            eventLoop().execute(new Runnable() {
                public void run() {
                    AbstractEpollStreamChannel.this.clearSpliceQueue();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void safeClosePipe(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            try {
                fileDescriptor.close();
            } catch (IOException e) {
                logger.warn("Error while closing a pipe", (Throwable) e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture channelFuture, ChannelFuture channelFuture2, ChannelPromise channelPromise) {
        Throwable cause = channelFuture.cause();
        Throwable cause2 = channelFuture2.cause();
        if (cause != null) {
            if (cause2 != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", cause2);
            }
            channelPromise.setFailure(cause);
        } else if (cause2 != null) {
            channelPromise.setFailure(cause2);
        } else {
            channelPromise.setSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            this.socket.shutdown(true, false);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    /* access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        ChannelFuture shutdownInput = shutdownInput();
        if (shutdownInput.isDone()) {
            shutdownDone(channelFuture, shutdownInput, channelPromise);
        } else {
            shutdownInput.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    AbstractEpollStreamChannel.shutdownDone(channelFuture, channelFuture, channelPromise);
                }
            });
        }
    }

    private int writeBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            channelOutboundBuffer.remove();
            return 0;
        } else if (byteBuf.hasMemoryAddress() || byteBuf.nioBufferCount() == 1) {
            return doWriteBytes(channelOutboundBuffer, byteBuf);
        } else {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers();
            return writeBytesMultiple(channelOutboundBuffer, nioBuffers, nioBuffers.length, (long) readableBytes, config().getMaxBytesPerGatheringWrite());
        }
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, IovArray iovArray) throws IOException {
        long size = iovArray.size();
        long writevAddresses = this.socket.writevAddresses(iovArray.memoryAddress(0), iovArray.count());
        if (writevAddresses <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(size, writevAddresses, iovArray.maxBytes());
        channelOutboundBuffer.removeBytes(writevAddresses);
        return 1;
    }

    private int writeDefaultFileRegion(ChannelOutboundBuffer channelOutboundBuffer, DefaultFileRegion defaultFileRegion) throws Exception {
        long transferred = defaultFileRegion.transferred();
        long count = defaultFileRegion.count();
        if (transferred >= count) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long sendFile = this.socket.sendFile(defaultFileRegion, defaultFileRegion.position(), transferred, count - transferred);
        int i = (sendFile > 0 ? 1 : (sendFile == 0 ? 0 : -1));
        if (i > 0) {
            channelOutboundBuffer.progress(sendFile);
            if (defaultFileRegion.transferred() < count) {
                return 1;
            }
            channelOutboundBuffer.remove();
            return 1;
        } else if (i != 0) {
            return Integer.MAX_VALUE;
        } else {
            validateFileRegion(defaultFileRegion, transferred);
            return Integer.MAX_VALUE;
        }
    }

    private int writeFileRegion(ChannelOutboundBuffer channelOutboundBuffer, FileRegion fileRegion) throws Exception {
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (this.byteChannel == null) {
            this.byteChannel = new EpollSocketWritableByteChannel();
        }
        long transferTo = fileRegion.transferTo(this.byteChannel, fileRegion.transferred());
        if (transferTo <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(transferTo);
        if (fileRegion.transferred() < fileRegion.count()) {
            return 1;
        }
        channelOutboundBuffer.remove();
        return 1;
    }

    public void doClose() throws Exception {
        try {
            super.doClose();
        } finally {
            safeClosePipe(this.pipeIn);
            safeClosePipe(this.pipeOut);
            clearSpliceQueue();
        }
    }

    public final void doShutdownOutput() throws Exception {
        this.socket.shutdown(false, true);
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int doWriteSingle;
        int writeSpinCount = config().getWriteSpinCount();
        do {
            int size = channelOutboundBuffer.size();
            if (size > 1 && (channelOutboundBuffer.current() instanceof ByteBuf)) {
                doWriteSingle = doWriteMultiple(channelOutboundBuffer);
            } else if (size == 0) {
                clearFlag(Native.EPOLLOUT);
                return;
            } else {
                doWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= doWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            clearFlag(Native.EPOLLOUT);
            eventLoop().execute(this.flushTask);
            return;
        }
        setFlag(Native.EPOLLOUT);
    }

    public int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object current = channelOutboundBuffer.current();
        if (current instanceof ByteBuf) {
            return writeBytes(channelOutboundBuffer, (ByteBuf) current);
        }
        if (current instanceof DefaultFileRegion) {
            return writeDefaultFileRegion(channelOutboundBuffer, (DefaultFileRegion) current);
        }
        if (current instanceof FileRegion) {
            return writeFileRegion(channelOutboundBuffer, (FileRegion) current);
        }
        if (!(current instanceof SpliceOutTask)) {
            throw new Error();
        } else if (!((SpliceOutTask) current).spliceOut()) {
            return Integer.MAX_VALUE;
        } else {
            channelOutboundBuffer.remove();
            return 1;
        }
    }

    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        } else if ((obj instanceof FileRegion) || (obj instanceof SpliceOutTask)) {
            return obj;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown();
    }

    public boolean isShutdown() {
        return this.socket.isShutdown();
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i) {
        return spliceTo(abstractEpollStreamChannel, i, newPromise());
    }

    public AbstractEpollStreamChannel(int i) {
        this(new LinuxSocket(i));
    }

    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollStreamUnsafe();
    }

    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
        } else {
            shutdownOutput.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    AbstractEpollStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() {
                public void run() {
                    AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
        } else {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdownInput0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() {
                    public void run() {
                        AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(channelPromise);
        } else {
            eventLoop.execute(new Runnable() {
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) AbstractEpollStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i, ChannelPromise channelPromise) {
        if (abstractEpollStreamChannel.eventLoop() == eventLoop()) {
            ObjectUtil.checkPositiveOrZero(i, "len");
            EpollMode epollMode = abstractEpollStreamChannel.config().getEpollMode();
            EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
            if (epollMode == epollMode2 && config().getEpollMode() == epollMode2) {
                ObjectUtil.checkNotNull(channelPromise, "promise");
                if (!isOpen()) {
                    channelPromise.tryFailure(new ClosedChannelException());
                } else {
                    addToSpliceQueue(new SpliceInChannelTask(abstractEpollStreamChannel, i, channelPromise));
                    failSpliceIfClosed(channelPromise);
                }
                return channelPromise;
            }
            throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
        }
        throw new IllegalArgumentException("EventLoops are not the same.");
    }

    public AbstractEpollStreamChannel(LinuxSocket linuxSocket) {
        this(linuxSocket, AbstractEpollChannel.isSoErrorZero(linuxSocket));
    }

    public AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket) {
        super(channel, linuxSocket, true);
        this.flushTask = new Runnable() {
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, ByteBuffer[] byteBufferArr, int i, long j, long j2) throws IOException {
        if (j > j2) {
            j = j2;
        }
        long writev = this.socket.writev(byteBufferArr, 0, i, j);
        if (writev <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(j, writev, j2);
        channelOutboundBuffer.removeBytes(writev);
        return 1;
    }

    public AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket, SocketAddress socketAddress) {
        super(channel, linuxSocket, socketAddress);
        this.flushTask = new Runnable() {
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    public AbstractEpollStreamChannel(LinuxSocket linuxSocket, boolean z) {
        super((Channel) null, linuxSocket, z);
        this.flushTask = new Runnable() {
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i, int i2) {
        return spliceTo(fileDescriptor, i, i2, newPromise());
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i, int i2, ChannelPromise channelPromise) {
        ObjectUtil.checkPositiveOrZero(i2, "len");
        ObjectUtil.checkPositiveOrZero(i, "offset");
        EpollMode epollMode = config().getEpollMode();
        EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
        if (epollMode == epollMode2) {
            ObjectUtil.checkNotNull(channelPromise, "promise");
            if (!isOpen()) {
                channelPromise.tryFailure(new ClosedChannelException());
            } else {
                addToSpliceQueue(new SpliceFdTask(fileDescriptor, i, i2, channelPromise));
                failSpliceIfClosed(channelPromise);
            }
            return channelPromise;
        }
        throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
    }
}
