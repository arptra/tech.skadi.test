package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class VenueInfo extends NativeBase {
    public VenueInfo(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueInfo.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native int getVenueId();

    @NonNull
    public native String getVenueIdentifier();

    @NonNull
    public native String getVenueName();
}
