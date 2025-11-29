package com.geetest.sdk;

import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class n {
    public static String a(byte[] bArr) {
        try {
            return o.a(b(bArr, MessageDigestAlgorithms.SHA_256));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }
}
