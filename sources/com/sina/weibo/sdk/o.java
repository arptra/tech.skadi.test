package com.sina.weibo.sdk;

import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f9991a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            byte[] digest = instance.digest();
            char[] cArr = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                char[] cArr2 = f9991a;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i += 2;
                cArr[i3] = cArr2[b & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
