package com.upuphone.runasone.channel.proxy.client.util;

import android.util.Log;

public class DebugLog {
    public static final boolean IS_DEBUG = true;
    public static final boolean IS_VERBOSE = false;
    private static final String TAG = "Starry-Net-Proxy";

    public static void d(String str, Object... objArr) {
        dWithTag(TAG, str, objArr);
    }

    public static void dWithTag(String str, String str2, Object... objArr) {
        Log.d(str, format(str2, objArr));
    }

    public static void e(String str, Object... objArr) {
        eWithTag(TAG, str, objArr);
    }

    public static void eWithTag(String str, String str2, Object... objArr) {
        Log.e(str, format(str2, objArr));
    }

    private static String format(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public static void i(String str, Object... objArr) {
        iWithTag(TAG, str, objArr);
    }

    public static void iWithTag(String str, String str2, Object... objArr) {
        Log.i(str, format(str2, objArr));
    }

    public static void v(String str, Object... objArr) {
        vWithTag(TAG, str, objArr);
    }

    public static void vWithTag(String str, String str2, Object... objArr) {
    }

    public static void w(String str, Object... objArr) {
        wWithLog(TAG, str, objArr);
    }

    public static void wWithLog(String str, String str2, Object... objArr) {
        Log.w(str, format(str2, objArr));
    }
}
