package com.here.sdk.prefetcher;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoPolygon;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.threading.TaskHandle;

public final class PolygonPrefetcher extends NativeBase {
    public PolygonPrefetcher(@NonNull SDKNativeEngine sDKNativeEngine) {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine);

    @NonNull
    public native TaskHandle estimateMapDataSize(@NonNull GeoPolygon geoPolygon, @NonNull MapDataSizeListener mapDataSizeListener);

    @NonNull
    public native TaskHandle prefetch(@NonNull GeoPolygon geoPolygon, @NonNull PrefetchStatusListener prefetchStatusListener);

    public PolygonPrefetcher(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PolygonPrefetcher.disposeNativeHandle(j);
            }
        });
    }
}
