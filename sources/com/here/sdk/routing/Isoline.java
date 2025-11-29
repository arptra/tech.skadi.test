package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoPolygon;
import java.util.List;

public final class Isoline extends NativeBase {
    public Isoline(@NonNull IsolineRangeType isolineRangeType, double d, @NonNull MapMatchedCoordinates mapMatchedCoordinates, @NonNull List<GeoPolygon> list) {
        this(make(isolineRangeType, d, mapMatchedCoordinates, list), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull IsolineRangeType isolineRangeType, double d, @NonNull MapMatchedCoordinates mapMatchedCoordinates, @NonNull List<GeoPolygon> list);

    @NonNull
    public native MapMatchedCoordinates getCenter();

    @NonNull
    public native List<GeoPolygon> getPolygons();

    @NonNull
    public native IsolineRangeType getRangeType();

    public native double getRangeValue();

    public Isoline(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Isoline.disposeNativeHandle(j);
            }
        });
    }
}
