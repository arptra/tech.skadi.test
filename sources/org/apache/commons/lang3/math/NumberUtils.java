package org.apache.commons.lang3.math;

import com.here.posclient.UpdateOptions;
import com.meizu.common.util.LunarCalendar;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_ZERO = 0;
    public static final Long LONG_INT_MAX_VALUE = Long.valueOf(UpdateOptions.SOURCE_ANY);
    public static final Long LONG_INT_MIN_VALUE = -2147483648L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_ZERO = 0L;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_ZERO = 0;

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (!StringUtils.isBlank(str)) {
            return new BigDecimal(str);
        }
        throw new NumberFormatException("A blank string is not a valid number");
    }

    public static BigInteger createBigInteger(String str) {
        int i;
        int i2;
        if (str == null) {
            return null;
        }
        boolean startsWith = str.startsWith(LunarCalendar.DATE_SEPARATOR);
        int i3 = 16;
        if (str.startsWith("0x", startsWith ? 1 : 0) || str.startsWith("0X", startsWith)) {
            i = startsWith + true;
        } else if (str.startsWith("#", startsWith)) {
            i = startsWith + true;
        } else if (!str.startsWith("0", startsWith) || str.length() <= (i2 = startsWith + true)) {
            i3 = 10;
            i = startsWith;
        } else {
            int i4 = i2;
            i3 = 8;
            i = i4;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i), i3);
        return startsWith ? bigInteger.negate() : bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:(1:58)(1:57)|59|(1:64)(1:63)|65|(5:67|(3:69|(2:71|(2:73|(1:75)))|(2:93|94)(3:87|88|89))|95|96|(1:102))|103|104|(1:110)|111|112|113) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:126|127|128) */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01a8, code lost:
        throw new java.lang.NumberFormatException(r0 + " is not a valid number.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01c5, code lost:
        return createLong(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01ca, code lost:
        return createBigInteger(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0122, code lost:
        if (r5 == 'l') goto L_0x0124;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x017a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x018f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:126:0x01c1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Number createNumber(java.lang.String r17) {
        /*
            r0 = r17
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r2 = org.apache.commons.lang3.StringUtils.isBlank(r17)
            if (r2 != 0) goto L_0x0228
            java.lang.String r7 = "#"
            java.lang.String r8 = "-#"
            java.lang.String r3 = "0x"
            java.lang.String r4 = "0X"
            java.lang.String r5 = "-0x"
            java.lang.String r6 = "-0X"
            java.lang.String[] r2 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
            int r3 = r17.length()
            r4 = 0
            r5 = r4
        L_0x0022:
            r6 = 6
            if (r5 >= r6) goto L_0x0035
            r6 = r2[r5]
            boolean r7 = r0.startsWith(r6)
            if (r7 == 0) goto L_0x0032
            int r2 = r6.length()
            goto L_0x0036
        L_0x0032:
            int r5 = r5 + 1
            goto L_0x0022
        L_0x0035:
            r2 = r4
        L_0x0036:
            if (r2 <= 0) goto L_0x006c
            r1 = r2
        L_0x0039:
            if (r2 >= r3) goto L_0x0048
            char r4 = r0.charAt(r2)
            r5 = 48
            if (r4 != r5) goto L_0x0048
            int r1 = r1 + 1
            int r2 = r2 + 1
            goto L_0x0039
        L_0x0048:
            int r3 = r3 - r1
            r1 = 16
            if (r3 > r1) goto L_0x0067
            r2 = 55
            if (r3 != r1) goto L_0x0054
            if (r4 <= r2) goto L_0x0054
            goto L_0x0067
        L_0x0054:
            r1 = 8
            if (r3 > r1) goto L_0x0062
            if (r3 != r1) goto L_0x005d
            if (r4 <= r2) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            java.lang.Integer r0 = createInteger(r17)
            return r0
        L_0x0062:
            java.lang.Long r0 = createLong(r17)
            return r0
        L_0x0067:
            java.math.BigInteger r0 = createBigInteger(r17)
            return r0
        L_0x006c:
            int r2 = r3 + -1
            char r5 = r0.charAt(r2)
            r6 = 46
            int r7 = r0.indexOf(r6)
            r8 = 101(0x65, float:1.42E-43)
            int r8 = r0.indexOf(r8)
            r9 = 69
            int r9 = r0.indexOf(r9)
            int r8 = r8 + r9
            int r9 = r8 + 1
            java.lang.String r10 = " is not a valid number."
            r11 = -1
            if (r7 <= r11) goto L_0x00b9
            if (r9 <= r11) goto L_0x00ae
            if (r9 < r7) goto L_0x0099
            if (r9 > r3) goto L_0x0099
            int r3 = r7 + 1
            java.lang.String r3 = r0.substring(r3, r9)
            goto L_0x00b4
        L_0x0099:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00ae:
            int r3 = r7 + 1
            java.lang.String r3 = r0.substring(r3)
        L_0x00b4:
            java.lang.String r7 = getMantissa(r0, r7)
            goto L_0x00de
        L_0x00b9:
            if (r9 <= r11) goto L_0x00d8
            if (r9 > r3) goto L_0x00c3
            java.lang.String r3 = getMantissa(r0, r9)
        L_0x00c1:
            r7 = r3
            goto L_0x00dd
        L_0x00c3:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00d8:
            java.lang.String r3 = getMantissa(r17)
            goto L_0x00c1
        L_0x00dd:
            r3 = r1
        L_0x00de:
            boolean r12 = java.lang.Character.isDigit(r5)
            r13 = 0
            r15 = 0
            r1 = 1
            if (r12 != 0) goto L_0x01a9
            if (r5 == r6) goto L_0x01a9
            if (r9 <= r11) goto L_0x00f7
            if (r9 >= r2) goto L_0x00f7
            int r8 = r8 + 2
            java.lang.String r6 = r0.substring(r8, r2)
            r16 = r6
            goto L_0x00f9
        L_0x00f7:
            r16 = 0
        L_0x00f9:
            java.lang.String r2 = r0.substring(r4, r2)
            boolean r6 = isAllZeros(r7)
            if (r6 == 0) goto L_0x010b
            boolean r6 = isAllZeros(r16)
            if (r6 == 0) goto L_0x010b
            r6 = r1
            goto L_0x010c
        L_0x010b:
            r6 = r4
        L_0x010c:
            r7 = 68
            if (r5 == r7) goto L_0x017a
            r7 = 70
            if (r5 == r7) goto L_0x0165
            r7 = 76
            if (r5 == r7) goto L_0x0124
            r7 = 100
            if (r5 == r7) goto L_0x017a
            r7 = 102(0x66, float:1.43E-43)
            if (r5 == r7) goto L_0x0165
            r6 = 108(0x6c, float:1.51E-43)
            if (r5 != r6) goto L_0x0194
        L_0x0124:
            if (r3 != 0) goto L_0x0150
            if (r16 != 0) goto L_0x0150
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0140
            char r3 = r2.charAt(r4)
            r4 = 45
            if (r3 != r4) goto L_0x0140
            java.lang.String r1 = r2.substring(r1)
            boolean r1 = isDigits(r1)
            if (r1 != 0) goto L_0x0146
        L_0x0140:
            boolean r1 = isDigits(r2)
            if (r1 == 0) goto L_0x0150
        L_0x0146:
            java.lang.Long r0 = createLong(r2)     // Catch:{ NumberFormatException -> 0x014b }
            return r0
        L_0x014b:
            java.math.BigInteger r0 = createBigInteger(r2)
            return r0
        L_0x0150:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0165:
            java.lang.Float r1 = createFloat(r17)     // Catch:{ NumberFormatException -> 0x017a }
            boolean r3 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x017a }
            if (r3 != 0) goto L_0x017a
            float r3 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x017a }
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x0179
            if (r6 == 0) goto L_0x017a
        L_0x0179:
            return r1
        L_0x017a:
            java.lang.Double r1 = createDouble(r17)     // Catch:{ NumberFormatException -> 0x018f }
            boolean r3 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x018f }
            if (r3 != 0) goto L_0x018f
            double r3 = r1.doubleValue()     // Catch:{ NumberFormatException -> 0x018f }
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x018e
            if (r6 == 0) goto L_0x018f
        L_0x018e:
            return r1
        L_0x018f:
            java.math.BigDecimal r0 = createBigDecimal(r2)     // Catch:{ NumberFormatException -> 0x0194 }
            return r0
        L_0x0194:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01a9:
            if (r9 <= r11) goto L_0x01b6
            if (r9 >= r2) goto L_0x01b6
            int r8 = r8 + 2
            java.lang.String r2 = r0.substring(r8)
            r16 = r2
            goto L_0x01b8
        L_0x01b6:
            r16 = 0
        L_0x01b8:
            if (r3 != 0) goto L_0x01cb
            if (r16 != 0) goto L_0x01cb
            java.lang.Integer r0 = createInteger(r17)     // Catch:{ NumberFormatException -> 0x01c1 }
            return r0
        L_0x01c1:
            java.lang.Long r0 = createLong(r17)     // Catch:{ NumberFormatException -> 0x01c6 }
            return r0
        L_0x01c6:
            java.math.BigInteger r0 = createBigInteger(r17)
            return r0
        L_0x01cb:
            boolean r2 = isAllZeros(r7)
            if (r2 == 0) goto L_0x01d8
            boolean r2 = isAllZeros(r16)
            if (r2 == 0) goto L_0x01d8
            r4 = r1
        L_0x01d8:
            java.lang.Float r1 = createFloat(r17)     // Catch:{ NumberFormatException -> 0x0223 }
            java.lang.Double r2 = createDouble(r17)     // Catch:{ NumberFormatException -> 0x0223 }
            boolean r3 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x0223 }
            if (r3 != 0) goto L_0x01ff
            float r3 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x0223 }
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x01f0
            if (r4 == 0) goto L_0x01ff
        L_0x01f0:
            java.lang.String r3 = r1.toString()     // Catch:{ NumberFormatException -> 0x0223 }
            java.lang.String r5 = r2.toString()     // Catch:{ NumberFormatException -> 0x0223 }
            boolean r3 = r3.equals(r5)     // Catch:{ NumberFormatException -> 0x0223 }
            if (r3 == 0) goto L_0x01ff
            return r1
        L_0x01ff:
            boolean r1 = r2.isInfinite()     // Catch:{ NumberFormatException -> 0x0223 }
            if (r1 != 0) goto L_0x0223
            double r5 = r2.doubleValue()     // Catch:{ NumberFormatException -> 0x0223 }
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 != 0) goto L_0x020f
            if (r4 == 0) goto L_0x0223
        L_0x020f:
            java.math.BigDecimal r1 = createBigDecimal(r17)     // Catch:{ NumberFormatException -> 0x0223 }
            double r3 = r2.doubleValue()     // Catch:{ NumberFormatException -> 0x0223 }
            java.math.BigDecimal r3 = java.math.BigDecimal.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0223 }
            int r0 = r1.compareTo(r3)     // Catch:{ NumberFormatException -> 0x0223 }
            if (r0 != 0) goto L_0x0222
            return r2
        L_0x0222:
            return r1
        L_0x0223:
            java.math.BigDecimal r0 = createBigDecimal(r17)
            return r0
        L_0x0228:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "A blank string is not a valid number"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return !str.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008d, code lost:
        if (r3 >= r0.length) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x008f, code lost:
        r0 = r0[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0091, code lost:
        if (r0 < '0') goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0093, code lost:
        if (r0 > '9') goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0095, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0096, code lost:
        if (r0 == 'e') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0098, code lost:
        if (r0 != 'E') goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x009b, code lost:
        if (r0 != '.') goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x009d, code lost:
        if (r16 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x009f, code lost:
        if (r15 == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a2, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a3, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a4, code lost:
        if (r13 != false) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a8, code lost:
        if (r0 == 'd') goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ac, code lost:
        if (r0 == 'D') goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ae, code lost:
        if (r0 == 'f') goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b0, code lost:
        if (r0 != 'F') goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b2, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00b5, code lost:
        if (r0 == 'l') goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00b9, code lost:
        if (r0 != 'L') goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00bc, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00bd, code lost:
        if (r14 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00bf, code lost:
        if (r15 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00c1, code lost:
        if (r16 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00c5, code lost:
        if (r13 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00c7, code lost:
        if (r14 == false) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCreatable(java.lang.String r17) {
        /*
            boolean r0 = org.apache.commons.lang3.StringUtils.isEmpty(r17)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            char[] r0 = r17.toCharArray()
            int r2 = r0.length
            char r3 = r0[r1]
            r4 = 43
            r5 = 45
            r6 = 1
            if (r3 == r5) goto L_0x001b
            if (r3 != r4) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r3 = r1
            goto L_0x001c
        L_0x001b:
            r3 = r6
        L_0x001c:
            int r7 = r3 + 1
            r8 = 70
            r9 = 102(0x66, float:1.43E-43)
            r10 = 57
            r11 = 46
            r12 = 48
            if (r2 <= r7) goto L_0x0078
            char r13 = r0[r3]
            if (r13 != r12) goto L_0x0078
            r13 = r17
            boolean r13 = org.apache.commons.lang3.StringUtils.contains((java.lang.CharSequence) r13, (int) r11)
            if (r13 != 0) goto L_0x0078
            char r13 = r0[r7]
            r14 = 120(0x78, float:1.68E-43)
            if (r13 == r14) goto L_0x0058
            r14 = 88
            if (r13 != r14) goto L_0x0041
            goto L_0x0058
        L_0x0041:
            boolean r13 = java.lang.Character.isDigit(r13)
            if (r13 == 0) goto L_0x0078
        L_0x0047:
            int r2 = r0.length
            if (r7 >= r2) goto L_0x0057
            char r2 = r0[r7]
            if (r2 < r12) goto L_0x0056
            r3 = 55
            if (r2 <= r3) goto L_0x0053
            goto L_0x0056
        L_0x0053:
            int r7 = r7 + 1
            goto L_0x0047
        L_0x0056:
            return r1
        L_0x0057:
            return r6
        L_0x0058:
            int r3 = r3 + 2
            if (r3 != r2) goto L_0x005d
            return r1
        L_0x005d:
            int r2 = r0.length
            if (r3 >= r2) goto L_0x0077
            char r2 = r0[r3]
            if (r2 < r12) goto L_0x0066
            if (r2 <= r10) goto L_0x0073
        L_0x0066:
            r4 = 97
            if (r2 < r4) goto L_0x006c
            if (r2 <= r9) goto L_0x0073
        L_0x006c:
            r4 = 65
            if (r2 < r4) goto L_0x0076
            if (r2 <= r8) goto L_0x0073
            goto L_0x0076
        L_0x0073:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x0076:
            return r1
        L_0x0077:
            return r6
        L_0x0078:
            int r7 = r2 + -1
            r13 = r1
            r14 = r13
            r15 = r14
            r16 = r15
        L_0x007f:
            r5 = 69
            r4 = 101(0x65, float:1.42E-43)
            if (r3 < r7) goto L_0x00cb
            if (r3 >= r2) goto L_0x008c
            if (r13 == 0) goto L_0x008c
            if (r14 != 0) goto L_0x008c
            goto L_0x00cb
        L_0x008c:
            int r2 = r0.length
            if (r3 >= r2) goto L_0x00c5
            char r0 = r0[r3]
            if (r0 < r12) goto L_0x0096
            if (r0 > r10) goto L_0x0096
            return r6
        L_0x0096:
            if (r0 == r4) goto L_0x00c4
            if (r0 != r5) goto L_0x009b
            goto L_0x00c4
        L_0x009b:
            if (r0 != r11) goto L_0x00a4
            if (r16 != 0) goto L_0x00a3
            if (r15 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            return r14
        L_0x00a3:
            return r1
        L_0x00a4:
            if (r13 != 0) goto L_0x00b3
            r2 = 100
            if (r0 == r2) goto L_0x00b2
            r2 = 68
            if (r0 == r2) goto L_0x00b2
            if (r0 == r9) goto L_0x00b2
            if (r0 != r8) goto L_0x00b3
        L_0x00b2:
            return r14
        L_0x00b3:
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 == r2) goto L_0x00bd
            r2 = 76
            if (r0 != r2) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            return r1
        L_0x00bd:
            if (r14 == 0) goto L_0x00c4
            if (r15 != 0) goto L_0x00c4
            if (r16 != 0) goto L_0x00c4
            r1 = r6
        L_0x00c4:
            return r1
        L_0x00c5:
            if (r13 != 0) goto L_0x00ca
            if (r14 == 0) goto L_0x00ca
            r1 = r6
        L_0x00ca:
            return r1
        L_0x00cb:
            char r6 = r0[r3]
            if (r6 < r12) goto L_0x00d8
            if (r6 > r10) goto L_0x00d8
            r13 = r1
            r4 = 43
            r5 = 45
            r14 = 1
            goto L_0x0108
        L_0x00d8:
            if (r6 != r11) goto L_0x00e7
            if (r16 != 0) goto L_0x00e6
            if (r15 == 0) goto L_0x00df
            goto L_0x00e6
        L_0x00df:
            r4 = 43
            r5 = 45
            r16 = 1
            goto L_0x0108
        L_0x00e6:
            return r1
        L_0x00e7:
            if (r6 == r4) goto L_0x00eb
            if (r6 != r5) goto L_0x00f0
        L_0x00eb:
            r4 = 43
            r5 = 45
            goto L_0x0100
        L_0x00f0:
            r4 = 43
            r5 = 45
            if (r6 == r4) goto L_0x00fa
            if (r6 != r5) goto L_0x00f9
            goto L_0x00fa
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r13 != 0) goto L_0x00fd
            return r1
        L_0x00fd:
            r13 = r1
            r14 = r13
            goto L_0x0108
        L_0x0100:
            if (r15 == 0) goto L_0x0103
            return r1
        L_0x0103:
            if (r14 != 0) goto L_0x0106
            return r1
        L_0x0106:
            r13 = 1
            r15 = 1
        L_0x0108:
            int r3 = r3 + 1
            r6 = 1
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.isCreatable(java.lang.String):boolean");
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) != '-') {
            return withDecimalsParsing(str, 0);
        }
        if (str.length() == 1) {
            return false;
        }
        return withDecimalsParsing(str, 1);
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return toScaledBigDecimal(bigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static short toShort(String str) {
        return toShort(str, 0);
    }

    private static void validateArray(Object obj) {
        Validate.notNull(obj, "array", new Object[0]);
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    private static boolean withDecimalsParsing(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            boolean z = str.charAt(i) == '.';
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    private static String getMantissa(String str, int i) {
        int i2 = 0;
        char charAt = str.charAt(0);
        if (charAt == '-' || charAt == '+') {
            i2 = 1;
        }
        return str.substring(i2, i);
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int i, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i, roundingMode);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return toDouble(bigDecimal, 0.0d);
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static double toDouble(BigDecimal bigDecimal, double d) {
        return bigDecimal == null ? d : bigDecimal.doubleValue();
    }

    public static BigDecimal toScaledBigDecimal(Float f) {
        return toScaledBigDecimal(f, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 < j) {
                j = j2;
            }
        }
        return j;
    }

    public static BigDecimal toScaledBigDecimal(Float f, int i, RoundingMode roundingMode) {
        if (f == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf((double) f.floatValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double d) {
        return toScaledBigDecimal(d, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 < i) {
                i = i3;
            }
        }
        return i;
    }

    public static BigDecimal toScaledBigDecimal(Double d, int i, RoundingMode roundingMode) {
        if (d == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(d.doubleValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String str) {
        return toScaledBigDecimal(str, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }

    public static BigDecimal toScaledBigDecimal(String str, int i, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(createBigDecimal(str), i, roundingMode);
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f2 = fArr[i];
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }
}
