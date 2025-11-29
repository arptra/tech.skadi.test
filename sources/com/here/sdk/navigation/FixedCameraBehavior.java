package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;

public final class FixedCameraBehavior extends NativeBase implements CameraBehavior {
    public FixedCameraBehavior() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    @Nullable
    public native Double getCameraBearingInDegrees();

    public native double getCameraDistanceInMeters();

    public native double getCameraTiltInDegrees();

    @NonNull
    public native Anchor2D getNormalizedPrincipalPoint();

    public native void setCameraBearingInDegrees(@Nullable Double d);

    public native void setCameraDistanceInMeters(double d);

    public native void setCameraTiltInDegrees(double d);

    public native void setNormalizedPrincipalPoint(@NonNull Anchor2D anchor2D);

    public FixedCameraBehavior(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                FixedCameraBehavior.disposeNativeHandle(j);
            }
        });
    }
}
