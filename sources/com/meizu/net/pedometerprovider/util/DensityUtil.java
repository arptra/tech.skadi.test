package com.meizu.net.pedometerprovider.util;

import android.content.Context;

public class DensityUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float sp2px(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().scaledDensity;
    }
}
