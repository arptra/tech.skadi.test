package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.venue.data.VenueDrawing;

class VenueDrawingSelectionListenerImpl extends NativeBase implements VenueDrawingSelectionListener {
    public VenueDrawingSelectionListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueDrawingSelectionListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onDrawingSelected(@NonNull Venue venue, @Nullable VenueDrawing venueDrawing, @NonNull VenueDrawing venueDrawing2);
}
