package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Color;
import com.here.sdk.core.GeoPolyline;
import java.util.Map;

public final class MapArrow extends NativeBase {
    public MapArrow(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color) {
        this(make(geoPolyline, d, color), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color);

    private static native long make(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color, double d2, @NonNull Color color2);

    @NonNull
    public native Map<MapMeasure, Double> getMeasureDependentTailWidth();

    public native void setMeasureDependentTailWidth(@NonNull Map<MapMeasure, Double> map);

    public MapArrow(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color, double d2, @NonNull Color color2) {
        this(make(geoPolyline, d, color, d2, color2), (Object) null);
        cacheThisInstance();
    }

    public MapArrow(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapArrow.disposeNativeHandle(j);
            }
        });
    }
}
