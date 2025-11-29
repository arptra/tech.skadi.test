package com.here.sdk.core.threading;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class Threading extends NativeBase {
    public Threading(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Threading.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native PlatformThreading getPlatformThreading();

    public static native void setPlatformThreading(@NonNull PlatformThreading platformThreading);
}
