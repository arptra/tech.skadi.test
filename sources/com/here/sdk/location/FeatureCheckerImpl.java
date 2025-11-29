package com.here.sdk.location;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.location.FeatureChecker;

class FeatureCheckerImpl extends NativeBase implements FeatureChecker {
    public FeatureCheckerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                FeatureCheckerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void checkFeatureAuthorization(@NonNull LocationFeature locationFeature, @NonNull FeatureChecker.AuthorizationCallback authorizationCallback);
}
