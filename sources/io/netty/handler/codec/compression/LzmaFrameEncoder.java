package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import lzma.sdk.lzma.Encoder;

public class LzmaFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int DEFAULT_LC = 3;
    private static final int DEFAULT_LP = 0;
    private static final int DEFAULT_MATCH_FINDER = 1;
    private static final int DEFAULT_PB = 2;
    private static final int MAX_FAST_BYTES = 273;
    private static final int MEDIUM_DICTIONARY_SIZE = 65536;
    private static final int MEDIUM_FAST_BYTES = 32;
    private static final int MIN_FAST_BYTES = 5;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) LzmaFrameEncoder.class);
    private static boolean warningLogged;
    private final Encoder encoder;
    private final int littleEndianDictionarySize;
    private final byte properties;

    public LzmaFrameEncoder() {
        this(65536);
    }

    private static int maxOutputBufferLength(int i) {
        return ((int) (((double) i) * (i < 200 ? 1.5d : i < 500 ? 1.2d : i < 1000 ? 1.1d : i < 10000 ? 1.05d : 1.02d))) + 13;
    }

    public LzmaFrameEncoder(int i, int i2, int i3) {
        this(i, i2, i3, 65536);
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) throws Exception {
        return channelHandlerContext.alloc().ioBuffer(maxOutputBufferLength(byteBuf.readableBytes()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(io.netty.channel.ChannelHandlerContext r11, io.netty.buffer.ByteBuf r12, io.netty.buffer.ByteBuf r13) throws java.lang.Exception {
        /*
            r10 = this;
            int r11 = r12.readableBytes()
            r0 = 0
            io.netty.buffer.ByteBufInputStream r9 = new io.netty.buffer.ByteBufInputStream     // Catch:{ all -> 0x003a }
            r9.<init>(r12)     // Catch:{ all -> 0x003a }
            io.netty.buffer.ByteBufOutputStream r12 = new io.netty.buffer.ByteBufOutputStream     // Catch:{ all -> 0x0037 }
            r12.<init>(r13)     // Catch:{ all -> 0x0037 }
            byte r13 = r10.properties     // Catch:{ all -> 0x0034 }
            r12.writeByte(r13)     // Catch:{ all -> 0x0034 }
            int r13 = r10.littleEndianDictionarySize     // Catch:{ all -> 0x0034 }
            r12.writeInt(r13)     // Catch:{ all -> 0x0034 }
            long r0 = (long) r11     // Catch:{ all -> 0x0034 }
            long r0 = java.lang.Long.reverseBytes(r0)     // Catch:{ all -> 0x0034 }
            r12.writeLong(r0)     // Catch:{ all -> 0x0034 }
            lzma.sdk.lzma.Encoder r1 = r10.encoder     // Catch:{ all -> 0x0034 }
            r6 = -1
            r8 = 0
            r4 = -1
            r2 = r9
            r3 = r12
            r1.code(r2, r3, r4, r6, r8)     // Catch:{ all -> 0x0034 }
            r9.close()
            r12.close()
            return
        L_0x0034:
            r10 = move-exception
        L_0x0035:
            r0 = r9
            goto L_0x003c
        L_0x0037:
            r10 = move-exception
            r12 = r0
            goto L_0x0035
        L_0x003a:
            r10 = move-exception
            r12 = r0
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.close()
        L_0x0041:
            if (r12 == 0) goto L_0x0046
            r12.close()
        L_0x0046:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.LzmaFrameEncoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    public LzmaFrameEncoder(int i) {
        this(3, 0, 2, i);
    }

    public LzmaFrameEncoder(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, false, 32);
    }

    public LzmaFrameEncoder(int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i < 0 || i > 8) {
            throw new IllegalArgumentException("lc: " + i + " (expected: 0-8)");
        } else if (i2 < 0 || i2 > 4) {
            throw new IllegalArgumentException("lp: " + i2 + " (expected: 0-4)");
        } else if (i3 < 0 || i3 > 4) {
            throw new IllegalArgumentException("pb: " + i3 + " (expected: 0-4)");
        } else {
            if (i + i2 > 4 && !warningLogged) {
                logger.warn("The latest versions of LZMA libraries (for example, XZ Utils) has an additional requirement: lc + lp <= 4. Data which don't follow this requirement cannot be decompressed with this libraries.");
                warningLogged = true;
            }
            if (i4 < 0) {
                throw new IllegalArgumentException("dictionarySize: " + i4 + " (expected: 0+)");
            } else if (i5 < 5 || i5 > MAX_FAST_BYTES) {
                throw new IllegalArgumentException(String.format("numFastBytes: %d (expected: %d-%d)", new Object[]{Integer.valueOf(i5), 5, Integer.valueOf(MAX_FAST_BYTES)}));
            } else {
                Encoder encoder2 = new Encoder();
                this.encoder = encoder2;
                encoder2.setDictionarySize(i4);
                encoder2.setEndMarkerMode(z);
                encoder2.setMatchFinder(1);
                encoder2.setNumFastBytes(i5);
                encoder2.setLcLpPb(i, i2, i3);
                this.properties = (byte) ((((i3 * 5) + i2) * 9) + i);
                this.littleEndianDictionarySize = Integer.reverseBytes(i4);
            }
        }
    }
}
