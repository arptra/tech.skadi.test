package com.upuphone.ar.fastrecord.phone.utils;

public class RecordOpusUtil {
    public static int byteArrayToInt(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    public static double calculateAmplitude(byte[] bArr) {
        if (bArr.length == 0) {
            return 0.0d;
        }
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2 + 1] << 8) | (bArr[i2] & 255));
        }
        short s = sArr[0];
        short s2 = s;
        for (int i3 = 0; i3 < length; i3++) {
            short s3 = sArr[i3];
            if (s3 > s) {
                s = s3;
            }
            if (s3 < s2) {
                s2 = s3;
            }
        }
        return (double) (s - s2);
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }
}
