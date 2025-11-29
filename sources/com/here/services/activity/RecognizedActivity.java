package com.here.services.activity;

public class RecognizedActivity {
    private float mConfidence;
    private long mElapsedRealTimeMs;
    private ActivityType mType;

    public enum ActivityType {
        Unknown,
        Stationary
    }

    public RecognizedActivity(ActivityType activityType, float f, long j) {
        this.mType = activityType;
        this.mConfidence = f;
        this.mElapsedRealTimeMs = j;
    }

    public ActivityType getActivityType() {
        return this.mType;
    }

    public float getConfidence() {
        return this.mConfidence;
    }

    public long getElapsedRealTimeMs() {
        return this.mElapsedRealTimeMs;
    }
}
