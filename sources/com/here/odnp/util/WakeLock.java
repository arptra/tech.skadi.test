package com.here.odnp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;

public class WakeLock {
    private static final String TAG = "odnp.util.WakeLock";
    private static final String WAKELOCK_TAG = "odnp:WakeLock";
    private long mAcquiredTime;
    private final PowerManager.WakeLock mWakeLock;

    public WakeLock(Context context) {
        if (context != null) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, WAKELOCK_TAG);
            this.mWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    @SuppressLint({"Wakelock", "WakelockTimeout"})
    public void acquire() {
        if (!this.mWakeLock.isHeld()) {
            this.mWakeLock.acquire();
            this.mAcquiredTime = SystemClock.elapsedRealtime();
        }
    }

    public void release() {
        if (this.mWakeLock.isHeld()) {
            Log.v(TAG, "WakeLock held for: %d ms", Long.valueOf(SystemClock.elapsedRealtime() - this.mAcquiredTime));
            this.mWakeLock.release();
        }
    }
}
