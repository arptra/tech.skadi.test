package com.here.sdk.location;

import androidx.annotation.NonNull;
import com.here.NativeBase;

interface FeatureChecker {

    @FunctionalInterface
    public interface AuthorizationCallback {
        void apply(@NonNull LocationFeature locationFeature, boolean z, int i);
    }

    public static class AuthorizationCallbackImpl extends NativeBase implements AuthorizationCallback {
        public AuthorizationCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    AuthorizationCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void apply(@NonNull LocationFeature locationFeature, boolean z, int i);
    }

    void checkFeatureAuthorization(@NonNull LocationFeature locationFeature, @NonNull AuthorizationCallback authorizationCallback);
}
