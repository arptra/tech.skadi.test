package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import io.netty.handler.codec.ByteToMessageDecoder;

public class LzfDecoder extends ByteToMessageDecoder {
    private static final short MAGIC_NUMBER = 23126;
    private int chunkLength;
    private State currentState;
    private ChunkDecoder decoder;
    private boolean isCompressed;
    private int originalLength;
    private BufferRecycler recycler;

    /* renamed from: io.netty.handler.codec.compression.LzfDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.handler.codec.compression.LzfDecoder$State[] r0 = io.netty.handler.codec.compression.LzfDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State = r0
                io.netty.handler.codec.compression.LzfDecoder$State r1 = io.netty.handler.codec.compression.LzfDecoder.State.INIT_BLOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.compression.LzfDecoder$State r1 = io.netty.handler.codec.compression.LzfDecoder.State.INIT_ORIGINAL_LENGTH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.compression.LzfDecoder$State r1 = io.netty.handler.codec.compression.LzfDecoder.State.DECOMPRESS_DATA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.compression.LzfDecoder$State r1 = io.netty.handler.codec.compression.LzfDecoder.State.CORRUPTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.LzfDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        INIT_BLOCK,
        INIT_ORIGINAL_LENGTH,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public LzfDecoder() {
        this(false);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096 A[Catch:{ all -> 0x00f5, Exception -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098 A[Catch:{ all -> 0x00f5, Exception -> 0x0023 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r12, io.netty.buffer.ByteBuf r13, java.util.List<java.lang.Object> r14) throws java.lang.Exception {
        /*
            r11 = this;
            int[] r0 = io.netty.handler.codec.compression.LzfDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State     // Catch:{ Exception -> 0x0023 }
            io.netty.handler.codec.compression.LzfDecoder$State r1 = r11.currentState     // Catch:{ Exception -> 0x0023 }
            int r1 = r1.ordinal()     // Catch:{ Exception -> 0x0023 }
            r0 = r0[r1]     // Catch:{ Exception -> 0x0023 }
            r1 = 2
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 0
            r4 = 1
            if (r0 == r4) goto L_0x002c
            if (r0 == r1) goto L_0x007a
            r1 = 3
            if (r0 == r1) goto L_0x008e
            r12 = 4
            if (r0 != r12) goto L_0x0026
            int r12 = r13.readableBytes()     // Catch:{ Exception -> 0x0023 }
            r13.skipBytes(r12)     // Catch:{ Exception -> 0x0023 }
            goto L_0x011d
        L_0x0023:
            r12 = move-exception
            goto L_0x015a
        L_0x0026:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0023 }
            r12.<init>()     // Catch:{ Exception -> 0x0023 }
            throw r12     // Catch:{ Exception -> 0x0023 }
        L_0x002c:
            int r0 = r13.readableBytes()     // Catch:{ Exception -> 0x0023 }
            r5 = 5
            if (r0 >= r5) goto L_0x0035
            goto L_0x011d
        L_0x0035:
            int r0 = r13.readUnsignedShort()     // Catch:{ Exception -> 0x0023 }
            r5 = 23126(0x5a56, float:3.2406E-41)
            if (r0 != r5) goto L_0x0152
            byte r0 = r13.readByte()     // Catch:{ Exception -> 0x0023 }
            if (r0 == 0) goto L_0x0068
            if (r0 != r4) goto L_0x004c
            r11.isCompressed = r4     // Catch:{ Exception -> 0x0023 }
            io.netty.handler.codec.compression.LzfDecoder$State r5 = io.netty.handler.codec.compression.LzfDecoder.State.INIT_ORIGINAL_LENGTH     // Catch:{ Exception -> 0x0023 }
            r11.currentState = r5     // Catch:{ Exception -> 0x0023 }
            goto L_0x006e
        L_0x004c:
            io.netty.handler.codec.compression.DecompressionException r12 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0023 }
            java.lang.String r13 = "unknown type of chunk: %d (expected: %d or %d)"
            java.lang.Integer r14 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0023 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0023 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0023 }
            java.lang.Object[] r14 = new java.lang.Object[]{r14, r0, r1}     // Catch:{ Exception -> 0x0023 }
            java.lang.String r13 = java.lang.String.format(r13, r14)     // Catch:{ Exception -> 0x0023 }
            r12.<init>((java.lang.String) r13)     // Catch:{ Exception -> 0x0023 }
            throw r12     // Catch:{ Exception -> 0x0023 }
        L_0x0068:
            r11.isCompressed = r3     // Catch:{ Exception -> 0x0023 }
            io.netty.handler.codec.compression.LzfDecoder$State r5 = io.netty.handler.codec.compression.LzfDecoder.State.DECOMPRESS_DATA     // Catch:{ Exception -> 0x0023 }
            r11.currentState = r5     // Catch:{ Exception -> 0x0023 }
        L_0x006e:
            int r5 = r13.readUnsignedShort()     // Catch:{ Exception -> 0x0023 }
            r11.chunkLength = r5     // Catch:{ Exception -> 0x0023 }
            if (r5 > r2) goto L_0x0138
            if (r0 == r4) goto L_0x007a
            goto L_0x011d
        L_0x007a:
            int r0 = r13.readableBytes()     // Catch:{ Exception -> 0x0023 }
            if (r0 >= r1) goto L_0x0082
            goto L_0x011d
        L_0x0082:
            int r0 = r13.readUnsignedShort()     // Catch:{ Exception -> 0x0023 }
            r11.originalLength = r0     // Catch:{ Exception -> 0x0023 }
            if (r0 > r2) goto L_0x011e
            io.netty.handler.codec.compression.LzfDecoder$State r0 = io.netty.handler.codec.compression.LzfDecoder.State.DECOMPRESS_DATA     // Catch:{ Exception -> 0x0023 }
            r11.currentState = r0     // Catch:{ Exception -> 0x0023 }
        L_0x008e:
            int r0 = r11.chunkLength     // Catch:{ Exception -> 0x0023 }
            int r1 = r13.readableBytes()     // Catch:{ Exception -> 0x0023 }
            if (r1 >= r0) goto L_0x0098
            goto L_0x011d
        L_0x0098:
            int r1 = r11.originalLength     // Catch:{ Exception -> 0x0023 }
            boolean r2 = r11.isCompressed     // Catch:{ Exception -> 0x0023 }
            if (r2 == 0) goto L_0x0110
            int r2 = r13.readerIndex()     // Catch:{ Exception -> 0x0023 }
            boolean r4 = r13.hasArray()     // Catch:{ Exception -> 0x0023 }
            if (r4 == 0) goto L_0x00b3
            byte[] r4 = r13.array()     // Catch:{ Exception -> 0x0023 }
            int r5 = r13.arrayOffset()     // Catch:{ Exception -> 0x0023 }
            int r5 = r5 + r2
            r7 = r5
            goto L_0x00bd
        L_0x00b3:
            com.ning.compress.BufferRecycler r4 = r11.recycler     // Catch:{ Exception -> 0x0023 }
            byte[] r4 = r4.allocInputBuffer(r0)     // Catch:{ Exception -> 0x0023 }
            r13.getBytes((int) r2, (byte[]) r4, (int) r3, (int) r0)     // Catch:{ Exception -> 0x0023 }
            r7 = r3
        L_0x00bd:
            io.netty.buffer.ByteBufAllocator r12 = r12.alloc()     // Catch:{ Exception -> 0x0023 }
            io.netty.buffer.ByteBuf r12 = r12.heapBuffer(r1, r1)     // Catch:{ Exception -> 0x0023 }
            boolean r2 = r12.hasArray()     // Catch:{ Exception -> 0x0023 }
            if (r2 == 0) goto L_0x00da
            byte[] r2 = r12.array()     // Catch:{ Exception -> 0x0023 }
            int r3 = r12.arrayOffset()     // Catch:{ Exception -> 0x0023 }
            int r5 = r12.writerIndex()     // Catch:{ Exception -> 0x0023 }
            int r3 = r3 + r5
        L_0x00d8:
            r9 = r3
            goto L_0x00dd
        L_0x00da:
            byte[] r2 = new byte[r1]     // Catch:{ Exception -> 0x0023 }
            goto L_0x00d8
        L_0x00dd:
            com.ning.compress.lzf.ChunkDecoder r5 = r11.decoder     // Catch:{ all -> 0x00f5 }
            int r10 = r9 + r1
            r6 = r4
            r8 = r2
            r5.decodeChunk(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00f5 }
            boolean r3 = r12.hasArray()     // Catch:{ all -> 0x00f5 }
            if (r3 == 0) goto L_0x00f7
            int r2 = r12.writerIndex()     // Catch:{ all -> 0x00f5 }
            int r2 = r2 + r1
            r12.writerIndex(r2)     // Catch:{ all -> 0x00f5 }
            goto L_0x00fa
        L_0x00f5:
            r13 = move-exception
            goto L_0x010c
        L_0x00f7:
            r12.writeBytes((byte[]) r2)     // Catch:{ all -> 0x00f5 }
        L_0x00fa:
            r14.add(r12)     // Catch:{ all -> 0x00f5 }
            r13.skipBytes(r0)     // Catch:{ all -> 0x00f5 }
            boolean r12 = r13.hasArray()     // Catch:{ Exception -> 0x0023 }
            if (r12 != 0) goto L_0x0119
            com.ning.compress.BufferRecycler r12 = r11.recycler     // Catch:{ Exception -> 0x0023 }
            r12.releaseInputBuffer(r4)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0119
        L_0x010c:
            r12.release()     // Catch:{ Exception -> 0x0023 }
            throw r13     // Catch:{ Exception -> 0x0023 }
        L_0x0110:
            if (r0 <= 0) goto L_0x0119
            io.netty.buffer.ByteBuf r12 = r13.readRetainedSlice(r0)     // Catch:{ Exception -> 0x0023 }
            r14.add(r12)     // Catch:{ Exception -> 0x0023 }
        L_0x0119:
            io.netty.handler.codec.compression.LzfDecoder$State r12 = io.netty.handler.codec.compression.LzfDecoder.State.INIT_BLOCK     // Catch:{ Exception -> 0x0023 }
            r11.currentState = r12     // Catch:{ Exception -> 0x0023 }
        L_0x011d:
            return
        L_0x011e:
            io.netty.handler.codec.compression.DecompressionException r12 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0023 }
            java.lang.String r13 = "original length exceeds maximum: %d (expected: =< %d)"
            int r14 = r11.chunkLength     // Catch:{ Exception -> 0x0023 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0023 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.Object[] r14 = new java.lang.Object[]{r14, r0}     // Catch:{ Exception -> 0x0023 }
            java.lang.String r13 = java.lang.String.format(r13, r14)     // Catch:{ Exception -> 0x0023 }
            r12.<init>((java.lang.String) r13)     // Catch:{ Exception -> 0x0023 }
            throw r12     // Catch:{ Exception -> 0x0023 }
        L_0x0138:
            io.netty.handler.codec.compression.DecompressionException r12 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0023 }
            java.lang.String r13 = "chunk length exceeds maximum: %d (expected: =< %d)"
            int r14 = r11.chunkLength     // Catch:{ Exception -> 0x0023 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0023 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.Object[] r14 = new java.lang.Object[]{r14, r0}     // Catch:{ Exception -> 0x0023 }
            java.lang.String r13 = java.lang.String.format(r13, r14)     // Catch:{ Exception -> 0x0023 }
            r12.<init>((java.lang.String) r13)     // Catch:{ Exception -> 0x0023 }
            throw r12     // Catch:{ Exception -> 0x0023 }
        L_0x0152:
            io.netty.handler.codec.compression.DecompressionException r12 = new io.netty.handler.codec.compression.DecompressionException     // Catch:{ Exception -> 0x0023 }
            java.lang.String r13 = "unexpected block identifier"
            r12.<init>((java.lang.String) r13)     // Catch:{ Exception -> 0x0023 }
            throw r12     // Catch:{ Exception -> 0x0023 }
        L_0x015a:
            io.netty.handler.codec.compression.LzfDecoder$State r13 = io.netty.handler.codec.compression.LzfDecoder.State.CORRUPTED
            r11.currentState = r13
            r13 = 0
            r11.decoder = r13
            r11.recycler = r13
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.LzfDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public LzfDecoder(boolean z) {
        ChunkDecoder chunkDecoder;
        this.currentState = State.INIT_BLOCK;
        if (z) {
            chunkDecoder = ChunkDecoderFactory.safeInstance();
        } else {
            chunkDecoder = ChunkDecoderFactory.optimalInstance();
        }
        this.decoder = chunkDecoder;
        this.recycler = BufferRecycler.instance();
    }
}
