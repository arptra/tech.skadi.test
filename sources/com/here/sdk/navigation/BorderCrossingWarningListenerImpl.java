package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class BorderCrossingWarningListenerImpl extends NativeBase implements BorderCrossingWarningListener {
    public BorderCrossingWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                BorderCrossingWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onBorderCrossingWarningUpdated(@NonNull BorderCrossingWarning borderCrossingWarning);
}
