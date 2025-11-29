package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public class JZlibEncoder extends ZlibEncoder {
    private static final int THREAD_POOL_DELAY_SECONDS = 10;
    private volatile ChannelHandlerContext ctx;
    private volatile boolean finished;
    private final int wrapperOverhead;
    private final Deflater z;

    public JZlibEncoder() {
        this(6);
    }

    /* access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    /* access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        try {
            this.z.next_in = EmptyArrays.EMPTY_BYTES;
            this.z.next_in_index = 0;
            this.z.avail_in = 0;
            byte[] bArr = new byte[32];
            this.z.next_out = bArr;
            this.z.next_out_index = 0;
            this.z.avail_out = 32;
            int deflate = this.z.deflate(4);
            if (deflate == 0 || deflate == 1) {
                ByteBuf wrappedBuffer = this.z.next_out_index != 0 ? Unpooled.wrappedBuffer(bArr, 0, this.z.next_out_index) : Unpooled.EMPTY_BUFFER;
                this.z.deflateEnd();
                this.z.next_in = null;
                this.z.next_out = null;
                return channelHandlerContext.writeAndFlush(wrappedBuffer, channelPromise);
            }
            channelPromise.setFailure(ZlibUtil.deflaterException(this.z, "compression failure", deflate));
            return channelPromise;
        } finally {
            this.z.deflateEnd();
            this.z.next_in = null;
            this.z.next_out = null;
        }
    }

    public ChannelFuture close() {
        return close(ctx().channel().newPromise());
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public boolean isClosed() {
        return this.finished;
    }

    public JZlibEncoder(int i) {
        this(ZlibWrapper.ZLIB, i);
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext ctx2 = ctx();
        EventExecutor executor = ctx2.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx2, channelPromise);
        }
        final ChannelPromise newPromise = ctx2.newPromise();
        executor.execute(new Runnable() {
            public void run() {
                JZlibEncoder jZlibEncoder = JZlibEncoder.this;
                PromiseNotifier.cascade(jZlibEncoder.finishEncode(jZlibEncoder.ctx(), newPromise), channelPromise);
            }
        });
        return newPromise;
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        int i;
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != 0) {
            try {
                boolean hasArray = byteBuf.hasArray();
                this.z.avail_in = readableBytes;
                if (hasArray) {
                    this.z.next_in = byteBuf.array();
                    this.z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
                } else {
                    byte[] bArr = new byte[readableBytes];
                    byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                    this.z.next_in = bArr;
                    this.z.next_in_index = 0;
                }
                i = this.z.next_in_index;
                int ceil = ((int) Math.ceil(((double) readableBytes) * 1.001d)) + 12 + this.wrapperOverhead;
                byteBuf2.ensureWritable(ceil);
                this.z.avail_out = ceil;
                this.z.next_out = byteBuf2.array();
                this.z.next_out_index = byteBuf2.arrayOffset() + byteBuf2.writerIndex();
                int i2 = this.z.next_out_index;
                int deflate = this.z.deflate(2);
                byteBuf.skipBytes(this.z.next_in_index - i);
                if (deflate != 0) {
                    ZlibUtil.fail(this.z, "compression failure", deflate);
                }
                int i3 = this.z.next_out_index - i2;
                if (i3 > 0) {
                    byteBuf2.writerIndex(byteBuf2.writerIndex() + i3);
                }
                this.z.next_in = null;
                this.z.next_out = null;
            } catch (Throwable th) {
                this.z.next_in = null;
                this.z.next_out = null;
                throw th;
            }
        }
    }

    public JZlibEncoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 6);
    }

    public JZlibEncoder(ZlibWrapper zlibWrapper, int i) {
        this(zlibWrapper, i, 15, 8);
    }

    public JZlibEncoder(ZlibWrapper zlibWrapper, int i, int i2, int i3) {
        Deflater deflater = new Deflater();
        this.z = deflater;
        ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        ObjectUtil.checkInRange(i3, 1, 9, "memLevel");
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        ZlibWrapper zlibWrapper2 = ZlibWrapper.ZLIB_OR_NONE;
        if (zlibWrapper != zlibWrapper2) {
            int init = deflater.init(i, i2, i3, ZlibUtil.convertWrapperType(zlibWrapper));
            if (init != 0) {
                ZlibUtil.fail(deflater, "initialization failure", init);
            }
            this.wrapperOverhead = ZlibUtil.wrapperOverhead(zlibWrapper);
            return;
        }
        throw new IllegalArgumentException("wrapper '" + zlibWrapper2 + "' is not allowed for compression.");
    }

    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        ChannelFuture finishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        finishEncode.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (!finishEncode.isDone()) {
            channelHandlerContext.executor().schedule((Runnable) new Runnable() {
                public void run() {
                    channelHandlerContext.close(channelPromise);
                }
            }, 10, TimeUnit.SECONDS);
        }
    }

    public JZlibEncoder(byte[] bArr) {
        this(6, bArr);
    }

    public JZlibEncoder(int i, byte[] bArr) {
        this(i, 15, 8, bArr);
    }

    public JZlibEncoder(int i, int i2, int i3, byte[] bArr) {
        Deflater deflater = new Deflater();
        this.z = deflater;
        ObjectUtil.checkInRange(i, 0, 9, "compressionLevel");
        ObjectUtil.checkInRange(i2, 9, 15, "windowBits");
        ObjectUtil.checkInRange(i3, 1, 9, "memLevel");
        ObjectUtil.checkNotNull(bArr, "dictionary");
        int deflateInit = deflater.deflateInit(i, i2, i3, JZlib.W_ZLIB);
        if (deflateInit != 0) {
            ZlibUtil.fail(deflater, "initialization failure", deflateInit);
        } else {
            int deflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
            if (deflateSetDictionary != 0) {
                ZlibUtil.fail(deflater, "failed to set the dictionary", deflateSetDictionary);
            }
        }
        this.wrapperOverhead = ZlibUtil.wrapperOverhead(ZlibWrapper.ZLIB);
    }
}
