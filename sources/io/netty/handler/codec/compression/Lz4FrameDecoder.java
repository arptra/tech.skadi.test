package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

public class Lz4FrameDecoder extends ByteToMessageDecoder {
    private int blockType;
    private ByteBufChecksum checksum;
    private int compressedLength;
    private int currentChecksum;
    private State currentState;
    private int decompressedLength;
    private LZ4FastDecompressor decompressor;

    /* renamed from: io.netty.handler.codec.compression.Lz4FrameDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.handler.codec.compression.Lz4FrameDecoder$State[] r0 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State = r0
                io.netty.handler.codec.compression.Lz4FrameDecoder$State r1 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.INIT_BLOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.compression.Lz4FrameDecoder$State r1 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.DECOMPRESS_DATA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.compression.Lz4FrameDecoder$State r1 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.FINISHED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.compression.Lz4FrameDecoder$State r1 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.CORRUPTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Lz4FrameDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        INIT_BLOCK,
        DECOMPRESS_DATA,
        FINISHED,
        CORRUPTED
    }

    public Lz4FrameDecoder() {
        this(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0138 A[SYNTHETIC, Splitter:B:75:0x0138] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r9, io.netty.buffer.ByteBuf r10, java.util.List<java.lang.Object> r11) throws java.lang.Exception {
        /*
            r8 = this;
            int[] r0 = io.netty.handler.codec.compression.Lz4FrameDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State     // Catch:{ Exception -> 0x0020 }
            io.netty.handler.codec.compression.Lz4FrameDecoder$State r1 = r8.currentState     // Catch:{ Exception -> 0x0020 }
            int r1 = r1.ordinal()     // Catch:{ Exception -> 0x0020 }
            r0 = r0[r1]     // Catch:{ Exception -> 0x0020 }
            r1 = 1
            r2 = 16
            r3 = 0
            if (r0 == r1) goto L_0x002c
            r1 = 2
            if (r0 == r1) goto L_0x00b9
            r9 = 3
            if (r0 == r9) goto L_0x0023
            r9 = 4
            if (r0 != r9) goto L_0x001a
            goto L_0x0023
        L_0x001a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0020 }
            r9.<init>()     // Catch:{ Exception -> 0x0020 }
            throw r9     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            r9 = move-exception
            goto L_0x0174
        L_0x0023:
            int r9 = r10.readableBytes()     // Catch:{ Exception -> 0x0020 }
            r10.skipBytes(r9)     // Catch:{ Exception -> 0x0020 }
            goto L_0x012f
        L_0x002c:
            int r0 = r10.readableBytes()     // Catch:{ Exception -> 0x0020 }
            r4 = 21
            if (r0 >= r4) goto L_0x0036
            goto L_0x012f
        L_0x0036:
            long r4 = r10.readLong()     // Catch:{ Exception -> 0x0020 }
            r6 = 5501767354678207339(0x4c5a34426c6f636b, double:6.579441740982069E59)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x016c
            byte r0 = r10.readByte()     // Catch:{ Exception -> 0x0020 }
            r4 = r0 & 15
            int r4 = r4 + 10
            r0 = r0 & 240(0xf0, float:3.36E-43)
            int r5 = r10.readInt()     // Catch:{ Exception -> 0x0020 }
            int r5 = java.lang.Integer.reverseBytes(r5)     // Catch:{ Exception -> 0x0020 }
            r6 = 33554432(0x2000000, float:9.403955E-38)
            if (r5 < 0) goto L_0x0154
            if (r5 > r6) goto L_0x0154
            int r6 = r10.readInt()     // Catch:{ Exception -> 0x0020 }
            int r6 = java.lang.Integer.reverseBytes(r6)     // Catch:{ Exception -> 0x0020 }
            int r1 = r1 << r4
            if (r6 < 0) goto L_0x013c
            if (r6 > r1) goto L_0x013c
            if (r6 != 0) goto L_0x006c
            if (r5 != 0) goto L_0x0075
        L_0x006c:
            if (r6 == 0) goto L_0x0070
            if (r5 == 0) goto L_0x0075
        L_0x0070:
            if (r0 != r2) goto L_0x008d
            if (r6 != r5) goto L_0x0075
            goto L_0x008d
        L_0x0075:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = "stream corrupted: compressedLength(%d) and decompressedLength(%d) mismatch"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0020 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0020 }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r0}     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ Exception -> 0x0020 }
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x0020 }
            throw r9     // Catch:{ Exception -> 0x0020 }
        L_0x008d:
            int r1 = r10.readInt()     // Catch:{ Exception -> 0x0020 }
            int r1 = java.lang.Integer.reverseBytes(r1)     // Catch:{ Exception -> 0x0020 }
            if (r6 != 0) goto L_0x00ad
            if (r5 != 0) goto L_0x00ad
            if (r1 != 0) goto L_0x00a5
            io.netty.handler.codec.compression.Lz4FrameDecoder$State r9 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.FINISHED     // Catch:{ Exception -> 0x0020 }
            r8.currentState = r9     // Catch:{ Exception -> 0x0020 }
            r8.decompressor = r3     // Catch:{ Exception -> 0x0020 }
            r8.checksum = r3     // Catch:{ Exception -> 0x0020 }
            goto L_0x012f
        L_0x00a5:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = "stream corrupted: checksum error"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x0020 }
            throw r9     // Catch:{ Exception -> 0x0020 }
        L_0x00ad:
            r8.blockType = r0     // Catch:{ Exception -> 0x0020 }
            r8.compressedLength = r5     // Catch:{ Exception -> 0x0020 }
            r8.decompressedLength = r6     // Catch:{ Exception -> 0x0020 }
            r8.currentChecksum = r1     // Catch:{ Exception -> 0x0020 }
            io.netty.handler.codec.compression.Lz4FrameDecoder$State r0 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.DECOMPRESS_DATA     // Catch:{ Exception -> 0x0020 }
            r8.currentState = r0     // Catch:{ Exception -> 0x0020 }
        L_0x00b9:
            int r0 = r8.blockType     // Catch:{ Exception -> 0x0020 }
            int r1 = r8.compressedLength     // Catch:{ Exception -> 0x0020 }
            int r4 = r8.decompressedLength     // Catch:{ Exception -> 0x0020 }
            int r5 = r8.currentChecksum     // Catch:{ Exception -> 0x0020 }
            int r6 = r10.readableBytes()     // Catch:{ Exception -> 0x0020 }
            if (r6 >= r1) goto L_0x00c8
            goto L_0x012f
        L_0x00c8:
            io.netty.handler.codec.compression.ByteBufChecksum r6 = r8.checksum     // Catch:{ Exception -> 0x0020 }
            if (r0 == r2) goto L_0x0118
            r7 = 32
            if (r0 != r7) goto L_0x00fc
            io.netty.buffer.ByteBufAllocator r9 = r9.alloc()     // Catch:{ LZ4Exception -> 0x00fa }
            io.netty.buffer.ByteBuf r9 = r9.buffer(r4, r4)     // Catch:{ LZ4Exception -> 0x00fa }
            net.jpountz.lz4.LZ4FastDecompressor r0 = r8.decompressor     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            java.nio.ByteBuffer r2 = io.netty.handler.codec.compression.CompressionUtil.safeNioBuffer(r10)     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            int r7 = r9.writerIndex()     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            java.nio.ByteBuffer r7 = r9.internalNioBuffer(r7, r4)     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            r0.decompress(r2, r7)     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            int r0 = r9.writerIndex()     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            int r0 = r0 + r4
            r9.writerIndex(r0)     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            goto L_0x0120
        L_0x00f2:
            r10 = move-exception
            r3 = r9
            goto L_0x0136
        L_0x00f5:
            r10 = move-exception
            r3 = r9
            goto L_0x0130
        L_0x00f8:
            r10 = move-exception
            goto L_0x0136
        L_0x00fa:
            r10 = move-exception
            goto L_0x0130
        L_0x00fc:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ LZ4Exception -> 0x00fa }
            java.lang.String r10 = "unexpected blockType: %d (expected: %d or %d)"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)     // Catch:{ LZ4Exception -> 0x00fa }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch:{ LZ4Exception -> 0x00fa }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ LZ4Exception -> 0x00fa }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r0, r1}     // Catch:{ LZ4Exception -> 0x00fa }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ LZ4Exception -> 0x00fa }
            r9.<init>((java.lang.String) r10)     // Catch:{ LZ4Exception -> 0x00fa }
            throw r9     // Catch:{ LZ4Exception -> 0x00fa }
        L_0x0118:
            int r9 = r10.readerIndex()     // Catch:{ LZ4Exception -> 0x00fa }
            io.netty.buffer.ByteBuf r9 = r10.retainedSlice(r9, r4)     // Catch:{ LZ4Exception -> 0x00fa }
        L_0x0120:
            r10.skipBytes(r1)     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            if (r6 == 0) goto L_0x0128
            io.netty.handler.codec.compression.CompressionUtil.checkChecksum(r6, r9, r5)     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
        L_0x0128:
            r11.add(r9)     // Catch:{ LZ4Exception -> 0x00f5, all -> 0x00f2 }
            io.netty.handler.codec.compression.Lz4FrameDecoder$State r9 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.INIT_BLOCK     // Catch:{ LZ4Exception -> 0x00fa }
            r8.currentState = r9     // Catch:{ LZ4Exception -> 0x00fa }
        L_0x012f:
            return
        L_0x0130:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ all -> 0x00f8 }
            r9.<init>((java.lang.Throwable) r10)     // Catch:{ all -> 0x00f8 }
            throw r9     // Catch:{ all -> 0x00f8 }
        L_0x0136:
            if (r3 == 0) goto L_0x013b
            r3.release()     // Catch:{ Exception -> 0x0020 }
        L_0x013b:
            throw r10     // Catch:{ Exception -> 0x0020 }
        L_0x013c:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = "invalid decompressedLength: %d (expected: 0-%d)"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0020 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0020 }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r0}     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ Exception -> 0x0020 }
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x0020 }
            throw r9     // Catch:{ Exception -> 0x0020 }
        L_0x0154:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = "invalid compressedLength: %d (expected: 0-%d)"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0020 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0020 }
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r0}     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ Exception -> 0x0020 }
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x0020 }
            throw r9     // Catch:{ Exception -> 0x0020 }
        L_0x016c:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0020 }
            java.lang.String r10 = "unexpected block identifier"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x0020 }
            throw r9     // Catch:{ Exception -> 0x0020 }
        L_0x0174:
            io.netty.handler.codec.compression.Lz4FrameDecoder$State r10 = io.netty.handler.codec.compression.Lz4FrameDecoder.State.CORRUPTED
            r8.currentState = r10
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Lz4FrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public boolean isClosed() {
        return this.currentState == State.FINISHED;
    }

    public Lz4FrameDecoder(boolean z) {
        this(LZ4Factory.fastestInstance(), z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Lz4FrameDecoder(LZ4Factory lZ4Factory, boolean z) {
        this(lZ4Factory, (Checksum) z ? new Lz4XXHash32(-1756908916) : null);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, Checksum checksum2) {
        ByteBufChecksum byteBufChecksum;
        this.currentState = State.INIT_BLOCK;
        this.decompressor = ((LZ4Factory) ObjectUtil.checkNotNull(lZ4Factory, "factory")).fastDecompressor();
        if (checksum2 == null) {
            byteBufChecksum = null;
        } else {
            byteBufChecksum = ByteBufChecksum.wrapChecksum(checksum2);
        }
        this.checksum = byteBufChecksum;
    }
}
