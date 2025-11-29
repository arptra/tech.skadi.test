package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;

public class Bzip2Decoder extends ByteToMessageDecoder {
    private int blockCRC;
    private Bzip2BlockDecompressor blockDecompressor;
    private int blockSize;
    private State currentState = State.INIT;
    private Bzip2HuffmanStageDecoder huffmanStageDecoder;
    private final Bzip2BitReader reader = new Bzip2BitReader();
    private int streamCRC;

    /* renamed from: io.netty.handler.codec.compression.Bzip2Decoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.compression.Bzip2Decoder$State[] r0 = io.netty.handler.codec.compression.Bzip2Decoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State = r0
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK_PARAMS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_MAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_BITMAPS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS_NUMBER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_LENGTH     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x006c }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.DECODE_HUFFMAN_DATA     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.compression.Bzip2Decoder$State r1 = io.netty.handler.codec.compression.Bzip2Decoder.State.EOF     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2Decoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        INIT,
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        RECEIVE_HUFFMAN_USED_MAP,
        RECEIVE_HUFFMAN_USED_BITMAPS,
        RECEIVE_SELECTORS_NUMBER,
        RECEIVE_SELECTORS,
        RECEIVE_HUFFMAN_LENGTH,
        DECODE_HUFFMAN_DATA,
        EOF
    }

    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0268, code lost:
        throw new io.netty.handler.codec.compression.DecompressionException("block size is invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (r2.hasReadableBytes(10) != false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        r3 = r2.readBits(24);
        r5 = r2.readBits(24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
        if (r3 != 1536581) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r5 != 3690640) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r2.readInt() != r0.streamCRC) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        throw new io.netty.handler.codec.compression.DecompressionException("stream CRC error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0191, code lost:
        r11 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r17, io.netty.buffer.ByteBuf r18, java.util.List<java.lang.Object> r19) throws java.lang.Exception {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r18.isReadable()
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            io.netty.handler.codec.compression.Bzip2BitReader r2 = r0.reader
            r2.setByteBuf(r1)
        L_0x0010:
            int[] r3 = io.netty.handler.codec.compression.Bzip2Decoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State
            io.netty.handler.codec.compression.Bzip2Decoder$State r4 = r0.currentState
            int r4 = r4.ordinal()
            r3 = r3[r4]
            r9 = 6
            r4 = 24
            r10 = 16
            r11 = 0
            r12 = 1
            switch(r3) {
                case 1: goto L_0x0032;
                case 2: goto L_0x005b;
                case 3: goto L_0x009f;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00d4;
                case 6: goto L_0x0131;
                case 7: goto L_0x014e;
                case 8: goto L_0x0179;
                case 9: goto L_0x01ed;
                case 10: goto L_0x002a;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x002a:
            int r0 = r18.readableBytes()
            r1.skipBytes(r0)
            return
        L_0x0032:
            int r3 = r18.readableBytes()
            r5 = 4
            if (r3 >= r5) goto L_0x003a
            return
        L_0x003a:
            int r3 = r18.readUnsignedMedium()
            r5 = 4348520(0x425a68, float:6.093574E-39)
            if (r3 != r5) goto L_0x0269
            byte r3 = r18.readByte()
            int r3 = r3 + -48
            if (r3 < r12) goto L_0x0261
            r5 = 9
            if (r3 > r5) goto L_0x0261
            r5 = 100000(0x186a0, float:1.4013E-40)
            int r3 = r3 * r5
            r0.blockSize = r3
            r0.streamCRC = r11
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK
            r0.currentState = r3
        L_0x005b:
            r3 = 10
            boolean r3 = r2.hasReadableBytes(r3)
            if (r3 != 0) goto L_0x0064
            return
        L_0x0064:
            int r3 = r2.readBits(r4)
            int r5 = r2.readBits(r4)
            r6 = 1536581(0x177245, float:2.153209E-39)
            if (r3 != r6) goto L_0x008b
            r6 = 3690640(0x385090, float:5.171688E-39)
            if (r5 != r6) goto L_0x008b
            int r3 = r2.readInt()
            int r4 = r0.streamCRC
            if (r3 != r4) goto L_0x0083
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.EOF
            r0.currentState = r3
            goto L_0x0010
        L_0x0083:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r1 = "stream CRC error"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x008b:
            r6 = 3227993(0x314159, float:4.523382E-39)
            if (r3 != r6) goto L_0x0259
            r3 = 2511705(0x265359, float:3.519648E-39)
            if (r5 != r3) goto L_0x0259
            int r3 = r2.readInt()
            r0.blockCRC = r3
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK_PARAMS
            r0.currentState = r3
        L_0x009f:
            r3 = 25
            boolean r3 = r2.hasReadableBits(r3)
            if (r3 != 0) goto L_0x00a8
            return
        L_0x00a8:
            boolean r6 = r2.readBoolean()
            int r7 = r2.readBits(r4)
            io.netty.handler.codec.compression.Bzip2BlockDecompressor r13 = new io.netty.handler.codec.compression.Bzip2BlockDecompressor
            int r4 = r0.blockSize
            int r5 = r0.blockCRC
            r3 = r13
            r8 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            r0.blockDecompressor = r13
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_MAP
            r0.currentState = r3
        L_0x00c1:
            boolean r3 = r2.hasReadableBits(r10)
            if (r3 != 0) goto L_0x00c8
            return
        L_0x00c8:
            io.netty.handler.codec.compression.Bzip2BlockDecompressor r3 = r0.blockDecompressor
            int r4 = r2.readBits(r10)
            r3.huffmanInUse16 = r4
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_BITMAPS
            r0.currentState = r3
        L_0x00d4:
            io.netty.handler.codec.compression.Bzip2BlockDecompressor r3 = r0.blockDecompressor
            int r4 = r3.huffmanInUse16
            int r5 = java.lang.Integer.bitCount(r4)
            byte[] r6 = r3.huffmanSymbolMap
            int r7 = r5 * 16
            r8 = 3
            int r7 = r7 + r8
            boolean r7 = r2.hasReadableBits(r7)
            if (r7 != 0) goto L_0x00e9
            return
        L_0x00e9:
            if (r5 <= 0) goto L_0x0113
            r5 = r11
            r7 = r5
        L_0x00ed:
            if (r5 >= r10) goto L_0x0114
            r13 = 32768(0x8000, float:4.5918E-41)
            int r13 = r13 >>> r5
            r13 = r13 & r4
            if (r13 == 0) goto L_0x010e
            int r13 = r5 << 4
            r14 = r11
        L_0x00f9:
            if (r14 >= r10) goto L_0x010e
            boolean r15 = r2.readBoolean()
            if (r15 == 0) goto L_0x0107
            int r15 = r7 + 1
            byte r10 = (byte) r13
            r6[r7] = r10
            r7 = r15
        L_0x0107:
            int r14 = r14 + 1
            int r13 = r13 + 1
            r10 = 16
            goto L_0x00f9
        L_0x010e:
            int r5 = r5 + 1
            r10 = 16
            goto L_0x00ed
        L_0x0113:
            r7 = r11
        L_0x0114:
            int r4 = r7 + 1
            r3.huffmanEndOfBlockSymbol = r4
            int r3 = r2.readBits(r8)
            r4 = 2
            if (r3 < r4) goto L_0x0251
            if (r3 > r9) goto L_0x0251
            int r7 = r7 + r4
            r4 = 258(0x102, float:3.62E-43)
            if (r7 > r4) goto L_0x0249
            io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder r4 = new io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder
            r4.<init>(r2, r3, r7)
            r0.huffmanStageDecoder = r4
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS_NUMBER
            r0.currentState = r3
        L_0x0131:
            r3 = 15
            boolean r4 = r2.hasReadableBits(r3)
            if (r4 != 0) goto L_0x013a
            return
        L_0x013a:
            int r3 = r2.readBits(r3)
            if (r3 < r12) goto L_0x0241
            r4 = 18002(0x4652, float:2.5226E-41)
            if (r3 > r4) goto L_0x0241
            io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder r4 = r0.huffmanStageDecoder
            byte[] r3 = new byte[r3]
            r4.selectors = r3
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS
            r0.currentState = r3
        L_0x014e:
            io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder r3 = r0.huffmanStageDecoder
            byte[] r4 = r3.selectors
            int r5 = r4.length
            io.netty.handler.codec.compression.Bzip2MoveToFrontTable r6 = r3.tableMTF
            int r7 = r3.currentSelector
        L_0x0157:
            if (r7 >= r5) goto L_0x0175
            boolean r8 = r2.hasReadableBits(r9)
            if (r8 != 0) goto L_0x0162
            r3.currentSelector = r7
            return
        L_0x0162:
            r8 = r11
        L_0x0163:
            boolean r10 = r2.readBoolean()
            if (r10 == 0) goto L_0x016c
            int r8 = r8 + 1
            goto L_0x0163
        L_0x016c:
            byte r8 = r6.indexToFront(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0157
        L_0x0175:
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_LENGTH
            r0.currentState = r3
        L_0x0179:
            io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder r3 = r0.huffmanStageDecoder
            int r4 = r3.totalTables
            byte[][] r5 = r3.tableCodeLengths
            int r6 = r3.alphabetSize
            int r7 = r3.currentLength
            boolean r8 = r3.modifyLength
            int r9 = r3.currentGroup
        L_0x0187:
            if (r9 >= r4) goto L_0x01da
            r10 = 5
            boolean r13 = r2.hasReadableBits(r10)
            if (r13 != 0) goto L_0x0193
            r10 = r11
        L_0x0191:
            r11 = r12
            goto L_0x01db
        L_0x0193:
            if (r7 >= 0) goto L_0x0199
            int r7 = r2.readBits(r10)
        L_0x0199:
            int r10 = r3.currentAlpha
        L_0x019b:
            r13 = -1
            if (r10 >= r6) goto L_0x01d3
            boolean r14 = r2.isReadable()
            if (r14 != 0) goto L_0x01a5
            goto L_0x0191
        L_0x01a5:
            if (r8 != 0) goto L_0x01b6
            boolean r14 = r2.readBoolean()
            if (r14 == 0) goto L_0x01ae
            goto L_0x01b6
        L_0x01ae:
            r13 = r5[r9]
            byte r14 = (byte) r7
            r13[r10] = r14
            int r10 = r10 + 1
            goto L_0x019b
        L_0x01b6:
            boolean r8 = r2.isReadable()
            if (r8 != 0) goto L_0x01bf
            r8 = r12
            r11 = r8
            goto L_0x01db
        L_0x01bf:
            boolean r8 = r2.readBoolean()
            if (r8 == 0) goto L_0x01c7
            r8 = r13
            goto L_0x01c8
        L_0x01c7:
            r8 = r12
        L_0x01c8:
            int r7 = r7 + r8
            boolean r8 = r2.isReadable()
            if (r8 != 0) goto L_0x01d1
            r8 = r11
            goto L_0x0191
        L_0x01d1:
            r8 = r11
            goto L_0x01a5
        L_0x01d3:
            r3.currentAlpha = r11
            int r9 = r9 + 1
            r8 = r11
            r7 = r13
            goto L_0x0187
        L_0x01da:
            r10 = r11
        L_0x01db:
            if (r11 == 0) goto L_0x01e6
            r3.currentGroup = r9
            r3.currentLength = r7
            r3.currentAlpha = r10
            r3.modifyLength = r8
            return
        L_0x01e6:
            r3.createHuffmanDecodingTables()
            io.netty.handler.codec.compression.Bzip2Decoder$State r3 = io.netty.handler.codec.compression.Bzip2Decoder.State.DECODE_HUFFMAN_DATA
            r0.currentState = r3
        L_0x01ed:
            io.netty.handler.codec.compression.Bzip2BlockDecompressor r3 = r0.blockDecompressor
            int r4 = r18.readerIndex()
            io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder r5 = r0.huffmanStageDecoder
            boolean r5 = r3.decodeHuffmanData(r5)
            if (r5 != 0) goto L_0x01fc
            return
        L_0x01fc:
            int r5 = r18.readerIndex()
            if (r5 != r4) goto L_0x020b
            boolean r1 = r18.isReadable()
            if (r1 == 0) goto L_0x020b
            r2.refill()
        L_0x020b:
            int r1 = r3.blockLength()
            io.netty.buffer.ByteBufAllocator r2 = r17.alloc()
            io.netty.buffer.ByteBuf r1 = r2.buffer(r1)
        L_0x0217:
            int r2 = r3.read()     // Catch:{ all -> 0x0221 }
            if (r2 < 0) goto L_0x0223
            r1.writeByte(r2)     // Catch:{ all -> 0x0221 }
            goto L_0x0217
        L_0x0221:
            r0 = move-exception
            goto L_0x023b
        L_0x0223:
            io.netty.handler.codec.compression.Bzip2Decoder$State r2 = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK     // Catch:{ all -> 0x0221 }
            r0.currentState = r2     // Catch:{ all -> 0x0221 }
            int r2 = r3.checkCRC()     // Catch:{ all -> 0x0221 }
            int r3 = r0.streamCRC     // Catch:{ all -> 0x0221 }
            int r4 = r3 << 1
            int r3 = r3 >>> 31
            r3 = r3 | r4
            r2 = r2 ^ r3
            r0.streamCRC = r2     // Catch:{ all -> 0x0221 }
            r0 = r19
            r0.add(r1)     // Catch:{ all -> 0x0221 }
            return
        L_0x023b:
            if (r1 == 0) goto L_0x0240
            r1.release()
        L_0x0240:
            throw r0
        L_0x0241:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r1 = "incorrect selectors number"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0249:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r1 = "incorrect alphabet size"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0251:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r1 = "incorrect huffman groups number"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0259:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r1 = "bad block header"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0261:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r1 = "block size is invalid"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0269:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r1 = "Unexpected stream identifier contents. Mismatched bzip2 protocol version?"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2Decoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public boolean isClosed() {
        return this.currentState == State.EOF;
    }
}
