package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

public class FastLzFrameDecoder extends ByteToMessageDecoder {
    private final ByteBufChecksum checksum;
    private int chunkLength;
    private int currentChecksum;
    private State currentState;
    private boolean hasChecksum;
    private boolean isCompressed;
    private int originalLength;

    /* renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.handler.codec.compression.FastLzFrameDecoder$State[] r0 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State = r0
                io.netty.handler.codec.compression.FastLzFrameDecoder$State r1 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.INIT_BLOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.compression.FastLzFrameDecoder$State r1 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.INIT_BLOCK_PARAMS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.compression.FastLzFrameDecoder$State r1 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.DECOMPRESS_DATA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.compression.FastLzFrameDecoder$State r1 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.CORRUPTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLzFrameDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public FastLzFrameDecoder() {
        this(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f A[Catch:{ Exception -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091 A[Catch:{ Exception -> 0x0020 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r10, io.netty.buffer.ByteBuf r11, java.util.List<java.lang.Object> r12) throws java.lang.Exception {
        /*
            r9 = this;
            int[] r0 = io.netty.handler.codec.compression.FastLzFrameDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State     // Catch:{ Exception -> 0x0020 }
            io.netty.handler.codec.compression.FastLzFrameDecoder$State r1 = r9.currentState     // Catch:{ Exception -> 0x0020 }
            int r1 = r1.ordinal()     // Catch:{ Exception -> 0x0020 }
            r0 = r0[r1]     // Catch:{ Exception -> 0x0020 }
            r1 = 4
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r4) goto L_0x0029
            if (r0 == r2) goto L_0x0054
            r2 = 3
            if (r0 == r2) goto L_0x0087
            if (r0 != r1) goto L_0x0023
            int r10 = r11.readableBytes()     // Catch:{ Exception -> 0x0020 }
            r11.skipBytes(r10)     // Catch:{ Exception -> 0x0020 }
            goto L_0x012a
        L_0x0020:
            r10 = move-exception
            goto L_0x0139
        L_0x0023:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0020 }
            r10.<init>()     // Catch:{ Exception -> 0x0020 }
            throw r10     // Catch:{ Exception -> 0x0020 }
        L_0x0029:
            int r0 = r11.readableBytes()     // Catch:{ Exception -> 0x0020 }
            if (r0 >= r1) goto L_0x0031
            goto L_0x012a
        L_0x0031:
            int r0 = r11.readUnsignedMedium()     // Catch:{ Exception -> 0x0020 }
            r5 = 4607066(0x464c5a, float:6.455875E-39)
            if (r0 != r5) goto L_0x0131
            byte r0 = r11.readByte()     // Catch:{ Exception -> 0x0020 }
            r5 = r0 & 1
            if (r5 != r4) goto L_0x0044
            r5 = r4
            goto L_0x0045
        L_0x0044:
            r5 = r3
        L_0x0045:
            r9.isCompressed = r5     // Catch:{ Exception -> 0x0020 }
            r5 = 16
            r0 = r0 & r5
            if (r0 != r5) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r4 = r3
        L_0x004e:
            r9.hasChecksum = r4     // Catch:{ Exception -> 0x0020 }
            io.netty.handler.codec.compression.FastLzFrameDecoder$State r0 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.INIT_BLOCK_PARAMS     // Catch:{ Exception -> 0x0020 }
            r9.currentState = r0     // Catch:{ Exception -> 0x0020 }
        L_0x0054:
            int r0 = r11.readableBytes()     // Catch:{ Exception -> 0x0020 }
            boolean r4 = r9.isCompressed     // Catch:{ Exception -> 0x0020 }
            if (r4 == 0) goto L_0x005e
            r4 = r2
            goto L_0x005f
        L_0x005e:
            r4 = r3
        L_0x005f:
            int r2 = r2 + r4
            boolean r4 = r9.hasChecksum     // Catch:{ Exception -> 0x0020 }
            if (r4 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = r3
        L_0x0066:
            int r2 = r2 + r1
            if (r0 >= r2) goto L_0x006b
            goto L_0x012a
        L_0x006b:
            if (r4 == 0) goto L_0x0071
            int r3 = r11.readInt()     // Catch:{ Exception -> 0x0020 }
        L_0x0071:
            r9.currentChecksum = r3     // Catch:{ Exception -> 0x0020 }
            int r0 = r11.readUnsignedShort()     // Catch:{ Exception -> 0x0020 }
            r9.chunkLength = r0     // Catch:{ Exception -> 0x0020 }
            boolean r1 = r9.isCompressed     // Catch:{ Exception -> 0x0020 }
            if (r1 == 0) goto L_0x0081
            int r0 = r11.readUnsignedShort()     // Catch:{ Exception -> 0x0020 }
        L_0x0081:
            r9.originalLength = r0     // Catch:{ Exception -> 0x0020 }
            io.netty.handler.codec.compression.FastLzFrameDecoder$State r0 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.DECOMPRESS_DATA     // Catch:{ Exception -> 0x0020 }
            r9.currentState = r0     // Catch:{ Exception -> 0x0020 }
        L_0x0087:
            int r0 = r9.chunkLength     // Catch:{ Exception -> 0x0020 }
            int r1 = r11.readableBytes()     // Catch:{ Exception -> 0x0020 }
            if (r1 >= r0) goto L_0x0091
            goto L_0x012a
        L_0x0091:
            int r2 = r11.readerIndex()     // Catch:{ Exception -> 0x0020 }
            int r7 = r9.originalLength     // Catch:{ Exception -> 0x0020 }
            r8 = 0
            boolean r1 = r9.isCompressed     // Catch:{ all -> 0x00d6 }
            if (r1 == 0) goto L_0x00d8
            io.netty.buffer.ByteBufAllocator r10 = r10.alloc()     // Catch:{ all -> 0x00d6 }
            io.netty.buffer.ByteBuf r10 = r10.buffer(r7)     // Catch:{ all -> 0x00d6 }
            int r5 = r10.writerIndex()     // Catch:{ all -> 0x00bb }
            r1 = r11
            r3 = r0
            r4 = r10
            r6 = r7
            int r1 = io.netty.handler.codec.compression.FastLz.decompress(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00bb }
            if (r7 != r1) goto L_0x00be
            int r2 = r10.writerIndex()     // Catch:{ all -> 0x00bb }
            int r2 = r2 + r1
            r10.writerIndex(r2)     // Catch:{ all -> 0x00bb }
            goto L_0x00dc
        L_0x00bb:
            r11 = move-exception
            r8 = r10
            goto L_0x012b
        L_0x00be:
            io.netty.handler.codec.compression.DecompressionException r11 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ all -> 0x00bb }
            java.lang.String r12 = "stream corrupted: originalLength(%d) and actual length(%d) mismatch"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00bb }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00bb }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1}     // Catch:{ all -> 0x00bb }
            java.lang.String r12 = java.lang.String.format(r12, r0)     // Catch:{ all -> 0x00bb }
            r11.<init>((java.lang.String) r12)     // Catch:{ all -> 0x00bb }
            throw r11     // Catch:{ all -> 0x00bb }
        L_0x00d6:
            r11 = move-exception
            goto L_0x012b
        L_0x00d8:
            io.netty.buffer.ByteBuf r10 = r11.retainedSlice(r2, r0)     // Catch:{ all -> 0x00d6 }
        L_0x00dc:
            io.netty.handler.codec.compression.ByteBufChecksum r1 = r9.checksum     // Catch:{ all -> 0x00bb }
            boolean r2 = r9.hasChecksum     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x0116
            if (r1 == 0) goto L_0x0116
            r1.reset()     // Catch:{ all -> 0x00bb }
            int r2 = r10.readerIndex()     // Catch:{ all -> 0x00bb }
            int r3 = r10.readableBytes()     // Catch:{ all -> 0x00bb }
            r1.update(r10, r2, r3)     // Catch:{ all -> 0x00bb }
            long r1 = r1.getValue()     // Catch:{ all -> 0x00bb }
            int r1 = (int) r1     // Catch:{ all -> 0x00bb }
            int r2 = r9.currentChecksum     // Catch:{ all -> 0x00bb }
            if (r1 != r2) goto L_0x00fc
            goto L_0x0116
        L_0x00fc:
            io.netty.handler.codec.compression.DecompressionException r11 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ all -> 0x00bb }
            java.lang.String r12 = "stream corrupted: mismatching checksum: %d (expected: %d)"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00bb }
            int r1 = r9.currentChecksum     // Catch:{ all -> 0x00bb }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00bb }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1}     // Catch:{ all -> 0x00bb }
            java.lang.String r12 = java.lang.String.format(r12, r0)     // Catch:{ all -> 0x00bb }
            r11.<init>((java.lang.String) r12)     // Catch:{ all -> 0x00bb }
            throw r11     // Catch:{ all -> 0x00bb }
        L_0x0116:
            int r1 = r10.readableBytes()     // Catch:{ all -> 0x00bb }
            if (r1 <= 0) goto L_0x0120
            r12.add(r10)     // Catch:{ all -> 0x00bb }
            goto L_0x0123
        L_0x0120:
            r10.release()     // Catch:{ all -> 0x00bb }
        L_0x0123:
            r11.skipBytes(r0)     // Catch:{ all -> 0x00d6 }
            io.netty.handler.codec.compression.FastLzFrameDecoder$State r10 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.INIT_BLOCK     // Catch:{ all -> 0x00d6 }
            r9.currentState = r10     // Catch:{ all -> 0x00d6 }
        L_0x012a:
            return
        L_0x012b:
            if (r8 == 0) goto L_0x0130
            r8.release()     // Catch:{ Exception -> 0x0020 }
        L_0x0130:
            throw r11     // Catch:{ Exception -> 0x0020 }
        L_0x0131:
            io.netty.handler.codec.compression.DecompressionException r10 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0020 }
            java.lang.String r11 = "unexpected block identifier"
            r10.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x0020 }
            throw r10     // Catch:{ Exception -> 0x0020 }
        L_0x0139:
            io.netty.handler.codec.compression.FastLzFrameDecoder$State r11 = io.netty.handler.codec.compression.FastLzFrameDecoder.State.CORRUPTED
            r9.currentState = r11
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLzFrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastLzFrameDecoder(boolean z) {
        this((Checksum) z ? new Adler32() : null);
    }

    public FastLzFrameDecoder(Checksum checksum2) {
        ByteBufChecksum byteBufChecksum;
        this.currentState = State.INIT_BLOCK;
        if (checksum2 == null) {
            byteBufChecksum = null;
        } else {
            byteBufChecksum = ByteBufChecksum.wrapChecksum(checksum2);
        }
        this.checksum = byteBufChecksum;
    }
}
