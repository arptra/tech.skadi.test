package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;
import kotlin.jvm.internal.LongCompanionObject;

public final class NumberInput {
    static final long L_BILLION = 1000000000;
    static final String MAX_LONG_STR = String.valueOf(LongCompanionObject.MAX_VALUE);
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";

    private static NumberFormatException _badBD(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }

    public static boolean inLongRange(char[] cArr, int i, int i2, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        int i3 = 0;
        while (i3 < length) {
            int charAt = cArr[i + i3] - str.charAt(i3);
            if (charAt == 0) {
                i3++;
            } else if (charAt < 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static double parseAsDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return d;
        }
        try {
            return parseDouble(trim);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r5 = r5.trim();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseAsInt(java.lang.String r5, int r6) {
        /*
            if (r5 != 0) goto L_0x0003
            return r6
        L_0x0003:
            java.lang.String r5 = r5.trim()
            int r0 = r5.length()
            if (r0 != 0) goto L_0x000e
            return r6
        L_0x000e:
            r1 = 0
            if (r0 <= 0) goto L_0x0028
            char r2 = r5.charAt(r1)
            r3 = 43
            r4 = 1
            if (r2 != r3) goto L_0x0023
            java.lang.String r5 = r5.substring(r4)
            int r0 = r5.length()
            goto L_0x0028
        L_0x0023:
            r3 = 45
            if (r2 != r3) goto L_0x0028
            r1 = r4
        L_0x0028:
            if (r1 >= r0) goto L_0x0041
            char r2 = r5.charAt(r1)
            r3 = 57
            if (r2 > r3) goto L_0x003a
            r3 = 48
            if (r2 >= r3) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x0028
        L_0x003a:
            double r5 = parseDouble(r5)     // Catch:{ NumberFormatException -> 0x0040 }
            int r5 = (int) r5
            return r5
        L_0x0040:
            return r6
        L_0x0041:
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0046 }
            return r5
        L_0x0046:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseAsInt(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r5 = r5.trim();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long parseAsLong(java.lang.String r5, long r6) {
        /*
            if (r5 != 0) goto L_0x0003
            return r6
        L_0x0003:
            java.lang.String r5 = r5.trim()
            int r0 = r5.length()
            if (r0 != 0) goto L_0x000e
            return r6
        L_0x000e:
            r1 = 0
            if (r0 <= 0) goto L_0x0028
            char r2 = r5.charAt(r1)
            r3 = 43
            r4 = 1
            if (r2 != r3) goto L_0x0023
            java.lang.String r5 = r5.substring(r4)
            int r0 = r5.length()
            goto L_0x0028
        L_0x0023:
            r3 = 45
            if (r2 != r3) goto L_0x0028
            r1 = r4
        L_0x0028:
            if (r1 >= r0) goto L_0x0041
            char r2 = r5.charAt(r1)
            r3 = 57
            if (r2 > r3) goto L_0x003a
            r3 = 48
            if (r2 >= r3) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x0028
        L_0x003a:
            double r5 = parseDouble(r5)     // Catch:{ NumberFormatException -> 0x0040 }
            long r5 = (long) r5
            return r5
        L_0x0040:
            return r6
        L_0x0041:
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x0046 }
            return r5
        L_0x0046:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseAsLong(java.lang.String, long):long");
    }

    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw _badBD(str);
        }
    }

    public static double parseDouble(String str) throws NumberFormatException {
        if (NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    public static int parseInt(char[] cArr, int i, int i2) {
        int i3 = cArr[i] - '0';
        if (i2 > 4) {
            int i4 = i + 4;
            i3 = (((((((i3 * 10) + (cArr[i + 1] - '0')) * 10) + (cArr[i + 2] - '0')) * 10) + (cArr[i + 3] - '0')) * 10) + (cArr[i4] - '0');
            i2 -= 4;
            if (i2 > 4) {
                return (((((((i3 * 10) + (cArr[i + 5] - '0')) * 10) + (cArr[i + 6] - '0')) * 10) + (cArr[i + 7] - '0')) * 10) + (cArr[i + 8] - '0');
            }
            i = i4;
        }
        if (i2 <= 1) {
            return i3;
        }
        int i5 = (i3 * 10) + (cArr[i + 1] - '0');
        if (i2 <= 2) {
            return i5;
        }
        int i6 = (i5 * 10) + (cArr[i + 2] - '0');
        return i2 > 3 ? (i6 * 10) + (cArr[i + 3] - '0') : i6;
    }

    public static long parseLong(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (((long) parseInt(cArr, i, i3)) * L_BILLION) + ((long) parseInt(cArr, i + i3, 9));
    }

    public static BigDecimal parseBigDecimal(char[] cArr) throws NumberFormatException {
        return parseBigDecimal(cArr, 0, cArr.length);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return (long) parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        int i = 0;
        while (i < length) {
            int charAt = str.charAt(i) - str2.charAt(i);
            if (charAt == 0) {
                i++;
            } else if (charAt < 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i, i2);
        } catch (NumberFormatException unused) {
            throw _badBD(new String(cArr, i, i2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0072, code lost:
        return java.lang.Integer.parseInt(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseInt(java.lang.String r10) {
        /*
            r0 = 0
            char r1 = r10.charAt(r0)
            int r2 = r10.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto L_0x000f
            r0 = r4
        L_0x000f:
            r3 = 2
            r5 = 10
            if (r0 == 0) goto L_0x0024
            if (r2 == r4) goto L_0x001f
            if (r2 <= r5) goto L_0x0019
            goto L_0x001f
        L_0x0019:
            char r1 = r10.charAt(r4)
            r4 = r3
            goto L_0x002d
        L_0x001f:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x0024:
            r6 = 9
            if (r2 <= r6) goto L_0x002d
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x002d:
            r6 = 57
            if (r1 > r6) goto L_0x0081
            r7 = 48
            if (r1 >= r7) goto L_0x0036
            goto L_0x0081
        L_0x0036:
            int r1 = r1 - r7
            if (r4 >= r2) goto L_0x007d
            int r8 = r4 + 1
            char r9 = r10.charAt(r4)
            if (r9 > r6) goto L_0x0078
            if (r9 >= r7) goto L_0x0044
            goto L_0x0078
        L_0x0044:
            int r1 = r1 * 10
            int r9 = r9 - r7
            int r1 = r1 + r9
            if (r8 >= r2) goto L_0x007d
            int r4 = r4 + r3
            char r3 = r10.charAt(r8)
            if (r3 > r6) goto L_0x0073
            if (r3 >= r7) goto L_0x0054
            goto L_0x0073
        L_0x0054:
            int r1 = r1 * 10
            int r3 = r3 - r7
            int r1 = r1 + r3
            if (r4 >= r2) goto L_0x007d
        L_0x005a:
            int r3 = r4 + 1
            char r4 = r10.charAt(r4)
            if (r4 > r6) goto L_0x006e
            if (r4 >= r7) goto L_0x0065
            goto L_0x006e
        L_0x0065:
            int r1 = r1 * r5
            int r4 = r4 + -48
            int r1 = r1 + r4
            if (r3 < r2) goto L_0x006c
            goto L_0x007d
        L_0x006c:
            r4 = r3
            goto L_0x005a
        L_0x006e:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x0073:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x0078:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x007d:
            if (r0 == 0) goto L_0x0080
            int r1 = -r1
        L_0x0080:
            return r1
        L_0x0081:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseInt(java.lang.String):int");
    }
}
