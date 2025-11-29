package com.upuphone.ai.ttsengine.base.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class WaveHeader {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f5533a = {'R', 'I', 'F', 'F'};
    public static char[] b = {'W', 'A', 'V', 'E'};
    public static char[] c = {'f', 'm', 't', ' '};
    public static int d = 16;
    public static short e = 1;
    public static short f = 16;
    public static char[] g = {'d', 'a', 't', 'a'};

    public static byte[] a(int i, int i2, int i3) {
        byte[] bArr = null;
        try {
            short s = (short) ((f * i2) / 8);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            b(byteArrayOutputStream, f5533a);
            c(byteArrayOutputStream, i + 36);
            b(byteArrayOutputStream, b);
            b(byteArrayOutputStream, c);
            c(byteArrayOutputStream, d);
            d(byteArrayOutputStream, e);
            d(byteArrayOutputStream, (short) i2);
            c(byteArrayOutputStream, i3);
            c(byteArrayOutputStream, i3 * s);
            d(byteArrayOutputStream, s);
            d(byteArrayOutputStream, f);
            b(byteArrayOutputStream, g);
            c(byteArrayOutputStream, i);
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    public static void b(ByteArrayOutputStream byteArrayOutputStream, char[] cArr) {
        for (char write : cArr) {
            byteArrayOutputStream.write(write);
        }
    }

    public static void c(ByteArrayOutputStream byteArrayOutputStream, int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i >> 24);
        bArr[2] = (byte) ((i << 8) >> 24);
        bArr[1] = (byte) ((i << 16) >> 24);
        bArr[0] = (byte) ((i << 24) >> 24);
        byteArrayOutputStream.write(bArr);
    }

    public static void d(ByteArrayOutputStream byteArrayOutputStream, short s) {
        try {
            byte[] bArr = new byte[2];
            bArr[1] = (byte) (s >> 8);
            bArr[0] = (byte) ((s << 8) >> 8);
            byteArrayOutputStream.write(bArr);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
