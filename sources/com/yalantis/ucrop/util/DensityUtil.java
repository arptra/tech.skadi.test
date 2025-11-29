package com.yalantis.ucrop.util;

import android.content.Context;

public class DensityUtil {
    public static int a(Context context, float f) {
        return (int) ((f * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
