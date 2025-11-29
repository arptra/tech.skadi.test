package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Color;
import com.here.sdk.core.GeoPolygon;
import com.here.sdk.core.Metadata;
import java.util.List;

public final class MapPolygon extends NativeBase {
    public MapPolygon(@NonNull GeoPolygon geoPolygon, @NonNull Color color) {
        this(make(geoPolygon, color), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull GeoPolygon geoPolygon, @NonNull Color color);

    private static native long make(@NonNull GeoPolygon geoPolygon, @NonNull Color color, @NonNull Color color2, double d);

    public native int getDrawOrder();

    @NonNull
    public native Color getFillColor();

    @NonNull
    public native GeoPolygon getGeometry();

    @Nullable
    public native Metadata getMetadata();

    @NonNull
    public native Color getOutlineColor();

    public native double getOutlineWidth();

    @NonNull
    public native List<MapMeasureRange> getVisibilityRanges();

    public native void setDrawOrder(int i);

    public native void setFillColor(@NonNull Color color);

    public native void setGeometry(@NonNull GeoPolygon geoPolygon);

    public native void setMetadata(@Nullable Metadata metadata);

    public native void setOutlineColor(@NonNull Color color);

    public native void setOutlineWidth(double d);

    public native void setVisibilityRanges(@NonNull List<MapMeasureRange> list);

    public MapPolygon(@NonNull GeoPolygon geoPolygon, @NonNull Color color, @NonNull Color color2, double d) {
        this(make(geoPolygon, color, color2, d), (Object) null);
        cacheThisInstance();
    }

    public MapPolygon(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapPolygon.disposeNativeHandle(j);
            }
        });
    }
}
