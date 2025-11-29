package com.luck.picture.lib.utils;

import android.os.SystemClock;

public class DoubleUtils {

    /* renamed from: a  reason: collision with root package name */
    public static long f9472a;

    public static boolean a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f9472a < 600) {
            return true;
        }
        f9472a = elapsedRealtime;
        return false;
    }
}
