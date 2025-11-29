package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.mapview.MapMarkerCluster;
import java.util.List;

public final class PickMapItemsResult extends NativeBase {
    public PickMapItemsResult(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PickMapItemsResult.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<MapMarkerCluster.Grouping> getClusteredMarkers();

    @NonNull
    public native List<MapMarker> getMarkers();

    @NonNull
    public native List<MapMarker3D> getMarkers3d();

    @NonNull
    public native List<MapPolygon> getPolygons();

    @NonNull
    public native List<MapPolyline> getPolylines();
}
