package com.geetest.sdk.utils;

import android.content.Context;

public class i {
    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
