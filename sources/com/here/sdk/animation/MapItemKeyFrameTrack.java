package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

public final class MapItemKeyFrameTrack extends NativeBase {

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

    public MapItemKeyFrameTrack(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapItemKeyFrameTrack.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native MapItemKeyFrameTrack moveTo(@NonNull List<GeoCoordinatesKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapItemKeyFrameTrack moveTo(@NonNull List<GeoCoordinatesKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    public static native MapItemKeyFrameTrack polylineProgress(@NonNull List<ScalarKeyframe> list, @NonNull Easing easing, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;

    @NonNull
    @Deprecated
    public static native MapItemKeyFrameTrack polylineProgress(@NonNull List<ScalarKeyframe> list, @NonNull EasingFunction easingFunction, @NonNull KeyframeInterpolationMode keyframeInterpolationMode) throws InstantiationException;
}
