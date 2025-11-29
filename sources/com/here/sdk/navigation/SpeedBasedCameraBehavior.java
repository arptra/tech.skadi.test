package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.mapview.MapMeasure;
import java.util.List;

public final class SpeedBasedCameraBehavior extends NativeBase implements CameraBehavior {

    public static final class ProfileValue {
        public double fromMetersPerSecond;
        public double tiltInDegrees;
        public double toMetersPerSecond;
        @NonNull
        public MapMeasure zoom;

        public ProfileValue(double d, double d2, @NonNull MapMeasure mapMeasure, double d3) {
            this.fromMetersPerSecond = d;
            this.toMetersPerSecond = d2;
            this.zoom = mapMeasure;
            this.tiltInDegrees = d3;
        }
    }

    public SpeedBasedCameraBehavior() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    @NonNull
    public static native List<ProfileValue> default2DProfile();

    @NonNull
    public static native List<ProfileValue> default3DProfile();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    @NonNull
    public native Anchor2D getNormalizedPrincipalPoint();

    @NonNull
    public native List<ProfileValue> getProfile();

    public native void setNormalizedPrincipalPoint(@NonNull Anchor2D anchor2D);

    public native void setProfile(@NonNull List<ProfileValue> list);

    public SpeedBasedCameraBehavior(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SpeedBasedCameraBehavior.disposeNativeHandle(j);
            }
        });
    }
}
