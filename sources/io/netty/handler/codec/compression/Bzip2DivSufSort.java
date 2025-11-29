package io.netty.handler.codec.compression;

final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;
    private final int[] SA;
    private final byte[] T;
    private final int n;

    public static class PartitionResult {
        final int first;
        final int last;

        public PartitionResult(int i, int i2) {
            this.first = i;
            this.last = i2;
        }
    }

    public static class StackEntry {

        /* renamed from: a  reason: collision with root package name */
        final int f3686a;
        final int b;
        final int c;
        final int d;

        public StackEntry(int i, int i2, int i3, int i4) {
            this.f3686a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public static class TRBudget {
        int budget;
        int chance;

        public TRBudget(int i, int i2) {
            this.budget = i;
            this.chance = i2;
        }

        public boolean update(int i, int i2) {
            int i3 = this.budget - i2;
            this.budget = i3;
            if (i3 <= 0) {
                int i4 = this.chance - 1;
                this.chance = i4;
                if (i4 == 0) {
                    return false;
                }
                this.budget = i3 + i;
            }
            return true;
        }
    }

    public Bzip2DivSufSort(byte[] bArr, int[] iArr, int i) {
        this.T = bArr;
        this.SA = iArr;
        this.n = i;
    }

    private static int BUCKET_B(int i, int i2) {
        return i | (i2 << 8);
    }

    private static int BUCKET_BSTAR(int i, int i2) {
        return (i << 8) | i2;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v5, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v5, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r10v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v6, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int constructBWT(int[] r12, int[] r13) {
        /*
            r11 = this;
            byte[] r0 = r11.T
            int[] r1 = r11.SA
            int r11 = r11.n
            r2 = 0
            r3 = 254(0xfe, float:3.56E-43)
            r4 = r2
            r5 = r4
        L_0x000b:
            r6 = -1
            if (r3 < 0) goto L_0x0060
            int r4 = r3 + 1
            int r5 = BUCKET_BSTAR(r3, r4)
            r5 = r13[r5]
            r4 = r12[r4]
            r7 = r6
            r6 = r2
        L_0x001a:
            if (r5 > r4) goto L_0x005b
            r8 = r1[r4]
            if (r8 < 0) goto L_0x0055
            int r9 = r8 + -1
            if (r9 >= 0) goto L_0x0026
            int r9 = r11 + -1
        L_0x0026:
            byte r10 = r0[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            if (r10 > r3) goto L_0x0058
            int r8 = ~r8
            r1[r4] = r8
            if (r9 <= 0) goto L_0x003a
            int r8 = r9 + -1
            byte r8 = r0[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r8 <= r10) goto L_0x003a
            int r9 = ~r9
        L_0x003a:
            if (r7 != r10) goto L_0x0041
            int r6 = r6 + -1
            r1[r6] = r9
            goto L_0x0058
        L_0x0041:
            if (r7 < 0) goto L_0x0049
            int r7 = BUCKET_B(r7, r3)
            r13[r7] = r6
        L_0x0049:
            int r6 = BUCKET_B(r10, r3)
            r6 = r13[r6]
            int r6 = r6 + -1
            r1[r6] = r9
            r7 = r10
            goto L_0x0058
        L_0x0055:
            int r8 = ~r8
            r1[r4] = r8
        L_0x0058:
            int r4 = r4 + -1
            goto L_0x001a
        L_0x005b:
            int r3 = r3 + -1
            r4 = r6
            r5 = r7
            goto L_0x000b
        L_0x0060:
            r13 = r6
        L_0x0061:
            if (r2 >= r11) goto L_0x00ab
            r3 = r1[r2]
            if (r3 < 0) goto L_0x0097
            int r7 = r3 + -1
            if (r7 >= 0) goto L_0x006d
            int r7 = r11 + -1
        L_0x006d:
            byte r8 = r0[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r9 = r7 + 1
            byte r9 = r0[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            if (r8 < r9) goto L_0x0098
            if (r7 <= 0) goto L_0x0084
            int r9 = r7 + -1
            byte r9 = r0[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            if (r9 >= r8) goto L_0x0084
            int r7 = ~r7
        L_0x0084:
            if (r8 != r5) goto L_0x008b
            int r4 = r4 + 1
            r1[r4] = r7
            goto L_0x0098
        L_0x008b:
            if (r5 == r6) goto L_0x008f
            r12[r5] = r4
        L_0x008f:
            r4 = r12[r8]
            int r4 = r4 + 1
            r1[r4] = r7
            r5 = r8
            goto L_0x0098
        L_0x0097:
            int r3 = ~r3
        L_0x0098:
            if (r3 != 0) goto L_0x00a2
            int r13 = r11 + -1
            byte r13 = r0[r13]
            r1[r2] = r13
            r13 = r2
            goto L_0x00a8
        L_0x00a2:
            int r3 = r3 + -1
            byte r3 = r0[r3]
            r1[r2] = r3
        L_0x00a8:
            int r2 = r2 + 1
            goto L_0x0061
        L_0x00ab:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.constructBWT(int[], int[]):int");
    }

    private static int getIDX(int i) {
        return i >= 0 ? i : ~i;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0132 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0134  */
    private void lsIntroSort(int r21, int r22, int r23, int r24, int r25) {
        /*
            r20 = this;
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            int[] r10 = r6.SA
            r0 = 64
            io.netty.handler.codec.compression.Bzip2DivSufSort$StackEntry[] r11 = new io.netty.handler.codec.compression.Bzip2DivSufSort.StackEntry[r0]
            int r0 = r25 - r24
            int r0 = trLog(r0)
            r13 = r24
            r14 = r25
            r15 = 0
            r16 = 0
        L_0x001b:
            int r5 = r14 - r13
            r1 = 8
            r17 = -1
            r4 = 1
            if (r5 > r1) goto L_0x0049
            if (r4 >= r5) goto L_0x0037
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r13
            r5 = r14
            r0.trInsertionSort(r1, r2, r3, r4, r5)
            r6.lsUpdateGroup(r7, r13, r14)
            goto L_0x003b
        L_0x0037:
            if (r5 != r4) goto L_0x003b
            r10[r13] = r17
        L_0x003b:
            if (r15 != 0) goto L_0x003e
            return
        L_0x003e:
            int r15 = r15 + -1
            r0 = r11[r15]
            int r13 = r0.f3686a
            int r14 = r0.b
            int r0 = r0.c
            goto L_0x001b
        L_0x0049:
            int r3 = r0 + -1
            if (r0 != 0) goto L_0x008b
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r13
            r0.trHeapSort(r1, r2, r3, r4, r5)
            int r0 = r14 + -1
        L_0x005b:
            if (r13 >= r0) goto L_0x007a
            r1 = r10[r0]
            int r1 = r6.trGetC(r7, r8, r9, r1)
            int r0 = r0 + -1
        L_0x0065:
            if (r13 > r0) goto L_0x0077
            r2 = r10[r0]
            int r2 = r6.trGetC(r7, r8, r9, r2)
            if (r2 != r1) goto L_0x0077
            r2 = r10[r0]
            int r2 = ~r2
            r10[r0] = r2
            int r0 = r0 + -1
            goto L_0x0065
        L_0x0077:
            r16 = r1
            goto L_0x005b
        L_0x007a:
            r6.lsUpdateGroup(r7, r13, r14)
            if (r15 != 0) goto L_0x0080
            return
        L_0x0080:
            int r15 = r15 + -1
            r0 = r11[r15]
            int r13 = r0.f3686a
            int r14 = r0.b
            int r0 = r0.c
            goto L_0x001b
        L_0x008b:
            r0 = r20
            r1 = r21
            r2 = r22
            r5 = r3
            r3 = r23
            r12 = r4
            r4 = r13
            r18 = r5
            r5 = r14
            int r0 = r0.trPivot(r1, r2, r3, r4, r5)
            swapElements(r10, r13, r10, r0)
            r0 = r10[r13]
            int r0 = r6.trGetC(r7, r8, r9, r0)
            int r1 = r13 + 1
        L_0x00a8:
            if (r1 >= r14) goto L_0x00b7
            r2 = r10[r1]
            int r2 = r6.trGetC(r7, r8, r9, r2)
            if (r2 != r0) goto L_0x00b9
            int r1 = r1 + 1
            r16 = r2
            goto L_0x00a8
        L_0x00b7:
            r2 = r16
        L_0x00b9:
            if (r1 >= r14) goto L_0x00d2
            if (r2 >= r0) goto L_0x00d2
            r3 = r2
            r2 = r1
        L_0x00bf:
            int r1 = r1 + r12
            if (r1 >= r14) goto L_0x00d4
            r3 = r10[r1]
            int r3 = r6.trGetC(r7, r8, r9, r3)
            if (r3 > r0) goto L_0x00d4
            if (r3 != r0) goto L_0x00bf
            swapElements(r10, r1, r10, r2)
            int r2 = r2 + 1
            goto L_0x00bf
        L_0x00d2:
            r3 = r2
            r2 = r1
        L_0x00d4:
            int r4 = r14 + -1
        L_0x00d6:
            if (r1 >= r4) goto L_0x00e3
            r3 = r10[r4]
            int r3 = r6.trGetC(r7, r8, r9, r3)
            if (r3 != r0) goto L_0x00e3
            int r4 = r4 + -1
            goto L_0x00d6
        L_0x00e3:
            if (r1 >= r4) goto L_0x00ff
            if (r3 <= r0) goto L_0x00ff
            r5 = r4
        L_0x00e8:
            int r4 = r4 + -1
            if (r1 >= r4) goto L_0x00fc
            r3 = r10[r4]
            int r3 = r6.trGetC(r7, r8, r9, r3)
            if (r3 < r0) goto L_0x00fc
            if (r3 != r0) goto L_0x00e8
            swapElements(r10, r4, r10, r5)
            int r5 = r5 + -1
            goto L_0x00e8
        L_0x00fc:
            r16 = r3
            goto L_0x0102
        L_0x00ff:
            r16 = r3
            r5 = r4
        L_0x0102:
            if (r1 >= r4) goto L_0x0132
            swapElements(r10, r1, r10, r4)
        L_0x0107:
            int r1 = r1 + r12
            if (r1 >= r4) goto L_0x011e
            r3 = r10[r1]
            int r3 = r6.trGetC(r7, r8, r9, r3)
            if (r3 > r0) goto L_0x011c
            if (r3 != r0) goto L_0x0119
            swapElements(r10, r1, r10, r2)
            int r2 = r2 + 1
        L_0x0119:
            r16 = r3
            goto L_0x0107
        L_0x011c:
            r16 = r3
        L_0x011e:
            int r4 = r4 + -1
            if (r1 >= r4) goto L_0x0102
            r3 = r10[r4]
            int r3 = r6.trGetC(r7, r8, r9, r3)
            if (r3 < r0) goto L_0x00fc
            if (r3 != r0) goto L_0x011c
            swapElements(r10, r4, r10, r5)
            int r5 = r5 + -1
            goto L_0x011c
        L_0x0132:
            if (r2 > r5) goto L_0x01be
            int r0 = r1 + -1
            int r3 = r2 - r13
            int r2 = r1 - r2
            if (r3 <= r2) goto L_0x013d
            r3 = r2
        L_0x013d:
            int r4 = r1 - r3
            r12 = r13
        L_0x0140:
            if (r3 <= 0) goto L_0x014e
            swapElements(r10, r12, r10, r4)
            int r3 = r3 + -1
            r19 = 1
            int r12 = r12 + 1
            int r4 = r4 + 1
            goto L_0x0140
        L_0x014e:
            r19 = 1
            int r0 = r5 - r0
            int r3 = r14 - r5
            int r3 = r3 + -1
            if (r0 <= r3) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r3 = r0
        L_0x015a:
            int r4 = r14 - r3
        L_0x015c:
            if (r3 <= 0) goto L_0x0168
            swapElements(r10, r1, r10, r4)
            int r3 = r3 + -1
            int r1 = r1 + 1
            int r4 = r4 + 1
            goto L_0x015c
        L_0x0168:
            int r1 = r13 + r2
            int r0 = r14 - r0
            int r2 = r1 + -1
            r3 = r13
        L_0x016f:
            if (r3 >= r1) goto L_0x0179
            r4 = r10[r3]
            int r4 = r4 + r7
            r10[r4] = r2
            int r3 = r3 + 1
            goto L_0x016f
        L_0x0179:
            if (r0 >= r14) goto L_0x0188
            int r2 = r0 + -1
            r3 = r1
        L_0x017e:
            if (r3 >= r0) goto L_0x0188
            r4 = r10[r3]
            int r4 = r4 + r7
            r10[r4] = r2
            int r3 = r3 + 1
            goto L_0x017e
        L_0x0188:
            int r2 = r0 - r1
            r3 = 1
            if (r2 != r3) goto L_0x018f
            r10[r1] = r17
        L_0x018f:
            int r2 = r1 - r13
            int r3 = r14 - r0
            if (r2 > r3) goto L_0x01ac
            if (r13 >= r1) goto L_0x01a8
            int r2 = r15 + 1
            io.netty.handler.codec.compression.Bzip2DivSufSort$StackEntry r3 = new io.netty.handler.codec.compression.Bzip2DivSufSort$StackEntry
            r5 = r18
            r4 = 0
            r3.<init>(r0, r14, r5, r4)
            r11[r15] = r3
            r14 = r1
        L_0x01a4:
            r15 = r2
        L_0x01a5:
            r0 = r5
            goto L_0x001b
        L_0x01a8:
            r5 = r18
            r13 = r0
            goto L_0x01a5
        L_0x01ac:
            r5 = r18
            r4 = 0
            if (r0 >= r14) goto L_0x01bc
            int r2 = r15 + 1
            io.netty.handler.codec.compression.Bzip2DivSufSort$StackEntry r3 = new io.netty.handler.codec.compression.Bzip2DivSufSort$StackEntry
            r3.<init>(r13, r1, r5, r4)
            r11[r15] = r3
            r13 = r0
            goto L_0x01a4
        L_0x01bc:
            r14 = r1
            goto L_0x01a5
        L_0x01be:
            r4 = 0
            if (r15 != 0) goto L_0x01c2
            return
        L_0x01c2:
            int r15 = r15 + -1
            r0 = r11[r15]
            int r13 = r0.f3686a
            int r14 = r0.b
            int r0 = r0.c
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.lsIntroSort(int, int, int, int, int):void");
    }

    private void lsSort(int i, int i2, int i3) {
        int i4;
        int[] iArr = this.SA;
        int i5 = i3 + i;
        while (true) {
            int i6 = 0;
            if ((-i2) < iArr[0]) {
                int i7 = 0;
                int i8 = 0;
                do {
                    int i9 = iArr[i8];
                    if (i9 < 0) {
                        i8 -= i9;
                        i7 += i9;
                        continue;
                    } else {
                        if (i7 != 0) {
                            iArr[i8 + i7] = i7;
                            i4 = 0;
                        } else {
                            i4 = i7;
                        }
                        int i10 = iArr[i9 + i] + 1;
                        lsIntroSort(i, i5, i + i2, i8, i10);
                        i7 = i4;
                        i8 = i10;
                        continue;
                    }
                } while (i8 < i2);
                if (i7 != 0) {
                    iArr[i8 + i7] = i7;
                }
                int i11 = i5 - i;
                if (i2 < i11) {
                    do {
                        int i12 = iArr[i6];
                        if (i12 < 0) {
                            i6 -= i12;
                            continue;
                        } else {
                            int i13 = iArr[i12 + i] + 1;
                            while (i6 < i13) {
                                iArr[iArr[i6] + i] = i6;
                                i6++;
                            }
                            i6 = i13;
                            continue;
                        }
                    } while (i6 < i2);
                    return;
                }
                i5 += i11;
            } else {
                return;
            }
        }
    }

    private void lsUpdateGroup(int i, int i2, int i3) {
        int i4;
        int[] iArr = this.SA;
        while (i2 < i3) {
            if (iArr[i2] >= 0) {
                int i5 = i2;
                do {
                    iArr[iArr[i5] + i] = i5;
                    i5++;
                    if (i5 >= i3 || iArr[i5] < 0) {
                        iArr[i2] = i2 - i5;
                    }
                    iArr[iArr[i5] + i] = i5;
                    i5++;
                    break;
                } while (iArr[i5] < 0);
                iArr[i2] = i2 - i5;
                if (i3 > i5) {
                    i2 = i5;
                } else {
                    return;
                }
            }
            int i6 = i2;
            while (true) {
                iArr[i6] = ~iArr[i6];
                i4 = i6 + 1;
                if (iArr[i4] >= 0) {
                    break;
                }
                i6 = i4;
            }
            do {
                iArr[iArr[i2] + i] = i4;
                i2++;
            } while (i2 <= i4);
            i2 = i6 + 2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        r16 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0213 A[LOOP:16: B:102:0x0213->B:105:0x021f, LOOP_START, PHI: r13 
      PHI: (r13v3 int) = (r13v2 int), (r13v4 int) binds: [B:101:0x0211, B:105:0x021f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0211 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int sortTypeBstar(int[] r29, int[] r30) {
        /*
            r28 = this;
            r10 = r28
            byte[] r11 = r10.T
            int[] r12 = r10.SA
            int r13 = r10.n
            r0 = 256(0x100, float:3.59E-43)
            int[] r1 = new int[r0]
            r14 = 1
            r2 = r14
        L_0x000e:
            r15 = 0
            r9 = 255(0xff, float:3.57E-43)
            if (r2 >= r13) goto L_0x0027
            int r3 = r2 + -1
            byte r3 = r11[r3]
            byte r4 = r11[r2]
            if (r3 == r4) goto L_0x0024
            r2 = r3 & 255(0xff, float:3.57E-43)
            r3 = r4 & 255(0xff, float:3.57E-43)
            if (r2 <= r3) goto L_0x0027
            r16 = r15
            goto L_0x0029
        L_0x0024:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0027:
            r16 = r14
        L_0x0029:
            int r17 = r13 + -1
            byte r2 = r11[r17]
            r3 = r2 & 255(0xff, float:3.57E-43)
            byte r4 = r11[r15]
            r5 = r4 & 255(0xff, float:3.57E-43)
            if (r3 < r5) goto L_0x003e
            if (r2 != r4) goto L_0x003a
            if (r16 == 0) goto L_0x003a
            goto L_0x003e
        L_0x003a:
            r2 = r13
            r3 = r17
            goto L_0x0072
        L_0x003e:
            if (r16 != 0) goto L_0x004e
            int r2 = BUCKET_BSTAR(r3, r5)
            r3 = r30[r2]
            int r3 = r3 + r14
            r30[r2] = r3
            int r2 = r13 + -1
            r12[r2] = r17
            goto L_0x0058
        L_0x004e:
            int r2 = BUCKET_B(r3, r5)
            r3 = r30[r2]
            int r3 = r3 + r14
            r30[r2] = r3
            r2 = r13
        L_0x0058:
            int r3 = r13 + -2
        L_0x005a:
            if (r3 < 0) goto L_0x0072
            byte r4 = r11[r3]
            r4 = r4 & r9
            int r5 = r3 + 1
            byte r5 = r11[r5]
            r5 = r5 & r9
            if (r4 > r5) goto L_0x0072
            int r4 = BUCKET_B(r4, r5)
            r5 = r30[r4]
            int r5 = r5 + r14
            r30[r4] = r5
            int r3 = r3 + -1
            goto L_0x005a
        L_0x0072:
            if (r3 < 0) goto L_0x00bc
        L_0x0074:
            byte r4 = r11[r3]
            r4 = r4 & r9
            r5 = r29[r4]
            int r5 = r5 + r14
            r29[r4] = r5
            int r4 = r3 + -1
            if (r4 < 0) goto L_0x008b
            byte r5 = r11[r4]
            r5 = r5 & r9
            byte r6 = r11[r3]
            r6 = r6 & r9
            if (r5 >= r6) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r3 = r4
            goto L_0x0074
        L_0x008b:
            if (r4 < 0) goto L_0x00ba
            byte r5 = r11[r4]
            r5 = r5 & r9
            byte r6 = r11[r3]
            r6 = r6 & r9
            int r5 = BUCKET_BSTAR(r5, r6)
            r6 = r30[r5]
            int r6 = r6 + r14
            r30[r5] = r6
            int r2 = r2 + -1
            r12[r2] = r4
            int r3 = r3 + -2
        L_0x00a2:
            if (r3 < 0) goto L_0x0072
            byte r4 = r11[r3]
            r4 = r4 & r9
            int r5 = r3 + 1
            byte r5 = r11[r5]
            r5 = r5 & r9
            if (r4 > r5) goto L_0x0072
            int r4 = BUCKET_B(r4, r5)
            r5 = r30[r4]
            int r5 = r5 + r14
            r30[r4] = r5
            int r3 = r3 + -1
            goto L_0x00a2
        L_0x00ba:
            r3 = r4
            goto L_0x0072
        L_0x00bc:
            int r8 = r13 - r2
            if (r8 != 0) goto L_0x00c9
            r0 = r15
        L_0x00c1:
            if (r0 >= r13) goto L_0x00c8
            r12[r0] = r0
            int r0 = r0 + 1
            goto L_0x00c1
        L_0x00c8:
            return r15
        L_0x00c9:
            r2 = -1
            r3 = r15
            r4 = r3
        L_0x00cc:
            if (r3 >= r0) goto L_0x00f9
            r5 = r29[r3]
            int r5 = r5 + r2
            int r2 = r2 + r4
            r29[r3] = r2
            int r2 = BUCKET_B(r3, r3)
            r2 = r30[r2]
            int r5 = r5 + r2
            int r2 = r3 + 1
            r6 = r2
        L_0x00de:
            if (r6 >= r0) goto L_0x00f6
            int r7 = BUCKET_BSTAR(r3, r6)
            r7 = r30[r7]
            int r4 = r4 + r7
            int r7 = r3 << 8
            r7 = r7 | r6
            r30[r7] = r4
            int r7 = BUCKET_B(r3, r6)
            r7 = r30[r7]
            int r5 = r5 + r7
            int r6 = r6 + 1
            goto L_0x00de
        L_0x00f6:
            r3 = r2
            r2 = r5
            goto L_0x00cc
        L_0x00f9:
            int r18 = r13 - r8
            int r2 = r8 + -2
        L_0x00fd:
            if (r2 < 0) goto L_0x0118
            int r3 = r18 + r2
            r3 = r12[r3]
            byte r4 = r11[r3]
            r4 = r4 & r9
            int r3 = r3 + r14
            byte r3 = r11[r3]
            r3 = r3 & r9
            int r3 = BUCKET_BSTAR(r4, r3)
            r4 = r30[r3]
            int r4 = r4 - r14
            r30[r3] = r4
            r12[r4] = r2
            int r2 = r2 + -1
            goto L_0x00fd
        L_0x0118:
            int r2 = r18 + r8
            int r2 = r2 - r14
            r2 = r12[r2]
            byte r3 = r11[r2]
            r3 = r3 & r9
            int r2 = r2 + r14
            byte r2 = r11[r2]
            r2 = r2 & r9
            int r2 = BUCKET_BSTAR(r3, r2)
            r3 = r30[r2]
            int r3 = r3 - r14
            r30[r2] = r3
            int r7 = r8 + -1
            r12[r3] = r7
            int r2 = r8 * 2
            int r2 = r13 - r2
            if (r2 > r0) goto L_0x013e
            r19 = r0
            r20 = r1
            r21 = r15
            goto L_0x0144
        L_0x013e:
            r19 = r2
            r21 = r8
            r20 = r12
        L_0x0144:
            r0 = r8
            r6 = r9
        L_0x0146:
            if (r0 <= 0) goto L_0x019d
            r3 = r0
            r5 = r9
        L_0x014a:
            if (r6 >= r5) goto L_0x0191
            int r0 = BUCKET_BSTAR(r6, r5)
            r22 = r30[r0]
            int r0 = r3 - r22
            if (r14 >= r0) goto L_0x017d
            r0 = r12[r22]
            if (r0 != r7) goto L_0x015d
            r23 = r14
            goto L_0x015f
        L_0x015d:
            r23 = r15
        L_0x015f:
            r24 = 2
            r0 = r28
            r1 = r18
            r2 = r22
            r4 = r20
            r25 = r5
            r5 = r21
            r26 = r6
            r6 = r19
            r27 = r7
            r7 = r24
            r15 = r8
            r8 = r23
            r9 = r13
            r0.subStringSort(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0184
        L_0x017d:
            r25 = r5
            r26 = r6
            r27 = r7
            r15 = r8
        L_0x0184:
            int r5 = r25 + -1
            r8 = r15
            r3 = r22
            r6 = r26
            r7 = r27
            r9 = 255(0xff, float:3.57E-43)
            r15 = 0
            goto L_0x014a
        L_0x0191:
            r26 = r6
            r27 = r7
            r15 = r8
            int r6 = r26 + -1
            r0 = r3
            r9 = 255(0xff, float:3.57E-43)
            r15 = 0
            goto L_0x0146
        L_0x019d:
            r27 = r7
            r15 = r8
        L_0x01a0:
            if (r7 < 0) goto L_0x01d9
            r0 = r12[r7]
            if (r0 < 0) goto L_0x01c0
            r0 = r7
        L_0x01a7:
            r1 = r12[r0]
            int r8 = r15 + r1
            r12[r8] = r0
            int r1 = r0 + -1
            if (r1 < 0) goto L_0x01b8
            r2 = r12[r1]
            if (r2 >= 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r0 = r1
            goto L_0x01a7
        L_0x01b8:
            int r2 = r1 - r7
            r12[r0] = r2
            if (r1 > 0) goto L_0x01bf
            goto L_0x01d9
        L_0x01bf:
            r7 = r1
        L_0x01c0:
            r0 = r7
        L_0x01c1:
            r1 = r12[r0]
            int r1 = ~r1
            r12[r0] = r1
            int r8 = r15 + r1
            r12[r8] = r7
            int r1 = r0 + -1
            r2 = r12[r1]
            if (r2 < 0) goto L_0x01d7
            int r8 = r15 + r2
            r12[r8] = r7
            int r7 = r0 + -2
            goto L_0x01a0
        L_0x01d7:
            r0 = r1
            goto L_0x01c1
        L_0x01d9:
            r10.trSort(r15, r15, r14)
            byte r0 = r11[r17]
            r1 = r0 & 255(0xff, float:3.57E-43)
            r2 = 0
            byte r2 = r11[r2]
            r3 = r2 & 255(0xff, float:3.57E-43)
            if (r1 < r3) goto L_0x01f2
            if (r0 != r2) goto L_0x01ec
            if (r16 == 0) goto L_0x01ec
            goto L_0x01f2
        L_0x01ec:
            r8 = r15
            r13 = r17
        L_0x01ef:
            r1 = 255(0xff, float:3.57E-43)
            goto L_0x0211
        L_0x01f2:
            if (r16 != 0) goto L_0x01fd
            int r8 = r15 + -1
            int r0 = r15 + r8
            r0 = r12[r0]
            r12[r0] = r17
            goto L_0x01fe
        L_0x01fd:
            r8 = r15
        L_0x01fe:
            int r13 = r13 + -2
        L_0x0200:
            if (r13 < 0) goto L_0x01ef
            byte r0 = r11[r13]
            r1 = 255(0xff, float:3.57E-43)
            r0 = r0 & r1
            int r2 = r13 + 1
            byte r2 = r11[r2]
            r2 = r2 & r1
            if (r0 > r2) goto L_0x0211
            int r13 = r13 + -1
            goto L_0x0200
        L_0x0211:
            if (r13 < 0) goto L_0x023b
        L_0x0213:
            int r13 = r13 + -1
            if (r13 < 0) goto L_0x0222
            byte r0 = r11[r13]
            r0 = r0 & r1
            int r2 = r13 + 1
            byte r2 = r11[r2]
            r2 = r2 & r1
            if (r0 < r2) goto L_0x0222
            goto L_0x0213
        L_0x0222:
            if (r13 < 0) goto L_0x0211
            int r8 = r8 + -1
            int r0 = r15 + r8
            r0 = r12[r0]
            r12[r0] = r13
        L_0x022c:
            int r13 = r13 + -1
            if (r13 < 0) goto L_0x0211
            byte r0 = r11[r13]
            r0 = r0 & r1
            int r2 = r13 + 1
            byte r2 = r11[r2]
            r2 = r2 & r1
            if (r0 > r2) goto L_0x0211
            goto L_0x022c
        L_0x023b:
            r9 = r1
            r7 = r27
        L_0x023e:
            if (r9 < 0) goto L_0x0289
            r0 = r1
        L_0x0241:
            if (r9 >= r0) goto L_0x0269
            int r2 = BUCKET_B(r9, r0)
            r2 = r30[r2]
            int r2 = r17 - r2
            int r3 = BUCKET_B(r9, r0)
            int r17 = r17 + 1
            r30[r3] = r17
            int r3 = BUCKET_BSTAR(r9, r0)
            r3 = r30[r3]
            r17 = r2
        L_0x025b:
            if (r3 > r7) goto L_0x0266
            r2 = r12[r7]
            r12[r17] = r2
            int r17 = r17 + -1
            int r7 = r7 + -1
            goto L_0x025b
        L_0x0266:
            int r0 = r0 + -1
            goto L_0x0241
        L_0x0269:
            int r0 = BUCKET_B(r9, r9)
            r0 = r30[r0]
            int r0 = r17 - r0
            int r2 = BUCKET_B(r9, r9)
            int r17 = r17 + 1
            r30[r2] = r17
            if (r9 >= r1) goto L_0x0284
            int r2 = r9 + 1
            int r2 = BUCKET_BSTAR(r9, r2)
            int r0 = r0 + r14
            r30[r2] = r0
        L_0x0284:
            r17 = r29[r9]
            int r9 = r9 + -1
            goto L_0x023e
        L_0x0289:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.sortTypeBstar(int[], int[]):int");
    }

    private static void ssBlockSwap(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        while (i3 > 0) {
            swapElements(iArr, i, iArr2, i2);
            i3--;
            i++;
            i2++;
        }
    }

    private int ssCompare(int i, int i2, int i3) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i4 = iArr[i + 1] + 2;
        int i5 = iArr[i2 + 1] + 2;
        int i6 = iArr[i] + i3;
        int i7 = i3 + iArr[i2];
        while (i6 < i4 && i7 < i5 && bArr[i6] == bArr[i7]) {
            i6++;
            i7++;
        }
        if (i6 >= i4) {
            return i7 < i5 ? -1 : 0;
        }
        if (i7 < i5) {
            return (bArr[i6] & 255) - (bArr[i7] & 255);
        }
        return 1;
    }

    private int ssCompareLast(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = iArr[i2] + i4;
        int i7 = i4 + iArr[i3];
        int i8 = iArr[i3 + 1] + 2;
        while (i6 < i5 && i7 < i8 && bArr[i6] == bArr[i7]) {
            i6++;
            i7++;
        }
        if (i6 < i5) {
            if (i7 < i8) {
                return (bArr[i6] & 255) - (bArr[i7] & 255);
            }
            return 1;
        } else if (i7 == i8) {
            return 1;
        } else {
            int i9 = i6 % i5;
            int i10 = iArr[i] + 2;
            while (i9 < i10 && i7 < i8 && bArr[i9] == bArr[i7]) {
                i9++;
                i7++;
            }
            if (i9 >= i10) {
                return i7 < i8 ? -1 : 0;
            }
            if (i7 < i8) {
                return (bArr[i9] & 255) - (bArr[i7] & 255);
            }
            return 1;
        }
    }

    private void ssFixdown(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = iArr[i3 + i4];
        byte b = bArr[iArr[i2 + i6] + i] & 255;
        while (true) {
            int i7 = i4 * 2;
            int i8 = i7 + 1;
            if (i8 >= i5) {
                break;
            }
            int i9 = i7 + 2;
            byte b2 = bArr[iArr[iArr[i3 + i8] + i2] + i] & 255;
            byte b3 = bArr[iArr[iArr[i3 + i9] + i2] + i] & 255;
            if (b2 < b3) {
                b2 = b3;
            } else {
                i9 = i8;
            }
            if (b2 <= b) {
                break;
            }
            iArr[i4 + i3] = iArr[i3 + i9];
            i4 = i9;
        }
        iArr[i3 + i4] = i6;
    }

    private void ssHeapSort(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i3;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i7 = i4 % 2;
        if (i7 == 0) {
            int i8 = i4 - 1;
            int i9 = (i8 / 2) + i6;
            int i10 = i6 + i8;
            if ((bArr[iArr[iArr[i9] + i2] + i] & 255) < (bArr[iArr[iArr[i10] + i2] + i] & 255)) {
                swapElements(iArr, i10, iArr, i9);
            }
            i5 = i8;
        } else {
            i5 = i4;
        }
        for (int i11 = (i5 / 2) - 1; i11 >= 0; i11--) {
            ssFixdown(i, i2, i3, i11, i5);
        }
        if (i7 == 0) {
            swapElements(iArr, i3, iArr, i6 + i5);
            ssFixdown(i, i2, i3, 0, i5);
        }
        for (int i12 = i5 - 1; i12 > 0; i12--) {
            int i13 = iArr[i6];
            int i14 = i6 + i12;
            iArr[i6] = iArr[i14];
            ssFixdown(i, i2, i3, 0, i12);
            iArr[i14] = i13;
        }
    }

    private void ssInsertionSort(int i, int i2, int i3, int i4) {
        int ssCompare;
        int[] iArr = this.SA;
        for (int i5 = i3 - 2; i2 <= i5; i5--) {
            int i6 = iArr[i5];
            int i7 = i5 + 1;
            do {
                ssCompare = ssCompare(i + i6, iArr[i7] + i, i4);
                if (ssCompare <= 0) {
                    break;
                }
                do {
                    iArr[i7 - 1] = iArr[i7];
                    i7++;
                    if (i7 >= i3 || iArr[i7] >= 0) {
                    }
                    iArr[i7 - 1] = iArr[i7];
                    i7++;
                    break;
                } while (iArr[i7] >= 0);
                continue;
            } while (i3 > i7);
            if (ssCompare == 0) {
                iArr[i7] = ~iArr[i7];
            }
            iArr[i7 - 1] = i6;
        }
    }

    private static int ssLog(int i) {
        return (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int ssMedian3(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        byte b = bArr[iArr[iArr[i3] + i2] + i] & 255;
        byte b2 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        byte b3 = bArr[i + iArr[i2 + iArr[i5]]] & 255;
        if (b <= b2) {
            int i6 = i4;
            i4 = i3;
            i3 = i6;
            byte b4 = b2;
            b2 = b;
            b = b4;
        }
        return b > b3 ? b2 > b3 ? i4 : i5 : i3;
    }

    private int ssMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        byte b = bArr[iArr[iArr[i3] + i2] + i] & 255;
        byte b2 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        byte b3 = bArr[iArr[iArr[i5] + i2] + i] & 255;
        byte b4 = bArr[iArr[iArr[i6] + i2] + i] & 255;
        byte b5 = bArr[i + iArr[i2 + iArr[i7]]] & 255;
        if (b2 > b3) {
            int i8 = i5;
            i5 = i4;
            i4 = i8;
            byte b6 = b3;
            b3 = b2;
            b2 = b6;
        }
        if (b4 > b5) {
            byte b7 = b4;
            b4 = b5;
            b5 = b7;
        } else {
            int i9 = i7;
            i7 = i6;
            i6 = i9;
        }
        if (b2 > b4) {
            byte b8 = b3;
            b3 = b5;
            b5 = b8;
            int i10 = i6;
            i6 = i5;
            i5 = i10;
        } else {
            i4 = i7;
            b2 = b4;
        }
        if (b > b3) {
            int i11 = i5;
            i5 = i3;
            i3 = i11;
            byte b9 = b3;
            b3 = b;
            b = b9;
        }
        if (b > b2) {
            i4 = i3;
            b2 = b;
        } else {
            i6 = i5;
            b5 = b3;
        }
        return b5 > b2 ? i4 : i6;
    }

    private void ssMerge(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i;
        int i15 = i6;
        int i16 = i7;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i17 = i2;
        int i18 = i3;
        int i19 = i4;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            int i22 = i19 - i18;
            if (i22 <= i15) {
                if (i17 >= i18 || i18 >= i19) {
                    i13 = i19;
                } else {
                    i13 = i19;
                    ssMergeBackward(i, iArr, i5, i17, i18, i19, i7);
                }
                if ((i20 & 1) != 0) {
                    ssMergeCheckEqual(i14, i16, i17);
                }
                if ((i20 & 2) != 0) {
                    ssMergeCheckEqual(i14, i16, i13);
                }
                if (i21 != 0) {
                    i21--;
                    StackEntry stackEntry = stackEntryArr[i21];
                    i17 = stackEntry.f3686a;
                    i18 = stackEntry.b;
                    i8 = stackEntry.c;
                    i9 = stackEntry.d;
                } else {
                    return;
                }
            } else {
                int i23 = i19;
                int i24 = i18 - i17;
                if (i24 <= i15) {
                    if (i17 < i18) {
                        ssMergeForward(i, iArr, i5, i17, i18, i23, i7);
                    }
                    if ((i20 & 1) != 0) {
                        ssMergeCheckEqual(i14, i16, i17);
                    }
                    if ((i20 & 2) != 0) {
                        ssMergeCheckEqual(i14, i16, i23);
                    }
                    if (i21 != 0) {
                        i21--;
                        StackEntry stackEntry2 = stackEntryArr[i21];
                        i17 = stackEntry2.f3686a;
                        i18 = stackEntry2.b;
                        i8 = stackEntry2.c;
                        i9 = stackEntry2.d;
                    } else {
                        return;
                    }
                } else {
                    int min = Math.min(i24, i22);
                    int i25 = min >> 1;
                    int i26 = 0;
                    while (min > 0) {
                        if (ssCompare(getIDX(iArr2[i18 + i26 + i25]) + i14, getIDX(iArr2[((i18 - i26) - i25) - 1]) + i14, i16) < 0) {
                            i26 += i25 + 1;
                            i25 -= (min & 1) ^ 1;
                        }
                        min = i25;
                        i25 = min >> 1;
                    }
                    if (i26 > 0) {
                        int i27 = i18 - i26;
                        ssBlockSwap(iArr2, i27, iArr2, i18, i26);
                        int i28 = i18 + i26;
                        if (i28 < i23) {
                            if (iArr2[i28] < 0) {
                                i12 = i18;
                                while (iArr2[i12 - 1] < 0) {
                                    i12--;
                                }
                                iArr2[i28] = ~iArr2[i28];
                            } else {
                                i12 = i18;
                            }
                            i10 = i18;
                            while (iArr2[i10] < 0) {
                                i10++;
                            }
                            i19 = i12;
                            i11 = 1;
                        } else {
                            i10 = i18;
                            i19 = i10;
                            i11 = 0;
                        }
                        if (i19 - i17 <= i23 - i10) {
                            stackEntryArr[i21] = new StackEntry(i10, i28, i23, i11 | (i20 & 2));
                            i20 &= 1;
                            i18 = i27;
                            i21++;
                        } else {
                            if (i19 == i18 && i18 == i10) {
                                i11 <<= 1;
                            }
                            stackEntryArr[i21] = new StackEntry(i17, i27, i19, (i20 & 1) | (i11 & 2));
                            i20 = (i20 & 2) | (i11 & 1);
                            i18 = i28;
                            i21++;
                            i17 = i10;
                            i19 = i23;
                        }
                    } else {
                        if ((i20 & 1) != 0) {
                            ssMergeCheckEqual(i14, i16, i17);
                        }
                        ssMergeCheckEqual(i14, i16, i18);
                        if ((i20 & 2) != 0) {
                            ssMergeCheckEqual(i14, i16, i23);
                        }
                        if (i21 != 0) {
                            i21--;
                            StackEntry stackEntry3 = stackEntryArr[i21];
                            i17 = stackEntry3.f3686a;
                            i18 = stackEntry3.b;
                            i8 = stackEntry3.c;
                            i9 = stackEntry3.d;
                        } else {
                            return;
                        }
                    }
                }
            }
            i20 = i9;
        }
    }

    private void ssMergeBackward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int[] iArr2 = iArr;
        int i16 = i2;
        int i17 = i3;
        int i18 = i4;
        int[] iArr3 = this.SA;
        int i19 = i5 - i18;
        ssBlockSwap(iArr2, i16, iArr3, i18, i19);
        int i20 = (i16 + i19) - 1;
        int i21 = iArr2[i20];
        if (i21 < 0) {
            i7 = i + (~i21);
            z = true;
        } else {
            i7 = i + i21;
            z = false;
        }
        int i22 = i18 - 1;
        int i23 = iArr3[i22];
        if (i23 < 0) {
            z |= true;
            i23 = ~i23;
        }
        int i24 = i + i23;
        int i25 = i5 - 1;
        int i26 = iArr3[i25];
        int i27 = i6;
        while (true) {
            int ssCompare = ssCompare(i7, i24, i27);
            if (ssCompare > 0) {
                if (z && true) {
                    while (true) {
                        i14 = i25 - 1;
                        iArr3[i25] = iArr2[i20];
                        i15 = i20 - 1;
                        iArr2[i20] = iArr3[i14];
                        if (iArr2[i15] >= 0) {
                            break;
                        }
                        i20 = i15;
                        i25 = i14;
                    }
                    z = !z;
                    i20 = i15;
                    i25 = i14;
                }
                int i28 = i25 - 1;
                iArr3[i25] = iArr2[i20];
                if (i20 <= i16) {
                    iArr2[i20] = i26;
                    return;
                }
                int i29 = i20 - 1;
                iArr2[i20] = iArr3[i28];
                int i30 = iArr2[i29];
                if (i30 < 0) {
                    z |= true;
                    i30 = ~i30;
                }
                int i31 = i + i30;
                i20 = i29;
                i25 = i28;
                i7 = i31;
            } else if (ssCompare < 0) {
                if (z && true) {
                    while (true) {
                        i12 = i25 - 1;
                        iArr3[i25] = iArr3[i22];
                        i13 = i22 - 1;
                        iArr3[i22] = iArr3[i12];
                        if (iArr3[i13] >= 0) {
                            break;
                        }
                        i22 = i13;
                        i25 = i12;
                    }
                    z ^= true;
                    i22 = i13;
                    i25 = i12;
                }
                int i32 = i25 - 1;
                iArr3[i25] = iArr3[i22];
                int i33 = i22 - 1;
                iArr3[i22] = iArr3[i32];
                if (i33 < i17) {
                    while (i16 < i20) {
                        int i34 = i32 - 1;
                        iArr3[i32] = iArr2[i20];
                        iArr2[i20] = iArr3[i34];
                        i32 = i34;
                        i20--;
                    }
                    iArr3[i32] = iArr2[i20];
                    iArr2[i20] = i26;
                    return;
                }
                int i35 = iArr3[i33];
                if (i35 < 0) {
                    z |= true;
                    i35 = ~i35;
                }
                int i36 = i32;
                i24 = i + i35;
                i22 = i33;
                i25 = i36;
            } else {
                if (z && true) {
                    while (true) {
                        i10 = i25 - 1;
                        iArr3[i25] = iArr2[i20];
                        i11 = i20 - 1;
                        iArr2[i20] = iArr3[i10];
                        if (iArr2[i11] >= 0) {
                            break;
                        }
                        i20 = i11;
                        i25 = i10;
                    }
                    z = !z;
                    i20 = i11;
                    i25 = i10;
                }
                int i37 = i25 - 1;
                iArr3[i25] = ~iArr2[i20];
                if (i20 <= i16) {
                    iArr2[i20] = i26;
                    return;
                }
                int i38 = i20 - 1;
                iArr2[i20] = iArr3[i37];
                if (z && true) {
                    while (true) {
                        i8 = i37 - 1;
                        iArr3[i37] = iArr3[i22];
                        i9 = i22 - 1;
                        iArr3[i22] = iArr3[i8];
                        if (iArr3[i9] >= 0) {
                            break;
                        }
                        i22 = i9;
                        i37 = i8;
                    }
                    z ^= true;
                    i22 = i9;
                    i37 = i8;
                }
                int i39 = i37 - 1;
                iArr3[i37] = iArr3[i22];
                int i40 = i22 - 1;
                iArr3[i22] = iArr3[i39];
                if (i40 < i17) {
                    while (i16 < i38) {
                        int i41 = i39 - 1;
                        iArr3[i39] = iArr2[i38];
                        iArr2[i38] = iArr3[i41];
                        i39 = i41;
                        i38--;
                    }
                    iArr3[i39] = iArr2[i38];
                    iArr2[i38] = i26;
                    return;
                }
                int i42 = iArr2[i38];
                if (i42 < 0) {
                    z |= true;
                    i42 = ~i42;
                }
                int i43 = i + i42;
                int i44 = iArr3[i40];
                if (i44 < 0) {
                    z |= true;
                    i44 = ~i44;
                }
                i24 = i + i44;
                int i45 = i40;
                i7 = i43;
                i22 = i45;
                int i46 = i39;
                i20 = i38;
                i25 = i46;
            }
        }
    }

    private void ssMergeCheckEqual(int i, int i2, int i3) {
        int[] iArr = this.SA;
        if (iArr[i3] >= 0 && ssCompare(getIDX(iArr[i3 - 1]) + i, i + iArr[i3], i2) == 0) {
            iArr[i3] = ~iArr[i3];
        }
    }

    private void ssMergeForward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int[] iArr2 = this.SA;
        int i8 = i4 - i3;
        int i9 = (i2 + i8) - 1;
        ssBlockSwap(iArr, i2, iArr2, i3, i8);
        int i10 = iArr2[i3];
        while (true) {
            int ssCompare = ssCompare(iArr[i2] + i, iArr2[i4] + i, i6);
            if (ssCompare < 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i11 = i2 + 1;
                    iArr[i2] = iArr2[i7];
                    if (iArr[i11] >= 0) {
                        i2 = i11;
                        break;
                    } else {
                        i2 = i11;
                        i3 = i7;
                    }
                }
            } else if (ssCompare > 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr2[i4];
                    int i12 = i4 + 1;
                    iArr2[i4] = iArr2[i7];
                    if (i5 <= i12) {
                        while (i2 < i9) {
                            int i13 = i7 + 1;
                            iArr2[i7] = iArr[i2];
                            iArr[i2] = iArr2[i13];
                            i7 = i13;
                            i2++;
                        }
                        iArr2[i7] = iArr[i2];
                        iArr[i2] = i10;
                        return;
                    } else if (iArr2[i12] >= 0) {
                        i4 = i12;
                        break;
                    } else {
                        i4 = i12;
                        i3 = i7;
                    }
                }
            } else {
                iArr2[i4] = ~iArr2[i4];
                while (true) {
                    int i14 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i15 = i2 + 1;
                    iArr[i2] = iArr2[i14];
                    if (iArr[i15] >= 0) {
                        while (true) {
                            int i16 = i14 + 1;
                            iArr2[i14] = iArr2[i4];
                            int i17 = i4 + 1;
                            iArr2[i4] = iArr2[i16];
                            if (i5 <= i17) {
                                while (i15 < i9) {
                                    int i18 = i16 + 1;
                                    iArr2[i16] = iArr[i15];
                                    iArr[i15] = iArr2[i18];
                                    i16 = i18;
                                    i15++;
                                }
                                iArr2[i16] = iArr[i15];
                                iArr[i15] = i10;
                                return;
                            } else if (iArr2[i17] >= 0) {
                                i4 = i17;
                                int i19 = i15;
                                i3 = i16;
                                i2 = i19;
                                break;
                            } else {
                                i4 = i17;
                                i14 = i16;
                            }
                        }
                    } else {
                        i2 = i15;
                        i3 = i14;
                    }
                }
            }
            i3 = i7;
        }
    }

    private void ssMultiKeyIntroSort(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        byte b;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int ssLog;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int i13 = i;
        int[] iArr = bzip2DivSufSort.SA;
        byte[] bArr = bzip2DivSufSort.T;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i14 = i4;
        int ssLog2 = ssLog(i3 - i2);
        int i15 = 0;
        byte b2 = 0;
        int i16 = i2;
        int i17 = i3;
        while (true) {
            int i18 = i17 - i16;
            if (i18 <= 8) {
                if (1 < i18) {
                    bzip2DivSufSort.ssInsertionSort(i13, i16, i17, i14);
                }
                if (i15 != 0) {
                    i15--;
                    StackEntry stackEntry = stackEntryArr[i15];
                    int i19 = stackEntry.f3686a;
                    int i20 = stackEntry.b;
                    int i21 = stackEntry.c;
                    ssLog2 = stackEntry.d;
                    i16 = i19;
                    i17 = i20;
                    i14 = i21;
                } else {
                    return;
                }
            } else {
                int i22 = ssLog2 - 1;
                if (ssLog2 == 0) {
                    bzip2DivSufSort.ssHeapSort(i14, i13, i16, i18);
                }
                if (i22 < 0) {
                    byte b3 = bArr[iArr[iArr[i16] + i13] + i14] & 255;
                    int i23 = i16;
                    i16++;
                    while (i16 < i17) {
                        b2 = bArr[iArr[iArr[i16] + i13] + i14] & 255;
                        if (b2 != b3) {
                            if (1 < i16 - i23) {
                                break;
                            }
                            i23 = i16;
                            b3 = b2;
                        }
                        i16++;
                    }
                    if ((bArr[(iArr[iArr[i23] + i13] + i14) - 1] & 255) < b3) {
                        i23 = bzip2DivSufSort.ssSubstringPartition(i13, i23, i16, i14);
                    }
                    int i24 = i16 - i23;
                    int i25 = i17 - i16;
                    if (i24 <= i25) {
                        if (1 < i24) {
                            stackEntryArr[i15] = new StackEntry(i16, i17, i14, -1);
                            i14++;
                            ssLog = ssLog(i24);
                            i15++;
                        } else {
                            ssLog2 = -1;
                        }
                    } else if (1 < i25) {
                        stackEntryArr[i15] = new StackEntry(i23, i16, i14 + 1, ssLog(i24));
                        ssLog2 = -1;
                        i15++;
                    } else {
                        i14++;
                        ssLog = ssLog(i24);
                    }
                    int i26 = ssLog;
                    i17 = i16;
                    i16 = i23;
                    ssLog2 = i26;
                } else {
                    int ssPivot = bzip2DivSufSort.ssPivot(i14, i13, i16, i17);
                    byte b4 = bArr[iArr[iArr[ssPivot] + i13] + i14] & 255;
                    swapElements(iArr, i16, iArr, ssPivot);
                    int i27 = i16 + 1;
                    while (i27 < i17) {
                        b2 = bArr[iArr[iArr[i27] + i13] + i14] & 255;
                        if (b2 != b4) {
                            break;
                        }
                        i27++;
                    }
                    if (i27 < i17 && b2 < b4) {
                        i5 = i27;
                        while (true) {
                            i27++;
                            if (i27 >= i17 || (b2 = bArr[iArr[iArr[i27] + i13] + i14] & 255) > b4) {
                                break;
                            } else if (b2 == b4) {
                                swapElements(iArr, i27, iArr, i5);
                                i5++;
                            }
                        }
                    } else {
                        i5 = i27;
                    }
                    int i28 = i17 - 1;
                    while (i27 < i28) {
                        b2 = bArr[iArr[iArr[i28] + i13] + i14] & 255;
                        if (b2 != b4) {
                            break;
                        }
                        i28--;
                    }
                    if (i27 < i28 && b2 > b4) {
                        i6 = ssLog2;
                        i7 = i28;
                        while (true) {
                            i28--;
                            if (i27 >= i28 || (b2 = bArr[iArr[iArr[i28] + i13] + i14] & 255) < b4) {
                                break;
                            } else if (b2 == b4) {
                                swapElements(iArr, i28, iArr, i7);
                                i7--;
                            }
                        }
                    } else {
                        i6 = ssLog2;
                        i7 = i28;
                    }
                    while (i27 < i28) {
                        swapElements(iArr, i27, iArr, i28);
                        while (true) {
                            i27++;
                            if (i27 < i28 && (b2 = bArr[iArr[iArr[i27] + i13] + i14] & 255) <= b4) {
                                if (b2 == b4) {
                                    swapElements(iArr, i27, iArr, i5);
                                    i5++;
                                }
                            }
                        }
                        while (true) {
                            i28--;
                            if (i27 < i28 && (b2 = bArr[iArr[iArr[i28] + i13] + i14] & 255) >= b4) {
                                if (b2 == b4) {
                                    swapElements(iArr, i28, iArr, i7);
                                    i7--;
                                }
                            }
                        }
                    }
                    if (i5 <= i7) {
                        int i29 = i27 - 1;
                        b = b2;
                        int i30 = i5 - i16;
                        int i31 = i27 - i5;
                        if (i30 > i31) {
                            i30 = i31;
                        }
                        int i32 = i22;
                        int i33 = i16;
                        int i34 = i27;
                        int i35 = i27 - i30;
                        while (i30 > 0) {
                            swapElements(iArr, i33, iArr, i35);
                            i30--;
                            i33++;
                            i35++;
                        }
                        int i36 = i7 - i29;
                        int i37 = (i17 - i7) - 1;
                        if (i36 <= i37) {
                            i37 = i36;
                        }
                        int i38 = i17 - i37;
                        int i39 = i34;
                        while (i37 > 0) {
                            swapElements(iArr, i39, iArr, i38);
                            i37--;
                            i39++;
                            i38++;
                        }
                        int i40 = i16 + i31;
                        int i41 = i17 - i36;
                        int ssSubstringPartition = b4 <= (bArr[(iArr[iArr[i40] + i13] + i14) + -1] & 255) ? i40 : bzip2DivSufSort.ssSubstringPartition(i13, i40, i41, i14);
                        int i42 = i40 - i16;
                        int i43 = i17 - i41;
                        if (i42 <= i43) {
                            int i44 = i41 - ssSubstringPartition;
                            if (i43 <= i44) {
                                int i45 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(ssSubstringPartition, i41, i14 + 1, ssLog(i44));
                                i15 += 2;
                                i12 = i32;
                                stackEntryArr[i45] = new StackEntry(i41, i17, i14, i12);
                            } else {
                                i12 = i32;
                                if (i42 <= i44) {
                                    int i46 = i15 + 1;
                                    stackEntryArr[i15] = new StackEntry(i41, i17, i14, i12);
                                    i15 += 2;
                                    stackEntryArr[i46] = new StackEntry(ssSubstringPartition, i41, i14 + 1, ssLog(i44));
                                } else {
                                    int i47 = i15 + 1;
                                    stackEntryArr[i15] = new StackEntry(i41, i17, i14, i12);
                                    i9 = i15 + 2;
                                    stackEntryArr[i47] = new StackEntry(i16, i40, i14, i12);
                                    i10 = i14 + 1;
                                    ssLog2 = ssLog(i44);
                                }
                            }
                            b2 = b;
                            i17 = i40;
                            ssLog2 = i12;
                        } else {
                            int i48 = i32;
                            int i49 = i41 - ssSubstringPartition;
                            if (i42 <= i49) {
                                int i50 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(ssSubstringPartition, i41, i14 + 1, ssLog(i49));
                                i11 = i15 + 2;
                                stackEntryArr[i50] = new StackEntry(i16, i40, i14, i48);
                            } else if (i43 <= i49) {
                                int i51 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(i16, i40, i14, i48);
                                i11 = i15 + 2;
                                stackEntryArr[i51] = new StackEntry(ssSubstringPartition, i41, i14 + 1, ssLog(i49));
                            } else {
                                int i52 = i15 + 1;
                                stackEntryArr[i15] = new StackEntry(i16, i40, i14, i48);
                                i9 = i15 + 2;
                                stackEntryArr[i52] = new StackEntry(i41, i17, i14, i48);
                                i10 = i14 + 1;
                                ssLog2 = ssLog(i49);
                                bzip2DivSufSort = this;
                            }
                            bzip2DivSufSort = this;
                            i16 = i41;
                            ssLog2 = i48;
                        }
                        i17 = i41;
                        i16 = ssSubstringPartition;
                    } else {
                        b = b2;
                        if ((bArr[(iArr[iArr[i16] + i13] + i14) - 1] & 255) < b4) {
                            bzip2DivSufSort = this;
                            i16 = bzip2DivSufSort.ssSubstringPartition(i13, i16, i17, i14);
                            i8 = ssLog(i17 - i16);
                        } else {
                            bzip2DivSufSort = this;
                            i8 = i6;
                        }
                        i14++;
                    }
                    b2 = b;
                }
            }
        }
    }

    private int ssPivot(int i, int i2, int i3, int i4) {
        int i5 = i4 - i3;
        int i6 = i3 + (i5 / 2);
        if (i5 > 512) {
            int i7 = i5 >> 3;
            int i8 = i7 << 1;
            int i9 = i;
            int i10 = i4 - 1;
            return ssMedian3(i, i2, ssMedian3(i9, i2, i3, i3 + i7, i3 + i8), ssMedian3(i, i2, i6 - i7, i6, i6 + i7), ssMedian3(i9, i2, i10 - i8, i10 - i7, i10));
        } else if (i5 <= 32) {
            return ssMedian3(i, i2, i3, i6, i4 - 1);
        } else {
            int i11 = i5 >> 2;
            int i12 = i4 - 1;
            return ssMedian5(i, i2, i3, i3 + i11, i6, i12 - i11, i12);
        }
    }

    private int ssSubstringPartition(int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr = this.SA;
        int i6 = i2 - 1;
        while (true) {
            i6++;
            if (i6 < i3) {
                int i7 = iArr[i6];
                if (iArr[i + i7] + i4 >= iArr[i + i7 + 1] + 1) {
                    iArr[i6] = ~i7;
                }
            }
            do {
                i3--;
                if (i6 >= i3) {
                    break;
                }
                i5 = iArr[i3];
            } while (iArr[i + i5] + i4 < iArr[i5 + i + 1] + 1);
            if (i3 <= i6) {
                break;
            }
            int i8 = ~iArr[i3];
            iArr[i3] = iArr[i6];
            iArr[i6] = i8;
        }
        if (i2 < i6) {
            iArr[i2] = ~iArr[i2];
        }
        return i6;
    }

    private void subStringSort(int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, boolean z, int i7) {
        int i8;
        int[] iArr2;
        int i9;
        int i10 = i;
        int i11 = i3;
        int i12 = i6;
        int[] iArr3 = this.SA;
        int i13 = z ? i2 + 1 : i2;
        int i14 = 0;
        int i15 = i13;
        while (true) {
            int i16 = i15 + 1024;
            if (i16 >= i11) {
                break;
            }
            ssMultiKeyIntroSort(i10, i15, i16, i12);
            int i17 = i11 - i16;
            int i18 = i5;
            if (i17 <= i18) {
                iArr2 = iArr;
                i8 = i4;
                i9 = i18;
            } else {
                i9 = i17;
                i8 = i16;
                iArr2 = iArr3;
            }
            int i19 = i15;
            int i20 = 1024;
            int i21 = i14;
            while ((i21 & 1) != 0) {
                int i22 = i19 - i20;
                ssMerge(i, i22, i19, i19 + i20, iArr2, i8, i9, i6);
                i20 <<= 1;
                i21 >>>= 1;
                int i23 = i5;
                i19 = i22;
                i16 = i16;
            }
            i14++;
            i15 = i16;
        }
        ssMultiKeyIntroSort(i10, i15, i11, i12);
        int i24 = i15;
        int i25 = 1024;
        for (int i26 = i14; i26 != 0; i26 >>= 1) {
            if ((i26 & 1) != 0) {
                int i27 = i24 - i25;
                ssMerge(i, i27, i24, i3, iArr, i4, i5, i6);
                i24 = i27;
            }
            i25 <<= 1;
        }
        if (z) {
            int i28 = iArr3[i13 - 1];
            int i29 = 1;
            while (i13 < i11) {
                int i30 = iArr3[i13];
                if (i30 >= 0 && (i29 = ssCompareLast(i, i10 + i28, i10 + i30, i6, i7)) <= 0) {
                    break;
                }
                iArr3[i13 - 1] = iArr3[i13];
                i13++;
            }
            if (i29 == 0) {
                iArr3[i13] = ~iArr3[i13];
            }
            iArr3[i13 - 1] = i28;
        }
    }

    private static void swapElements(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr2[i2];
        iArr2[i2] = i3;
    }

    private void trCopy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = this.SA;
        int i8 = i5 - 1;
        int i9 = i4 - 1;
        while (i3 <= i9) {
            int i10 = iArr[i3] - i7;
            if (i10 < 0) {
                i10 += i2 - i;
            }
            int i11 = i + i10;
            if (iArr[i11] == i8) {
                i9++;
                iArr[i9] = i10;
                iArr[i11] = i9;
            }
            i3++;
        }
        int i12 = i6 - 1;
        int i13 = i9 + 1;
        while (i13 < i5) {
            int i14 = iArr[i12] - i7;
            if (i14 < 0) {
                i14 += i2 - i;
            }
            int i15 = i + i14;
            if (iArr[i15] == i8) {
                i5--;
                iArr[i5] = i14;
                iArr[i15] = i5;
            }
            i12--;
        }
    }

    private void trFixdown(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.SA;
        int i7 = iArr[i4 + i5];
        int trGetC = trGetC(i, i2, i3, i7);
        while (true) {
            int i8 = i5 * 2;
            int i9 = i8 + 1;
            if (i9 >= i6) {
                break;
            }
            int i10 = i8 + 2;
            int trGetC2 = trGetC(i, i2, i3, iArr[i4 + i9]);
            int trGetC3 = trGetC(i, i2, i3, iArr[i4 + i10]);
            if (trGetC2 < trGetC3) {
                trGetC2 = trGetC3;
            } else {
                i10 = i9;
            }
            if (trGetC2 <= trGetC) {
                break;
            }
            iArr[i5 + i4] = iArr[i4 + i10];
            i5 = i10;
        }
        iArr[i4 + i5] = i7;
    }

    private int trGetC(int i, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int[] iArr = this.SA;
        return i5 < i3 ? iArr[i5] : iArr[i + (((i2 - i) + i4) % (i3 - i))];
    }

    private void trHeapSort(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int[] iArr = this.SA;
        int i11 = i5 % 2;
        if (i11 == 0) {
            int i12 = i5 - 1;
            int i13 = (i12 / 2) + i10;
            int i14 = i10 + i12;
            if (trGetC(i7, i8, i9, iArr[i13]) < trGetC(i7, i8, i9, iArr[i14])) {
                swapElements(iArr, i14, iArr, i13);
            }
            i6 = i12;
        } else {
            i6 = i5;
        }
        for (int i15 = (i6 / 2) - 1; i15 >= 0; i15--) {
            trFixdown(i, i2, i3, i4, i15, i6);
        }
        if (i11 == 0) {
            swapElements(iArr, i10, iArr, i10 + i6);
            trFixdown(i, i2, i3, i4, 0, i6);
        }
        for (int i16 = i6 - 1; i16 > 0; i16--) {
            int i17 = iArr[i10];
            int i18 = i10 + i16;
            iArr[i10] = iArr[i18];
            trFixdown(i, i2, i3, i4, 0, i16);
            iArr[i18] = i17;
        }
    }

    private void trInsertionSort(int i, int i2, int i3, int i4, int i5) {
        int trGetC;
        int[] iArr = this.SA;
        for (int i6 = i4 + 1; i6 < i5; i6++) {
            int i7 = iArr[i6];
            int i8 = i6 - 1;
            do {
                trGetC = trGetC(i, i2, i3, i7) - trGetC(i, i2, i3, iArr[i8]);
                if (trGetC >= 0) {
                    break;
                }
                do {
                    iArr[i8 + 1] = iArr[i8];
                    i8--;
                    if (i4 > i8 || iArr[i8] >= 0) {
                    }
                    iArr[i8 + 1] = iArr[i8];
                    i8--;
                    break;
                } while (iArr[i8] >= 0);
                continue;
            } while (i8 >= i4);
            if (trGetC == 0) {
                iArr[i8] = ~iArr[i8];
            }
            iArr[i8 + 1] = i7;
        }
    }

    private void trIntroSort(int i, int i2, int i3, int i4, int i5, TRBudget tRBudget, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33 = i;
        int i34 = i3;
        TRBudget tRBudget2 = tRBudget;
        int i35 = i6;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i36 = i2;
        int i37 = i4;
        int i38 = i5;
        int trLog = trLog(i5 - i4);
        int i39 = 0;
        int i40 = 0;
        while (true) {
            int i41 = -1;
            if (trLog >= 0) {
                i8 = i39;
                int i42 = i37;
                i7 = 0;
                int i43 = i38;
                int i44 = i43 - i42;
                if (i44 > 8) {
                    int i45 = trLog - 1;
                    if (trLog != 0) {
                        int i46 = i44;
                        int i47 = trLog;
                        int i48 = i43;
                        int i49 = i42;
                        int i50 = i45;
                        int i51 = i49;
                        int i52 = i3;
                        int i53 = i51;
                        swapElements(iArr2, i53, iArr2, trPivot(i, i36, i3, i51, i48));
                        int trGetC = trGetC(i33, i36, i52, iArr2[i53]);
                        int i54 = i53 + 1;
                        while (true) {
                            if (i54 < i48) {
                                i9 = trGetC(i33, i36, i52, iArr2[i54]);
                                if (i9 != trGetC) {
                                    break;
                                }
                                i54++;
                                i40 = i9;
                            } else {
                                i9 = i40;
                                break;
                            }
                        }
                        if (i54 < i48 && i9 < trGetC) {
                            i10 = i9;
                            int i55 = 1;
                            i11 = i54;
                            while (true) {
                                i54 += i55;
                                if (i54 >= i48 || (i10 = trGetC(i33, i36, i52, iArr2[i54])) > trGetC) {
                                    break;
                                }
                                if (i10 == trGetC) {
                                    swapElements(iArr2, i54, iArr2, i11);
                                    i11++;
                                }
                                i55 = 1;
                            }
                        } else {
                            i10 = i9;
                            i11 = i54;
                        }
                        int i56 = i48 - 1;
                        while (i54 < i56) {
                            i10 = trGetC(i33, i36, i52, iArr2[i56]);
                            if (i10 != trGetC) {
                                break;
                            }
                            i56--;
                        }
                        if (i54 >= i56 || i10 <= trGetC) {
                            i13 = i11;
                            i40 = i10;
                            i12 = i56;
                        } else {
                            int i57 = i11;
                            int i58 = i56;
                            while (true) {
                                i56--;
                                if (i54 >= i56 || (i10 = trGetC(i33, i36, i52, iArr2[i56])) < trGetC) {
                                    i40 = i10;
                                    i12 = i58;
                                    i13 = i57;
                                } else if (i10 == trGetC) {
                                    swapElements(iArr2, i56, iArr2, i58);
                                    i58--;
                                }
                            }
                            i40 = i10;
                            i12 = i58;
                            i13 = i57;
                        }
                        while (i54 < i56) {
                            swapElements(iArr2, i54, iArr2, i56);
                            while (true) {
                                i54++;
                                int i59 = i56;
                                if (i54 < i56) {
                                    int trGetC2 = trGetC(i33, i36, i52, iArr2[i54]);
                                    if (trGetC2 > trGetC) {
                                        i40 = trGetC2;
                                        i56 = i59;
                                        break;
                                    }
                                    if (trGetC2 == trGetC) {
                                        swapElements(iArr2, i54, iArr2, i13);
                                        i13++;
                                    }
                                    i40 = trGetC2;
                                    i56 = i59;
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                i56--;
                                int i60 = i54;
                                if (i54 < i56) {
                                    int trGetC3 = trGetC(i33, i36, i52, iArr2[i56]);
                                    if (trGetC3 < trGetC) {
                                        i40 = trGetC3;
                                        i54 = i60;
                                        break;
                                    }
                                    if (trGetC3 == trGetC) {
                                        swapElements(iArr2, i56, iArr2, i12);
                                        i12--;
                                    }
                                    i40 = trGetC3;
                                    i54 = i60;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (i13 <= i12) {
                            int i61 = i54 - 1;
                            int i62 = i13 - i53;
                            int i63 = i54 - i13;
                            if (i62 > i63) {
                                i62 = i63;
                            }
                            int i64 = i54;
                            int i65 = i54 - i62;
                            int i66 = i62;
                            int i67 = i53;
                            while (i66 > 0) {
                                swapElements(iArr2, i67, iArr2, i65);
                                i66--;
                                i67++;
                                i65++;
                            }
                            int i68 = i12 - i61;
                            int i69 = (i48 - i12) - 1;
                            if (i68 <= i69) {
                                i69 = i68;
                            }
                            int i70 = i69;
                            int i71 = i48 - i69;
                            int i72 = i64;
                            while (i70 > 0) {
                                swapElements(iArr2, i72, iArr2, i71);
                                i70--;
                                i72++;
                                i71++;
                            }
                            i14 = i53 + i63;
                            int i73 = i48 - i68;
                            int trLog2 = iArr2[iArr2[i14] + i33] != trGetC ? trLog(i73 - i14) : -1;
                            int i74 = i14 - 1;
                            for (int i75 = i53; i75 < i14; i75++) {
                                iArr2[iArr2[i75] + i33] = i74;
                            }
                            if (i73 < i48) {
                                int i76 = i73 - 1;
                                for (int i77 = i14; i77 < i73; i77++) {
                                    iArr2[iArr2[i77] + i33] = i76;
                                }
                            }
                            int i78 = i14 - i53;
                            int i79 = i48 - i73;
                            if (i78 <= i79) {
                                int i80 = i73 - i14;
                                if (i79 <= i80) {
                                    iArr = iArr2;
                                    if (1 < i78) {
                                        stackEntryArr[i8] = new StackEntry(i36 + 1, i14, i73, trLog2);
                                        i17 = i50;
                                        stackEntryArr[i8 + 1] = new StackEntry(i36, i73, i48, i17);
                                        int i81 = i3;
                                        i15 = i8 + 2;
                                    } else {
                                        i17 = i50;
                                        if (1 < i79) {
                                            i18 = i8 + 1;
                                            stackEntryArr[i8] = new StackEntry(i36 + 1, i14, i73, trLog2);
                                            int i82 = i3;
                                            i53 = i73;
                                            i14 = i48;
                                        } else if (1 < i80) {
                                            i23 = i36 + 1;
                                            int i83 = i3;
                                            i24 = trLog2;
                                            i25 = i14;
                                            i21 = i8;
                                            iArr2 = iArr;
                                            i38 = i73;
                                        } else if (i8 != 0) {
                                            i15 = i8 - 1;
                                            StackEntry stackEntry = stackEntryArr[i15];
                                            i36 = stackEntry.f3686a;
                                            i53 = stackEntry.b;
                                            i14 = stackEntry.c;
                                            i16 = stackEntry.d;
                                            int i84 = i3;
                                        } else {
                                            return;
                                        }
                                    }
                                } else {
                                    iArr = iArr2;
                                    i17 = i50;
                                    if (i78 <= i80) {
                                        if (1 < i78) {
                                            stackEntryArr[i8] = new StackEntry(i36, i73, i48, i17);
                                            stackEntryArr[i8 + 1] = new StackEntry(i36 + 1, i14, i73, trLog2);
                                            int i85 = i3;
                                            i15 = i8 + 2;
                                        } else if (1 < i80) {
                                            i21 = i8 + 1;
                                            stackEntryArr[i8] = new StackEntry(i36, i73, i48, i17);
                                            i22 = i36 + 1;
                                            int i86 = i3;
                                            i24 = trLog2;
                                            i25 = i14;
                                            iArr2 = iArr;
                                            i38 = i73;
                                        } else {
                                            int i87 = i3;
                                            i53 = i73;
                                            i14 = i48;
                                            i16 = i17;
                                            i15 = i8;
                                        }
                                    } else if (1 < i80) {
                                        stackEntryArr[i8] = new StackEntry(i36, i73, i48, i17);
                                        i19 = i8 + 2;
                                        stackEntryArr[i8 + 1] = new StackEntry(i36, i53, i14, i17);
                                        i20 = i36 + 1;
                                        int i88 = i3;
                                        i24 = trLog2;
                                        i21 = i19;
                                        i25 = i14;
                                        iArr2 = iArr;
                                        i38 = i73;
                                    } else {
                                        i15 = i8 + 1;
                                        stackEntryArr[i8] = new StackEntry(i36, i73, i48, i17);
                                        int i89 = i3;
                                    }
                                }
                            } else {
                                iArr = iArr2;
                                i17 = i50;
                                int i90 = i73 - i14;
                                if (i78 <= i90) {
                                    if (1 < i79) {
                                        stackEntryArr[i8] = new StackEntry(i36 + 1, i14, i73, trLog2);
                                        stackEntryArr[i8 + 1] = new StackEntry(i36, i53, i14, i17);
                                        int i91 = i3;
                                        i18 = i8 + 2;
                                        i53 = i73;
                                    } else if (1 < i78) {
                                        i15 = i8 + 1;
                                        stackEntryArr[i8] = new StackEntry(i36 + 1, i14, i73, trLog2);
                                        int i892 = i3;
                                    } else if (1 < i90) {
                                        i23 = i36 + 1;
                                        int i832 = i3;
                                        i24 = trLog2;
                                        i25 = i14;
                                        i21 = i8;
                                        iArr2 = iArr;
                                        i38 = i73;
                                    } else {
                                        i18 = i8 + 1;
                                        stackEntryArr[i8] = new StackEntry(i36, i53, i48, i17);
                                        int i92 = i3;
                                    }
                                } else if (i79 <= i90) {
                                    if (1 < i79) {
                                        stackEntryArr[i8] = new StackEntry(i36, i53, i14, i17);
                                        stackEntryArr[i8 + 1] = new StackEntry(i36 + 1, i14, i73, trLog2);
                                        int i93 = i3;
                                        i53 = i73;
                                        i18 = i8 + 2;
                                    } else if (1 < i90) {
                                        i21 = i8 + 1;
                                        stackEntryArr[i8] = new StackEntry(i36, i53, i14, i17);
                                        i22 = i36 + 1;
                                        int i862 = i3;
                                        i24 = trLog2;
                                        i25 = i14;
                                        iArr2 = iArr;
                                        i38 = i73;
                                    } else {
                                        int i94 = i3;
                                        i16 = i17;
                                        i15 = i8;
                                    }
                                } else if (1 < i90) {
                                    stackEntryArr[i8] = new StackEntry(i36, i53, i14, i17);
                                    i19 = i8 + 2;
                                    stackEntryArr[i8 + 1] = new StackEntry(i36, i73, i48, i17);
                                    i20 = i36 + 1;
                                    int i882 = i3;
                                    i24 = trLog2;
                                    i21 = i19;
                                    i25 = i14;
                                    iArr2 = iArr;
                                    i38 = i73;
                                } else {
                                    i18 = i8 + 1;
                                    stackEntryArr[i8] = new StackEntry(i36, i53, i14, i17);
                                    int i822 = i3;
                                    i53 = i73;
                                }
                                i14 = i48;
                            }
                            i16 = i17;
                        } else {
                            iArr = iArr2;
                            if (!tRBudget2.update(i35, i46)) {
                                break;
                            }
                            i36++;
                            int i95 = i3;
                            i14 = i48;
                            i15 = i8;
                            i16 = i47;
                        }
                        iArr2 = iArr;
                    } else if (!tRBudget2.update(i35, i44)) {
                        break;
                    } else {
                        int i96 = i43;
                        trHeapSort(i, i36, i3, i42, i44);
                        int i97 = i96 - 1;
                        while (i42 < i97) {
                            int i98 = i3;
                            int i99 = i42;
                            int trGetC4 = trGetC(i33, i36, i98, iArr2[i97]);
                            i97--;
                            while (i99 <= i97 && trGetC(i33, i36, i98, iArr2[i97]) == trGetC4) {
                                iArr2[i97] = ~iArr2[i97];
                                i97--;
                            }
                            i40 = trGetC4;
                            i42 = i99;
                        }
                        int i100 = i42;
                        int i101 = i3;
                        i37 = i100;
                        i38 = i96;
                        i39 = i8;
                        trLog = -3;
                    }
                } else if (!tRBudget2.update(i35, i44)) {
                    break;
                } else {
                    trLog = -3;
                    int i102 = i43;
                    trInsertionSort(i, i36, i3, i42, i43);
                    i26 = i42;
                    i38 = i102;
                    i39 = i8;
                }
            } else if (trLog != -1) {
                int i103 = i39;
                int i104 = i37;
                int i105 = i38;
                if (trLog == -2) {
                    int i106 = i103 - 1;
                    StackEntry stackEntry2 = stackEntryArr[i106];
                    trCopy(i, i3, i104, stackEntry2.b, stackEntry2.c, i105, i36 - i33);
                    if (i106 != 0) {
                        i39 = i103 - 2;
                        StackEntry stackEntry3 = stackEntryArr[i39];
                        i36 = stackEntry3.f3686a;
                        i26 = stackEntry3.b;
                        i38 = stackEntry3.c;
                        trLog = stackEntry3.d;
                    } else {
                        return;
                    }
                } else {
                    if (iArr2[i104] >= 0) {
                        do {
                            iArr2[iArr2[i104] + i33] = i104;
                            i104++;
                            if (i104 >= i105) {
                                break;
                            }
                        } while (iArr2[i104] < 0);
                    }
                    if (i104 < i105) {
                        int i107 = i104;
                        while (true) {
                            iArr2[i107] = ~iArr2[i107];
                            i27 = i107 + 1;
                            i28 = iArr2[i27];
                            if (i28 >= 0) {
                                break;
                            }
                            i107 = i27;
                        }
                        if (iArr2[i33 + i28] != iArr2[i28 + i36]) {
                            i41 = trLog((i27 - i104) + 1);
                        }
                        trLog = i41;
                        i38 = i107 + 2;
                        if (i38 < i105) {
                            int i108 = i107 + 1;
                            for (int i109 = i104; i109 < i38; i109++) {
                                iArr2[iArr2[i109] + i33] = i108;
                            }
                        }
                        int i110 = i105 - i38;
                        if (i38 - i104 <= i110) {
                            i29 = i103 + 1;
                            stackEntryArr[i103] = new StackEntry(i36, i38, i105, -3);
                            i36++;
                            int i111 = i3;
                            i37 = i104;
                        } else if (1 < i110) {
                            i39 = i103 + 1;
                            stackEntryArr[i103] = new StackEntry(i36 + 1, i104, i38, trLog);
                            int i112 = i3;
                            trLog = -3;
                            int i113 = i105;
                            i37 = i38;
                            i38 = i113;
                        } else {
                            i36++;
                            int i114 = i3;
                            i37 = i104;
                            i29 = i103;
                        }
                    } else if (i103 != 0) {
                        i39 = i103 - 1;
                        StackEntry stackEntry4 = stackEntryArr[i39];
                        i36 = stackEntry4.f3686a;
                        i26 = stackEntry4.b;
                        i38 = stackEntry4.c;
                        trLog = stackEntry4.d;
                    } else {
                        return;
                    }
                }
            } else if (!tRBudget2.update(i35, i38 - i37)) {
                i8 = i39;
                i7 = 0;
                break;
            } else {
                int i115 = i36 - 1;
                int i116 = i38 - 1;
                int i117 = i39;
                int i118 = i38;
                int i119 = i37;
                int i120 = i37;
                int i121 = i118;
                int i122 = i115;
                PartitionResult trPartition = trPartition(i, i115, i3, i119, i121, i116);
                int i123 = trPartition.first;
                int i124 = trPartition.last;
                if (i120 < i123 || i124 < i121) {
                    if (i123 < i121) {
                        int i125 = i123 - 1;
                        for (int i126 = i120; i126 < i123; i126++) {
                            iArr2[iArr2[i126] + i33] = i125;
                        }
                    }
                    if (i124 < i121) {
                        int i127 = i124 - 1;
                        for (int i128 = i123; i128 < i124; i128++) {
                            iArr2[iArr2[i128] + i33] = i127;
                        }
                    }
                    stackEntryArr[i117] = new StackEntry(0, i123, i124, 0);
                    int i129 = i117 + 2;
                    stackEntryArr[i117 + 1] = new StackEntry(i122, i120, i121, -2);
                    int i130 = i123 - i120;
                    int i131 = i121 - i124;
                    if (i130 <= i131) {
                        if (1 < i130) {
                            stackEntryArr[i129] = new StackEntry(i36, i124, i121, trLog(i131));
                            int trLog3 = trLog(i130);
                            i38 = i123;
                            i39 = i117 + 3;
                            i26 = i120;
                            trLog = trLog3;
                        } else if (1 < i131) {
                            trLog = trLog(i131);
                            i39 = i129;
                            i38 = i121;
                            i26 = i124;
                        } else if (i129 != 0) {
                            i39 = i117 + 1;
                            StackEntry stackEntry5 = stackEntryArr[i39];
                            i30 = stackEntry5.f3686a;
                            i31 = stackEntry5.b;
                            i38 = stackEntry5.c;
                            i32 = stackEntry5.d;
                        } else {
                            return;
                        }
                    } else if (1 < i131) {
                        stackEntryArr[i129] = new StackEntry(i36, i120, i123, trLog(i130));
                        int trLog4 = trLog(i131);
                        i38 = i121;
                        i39 = i117 + 3;
                        i26 = i124;
                        trLog = trLog4;
                    } else if (1 < i130) {
                        trLog = trLog(i130);
                        i38 = i123;
                        i39 = i129;
                        i26 = i120;
                    } else if (i129 != 0) {
                        i39 = i117 + 1;
                        StackEntry stackEntry6 = stackEntryArr[i39];
                        i30 = stackEntry6.f3686a;
                        i31 = stackEntry6.b;
                        i38 = stackEntry6.c;
                        i32 = stackEntry6.d;
                    } else {
                        return;
                    }
                } else {
                    while (i120 < i121) {
                        iArr2[iArr2[i120] + i33] = i120;
                        i120++;
                    }
                    if (i117 != 0) {
                        i39 = i117 - 1;
                        StackEntry stackEntry7 = stackEntryArr[i39];
                        i30 = stackEntry7.f3686a;
                        i31 = stackEntry7.b;
                        i38 = stackEntry7.c;
                        i32 = stackEntry7.d;
                    } else {
                        return;
                    }
                }
                trLog = i32;
                i36 = i30;
                i26 = i31;
            }
            int i132 = i3;
        }
        for (int i133 = i7; i133 < i8; i133++) {
            StackEntry stackEntry8 = stackEntryArr[i133];
            if (stackEntry8.d == -3) {
                lsUpdateGroup(i33, stackEntry8.b, stackEntry8.c);
            }
        }
    }

    private static int trLog(int i) {
        return (-65536 & i) != 0 ? (-16777216 & i) != 0 ? LOG_2_TABLE[(i >> 24) & 255] + 24 : LOG_2_TABLE[(i >> 16) & 271] : (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int trMedian3(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i, i2, i3, iArr[i4]);
        int trGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int trGetC3 = trGetC(i, i2, i3, iArr[i6]);
        if (trGetC <= trGetC2) {
            int i7 = i5;
            i5 = i4;
            i4 = i7;
            int i8 = trGetC2;
            trGetC2 = trGetC;
            trGetC = i8;
        }
        return trGetC > trGetC3 ? trGetC2 > trGetC3 ? i5 : i6 : i4;
    }

    private int trMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i, i2, i3, iArr[i4]);
        int trGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int trGetC3 = trGetC(i, i2, i3, iArr[i6]);
        int trGetC4 = trGetC(i, i2, i3, iArr[i7]);
        int trGetC5 = trGetC(i, i2, i3, iArr[i8]);
        if (trGetC2 > trGetC3) {
            int i9 = i6;
            i6 = i5;
            i5 = i9;
            int i10 = trGetC3;
            trGetC3 = trGetC2;
            trGetC2 = i10;
        }
        if (trGetC4 > trGetC5) {
            int i11 = trGetC4;
            trGetC4 = trGetC5;
            trGetC5 = i11;
        } else {
            int i12 = i8;
            i8 = i7;
            i7 = i12;
        }
        if (trGetC2 > trGetC4) {
            int i13 = trGetC3;
            trGetC3 = trGetC5;
            trGetC5 = i13;
            int i14 = i7;
            i7 = i6;
            i6 = i14;
        } else {
            i5 = i8;
            trGetC2 = trGetC4;
        }
        if (trGetC > trGetC3) {
            int i15 = i6;
            i6 = i4;
            i4 = i15;
            int i16 = trGetC3;
            trGetC3 = trGetC;
            trGetC = i16;
        }
        if (trGetC > trGetC2) {
            i5 = i4;
            trGetC2 = trGetC;
        } else {
            i7 = i6;
            trGetC5 = trGetC3;
        }
        return trGetC5 > trGetC2 ? i5 : i7;
    }

    private PartitionResult trPartition(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int trGetC;
        int trGetC2;
        int trGetC3;
        int[] iArr = this.SA;
        int i9 = 0;
        int i10 = i4;
        while (i10 < i5) {
            i9 = trGetC(i, i2, i3, iArr[i10]);
            if (i9 != i6) {
                break;
            }
            i10++;
        }
        if (i10 < i5 && i9 < i6) {
            i7 = i10;
            while (true) {
                i10++;
                if (i10 >= i5 || (i9 = trGetC(i, i2, i3, iArr[i10])) > i6) {
                    break;
                } else if (i9 == i6) {
                    swapElements(iArr, i10, iArr, i7);
                    i7++;
                }
            }
        } else {
            i7 = i10;
        }
        int i11 = i5 - 1;
        while (i10 < i11) {
            i9 = trGetC(i, i2, i3, iArr[i11]);
            if (i9 != i6) {
                break;
            }
            i11--;
        }
        if (i10 < i11 && i9 > i6) {
            i8 = i11;
            while (true) {
                i11--;
                if (i10 >= i11 || (trGetC3 = trGetC(i, i2, i3, iArr[i11])) < i6) {
                    break;
                } else if (trGetC3 == i6) {
                    swapElements(iArr, i11, iArr, i8);
                    i8--;
                }
            }
        } else {
            i8 = i11;
        }
        while (i10 < i11) {
            swapElements(iArr, i10, iArr, i11);
            while (true) {
                i10++;
                if (i10 < i11 && (trGetC2 = trGetC(i, i2, i3, iArr[i10])) <= i6) {
                    if (trGetC2 == i6) {
                        swapElements(iArr, i10, iArr, i7);
                        i7++;
                    }
                }
            }
            while (true) {
                i11--;
                if (i10 < i11 && (trGetC = trGetC(i, i2, i3, iArr[i11])) >= i6) {
                    if (trGetC == i6) {
                        swapElements(iArr, i11, iArr, i8);
                        i8--;
                    }
                }
            }
        }
        if (i7 <= i8) {
            int i12 = i10 - 1;
            int i13 = i7 - i4;
            int i14 = i10 - i7;
            if (i13 > i14) {
                i13 = i14;
            }
            int i15 = i10 - i13;
            int i16 = i4;
            while (i13 > 0) {
                swapElements(iArr, i16, iArr, i15);
                i13--;
                i16++;
                i15++;
            }
            int i17 = i8 - i12;
            int i18 = (i5 - i8) - 1;
            if (i17 <= i18) {
                i18 = i17;
            }
            int i19 = i5 - i18;
            while (i18 > 0) {
                swapElements(iArr, i10, iArr, i19);
                i18--;
                i10++;
                i19++;
            }
            i4 += i14;
            i5 -= i17;
        }
        return new PartitionResult(i4, i5);
    }

    private int trPivot(int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 - i4;
        int i7 = i4 + (i6 / 2);
        if (i6 > 512) {
            int i8 = i6 >> 3;
            int i9 = i8 << 1;
            int i10 = i;
            int i11 = i5 - 1;
            return trMedian3(i, i2, i3, trMedian3(i10, i2, i3, i4, i4 + i8, i4 + i9), trMedian3(i, i2, i3, i7 - i8, i7, i7 + i8), trMedian3(i10, i2, i3, i11 - i9, i11 - i8, i11));
        } else if (i6 <= 32) {
            return trMedian3(i, i2, i3, i4, i7, i5 - 1);
        } else {
            int i12 = i6 >> 2;
            int i13 = i5 - 1;
            return trMedian5(i, i2, i3, i4, i4 + i12, i7, i13 - i12, i13);
        }
    }

    private void trSort(int i, int i2, int i3) {
        int i4 = i2;
        int[] iArr = this.SA;
        if ((-i4) < iArr[0]) {
            TRBudget tRBudget = new TRBudget(i4, ((trLog(i2) * 2) / 3) + 1);
            int i5 = 0;
            do {
                int i6 = iArr[i5];
                if (i6 < 0) {
                    i5 -= i6;
                    continue;
                } else {
                    int i7 = iArr[i + i6] + 1;
                    if (1 < i7 - i5) {
                        trIntroSort(i, i + i3, i + i4, i5, i7, tRBudget, i2);
                        if (tRBudget.chance == 0) {
                            if (i5 > 0) {
                                iArr[0] = -i5;
                            }
                            lsSort(i, i2, i3);
                            return;
                        }
                    }
                    i5 = i7;
                    continue;
                }
            } while (i5 < i4);
        }
    }

    public int bwt() {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i = this.n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            iArr[0] = bArr[0];
            return 0;
        } else if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        } else {
            return 0;
        }
    }
}
