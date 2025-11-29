package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import java.util.List;
import java.util.Map;

public final class VenueLevel extends NativeBase {
    public VenueLevel(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueLevel.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native boolean contains(@NonNull GeoCoordinates geoCoordinates);

    public native boolean containsMergedLevel(@NonNull String str);

    @NonNull
    public native List<VenueGeometry> filterGeometry(@NonNull String str, @NonNull VenueGeometryFilterType venueGeometryFilterType);

    @NonNull
    public native GeoBox getBoundingBox();

    @NonNull
    public native GeoCoordinates getCenter();

    @NonNull
    public native VenueDrawing getDrawing();

    @NonNull
    public native String getDrawingID();

    @NonNull
    public native List<VenueGeometry> getGeometries();

    @NonNull
    public native List<VenueGeometry> getGeometriesByCoordinates(@NonNull GeoCoordinates geoCoordinates);

    @NonNull
    public native Map<String, List<VenueGeometry>> getGeometriesByIconNames();

    @NonNull
    public native List<VenueGeometry> getGeometriesByName();

    @Nullable
    public native VenueGeometry getGeometryByAddress(@NonNull String str);

    @Nullable
    public native VenueGeometry getGeometryByCoordinates(@NonNull GeoCoordinates geoCoordinates);

    @Nullable
    public native VenueGeometry getGeometryById(@NonNull String str);

    @NonNull
    public native String getIdentifier();

    @NonNull
    public native List<String> getMergedLevel();

    @NonNull
    public native String getName();

    @NonNull
    public native Map<String, Property> getProperties();

    @NonNull
    public native String getShortName();

    @NonNull
    public native List<VenueTopology> getTopologies();

    public native int getZIndex();

    public native boolean isMainLevel();

    public native boolean mergeLevel(@NonNull VenueLevel venueLevel);
}
