package com.google.android.gms.common.util;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.core.os.BuildCompat;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class PlatformVersion {
    private PlatformVersion() {
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastIceCreamSandwichMR1() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastJellyBean() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastJellyBeanMR1() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastJellyBeanMR2() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastKitKat() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastKitKatWatch() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastLollipop() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastLollipopMR1() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastM() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastN() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastO() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastP() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastQ() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastSv2() {
        return Build.VERSION.SDK_INT >= 32;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastT() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastU() {
        if (!isAtLeastT()) {
            return false;
        }
        return BuildCompat.c();
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast
    public static boolean isAtLeastV() {
        if (!isAtLeastU()) {
            return false;
        }
        return BuildCompat.d();
    }
}
