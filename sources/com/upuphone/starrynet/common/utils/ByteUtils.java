package com.upuphone.starrynet.common.utils;

import android.text.TextUtils;
import com.upuphone.starrynet.common.StLog;
import java.nio.ByteBuffer;

public class ByteUtils {
    public static final int BYTE_MAX = 255;
    public static final byte[] EMPTY_BYTES = new byte[0];
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final int INTEGER_LENGTH = 4;

    private ByteUtils() {
    }

    public static byte[] append(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte bitToByte(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        if (length == 4 || length == 8) {
            return (byte) Integer.parseInt(str, 2);
        }
        return 0;
    }

    public static boolean byteEquals(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || (length = bArr.length) != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String byteToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty(bArr)) {
            for (byte valueOf : bArr) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
            }
        }
        return sb.toString();
    }

    public static String byteToStringLittleEndian(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty(bArr)) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[length])}));
            }
        }
        return sb.toString();
    }

    public static byte[] charToByte(char c) {
        return new byte[]{(byte) ((65280 & c) >> 8), (byte) (c & 255)};
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static void copy(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr != null && bArr2 != null && i >= 0) {
            while (i2 < bArr2.length && i < bArr.length) {
                bArr[i] = bArr2[i2];
                i++;
                i2++;
            }
        }
    }

    public static int deepHashCode(byte[] bArr) {
        int i = 1;
        for (byte b : bArr) {
            i = (i * 31) + b;
        }
        return i;
    }

    public static boolean equals(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] fromHexString(String str) {
        char[] charArray = str.toUpperCase().toCharArray();
        int i = 0;
        for (char c : charArray) {
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) {
                i++;
            }
        }
        byte[] bArr = new byte[((i + 1) >> 1)];
        int i2 = i & 1;
        for (char c2 : charArray) {
            if (c2 < '0' || c2 > '9') {
                if (c2 >= 'A' && c2 <= 'F') {
                    int i3 = i2 >> 1;
                    byte b = (byte) (bArr[i3] << 4);
                    bArr[i3] = b;
                    bArr[i3] = (byte) ((c2 - '7') | b);
                }
            } else {
                int i4 = i2 >> 1;
                byte b2 = (byte) (bArr[i4] << 4);
                bArr[i4] = b2;
                bArr[i4] = (byte) ((c2 - '0') | b2);
            }
            i2++;
        }
        return bArr;
    }

    public static byte[] fromInt(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static byte[] fromLong(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) (j >>> (i * 8)));
        }
        return bArr;
    }

    public static byte[] fromShort(short s) {
        return new byte[]{(byte) s, (byte) (s >>> 8)};
    }

    public static byte[] get(byte[] bArr, int i) {
        return get(bArr, i, bArr.length - i);
    }

    public static byte[] getBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        if (i >= 0 && i < bArr.length && i2 >= 0 && i2 < bArr.length) {
            if (i > i2) {
                return null;
            }
            bArr2 = new byte[((i2 - i) + 1)];
            for (int i3 = i; i3 <= i2; i3++) {
                bArr2[i3 - i] = bArr[i3];
            }
        }
        return bArr2;
    }

    public static byte[] getNonEmptyByte(byte[] bArr) {
        return bArr != null ? bArr : EMPTY_BYTES;
    }

    public static String getText(byte[] bArr) {
        return new String(bArr);
    }

    public static boolean isAllFF(byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        for (int i = 0; i < length; i++) {
            if (ubyteToInt(bArr[i]) != 255) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllMin(byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        for (int i = 0; i < length; i++) {
            if (ubyteToInt(bArr[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean isNormalBytes(byte[] bArr) {
        return !isEmpty(bArr) && !isAllFF(bArr);
    }

    public static boolean isSameElement(byte[] bArr, byte b) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (b2 != b) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] split(byte[] bArr, int i) throws ArrayIndexOutOfBoundsException {
        if (i <= bArr.length) {
            byte[][] bArr2 = {new byte[i], new byte[(bArr.length - i)]};
            System.arraycopy(bArr, 0, bArr2[0], 0, i);
            System.arraycopy(bArr, i, bArr2[1], 0, bArr.length - i);
            return bArr2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static byte[] stringToBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[((length + 1) / 2)];
        int i = 0;
        while (i < length) {
            try {
                bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, Math.min(2, length - i) + i), 16);
                i += 2;
            } catch (Exception e) {
                StLog.e("ByteUtil", "stringToBytes", (Throwable) e);
                return EMPTY_BYTES;
            }
        }
        return bArr;
    }

    public static byte[] subArray(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }

    public static String toBinaryString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            for (int i2 = 0; i2 < 8; i2++) {
                sb.append((b >>> i2) & 1);
            }
            if (i != bArr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static char[] toCharArray(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return cArr;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            char[] cArr = HEX_CHARS;
            sb.append(cArr[(b >>> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    public static int toInt(byte[] bArr) {
        int i = 0;
        if (bArr.length != 4) {
            return 0;
        }
        int i2 = 0;
        while (i < 4) {
            int i3 = i + 1;
            i2 = (int) (((long) i2) + (((long) (bArr[i] << (i * 8))) & ((1 << (i3 * 8)) - 1)));
            i = i3;
        }
        return i2;
    }

    public static short toShort(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return ByteBuffer.wrap(bArr).getShort();
    }

    public static int ubyteToInt(byte b) {
        return b & 255;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr3[length] = (byte) (bArr[length] ^ bArr2[length]);
        }
        return bArr3;
    }

    public static int deepHashCode(byte[][] bArr) {
        int i = 1;
        for (byte[] deepHashCode : bArr) {
            i = (i * 31) + deepHashCode(deepHashCode);
        }
        return i;
    }

    public static byte[] get(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            z &= bArr[length] == bArr2[length];
        }
        return z;
    }

    public static byte[] subArray(byte[] bArr, int i) {
        return subArray(bArr, i, bArr.length);
    }

    public static boolean byteEquals(byte[] bArr, int i, byte[] bArr2) {
        int length;
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || i < 0 || i >= bArr.length || (length = (bArr2.length + i) - 1) < 0 || length >= bArr.length) {
            return false;
        }
        for (int i2 = i; i2 <= length; i2++) {
            if (bArr[i2] != bArr2[i2 - i]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] concatenate(byte[][] bArr) {
        int length = bArr[0].length;
        byte[] bArr2 = new byte[(bArr.length * length)];
        int i = 0;
        for (byte[] arraycopy : bArr) {
            System.arraycopy(arraycopy, 0, bArr2, i, length);
            i += length;
        }
        return bArr2;
    }

    public static int deepHashCode(byte[][][] bArr) {
        int i = 1;
        for (byte[][] deepHashCode : bArr) {
            i = (i * 31) + deepHashCode(deepHashCode);
        }
        return i;
    }

    public static boolean equals(byte[][] bArr, byte[][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            z &= equals(bArr[length], bArr2[length]);
        }
        return z;
    }

    public static String toHexString(byte[] bArr, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < bArr.length; i++) {
            char[] cArr = HEX_CHARS;
            sb.append(cArr[(bArr[i] >>> 4) & 15]);
            sb.append(cArr[bArr[i] & 15]);
            if (i < bArr.length - 1) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static boolean equals(byte[][][] bArr, byte[][][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte[][] bArr3 = bArr[length];
            if (bArr3.length != bArr2[length].length) {
                return false;
            }
            for (int length2 = bArr3.length - 1; length2 >= 0; length2--) {
                z &= equals(bArr[length][length2], bArr2[length][length2]);
            }
        }
        return z;
    }
}
