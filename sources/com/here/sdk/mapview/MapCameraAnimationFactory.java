package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.animation.Easing;
import com.here.sdk.animation.EasingFunction;
import com.here.sdk.core.GeoCoordinatesUpdate;
import com.here.sdk.core.GeoOrientationUpdate;
import com.here.sdk.mapview.MapCameraAnimation;
import com.here.time.Duration;
import java.util.List;

public final class MapCameraAnimationFactory extends NativeBase {
    public MapCameraAnimationFactory(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapCameraAnimationFactory.disposeNativeHandle(j);
            }
        });
    }

    @NonNull
    public static native MapCameraAnimation createAnimation(@NonNull MapCameraKeyframeTrack mapCameraKeyframeTrack);

    @NonNull
    public static native MapCameraAnimation createAnimation(@NonNull MapCameraUpdate mapCameraUpdate, @NonNull Duration duration, @NonNull Easing easing);

    @NonNull
    @Deprecated
    public static native MapCameraAnimation createAnimation(@NonNull MapCameraUpdate mapCameraUpdate, @NonNull Duration duration, @NonNull EasingFunction easingFunction);

    @NonNull
    public static native MapCameraAnimation createAnimation(@NonNull List<MapCameraKeyframeTrack> list) throws MapCameraAnimation.InstantiationException;

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native MapCameraAnimation flyTo(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, double d, @NonNull Duration duration);

    @NonNull
    public static native MapCameraAnimation flyTo(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, @NonNull GeoOrientationUpdate geoOrientationUpdate, double d, @NonNull Duration duration);

    @NonNull
    public static native MapCameraAnimation flyTo(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull MapMeasure mapMeasure, double d, @NonNull Duration duration);

    @NonNull
    public static native MapCameraAnimation flyTo(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, @NonNull MapMeasure mapMeasure, double d, @NonNull Duration duration);
}
