package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;

public class SnappyFrameDecoder extends ByteToMessageDecoder {
    private static final int MAX_COMPRESSED_CHUNK_SIZE = 16777215;
    private static final int MAX_DECOMPRESSED_DATA_SIZE = 65536;
    private static final int MAX_UNCOMPRESSED_DATA_SIZE = 65540;
    private static final int SNAPPY_IDENTIFIER_LEN = 6;
    private boolean corrupted;
    private int numBytesToSkip;
    private final Snappy snappy;
    private boolean started;
    private final boolean validateChecksums;

    /* renamed from: io.netty.handler.codec.compression.SnappyFrameDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType[] r0 = io.netty.handler.codec.compression.SnappyFrameDecoder.ChunkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType = r0
                io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType r1 = io.netty.handler.codec.compression.SnappyFrameDecoder.ChunkType.STREAM_IDENTIFIER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType r1 = io.netty.handler.codec.compression.SnappyFrameDecoder.ChunkType.RESERVED_SKIPPABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType r1 = io.netty.handler.codec.compression.SnappyFrameDecoder.ChunkType.RESERVED_UNSKIPPABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType r1 = io.netty.handler.codec.compression.SnappyFrameDecoder.ChunkType.UNCOMPRESSED_DATA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType r1 = io.netty.handler.codec.compression.SnappyFrameDecoder.ChunkType.COMPRESSED_DATA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.SnappyFrameDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ChunkType {
        STREAM_IDENTIFIER,
        COMPRESSED_DATA,
        UNCOMPRESSED_DATA,
        RESERVED_UNSKIPPABLE,
        RESERVED_SKIPPABLE
    }

    public SnappyFrameDecoder() {
        this(false);
    }

    private static void checkByte(byte b, byte b2) {
        if (b != b2) {
            throw new DecompressionException("Unexpected stream identifier contents. Mismatched snappy protocol version?");
        }
    }

    private static ChunkType mapChunkType(byte b) {
        return b == 0 ? ChunkType.COMPRESSED_DATA : b == 1 ? ChunkType.UNCOMPRESSED_DATA : b == -1 ? ChunkType.STREAM_IDENTIFIER : (b & 128) == 128 ? ChunkType.RESERVED_SKIPPABLE : ChunkType.RESERVED_UNSKIPPABLE;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r9, io.netty.buffer.ByteBuf r10, java.util.List<java.lang.Object> r11) throws java.lang.Exception {
        /*
            r8 = this;
            boolean r0 = r8.corrupted
            if (r0 == 0) goto L_0x000c
            int r8 = r10.readableBytes()
            r10.skipBytes(r8)
            return
        L_0x000c:
            int r0 = r8.numBytesToSkip
            if (r0 == 0) goto L_0x0021
            int r9 = r10.readableBytes()
            int r9 = java.lang.Math.min(r0, r9)
            r10.skipBytes(r9)
            int r10 = r8.numBytesToSkip
            int r10 = r10 - r9
            r8.numBytesToSkip = r10
            return
        L_0x0021:
            r0 = 1
            int r1 = r10.readerIndex()     // Catch:{ Exception -> 0x00b7 }
            int r2 = r10.readableBytes()     // Catch:{ Exception -> 0x00b7 }
            r3 = 4
            if (r2 >= r3) goto L_0x002e
            return
        L_0x002e:
            short r4 = r10.getUnsignedByte(r1)     // Catch:{ Exception -> 0x00b7 }
            byte r5 = (byte) r4     // Catch:{ Exception -> 0x00b7 }
            io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType r5 = mapChunkType(r5)     // Catch:{ Exception -> 0x00b7 }
            int r1 = r1 + r0
            int r1 = r10.getUnsignedMediumLE(r1)     // Catch:{ Exception -> 0x00b7 }
            int[] r6 = io.netty.handler.codec.compression.SnappyFrameDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType     // Catch:{ Exception -> 0x00b7 }
            int r5 = r5.ordinal()     // Catch:{ Exception -> 0x00b7 }
            r5 = r6[r5]     // Catch:{ Exception -> 0x00b7 }
            r6 = 5
            if (r5 == r0) goto L_0x0153
            r7 = 2
            if (r5 == r7) goto L_0x0133
            r7 = 3
            if (r5 == r7) goto L_0x0118
            if (r5 == r3) goto L_0x00d8
            if (r5 == r6) goto L_0x0053
            goto L_0x01a6
        L_0x0053:
            boolean r4 = r8.started     // Catch:{ Exception -> 0x00b7 }
            if (r4 == 0) goto L_0x00d0
            r4 = 16777215(0xffffff, float:2.3509886E-38)
            if (r1 > r4) goto L_0x00c8
            int r4 = r1 + 4
            if (r2 >= r4) goto L_0x0061
            return
        L_0x0061:
            r10.skipBytes(r3)     // Catch:{ Exception -> 0x00b7 }
            int r2 = r10.readIntLE()     // Catch:{ Exception -> 0x00b7 }
            io.netty.handler.codec.compression.Snappy r4 = r8.snappy     // Catch:{ Exception -> 0x00b7 }
            int r4 = r4.getPreamble(r10)     // Catch:{ Exception -> 0x00b7 }
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r4 > r5) goto L_0x00c0
            io.netty.buffer.ByteBufAllocator r9 = r9.alloc()     // Catch:{ Exception -> 0x00b7 }
            io.netty.buffer.ByteBuf r9 = r9.buffer(r4, r5)     // Catch:{ Exception -> 0x00b7 }
            boolean r4 = r8.validateChecksums     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x00a3
            int r4 = r10.writerIndex()     // Catch:{ all -> 0x009c }
            int r5 = r10.readerIndex()     // Catch:{ all -> 0x009e }
            int r5 = r5 + r1
            int r5 = r5 - r3
            r10.writerIndex(r5)     // Catch:{ all -> 0x009e }
            io.netty.handler.codec.compression.Snappy r1 = r8.snappy     // Catch:{ all -> 0x009e }
            r1.decode(r10, r9)     // Catch:{ all -> 0x009e }
            r10.writerIndex(r4)     // Catch:{ all -> 0x009c }
            int r10 = r9.writerIndex()     // Catch:{ all -> 0x009c }
            r1 = 0
            io.netty.handler.codec.compression.Snappy.validateChecksum(r2, r9, r1, r10)     // Catch:{ all -> 0x009c }
            goto L_0x00ad
        L_0x009c:
            r10 = move-exception
            goto L_0x00ba
        L_0x009e:
            r11 = move-exception
            r10.writerIndex(r4)     // Catch:{ all -> 0x009c }
            throw r11     // Catch:{ all -> 0x009c }
        L_0x00a3:
            io.netty.handler.codec.compression.Snappy r2 = r8.snappy     // Catch:{ all -> 0x009c }
            int r1 = r1 - r3
            io.netty.buffer.ByteBuf r10 = r10.readSlice(r1)     // Catch:{ all -> 0x009c }
            r2.decode(r10, r9)     // Catch:{ all -> 0x009c }
        L_0x00ad:
            r11.add(r9)     // Catch:{ all -> 0x009c }
            io.netty.handler.codec.compression.Snappy r9 = r8.snappy     // Catch:{ Exception -> 0x00b7 }
            r9.reset()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x01a6
        L_0x00b7:
            r9 = move-exception
            goto L_0x01be
        L_0x00ba:
            if (r9 == 0) goto L_0x00bf
            r9.release()     // Catch:{ Exception -> 0x00b7 }
        L_0x00bf:
            throw r10     // Catch:{ Exception -> 0x00b7 }
        L_0x00c0:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "Received COMPRESSED_DATA that contains uncompressed data that exceeds 65536 bytes"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x00c8:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "Received COMPRESSED_DATA that contains chunk that exceeds 16777215 bytes"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x00d0:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "Received COMPRESSED_DATA tag before STREAM_IDENTIFIER"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x00d8:
            boolean r9 = r8.started     // Catch:{ Exception -> 0x00b7 }
            if (r9 == 0) goto L_0x0110
            r9 = 65540(0x10004, float:9.1841E-41)
            if (r1 > r9) goto L_0x0108
            int r9 = r1 + 4
            if (r2 >= r9) goto L_0x00e6
            return
        L_0x00e6:
            r10.skipBytes(r3)     // Catch:{ Exception -> 0x00b7 }
            boolean r9 = r8.validateChecksums     // Catch:{ Exception -> 0x00b7 }
            if (r9 == 0) goto L_0x00fb
            int r9 = r10.readIntLE()     // Catch:{ Exception -> 0x00b7 }
            int r2 = r10.readerIndex()     // Catch:{ Exception -> 0x00b7 }
            int r4 = r1 + -4
            io.netty.handler.codec.compression.Snappy.validateChecksum(r9, r10, r2, r4)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00fe
        L_0x00fb:
            r10.skipBytes(r3)     // Catch:{ Exception -> 0x00b7 }
        L_0x00fe:
            int r1 = r1 - r3
            io.netty.buffer.ByteBuf r9 = r10.readRetainedSlice(r1)     // Catch:{ Exception -> 0x00b7 }
            r11.add(r9)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x01a6
        L_0x0108:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "Received UNCOMPRESSED_DATA larger than 65540 bytes"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x0110:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "Received UNCOMPRESSED_DATA tag before STREAM_IDENTIFIER"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x0118:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r10.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r11 = "Found reserved unskippable chunk type: 0x"
            r10.append(r11)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r11 = java.lang.Integer.toHexString(r4)     // Catch:{ Exception -> 0x00b7 }
            r10.append(r11)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00b7 }
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x0133:
            boolean r9 = r8.started     // Catch:{ Exception -> 0x00b7 }
            if (r9 == 0) goto L_0x014b
            r10.skipBytes(r3)     // Catch:{ Exception -> 0x00b7 }
            int r9 = r10.readableBytes()     // Catch:{ Exception -> 0x00b7 }
            int r9 = java.lang.Math.min(r1, r9)     // Catch:{ Exception -> 0x00b7 }
            r10.skipBytes(r9)     // Catch:{ Exception -> 0x00b7 }
            if (r9 == r1) goto L_0x01a6
            int r1 = r1 - r9
            r8.numBytesToSkip = r1     // Catch:{ Exception -> 0x00b7 }
            goto L_0x01a6
        L_0x014b:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "Received RESERVED_SKIPPABLE tag before STREAM_IDENTIFIER"
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x0153:
            r9 = 6
            if (r1 != r9) goto L_0x01a7
            r11 = 10
            if (r2 >= r11) goto L_0x015b
            goto L_0x01a6
        L_0x015b:
            r10.skipBytes(r3)     // Catch:{ Exception -> 0x00b7 }
            int r11 = r10.readerIndex()     // Catch:{ Exception -> 0x00b7 }
            r10.skipBytes(r9)     // Catch:{ Exception -> 0x00b7 }
            int r9 = r11 + 1
            byte r1 = r10.getByte(r11)     // Catch:{ Exception -> 0x00b7 }
            r2 = 115(0x73, float:1.61E-43)
            checkByte(r1, r2)     // Catch:{ Exception -> 0x00b7 }
            int r1 = r11 + 2
            byte r9 = r10.getByte(r9)     // Catch:{ Exception -> 0x00b7 }
            r2 = 78
            checkByte(r9, r2)     // Catch:{ Exception -> 0x00b7 }
            int r9 = r11 + 3
            byte r1 = r10.getByte(r1)     // Catch:{ Exception -> 0x00b7 }
            r2 = 97
            checkByte(r1, r2)     // Catch:{ Exception -> 0x00b7 }
            int r1 = r11 + 4
            byte r9 = r10.getByte(r9)     // Catch:{ Exception -> 0x00b7 }
            r2 = 80
            checkByte(r9, r2)     // Catch:{ Exception -> 0x00b7 }
            int r11 = r11 + r6
            byte r9 = r10.getByte(r1)     // Catch:{ Exception -> 0x00b7 }
            r1 = 112(0x70, float:1.57E-43)
            checkByte(r9, r1)     // Catch:{ Exception -> 0x00b7 }
            byte r9 = r10.getByte(r11)     // Catch:{ Exception -> 0x00b7 }
            r10 = 89
            checkByte(r9, r10)     // Catch:{ Exception -> 0x00b7 }
            r8.started = r0     // Catch:{ Exception -> 0x00b7 }
        L_0x01a6:
            return
        L_0x01a7:
            io.netty.handler.codec.compression.DecompressionException r9 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r10.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r11 = "Unexpected length of stream identifier: "
            r10.append(r11)     // Catch:{ Exception -> 0x00b7 }
            r10.append(r1)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00b7 }
            r9.<init>((java.lang.String) r10)     // Catch:{ Exception -> 0x00b7 }
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x01be:
            r8.corrupted = r0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.SnappyFrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public SnappyFrameDecoder(boolean z) {
        this.snappy = new Snappy();
        this.validateChecksums = z;
    }
}
