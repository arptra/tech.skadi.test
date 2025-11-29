package com.upuphone.starrynet.payload;

import android.util.Log;

public class Plog {
    private static boolean enableLog = true;

    public static void d(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        Log.d(str, str2);
    }

    public static void e(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        Log.e(str, str2);
    }

    public static void enableLog(boolean z) {
        enableLog = z;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        Log.v(str, str2);
    }

    public static void w(String str, String str2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        Log.w(str, str2);
    }
}
