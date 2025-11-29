package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class OffRoadProgressListenerImpl extends NativeBase implements OffRoadProgressListener {
    public OffRoadProgressListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OffRoadProgressListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onOffRoadProgressUpdated(@NonNull OffRoadProgress offRoadProgress);
}
