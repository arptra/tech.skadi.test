package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Location;

public final class LocationIndicator extends NativeBase implements MapViewLifecycleListener {

    public enum IndicatorStyle {
        PEDESTRIAN(0),
        NAVIGATION(1);
        
        public final int value;

        private IndicatorStyle(int i) {
            this.value = i;
        }
    }

    public enum MarkerType {
        PEDESTRIAN(0),
        PEDESTRIAN_INACTIVE(1),
        NAVIGATION(2),
        NAVIGATION_INACTIVE(3);
        
        public final int value;

        private MarkerType(int i) {
            this.value = i;
        }
    }

    public LocationIndicator() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    private static native long make(@NonNull MapViewBase mapViewBase);

    public native void disable();

    public native void enable(@NonNull MapViewBase mapViewBase);

    @NonNull
    public native IndicatorStyle getLocationIndicatorStyle();

    public native double getOpacity();

    public native boolean isAccuracyVisualized();

    public native boolean isActive();

    public native boolean isDirectionIndicatorVisible();

    public native void onAttach(@NonNull MapViewBase mapViewBase);

    public native void onDestroy();

    public native void onDetach(@NonNull MapViewBase mapViewBase);

    public native void onPause();

    public native void onResume();

    public native void setAccuracyVisualized(boolean z);

    public native void setActive(boolean z);

    public native void setDirectionIndicatorVisible(boolean z);

    public native void setLocationIndicatorStyle(@NonNull IndicatorStyle indicatorStyle);

    public native void setMarker3dModel(@NonNull MapMarker3DModel mapMarker3DModel, double d, @NonNull MarkerType markerType);

    public native void setOpacity(double d);

    public native void updateLocation(@NonNull Location location);

    public native void updateLocation(@NonNull Location location, @NonNull MapCameraUpdate mapCameraUpdate);

    public LocationIndicator(@NonNull MapViewBase mapViewBase) {
        this(make(mapViewBase), (Object) null);
        cacheThisInstance();
    }

    public LocationIndicator(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationIndicator.disposeNativeHandle(j);
            }
        });
    }
}
