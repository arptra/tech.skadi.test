package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFChunk;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.commons.codec.language.Soundex;

public class LzfEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_BLOCK_TO_COMPRESS = 16;
    private final int compressThreshold;
    private final ChunkEncoder encoder;
    private final BufferRecycler recycler;

    public LzfEncoder() {
        this(false);
    }

    private int encodeCompress(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return LZFEncoder.appendEncoded(this.encoder, bArr, i, i2, bArr2, i3) - i3;
    }

    private static int encodeNonCompress(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return lzfEncodeNonCompress(bArr, i, i2, bArr2, i3) - i3;
    }

    private static int lzfEncodeNonCompress(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int min = Math.min(65535, i2);
        int appendNonCompressed = LZFChunk.appendNonCompressed(bArr, i, min, bArr2, i3);
        int i4 = i2 - min;
        if (i4 < 1) {
            return appendNonCompressed;
        }
        int i5 = i + min;
        do {
            int min2 = Math.min(i4, 65535);
            appendNonCompressed = LZFChunk.appendNonCompressed(bArr, i5, min2, bArr2, appendNonCompressed);
            i5 += min2;
            i4 -= min2;
        } while (i4 > 0);
        return appendNonCompressed;
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.close();
        super.handlerRemoved(channelHandlerContext);
    }

    public LzfEncoder(boolean z) {
        this(z, 65535);
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        byte[] bArr;
        int i;
        byte[] bArr2;
        int i2;
        int i3;
        int readableBytes = byteBuf.readableBytes();
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.hasArray()) {
            byte[] array = byteBuf.array();
            i = byteBuf.arrayOffset() + readerIndex;
            bArr = array;
        } else {
            byte[] allocInputBuffer = this.recycler.allocInputBuffer(readableBytes);
            byteBuf.getBytes(readerIndex, allocInputBuffer, 0, readableBytes);
            bArr = allocInputBuffer;
            i = 0;
        }
        int estimateMaxWorkspaceSize = LZFEncoder.estimateMaxWorkspaceSize(readableBytes) + 1;
        byteBuf2.ensureWritable(estimateMaxWorkspaceSize);
        if (byteBuf2.hasArray()) {
            bArr2 = byteBuf2.array();
            i2 = byteBuf2.arrayOffset() + byteBuf2.writerIndex();
        } else {
            bArr2 = new byte[estimateMaxWorkspaceSize];
            i2 = 0;
        }
        if (readableBytes >= this.compressThreshold) {
            i3 = encodeCompress(bArr, i, readableBytes, bArr2, i2);
        } else {
            i3 = encodeNonCompress(bArr, i, readableBytes, bArr2, i2);
        }
        if (byteBuf2.hasArray()) {
            byteBuf2.writerIndex(byteBuf2.writerIndex() + i3);
        } else {
            byteBuf2.writeBytes(bArr2, 0, i3);
        }
        byteBuf.skipBytes(readableBytes);
        if (!byteBuf.hasArray()) {
            this.recycler.releaseInputBuffer(bArr);
        }
    }

    public LzfEncoder(boolean z, int i) {
        this(z, i, 16);
    }

    public LzfEncoder(int i) {
        this(false, i);
    }

    public LzfEncoder(boolean z, int i, int i2) {
        super(false);
        ChunkEncoder chunkEncoder;
        if (i < 16 || i > 65535) {
            throw new IllegalArgumentException("totalLength: " + i + " (expected: " + 16 + Soundex.SILENT_MARKER + 65535 + ')');
        } else if (i2 >= 16) {
            this.compressThreshold = i2;
            if (z) {
                chunkEncoder = ChunkEncoderFactory.safeNonAllocatingInstance(i);
            } else {
                chunkEncoder = ChunkEncoderFactory.optimalNonAllocatingInstance(i);
            }
            this.encoder = chunkEncoder;
            this.recycler = BufferRecycler.instance();
        } else {
            throw new IllegalArgumentException("compressThreshold:" + i2 + " expected >=" + 16);
        }
    }
}
