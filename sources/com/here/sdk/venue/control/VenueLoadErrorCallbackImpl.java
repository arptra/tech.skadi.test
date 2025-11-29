package com.here.sdk.venue.control;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class VenueLoadErrorCallbackImpl extends NativeBase implements VenueLoadErrorCallback {
    public VenueLoadErrorCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueLoadErrorCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onVenueLoadError(@Nullable VenueErrorCode venueErrorCode);
}
