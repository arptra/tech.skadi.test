package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.animation.AnimationListener;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoOrientation;
import com.here.sdk.core.GeoOrientationUpdate;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.Rectangle2D;

public final class MapCamera extends NativeBase {

    public static final class State {
        public double distanceToTargetInMeters;
        @NonNull
        public GeoOrientation orientationAtTarget;
        @NonNull
        public GeoCoordinates targetCoordinates;
        public double zoomLevel;

        public State(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoOrientation geoOrientation, double d, double d2) {
            this.targetCoordinates = geoCoordinates;
            this.orientationAtTarget = geoOrientation;
            this.distanceToTargetInMeters = d;
            this.zoomLevel = d2;
        }
    }

    public MapCamera(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapCamera.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addListener(@NonNull MapCameraListener mapCameraListener);

    public native void applyUpdate(@NonNull MapCameraUpdate mapCameraUpdate);

    public native void cancelAnimation(@NonNull MapCameraAnimation mapCameraAnimation);

    public native void cancelAnimations();

    @Nullable
    public native GeoBox getBoundingBox();

    @NonNull
    public native MapCameraLimits getLimits();

    @NonNull
    public native Point2D getPrincipalPoint();

    @NonNull
    public native State getState();

    public native void lookAt(@NonNull GeoBox geoBox, @NonNull GeoOrientationUpdate geoOrientationUpdate);

    public native void lookAt(@NonNull GeoBox geoBox, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull Rectangle2D rectangle2D);

    public native void lookAt(@NonNull GeoCoordinates geoCoordinates);

    public native void lookAt(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull MapMeasure mapMeasure);

    public native void lookAt(@NonNull GeoCoordinates geoCoordinates, @NonNull MapMeasure mapMeasure);

    public native void orbitBy(@NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull Point2D point2D);

    public native void removeListener(@NonNull MapCameraListener mapCameraListener);

    public native void removeListeners();

    public native void setDistanceToTarget(double d);

    public native void setOrientationAtTarget(@NonNull GeoOrientationUpdate geoOrientationUpdate);

    public native void setPrincipalPoint(@NonNull Point2D point2D);

    public native void startAnimation(@NonNull MapCameraAnimation mapCameraAnimation);

    public native void startAnimation(@NonNull MapCameraAnimation mapCameraAnimation, @NonNull AnimationListener animationListener);

    public native void zoomBy(double d, @NonNull Point2D point2D);

    public native void zoomTo(double d);
}
