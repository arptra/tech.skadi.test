package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Location;

class InterpolatedLocationListenerImpl extends NativeBase implements InterpolatedLocationListener {
    public InterpolatedLocationListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                InterpolatedLocationListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onInterpolatedLocationUpdated(@NonNull Location location);
}
