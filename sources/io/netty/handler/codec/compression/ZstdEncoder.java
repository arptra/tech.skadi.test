package io.netty.handler.codec.compression;

import com.github.luben.zstd.Zstd;
import com.here.posclient.PositionEstimate;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;

public final class ZstdEncoder extends MessageToByteEncoder<ByteBuf> {
    private final int blockSize;
    private ByteBuf buffer;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdEncoder() {
        this(3, 65536, PositionEstimate.Value.GNSS_TIME);
    }

    private void flushBufferedData(ByteBuf byteBuf) {
        int readableBytes = this.buffer.readableBytes();
        if (readableBytes != 0) {
            byteBuf.ensureWritable((int) Zstd.compressBound((long) readableBytes));
            int writerIndex = byteBuf.writerIndex();
            try {
                ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, byteBuf.writableBytes());
                ByteBuf byteBuf2 = this.buffer;
                byteBuf.writerIndex(writerIndex + Zstd.compress(internalNioBuffer, byteBuf2.internalNioBuffer(byteBuf2.readerIndex(), readableBytes), this.compressionLevel));
                this.buffer.clear();
            } catch (Exception e) {
                throw new CompressionException((Throwable) e);
            }
        }
    }

    public void flush(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null && byteBuf.isReadable()) {
            ByteBuf allocateBuffer = allocateBuffer(channelHandlerContext, Unpooled.EMPTY_BUFFER, isPreferDirect());
            flushBufferedData(allocateBuffer);
            channelHandlerContext.write(allocateBuffer);
        }
        channelHandlerContext.flush();
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ByteBuf directBuffer = channelHandlerContext.alloc().directBuffer(this.blockSize);
        this.buffer = directBuffer;
        directBuffer.clear();
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved(channelHandlerContext);
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null) {
            byteBuf.release();
            this.buffer = null;
        }
    }

    public ZstdEncoder(int i) {
        this(i, 65536, PositionEstimate.Value.GNSS_TIME);
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) {
        if (this.buffer != null) {
            int readableBytes = byteBuf.readableBytes() + this.buffer.readableBytes();
            if (readableBytes >= 0) {
                long j = 0;
                while (readableBytes > 0) {
                    int min = Math.min(this.blockSize, readableBytes);
                    readableBytes -= min;
                    j += Zstd.compressBound((long) min);
                }
                if (j <= ((long) this.maxEncodeSize) && 0 <= j) {
                    return channelHandlerContext.alloc().directBuffer((int) j);
                }
                throw new EncoderException("requested encode buffer size (" + j + " bytes) exceeds the maximum allowable size (" + this.maxEncodeSize + " bytes)");
            }
            throw new EncoderException("too much data to allocate a buffer for compression");
        }
        throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf byteBuf3 = this.buffer;
        if (byteBuf3 != null) {
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
        } else {
            throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
        }
    }

    public ZstdEncoder(int i, int i2) {
        this(3, i, i2);
    }

    public ZstdEncoder(int i, int i2, int i3) {
        super(true);
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(i2, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(i3, "maxEncodeSize");
    }
}
