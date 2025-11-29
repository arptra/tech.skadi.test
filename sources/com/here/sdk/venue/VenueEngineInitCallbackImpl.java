package com.here.sdk.venue;

import com.here.NativeBase;

class VenueEngineInitCallbackImpl extends NativeBase implements VenueEngineInitCallback {
    public VenueEngineInitCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueEngineInitCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onVenueEngineInit();
}
