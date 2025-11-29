package com.here.sdk.core;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class AuthenticationCallbackImpl extends NativeBase implements AuthenticationCallback {
    public AuthenticationCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                AuthenticationCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onTokenReceived(@Nullable AuthenticationError authenticationError, @Nullable AuthenticationData authenticationData);
}
