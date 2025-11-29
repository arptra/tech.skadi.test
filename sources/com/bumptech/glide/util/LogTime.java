package com.bumptech.glide.util;

import android.os.SystemClock;

public final class LogTime {

    /* renamed from: a  reason: collision with root package name */
    public static final double f2744a = (1.0d / Math.pow(10.0d, 6.0d));

    public static double a(long j) {
        return ((double) (b() - j)) * f2744a;
    }

    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
