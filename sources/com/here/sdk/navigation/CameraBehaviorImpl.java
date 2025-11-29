package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;

class CameraBehaviorImpl extends NativeBase implements CameraBehavior {
    public CameraBehaviorImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CameraBehaviorImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native Anchor2D getNormalizedPrincipalPoint();

    public native void setNormalizedPrincipalPoint(@NonNull Anchor2D anchor2D);
}
