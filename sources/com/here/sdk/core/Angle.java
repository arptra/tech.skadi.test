package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class Angle extends NativeBase {
    public Angle(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Angle.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native Angle fromDegrees(double d);

    @NonNull
    public static native Angle fromRadians(double d);

    public native double getDegrees();

    public native double getRadians();
}
