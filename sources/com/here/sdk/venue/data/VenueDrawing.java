package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.venue.style.VenueGeometryStyle;
import java.util.List;
import java.util.Map;

public final class VenueDrawing extends NativeBase {
    public VenueDrawing(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueDrawing.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<VenueGeometry> filterGeometry(@NonNull String str, @NonNull VenueGeometryFilterType venueGeometryFilterType);

    public native float getAngle();

    @NonNull
    public native GeoBox getBoundingBox();

    @NonNull
    public native GeoCoordinates getCenter();

    @NonNull
    public native Map<String, List<VenueGeometry>> getGeometriesByIconNames();

    @NonNull
    public native List<VenueGeometry> getGeometriesByName();

    @Nullable
    public native VenueGeometry getGeometryByAddress(@NonNull String str);

    @Nullable
    public native VenueGeometry getGeometryById(@NonNull String str);

    @NonNull
    public native String getIdentifier();

    @NonNull
    public native List<VenueLevel> getLevels();

    @NonNull
    public native Map<String, Property> getProperties();

    @NonNull
    public native Shapes getShape();

    @Nullable
    public native VenueGeometryStyle getStyle();

    @NonNull
    public native String getStyleName();

    @NonNull
    public native List<Double> getTransform();

    @NonNull
    public native VenueModel getVenueModel();

    public native boolean isRoot();

    public native void mergeDrawing(@NonNull VenueDrawing venueDrawing);

    @NonNull
    public native GeoCoordinates transformToGeo(@NonNull Vector2D vector2D);

    @NonNull
    public native Vector2D transformToLocal(@NonNull GeoCoordinates geoCoordinates);
}
