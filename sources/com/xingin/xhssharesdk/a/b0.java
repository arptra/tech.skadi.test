package com.xingin.xhssharesdk.a;

import com.here.odnp.config.OdnpConfigStatic;
import com.meizu.common.widget.CircularProgressButton;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8123a = ((!a0.c || !a0.b) ? new b() : new d());

    public static abstract class a {
        public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        public abstract int b(byte[] bArr, int i, int i2);
    }

    public static final class b extends a {
        public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            char charAt;
            int length = charSequence.length();
            int i5 = i2 + i;
            int i6 = 0;
            while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
                bArr[i4] = (byte) charAt;
                i6++;
            }
            if (i6 == length) {
                return i + length;
            }
            int i7 = i + i6;
            while (i6 < length) {
                char charAt2 = charSequence.charAt(i6);
                if (charAt2 < 128 && i7 < i5) {
                    bArr[i7] = (byte) charAt2;
                    i7++;
                } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> 6) | OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES);
                    i7 += 2;
                    bArr[i8] = (byte) ((charAt2 & '?') | 128);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i5 - 3) {
                    bArr[i7] = (byte) ((charAt2 >>> 12) | OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES);
                    int i9 = i7 + 2;
                    bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i7 += 3;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                } else if (i7 <= i5 - 4) {
                    int i10 = i6 + 1;
                    if (i10 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i10);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            bArr[i7] = (byte) ((codePoint >>> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL);
                            bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i11 = i7 + 3;
                            bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i7 += 4;
                            bArr[i11] = (byte) ((codePoint & 63) | 128);
                            i6 = i10;
                        } else {
                            i6 = i10;
                        }
                    }
                    throw new c(i6 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i6 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                } else {
                    throw new c(i6, length);
                }
                i6++;
            }
            return i7;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
            if (r0 > -12) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x009b, code lost:
            if (r0 > -12) goto L_0x00b9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int b(byte[] r8, int r9, int r10) {
            /*
                r7 = this;
            L_0x0000:
                if (r9 >= r10) goto L_0x0009
                byte r7 = r8[r9]
                if (r7 < 0) goto L_0x0009
                int r9 = r9 + 1
                goto L_0x0000
            L_0x0009:
                if (r9 < r10) goto L_0x000c
                goto L_0x000e
            L_0x000c:
                if (r9 < r10) goto L_0x0011
            L_0x000e:
                r7 = 0
                goto L_0x00ba
            L_0x0011:
                int r7 = r9 + 1
                byte r0 = r8[r9]
                if (r0 >= 0) goto L_0x00bb
                r1 = -32
                r2 = -65
                if (r0 >= r1) goto L_0x002e
                if (r7 < r10) goto L_0x0022
            L_0x001f:
                r7 = r0
                goto L_0x00ba
            L_0x0022:
                r1 = -62
                if (r0 < r1) goto L_0x00b9
                int r9 = r9 + 2
                byte r7 = r8[r7]
                if (r7 <= r2) goto L_0x000c
                goto L_0x00b9
            L_0x002e:
                r3 = -16
                r4 = -12
                r5 = 1
                r6 = 2
                if (r0 >= r3) goto L_0x0077
                int r3 = r10 + -1
                if (r7 < r3) goto L_0x005e
                byte r0 = r8[r9]
                int r10 = r10 - r7
                if (r10 == 0) goto L_0x005b
                if (r10 == r5) goto L_0x0054
                if (r10 != r6) goto L_0x004e
                byte r7 = r8[r7]
                int r9 = r9 + r6
                byte r8 = r8[r9]
                int r7 = com.xingin.xhssharesdk.a.b0.b(r0, r7, r8)
                goto L_0x00ba
            L_0x004e:
                java.lang.AssertionError r7 = new java.lang.AssertionError
                r7.<init>()
                throw r7
            L_0x0054:
                byte r7 = r8[r7]
                int r7 = com.xingin.xhssharesdk.a.b0.a(r0, r7)
                goto L_0x00ba
            L_0x005b:
                if (r0 <= r4) goto L_0x001f
                goto L_0x00b9
            L_0x005e:
                int r3 = r9 + 2
                byte r7 = r8[r7]
                if (r7 > r2) goto L_0x00b9
                r4 = -96
                if (r0 != r1) goto L_0x006a
                if (r7 < r4) goto L_0x00b9
            L_0x006a:
                r1 = -19
                if (r0 != r1) goto L_0x0070
                if (r7 >= r4) goto L_0x00b9
            L_0x0070:
                int r9 = r9 + 3
                byte r7 = r8[r3]
                if (r7 <= r2) goto L_0x000c
                goto L_0x00b9
            L_0x0077:
                int r1 = r10 + -2
                if (r7 < r1) goto L_0x009e
                byte r0 = r8[r9]
                int r10 = r10 - r7
                if (r10 == 0) goto L_0x009b
                if (r10 == r5) goto L_0x0094
                if (r10 != r6) goto L_0x008e
                byte r7 = r8[r7]
                int r9 = r9 + r6
                byte r8 = r8[r9]
                int r7 = com.xingin.xhssharesdk.a.b0.b(r0, r7, r8)
                goto L_0x00ba
            L_0x008e:
                java.lang.AssertionError r7 = new java.lang.AssertionError
                r7.<init>()
                throw r7
            L_0x0094:
                byte r7 = r8[r7]
                int r7 = com.xingin.xhssharesdk.a.b0.a(r0, r7)
                goto L_0x00ba
            L_0x009b:
                if (r0 <= r4) goto L_0x001f
                goto L_0x00b9
            L_0x009e:
                int r1 = r9 + 2
                byte r7 = r8[r7]
                if (r7 > r2) goto L_0x00b9
                int r0 = r0 << 28
                int r7 = r7 + 112
                int r7 = r7 + r0
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x00b9
                int r7 = r9 + 3
                byte r0 = r8[r1]
                if (r0 > r2) goto L_0x00b9
                int r9 = r9 + 4
                byte r7 = r8[r7]
                if (r7 <= r2) goto L_0x000c
            L_0x00b9:
                r7 = -1
            L_0x00ba:
                return r7
            L_0x00bb:
                r9 = r7
                goto L_0x000c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.b0.b.b(byte[], int, int):int");
        }
    }

    public static class c extends IllegalArgumentException {
        public c(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    public static final class d extends a {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[LOOP:1: B:14:0x0039->B:39:0x00fe, LOOP_START, PHI: r2 r4 r6 r9 r10 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x0032, B:39:0x00fe] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v5 long) binds: [B:10:0x0032, B:39:0x00fe] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v4 long) = (r6v2 long), (r6v5 long) binds: [B:10:0x0032, B:39:0x00fe] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v2 java.lang.String) binds: [B:10:0x0032, B:39:0x00fe] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v1 java.lang.String) = (r10v0 java.lang.String), (r10v2 java.lang.String) binds: [B:10:0x0032, B:39:0x00fe] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x0032, B:39:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(java.lang.CharSequence r24, byte[] r25, int r26, int r27) {
            /*
                r23 = this;
                r0 = r24
                r1 = r25
                r2 = r26
                r3 = r27
                long r4 = com.xingin.xhssharesdk.a.a0.d
                long r6 = (long) r2
                long r4 = r4 + r6
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r24.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0149
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0149
                r2 = 0
            L_0x001d:
                r11 = 1
                r3 = 128(0x80, float:1.794E-43)
                if (r2 >= r8) goto L_0x0032
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x0032
                long r11 = r11 + r4
                byte r3 = (byte) r13
                com.xingin.xhssharesdk.a.a0.d(r1, r4, r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001d
            L_0x0032:
                if (r2 != r8) goto L_0x0039
                long r0 = com.xingin.xhssharesdk.a.a0.d
            L_0x0036:
                long r4 = r4 - r0
                int r0 = (int) r4
                return r0
            L_0x0039:
                if (r2 >= r8) goto L_0x0145
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x0055
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x0055
                long r14 = r4 + r11
                byte r13 = (byte) r13
                com.xingin.xhssharesdk.a.a0.d(r1, r4, r13)
                r21 = r6
                r23 = r9
                r19 = r11
                r4 = r14
                r14 = r10
                goto L_0x00fe
            L_0x0055:
                r14 = 2048(0x800, float:2.87E-42)
                r15 = 2
                if (r13 >= r14) goto L_0x007c
                long r17 = r6 - r15
                int r14 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r14 > 0) goto L_0x007c
                r23 = r9
                r14 = r10
                long r9 = r4 + r11
                int r11 = r13 >>> 6
                r11 = r11 | 960(0x3c0, float:1.345E-42)
                byte r11 = (byte) r11
                com.xingin.xhssharesdk.a.a0.d(r1, r4, r11)
                long r4 = r4 + r15
                r11 = r13 & 63
                r11 = r11 | r3
                byte r11 = (byte) r11
                com.xingin.xhssharesdk.a.a0.d(r1, r9, r11)
            L_0x0076:
                r21 = r6
                r19 = 1
                goto L_0x00fe
            L_0x007c:
                r23 = r9
                r14 = r10
                r9 = 57343(0xdfff, float:8.0355E-41)
                r10 = 55296(0xd800, float:7.7486E-41)
                r11 = 3
                if (r13 < r10) goto L_0x008b
                if (r9 >= r13) goto L_0x00b3
            L_0x008b:
                long r17 = r6 - r11
                int r17 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r17 > 0) goto L_0x00b3
                r17 = 1
                long r9 = r4 + r17
                int r11 = r13 >>> 12
                r11 = r11 | 480(0x1e0, float:6.73E-43)
                byte r11 = (byte) r11
                com.xingin.xhssharesdk.a.a0.d(r1, r4, r11)
                long r11 = r4 + r15
                int r15 = r13 >>> 6
                r15 = r15 & 63
                r15 = r15 | r3
                byte r15 = (byte) r15
                com.xingin.xhssharesdk.a.a0.d(r1, r9, r15)
                r9 = 3
                long r4 = r4 + r9
                r9 = r13 & 63
                r9 = r9 | r3
                byte r9 = (byte) r9
                com.xingin.xhssharesdk.a.a0.d(r1, r11, r9)
                goto L_0x0076
            L_0x00b3:
                r11 = 4
                long r19 = r6 - r11
                int r19 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
                if (r19 > 0) goto L_0x0112
                int r9 = r2 + 1
                if (r9 == r8) goto L_0x010a
                char r2 = r0.charAt(r9)
                boolean r10 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r10 == 0) goto L_0x0109
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r19 = 1
                long r11 = r4 + r19
                int r10 = r2 >>> 18
                r10 = r10 | 240(0xf0, float:3.36E-43)
                byte r10 = (byte) r10
                com.xingin.xhssharesdk.a.a0.d(r1, r4, r10)
                r21 = r6
                long r6 = r4 + r15
                int r10 = r2 >>> 12
                r10 = r10 & 63
                r10 = r10 | r3
                byte r10 = (byte) r10
                com.xingin.xhssharesdk.a.a0.d(r1, r11, r10)
                r10 = 3
                long r11 = r4 + r10
                int r10 = r2 >>> 6
                r10 = r10 & 63
                r10 = r10 | r3
                byte r10 = (byte) r10
                com.xingin.xhssharesdk.a.a0.d(r1, r6, r10)
                r6 = 4
                long r4 = r4 + r6
                r2 = r2 & 63
                r2 = r2 | r3
                byte r2 = (byte) r2
                com.xingin.xhssharesdk.a.a0.d(r1, r11, r2)
                r2 = r9
            L_0x00fe:
                int r2 = r2 + 1
                r9 = r23
                r10 = r14
                r11 = r19
                r6 = r21
                goto L_0x0039
            L_0x0109:
                r2 = r9
            L_0x010a:
                com.xingin.xhssharesdk.a.b0$c r0 = new com.xingin.xhssharesdk.a.b0$c
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x0112:
                if (r10 > r13) goto L_0x012a
                if (r13 > r9) goto L_0x012a
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0124
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x012a
            L_0x0124:
                com.xingin.xhssharesdk.a.b0$c r0 = new com.xingin.xhssharesdk.a.b0$c
                r0.<init>(r2, r8)
                throw r0
            L_0x012a:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r6 = r14
                r1.<init>(r6)
                r1.append(r13)
                r7 = r23
                r1.append(r7)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0145:
                long r0 = com.xingin.xhssharesdk.a.a0.d
                goto L_0x0036
            L_0x0149:
                r7 = r9
                r6 = r10
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r6)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r7)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.b0.d.a(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b8, code lost:
            if (r2 > -12) goto L_0x012d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0105, code lost:
            if (r2 > -12) goto L_0x012d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int b(byte[] r17, int r18, int r19) {
            /*
                r16 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                r3 = -1
                r4 = r1 | r2
                int r5 = r0.length
                int r5 = r5 - r2
                r4 = r4 | r5
                if (r4 < 0) goto L_0x012f
                long r4 = com.xingin.xhssharesdk.a.a0.d
                long r6 = (long) r1
                long r6 = r6 + r4
                long r1 = (long) r2
                long r4 = r4 + r1
                long r4 = r4 - r6
                int r1 = (int) r4
                r2 = 16
                r8 = 1
                if (r1 >= r2) goto L_0x001e
                r2 = 0
                goto L_0x0050
            L_0x001e:
                int r2 = (int) r6
                r2 = r2 & 7
                r5 = r2
                r10 = r6
            L_0x0023:
                if (r5 <= 0) goto L_0x0032
                long r12 = r10 + r8
                byte r10 = com.xingin.xhssharesdk.a.a0.a(r0, r10)
                if (r10 >= 0) goto L_0x002f
                int r2 = r2 - r5
                goto L_0x0050
            L_0x002f:
                int r5 = r5 + r3
                r10 = r12
                goto L_0x0023
            L_0x0032:
                int r2 = r1 - r2
            L_0x0034:
                r5 = 8
                if (r2 < r5) goto L_0x004e
                long r12 = com.xingin.xhssharesdk.a.a0.e(r0, r10)
                r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r12 = r12 & r14
                r14 = 0
                int r5 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r5 != 0) goto L_0x004e
                r12 = 8
                long r10 = r10 + r12
                int r2 = r2 + -8
                goto L_0x0034
            L_0x004e:
                int r2 = r1 - r2
            L_0x0050:
                int r1 = r1 - r2
                long r10 = (long) r2
                long r6 = r6 + r10
            L_0x0053:
                r2 = 0
            L_0x0054:
                if (r1 <= 0) goto L_0x0062
                long r10 = r6 + r8
                byte r2 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                if (r2 < 0) goto L_0x0061
                int r1 = r1 + r3
                r6 = r10
                goto L_0x0054
            L_0x0061:
                r6 = r10
            L_0x0062:
                if (r1 != 0) goto L_0x0067
                r3 = 0
                goto L_0x012e
            L_0x0067:
                int r5 = r1 + -1
                r10 = -32
                r11 = -65
                if (r2 >= r10) goto L_0x0085
                if (r5 != 0) goto L_0x0073
                goto L_0x0108
            L_0x0073:
                int r1 = r1 + -2
                r5 = -62
                if (r2 < r5) goto L_0x012d
                long r12 = r6 + r8
                byte r2 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                if (r2 <= r11) goto L_0x0083
                goto L_0x012d
            L_0x0083:
                r6 = r12
                goto L_0x0053
            L_0x0085:
                r12 = -16
                r13 = 2
                r15 = -12
                r3 = 1
                r4 = 2
                if (r2 >= r12) goto L_0x00dd
                if (r5 >= r4) goto L_0x00bc
                if (r5 == 0) goto L_0x00b6
                if (r5 == r3) goto L_0x00ac
                if (r5 != r4) goto L_0x00a6
                byte r1 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                long r6 = r6 + r8
                byte r0 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                int r3 = com.xingin.xhssharesdk.a.b0.b(r2, r1, r0)
                goto L_0x012e
            L_0x00a6:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x00ac:
                byte r0 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                int r3 = com.xingin.xhssharesdk.a.b0.a(r2, r0)
                goto L_0x012e
            L_0x00b6:
                com.xingin.xhssharesdk.a.b0$a r0 = com.xingin.xhssharesdk.a.b0.f8123a
                if (r2 <= r15) goto L_0x0108
                goto L_0x012d
            L_0x00bc:
                int r1 = r1 + -3
                long r3 = r6 + r8
                byte r5 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                if (r5 > r11) goto L_0x012d
                r12 = -96
                if (r2 != r10) goto L_0x00cc
                if (r5 < r12) goto L_0x012d
            L_0x00cc:
                r10 = -19
                if (r2 != r10) goto L_0x00d2
                if (r5 >= r12) goto L_0x012d
            L_0x00d2:
                long r6 = r6 + r13
                byte r2 = com.xingin.xhssharesdk.a.a0.a(r0, r3)
                if (r2 <= r11) goto L_0x00da
                goto L_0x012d
            L_0x00da:
                r3 = -1
                goto L_0x0053
            L_0x00dd:
                r10 = 3
                if (r5 >= r10) goto L_0x010a
                if (r5 == 0) goto L_0x0103
                if (r5 == r3) goto L_0x00fa
                if (r5 != r4) goto L_0x00f4
                byte r1 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                long r6 = r6 + r8
                byte r0 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                int r3 = com.xingin.xhssharesdk.a.b0.b(r2, r1, r0)
                goto L_0x012e
            L_0x00f4:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x00fa:
                byte r0 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                int r3 = com.xingin.xhssharesdk.a.b0.a(r2, r0)
                goto L_0x012e
            L_0x0103:
                com.xingin.xhssharesdk.a.b0$a r0 = com.xingin.xhssharesdk.a.b0.f8123a
                if (r2 <= r15) goto L_0x0108
                goto L_0x012d
            L_0x0108:
                r3 = r2
                goto L_0x012e
            L_0x010a:
                int r1 = r1 + -4
                long r3 = r6 + r8
                byte r5 = com.xingin.xhssharesdk.a.a0.a(r0, r6)
                if (r5 > r11) goto L_0x012d
                int r2 = r2 << 28
                int r5 = r5 + 112
                int r5 = r5 + r2
                int r2 = r5 >> 30
                if (r2 != 0) goto L_0x012d
                long r13 = r13 + r6
                byte r2 = com.xingin.xhssharesdk.a.a0.a(r0, r3)
                if (r2 > r11) goto L_0x012d
                r2 = 3
                long r6 = r6 + r2
                byte r2 = com.xingin.xhssharesdk.a.a0.a(r0, r13)
                if (r2 <= r11) goto L_0x00da
            L_0x012d:
                r3 = -1
            L_0x012e:
                return r3
            L_0x012f:
                java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
                int r0 = r0.length
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r19)
                java.lang.Object[] r0 = new java.lang.Object[]{r0, r1, r2}
                java.lang.String r1 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.b0.d.b(byte[], int, int):int");
        }
    }

    public static int a(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int b(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static int c(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new c(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    public static boolean d(byte[] bArr, int i, int i2) {
        return f8123a.b(bArr, i, i2) == 0;
    }
}
