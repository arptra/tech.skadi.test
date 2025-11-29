package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import java.util.List;

public final class Place extends NativeBase {
    public Place(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Place.disposeNativeHandle(j);
            }
        });
    }

    @NonNull
    public static native Place deserialize(@NonNull String str) throws PlaceSerializationException;

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<GeoCoordinates> getAccessPoints();

    @NonNull
    public native Address getAddress();

    @Nullable
    public native AreaType getAreaType();

    @Nullable
    public native GeoBox getBoundingBox();

    @NonNull
    public native Details getDetails();

    @Nullable
    public native Integer getDistanceInMeters();

    @Nullable
    public native GeoCoordinates getGeoCoordinates();

    @NonNull
    public native String getId();

    @NonNull
    public native PlaceType getPlaceType();

    @Nullable
    public native String getPoliticalView();

    @NonNull
    public native String getTitle();

    public native boolean isCoordinatesInterpolated();

    @NonNull
    public native String serializeCompact();
}
