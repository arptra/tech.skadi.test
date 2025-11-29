package com.here.services.playback.internal.util;

import com.here.odnp.util.TimeManager;

public abstract class TimeCalculatorBase {
    public static long timeSinceBootDiff(long j) {
        return Math.max(0, j - TimeManager.timeSinceBoot());
    }

    public abstract void doFastForwardAdjustments(long j);

    public abstract long getAdjustedCurrentTimeMillis(long j);

    public abstract long getAdjustedTimeSinceBoot(long j);
}
