package com.ucar.util;

public class DigitalTrans {
    public static String a(int i, int i2) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() % 2 == 1) {
            hexString = "0" + hexString;
        }
        return b(hexString.toUpperCase(), i2);
    }

    public static String b(String str, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i - str.length(); i2++) {
            sb.insert(0, "0");
        }
        return (sb + str).substring(0, i);
    }
}
