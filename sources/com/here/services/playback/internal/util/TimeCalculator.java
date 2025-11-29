package com.here.services.playback.internal.util;

import com.here.odnp.util.Log;
import com.here.odnp.util.TimeManager;
import java.util.concurrent.TimeUnit;

class TimeCalculator extends TimeCalculatorBase {
    private static final String TAG = "services.playback.internal.util.TimeCalculator";
    private final long FAST_FORWARD_INTERVAL_LIMIT = TimeUnit.SECONDS.toMillis(4);
    private final long mCurrentTimeMillis = TimeManager.currentTimeMillis();
    private long mFastForwardAdjustment;
    private long mFfCumulativeCount;
    private long mFfCumulativeMovingAverage;
    private long mFfLastMeasurementTime;
    private final long mReferenceTime;
    private final long mTimeSinceBoot = TimeManager.timeSinceBoot();

    public TimeCalculator(long j) {
        this.mReferenceTime = j;
    }

    public void doFastForwardAdjustments(long j) {
        long j2 = this.mFfLastMeasurementTime;
        if (j2 == 0) {
            this.mFfLastMeasurementTime = j;
            return;
        }
        long j3 = j - j2;
        if (j3 > this.FAST_FORWARD_INTERVAL_LIMIT) {
            this.mFastForwardAdjustment += j3 - this.mFfCumulativeMovingAverage;
            Log.v(TAG, "doFastForwardAdjustments: fast forwarding: interval: %d, avg interval: %d, mFastForwardAdjustment: %d", Long.valueOf(j3), Long.valueOf(this.mFfCumulativeMovingAverage), Long.valueOf(this.mFastForwardAdjustment));
        } else {
            long j4 = this.mFfCumulativeMovingAverage;
            long j5 = this.mFfCumulativeCount + 1;
            this.mFfCumulativeCount = j5;
            this.mFfCumulativeMovingAverage = j4 + ((j3 - j4) / j5);
        }
        this.mFfLastMeasurementTime = j;
    }

    public long getAdjustedCurrentTimeMillis(long j) {
        return (this.mCurrentTimeMillis + (j - this.mReferenceTime)) - this.mFastForwardAdjustment;
    }

    public long getAdjustedTimeSinceBoot(long j) {
        return (this.mTimeSinceBoot + (j - this.mReferenceTime)) - this.mFastForwardAdjustment;
    }
}
