package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class DangerZoneWarningListenerImpl extends NativeBase implements DangerZoneWarningListener {
    public DangerZoneWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DangerZoneWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onDangerZoneWarningsUpdated(@NonNull DangerZoneWarning dangerZoneWarning);
}
