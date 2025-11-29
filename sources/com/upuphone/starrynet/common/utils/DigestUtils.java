package com.upuphone.starrynet.common.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class DigestUtils {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    private static byte[] getBytes(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytes(str, StandardCharsets.UTF_8);
    }

    public static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getSnSign(byte[] bArr) {
        String bytesToHex = bytesToHex(bArr);
        return sha256Hex("RhdNS`Z?" + bytesToHex);
    }

    public static byte[] sha256(String str) {
        return sha256(getBytesUtf8(str));
    }

    public static String sha256Hex(String str) {
        return encodeHexString(sha256(str));
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static byte[] sha256(byte[] bArr) {
        return getDigest(MessageDigestAlgorithms.SHA_256).digest(bArr);
    }

    public static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[(bArr.length << 1)];
        encodeHex(bArr, 0, bArr.length, cArr, cArr2, 0);
        return cArr2;
    }

    public static String getSnSign(String str) {
        return sha256Hex("RhdNS`Z?" + str);
    }

    private static void encodeHex(byte[] bArr, int i, int i2, char[] cArr, char[] cArr2, int i3) {
        for (int i4 = i; i4 < i + i2; i4++) {
            int i5 = i3 + 1;
            byte b = bArr[i4];
            cArr2[i3] = cArr[(b & 240) >>> 4];
            i3 += 2;
            cArr2[i5] = cArr[b & 15];
        }
    }
}
