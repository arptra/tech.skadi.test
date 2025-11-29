package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

public class FastLzFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private final ByteBufChecksum checksum;
    private final int level;

    public FastLzFrameEncoder() {
        this(0, (Checksum) null);
    }

    public FastLzFrameEncoder(int i) {
        this(i, (Checksum) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(io.netty.channel.ChannelHandlerContext r12, io.netty.buffer.ByteBuf r13, io.netty.buffer.ByteBuf r14) throws java.lang.Exception {
        /*
            r11 = this;
            io.netty.handler.codec.compression.ByteBufChecksum r12 = r11.checksum
        L_0x0002:
            boolean r0 = r13.isReadable()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            int r0 = r13.readerIndex()
            int r1 = r13.readableBytes()
            r2 = 65535(0xffff, float:9.1834E-41)
            int r1 = java.lang.Math.min(r1, r2)
            int r2 = r14.writerIndex()
            r3 = 4607066(0x464c5a, float:6.455875E-39)
            r14.setMedium(r2, r3)
            int r3 = r2 + 4
            r9 = 0
            if (r12 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = r9
        L_0x002a:
            int r10 = r3 + r4
            r4 = 32
            if (r1 >= r4) goto L_0x004d
            int r4 = r10 + 2
            int r5 = r4 + r1
            r14.ensureWritable(r5)
            if (r12 == 0) goto L_0x0047
            r12.reset()
            r12.update(r13, r0, r1)
            long r5 = r12.getValue()
            int r5 = (int) r5
            r14.setInt(r3, r5)
        L_0x0047:
            r14.setBytes((int) r4, (io.netty.buffer.ByteBuf) r13, (int) r0, (int) r1)
        L_0x004a:
            r3 = r1
            r0 = r9
            goto L_0x0083
        L_0x004d:
            if (r12 == 0) goto L_0x005d
            r12.reset()
            r12.update(r13, r0, r1)
            long r4 = r12.getValue()
            int r4 = (int) r4
            r14.setInt(r3, r4)
        L_0x005d:
            int r3 = io.netty.handler.codec.compression.FastLz.calculateOutputBufferLength(r1)
            int r7 = r10 + 4
            int r3 = r3 + r7
            r14.ensureWritable(r3)
            int r4 = r13.readerIndex()
            int r8 = r11.level
            r3 = r13
            r5 = r1
            r6 = r14
            int r3 = io.netty.handler.codec.compression.FastLz.compress(r3, r4, r5, r6, r7, r8)
            if (r3 >= r1) goto L_0x007d
            r14.setShort(r10, r3)
            int r10 = r10 + 2
            r0 = 1
            goto L_0x0083
        L_0x007d:
            int r3 = r10 + 2
            r14.setBytes((int) r3, (io.netty.buffer.ByteBuf) r13, (int) r0, (int) r1)
            goto L_0x004a
        L_0x0083:
            r14.setShort(r10, r1)
            int r2 = r2 + 3
            if (r12 == 0) goto L_0x008c
            r9 = 16
        L_0x008c:
            r0 = r0 | r9
            r14.setByte(r2, r0)
            int r10 = r10 + 2
            int r10 = r10 + r3
            r14.writerIndex(r10)
            r13.skipBytes(r1)
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLzFrameEncoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastLzFrameEncoder(boolean z) {
        this(0, z ? new Adler32() : null);
    }

    public FastLzFrameEncoder(int i, Checksum checksum2) {
        ByteBufChecksum byteBufChecksum;
        if (i == 0 || i == 1 || i == 2) {
            this.level = i;
            if (checksum2 == null) {
                byteBufChecksum = null;
            } else {
                byteBufChecksum = ByteBufChecksum.wrapChecksum(checksum2);
            }
            this.checksum = byteBufChecksum;
            return;
        }
        throw new IllegalArgumentException(String.format("level: %d (expected: %d or %d or %d)", new Object[]{Integer.valueOf(i), 0, 1, 2}));
    }
}
