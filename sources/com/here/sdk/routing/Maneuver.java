package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LocalizedTexts;
import com.here.time.Duration;

public final class Maneuver extends NativeBase {
    public Maneuver(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Maneuver.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native ManeuverAction getAction();

    @NonNull
    public native GeoCoordinates getCoordinates();

    @Nullable
    public native String getCountryCode();

    @NonNull
    public native Duration getDuration();

    @NonNull
    public native LocalizedTexts getExitSignTexts();

    @NonNull
    public native LocalizedTexts getIntersectionNames();

    public native int getLengthInMeters();

    @NonNull
    public native RoadTexts getNextRoadTexts();

    @Nullable
    public native RoadType getNextRoadType();

    public native int getOffset();

    @NonNull
    public native RoadTexts getRoadTexts();

    @Nullable
    public native RoadType getRoadType();

    @Nullable
    public native Double getRoundaboutAngleInDegrees();

    public native int getSectionIndex();

    @Nullable
    public native Signpost getSignpost();

    @Nullable
    public native TbtManeuverAction getTbtManeuverAction();

    @NonNull
    public native String getText();

    @Nullable
    public native Double getTurnAngleInDegrees();
}
