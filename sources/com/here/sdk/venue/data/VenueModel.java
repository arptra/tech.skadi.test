package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import java.util.List;
import java.util.Map;

public final class VenueModel extends NativeBase {
    public VenueModel(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueModel.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void applyDisplaySettings();

    @NonNull
    public native List<VenueGeometry> filterGeometry(@NonNull String str, @NonNull VenueGeometryFilterType venueGeometryFilterType);

    @NonNull
    public native GeoBox getBoundingBox();

    @NonNull
    public native GeoCoordinates getCenter();

    @NonNull
    public native VenueDisplayType getDisplayType();

    @NonNull
    public native VenueDrawing getDrawing(int i);

    @NonNull
    public native VenueDrawing getDrawing(@NonNull String str);

    @NonNull
    public native List<VenueDrawing> getDrawings();

    @NonNull
    public native Map<String, List<VenueGeometry>> getGeometriesByIconNames();

    @NonNull
    public native List<VenueGeometry> getGeometriesByName();

    public native int getId();

    @NonNull
    public native String getIdentifier();

    @NonNull
    public native String getLanguage();

    @NonNull
    public native Map<String, Property> getProperties();

    @NonNull
    public native List<String> getStringOverrideUrls();

    @NonNull
    public native List<String> getThemeMapOverrideUrls();

    @NonNull
    public native Map<String, List<String>> getThemeOverrideUrlMap();

    public native void setIdentifier(@NonNull String str);
}
