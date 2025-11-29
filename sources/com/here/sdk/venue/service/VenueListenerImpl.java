package com.here.sdk.venue.service;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.venue.data.VenueModel;
import com.here.sdk.venue.style.VenueStyle;

class VenueListenerImpl extends NativeBase implements VenueListener {
    public VenueListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onGetVenueCompleted(int i, @Nullable VenueModel venueModel, boolean z, @Nullable VenueStyle venueStyle);
}
