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

public interface MapViewBase {

    @FunctionalInterface
    public interface PickMapContentCallback {
        void onPickMapContent(@Nullable PickMapContentResult pickMapContentResult);
    }

    public static class PickMapContentCallbackImpl extends NativeBase implements PickMapContentCallback {
        public PickMapContentCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    PickMapContentCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onPickMapContent(@Nullable PickMapContentResult pickMapContentResult);
    }

    @FunctionalInterface
    public interface PickMapItemsCallback {
        void onPickMapItems(@Nullable PickMapItemsResult pickMapItemsResult);
    }

    public static class PickMapItemsCallbackImpl extends NativeBase implements PickMapItemsCallback {
        public PickMapItemsCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    PickMapItemsCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onPickMapItems(@Nullable PickMapItemsResult pickMapItemsResult);
    }

    void addLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener);

    @Nullable
    Point2D geoToViewCoordinates(@NonNull GeoCoordinates geoCoordinates);

    @NonNull
    MapCamera getCamera();

    int getFrameRate();

    @NonNull
    Gestures getGestures();

    @NonNull
    HereMap getHereMap();

    @NonNull
    MapContext getMapContext();

    @NonNull
    MapScene getMapScene();

    double getPixelScale();

    @NonNull
    Size2D getViewportSize();

    @NonNull
    Size2D getWatermarkSize();

    boolean isValid();

    void pickMapContent(@NonNull Rectangle2D rectangle2D, @NonNull PickMapContentCallback pickMapContentCallback);

    void pickMapItems(@NonNull Point2D point2D, double d, @NonNull PickMapItemsCallback pickMapItemsCallback);

    void removeLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener);

    void setFrameRate(int i);

    void setWatermarkLocation(@NonNull Anchor2D anchor2D, @NonNull Point2D point2D);

    @Nullable
    GeoCoordinates viewToGeoCoordinates(@NonNull Point2D point2D);
}
