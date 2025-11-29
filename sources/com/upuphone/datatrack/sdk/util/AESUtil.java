package com.upuphone.datatrack.sdk.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    public static byte[] a(byte[] bArr, byte[] bArr2, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(i, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr, "E21B5316F7B0813C".getBytes(), 2));
    }
}
