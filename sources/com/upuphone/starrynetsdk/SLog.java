package com.upuphone.starrynetsdk;

import android.util.Log;

public class SLog {
    private static final String TAG = "SLog-2.8.44";

    public static void d(String str) {
        Log.d(TAG, str);
    }

    public static void e(String str) {
        Log.e(TAG, str);
    }

    public static void i(String str) {
        Log.i(TAG, str);
    }

    public static void v(String str) {
        Log.v(TAG, str);
    }

    public static void w(String str) {
        Log.w(TAG, str);
    }

    public static void e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }
}
