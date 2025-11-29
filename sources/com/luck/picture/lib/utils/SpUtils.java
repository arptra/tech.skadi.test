package com.luck.picture.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f9474a;

    public static boolean a(Context context, String str, boolean z) {
        return b(context).getBoolean(str, z);
    }

    public static SharedPreferences b(Context context) {
        if (f9474a == null) {
            f9474a = context.getSharedPreferences("PictureSpUtils", 0);
        }
        return f9474a;
    }

    public static void c(Context context, String str, boolean z) {
        b(context).edit().putBoolean(str, z).apply();
    }

    public static void d(Context context, String str, String str2) {
        b(context).edit().putString(str, str2).apply();
    }
}
