package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class TollStopWarningListenerImpl extends NativeBase implements TollStopWarningListener {
    public TollStopWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TollStopWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onTollStopWarning(@NonNull TollStop tollStop);
}
