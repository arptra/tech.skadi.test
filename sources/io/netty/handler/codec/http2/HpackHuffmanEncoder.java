package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

final class HpackHuffmanEncoder {
    /* access modifiers changed from: private */
    public final int[] codes;
    private final EncodeProcessor encodeProcessor;
    private final EncodedLengthProcessor encodedLengthProcessor;
    /* access modifiers changed from: private */
    public final byte[] lengths;

    public final class EncodeProcessor implements ByteProcessor {
        private long current;
        private int n;
        ByteBuf out;

        private EncodeProcessor() {
        }

        public void end() {
            try {
                int i = this.n;
                if (i > 0) {
                    long j = (this.current << (8 - i)) | ((long) (255 >>> i));
                    this.current = j;
                    this.out.writeByte((int) j);
                }
            } finally {
                this.out = null;
                this.current = 0;
                this.n = 0;
            }
        }

        public boolean process(byte b) {
            byte b2 = b & 255;
            byte b3 = HpackHuffmanEncoder.this.lengths[b2];
            long j = this.current << b3;
            this.current = j;
            this.current = j | ((long) HpackHuffmanEncoder.this.codes[b2]);
            this.n += b3;
            while (true) {
                int i = this.n;
                if (i < 8) {
                    return true;
                }
                int i2 = i - 8;
                this.n = i2;
                this.out.writeByte((int) (this.current >> i2));
            }
        }
    }

    public final class EncodedLengthProcessor implements ByteProcessor {
        private long len;

        private EncodedLengthProcessor() {
        }

        public int length() {
            return (int) ((this.len + 7) >> 3);
        }

        public boolean process(byte b) {
            this.len += (long) HpackHuffmanEncoder.this.lengths[b & 255];
            return true;
        }

        public void reset() {
            this.len = 0;
        }
    }

    public HpackHuffmanEncoder() {
        this(HpackUtil.HUFFMAN_CODES, HpackUtil.HUFFMAN_CODE_LENGTHS);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void encodeSlowPath(io.netty.buffer.ByteBuf r8, java.lang.CharSequence r9) {
        /*
            r7 = this;
            r0 = 0
            r2 = 0
            r3 = r2
        L_0x0004:
            int r4 = r9.length()
            r5 = 255(0xff, float:3.57E-43)
            if (r2 >= r4) goto L_0x002d
            char r4 = r9.charAt(r2)
            r4 = r4 & r5
            int[] r5 = r7.codes
            r5 = r5[r4]
            byte[] r6 = r7.lengths
            byte r4 = r6[r4]
            long r0 = r0 << r4
            long r5 = (long) r5
            long r0 = r0 | r5
            int r3 = r3 + r4
        L_0x001d:
            r4 = 8
            if (r3 < r4) goto L_0x002a
            int r3 = r3 + -8
            long r4 = r0 >> r3
            int r4 = (int) r4
            r8.writeByte(r4)
            goto L_0x001d
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x002d:
            if (r3 <= 0) goto L_0x003a
            int r7 = 8 - r3
            long r0 = r0 << r7
            int r7 = r5 >>> r3
            long r2 = (long) r7
            long r0 = r0 | r2
            int r7 = (int) r0
            r8.writeByte(r7)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HpackHuffmanEncoder.encodeSlowPath(io.netty.buffer.ByteBuf, java.lang.CharSequence):void");
    }

    private int getEncodedLengthSlowPath(CharSequence charSequence) {
        long j = 0;
        for (int i = 0; i < charSequence.length(); i++) {
            j += (long) this.lengths[charSequence.charAt(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    public void encode(ByteBuf byteBuf, CharSequence charSequence) {
        ObjectUtil.checkNotNull(byteBuf, "out");
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            try {
                EncodeProcessor encodeProcessor2 = this.encodeProcessor;
                encodeProcessor2.out = byteBuf;
                asciiString.forEachByte(encodeProcessor2);
            } catch (Exception e) {
                PlatformDependent.throwException(e);
            } catch (Throwable th) {
                this.encodeProcessor.end();
                throw th;
            }
            this.encodeProcessor.end();
            return;
        }
        encodeSlowPath(byteBuf, charSequence);
    }

    public int getEncodedLength(CharSequence charSequence) {
        if (!(charSequence instanceof AsciiString)) {
            return getEncodedLengthSlowPath(charSequence);
        }
        AsciiString asciiString = (AsciiString) charSequence;
        try {
            this.encodedLengthProcessor.reset();
            asciiString.forEachByte(this.encodedLengthProcessor);
            return this.encodedLengthProcessor.length();
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    private HpackHuffmanEncoder(int[] iArr, byte[] bArr) {
        this.encodedLengthProcessor = new EncodedLengthProcessor();
        this.encodeProcessor = new EncodeProcessor();
        this.codes = iArr;
        this.lengths = bArr;
    }
}
