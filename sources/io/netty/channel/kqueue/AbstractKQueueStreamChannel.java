package io.netty.channel.kqueue;

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
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.Executor;

public abstract class AbstractKQueueStreamChannel extends AbstractKQueueChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EXPECTED_TYPES = (" (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')');
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractKQueueStreamChannel.class);
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;

    public final class KQueueSocketWritableByteChannel extends SocketWritableByteChannel {
        public KQueueSocketWritableByteChannel() {
            super(AbstractKQueueStreamChannel.this.socket);
        }

        public ByteBufAllocator alloc() {
            return AbstractKQueueStreamChannel.this.alloc();
        }
    }

    public class KQueueStreamUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        public KQueueStreamUnsafe() {
            super();
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead(byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            if (!failConnectPromise(th)) {
                kQueueRecvByteAllocatorHandle.readComplete();
                channelPipeline.fireChannelReadComplete();
                channelPipeline.fireExceptionCaught(th);
                if (z || (th instanceof OutOfMemoryError) || (th instanceof IOException)) {
                    shutdownInput(false);
                }
            }
        }

        public Executor prepareToClose() {
            return super.prepareToClose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
            r5.release();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            if (r9.lastBytesRead() >= 0) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
            if (r7 == false) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r8.readPending = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
            r5 = r1;
            r6 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
            r7 = false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r9) {
            /*
                r8 = this;
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r0 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                io.netty.channel.kqueue.KQueueChannelConfig r0 = r0.config()
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r1 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                boolean r1 = r1.shouldBreakReadReady(r0)
                if (r1 == 0) goto L_0x0012
                r8.clearReadFilter0()
                return
            L_0x0012:
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r1 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                r9.reset(r0)
                r8.readReadyBefore()
            L_0x0022:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r9.allocate(r1)     // Catch:{ all -> 0x004c }
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r6 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this     // Catch:{ all -> 0x0050 }
                int r6 = r6.doReadBytes(r5)     // Catch:{ all -> 0x0050 }
                r9.lastBytesRead(r6)     // Catch:{ all -> 0x0050 }
                int r6 = r9.lastBytesRead()     // Catch:{ all -> 0x0050 }
                r7 = 1
                if (r6 > 0) goto L_0x0055
                r5.release()     // Catch:{ all -> 0x0050 }
                int r1 = r9.lastBytesRead()     // Catch:{ all -> 0x004c }
                if (r1 >= 0) goto L_0x0042
                goto L_0x0043
            L_0x0042:
                r7 = r2
            L_0x0043:
                if (r7 == 0) goto L_0x006d
                r8.readPending = r2     // Catch:{ all -> 0x0048 }
                goto L_0x006d
            L_0x0048:
                r1 = move-exception
                r5 = r1
                r6 = r7
                goto L_0x007c
            L_0x004c:
                r1 = move-exception
                r5 = r1
                r6 = r2
                goto L_0x007c
            L_0x0050:
                r1 = move-exception
                r6 = r2
                r4 = r5
                r5 = r1
                goto L_0x007c
            L_0x0055:
                r9.incMessagesRead(r7)     // Catch:{ all -> 0x0050 }
                r8.readPending = r2     // Catch:{ all -> 0x0050 }
                r3.fireChannelRead(r5)     // Catch:{ all -> 0x0050 }
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r5 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this     // Catch:{ all -> 0x004c }
                boolean r5 = r5.shouldBreakReadReady(r0)     // Catch:{ all -> 0x004c }
                if (r5 == 0) goto L_0x0066
                goto L_0x006c
            L_0x0066:
                boolean r5 = r9.continueReading()     // Catch:{ all -> 0x004c }
                if (r5 != 0) goto L_0x0022
            L_0x006c:
                r7 = r2
            L_0x006d:
                r9.readComplete()     // Catch:{ all -> 0x0048 }
                r3.fireChannelReadComplete()     // Catch:{ all -> 0x0048 }
                if (r7 == 0) goto L_0x0078
                r8.shutdownInput(r2)     // Catch:{ all -> 0x0048 }
            L_0x0078:
                r8.readReadyFinally(r0)
                goto L_0x0082
            L_0x007c:
                r2 = r8
                r7 = r9
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0083 }
                goto L_0x0078
            L_0x0082:
                return
            L_0x0083:
                r9 = move-exception
                r8.readReadyFinally(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }
    }

    public AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, boolean z) {
        super(channel, bsdSocket, z);
        this.flushTask = new Runnable() {
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
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

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray cleanArray = ((KQueueEventLoop) eventLoop()).cleanArray();
        cleanArray.maxBytes(maxBytesPerGatheringWrite);
        channelOutboundBuffer.forEachFlushedMessage(cleanArray);
        if (cleanArray.count() >= 1) {
            return writeBytesMultiple(channelOutboundBuffer, cleanArray);
        }
        channelOutboundBuffer.removeBytes(0);
        return 0;
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
                    AbstractKQueueStreamChannel.shutdownDone(channelFuture, channelFuture, channelPromise);
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
        long count = defaultFileRegion.count();
        long transferred = defaultFileRegion.transferred();
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
            this.byteChannel = new KQueueSocketWritableByteChannel();
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
                writeFilter(false);
                return;
            } else {
                doWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= doWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            writeFilter(false);
            eventLoop().execute(this.flushTask);
            return;
        }
        writeFilter(true);
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
        throw new Error();
    }

    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        } else if (obj instanceof FileRegion) {
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

    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueStreamUnsafe();
    }

    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
        } else {
            shutdownOutput.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    AbstractKQueueStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
        } else {
            eventLoop.execute(new Runnable() {
                public void run() {
                    AbstractKQueueStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
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
                    ((AbstractChannel.AbstractUnsafe) AbstractKQueueStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, SocketAddress socketAddress) {
        super(channel, bsdSocket, socketAddress);
        this.flushTask = new Runnable() {
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
    }

    public AbstractKQueueStreamChannel(BsdSocket bsdSocket) {
        this((Channel) null, bsdSocket, AbstractKQueueChannel.isSoErrorZero(bsdSocket));
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
}
