package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

class EnvironmentalZoneWarningListenerImpl extends NativeBase implements EnvironmentalZoneWarningListener {
    public EnvironmentalZoneWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                EnvironmentalZoneWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onEnvironmentalZoneWarningsUpdated(@NonNull List<EnvironmentalZoneWarning> list);
}
