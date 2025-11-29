package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;

public abstract class ByteToMessageDecoder extends ChannelInboundHandlerAdapter {
    public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator() {
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.netty.buffer.ByteBuf cumulate(io.netty.buffer.ByteBufAllocator r4, io.netty.buffer.ByteBuf r5, io.netty.buffer.ByteBuf r6) {
            /*
                r3 = this;
                boolean r3 = r5.isReadable()
                if (r3 != 0) goto L_0x000a
                r5.release()
                return r6
            L_0x000a:
                r3 = 0
                boolean r0 = r5 instanceof io.netty.buffer.CompositeByteBuf     // Catch:{ all -> 0x002f }
                r1 = 1
                if (r0 == 0) goto L_0x0034
                int r0 = r5.refCnt()     // Catch:{ all -> 0x002f }
                if (r0 != r1) goto L_0x0034
                r4 = r5
                io.netty.buffer.CompositeByteBuf r4 = (io.netty.buffer.CompositeByteBuf) r4     // Catch:{ all -> 0x002f }
                int r3 = r4.writerIndex()     // Catch:{ all -> 0x002b }
                int r0 = r4.capacity()     // Catch:{ all -> 0x002b }
                if (r3 == r0) goto L_0x002d
                int r3 = r4.writerIndex()     // Catch:{ all -> 0x002b }
                r4.capacity((int) r3)     // Catch:{ all -> 0x002b }
                goto L_0x002d
            L_0x002b:
                r3 = move-exception
                goto L_0x0043
            L_0x002d:
                r3 = r4
                goto L_0x003f
            L_0x002f:
                r4 = move-exception
                r2 = r4
                r4 = r3
                r3 = r2
                goto L_0x0043
            L_0x0034:
                r0 = 2147483647(0x7fffffff, float:NaN)
                io.netty.buffer.CompositeByteBuf r4 = r4.compositeBuffer(r0)     // Catch:{ all -> 0x002f }
                io.netty.buffer.CompositeByteBuf r3 = r4.addFlattenedComponents(r1, r5)     // Catch:{ all -> 0x002f }
            L_0x003f:
                r3.addFlattenedComponents(r1, r6)     // Catch:{ all -> 0x002f }
                return r3
            L_0x0043:
                if (r6 == 0) goto L_0x004f
                r6.release()
                if (r4 == 0) goto L_0x004f
                if (r4 == r5) goto L_0x004f
                r4.release()
            L_0x004f:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.ByteToMessageDecoder.AnonymousClass2.cumulate(io.netty.buffer.ByteBufAllocator, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):io.netty.buffer.ByteBuf");
        }
    };
    public static final Cumulator MERGE_CUMULATOR = new Cumulator() {
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            if (byteBuf.isReadable() || !byteBuf2.isContiguous()) {
                try {
                    int readableBytes = byteBuf2.readableBytes();
                    if (readableBytes <= byteBuf.maxWritableBytes()) {
                        if (readableBytes > byteBuf.maxFastWritableBytes()) {
                            if (byteBuf.refCnt() <= 1) {
                            }
                        }
                        if (!byteBuf.isReadOnly()) {
                            byteBuf.writeBytes(byteBuf2, byteBuf2.readerIndex(), readableBytes);
                            byteBuf2.readerIndex(byteBuf2.writerIndex());
                            byteBuf2.release();
                            return byteBuf;
                        }
                    }
                    ByteBuf expandCumulation = ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2);
                    byteBuf2.release();
                    return expandCumulation;
                } catch (Throwable th) {
                    byteBuf2.release();
                    throw th;
                }
            } else {
                byteBuf.release();
                return byteBuf2;
            }
        }
    };
    private static final byte STATE_CALLING_CHILD_DECODE = 1;
    private static final byte STATE_HANDLER_REMOVED_PENDING = 2;
    private static final byte STATE_INIT = 0;
    ByteBuf cumulation;
    private Cumulator cumulator = MERGE_CUMULATOR;
    private byte decodeState = 0;
    private int discardAfterReads = 16;
    private boolean firedChannelRead;
    private boolean first;
    private int numReads;
    private boolean selfFiredChannelRead;
    private boolean singleDecode;

    public interface Cumulator {
        ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);
    }

    public ByteToMessageDecoder() {
        ensureNotSharable();
    }

    private void channelInputClosed(ChannelHandlerContext channelHandlerContext, boolean z) {
        CodecOutputList newInstance = CodecOutputList.newInstance();
        try {
            channelInputClosed(channelHandlerContext, (List<Object>) newInstance);
            try {
                ByteBuf byteBuf = this.cumulation;
                if (byteBuf != null) {
                    byteBuf.release();
                    this.cumulation = null;
                }
                int size = newInstance.size();
                fireChannelRead(channelHandlerContext, newInstance, size);
                if (size > 0) {
                    channelHandlerContext.fireChannelReadComplete();
                }
                if (z) {
                    channelHandlerContext.fireChannelInactive();
                }
                newInstance.recycle();
            } catch (Throwable th) {
                newInstance.recycle();
                throw th;
            }
        } catch (DecoderException e) {
            throw e;
        } catch (Exception e2) {
            throw new DecoderException((Throwable) e2);
        } catch (Throwable th2) {
            newInstance.recycle();
            throw th2;
        }
    }

    public static ByteBuf expandCumulation(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        int readableBytes = byteBuf.readableBytes();
        int readableBytes2 = byteBuf2.readableBytes();
        int i = readableBytes + readableBytes2;
        ByteBuf byteBuf3 = byteBufAllocator.buffer(byteBufAllocator.calculateNewCapacity(i, Integer.MAX_VALUE));
        try {
            byteBuf3.setBytes(0, byteBuf3, byteBuf3.readerIndex(), readableBytes).setBytes(readableBytes, byteBuf2, byteBuf2.readerIndex(), readableBytes2).writerIndex(i);
            byteBuf2.readerIndex(byteBuf2.writerIndex());
            return byteBuf3;
        } finally {
            byteBuf3.release();
        }
    }

    public static void fireChannelRead(ChannelHandlerContext channelHandlerContext, List<Object> list, int i) {
        if (list instanceof CodecOutputList) {
            fireChannelRead(channelHandlerContext, (CodecOutputList) list, i);
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            channelHandlerContext.fireChannelRead(list.get(i2));
        }
    }

    public int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    public void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        while (byteBuf.isReadable()) {
            try {
                int size = list.size();
                if (size > 0) {
                    fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                }
                int readableBytes = byteBuf.readableBytes();
                decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
                if (!channelHandlerContext.isRemoved()) {
                    if (list.isEmpty()) {
                        if (readableBytes == byteBuf.readableBytes()) {
                            return;
                        }
                    } else if (readableBytes == byteBuf.readableBytes()) {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() did not read anything but decoded a message.");
                    } else if (isSingleDecode()) {
                        return;
                    }
                } else {
                    return;
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Exception e2) {
                throw new DecoderException((Throwable) e2);
            }
        }
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelInputClosed(channelHandlerContext, true);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            this.selfFiredChannelRead = true;
            CodecOutputList newInstance = CodecOutputList.newInstance();
            try {
                this.first = this.cumulation == null;
                ByteBuf cumulate = this.cumulator.cumulate(channelHandlerContext.alloc(), this.first ? Unpooled.EMPTY_BUFFER : this.cumulation, (ByteBuf) obj);
                this.cumulation = cumulate;
                callDecode(channelHandlerContext, cumulate, newInstance);
                try {
                    ByteBuf byteBuf = this.cumulation;
                    if (byteBuf == null || byteBuf.isReadable()) {
                        int i = this.numReads + 1;
                        this.numReads = i;
                        if (i >= this.discardAfterReads) {
                            this.numReads = 0;
                            discardSomeReadBytes();
                        }
                    } else {
                        this.numReads = 0;
                        this.cumulation.release();
                        this.cumulation = null;
                    }
                    int size = newInstance.size();
                    this.firedChannelRead |= newInstance.insertSinceRecycled();
                    fireChannelRead(channelHandlerContext, newInstance, size);
                    newInstance.recycle();
                } catch (IllegalReferenceCountException e) {
                    throw new IllegalReferenceCountException(getClass().getSimpleName() + "#decode() might have released its input buffer, or passed it down the pipeline without a retain() call, which is not allowed.", (Throwable) e);
                } catch (Throwable th) {
                    newInstance.recycle();
                    throw th;
                }
            } catch (IllegalReferenceCountException e2) {
                throw new IllegalReferenceCountException(getClass().getSimpleName() + "#decode() might have released its input buffer, or passed it down the pipeline without a retain() call, which is not allowed.", (Throwable) e2);
            } catch (DecoderException e3) {
                throw e3;
            } catch (Exception e4) {
                throw new DecoderException((Throwable) e4);
            } catch (Throwable th2) {
                newInstance.recycle();
                throw th2;
            }
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.numReads = 0;
        discardSomeReadBytes();
        if (this.selfFiredChannelRead && !this.firedChannelRead && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    public abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.isReadable()) {
            decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
        }
    }

    public final void decodeRemovalReentryProtection(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte b = 1;
        this.decodeState = b;
        try {
            decode(channelHandlerContext, byteBuf, list);
        } finally {
            if (this.decodeState != 2) {
                b = 0;
            }
            this.decodeState = 0;
            if (b != 0) {
                fireChannelRead(channelHandlerContext, list, list.size());
                list.clear();
                handlerRemoved(channelHandlerContext);
            }
        }
    }

    public final void discardSomeReadBytes() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null && !this.first && byteBuf.refCnt() == 1) {
            this.cumulation.discardSomeReadBytes();
        }
    }

    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.decodeState == 1) {
            this.decodeState = 2;
            return;
        }
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            this.cumulation = null;
            this.numReads = 0;
            if (byteBuf.readableBytes() > 0) {
                channelHandlerContext.fireChannelRead(byteBuf);
                channelHandlerContext.fireChannelReadComplete();
            } else {
                byteBuf.release();
            }
        }
        handlerRemoved0(channelHandlerContext);
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public ByteBuf internalBuffer() {
        ByteBuf byteBuf = this.cumulation;
        return byteBuf != null ? byteBuf : Unpooled.EMPTY_BUFFER;
    }

    public boolean isSingleDecode() {
        return this.singleDecode;
    }

    public void setCumulator(Cumulator cumulator2) {
        this.cumulator = (Cumulator) ObjectUtil.checkNotNull(cumulator2, "cumulator");
    }

    public void setDiscardAfterReads(int i) {
        ObjectUtil.checkPositive(i, "discardAfterReads");
        this.discardAfterReads = i;
    }

    public void setSingleDecode(boolean z) {
        this.singleDecode = z;
    }

    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof ChannelInputShutdownEvent) {
            channelInputClosed(channelHandlerContext, false);
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    public static void fireChannelRead(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            channelHandlerContext.fireChannelRead(codecOutputList.getUnsafe(i2));
        }
    }

    public void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            callDecode(channelHandlerContext, byteBuf, list);
            if (!channelHandlerContext.isRemoved()) {
                ByteBuf byteBuf2 = this.cumulation;
                if (byteBuf2 == null) {
                    byteBuf2 = Unpooled.EMPTY_BUFFER;
                }
                decodeLast(channelHandlerContext, byteBuf2, list);
                return;
            }
            return;
        }
        decodeLast(channelHandlerContext, Unpooled.EMPTY_BUFFER, list);
    }
}
