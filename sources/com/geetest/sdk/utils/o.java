package com.geetest.sdk.utils;

import android.content.Context;

public final class o {
    public static int a(Context context, String str) {
        return b(context, str, "drawable");
    }

    public static int b(Context context, String str, String str2) {
        return c(str, str2, context.getApplicationContext().getResources().getIdentifier(str, str2, context.getPackageName()));
    }

    public static int c(String str, String str2, int i) {
        if (i == 0) {
            l.c("Geetest", "resource " + str + ", type " + str2 + ", undefined.");
        }
        return i;
    }

    public static int d(Context context, String str) {
        return b(context, str, "id");
    }

    public static int e(Context context, String str) {
        return b(context, str, "layout");
    }

    public static int f(Context context, String str) {
        return b(context, str, "mipmap");
    }

    public static int g(Context context, String str) {
        return b(context, str, "string");
    }

    public static int h(Context context, String str) {
        return b(context, str, "style");
    }
}
