package com.here.sdk.venue.threading;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class VenueThreadsImpl extends NativeBase implements VenueThreads {
    public VenueThreadsImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueThreadsImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void createThread(@NonNull String str, @NonNull VenueRunnable venueRunnable);

    public native void postToMainThread(@NonNull VenueRunnable venueRunnable);
}
