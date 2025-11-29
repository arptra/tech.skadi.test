package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        return xflow(r12, r4, r5, r13, r7, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c7, code lost:
        return xflow(r12, r4, r5, r13, r7, 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012c, code lost:
        return xflow(r12, r4, r5, r13, r7, 4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.nio.charset.CoderResult decodeArrayLoop(java.nio.ByteBuffer r12, java.nio.CharBuffer r13) {
        /*
            r11 = this;
            byte[] r11 = r12.array()
            int r0 = r12.arrayOffset()
            int r1 = r12.position()
            int r0 = r0 + r1
            int r1 = r12.arrayOffset()
            int r2 = r12.limit()
            int r5 = r1 + r2
            char[] r1 = r13.array()
            int r2 = r13.arrayOffset()
            int r3 = r13.position()
            int r2 = r2 + r3
            int r3 = r13.arrayOffset()
            int r4 = r13.limit()
            int r3 = r3 + r4
            int r4 = r5 - r0
            int r6 = r3 - r2
            int r4 = java.lang.Math.min(r4, r6)
            int r4 = r4 + r2
        L_0x0036:
            if (r2 >= r4) goto L_0x0045
            byte r6 = r11[r0]
            if (r6 < 0) goto L_0x0045
            int r7 = r2 + 1
            int r0 = r0 + 1
            char r6 = (char) r6
            r1[r2] = r6
            r2 = r7
            goto L_0x0036
        L_0x0045:
            r4 = r0
        L_0x0046:
            r7 = r2
        L_0x0047:
            if (r4 >= r5) goto L_0x0133
            byte r0 = r11[r4]
            if (r0 < 0) goto L_0x005f
            if (r7 < r3) goto L_0x0057
            r8 = 1
            r3 = r12
            r6 = r13
            java.nio.charset.CoderResult r11 = xflow(r3, r4, r5, r6, r7, r8)
            return r11
        L_0x0057:
            int r2 = r7 + 1
            char r0 = (char) r0
            r1[r7] = r0
            int r4 = r4 + 1
            goto L_0x0046
        L_0x005f:
            int r2 = r0 >> 5
            r6 = -2
            r8 = 2
            if (r2 != r6) goto L_0x0091
            int r2 = r5 - r4
            if (r2 < r8) goto L_0x0089
            if (r7 < r3) goto L_0x006c
            goto L_0x0089
        L_0x006c:
            int r2 = r4 + 1
            byte r2 = r11[r2]
            boolean r6 = isMalformed2(r0, r2)
            if (r6 == 0) goto L_0x007b
            java.nio.charset.CoderResult r11 = malformed(r12, r4, r13, r7, r8)
            return r11
        L_0x007b:
            int r6 = r7 + 1
            int r0 = r0 << 6
            r0 = r0 ^ r2
            r0 = r0 ^ 3968(0xf80, float:5.56E-42)
            char r0 = (char) r0
            r1[r7] = r0
            int r4 = r4 + 2
        L_0x0087:
            r7 = r6
            goto L_0x0047
        L_0x0089:
            r8 = 2
            r3 = r12
            r6 = r13
            java.nio.charset.CoderResult r11 = xflow(r3, r4, r5, r6, r7, r8)
            return r11
        L_0x0091:
            int r2 = r0 >> 4
            if (r2 != r6) goto L_0x00c8
            int r2 = r5 - r4
            r6 = 3
            if (r2 < r6) goto L_0x00c0
            if (r7 < r3) goto L_0x009d
            goto L_0x00c0
        L_0x009d:
            int r2 = r4 + 1
            byte r2 = r11[r2]
            int r8 = r4 + 2
            byte r8 = r11[r8]
            boolean r9 = isMalformed3(r0, r2, r8)
            if (r9 == 0) goto L_0x00b0
            java.nio.charset.CoderResult r11 = malformed(r12, r4, r13, r7, r6)
            return r11
        L_0x00b0:
            int r6 = r7 + 1
            int r0 = r0 << 12
            int r2 = r2 << 6
            r0 = r0 ^ r2
            r0 = r0 ^ r8
            r0 = r0 ^ 8064(0x1f80, float:1.13E-41)
            char r0 = (char) r0
            r1[r7] = r0
            int r4 = r4 + 3
            goto L_0x0087
        L_0x00c0:
            r8 = 3
            r3 = r12
            r6 = r13
            java.nio.charset.CoderResult r11 = xflow(r3, r4, r5, r6, r7, r8)
            return r11
        L_0x00c8:
            int r2 = r0 >> 3
            if (r2 != r6) goto L_0x012d
            int r2 = r5 - r4
            r6 = 4
            if (r2 < r6) goto L_0x0125
            int r2 = r3 - r7
            if (r2 >= r8) goto L_0x00d6
            goto L_0x0125
        L_0x00d6:
            int r2 = r4 + 1
            byte r2 = r11[r2]
            int r8 = r4 + 2
            byte r8 = r11[r8]
            int r9 = r4 + 3
            byte r9 = r11[r9]
            r0 = r0 & 7
            int r0 = r0 << 18
            r10 = r2 & 63
            int r10 = r10 << 12
            r0 = r0 | r10
            r10 = r8 & 63
            int r10 = r10 << 6
            r0 = r0 | r10
            r10 = r9 & 63
            r0 = r0 | r10
            boolean r2 = isMalformed4(r2, r8, r9)
            if (r2 != 0) goto L_0x0120
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r0 < r2) goto L_0x0120
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r0 <= r8) goto L_0x0103
            goto L_0x0120
        L_0x0103:
            int r6 = r7 + 1
            int r0 = r0 - r2
            int r2 = r0 >> 10
            r2 = r2 & 1023(0x3ff, float:1.434E-42)
            r8 = 55296(0xd800, float:7.7486E-41)
            r2 = r2 | r8
            char r2 = (char) r2
            r1[r7] = r2
            int r7 = r7 + 2
            r2 = 56320(0xdc00, float:7.8921E-41)
            r0 = r0 & 1023(0x3ff, float:1.434E-42)
            r0 = r0 | r2
            char r0 = (char) r0
            r1[r6] = r0
            int r4 = r4 + 4
            goto L_0x0047
        L_0x0120:
            java.nio.charset.CoderResult r11 = malformed(r12, r4, r13, r7, r6)
            return r11
        L_0x0125:
            r8 = 4
            r3 = r12
            r6 = r13
            java.nio.charset.CoderResult r11 = xflow(r3, r4, r5, r6, r7, r8)
            return r11
        L_0x012d:
            r11 = 1
            java.nio.charset.CoderResult r11 = malformed(r12, r4, r13, r7, r11)
            return r11
        L_0x0133:
            r8 = 0
            r3 = r12
            r6 = r13
            java.nio.charset.CoderResult r11 = xflow(r3, r4, r5, r6, r7, r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.UTF8Decoder.decodeArrayLoop(java.nio.ByteBuffer, java.nio.CharBuffer):java.nio.charset.CoderResult");
    }

    private static boolean isMalformed2(int i, int i2) {
        return (i & 30) == 0 || (i2 & 192) != 128;
    }

    private static boolean isMalformed3(int i, int i2, int i3) {
        return ((i != -32 || (i2 & 224) != 128) && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i, int i2, int i3) {
        return ((i & 192) == 128 && (i2 & 192) == 128 && (i3 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i) {
        return (i & 192) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i) {
        for (int i2 = 1; i2 < i; i2++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i2);
            }
        }
        return CoderResult.malformedForLength(i);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i3);
        byteBuffer.position(i);
        charBuffer.position(i2);
        return malformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i) {
        int i2 = 1;
        if (i == 1) {
            byte b = byteBuffer.get();
            return (b >> 2) == -2 ? byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5) : (b >> 1) == -2 ? byteBuffer.remaining() < 5 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 6) : CoderResult.malformedForLength(1);
        } else if (i == 2) {
            return CoderResult.malformedForLength(1);
        } else {
            if (i == 3) {
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                if (!(b2 == -32 && (b3 & 224) == 128) && !isNotContinuation(b3)) {
                    i2 = 2;
                }
                return CoderResult.malformedForLength(i2);
            } else if (i == 4) {
                byte b4 = byteBuffer.get() & 255;
                byte b5 = byteBuffer.get();
                byte b6 = b5 & 255;
                return (b4 > 244 || (b4 == 240 && (b6 < 144 || b6 > 191)) || ((b4 == 244 && (b5 & 240) != 128) || isNotContinuation(b6))) ? CoderResult.malformedForLength(1) : isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private static CoderResult xflow(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        buffer.position(i);
        buffer2.position(i3);
        return (i4 == 0 || i2 - i < i4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
