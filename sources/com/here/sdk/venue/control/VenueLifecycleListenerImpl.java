package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class VenueLifecycleListenerImpl extends NativeBase implements VenueLifecycleListener {
    public VenueLifecycleListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueLifecycleListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onVenueAdded(@NonNull Venue venue);

    public native void onVenueRemoved(int i);
}
