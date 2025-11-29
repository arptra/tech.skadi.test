package com.honey.account.utils.encrypt;

import android.text.TextUtils;
import java.math.BigInteger;

public class XORUtil {
    private static final int RADIX = 16;
    private static final String SEED = "0665523627463256377889865";

    public static String Decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(new BigInteger(str, 16).xor(new BigInteger(SEED)).toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String DecryptBySeeds(String str, String[] strArr) {
        if ("".equals(str)) {
            return "";
        }
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    int length = strArr.length - 1;
                    String str2 = str;
                    while (length >= 0) {
                        BigInteger bigInteger = new BigInteger(strArr[length]);
                        length--;
                        str2 = new String(new BigInteger(str2, 16).xor(bigInteger).toByteArray());
                    }
                    return str2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String Encrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new BigInteger(SEED).xor(new BigInteger(str.getBytes())).toString(16);
    }

    public static String EncryptBySeeds(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (strArr != null && strArr.length > 0) {
            for (String bigInteger : strArr) {
                str = new BigInteger(bigInteger).xor(new BigInteger(str.getBytes())).toString(16);
            }
        }
        return str;
    }

    public static String Decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(new BigInteger(str, 16).xor(new BigInteger(str2)).toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String Encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new BigInteger(str2).xor(new BigInteger(str.getBytes())).toString(16);
    }
}
