package com.ucar.vehiclesdk.test;

import org.apache.commons.lang3.BooleanUtils;

public class TestUtil {
    public static String a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static boolean b() {
        String a2 = a("ucar.test.action", BooleanUtils.FALSE);
        return a2 != null && a2.equals(BooleanUtils.TRUE);
    }

    public static boolean c() {
        String a2 = a("ucar.test.mode", BooleanUtils.FALSE);
        return a2 != null && a2.equals(BooleanUtils.TRUE);
    }
}
