package com.honey.account.utils.encrypt;

import okio.Utf8;

public class Base64Coder {
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            map1[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            map1[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            map1[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char[] cArr = map1;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        int i2 = 0;
        while (true) {
            byte[] bArr = map2;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            map2[map1[i3]] = (byte) i3;
        }
    }

    private Base64Coder() {
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static String decodeString(String str) {
        return new String(decode(str));
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, bArr.length);
    }

    public static String encode2String(byte[] bArr) {
        return new String(encode(bArr, bArr.length));
    }

    public static String encodeString(String str) {
        return new String(encode(str.getBytes()));
    }

    public static byte[] decode(char[] cArr) {
        char c;
        int length = cArr.length;
        if (length % 4 == 0) {
            while (length > 0 && cArr[length - 1] == '=') {
                length--;
            }
            int i = (length * 3) / 4;
            byte[] bArr = new byte[i];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                char c2 = cArr[i2];
                int i4 = i2 + 2;
                char c3 = cArr[i2 + 1];
                char c4 = 'A';
                if (i4 < length) {
                    i2 += 3;
                    c = cArr[i4];
                } else {
                    i2 = i4;
                    c = 'A';
                }
                if (i2 < length) {
                    c4 = cArr[i2];
                    i2++;
                }
                if (c2 > 127 || c3 > 127 || c > 127 || c4 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = map2;
                byte b = bArr2[c2];
                byte b2 = bArr2[c3];
                byte b3 = bArr2[c];
                byte b4 = bArr2[c4];
                if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i5 = (b << 2) | (b2 >>> 4);
                int i6 = ((b2 & 15) << 4) | (b3 >>> 2);
                byte b5 = ((b3 & 3) << 6) | b4;
                int i7 = i3 + 1;
                bArr[i3] = (byte) i5;
                if (i7 < i) {
                    bArr[i7] = (byte) i6;
                    i7 = i3 + 2;
                }
                if (i7 < i) {
                    i3 = i7 + 1;
                    bArr[i7] = (byte) b5;
                } else {
                    i3 = i7;
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] encode(byte[] bArr, int i) {
        byte b;
        int i2;
        int i3;
        byte b2;
        int i4 = ((i * 4) + 2) / 3;
        char[] cArr = new char[(((i + 2) / 3) * 4)];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            int i7 = i5 + 1;
            byte b3 = bArr[i5];
            byte b4 = b3 & 255;
            if (i7 < i) {
                i2 = i5 + 2;
                b = bArr[i7] & 255;
            } else {
                i2 = i7;
                b = 0;
            }
            if (i2 < i) {
                i3 = i2 + 1;
                b2 = bArr[i2] & 255;
            } else {
                i3 = i2;
                b2 = 0;
            }
            int i8 = ((b3 & 3) << 4) | (b >>> 4);
            int i9 = ((b & 15) << 2) | (b2 >>> 6);
            byte b5 = b2 & Utf8.REPLACEMENT_BYTE;
            char[] cArr2 = map1;
            cArr[i6] = cArr2[b4 >>> 2];
            int i10 = i6 + 2;
            cArr[i6 + 1] = cArr2[i8];
            char c = '=';
            cArr[i10] = i10 < i4 ? cArr2[i9] : '=';
            int i11 = i6 + 3;
            if (i11 < i4) {
                c = cArr2[b5];
            }
            cArr[i11] = c;
            i6 += 4;
            i5 = i3;
        }
        return cArr;
    }
}
