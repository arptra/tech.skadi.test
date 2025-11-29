package com.here.sdk.venue.control;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class VenueSelectionListenerImpl extends NativeBase implements VenueSelectionListener {
    public VenueSelectionListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueSelectionListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSelectedVenueChanged(@Nullable Venue venue, @Nullable Venue venue2);
}
