package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private static final String EXPECTED_TYPES = (" (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')');
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private final Runnable flushTask = new Runnable() {
        public void run() {
            ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
        }
    };
    /* access modifiers changed from: private */
    public boolean inputClosedSeenErrorOnRead;

    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        public NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (AbstractNioByteChannel.this.isInputShutdown0()) {
                boolean unused = AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
            } else if (AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                AbstractNioByteChannel.this.shutdownInput();
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
            } else {
                close(voidPromise());
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead(byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof OutOfMemoryError) || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
            r5.release();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
            if (r7.lastBytesRead() >= 0) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
            if (r8 == false) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r9.this$0.readPending = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
            r5 = r1;
            r6 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
            r2 = r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void read() {
            /*
                r9 = this;
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelConfig r0 = r0.config()
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.shouldBreakReadReady(r0)
                if (r1 == 0) goto L_0x0014
                io.netty.channel.nio.AbstractNioByteChannel r9 = io.netty.channel.nio.AbstractNioByteChannel.this
                r9.clearReadPending()
                return
            L_0x0014:
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                io.netty.channel.RecvByteBufAllocator$Handle r7 = r9.recvBufAllocHandle()
                r7.reset(r0)
            L_0x0025:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r7.allocate(r1)     // Catch:{ all -> 0x0053 }
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch:{ all -> 0x0057 }
                int r6 = r6.doReadBytes(r5)     // Catch:{ all -> 0x0057 }
                r7.lastBytesRead(r6)     // Catch:{ all -> 0x0057 }
                int r6 = r7.lastBytesRead()     // Catch:{ all -> 0x0057 }
                r8 = 1
                if (r6 > 0) goto L_0x005c
                r5.release()     // Catch:{ all -> 0x0057 }
                int r1 = r7.lastBytesRead()     // Catch:{ all -> 0x0053 }
                if (r1 >= 0) goto L_0x0045
                goto L_0x0046
            L_0x0045:
                r8 = r2
            L_0x0046:
                if (r8 == 0) goto L_0x0051
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch:{ all -> 0x004d }
                r1.readPending = r2     // Catch:{ all -> 0x004d }
                goto L_0x0051
            L_0x004d:
                r1 = move-exception
                r5 = r1
                r6 = r8
                goto L_0x0087
            L_0x0051:
                r2 = r8
                goto L_0x006c
            L_0x0053:
                r1 = move-exception
                r5 = r1
                r6 = r2
                goto L_0x0087
            L_0x0057:
                r1 = move-exception
                r6 = r2
                r4 = r5
                r5 = r1
                goto L_0x0087
            L_0x005c:
                r7.incMessagesRead(r8)     // Catch:{ all -> 0x0057 }
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch:{ all -> 0x0057 }
                r6.readPending = r2     // Catch:{ all -> 0x0057 }
                r3.fireChannelRead(r5)     // Catch:{ all -> 0x0057 }
                boolean r5 = r7.continueReading()     // Catch:{ all -> 0x0053 }
                if (r5 != 0) goto L_0x0025
            L_0x006c:
                r7.readComplete()     // Catch:{ all -> 0x0053 }
                r3.fireChannelReadComplete()     // Catch:{ all -> 0x0053 }
                if (r2 == 0) goto L_0x0077
                r9.closeOnRead(r3)     // Catch:{ all -> 0x0053 }
            L_0x0077:
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L_0x0098
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L_0x0098
            L_0x0083:
                r9.removeReadOp()
                goto L_0x0098
            L_0x0087:
                r2 = r9
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0099 }
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L_0x0098
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L_0x0098
                goto L_0x0083
            L_0x0098:
                return
            L_0x0099:
                r1 = move-exception
                io.netty.channel.nio.AbstractNioByteChannel r2 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r2 = r2.readPending
                if (r2 != 0) goto L_0x00a9
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L_0x00a9
                r9.removeReadOp()
            L_0x00a9:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe.read():void");
        }
    }

    public AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
    }

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int doWriteBytes = doWriteBytes(byteBuf);
            if (doWriteBytes <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress((long) doWriteBytes);
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        } else if (obj instanceof FileRegion) {
            FileRegion fileRegion = (FileRegion) obj;
            if (fileRegion.transferred() >= fileRegion.count()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            long doWriteFileRegion = doWriteFileRegion(fileRegion);
            if (doWriteFileRegion <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress(doWriteFileRegion);
            if (fileRegion.transferred() >= fileRegion.count()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        } else {
            throw new Error();
        }
    }

    /* access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    public final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) != 0) {
                selectionKey.interestOps(interestOps & -5);
            }
        }
    }

    public abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(channelOutboundBuffer, current);
        } while (writeSpinCount > 0);
        incompleteWrite(writeSpinCount < 0);
    }

    public final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    public abstract int doWriteBytes(ByteBuf byteBuf) throws Exception;

    public abstract long doWriteFileRegion(FileRegion fileRegion) throws Exception;

    public final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        } else if (obj instanceof FileRegion) {
            return obj;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    public final void incompleteWrite(boolean z) {
        if (z) {
            setOpWrite();
            return;
        }
        clearOpWrite();
        eventLoop().execute(this.flushTask);
    }

    public boolean isInputShutdown0() {
        return false;
    }

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) == 0) {
                selectionKey.interestOps(interestOps | 4);
            }
        }
    }

    public final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        return isInputShutdown0() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig));
    }

    public abstract ChannelFuture shutdownInput();

    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }
}
