package com.xjsd.ai.assistant.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class DigestUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f8461a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void a(byte[] bArr, int i, int i2, char[] cArr, char[] cArr2, int i3) {
        for (int i4 = i; i4 < i + i2; i4++) {
            int i5 = i3 + 1;
            byte b2 = bArr[i4];
            cArr2[i3] = cArr[(b2 & 240) >>> 4];
            i3 += 2;
            cArr2[i5] = cArr[b2 & 15];
        }
    }

    public static char[] b(byte[] bArr) {
        return c(bArr, true);
    }

    public static char[] c(byte[] bArr, boolean z) {
        return d(bArr, z ? f8461a : b);
    }

    public static char[] d(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[(bArr.length << 1)];
        a(bArr, 0, bArr.length, cArr, cArr2, 0);
        return cArr2;
    }

    public static String e(byte[] bArr) {
        return new String(b(bArr));
    }

    public static MessageDigest f(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] g(String str) {
        return h(StringUtils.getBytesUtf8(str));
    }

    public static byte[] h(byte[] bArr) {
        return f(MessageDigestAlgorithms.MD5).digest(bArr);
    }

    public static String i(String str) {
        return e(g(str));
    }

    public static byte[] j(String str) {
        return k(StringUtils.getBytesUtf8(str));
    }

    public static byte[] k(byte[] bArr) {
        return f(MessageDigestAlgorithms.SHA_256).digest(bArr);
    }

    public static String l(String str) {
        return e(j(str));
    }
}
