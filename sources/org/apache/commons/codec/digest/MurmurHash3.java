package org.apache.commons.codec.digest;

import org.apache.commons.codec.binary.StringUtils;

public final class MurmurHash3 {
    private static final long C1 = -8663945395140668459L;
    private static final int C1_32 = -862048943;
    private static final long C2 = 5545529020109919103L;
    private static final int C2_32 = 461845907;
    public static final int DEFAULT_SEED = 104729;
    static final int INTEGER_BYTES = 4;
    static final int LONG_BYTES = 8;
    private static final int M = 5;
    private static final int M_32 = 5;
    private static final int N1 = 1390208809;
    private static final int N2 = 944331445;
    @Deprecated
    public static final long NULL_HASHCODE = 2862933555777941757L;
    private static final int N_32 = -430675100;
    private static final int R1 = 31;
    private static final int R1_32 = 15;
    private static final int R2 = 27;
    private static final int R2_32 = 13;
    private static final int R3 = 33;
    static final int SHORT_BYTES = 2;

    @Deprecated
    public static class IncrementalHash32 extends IncrementalHash32x86 {
        @Deprecated
        public int finalise(int i, int i2, byte[] bArr, int i3) {
            byte b;
            int i4;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i4 = bArr[2] << 16;
                    }
                    return MurmurHash3.fmix32(i ^ i3);
                }
                i4 = 0;
                b = (bArr[1] << 8) ^ i4;
            } else {
                b = 0;
            }
            i ^= Integer.rotateLeft((b ^ bArr[0]) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i ^ i3);
        }
    }

    public static class IncrementalHash32x86 {
        private static final int BLOCK_SIZE = 4;
        private int hash;
        private int totalLen;
        private final byte[] unprocessed = new byte[3];
        private int unprocessedLength;

        private static int orBytes(byte b, byte b2, byte b3, byte b4) {
            return (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16) | ((b4 & 255) << 24);
        }

        public final void add(byte[] bArr, int i, int i2) {
            int i3;
            if (i2 > 0) {
                this.totalLen += i2;
                int i4 = this.unprocessedLength;
                if ((i4 + i2) - 4 < 0) {
                    System.arraycopy(bArr, i, this.unprocessed, i4, i2);
                    this.unprocessedLength += i2;
                    return;
                }
                if (i4 > 0) {
                    if (i4 == 1) {
                        i3 = orBytes(this.unprocessed[0], bArr[i], bArr[i + 1], bArr[i + 2]);
                    } else if (i4 == 2) {
                        byte[] bArr2 = this.unprocessed;
                        i3 = orBytes(bArr2[0], bArr2[1], bArr[i], bArr[i + 1]);
                    } else if (i4 == 3) {
                        byte[] bArr3 = this.unprocessed;
                        i3 = orBytes(bArr3[0], bArr3[1], bArr3[2], bArr[i]);
                    } else {
                        throw new IllegalStateException("Unprocessed length should be 1, 2, or 3: " + this.unprocessedLength);
                    }
                    this.hash = MurmurHash3.mix32(i3, this.hash);
                    int i5 = 4 - this.unprocessedLength;
                    i += i5;
                    i2 -= i5;
                }
                int i6 = i2 >> 2;
                for (int i7 = 0; i7 < i6; i7++) {
                    this.hash = MurmurHash3.mix32(MurmurHash3.getLittleEndianInt(bArr, (i7 << 2) + i), this.hash);
                }
                int i8 = i6 << 2;
                int i9 = i2 - i8;
                this.unprocessedLength = i9;
                if (i9 != 0) {
                    System.arraycopy(bArr, i + i8, this.unprocessed, 0, i9);
                }
            }
        }

        public final int end() {
            return finalise(this.hash, this.unprocessedLength, this.unprocessed, this.totalLen);
        }

        public int finalise(int i, int i2, byte[] bArr, int i3) {
            byte b;
            int i4;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i4 = (bArr[2] & 255) << 16;
                    }
                    return MurmurHash3.fmix32(i ^ i3);
                }
                i4 = 0;
                b = ((bArr[1] & 255) << 8) ^ i4;
            } else {
                b = 0;
            }
            i ^= Integer.rotateLeft((b ^ (bArr[0] & 255)) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i ^ i3);
        }

        public final void start(int i) {
            this.totalLen = 0;
            this.unprocessedLength = 0;
            this.hash = i;
        }
    }

    private MurmurHash3() {
    }

    /* access modifiers changed from: private */
    public static int fmix32(int i) {
        int i2 = (i ^ (i >>> 16)) * -2048144789;
        int i3 = (i2 ^ (i2 >>> 13)) * -1028477387;
        return i3 ^ (i3 >>> 16);
    }

    private static long fmix64(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    /* access modifiers changed from: private */
    public static int getLittleEndianInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static long getLittleEndianLong(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static long[] hash128(byte[] bArr) {
        return hash128(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr) {
        return hash128x64(bArr, 0, bArr.length, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x008f, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 12]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x009d, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 11]) & 255) << 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00aa, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 10]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b7, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 9]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c8, code lost:
        r9 = r9 ^ (java.lang.Long.rotateLeft((r22 ^ ((long) (r0[r2 + 8] & 255))) * C2, 33) * C1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00dc, code lost:
        r22 = (((long) r0[r2 + 7]) & 255) << 56;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ea, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 6]) & 255) << 48);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f8, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 5]) & 255) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0106, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 4]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0114, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 3]) & 255) << 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0123, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 2]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0130, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 1]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x013f, code lost:
        r7 = r26 ^ (java.lang.Long.rotateLeft((r22 ^ ((long) (r0[r2] & 255))) * C1, 31) * C2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0081, code lost:
        r22 = r22 ^ ((((long) r0[r2 + 13]) & 255) << 40);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long[] hash128x64Internal(byte[] r28, int r29, int r30, long r31) {
        /*
            r0 = r28
            r1 = r30
            r3 = 8
            r4 = 1
            int r5 = r1 >> 4
            r7 = r31
            r9 = r7
            r11 = 0
        L_0x000d:
            r12 = 33
            r13 = 31
            r14 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            r16 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            if (r11 >= r5) goto L_0x0059
            int r18 = r11 << 4
            int r6 = r29 + r18
            long r19 = getLittleEndianLong(r0, r6)
            int r6 = r6 + r3
            long r21 = getLittleEndianLong(r0, r6)
            long r2 = r19 * r16
            long r2 = java.lang.Long.rotateLeft(r2, r13)
            long r2 = r2 * r14
            long r2 = r2 ^ r7
            r7 = 27
            long r2 = java.lang.Long.rotateLeft(r2, r7)
            long r2 = r2 + r9
            r7 = 5
            long r2 = r2 * r7
            r19 = 1390208809(0x52dce729, double:6.86854413E-315)
            long r2 = r2 + r19
            long r14 = r14 * r21
            long r14 = java.lang.Long.rotateLeft(r14, r12)
            long r14 = r14 * r16
            long r9 = r9 ^ r14
            long r9 = java.lang.Long.rotateLeft(r9, r13)
            long r9 = r9 + r2
            long r9 = r9 * r7
            r7 = 944331445(0x38495ab5, double:4.665617253E-315)
            long r9 = r9 + r7
            int r11 = r11 + r4
            r7 = r2
            r3 = 8
            goto L_0x000d
        L_0x0059:
            int r2 = r5 << 4
            int r2 = r29 + r2
            int r3 = r29 + r1
            int r3 = r3 - r2
            r5 = 16
            r11 = 24
            r19 = 32
            r20 = 40
            r21 = 48
            r22 = 0
            r24 = 255(0xff, double:1.26E-321)
            switch(r3) {
                case 1: goto L_0x013d;
                case 2: goto L_0x012e;
                case 3: goto L_0x0120;
                case 4: goto L_0x0112;
                case 5: goto L_0x0104;
                case 6: goto L_0x00f6;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00da;
                case 9: goto L_0x00c4;
                case 10: goto L_0x00b5;
                case 11: goto L_0x00a8;
                case 12: goto L_0x009b;
                case 13: goto L_0x008d;
                case 14: goto L_0x007f;
                case 15: goto L_0x0073;
                default: goto L_0x0071;
            }
        L_0x0071:
            goto L_0x014f
        L_0x0073:
            int r3 = r2 + 14
            byte r3 = r0[r3]
            r26 = r7
            long r6 = (long) r3
            long r6 = r6 & r24
            long r22 = r6 << r21
            goto L_0x0081
        L_0x007f:
            r26 = r7
        L_0x0081:
            int r3 = r2 + 13
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r20
            long r22 = r22 ^ r6
            goto L_0x008f
        L_0x008d:
            r26 = r7
        L_0x008f:
            int r3 = r2 + 12
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r19
            long r22 = r22 ^ r6
            goto L_0x009d
        L_0x009b:
            r26 = r7
        L_0x009d:
            int r3 = r2 + 11
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r11
            long r22 = r22 ^ r6
            goto L_0x00aa
        L_0x00a8:
            r26 = r7
        L_0x00aa:
            int r3 = r2 + 10
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r5
            long r22 = r22 ^ r6
            goto L_0x00b7
        L_0x00b5:
            r26 = r7
        L_0x00b7:
            int r3 = r2 + 9
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            r3 = 8
            long r6 = r6 << r3
            long r22 = r22 ^ r6
            goto L_0x00c8
        L_0x00c4:
            r26 = r7
            r3 = 8
        L_0x00c8:
            int r6 = r2 + 8
            byte r3 = r0[r6]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r6 = (long) r3
            long r6 = r22 ^ r6
            long r6 = r6 * r14
            long r6 = java.lang.Long.rotateLeft(r6, r12)
            long r6 = r6 * r16
            long r9 = r9 ^ r6
            goto L_0x00dc
        L_0x00da:
            r26 = r7
        L_0x00dc:
            int r3 = r2 + 7
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            r3 = 56
            long r22 = r6 << r3
            goto L_0x00ea
        L_0x00e8:
            r26 = r7
        L_0x00ea:
            int r3 = r2 + 6
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r21
            long r22 = r22 ^ r6
            goto L_0x00f8
        L_0x00f6:
            r26 = r7
        L_0x00f8:
            int r3 = r2 + 5
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r20
            long r22 = r22 ^ r6
            goto L_0x0106
        L_0x0104:
            r26 = r7
        L_0x0106:
            int r3 = r2 + 4
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r19
            long r22 = r22 ^ r6
            goto L_0x0114
        L_0x0112:
            r26 = r7
        L_0x0114:
            int r3 = r2 + 3
            byte r3 = r0[r3]
            long r6 = (long) r3
            long r6 = r6 & r24
            long r6 = r6 << r11
            long r22 = r22 ^ r6
        L_0x011e:
            r3 = 2
            goto L_0x0123
        L_0x0120:
            r26 = r7
            goto L_0x011e
        L_0x0123:
            int r7 = r2 + 2
            byte r3 = r0[r7]
            long r7 = (long) r3
            long r7 = r7 & r24
            long r7 = r7 << r5
            long r22 = r22 ^ r7
            goto L_0x0130
        L_0x012e:
            r26 = r7
        L_0x0130:
            int r3 = r2 + 1
            byte r3 = r0[r3]
            long r7 = (long) r3
            long r7 = r7 & r24
            r3 = 8
            long r7 = r7 << r3
            long r22 = r22 ^ r7
            goto L_0x013f
        L_0x013d:
            r26 = r7
        L_0x013f:
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            long r2 = (long) r0
            long r2 = r22 ^ r2
            long r2 = r2 * r16
            long r2 = java.lang.Long.rotateLeft(r2, r13)
            long r2 = r2 * r14
            long r7 = r26 ^ r2
        L_0x014f:
            long r0 = (long) r1
            long r2 = r7 ^ r0
            long r0 = r0 ^ r9
            long r2 = r2 + r0
            long r0 = r0 + r2
            long r2 = fmix64(r2)
            long r0 = fmix64(r0)
            long r2 = r2 + r0
            long r0 = r0 + r2
            r5 = 2
            long[] r5 = new long[r5]
            r6 = 0
            r5[r6] = r2
            r5[r4] = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash3.hash128x64Internal(byte[], int, int, long):long[]");
    }

    public static int hash32(long j, long j2) {
        return hash32(j, j2, (int) DEFAULT_SEED);
    }

    public static int hash32x86(byte[] bArr) {
        return hash32x86(bArr, 0, bArr.length, 0);
    }

    @Deprecated
    public static long hash64(long j) {
        return fmix64(((Long.rotateLeft((Long.rotateLeft(Long.reverseBytes(j) * C1, 31) * C2) ^ 104729, 27) * 5) + 1390208809) ^ 8);
    }

    /* access modifiers changed from: private */
    public static int mix32(int i, int i2) {
        return (Integer.rotateLeft((Integer.rotateLeft(i * C1_32, 15) * C2_32) ^ i2, 13) * 5) + N_32;
    }

    @Deprecated
    public static long[] hash128(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash128(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr, int i, int i2, int i3) {
        return hash128x64Internal(bArr, i, i2, ((long) i3) & 4294967295L);
    }

    public static int hash32(long j, long j2, int i) {
        long reverseBytes = Long.reverseBytes(j);
        long reverseBytes2 = Long.reverseBytes(j2);
        int i2 = (int) reverseBytes2;
        return fmix32(mix32((int) (reverseBytes2 >>> 32), mix32(i2, mix32((int) (reverseBytes >>> 32), mix32((int) reverseBytes, i)))) ^ 16);
    }

    public static int hash32x86(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i3 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i), i3);
        }
        int i7 = (i4 << 2) + i;
        int i8 = (i + i2) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    i5 = (bArr[i7 + 2] & 255) << 16;
                }
                return fmix32(i3 ^ i2);
            }
            i5 ^= (bArr[i7 + 1] & 255) << 8;
        }
        i3 ^= Integer.rotateLeft(((bArr[i7] & 255) ^ i5) * C1_32, 15) * C2_32;
        return fmix32(i3 ^ i2);
    }

    @Deprecated
    public static long[] hash128(byte[] bArr, int i, int i2, int i3) {
        return hash128x64Internal(bArr, i, i2, (long) i3);
    }

    @Deprecated
    public static long hash64(int i) {
        return fmix64((Long.rotateLeft((((long) Integer.reverseBytes(i)) & 4294967295L) * C1, 31) * C2) ^ 104733);
    }

    @Deprecated
    public static long hash64(short s) {
        return fmix64((Long.rotateLeft((((((long) s) & 255) << 8) ^ (255 & ((long) ((s & 65280) >> 8)))) * C1, 31) * C2) ^ 104731);
    }

    public static int hash32(long j) {
        return hash32(j, (int) DEFAULT_SEED);
    }

    public static int hash32(long j, int i) {
        long reverseBytes = Long.reverseBytes(j);
        return fmix32(mix32((int) (reverseBytes >>> 32), mix32((int) reverseBytes, i)) ^ 8);
    }

    @Deprecated
    public static long hash64(byte[] bArr) {
        return hash64(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static long hash64(byte[] bArr, int i, int i2) {
        return hash64(bArr, i, i2, DEFAULT_SEED);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 2]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0077, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 1]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0081, code lost:
        r2 = r2 ^ (java.lang.Long.rotateLeft(((((long) r0[r4]) & 255) ^ r13) * C1, 31) * C2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0098, code lost:
        return fmix64(((long) r1) ^ r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004e, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 5]) & 255) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0059, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 4]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0063, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 3]) & 255) << 24);
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long hash64(byte[] r15, int r16, int r17, int r18) {
        /*
            r0 = r15
            r1 = r17
            r2 = r18
            long r2 = (long) r2
            int r4 = r1 >> 3
            r5 = 0
        L_0x0009:
            r6 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            r8 = 31
            r9 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            if (r5 >= r4) goto L_0x0036
            int r11 = r5 << 3
            int r11 = r16 + r11
            long r11 = getLittleEndianLong(r15, r11)
            long r11 = r11 * r9
            long r8 = java.lang.Long.rotateLeft(r11, r8)
            long r8 = r8 * r6
            long r2 = r2 ^ r8
            r6 = 27
            long r2 = java.lang.Long.rotateLeft(r2, r6)
            r6 = 5
            long r2 = r2 * r6
            r6 = 1390208809(0x52dce729, double:6.86854413E-315)
            long r2 = r2 + r6
            int r5 = r5 + 1
            goto L_0x0009
        L_0x0036:
            int r4 = r4 << 3
            int r4 = r16 + r4
            int r5 = r16 + r1
            int r5 = r5 - r4
            r11 = 255(0xff, double:1.26E-321)
            r13 = 0
            switch(r5) {
                case 1: goto L_0x0081;
                case 2: goto L_0x0077;
                case 3: goto L_0x006d;
                case 4: goto L_0x0063;
                case 5: goto L_0x0059;
                case 6: goto L_0x004e;
                case 7: goto L_0x0045;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x0092
        L_0x0045:
            int r5 = r4 + 6
            byte r5 = r0[r5]
            long r13 = (long) r5
            long r13 = r13 & r11
            r5 = 48
            long r13 = r13 << r5
        L_0x004e:
            int r5 = r4 + 5
            byte r5 = r0[r5]
            long r6 = (long) r5
            long r5 = r6 & r11
            r7 = 40
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0059:
            int r5 = r4 + 4
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 32
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0063:
            int r5 = r4 + 3
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 24
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x006d:
            int r5 = r4 + 2
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 16
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0077:
            int r5 = r4 + 1
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 8
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0081:
            byte r0 = r0[r4]
            long r4 = (long) r0
            long r4 = r4 & r11
            long r4 = r4 ^ r13
            long r4 = r4 * r9
            long r4 = java.lang.Long.rotateLeft(r4, r8)
            r6 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            long r4 = r4 * r6
            long r2 = r2 ^ r4
        L_0x0092:
            long r0 = (long) r1
            long r0 = r0 ^ r2
            long r0 = fmix64(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash3.hash64(byte[], int, int, int):long");
    }

    @Deprecated
    public static int hash32(byte[] bArr) {
        return hash32(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i) {
        return hash32(bArr, i, (int) DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i, int i2) {
        return hash32(bArr, 0, i, i2);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i3 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i), i3);
        }
        int i7 = (i4 << 2) + i;
        int i8 = (i + i2) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    i5 = bArr[i7 + 2] << 16;
                }
                return fmix32(i3 ^ i2);
            }
            i5 ^= bArr[i7 + 1] << 8;
        }
        i3 ^= Integer.rotateLeft((bArr[i7] ^ i5) * C1_32, 15) * C2_32;
        return fmix32(i3 ^ i2);
    }
}
