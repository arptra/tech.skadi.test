package com.geetest.sdk.utils;

import android.content.Context;

public class g {
    public static int a(Context context) {
        return b(context, 140.0f);
    }

    public static int b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context) {
        return b(context, 220.0f);
    }

    public static int d(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
