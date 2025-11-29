package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

final class FastLz {
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int CHECKSUM_OFFSET = 4;
    private static final int HASH_LOG = 13;
    private static final int HASH_MASK = 8191;
    private static final int HASH_SIZE = 8192;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final int LEVEL_AUTO = 0;
    static final int MAGIC_NUMBER = 4607066;
    static final int MAX_CHUNK_LENGTH = 65535;
    private static final int MAX_COPY = 32;
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int MAX_LEN = 264;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int OPTIONS_OFFSET = 3;

    private FastLz() {
    }

    public static int calculateOutputBufferLength(int i) {
        return Math.max((int) (((double) i) * 1.06d), 66);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0204  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int compress(io.netty.buffer.ByteBuf r26, int r27, int r28, io.netty.buffer.ByteBuf r29, int r30, int r31) {
        /*
            r0 = r26
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = 2
            r5 = 1
            if (r31 != 0) goto L_0x0014
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r1 >= r6) goto L_0x0012
            r6 = r5
            goto L_0x0016
        L_0x0012:
            r6 = r4
            goto L_0x0016
        L_0x0014:
            r6 = r31
        L_0x0016:
            int r7 = r1 + -2
            int r8 = r1 + -12
            r9 = 8192(0x2000, float:1.14794E-41)
            int[] r10 = new int[r9]
            r11 = 4
            r12 = 0
            if (r1 >= r11) goto L_0x0044
            if (r1 == 0) goto L_0x0043
            int r4 = r1 + -1
            byte r4 = (byte) r4
            r2.setByte(r3, r4)
            int r4 = r1 + -1
            r6 = r5
        L_0x002d:
            if (r12 > r4) goto L_0x0040
            int r7 = r6 + 1
            int r6 = r6 + r3
            int r8 = r12 + 1
            int r9 = r27 + r12
            byte r9 = r0.getByte(r9)
            r2.setByte(r6, r9)
            r6 = r7
            r12 = r8
            goto L_0x002d
        L_0x0040:
            int r0 = r1 + 1
            return r0
        L_0x0043:
            return r12
        L_0x0044:
            r11 = r12
        L_0x0045:
            if (r11 >= r9) goto L_0x004c
            r10[r11] = r12
            int r11 = r11 + 1
            goto L_0x0045
        L_0x004c:
            r9 = 31
            r2.setByte(r3, r9)
            int r11 = r3 + 1
            byte r13 = r26.getByte(r27)
            r2.setByte(r11, r13)
            int r11 = r3 + 2
            int r13 = r27 + 1
            byte r13 = r0.getByte(r13)
            r2.setByte(r11, r13)
            r13 = r4
            r15 = r13
            r14 = 3
        L_0x0068:
            if (r13 >= r8) goto L_0x036e
            r16 = 1
            r18 = 0
            if (r6 != r4) goto L_0x0092
            int r12 = r27 + r13
            byte r9 = r0.getByte(r12)
            int r11 = r12 + -1
            byte r4 = r0.getByte(r11)
            if (r9 != r4) goto L_0x0092
            int r4 = readU16(r0, r11)
            int r12 = r12 + 1
            int r9 = readU16(r0, r12)
            if (r4 != r9) goto L_0x0092
            int r4 = r13 + 3
            int r9 = r13 + 2
            r11 = r5
            r20 = r16
            goto L_0x0097
        L_0x0092:
            r4 = r13
            r20 = r18
            r9 = 0
            r11 = 0
        L_0x0097:
            r22 = 8191(0x1fff, double:4.047E-320)
            if (r11 != 0) goto L_0x0183
            int r9 = r27 + r4
            int r11 = hashFunction(r0, r9)
            r12 = r10[r11]
            int r5 = r13 - r12
            r24 = r7
            r25 = r8
            long r7 = (long) r5
            r10[r11] = r13
            int r5 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r5 == 0) goto L_0x0165
            r5 = 1
            if (r6 != r5) goto L_0x00b9
            int r5 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r5 < 0) goto L_0x00c0
            goto L_0x0165
        L_0x00b9:
            r20 = 73725(0x11ffd, double:3.6425E-319)
            int r5 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r5 >= 0) goto L_0x0165
        L_0x00c0:
            int r5 = r12 + 1
            int r11 = r27 + r12
            byte r11 = r0.getByte(r11)
            int r20 = r4 + 1
            byte r9 = r0.getByte(r9)
            if (r11 != r9) goto L_0x0165
            int r9 = r12 + 2
            int r5 = r27 + r5
            byte r5 = r0.getByte(r5)
            int r11 = r4 + 2
            int r1 = r27 + r20
            byte r1 = r0.getByte(r1)
            if (r5 != r1) goto L_0x0165
            int r1 = r12 + 3
            int r5 = r27 + r9
            byte r5 = r0.getByte(r5)
            int r9 = r4 + 3
            int r11 = r27 + r11
            byte r11 = r0.getByte(r11)
            if (r5 == r11) goto L_0x00f6
            goto L_0x0165
        L_0x00f6:
            r5 = 2
            if (r6 != r5) goto L_0x0160
            int r5 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r5 < 0) goto L_0x0160
            int r4 = r4 + 4
            int r5 = r27 + r9
            byte r5 = r0.getByte(r5)
            int r9 = r12 + 4
            int r1 = r27 + r1
            byte r1 = r0.getByte(r1)
            if (r5 != r1) goto L_0x0126
            int r1 = r27 + r4
            byte r1 = r0.getByte(r1)
            int r4 = r12 + 5
            int r5 = r27 + r9
            byte r5 = r0.getByte(r5)
            if (r1 == r5) goto L_0x0120
            goto L_0x0126
        L_0x0120:
            r1 = 5
            r9 = r4
            r20 = r7
            goto L_0x0188
        L_0x0126:
            int r1 = r14 + 1
            int r4 = r3 + r14
            int r5 = r13 + 1
            int r7 = r27 + r13
            byte r7 = r0.getByte(r7)
            r2.setByte(r4, r7)
            int r15 = r15 + 1
            r4 = 32
            if (r15 != r4) goto L_0x0151
            int r14 = r14 + 2
            int r1 = r1 + r3
            r4 = 31
            r2.setByte(r1, r4)
        L_0x0143:
            r1 = r28
            r9 = r4
            r13 = r5
            r7 = r24
            r8 = r25
            r4 = 2
            r5 = 1
            r12 = 0
            r15 = 0
            goto L_0x0068
        L_0x0151:
            r14 = r1
            r13 = r5
            r7 = r24
            r8 = r25
            r4 = 2
            r5 = 1
            r9 = 31
            r12 = 0
        L_0x015c:
            r1 = r28
            goto L_0x0068
        L_0x0160:
            r9 = r1
            r20 = r7
        L_0x0163:
            r1 = 3
            goto L_0x0188
        L_0x0165:
            int r1 = r14 + 1
            int r4 = r3 + r14
            int r5 = r13 + 1
            int r7 = r27 + r13
            byte r7 = r0.getByte(r7)
            r2.setByte(r4, r7)
            int r15 = r15 + 1
            r4 = 32
            if (r15 != r4) goto L_0x0151
            int r14 = r14 + 2
            int r1 = r1 + r3
            r4 = 31
            r2.setByte(r1, r4)
            goto L_0x0143
        L_0x0183:
            r24 = r7
            r25 = r8
            goto L_0x0163
        L_0x0188:
            int r1 = r1 + r13
            long r4 = r20 - r16
            int r7 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            r8 = 8
            if (r7 != 0) goto L_0x01ac
            int r7 = r27 + r1
            r11 = 1
            int r7 = r7 - r11
            byte r7 = r0.getByte(r7)
            r11 = r24
        L_0x019b:
            if (r1 >= r11) goto L_0x01ea
            int r12 = r9 + 1
            int r9 = r27 + r9
            byte r9 = r0.getByte(r9)
            if (r9 == r7) goto L_0x01a8
            goto L_0x01ea
        L_0x01a8:
            int r1 = r1 + 1
            r9 = r12
            goto L_0x019b
        L_0x01ac:
            r11 = r24
            r7 = 0
        L_0x01af:
            if (r7 >= r8) goto L_0x01ce
            int r12 = r9 + 1
            int r9 = r27 + r9
            byte r9 = r0.getByte(r9)
            int r16 = r1 + 1
            int r1 = r27 + r1
            byte r1 = r0.getByte(r1)
            if (r9 == r1) goto L_0x01c8
            r9 = r12
            r1 = r16
            r7 = 1
            goto L_0x01cf
        L_0x01c8:
            int r7 = r7 + 1
            r9 = r12
            r1 = r16
            goto L_0x01af
        L_0x01ce:
            r7 = 0
        L_0x01cf:
            if (r7 != 0) goto L_0x01ea
        L_0x01d1:
            if (r1 >= r11) goto L_0x01ea
            int r7 = r9 + 1
            int r9 = r27 + r9
            byte r9 = r0.getByte(r9)
            int r12 = r1 + 1
            int r1 = r27 + r1
            byte r1 = r0.getByte(r1)
            if (r9 == r1) goto L_0x01e7
            r1 = r12
            goto L_0x01ea
        L_0x01e7:
            r9 = r7
            r1 = r12
            goto L_0x01d1
        L_0x01ea:
            if (r15 == 0) goto L_0x01f8
            int r7 = r3 + r14
            int r7 = r7 - r15
            r9 = 1
            int r7 = r7 - r9
            int r15 = r15 + -1
            byte r9 = (byte) r15
            r2.setByte(r7, r9)
            goto L_0x01fa
        L_0x01f8:
            int r14 = r14 + -1
        L_0x01fa:
            int r7 = r1 + -3
            int r9 = r7 - r13
            r15 = 7
            r16 = 255(0xff, double:1.26E-321)
            r12 = 2
            if (r6 != r12) goto L_0x02ce
            int r12 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            r13 = -1
            if (r12 >= 0) goto L_0x025f
            if (r9 >= r15) goto L_0x022a
            int r12 = r14 + 1
            int r13 = r3 + r14
            int r9 = r9 << 5
            r22 = r10
            long r9 = (long) r9
            long r18 = r4 >>> r8
            long r9 = r9 + r18
            int r8 = (int) r9
            byte r8 = (byte) r8
            r2.setByte(r13, r8)
            int r14 = r14 + 2
            int r8 = r3 + r12
            long r4 = r4 & r16
            int r4 = (int) r4
            byte r4 = (byte) r4
            r2.setByte(r8, r4)
            goto L_0x0344
        L_0x022a:
            r22 = r10
            int r10 = r14 + 1
            int r12 = r3 + r14
            long r14 = r4 >>> r8
            r18 = 224(0xe0, double:1.107E-321)
            long r14 = r14 + r18
            int r8 = (int) r14
            byte r8 = (byte) r8
            r2.setByte(r12, r8)
            int r9 = r9 + -7
        L_0x023d:
            r8 = 255(0xff, float:3.57E-43)
            if (r9 < r8) goto L_0x024b
            int r8 = r10 + 1
            int r10 = r10 + r3
            r2.setByte(r10, r13)
            int r9 = r9 + -255
            r10 = r8
            goto L_0x023d
        L_0x024b:
            int r8 = r10 + 1
            int r12 = r3 + r10
            byte r9 = (byte) r9
            r2.setByte(r12, r9)
            int r14 = r10 + 2
            int r8 = r8 + r3
            long r4 = r4 & r16
            int r4 = (int) r4
            byte r4 = (byte) r4
            r2.setByte(r8, r4)
            goto L_0x0344
        L_0x025f:
            r22 = r10
            r4 = 8192(0x2000, double:4.0474E-320)
            if (r9 >= r15) goto L_0x0290
            long r20 = r20 - r4
            int r4 = r14 + 1
            int r5 = r3 + r14
            int r9 = r9 << 5
            r10 = 31
            int r9 = r9 + r10
            byte r9 = (byte) r9
            r2.setByte(r5, r9)
            int r5 = r14 + 2
            int r4 = r4 + r3
            r2.setByte(r4, r13)
            int r4 = r14 + 3
            int r5 = r5 + r3
            long r8 = r20 >>> r8
            int r8 = (int) r8
            byte r8 = (byte) r8
            r2.setByte(r5, r8)
            int r14 = r14 + 4
            int r4 = r4 + r3
            long r8 = r20 & r16
            int r5 = (int) r8
            byte r5 = (byte) r5
            r2.setByte(r4, r5)
            goto L_0x0344
        L_0x0290:
            long r20 = r20 - r4
            int r4 = r14 + 1
            int r5 = r3 + r14
            r2.setByte(r5, r13)
            int r9 = r9 + -7
            r5 = 255(0xff, float:3.57E-43)
        L_0x029d:
            if (r9 < r5) goto L_0x02a9
            int r10 = r4 + 1
            int r4 = r4 + r3
            r2.setByte(r4, r13)
            int r9 = r9 + -255
            r4 = r10
            goto L_0x029d
        L_0x02a9:
            int r5 = r4 + 1
            int r10 = r3 + r4
            byte r9 = (byte) r9
            r2.setByte(r10, r9)
            int r9 = r4 + 2
            int r5 = r5 + r3
            r2.setByte(r5, r13)
            int r5 = r4 + 3
            int r9 = r9 + r3
            long r12 = r20 >>> r8
            int r8 = (int) r12
            byte r8 = (byte) r8
            r2.setByte(r9, r8)
            int r14 = r4 + 4
            int r4 = r3 + r5
            long r8 = r20 & r16
            int r5 = (int) r8
            byte r5 = (byte) r5
            r2.setByte(r4, r5)
            goto L_0x0344
        L_0x02ce:
            r22 = r10
            r10 = 262(0x106, float:3.67E-43)
            if (r9 <= r10) goto L_0x0300
        L_0x02d4:
            r10 = 262(0x106, float:3.67E-43)
            if (r9 <= r10) goto L_0x0300
            int r10 = r14 + 1
            int r12 = r3 + r14
            long r20 = r4 >>> r8
            r13 = r9
            r18 = 224(0xe0, double:1.107E-321)
            long r8 = r20 + r18
            int r8 = (int) r8
            byte r8 = (byte) r8
            r2.setByte(r12, r8)
            int r8 = r14 + 2
            int r9 = r3 + r10
            r10 = -3
            r2.setByte(r9, r10)
            int r14 = r14 + 3
            int r8 = r8 + r3
            long r9 = r4 & r16
            int r9 = (int) r9
            byte r9 = (byte) r9
            r2.setByte(r8, r9)
            r9 = r13
            int r9 = r9 + -262
            r8 = 8
            goto L_0x02d4
        L_0x0300:
            if (r9 >= r15) goto L_0x031f
            int r8 = r14 + 1
            int r10 = r3 + r14
            int r9 = r9 << 5
            long r12 = (long) r9
            r9 = 8
            long r18 = r4 >>> r9
            long r12 = r12 + r18
            int r9 = (int) r12
            byte r9 = (byte) r9
            r2.setByte(r10, r9)
            int r14 = r14 + 2
            int r8 = r8 + r3
            long r4 = r4 & r16
            int r4 = (int) r4
            byte r4 = (byte) r4
            r2.setByte(r8, r4)
            goto L_0x0344
        L_0x031f:
            int r8 = r14 + 1
            int r10 = r3 + r14
            r12 = 8
            long r12 = r4 >>> r12
            r18 = 224(0xe0, double:1.107E-321)
            long r12 = r12 + r18
            int r12 = (int) r12
            byte r12 = (byte) r12
            r2.setByte(r10, r12)
            int r10 = r14 + 2
            int r8 = r8 + r3
            int r9 = r9 + -7
            byte r9 = (byte) r9
            r2.setByte(r8, r9)
            int r14 = r14 + 3
            int r8 = r3 + r10
            long r4 = r4 & r16
            int r4 = (int) r4
            byte r4 = (byte) r4
            r2.setByte(r8, r4)
        L_0x0344:
            int r4 = r27 + r7
            int r4 = hashFunction(r0, r4)
            int r5 = r1 + -2
            r22[r4] = r7
            int r4 = r27 + r5
            int r4 = hashFunction(r0, r4)
            int r13 = r1 + -1
            r22[r4] = r5
            int r1 = r14 + 1
            int r4 = r3 + r14
            r5 = 31
            r2.setByte(r4, r5)
            r14 = r1
            r9 = r5
            r7 = r11
            r10 = r22
            r8 = r25
            r4 = 2
            r5 = 1
            r12 = 0
            r15 = 0
            goto L_0x015c
        L_0x036e:
            r1 = r5
            int r4 = r28 + -1
        L_0x0371:
            if (r13 > r4) goto L_0x0396
            int r1 = r14 + 1
            int r5 = r3 + r14
            int r7 = r13 + 1
            int r8 = r27 + r13
            byte r8 = r0.getByte(r8)
            r2.setByte(r5, r8)
            int r15 = r15 + 1
            r5 = 32
            if (r15 != r5) goto L_0x0393
            int r14 = r14 + 2
            int r1 = r1 + r3
            r5 = 31
            r2.setByte(r1, r5)
            r13 = r7
            r15 = 0
            goto L_0x0371
        L_0x0393:
            r14 = r1
            r13 = r7
            goto L_0x0371
        L_0x0396:
            if (r15 == 0) goto L_0x03a4
            int r0 = r3 + r14
            int r0 = r0 - r15
            r1 = 1
            int r0 = r0 - r1
            int r15 = r15 - r1
            byte r1 = (byte) r15
            r2.setByte(r0, r1)
        L_0x03a2:
            r0 = 2
            goto L_0x03a7
        L_0x03a4:
            int r14 = r14 + -1
            goto L_0x03a2
        L_0x03a7:
            if (r6 != r0) goto L_0x03b3
            byte r0 = r29.getByte(r30)
            r1 = 32
            r0 = r0 | r1
            r2.setByte(r3, r0)
        L_0x03b3:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLz.compress(io.netty.buffer.ByteBuf, int, int, io.netty.buffer.ByteBuf, int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decompress(io.netty.buffer.ByteBuf r29, int r30, int r31, io.netty.buffer.ByteBuf r32, int r33, int r34) {
        /*
            r0 = r29
            r1 = r31
            r2 = r32
            r3 = r34
            byte r4 = r29.getByte(r30)
            r5 = 5
            int r4 = r4 >> r5
            r6 = 1
            int r4 = r4 + r6
            if (r4 == r6) goto L_0x0032
            r7 = 2
            if (r4 != r7) goto L_0x0016
            goto L_0x0032
        L_0x0016:
            io.netty.handler.codec.compression.DecompressionException r0 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r2 = "invalid level: %d (expected: %d or %d)"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0032:
            byte r7 = r29.getByte(r30)
            r7 = r7 & 31
            long r7 = (long) r7
            r11 = r6
            r12 = r11
            r10 = 0
        L_0x003c:
            long r13 = r7 >> r5
            r15 = 31
            long r15 = r15 & r7
            r17 = 8
            long r15 = r15 << r17
            r18 = 32
            int r18 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            r19 = 0
            r21 = 1
            if (r18 < 0) goto L_0x0163
            long r13 = r13 - r21
            long r5 = (long) r10
            r23 = r10
            long r9 = r5 - r15
            int r9 = (int) r9
            r24 = 6
            int r10 = (r13 > r24 ? 1 : (r13 == r24 ? 0 : -1))
            r24 = r12
            r12 = 255(0xff, float:3.57E-43)
            if (r10 != 0) goto L_0x0072
            r10 = 1
            if (r4 != r10) goto L_0x0076
            int r10 = r11 + 1
            int r11 = r30 + r11
            short r11 = r0.getUnsignedByte(r11)
            r25 = r10
            long r10 = (long) r11
            long r13 = r13 + r10
            r11 = r25
        L_0x0072:
            r25 = r7
        L_0x0074:
            r7 = 1
            goto L_0x008a
        L_0x0076:
            int r10 = r11 + 1
            int r11 = r30 + r11
            short r11 = r0.getUnsignedByte(r11)
            r25 = r7
            long r7 = (long) r11
            long r13 = r13 + r7
            if (r11 == r12) goto L_0x0086
            r11 = r10
            goto L_0x0074
        L_0x0086:
            r11 = r10
            r7 = r25
            goto L_0x0076
        L_0x008a:
            if (r4 != r7) goto L_0x0096
            int r7 = r11 + 1
            int r8 = r30 + r11
            short r8 = r0.getUnsignedByte(r8)
            int r9 = r9 - r8
            goto L_0x00c2
        L_0x0096:
            int r7 = r11 + 1
            int r8 = r30 + r11
            short r8 = r0.getUnsignedByte(r8)
            int r9 = r9 - r8
            if (r8 != r12) goto L_0x00c2
            r27 = 7936(0x1f00, double:3.921E-320)
            int r8 = (r15 > r27 ? 1 : (r15 == r27 ? 0 : -1))
            if (r8 != 0) goto L_0x00c2
            int r8 = r11 + 2
            int r7 = r30 + r7
            short r7 = r0.getUnsignedByte(r7)
            int r7 = r7 << 8
            long r9 = (long) r7
            int r7 = r11 + 3
            int r8 = r30 + r8
            short r8 = r0.getUnsignedByte(r8)
            long r11 = (long) r8
            long r9 = r9 + r11
            long r8 = r5 - r9
            r10 = 8191(0x1fff, double:4.047E-320)
            long r8 = r8 - r10
            int r9 = (int) r8
        L_0x00c2:
            long r5 = r5 + r13
            r10 = 3
            long r5 = r5 + r10
            long r10 = (long) r3
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x00cd
            r5 = 0
            return r5
        L_0x00cd:
            r5 = 0
            int r6 = r9 + -1
            if (r6 >= 0) goto L_0x00d3
            return r5
        L_0x00d3:
            if (r7 >= r1) goto L_0x00e6
            int r5 = r7 + 1
            int r6 = r30 + r7
            short r6 = r0.getUnsignedByte(r6)
            long r7 = (long) r6
            r25 = r7
            r12 = r24
            r7 = r5
            r5 = r23
            goto L_0x00e9
        L_0x00e6:
            r5 = r23
            r12 = 0
        L_0x00e9:
            if (r9 != r5) goto L_0x011d
            int r6 = r33 + r9
            r10 = 1
            int r6 = r6 - r10
            byte r6 = r2.getByte(r6)
            int r8 = r5 + 1
            int r9 = r33 + r5
            r2.setByte(r9, r6)
            int r9 = r5 + 2
            int r8 = r33 + r8
            r2.setByte(r8, r6)
            int r5 = r5 + 3
            int r8 = r33 + r9
            r2.setByte(r8, r6)
        L_0x0108:
            int r8 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x0117
            int r8 = r5 + 1
            int r5 = r33 + r5
            r2.setByte(r5, r6)
            long r13 = r13 - r21
            r5 = r8
            goto L_0x0108
        L_0x0117:
            r11 = r7
            r7 = r25
            r6 = 0
            goto L_0x01bc
        L_0x011d:
            r10 = 1
            int r6 = r9 + -1
            int r8 = r5 + 1
            int r11 = r33 + r5
            int r6 = r33 + r6
            byte r6 = r2.getByte(r6)
            r2.setByte(r11, r6)
            int r6 = r5 + 2
            int r8 = r33 + r8
            int r11 = r9 + 1
            int r15 = r33 + r9
            byte r15 = r2.getByte(r15)
            r2.setByte(r8, r15)
            int r5 = r5 + 3
            int r6 = r33 + r6
            int r9 = r9 + 2
            int r8 = r33 + r11
            byte r8 = r2.getByte(r8)
            r2.setByte(r6, r8)
        L_0x014b:
            int r6 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r6 == 0) goto L_0x0117
            int r6 = r5 + 1
            int r5 = r33 + r5
            int r8 = r9 + 1
            int r9 = r33 + r9
            byte r9 = r2.getByte(r9)
            r2.setByte(r5, r9)
            long r13 = r13 - r21
            r5 = r6
            r9 = r8
            goto L_0x014b
        L_0x0163:
            r25 = r7
            r5 = r10
            r10 = r6
            long r7 = r25 + r21
            long r12 = (long) r5
            long r12 = r12 + r7
            long r14 = (long) r3
            int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x0172
            r6 = 0
            return r6
        L_0x0172:
            r6 = 0
            long r12 = (long) r11
            long r12 = r12 + r7
            long r7 = (long) r1
            int r7 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x017b
            return r6
        L_0x017b:
            int r7 = r5 + 1
            int r5 = r33 + r5
            int r8 = r11 + 1
            int r9 = r30 + r11
            byte r9 = r0.getByte(r9)
            r2.setByte(r5, r9)
            r5 = r7
            r9 = r8
            r7 = r25
        L_0x018e:
            int r11 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r11 == 0) goto L_0x01a6
            int r11 = r5 + 1
            int r5 = r33 + r5
            int r12 = r9 + 1
            int r9 = r30 + r9
            byte r9 = r0.getByte(r9)
            r2.setByte(r5, r9)
            long r7 = r7 - r21
            r5 = r11
            r9 = r12
            goto L_0x018e
        L_0x01a6:
            if (r9 >= r1) goto L_0x01aa
            r11 = r10
            goto L_0x01ab
        L_0x01aa:
            r11 = r6
        L_0x01ab:
            if (r11 == 0) goto L_0x01ba
            int r7 = r9 + 1
            int r8 = r30 + r9
            short r8 = r0.getUnsignedByte(r8)
            long r8 = (long) r8
            r12 = r11
            r11 = r7
            r7 = r8
            goto L_0x01bc
        L_0x01ba:
            r12 = r11
            r11 = r9
        L_0x01bc:
            if (r12 != 0) goto L_0x01bf
            return r5
        L_0x01bf:
            r6 = r10
            r10 = r5
            r5 = 5
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLz.decompress(io.netty.buffer.ByteBuf, int, int, io.netty.buffer.ByteBuf, int, int):int");
    }

    private static int hashFunction(ByteBuf byteBuf, int i) {
        int readU16 = readU16(byteBuf, i);
        return ((readU16(byteBuf, i + 1) ^ (readU16 >> 3)) ^ readU16) & 8191;
    }

    private static int readU16(ByteBuf byteBuf, int i) {
        int i2 = i + 1;
        if (i2 >= byteBuf.readableBytes()) {
            return byteBuf.getUnsignedByte(i);
        }
        return byteBuf.getUnsignedByte(i) | (byteBuf.getUnsignedByte(i2) << 8);
    }
}
