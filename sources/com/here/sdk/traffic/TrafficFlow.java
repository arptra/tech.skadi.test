package com.here.sdk.traffic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class TrafficFlow extends NativeBase implements TrafficFlowBase {
    public TrafficFlow(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficFlow.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @Nullable
    public native Double getConfidence();

    public native double getFreeFlowSpeedInMetersPerSecond();

    public native double getJamFactor();

    @Nullable
    public native Short getJamTendency();

    @Nullable
    public native JunctionsTraversability getJunctionsTraversability();

    @NonNull
    public native TrafficLocation getLocation();

    @Nullable
    public native Double getSpeedInMetersPerSecond();

    @Nullable
    public native Double getSpeedUncappedInMetersPerSecond();

    @Nullable
    public native Traversability getTraversability();
}
