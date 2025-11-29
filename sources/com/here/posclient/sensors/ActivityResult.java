package com.here.posclient.sensors;

import android.os.SystemClock;
import com.geetest.sdk.s;
import com.here.posclient.ActivityType;
import java.util.concurrent.TimeUnit;

public abstract class ActivityResult {
    private final int mConfidence;
    private final long mElapsedRealtimeMs;
    private final int mRawType;

    public interface Listener {
        void onActivityDetected(ActivityResult activityResult);
    }

    public ActivityResult(int i, int i2, long j) {
        this.mRawType = i;
        this.mConfidence = clampConfidence(i2);
        this.mElapsedRealtimeMs = j;
    }

    public static int clampConfidence(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 100) {
            return 100;
        }
        return i;
    }

    public static String posClnTypeString(ActivityType activityType) {
        return activityType == null ? ActivityType.Unknown.name() : activityType.name();
    }

    public long getAgeInSeconds() {
        return TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.mElapsedRealtimeMs);
    }

    public int getConfidence() {
        return this.mConfidence;
    }

    public long getElapsedRealtimeMillis() {
        return this.mElapsedRealtimeMs;
    }

    public int getRawType() {
        return this.mRawType;
    }

    public ActivityType getType() {
        return ActivityType.fromInt(getTypeValue());
    }

    public abstract int getTypeValue();

    public String toString() {
        return "" + " type: " + getType() + " prb: " + getConfidence() + "%" + " age: " + getAgeInSeconds() + s.f;
    }
}
