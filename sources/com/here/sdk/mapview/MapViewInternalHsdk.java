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
import com.here.sdk.gestures.InternalGestureDetector;
import com.here.sdk.mapview.MapViewBase;

final class MapViewInternalHsdk extends NativeBase implements MapViewBase {

    @FunctionalInterface
    public interface RedrawCallback {
        void onRedrawCompleted();
    }

    public static class RedrawCallbackImpl extends NativeBase implements RedrawCallback {
        public RedrawCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    RedrawCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onRedrawCompleted();
    }

    @FunctionalInterface
    public interface SetValidSceneConfigurationCallback {
        void onSceneConfigurationSet(boolean z);
    }

    public static class SetValidSceneConfigurationCallbackImpl extends NativeBase implements SetValidSceneConfigurationCallback {
        public SetValidSceneConfigurationCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    SetValidSceneConfigurationCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onSceneConfigurationSet(boolean z);
    }

    @FunctionalInterface
    public interface TakeScreenshotCallback {
        void onScreenshotTaken(@Nullable byte[] bArr);
    }

    public static class TakeScreenshotCallbackImpl extends NativeBase implements TakeScreenshotCallback {
        public TakeScreenshotCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    TakeScreenshotCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onScreenshotTaken(@Nullable byte[] bArr);
    }

    public MapViewInternalHsdk(@Nullable MapViewOptions mapViewOptions, double d, double d2, @Nullable Double d3) {
        this(create(mapViewOptions, d, d2, d3), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    private static native long create(@Nullable MapViewOptions mapViewOptions, double d, double d2, @Nullable Double d3);

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native long getLiveInstanceCount();

    public static native void invalidateViews();

    public native void addLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener);

    public native void addWatermark(@NonNull Point2D point2D);

    public native void attachHarpToWindowRenderTarget(long j);

    public native void destroy();

    public native void detachHarpFromRenderTarget();

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
    public native InternalGestureDetector getInternalGestureDetector();

    @NonNull
    public native MapContext getMapContext();

    @NonNull
    public native MapScene getMapScene();

    public native double getPixelScale();

    @NonNull
    public native Size2D getViewportSize();

    @NonNull
    public native Size2D getWatermarkSize();

    public native boolean isContinuousRendering();

    public native boolean isDestroyed();

    public native boolean isValid();

    public native void notifyOnSceneConfigurationSet(@NonNull SetValidSceneConfigurationCallback setValidSceneConfigurationCallback);

    public native void pause();

    public native void pickMapContent(@NonNull Rectangle2D rectangle2D, @NonNull MapViewBase.PickMapContentCallback pickMapContentCallback);

    public native void pickMapItems(@NonNull Point2D point2D, double d, @NonNull MapViewBase.PickMapItemsCallback pickMapItemsCallback);

    public native void redraw(@Nullable RedrawCallback redrawCallback);

    public native void reloadWatermark(@NonNull String str);

    public native void removeLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener);

    public native void resume();

    public native void setContinuousRendering(boolean z);

    public native void setDisplayMetrics(double d, double d2, @Nullable Double d3);

    public native void setFrameRate(int i);

    public native void setRenderTargetUpdatedListener(@Nullable RenderTargetUpdatedListener renderTargetUpdatedListener);

    public native void setViewSize(long j, long j2);

    public native void setWatermarkLocation(@NonNull Anchor2D anchor2D, @NonNull Point2D point2D);

    public native void takeScreenshot(@NonNull TakeScreenshotCallback takeScreenshotCallback);

    @Nullable
    public native GeoCoordinates viewToGeoCoordinates(@NonNull Point2D point2D);

    public MapViewInternalHsdk(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapViewInternalHsdk.disposeNativeHandle(j);
            }
        });
    }
}
