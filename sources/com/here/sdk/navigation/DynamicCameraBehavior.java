package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;

public final class DynamicCameraBehavior extends NativeBase implements CameraBehavior {
    public DynamicCameraBehavior() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    @NonNull
    public native Anchor2D getNormalizedPrincipalPoint();

    public native void setNormalizedPrincipalPoint(@NonNull Anchor2D anchor2D);

    public DynamicCameraBehavior(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DynamicCameraBehavior.disposeNativeHandle(j);
            }
        });
    }
}
