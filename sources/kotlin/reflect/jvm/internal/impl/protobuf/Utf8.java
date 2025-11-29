package kotlin.reflect.jvm.internal.impl.protobuf;

import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;

final class Utf8 {
    private static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        if (r7[r8] > -65) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0083, code lost:
        if (r7[r6] > -65) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r7[r8] > -65) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
        /*
            if (r6 == 0) goto L_0x0086
            if (r8 < r9) goto L_0x0005
            return r6
        L_0x0005:
            byte r0 = (byte) r6
            r1 = -32
            r2 = -1
            r3 = -65
            if (r0 >= r1) goto L_0x001c
            r6 = -62
            if (r0 < r6) goto L_0x001b
            int r6 = r8 + 1
            byte r8 = r7[r8]
            if (r8 <= r3) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            r8 = r6
            goto L_0x0086
        L_0x001b:
            return r2
        L_0x001c:
            r4 = -16
            if (r0 >= r4) goto L_0x0049
            int r6 = r6 >> 8
            int r6 = ~r6
            byte r6 = (byte) r6
            if (r6 != 0) goto L_0x0034
            int r6 = r8 + 1
            byte r8 = r7[r8]
            if (r6 < r9) goto L_0x0031
            int r6 = incompleteStateFor(r0, r8)
            return r6
        L_0x0031:
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0034:
            if (r6 > r3) goto L_0x0048
            r4 = -96
            if (r0 != r1) goto L_0x003c
            if (r6 < r4) goto L_0x0048
        L_0x003c:
            r1 = -19
            if (r0 != r1) goto L_0x0042
            if (r6 >= r4) goto L_0x0048
        L_0x0042:
            int r6 = r8 + 1
            byte r8 = r7[r8]
            if (r8 <= r3) goto L_0x0018
        L_0x0048:
            return r2
        L_0x0049:
            int r1 = r6 >> 8
            int r1 = ~r1
            byte r1 = (byte) r1
            if (r1 != 0) goto L_0x005c
            int r6 = r8 + 1
            byte r1 = r7[r8]
            if (r6 < r9) goto L_0x005a
            int r6 = incompleteStateFor(r0, r1)
            return r6
        L_0x005a:
            r8 = 0
            goto L_0x0062
        L_0x005c:
            int r6 = r6 >> 16
            byte r6 = (byte) r6
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0062:
            if (r8 != 0) goto L_0x0072
            int r8 = r6 + 1
            byte r6 = r7[r6]
            if (r8 < r9) goto L_0x006f
            int r6 = incompleteStateFor((int) r0, (int) r1, (int) r6)
            return r6
        L_0x006f:
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0072:
            if (r1 > r3) goto L_0x0085
            int r0 = r0 << 28
            int r1 = r1 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto L_0x0085
            if (r8 > r3) goto L_0x0085
            int r8 = r6 + 1
            byte r6 = r7[r6]
            if (r6 <= r3) goto L_0x0086
        L_0x0085:
            return r2
        L_0x0086:
            int r6 = partialIsValidUtf8(r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.Utf8.partialIsValidUtf8(int, byte[], int, int):int");
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                i = i3;
            } else if (b < -32) {
                if (i3 >= i2) {
                    return b;
                }
                if (b >= -62) {
                    i += 2;
                    if (bArr[i3] > -65) {
                    }
                }
                return -1;
            } else if (b < -16) {
                if (i3 >= i2 - 1) {
                    return incompleteStateFor(bArr, i3, i2);
                }
                int i4 = i + 2;
                byte b2 = bArr[i3];
                if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                    i += 3;
                    if (bArr[i4] > -65) {
                    }
                }
                return -1;
            } else if (i3 >= i2 - 2) {
                return incompleteStateFor(bArr, i3, i2);
            } else {
                int i5 = i + 2;
                byte b3 = bArr[i3];
                if (b3 <= -65 && (((b << 28) + (b3 + RingSecurityPair.OPCODE_RING_PAIR)) >> 30) == 0) {
                    int i6 = i + 3;
                    if (bArr[i5] <= -65) {
                        i += 4;
                        if (bArr[i6] > -65) {
                        }
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    private static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return partialIsValidUtf8(bArr, i, i2) == 0;
    }

    private static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    private static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return incompleteStateFor(b);
        }
        if (i3 == 1) {
            return incompleteStateFor(b, bArr[i]);
        }
        if (i3 == 2) {
            return incompleteStateFor((int) b, (int) bArr[i], (int) bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i, i2);
    }
}
