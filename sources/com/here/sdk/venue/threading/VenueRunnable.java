package com.here.sdk.venue.threading;

import com.here.NativeBase;

final class VenueRunnable extends NativeBase {
    public VenueRunnable(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueRunnable.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void run();
}
