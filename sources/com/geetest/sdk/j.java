package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;

class j {
    public static long a(Context context, String str) {
        try {
            return context.getSharedPreferences("gt_fp", 0).getLong(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void b(Context context, String str, long j) {
        try {
            context.getSharedPreferences("gt_fp", 0).edit().putLong(str, j).apply();
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("gt_fp", 0).edit().putString(str, str2).apply();
        } catch (Exception unused) {
        }
    }

    public static boolean d(String str) {
        return TextUtils.isEmpty(str) || "$unknown".equals(str);
    }

    public static String e(Context context, String str) {
        try {
            return context.getSharedPreferences("gt_fp", 0).getString(str, (String) null);
        } catch (Exception unused) {
            return "$unknown";
        }
    }

    public static String f(Context context, String str) {
        String a2 = n.a(str.getBytes());
        if (d(a2)) {
            return null;
        }
        c(context, "gt_fp", a2);
        return a2;
    }
}
