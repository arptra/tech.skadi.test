package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.venue.data.VenueGeometry;
import com.here.sdk.venue.style.VenueGeometryStyle;
import java.util.List;

public final class Shapes extends NativeBase {
    public Shapes(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Shapes.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native GeoBox getBoundingBox();

    @NonNull
    public native List<GeoShape> getGeoShape();

    @NonNull
    public native VenueGeometry.GeometryType getGeometryType();

    @NonNull
    public native String getIdentifier();

    @NonNull
    public native LabelInfo getLabelInfo();

    public native int getNestingDepth();

    @NonNull
    public native GeometryShapeType getShapeType();

    @NonNull
    public native String getSpaceType();

    @Nullable
    public native VenueGeometryStyle getStyle();

    @NonNull
    public native String getStyleName();
}
