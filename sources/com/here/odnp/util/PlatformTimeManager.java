package com.here.odnp.util;

import android.os.SystemClock;

public class PlatformTimeManager implements ITimeManager {
    private static final String TAG = "odnp.util.PlatformTimeManager";

    public PlatformTimeManager() {
        Log.i(TAG, "PlatformTimeManager", new Object[0]);
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long timeSinceBoot() {
        return SystemClock.elapsedRealtime();
    }

    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }
}
