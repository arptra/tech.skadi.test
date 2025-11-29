package com.here.sdk.mapdata;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.LocalizedTexts;
import com.here.sdk.routing.FunctionalRoadClass;
import com.here.sdk.routing.LocalizedRoadNumbers;
import com.here.sdk.routing.TravelDirection;
import java.util.List;

public final class SegmentSpanData extends NativeBase {
    public SegmentSpanData(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SegmentSpanData.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @Nullable
    public native FunctionalRoadClass getFunctionalRoadClass();

    @Nullable
    public native List<LocalRoadCharacteristic> getLocalRoadCharacteristics();

    @Nullable
    public native AllowedTransportModes getNegativeDirectionAllowedTransportModes();

    @Nullable
    public native Double getNegativeDirectionBaseSpeedInMetersPerSecond();

    @Nullable
    public native SegmentSpeedLimit getNegativeDirectionSpeedLimit();

    @Nullable
    public native PhysicalAttributes getPhysicalAttributes();

    @Nullable
    public native AllowedTransportModes getPositiveDirectionAllowedTransportModes();

    @Nullable
    public native Double getPositiveDirectionBaseSpeedInMetersPerSecond();

    @Nullable
    public native SegmentSpeedLimit getPositiveDirectionSpeedLimit();

    @Nullable
    public native LocalizedRoadNumbers getRoadNumbers();

    @Nullable
    public native RoadUsages getRoadUsages();

    public native int getSpanLengthInMeters();

    public native int getStartOffsetInMeters();

    @Nullable
    public native LocalizedTexts getStreetNames();

    @Nullable
    public native TravelDirection getTravelDirection();
}
