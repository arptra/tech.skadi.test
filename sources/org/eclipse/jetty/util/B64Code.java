package org.eclipse.jetty.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

public class B64Code {
    static final char __pad = '=';
    static final char[] __rfc1421alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    static final byte[] __rfc1421nibbles = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            __rfc1421nibbles[i] = -1;
        }
        for (byte b = 0; b < 64; b = (byte) (b + 1)) {
            __rfc1421nibbles[(byte) __rfc1421alphabet[b]] = b;
        }
        __rfc1421nibbles[61] = 0;
    }

    public static String decode(String str, String str2) throws UnsupportedEncodingException {
        byte[] decode = decode(str);
        if (str2 == null) {
            return new String(decode);
        }
        return new String(decode, str2);
    }

    public static String encode(String str) {
        try {
            return encode(str, (String) null);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    public static String encode(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr;
        if (str2 == null) {
            bArr = str.getBytes("ISO-8859-1");
        } else {
            bArr = str.getBytes(str2);
        }
        return new String(encode(bArr));
    }

    public static byte[] decode(char[] cArr) {
        int i;
        int i2;
        byte[] bArr;
        byte b;
        int i3;
        if (cArr == null) {
            return null;
        }
        int length = cArr.length;
        if (length % 4 == 0) {
            int i4 = length - 1;
            while (i4 >= 0 && cArr[i4] == '=') {
                i4--;
            }
            int i5 = 0;
            if (i4 < 0) {
                return new byte[0];
            }
            int i6 = ((i4 + 1) * 3) / 4;
            byte[] bArr2 = new byte[i6];
            int i7 = (i6 / 3) * 3;
            int i8 = 0;
            while (i5 < i7) {
                try {
                    bArr = __rfc1421nibbles;
                    i2 = i8 + 1;
                } catch (IndexOutOfBoundsException unused) {
                    throw new IllegalArgumentException("char " + i8 + " was not B64 encoded");
                }
                try {
                    byte b2 = bArr[cArr[i8]];
                    int i9 = i8 + 2;
                    try {
                        b = bArr[cArr[i2]];
                        i3 = i8 + 3;
                    } catch (IndexOutOfBoundsException unused2) {
                        i8 = i9;
                        throw new IllegalArgumentException("char " + i8 + " was not B64 encoded");
                    }
                    try {
                        byte b3 = bArr[cArr[i9]];
                        i8 += 4;
                        byte b4 = bArr[cArr[i3]];
                        if (b2 < 0 || b < 0 || b3 < 0 || b4 < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        bArr2[i5] = (byte) ((b2 << 2) | (b >>> 4));
                        int i10 = i5 + 2;
                        bArr2[i5 + 1] = (byte) ((b << 4) | (b3 >>> 2));
                        i5 += 3;
                        bArr2[i10] = (byte) ((b3 << 6) | b4);
                    } catch (IndexOutOfBoundsException unused3) {
                        i8 = i3;
                        throw new IllegalArgumentException("char " + i8 + " was not B64 encoded");
                    }
                } catch (IndexOutOfBoundsException unused4) {
                    i8 = i2;
                    throw new IllegalArgumentException("char " + i8 + " was not B64 encoded");
                }
            }
            if (i6 != i5) {
                int i11 = i6 % 3;
                if (i11 == 1) {
                    byte[] bArr3 = __rfc1421nibbles;
                    i = i8 + 1;
                    byte b5 = bArr3[cArr[i8]];
                    i8 += 2;
                    byte b6 = bArr3[cArr[i]];
                    if (b5 < 0 || b6 < 0) {
                        throw new IllegalArgumentException("Not B64 encoded");
                    }
                    bArr2[i5] = (byte) ((b6 >>> 4) | (b5 << 2));
                } else if (i11 == 2) {
                    byte[] bArr4 = __rfc1421nibbles;
                    i = i8 + 1;
                    try {
                        byte b7 = bArr4[cArr[i8]];
                        i2 = i8 + 2;
                        byte b8 = bArr4[cArr[i]];
                        i8 += 3;
                        byte b9 = bArr4[cArr[i2]];
                        if (b7 < 0 || b8 < 0 || b9 < 0) {
                            throw new IllegalArgumentException("Not B64 encoded");
                        }
                        bArr2[i5] = (byte) ((b7 << 2) | (b8 >>> 4));
                        bArr2[i5 + 1] = (byte) ((b9 >>> 2) | (b8 << 4));
                    } catch (IndexOutOfBoundsException unused5) {
                        i8 = i;
                        throw new IllegalArgumentException("char " + i8 + " was not B64 encoded");
                    }
                }
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input block size is not 4");
    }

    public static char[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        char[] cArr = new char[(((length + 2) / 3) * 4)];
        int i = (length / 3) * 3;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            byte b = bArr[i2];
            int i4 = i2 + 2;
            byte b2 = bArr[i2 + 1];
            i2 += 3;
            byte b3 = bArr[i4];
            char[] cArr2 = __rfc1421alphabet;
            cArr[i3] = cArr2[(b >>> 2) & 63];
            cArr[i3 + 1] = cArr2[((b << 4) & 63) | ((b2 >>> 4) & 15)];
            int i5 = i3 + 3;
            cArr[i3 + 2] = cArr2[((b2 << 2) & 63) | ((b3 >>> 6) & 3)];
            i3 += 4;
            cArr[i5] = cArr2[b3 & Utf8.REPLACEMENT_BYTE];
        }
        if (length != i2) {
            int i6 = length % 3;
            if (i6 == 1) {
                byte b4 = bArr[i2];
                char[] cArr3 = __rfc1421alphabet;
                cArr[i3] = cArr3[(b4 >>> 2) & 63];
                cArr[i3 + 1] = cArr3[(b4 << 4) & 63];
                cArr[i3 + 2] = __pad;
                cArr[i3 + 3] = __pad;
            } else if (i6 == 2) {
                int i7 = i2 + 1;
                byte b5 = bArr[i2];
                byte b6 = bArr[i7];
                char[] cArr4 = __rfc1421alphabet;
                cArr[i3] = cArr4[(b5 >>> 2) & 63];
                cArr[i3 + 1] = cArr4[((b5 << 4) & 63) | ((b6 >>> 4) & 15)];
                cArr[i3 + 2] = cArr4[(b6 << 2) & 63];
                cArr[i3 + 3] = __pad;
            }
        }
        return cArr;
    }

    public static char[] encode(byte[] bArr, boolean z) {
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        if (!z) {
            return encode(bArr);
        }
        int length = bArr2.length;
        int i = ((length + 2) / 3) * 4;
        char[] cArr = new char[(i + ((i / 76) * 2) + 2)];
        int i2 = (length / 3) * 3;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            byte b = bArr2[i3];
            int i6 = i3 + 2;
            byte b2 = bArr2[i3 + 1];
            i3 += 3;
            byte b3 = bArr2[i6];
            char[] cArr2 = __rfc1421alphabet;
            cArr[i4] = cArr2[(b >>> 2) & 63];
            cArr[i4 + 1] = cArr2[((b << 4) & 63) | ((b2 >>> 4) & 15)];
            cArr[i4 + 2] = cArr2[((b2 << 2) & 63) | ((b3 >>> 6) & 3)];
            int i7 = i4 + 4;
            cArr[i4 + 3] = cArr2[b3 & Utf8.REPLACEMENT_BYTE];
            i5 += 4;
            if (i5 % 76 == 0) {
                int i8 = i4 + 5;
                cArr[i7] = 13;
                i4 += 6;
                cArr[i8] = 10;
            } else {
                i4 = i7;
            }
        }
        if (length != i3) {
            int i9 = length % 3;
            if (i9 == 1) {
                byte b4 = bArr2[i3];
                char[] cArr3 = __rfc1421alphabet;
                cArr[i4] = cArr3[(b4 >>> 2) & 63];
                cArr[i4 + 1] = cArr3[(b4 << 4) & 63];
                int i10 = i4 + 3;
                cArr[i4 + 2] = __pad;
                i4 += 4;
                cArr[i10] = __pad;
            } else if (i9 == 2) {
                int i11 = i3 + 1;
                byte b5 = bArr2[i3];
                byte b6 = bArr2[i11];
                char[] cArr4 = __rfc1421alphabet;
                cArr[i4] = cArr4[(b5 >>> 2) & 63];
                cArr[i4 + 1] = cArr4[((b5 << 4) & 63) | ((b6 >>> 4) & 15)];
                int i12 = i4 + 3;
                cArr[i4 + 2] = cArr4[(b6 << 2) & 63];
                i4 += 4;
                cArr[i12] = __pad;
            }
        }
        cArr[i4] = 13;
        cArr[i4 + 1] = 10;
        return cArr;
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() * 4) / 3);
        decode(str, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void decode(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (str != null) {
            if (byteArrayOutputStream != null) {
                byte[] bArr = new byte[4];
                int i = 0;
                int i2 = 0;
                while (i < str.length()) {
                    int i3 = i + 1;
                    char charAt = str.charAt(i);
                    if (charAt != '=') {
                        if (!Character.isWhitespace(charAt)) {
                            byte b = __rfc1421nibbles[charAt];
                            if (b >= 0) {
                                int i4 = i2 + 1;
                                bArr[i2] = b;
                                if (i4 == 2) {
                                    byteArrayOutputStream.write((bArr[1] >>> 4) | (bArr[0] << 2));
                                } else if (i4 == 3) {
                                    byteArrayOutputStream.write((bArr[1] << 4) | (bArr[2] >>> 2));
                                } else if (i4 == 4) {
                                    byteArrayOutputStream.write((bArr[2] << 6) | bArr[3]);
                                    i2 = 0;
                                }
                                i2 = i4;
                            } else {
                                throw new IllegalArgumentException("Not B64 encoded");
                            }
                        }
                        i = i3;
                    } else {
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("No outputstream for decoded bytes");
        }
    }

    public static void encode(int i, Appendable appendable) throws IOException {
        char[] cArr = __rfc1421alphabet;
        appendable.append(cArr[((-67108864 & i) >> 26) & 63]);
        appendable.append(cArr[((66060288 & i) >> 20) & 63]);
        appendable.append(cArr[((1032192 & i) >> 14) & 63]);
        appendable.append(cArr[((i & 16128) >> 8) & 63]);
        appendable.append(cArr[((i & 252) >> 2) & 63]);
        appendable.append(cArr[((i & 3) << 4) & 63]);
        appendable.append(__pad);
    }

    public static void encode(long j, Appendable appendable) throws IOException {
        int i = (int) ((j >> 32) & -4);
        char[] cArr = __rfc1421alphabet;
        appendable.append(cArr[((-67108864 & i) >> 26) & 63]);
        appendable.append(cArr[((66060288 & i) >> 20) & 63]);
        appendable.append(cArr[((1032192 & i) >> 14) & 63]);
        appendable.append(cArr[((i & 16128) >> 8) & 63]);
        appendable.append(cArr[((i & 252) >> 2) & 63]);
        appendable.append(cArr[(((i & 3) << 4) + (((int) (j >> 28)) & 15)) & 63]);
        int i2 = (int) j;
        appendable.append(cArr[((264241152 & i2) >> 22) & 63]);
        appendable.append(cArr[((4128768 & i2) >> 16) & 63]);
        appendable.append(cArr[((64512 & i2) >> 10) & 63]);
        appendable.append(cArr[((i2 & 1008) >> 4) & 63]);
        appendable.append(cArr[((i2 & 15) << 2) & 63]);
    }
}
