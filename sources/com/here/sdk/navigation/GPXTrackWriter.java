package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Location;
import com.here.sdk.core.LocationListener;

public final class GPXTrackWriter extends NativeBase implements LocationListener {
    public GPXTrackWriter() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    private static native long make(@NonNull GPXTrack gPXTrack);

    @NonNull
    public native GPXTrack getTrack();

    public native void onLocationUpdated(@NonNull Location location);

    public GPXTrackWriter(@NonNull GPXTrack gPXTrack) {
        this(make(gPXTrack), (Object) null);
        cacheThisInstance();
    }

    public GPXTrackWriter(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                GPXTrackWriter.disposeNativeHandle(j);
            }
        });
    }
}
