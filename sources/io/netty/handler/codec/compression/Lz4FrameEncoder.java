package io.netty.handler.codec.compression;

import com.here.posclient.PositionEstimate;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;

public class Lz4FrameEncoder extends MessageToByteEncoder<ByteBuf> {
    static final int DEFAULT_MAX_ENCODE_SIZE = Integer.MAX_VALUE;
    private final int blockSize;
    private ByteBuf buffer;
    private final ByteBufChecksum checksum;
    private final int compressionLevel;
    private final LZ4Compressor compressor;
    private volatile ChannelHandlerContext ctx;
    private volatile boolean finished;
    private final int maxEncodeSize;

    public Lz4FrameEncoder() {
        this(false);
    }

    private static int compressionLevel(int i) {
        if (i >= 64 && i <= 33554432) {
            return Math.max(0, 22 - Integer.numberOfLeadingZeros(i - 1));
        }
        throw new IllegalArgumentException(String.format("blockSize: %d (expected: %d-%d)", new Object[]{Integer.valueOf(i), 64, Integer.valueOf(PositionEstimate.Value.GNSS_TIME)}));
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
        ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(this.compressor.maxCompressedLength(this.buffer.readableBytes()) + 21);
        flushBufferedData(heapBuffer);
        heapBuffer.ensureWritable(21);
        int writerIndex = heapBuffer.writerIndex();
        heapBuffer.setLong(writerIndex, 5501767354678207339L);
        heapBuffer.setByte(writerIndex + 8, (byte) (this.compressionLevel | 16));
        heapBuffer.setInt(writerIndex + 9, 0);
        heapBuffer.setInt(writerIndex + 13, 0);
        heapBuffer.setInt(writerIndex + 17, 0);
        heapBuffer.writerIndex(writerIndex + 21);
        return channelHandlerContext.writeAndFlush(heapBuffer, channelPromise);
    }

    private void flushBufferedData(ByteBuf byteBuf) {
        int i;
        int i2;
        int readableBytes = this.buffer.readableBytes();
        if (readableBytes != 0) {
            this.checksum.reset();
            ByteBufChecksum byteBufChecksum = this.checksum;
            ByteBuf byteBuf2 = this.buffer;
            byteBufChecksum.update(byteBuf2, byteBuf2.readerIndex(), readableBytes);
            int value = (int) this.checksum.getValue();
            byteBuf.ensureWritable(this.compressor.maxCompressedLength(readableBytes) + 21);
            int writerIndex = byteBuf.writerIndex();
            int i3 = writerIndex + 21;
            try {
                ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(i3, byteBuf.writableBytes() - 21);
                int position = internalNioBuffer.position();
                LZ4Compressor lZ4Compressor = this.compressor;
                ByteBuf byteBuf3 = this.buffer;
                lZ4Compressor.compress(byteBuf3.internalNioBuffer(byteBuf3.readerIndex(), readableBytes), internalNioBuffer);
                int position2 = internalNioBuffer.position() - position;
                if (position2 >= readableBytes) {
                    ByteBuf byteBuf4 = this.buffer;
                    byteBuf.setBytes(i3, byteBuf4, byteBuf4.readerIndex(), readableBytes);
                    i2 = 16;
                    i = readableBytes;
                } else {
                    i = position2;
                    i2 = 32;
                }
                byteBuf.setLong(writerIndex, 5501767354678207339L);
                byteBuf.setByte(writerIndex + 8, (byte) (i2 | this.compressionLevel));
                byteBuf.setIntLE(writerIndex + 9, i);
                byteBuf.setIntLE(writerIndex + 13, readableBytes);
                byteBuf.setIntLE(writerIndex + 17, value);
                byteBuf.writerIndex(i3 + i);
                this.buffer.clear();
            } catch (LZ4Exception e) {
                throw new CompressionException((Throwable) e);
            }
        }
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null && byteBuf.isReadable()) {
            ByteBuf allocateBuffer = allocateBuffer(channelHandlerContext, Unpooled.EMPTY_BUFFER, isPreferDirect(), false);
            flushBufferedData(allocateBuffer);
            channelHandlerContext.write(allocateBuffer);
        }
        channelHandlerContext.flush();
    }

    public final ByteBuf getBackingBuffer() {
        return this.buffer;
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(new byte[this.blockSize]);
        this.buffer = wrappedBuffer;
        wrappedBuffer.clear();
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved(channelHandlerContext);
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null) {
            byteBuf.release();
            this.buffer = null;
        }
    }

    public boolean isClosed() {
        return this.finished;
    }

    public Lz4FrameEncoder(boolean z) {
        this(LZ4Factory.fastestInstance(), z, 65536, new Lz4XXHash32(-1756908916));
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) {
        return allocateBuffer(channelHandlerContext, byteBuf, z, true);
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext ctx2 = ctx();
        EventExecutor executor = ctx2.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx2, channelPromise);
        }
        executor.execute(new Runnable() {
            public void run() {
                Lz4FrameEncoder lz4FrameEncoder = Lz4FrameEncoder.this;
                PromiseNotifier.cascade(lz4FrameEncoder.finishEncode(lz4FrameEncoder.ctx(), channelPromise), channelPromise);
            }
        });
        return channelPromise;
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        if (!this.finished) {
            ByteBuf byteBuf3 = this.buffer;
            while (true) {
                int readableBytes = byteBuf.readableBytes();
                if (readableBytes > 0) {
                    byteBuf.readBytes(byteBuf3, Math.min(readableBytes, byteBuf3.writableBytes()));
                    if (!byteBuf3.isWritable()) {
                        flushBufferedData(byteBuf2);
                    }
                } else {
                    return;
                }
            }
        } else if (byteBuf2.isWritable(byteBuf.readableBytes())) {
            byteBuf2.writeBytes(byteBuf);
        } else {
            throw new IllegalStateException("encode finished and not enough space to write remaining data");
        }
    }

    public Lz4FrameEncoder(LZ4Factory lZ4Factory, boolean z, int i, Checksum checksum2) {
        this(lZ4Factory, z, i, checksum2, Integer.MAX_VALUE);
    }

    private ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z, boolean z2) {
        int readableBytes = byteBuf.readableBytes() + this.buffer.readableBytes();
        if (readableBytes >= 0) {
            int i = 0;
            while (readableBytes > 0) {
                int min = Math.min(this.blockSize, readableBytes);
                readableBytes -= min;
                i += this.compressor.maxCompressedLength(min) + 21;
            }
            if (i > this.maxEncodeSize || i < 0) {
                throw new EncoderException(String.format("requested encode buffer size (%d bytes) exceeds the maximum allowable size (%d bytes)", new Object[]{Integer.valueOf(i), Integer.valueOf(this.maxEncodeSize)}));
            } else if (z2 && i < this.blockSize) {
                return Unpooled.EMPTY_BUFFER;
            } else {
                if (z) {
                    return channelHandlerContext.alloc().ioBuffer(i, i);
                }
                return channelHandlerContext.alloc().heapBuffer(i, i);
            }
        } else {
            throw new EncoderException("too much data to allocate a buffer for compression");
        }
    }

    public Lz4FrameEncoder(LZ4Factory lZ4Factory, boolean z, int i, Checksum checksum2, int i2) {
        ObjectUtil.checkNotNull(lZ4Factory, "factory");
        ObjectUtil.checkNotNull(checksum2, "checksum");
        this.compressor = z ? lZ4Factory.highCompressor() : lZ4Factory.fastCompressor();
        this.checksum = ByteBufChecksum.wrapChecksum(checksum2);
        this.compressionLevel = compressionLevel(i);
        this.blockSize = i;
        this.maxEncodeSize = ObjectUtil.checkPositive(i2, "maxEncodeSize");
        this.finished = false;
    }

    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) throws Exception {
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
}
