package com.here.sdk.traffic;

import com.here.NativeBase;

public final class TrafficDataProvider extends NativeBase {
    public TrafficDataProvider(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficDataProvider.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
