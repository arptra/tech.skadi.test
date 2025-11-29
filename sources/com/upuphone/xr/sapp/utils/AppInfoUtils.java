package com.upuphone.xr.sapp.utils;

import android.os.Build;

public class AppInfoUtils {
    public static String a() {
        return Build.BRAND;
    }

    public static String b() {
        return Build.MODEL;
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }
}
