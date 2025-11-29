package com.ucar.connect.aoa;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class AOAPreambleBuilder {
    public static String a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s;%s;%s;%s;%s;%s", new Object[]{c(str, 12), c(str2, 8), b(str3), c(str4, 12), d(str5), c(str6, 4)});
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length <= 16) {
            return str;
        }
        while (bytes.length > 16 && !str.isEmpty()) {
            str = str.substring(0, str.length() - 1);
            bytes = (str + "…").getBytes(StandardCharsets.UTF_8);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static String c(String str, int i) {
        return str == null ? "" : str.length() > i ? str.substring(0, i) : str;
    }

    public static String d(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\\.");
        if (split.length >= 2) {
            byte[] bArr = new byte[2];
            for (int i = 0; i < 2; i++) {
                bArr[i] = (byte) Integer.parseInt(split[i]);
            }
            return String.format(Locale.ENGLISH, "%d.%d", new Object[]{Integer.valueOf(Byte.toUnsignedInt(bArr[0])), Integer.valueOf(Byte.toUnsignedInt(bArr[1]))});
        }
        throw new IllegalArgumentException();
    }
}
