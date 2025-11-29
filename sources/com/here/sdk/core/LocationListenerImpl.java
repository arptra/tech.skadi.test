package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class LocationListenerImpl extends NativeBase implements LocationListener {
    public LocationListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onLocationUpdated(@NonNull Location location);
}
