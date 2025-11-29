package com.here.sdk.core.threading;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class PlatformThreadingImpl extends NativeBase implements PlatformThreading {
    public PlatformThreadingImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PlatformThreadingImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native TaskHandle postToMainThread(@NonNull Runnable runnable);

    @NonNull
    public native TaskHandle postToMainThread(@NonNull Runnable runnable, long j);

    @NonNull
    public native TaskHandle runOnMainThread(@NonNull Runnable runnable);
}
