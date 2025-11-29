package com.geetest.sdk.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class q {
    public static byte[] a() {
        return b(16);
    }

    public static byte[] b(int i) {
        byte[] bArr = new byte[i];
        try {
            SecureRandom.getInstanceStrong().nextBytes(bArr);
            return bArr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
