package com.here.sdk.prefetcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoCorridor;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.threading.TaskHandle;
import com.here.sdk.navigation.NavigatorInterface;

public final class RoutePrefetcher extends NativeBase {
    public RoutePrefetcher(@NonNull SDKNativeEngine sDKNativeEngine) {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine);

    public native int getPrefetchCorridorLengthMeters();

    @Deprecated
    public native void prefetchAroundLocation(@NonNull GeoCoordinates geoCoordinates);

    public native void prefetchAroundLocationWithRadius(@NonNull GeoCoordinates geoCoordinates, @Nullable Double d);

    public native void prefetchAroundRouteOnIntervals(@NonNull NavigatorInterface navigatorInterface);

    @NonNull
    public native TaskHandle prefetchGeoCorridor(@NonNull GeoCorridor geoCorridor, @NonNull PrefetchStatusListener prefetchStatusListener);

    public native void releaseAllProtectedTiles();

    public native void setPrefetchCorridorLengthMeters(int i);

    public native void stopPrefetchAroundRoute();

    public RoutePrefetcher(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RoutePrefetcher.disposeNativeHandle(j);
            }
        });
    }
}
