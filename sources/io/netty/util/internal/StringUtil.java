package io.netty.util.internal;

import com.honey.account.constant.AccountConstantKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String[] BYTE2HEX_NOPAD = new String[256];
    private static final String[] BYTE2HEX_PAD = new String[256];
    public static final char CARRIAGE_RETURN = '\r';
    public static final char COMMA = ',';
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    public static final char DOUBLE_QUOTE = '\"';
    public static final String EMPTY_STRING = "";
    private static final byte[] HEX2B;
    public static final char LINE_FEED = '\n';
    public static final String NEWLINE = SystemPropertyUtil.get("line.separator", StringUtils.LF);
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final char SPACE = ' ';
    public static final char TAB = '\t';

    static {
        String str;
        int i = 0;
        while (true) {
            String[] strArr = BYTE2HEX_PAD;
            if (i < strArr.length) {
                String hexString = Integer.toHexString(i);
                if (i > 15) {
                    str = hexString;
                } else {
                    str = '0' + hexString;
                }
                strArr[i] = str;
                BYTE2HEX_NOPAD[i] = hexString;
                i++;
            } else {
                byte[] bArr = new byte[65536];
                HEX2B = bArr;
                Arrays.fill(bArr, (byte) -1);
                bArr[48] = 0;
                bArr[49] = 1;
                bArr[50] = 2;
                bArr[51] = 3;
                bArr[52] = 4;
                bArr[53] = 5;
                bArr[54] = 6;
                bArr[55] = 7;
                bArr[56] = 8;
                bArr[57] = 9;
                bArr[65] = 10;
                bArr[66] = 11;
                bArr[67] = 12;
                bArr[68] = 13;
                bArr[69] = 14;
                bArr[70] = 15;
                bArr[97] = 10;
                bArr[98] = 11;
                bArr[99] = 12;
                bArr[100] = 13;
                bArr[101] = 14;
                bArr[102] = 15;
                return;
            }
        }
    }

    private StringUtil() {
    }

    public static String byteToHexString(int i) {
        return BYTE2HEX_NOPAD[i & 255];
    }

    public static String byteToHexStringPadded(int i) {
        return BYTE2HEX_PAD[i & 255];
    }

    public static boolean commonSuffixOfLength(String str, String str2, int i) {
        return str != null && str2 != null && i >= 0 && str.regionMatches(str.length() - i, str2, str2.length() - i, i);
    }

    public static byte decodeHexByte(CharSequence charSequence, int i) {
        int decodeHexNibble = decodeHexNibble(charSequence.charAt(i));
        int decodeHexNibble2 = decodeHexNibble(charSequence.charAt(i + 1));
        if (decodeHexNibble != -1 && decodeHexNibble2 != -1) {
            return (byte) ((decodeHexNibble << 4) + decodeHexNibble2);
        }
        throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", new Object[]{charSequence.subSequence(i, i + 2), Integer.valueOf(i), charSequence}));
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i, int i2) {
        if (i2 < 0 || (i2 & 1) != 0) {
            throw new IllegalArgumentException("length: " + i2);
        } else if (i2 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        } else {
            byte[] bArr = new byte[(i2 >>> 1)];
            for (int i3 = 0; i3 < i2; i3 += 2) {
                bArr[i3 >>> 1] = decodeHexByte(charSequence, i + i3);
            }
            return bArr;
        }
    }

    public static int decodeHexNibble(char c) {
        return HEX2B[c];
    }

    public static boolean endsWith(CharSequence charSequence, char c) {
        int length = charSequence.length();
        return length > 0 && charSequence.charAt(length - 1) == c;
    }

    public static CharSequence escapeCsv(CharSequence charSequence) {
        return escapeCsv(charSequence, false);
    }

    private static int indexOfFirstNonOwsChar(CharSequence charSequence, int i) {
        int i2 = 0;
        while (i2 < i && isOws(charSequence.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    private static int indexOfLastNonOwsChar(CharSequence charSequence, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 > i && isOws(charSequence.charAt(i3))) {
            i3--;
        }
        return i3;
    }

    public static int indexOfNonWhiteSpace(CharSequence charSequence, int i) {
        while (i < charSequence.length()) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOfWhiteSpace(CharSequence charSequence, int i) {
        while (i < charSequence.length()) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static boolean isDoubleQuote(char c) {
        return c == '\"';
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isOws(char c) {
        return c == ' ' || c == 9;
    }

    public static boolean isSurrogate(char c) {
        return c >= 55296 && c <= 57343;
    }

    public static CharSequence join(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        ObjectUtil.checkNotNull(charSequence, "separator");
        ObjectUtil.checkNotNull(iterable, "elements");
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        CharSequence charSequence2 = (CharSequence) it.next();
        if (!it.hasNext()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        do {
            sb.append(charSequence);
            sb.append((CharSequence) it.next());
        } while (it.hasNext());
        return sb;
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence, int i) {
        return new IllegalArgumentException("invalid escaped CSV field: " + charSequence + " index: " + i);
    }

    public static String simpleClassName(Object obj) {
        if (obj == null) {
            return "null_object";
        }
        return simpleClassName(obj.getClass());
    }

    public static String substringAfter(String str, char c) {
        int indexOf = str.indexOf(c);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    public static String substringBefore(String str, char c) {
        int indexOf = str.indexOf(c);
        if (indexOf >= 0) {
            return str.substring(0, indexOf);
        }
        return null;
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexStringPadded(byte[] bArr) {
        return toHexStringPadded(bArr, 0, bArr.length);
    }

    public static CharSequence trimOws(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return charSequence;
        }
        int indexOfFirstNonOwsChar = indexOfFirstNonOwsChar(charSequence, length);
        int indexOfLastNonOwsChar = indexOfLastNonOwsChar(charSequence, indexOfFirstNonOwsChar, length);
        return (indexOfFirstNonOwsChar == 0 && indexOfLastNonOwsChar == length + -1) ? charSequence : charSequence.subSequence(indexOfFirstNonOwsChar, indexOfLastNonOwsChar + 1);
    }

    public static CharSequence unescapeCsv(CharSequence charSequence) {
        int length = ((CharSequence) ObjectUtil.checkNotNull(charSequence, AccountConstantKt.RESPONSE_VALUE)).length();
        if (length == 0) {
            return charSequence;
        }
        int i = length - 1;
        if (!isDoubleQuote(charSequence.charAt(0)) || !isDoubleQuote(charSequence.charAt(i)) || length == 1) {
            validateCsvFormat(charSequence);
            return charSequence;
        }
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int i2 = 1;
        while (i2 < i) {
            char charAt = charSequence.charAt(i2);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                if (!isDoubleQuote(charSequence.charAt(i3)) || i3 == i) {
                    throw newInvalidEscapedCsvFieldException(charSequence, i2);
                }
                i2 = i3;
            }
            stringBuilder.append(charAt);
            i2++;
        }
        return stringBuilder.toString();
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList(2);
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char charAt = charSequence.charAt(i);
            if (!z) {
                if (!(charAt == 10 || charAt == 13)) {
                    if (charAt != '\"') {
                        if (charAt != ',') {
                            stringBuilder.append(charAt);
                        } else {
                            arrayList.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                        }
                    } else if (stringBuilder.length() == 0) {
                        z = true;
                    }
                }
                throw newInvalidEscapedCsvFieldException(charSequence, i);
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else if (i == length) {
                arrayList.add(stringBuilder.toString());
                return arrayList;
            } else {
                int i2 = i + 1;
                char charAt2 = charSequence.charAt(i2);
                if (charAt2 == '\"') {
                    stringBuilder.append('\"');
                } else if (charAt2 == ',') {
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    z = false;
                } else {
                    throw newInvalidEscapedCsvFieldException(charSequence, i);
                }
                i = i2;
            }
            i++;
        }
        if (!z) {
            arrayList.add(stringBuilder.toString());
            return arrayList;
        }
        throw newInvalidEscapedCsvFieldException(charSequence, length);
    }

    private static void validateCsvFormat(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt == 10 || charAt == 13 || charAt == '\"' || charAt == ',') {
                throw newInvalidEscapedCsvFieldException(charSequence, i);
            }
        }
    }

    public static <T extends Appendable> T byteToHexString(T t, int i) {
        try {
            t.append(byteToHexString(i));
        } catch (IOException e) {
            PlatformDependent.throwException(e);
        }
        return t;
    }

    public static <T extends Appendable> T byteToHexStringPadded(T t, int i) {
        try {
            t.append(byteToHexStringPadded(i));
        } catch (IOException e) {
            PlatformDependent.throwException(e);
        }
        return t;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence escapeCsv(java.lang.CharSequence r7, boolean r8) {
        /*
            java.lang.String r0 = "value"
            java.lang.Object r0 = io.netty.util.internal.ObjectUtil.checkNotNull(r7, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 0
            r2 = 1
            if (r8 == 0) goto L_0x0019
            int r8 = indexOfFirstNonOwsChar(r7, r0)
            int r0 = indexOfLastNonOwsChar(r7, r8, r0)
            goto L_0x001b
        L_0x0019:
            int r0 = r0 - r2
            r8 = r1
        L_0x001b:
            if (r8 <= r0) goto L_0x0020
            java.lang.String r7 = ""
            return r7
        L_0x0020:
            char r3 = r7.charAt(r8)
            boolean r3 = isDoubleQuote(r3)
            r4 = -1
            if (r3 == 0) goto L_0x003e
            char r3 = r7.charAt(r0)
            boolean r3 = isDoubleQuote(r3)
            if (r3 == 0) goto L_0x0038
            if (r0 <= r8) goto L_0x0038
            r1 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x0043
            int r8 = r8 + 1
            int r0 = r0 + -1
        L_0x003e:
            r3 = r1
            r1 = r0
            r0 = r8
            r8 = r4
            goto L_0x0046
        L_0x0043:
            r3 = r1
            r1 = r0
            r0 = r8
        L_0x0046:
            if (r8 >= 0) goto L_0x00a5
            if (r3 == 0) goto L_0x0069
            r4 = r0
        L_0x004b:
            if (r4 > r1) goto L_0x0096
            char r5 = r7.charAt(r4)
            boolean r5 = isDoubleQuote(r5)
            if (r5 == 0) goto L_0x0067
            if (r4 == r1) goto L_0x0095
            int r5 = r4 + 1
            char r6 = r7.charAt(r5)
            boolean r6 = isDoubleQuote(r6)
            if (r6 != 0) goto L_0x0066
            goto L_0x0095
        L_0x0066:
            r4 = r5
        L_0x0067:
            int r4 = r4 + r2
            goto L_0x004b
        L_0x0069:
            r4 = r0
        L_0x006a:
            if (r4 > r1) goto L_0x0096
            char r5 = r7.charAt(r4)
            r6 = 10
            if (r5 == r6) goto L_0x0095
            r6 = 13
            if (r5 == r6) goto L_0x0095
            r6 = 44
            if (r5 != r6) goto L_0x007d
            goto L_0x0095
        L_0x007d:
            boolean r5 = isDoubleQuote(r5)
            if (r5 == 0) goto L_0x0093
            if (r4 == r1) goto L_0x0095
            int r5 = r4 + 1
            char r6 = r7.charAt(r5)
            boolean r6 = isDoubleQuote(r6)
            if (r6 != 0) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            r4 = r5
        L_0x0093:
            int r4 = r4 + r2
            goto L_0x006a
        L_0x0095:
            r8 = r4
        L_0x0096:
            if (r8 >= 0) goto L_0x00a5
            if (r3 == 0) goto L_0x00a2
            int r0 = r0 - r2
            int r1 = r1 + 2
        L_0x009d:
            java.lang.CharSequence r7 = r7.subSequence(r0, r1)
            goto L_0x00a4
        L_0x00a2:
            int r1 = r1 + r2
            goto L_0x009d
        L_0x00a4:
            return r7
        L_0x00a5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r4 = r1 - r0
            int r4 = r4 + 8
            r3.<init>(r4)
            r4 = 34
            r3.append(r4)
            r3.append(r7, r0, r8)
        L_0x00b6:
            if (r8 > r1) goto L_0x00d9
            char r0 = r7.charAt(r8)
            boolean r5 = isDoubleQuote(r0)
            if (r5 == 0) goto L_0x00d4
            r3.append(r4)
            if (r8 >= r1) goto L_0x00d4
            int r5 = r8 + 1
            char r6 = r7.charAt(r5)
            boolean r6 = isDoubleQuote(r6)
            if (r6 == 0) goto L_0x00d4
            r8 = r5
        L_0x00d4:
            r3.append(r0)
            int r8 = r8 + r2
            goto L_0x00b6
        L_0x00d9:
            r3.append(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.StringUtil.escapeCsv(java.lang.CharSequence, boolean):java.lang.CharSequence");
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexString(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static String toHexStringPadded(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexStringPadded(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > -1 ? name.substring(lastIndexOf + 1) : name;
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr) {
        return toHexString(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr) {
        return toHexStringPadded(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return t;
        }
        int i3 = i2 + i;
        int i4 = i3 - 1;
        while (i < i4 && bArr[i] == 0) {
            i++;
        }
        int i5 = i + 1;
        byteToHexString(t, bArr[i]);
        toHexStringPadded(t, bArr, i5, i3 - i5);
        return t;
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            byteToHexStringPadded(t, bArr[i]);
            i++;
        }
        return t;
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return decodeHexDump(charSequence, 0, charSequence.length());
    }
}
