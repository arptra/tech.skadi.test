package com.here.sdk.venue.service;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class VenueServiceListenerImpl extends NativeBase implements VenueServiceListener {
    public VenueServiceListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueServiceListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onInitializationCompleted(@NonNull VenueServiceInitStatus venueServiceInitStatus);

    public native void onVenueServiceStopped();
}
