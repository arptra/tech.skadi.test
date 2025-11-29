package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class RoadSignWarningListenerImpl extends NativeBase implements RoadSignWarningListener {
    public RoadSignWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RoadSignWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onRoadSignWarningUpdated(@NonNull RoadSignWarning roadSignWarning);
}
