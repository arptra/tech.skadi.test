package com.upuphone.starrynetsdk.api;

import android.util.Log;

public final class SNSLog {
    private static final String TAG = "SNSLog";

    public static void d(String str, String str2) {
        Log.d("SNSLog " + str, str2);
    }

    public static void e(String str, String str2) {
        Log.e("SNSLog " + str, str2);
    }

    public static void i(String str, String str2) {
        Log.i("SNSLog " + str, str2);
    }

    public static void v(String str, String str2) {
        Log.v("SNSLog " + str, str2);
    }

    public static void w(String str, String str2) {
        Log.w("SNSLog " + str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("SNSLog " + str, str2, th);
    }
}
