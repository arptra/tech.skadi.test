package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.util.internal.StringUtil;
import java.io.IOException;

public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private static final String EXPECTED_TYPES = (" (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')');
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);

    public AbstractOioByteChannel(Channel channel) {
        super(channel);
    }

    private void closeOnRead(ChannelPipeline channelPipeline) {
        if (isOpen()) {
            if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                shutdownInput();
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
            } else {
                unsafe().close(unsafe().voidPromise());
            }
            channelPipeline.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
        }
    }

    private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
        if (byteBuf != null) {
            if (byteBuf.isReadable()) {
                this.readPending = false;
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

    public abstract int available();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r5.isReadable() != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r5.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r7.lastBytesRead() >= 0) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r9 == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r12.readPending = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doRead() {
        /*
            r12 = this;
            io.netty.channel.ChannelConfig r0 = r12.config()
            boolean r1 = r12.isInputShutdown()
            if (r1 != 0) goto L_0x0112
            boolean r1 = r12.readPending
            if (r1 != 0) goto L_0x0010
            goto L_0x0112
        L_0x0010:
            r1 = 0
            r12.readPending = r1
            io.netty.channel.ChannelPipeline r3 = r12.pipeline()
            io.netty.buffer.ByteBufAllocator r2 = r0.getAllocator()
            io.netty.channel.Channel$Unsafe r4 = r12.unsafe()
            io.netty.channel.RecvByteBufAllocator$Handle r7 = r4.recvBufAllocHandle()
            r7.reset(r0)
            r4 = 0
            io.netty.buffer.ByteBuf r5 = r7.allocate(r2)     // Catch:{ all -> 0x00e0 }
            r6 = r1
        L_0x002c:
            int r8 = r12.doReadBytes(r5)     // Catch:{ all -> 0x005f }
            r7.lastBytesRead(r8)     // Catch:{ all -> 0x005f }
            int r8 = r7.lastBytesRead()     // Catch:{ all -> 0x005f }
            r9 = 1
            if (r8 > 0) goto L_0x0064
            boolean r2 = r5.isReadable()     // Catch:{ all -> 0x005f }
            if (r2 != 0) goto L_0x0062
            r5.release()     // Catch:{ all -> 0x005f }
            int r2 = r7.lastBytesRead()     // Catch:{ all -> 0x0058 }
            if (r2 >= 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r9 = r1
        L_0x004b:
            if (r9 == 0) goto L_0x0056
            r12.readPending = r1     // Catch:{ all -> 0x0050 }
            goto L_0x0056
        L_0x0050:
            r1 = move-exception
        L_0x0051:
            r5 = r1
            r1 = r6
            r6 = r9
            goto L_0x00e3
        L_0x0056:
            r5 = r4
            goto L_0x00a4
        L_0x0058:
            r2 = move-exception
        L_0x0059:
            r5 = r2
            r11 = r6
            r6 = r1
            r1 = r11
            goto L_0x00e3
        L_0x005f:
            r2 = move-exception
            r4 = r5
            goto L_0x0059
        L_0x0062:
            r9 = r1
            goto L_0x00a4
        L_0x0064:
            int r6 = r12.available()     // Catch:{ all -> 0x0089 }
            if (r6 > 0) goto L_0x006c
        L_0x006a:
            r6 = r9
            goto L_0x0062
        L_0x006c:
            boolean r8 = r5.isWritable()     // Catch:{ all -> 0x0089 }
            if (r8 != 0) goto L_0x009d
            int r8 = r5.capacity()     // Catch:{ all -> 0x0089 }
            int r10 = r5.maxCapacity()     // Catch:{ all -> 0x0089 }
            if (r8 != r10) goto L_0x008f
            r7.incMessagesRead(r9)     // Catch:{ all -> 0x0089 }
            r12.readPending = r1     // Catch:{ all -> 0x0089 }
            r3.fireChannelRead(r5)     // Catch:{ all -> 0x0089 }
            io.netty.buffer.ByteBuf r5 = r7.allocate(r2)     // Catch:{ all -> 0x0089 }
            goto L_0x009d
        L_0x0089:
            r2 = move-exception
            r6 = r1
            r4 = r5
            r1 = r9
        L_0x008d:
            r5 = r2
            goto L_0x00e3
        L_0x008f:
            int r8 = r5.writerIndex()     // Catch:{ all -> 0x0089 }
            int r8 = r8 + r6
            if (r8 <= r10) goto L_0x009a
            r5.capacity(r10)     // Catch:{ all -> 0x0089 }
            goto L_0x009d
        L_0x009a:
            r5.ensureWritable(r6)     // Catch:{ all -> 0x0089 }
        L_0x009d:
            boolean r6 = r7.continueReading()     // Catch:{ all -> 0x0089 }
            if (r6 != 0) goto L_0x00dd
            goto L_0x006a
        L_0x00a4:
            if (r5 == 0) goto L_0x00b9
            boolean r2 = r5.isReadable()     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x00b5
            r12.readPending = r1     // Catch:{ all -> 0x00b2 }
            r3.fireChannelRead(r5)     // Catch:{ all -> 0x00b2 }
            goto L_0x00ba
        L_0x00b2:
            r1 = move-exception
            r4 = r5
            goto L_0x0051
        L_0x00b5:
            r5.release()     // Catch:{ all -> 0x00b2 }
            goto L_0x00ba
        L_0x00b9:
            r4 = r5
        L_0x00ba:
            if (r6 == 0) goto L_0x00c2
            r7.readComplete()     // Catch:{ all -> 0x0050 }
            r3.fireChannelReadComplete()     // Catch:{ all -> 0x0050 }
        L_0x00c2:
            if (r9 == 0) goto L_0x00c7
            r12.closeOnRead(r3)     // Catch:{ all -> 0x0050 }
        L_0x00c7:
            boolean r1 = r12.readPending
            if (r1 != 0) goto L_0x00d9
            boolean r0 = r0.isAutoRead()
            if (r0 != 0) goto L_0x00d9
            if (r6 != 0) goto L_0x00fa
            boolean r0 = r12.isActive()
            if (r0 == 0) goto L_0x00fa
        L_0x00d9:
            r12.read()
            goto L_0x00fa
        L_0x00dd:
            r6 = r9
            goto L_0x002c
        L_0x00e0:
            r2 = move-exception
            r6 = r1
            goto L_0x008d
        L_0x00e3:
            r2 = r12
            r2.handleReadException(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00fb }
            boolean r2 = r12.readPending
            if (r2 != 0) goto L_0x00d9
            boolean r0 = r0.isAutoRead()
            if (r0 != 0) goto L_0x00d9
            if (r1 != 0) goto L_0x00fa
            boolean r0 = r12.isActive()
            if (r0 == 0) goto L_0x00fa
            goto L_0x00d9
        L_0x00fa:
            return
        L_0x00fb:
            r2 = move-exception
            boolean r3 = r12.readPending
            if (r3 != 0) goto L_0x010e
            boolean r0 = r0.isAutoRead()
            if (r0 != 0) goto L_0x010e
            if (r1 != 0) goto L_0x0111
            boolean r0 = r12.isActive()
            if (r0 == 0) goto L_0x0111
        L_0x010e:
            r12.read()
        L_0x0111:
            throw r2
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.oio.AbstractOioByteChannel.doRead():void");
    }

    public abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current != null) {
                if (current instanceof ByteBuf) {
                    ByteBuf byteBuf = (ByteBuf) current;
                    int readableBytes = byteBuf.readableBytes();
                    while (readableBytes > 0) {
                        doWriteBytes(byteBuf);
                        int readableBytes2 = byteBuf.readableBytes();
                        channelOutboundBuffer.progress((long) (readableBytes - readableBytes2));
                        readableBytes = readableBytes2;
                    }
                    channelOutboundBuffer.remove();
                } else if (current instanceof FileRegion) {
                    FileRegion fileRegion = (FileRegion) current;
                    long transferred = fileRegion.transferred();
                    doWriteFileRegion(fileRegion);
                    channelOutboundBuffer.progress(fileRegion.transferred() - transferred);
                    channelOutboundBuffer.remove();
                } else {
                    channelOutboundBuffer.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(current)));
                }
            } else {
                return;
            }
        }
    }

    public abstract void doWriteBytes(ByteBuf byteBuf) throws Exception;

    public abstract void doWriteFileRegion(FileRegion fileRegion) throws Exception;

    public final Object filterOutboundMessage(Object obj) throws Exception {
        if ((obj instanceof ByteBuf) || (obj instanceof FileRegion)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    public abstract boolean isInputShutdown();

    public ChannelMetadata metadata() {
        return METADATA;
    }

    public abstract ChannelFuture shutdownInput();
}
