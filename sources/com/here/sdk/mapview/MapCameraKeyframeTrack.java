package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.animation.Anchor2DKeyframe;
import com.here.sdk.animation.Easing;
import com.here.sdk.animation.EasingFunction;
import com.here.sdk.animation.GeoCoordinatesKeyframe;
import com.here.sdk.animation.GeoOrientationKeyframe;
import com.here.sdk.animation.KeyframeInterpolationMode;
import com.here.sdk.animation.Point2DKeyframe;
import com.here.sdk.animation.ScalarKeyframe;
import java.util.List;

public final class MapCameraKeyframeTrack extends NativeBase {

    public enum InstantiationErrorCode {
        EMPTY_KEYFRAME_LIST(1),
        INVALID_KEYFRAME_DURATION(2);
        
        public final int value;

        private InstantiationErrorCode(int i) {
            this.value = i;
        }
    }

    public static final class InstantiationException extends Exception {
        public final InstantiationErrorCode error;

        public InstantiationException(InstantiationErrorCode instantiationErrorCode) {
            super(instantiationErrorCode.toString());
            this.error = instantiationErrorCode;
        }
    }

    public MapCameraKeyframeTrack(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapCameraKeyframeTrack.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native MapCameraKeyframeTrack fieldOfView(@NonNull List<ScalarKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapCameraKeyframeTrack fieldOfView(@NonNull List<ScalarKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    public static native MapCameraKeyframeTrack lookAtDistance(@NonNull List<ScalarKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapCameraKeyframeTrack lookAtDistance(@NonNull List<ScalarKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    public static native MapCameraKeyframeTrack lookAtOrientation(@NonNull List<GeoOrientationKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapCameraKeyframeTrack lookAtOrientation(@NonNull List<GeoOrientationKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    public static native MapCameraKeyframeTrack lookAtTarget(@NonNull List<GeoCoordinatesKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapCameraKeyframeTrack lookAtTarget(@NonNull List<GeoCoordinatesKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    public static native MapCameraKeyframeTrack normalizedPrincipalPoint(@NonNull List<Anchor2DKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapCameraKeyframeTrack normalizedPrincipalPoint(@NonNull List<Anchor2DKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    public static native MapCameraKeyframeTrack principalPoint(@NonNull List<Point2DKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapCameraKeyframeTrack principalPoint(@NonNull List<Point2DKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @Nullable
    public native List<Anchor2DKeyframe> getAnchor2DKeyframes();

    @NonNull
    @Deprecated
    public native EasingFunction getEasingFunction();

    @Nullable
    public native List<GeoCoordinatesKeyframe> getGeoCoordinatesKeyframes();

    @Nullable
    public native List<GeoOrientationKeyframe> getGeoOrientationKeyframes();

    @NonNull
    public native KeyframeInterpolationMode getInterpolationMode();

    @Nullable
    public native List<Point2DKeyframe> getPoint2DKeyframes();

    @Nullable
    public native List<ScalarKeyframe> getScalarKeyframes();
}
