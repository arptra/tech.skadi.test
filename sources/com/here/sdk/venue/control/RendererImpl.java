package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.venue.data.VenueGeometry;
import java.util.List;

class RendererImpl extends NativeBase implements Renderer {
    public RendererImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RendererImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addVenue(@NonNull Venue venue);

    public native boolean center(@NonNull VenueGeometry venueGeometry);

    @NonNull
    public native GeoBox getViewRectangle();

    public native float getZoomLevel();

    public native void removeVenue(@NonNull Venue venue);

    public native void selectVenue(@NonNull Venue venue);

    public native void update();

    public native void updateGeometries(@NonNull Venue venue, @NonNull List<VenueGeometry> list);
}
