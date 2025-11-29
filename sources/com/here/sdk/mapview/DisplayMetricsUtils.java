package com.here.sdk.mapview;

import android.os.Build;
import android.util.DisplayMetrics;

final class DisplayMetricsUtils {
    public static double extractDpi(DisplayMetrics displayMetrics) {
        return (Build.VERSION.SDK_INT <= 32 || !isRunningOnEmulator()) ? (double) displayMetrics.ydpi : (double) displayMetrics.densityDpi;
    }

    private static boolean isRunningOnEmulator() {
        return Build.MODEL.startsWith("sdk_gphone");
    }
}
