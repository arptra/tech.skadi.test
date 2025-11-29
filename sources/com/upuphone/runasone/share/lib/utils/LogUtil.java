package com.upuphone.runasone.share.lib.utils;

import android.util.Log;

public class LogUtil {
    private static final String APP_TAG = "[RunAsOne.UupShare] ";

    public static void d(String str, String str2) {
        Log.d(APP_TAG + str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(APP_TAG + str, str2);
    }

    public static void i(String str, String str2) {
        Log.i(APP_TAG + str, str2);
    }

    public static void w(String str, String str2) {
        Log.w(APP_TAG + str, str2);
    }
}
