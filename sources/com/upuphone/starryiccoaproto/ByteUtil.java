package com.upuphone.starryiccoaproto;

public final class ByteUtil {
    public static int a(byte[] bArr, int i) {
        if (bArr.length >= i + 4) {
            return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }
        throw new IllegalArgumentException("Read int from protocol bytes error");
    }

    public static short b(byte[] bArr, int i) {
        if (bArr.length >= i + 2) {
            return (short) (((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8)) & 65535);
        }
        throw new IllegalArgumentException("Read int from protocol bytes error");
    }

    public static void c(byte[] bArr, int i, int i2) {
        if (bArr.length >= i + 4) {
            bArr[i] = (byte) ((i2 >>> 24) & 255);
            bArr[i + 1] = (byte) ((i2 >>> 16) & 255);
            bArr[i + 2] = (byte) ((i2 >>> 8) & 255);
            bArr[i + 3] = (byte) (i2 & 255);
            return;
        }
        throw new IllegalArgumentException("Read int from protocol bytes error");
    }

    public static void d(byte[] bArr, int i, short s) {
        if (bArr.length >= i + 2) {
            bArr[i] = (byte) ((s >>> 8) & 255);
            bArr[i + 1] = (byte) (s & 255);
            return;
        }
        throw new IllegalArgumentException("Read int from protocol bytes error");
    }
}
