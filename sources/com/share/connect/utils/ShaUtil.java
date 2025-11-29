package com.share.connect.utils;

import android.text.TextUtils;
import com.easy.logger.EasyLog;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaUtil {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b : MessageDigest.getInstance("sha-256").digest(str.getBytes(StandardCharsets.UTF_8))) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e) {
            EasyLog.d("ShaUtil", "ShaUtil error", e);
            return "";
        }
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? str : a(str.toUpperCase());
    }
}
