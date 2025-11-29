package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class SafetyCameraWarningListenerImpl extends NativeBase implements SafetyCameraWarningListener {
    public SafetyCameraWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SafetyCameraWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSafetyCameraWarningUpdated(@NonNull SafetyCameraWarning safetyCameraWarning);
}
