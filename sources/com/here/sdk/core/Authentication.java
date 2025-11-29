package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.threading.PlatformThreading;

public final class Authentication extends NativeBase {
    public Authentication(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Authentication.disposeNativeHandle(j);
            }
        });
    }

    @NonNull
    public static native AuthenticationData authenticate(@NonNull SDKNativeEngine sDKNativeEngine) throws AuthenticationException;

    public static native void authenticate(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull AuthenticationCallback authenticationCallback);

    public static native void authenticate(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull AuthenticationCallback authenticationCallback, @NonNull PlatformThreading platformThreading);

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
