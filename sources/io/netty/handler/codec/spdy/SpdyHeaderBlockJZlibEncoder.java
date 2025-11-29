package io.netty.handler.codec.spdy;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;
import io.netty.util.internal.ObjectUtil;

class SpdyHeaderBlockJZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private boolean finished;
    private final Deflater z;

    public SpdyHeaderBlockJZlibEncoder(SpdyVersion spdyVersion, int i, int i2, int i3) {
        super(spdyVersion);
        Deflater deflater = new Deflater();
        this.z = deflater;
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        } else if (i2 < 9 || i2 > 15) {
            throw new IllegalArgumentException("windowBits: " + i2 + " (expected: 9-15)");
        } else if (i3 < 1 || i3 > 9) {
            throw new IllegalArgumentException("memLevel: " + i3 + " (expected: 1-9)");
        } else {
            int deflateInit = deflater.deflateInit(i, i2, i3, JZlib.W_ZLIB);
            if (deflateInit == 0) {
                byte[] bArr = SpdyCodecUtil.SPDY_DICT;
                int deflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
                if (deflateSetDictionary != 0) {
                    throw new CompressionException("failed to set the SPDY dictionary: " + deflateSetDictionary);
                }
                return;
            }
            throw new CompressionException("failed to initialize an SPDY header block deflater: " + deflateInit);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.netty.buffer.ByteBuf encode(io.netty.buffer.ByteBufAllocator r8) {
        /*
            r7 = this;
            r0 = 0
            com.jcraft.jzlib.Deflater r1 = r7.z     // Catch:{ all -> 0x0086 }
            int r1 = r1.next_in_index     // Catch:{ all -> 0x0086 }
            com.jcraft.jzlib.Deflater r2 = r7.z     // Catch:{ all -> 0x0086 }
            int r2 = r2.next_out_index     // Catch:{ all -> 0x0086 }
            com.jcraft.jzlib.Deflater r3 = r7.z     // Catch:{ all -> 0x0086 }
            byte[] r3 = r3.next_in     // Catch:{ all -> 0x0086 }
            int r3 = r3.length     // Catch:{ all -> 0x0086 }
            double r3 = (double) r3     // Catch:{ all -> 0x0086 }
            r5 = 4607186922399644778(0x3ff004189374bc6a, double:1.001)
            double r3 = r3 * r5
            double r3 = java.lang.Math.ceil(r3)     // Catch:{ all -> 0x0086 }
            int r3 = (int) r3     // Catch:{ all -> 0x0086 }
            int r3 = r3 + 12
            io.netty.buffer.ByteBuf r8 = r8.heapBuffer(r3)     // Catch:{ all -> 0x0086 }
            com.jcraft.jzlib.Deflater r4 = r7.z     // Catch:{ all -> 0x005a }
            byte[] r5 = r8.array()     // Catch:{ all -> 0x005a }
            r4.next_out = r5     // Catch:{ all -> 0x005a }
            com.jcraft.jzlib.Deflater r4 = r7.z     // Catch:{ all -> 0x005a }
            int r5 = r8.arrayOffset()     // Catch:{ all -> 0x005a }
            int r6 = r8.writerIndex()     // Catch:{ all -> 0x005a }
            int r5 = r5 + r6
            r4.next_out_index = r5     // Catch:{ all -> 0x005a }
            com.jcraft.jzlib.Deflater r4 = r7.z     // Catch:{ all -> 0x005a }
            r4.avail_out = r3     // Catch:{ all -> 0x005a }
            com.jcraft.jzlib.Deflater r3 = r7.z     // Catch:{ all -> 0x007c }
            r4 = 2
            int r3 = r3.deflate(r4)     // Catch:{ all -> 0x007c }
            com.jcraft.jzlib.Deflater r4 = r7.z     // Catch:{ all -> 0x005a }
            int r4 = r4.next_in_index     // Catch:{ all -> 0x005a }
            int r4 = r4 - r1
            r8.skipBytes(r4)     // Catch:{ all -> 0x005a }
            if (r3 != 0) goto L_0x0065
            com.jcraft.jzlib.Deflater r1 = r7.z     // Catch:{ all -> 0x005a }
            int r1 = r1.next_out_index     // Catch:{ all -> 0x005a }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x005c
            int r2 = r8.writerIndex()     // Catch:{ all -> 0x005a }
            int r2 = r2 + r1
            r8.writerIndex(r2)     // Catch:{ all -> 0x005a }
            goto L_0x005c
        L_0x005a:
            r1 = move-exception
            goto L_0x0088
        L_0x005c:
            com.jcraft.jzlib.Deflater r1 = r7.z
            r1.next_in = r0
            com.jcraft.jzlib.Deflater r7 = r7.z
            r7.next_out = r0
            return r8
        L_0x0065:
            io.netty.handler.codec.compression.CompressionException r1 = new io.netty.handler.codec.compression.CompressionException     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r2.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "compression failure: "
            r2.append(r4)     // Catch:{ all -> 0x005a }
            r2.append(r3)     // Catch:{ all -> 0x005a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005a }
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x005a }
            throw r1     // Catch:{ all -> 0x005a }
        L_0x007c:
            r2 = move-exception
            com.jcraft.jzlib.Deflater r3 = r7.z     // Catch:{ all -> 0x005a }
            int r3 = r3.next_in_index     // Catch:{ all -> 0x005a }
            int r3 = r3 - r1
            r8.skipBytes(r3)     // Catch:{ all -> 0x005a }
            throw r2     // Catch:{ all -> 0x005a }
        L_0x0086:
            r1 = move-exception
            r8 = r0
        L_0x0088:
            com.jcraft.jzlib.Deflater r2 = r7.z
            r2.next_in = r0
            com.jcraft.jzlib.Deflater r7 = r7.z
            r7.next_out = r0
            if (r8 == 0) goto L_0x0095
            r8.release()
        L_0x0095:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyHeaderBlockJZlibEncoder.encode(io.netty.buffer.ByteBufAllocator):io.netty.buffer.ByteBuf");
    }

    private void setInput(ByteBuf byteBuf) {
        int i;
        byte[] bArr;
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArr = byteBuf.array();
            i = byteBuf.arrayOffset() + byteBuf.readerIndex();
        } else {
            bArr = new byte[readableBytes];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            i = 0;
        }
        this.z.next_in = bArr;
        this.z.next_in_index = i;
        this.z.avail_in = readableBytes;
    }

    public void end() {
        if (!this.finished) {
            this.finished = true;
            this.z.deflateEnd();
            this.z.next_in = null;
            this.z.next_out = null;
        }
    }

    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        ObjectUtil.checkNotNullWithIAE(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNullWithIAE(spdyHeadersFrame, "frame");
        if (this.finished) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf encode = super.encode(byteBufAllocator, spdyHeadersFrame);
        try {
            if (!encode.isReadable()) {
                return Unpooled.EMPTY_BUFFER;
            }
            setInput(encode);
            ByteBuf encode2 = encode(byteBufAllocator);
            encode.release();
            return encode2;
        } finally {
            encode.release();
        }
    }
}
