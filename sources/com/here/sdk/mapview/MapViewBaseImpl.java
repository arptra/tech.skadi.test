package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.Rectangle2D;
import com.here.sdk.core.Size2D;
import com.here.sdk.gestures.Gestures;
import com.here.sdk.mapview.MapViewBase;

class MapViewBaseImpl extends NativeBase implements MapViewBase {
    public MapViewBaseImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapViewBaseImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener);

    @Nullable
    public native Point2D geoToViewCoordinates(@NonNull GeoCoordinates geoCoordinates);

    @NonNull
    public native MapCamera getCamera();

    public native int getFrameRate();

    @NonNull
    public native Gestures getGestures();

    @NonNull
    public native HereMap getHereMap();

    @NonNull
    public native MapContext getMapContext();

    @NonNull
    public native MapScene getMapScene();

    public native double getPixelScale();

    @NonNull
    public native Size2D getViewportSize();

    @NonNull
    public native Size2D getWatermarkSize();

    public native boolean isValid();

    public native void pickMapContent(@NonNull Rectangle2D rectangle2D, @NonNull MapViewBase.PickMapContentCallback pickMapContentCallback);

    public native void pickMapItems(@NonNull Point2D point2D, double d, @NonNull MapViewBase.PickMapItemsCallback pickMapItemsCallback);

    public native void removeLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener);

    public native void setFrameRate(int i);

    public native void setWatermarkLocation(@NonNull Anchor2D anchor2D, @NonNull Point2D point2D);

    @Nullable
    public native GeoCoordinates viewToGeoCoordinates(@NonNull Point2D point2D);
}
