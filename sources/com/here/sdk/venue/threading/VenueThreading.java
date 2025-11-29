package com.here.sdk.venue.threading;

import androidx.annotation.NonNull;
import com.here.NativeBase;

final class VenueThreading extends NativeBase {
    public VenueThreading(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueThreading.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native VenueThreads getFactory();

    public static native void setFactory(@NonNull VenueThreads venueThreads);
}
