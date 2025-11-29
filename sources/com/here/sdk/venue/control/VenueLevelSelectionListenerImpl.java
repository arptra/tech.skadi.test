package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.venue.data.VenueDrawing;
import com.here.sdk.venue.data.VenueLevel;

class VenueLevelSelectionListenerImpl extends NativeBase implements VenueLevelSelectionListener {
    public VenueLevelSelectionListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueLevelSelectionListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onLevelSelected(@NonNull Venue venue, @NonNull VenueDrawing venueDrawing, @Nullable VenueLevel venueLevel, @NonNull VenueLevel venueLevel2);
}
