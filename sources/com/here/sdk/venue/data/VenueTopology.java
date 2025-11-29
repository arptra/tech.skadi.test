package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.venue.style.VenueGeometryStyle;
import java.util.List;

public final class VenueTopology extends NativeBase {
    public VenueTopology(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueTopology.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native GeoCoordinates getCenter();

    @NonNull
    public native String getIdentifier();

    @NonNull
    public native VenueLevel getLevel();

    public native int getNestingDepth();

    @NonNull
    public native Shapes getShape();

    @NonNull
    public native List<GeoShape> getShapes();

    @Nullable
    public native VenueGeometryStyle getStyle();

    @NonNull
    public native String getStyleName();
}
