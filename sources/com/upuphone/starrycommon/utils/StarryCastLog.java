package com.upuphone.starrycommon.utils;

import android.text.TextUtils;
import android.util.Log;

public class StarryCastLog {

    /* renamed from: a  reason: collision with root package name */
    public static Log2File f6500a;

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Log.d("StarryCast", str);
            Log2File log2File = f6500a;
            if (log2File != null) {
                log2File.a(str);
            }
        }
    }

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d("StarryCast", str + " >>> " + str2);
            Log2File log2File = f6500a;
            if (log2File != null) {
                log2File.a(str2);
            }
        }
    }

    public static void c(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e("StarryCast", str + " >>> " + str2);
            Log2File log2File = f6500a;
            if (log2File != null) {
                log2File.a(str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i("StarryCast", str + " >>> " + str2);
            Log2File log2File = f6500a;
            if (log2File != null) {
                log2File.a(str2);
            }
        }
    }
}
