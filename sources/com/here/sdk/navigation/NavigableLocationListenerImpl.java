package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class NavigableLocationListenerImpl extends NativeBase implements NavigableLocationListener {
    public NavigableLocationListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                NavigableLocationListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onNavigableLocationUpdated(@NonNull NavigableLocation navigableLocation);
}
