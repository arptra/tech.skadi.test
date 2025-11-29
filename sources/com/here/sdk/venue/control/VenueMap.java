package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.venue.data.VenueGeometry;
import com.here.sdk.venue.data.VenueInfo;
import com.here.sdk.venue.service.VenueService;
import java.util.List;

public final class VenueMap extends NativeBase {
    public VenueMap(@NonNull VenueService venueService, @Nullable Renderer renderer) {
        this(make(venueService, renderer), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull VenueService venueService, @Nullable Renderer renderer);

    public native void add(@NonNull VenueDrawingSelectionListener venueDrawingSelectionListener);

    public native void add(@NonNull VenueLevelSelectionListener venueLevelSelectionListener);

    public native void add(@NonNull VenueLifecycleListener venueLifecycleListener);

    public native void add(@NonNull VenueSelectionListener venueSelectionListener);

    public native void addVenueAsync(int i);

    public native void addVenueAsync(int i, @NonNull VenueLoadErrorCallback venueLoadErrorCallback);

    public native boolean cancelVenueSelection();

    @Nullable
    public native VenueGeometry getGeometry(@NonNull GeoCoordinates geoCoordinates);

    @Nullable
    public native Renderer getRenderer();

    @Nullable
    public native Venue getSelectedVenue();

    @Nullable
    public native Venue getVenue(@NonNull GeoCoordinates geoCoordinates);

    @NonNull
    public native List<VenueInfo> getVenueInfoList();

    @NonNull
    public native List<VenueInfo> getVenueInfoList(@NonNull VenueLoadErrorCallback venueLoadErrorCallback);

    @NonNull
    public native VenueService getVenueService();

    public native void remove(@NonNull VenueDrawingSelectionListener venueDrawingSelectionListener);

    public native void remove(@NonNull VenueLevelSelectionListener venueLevelSelectionListener);

    public native void remove(@NonNull VenueLifecycleListener venueLifecycleListener);

    public native void remove(@NonNull VenueSelectionListener venueSelectionListener);

    public native void removeVenue(@NonNull Venue venue);

    public native void selectVenueAsync(int i);

    public native void selectVenueAsync(int i, @NonNull VenueLoadErrorCallback venueLoadErrorCallback);

    public native void setRenderer(@Nullable Renderer renderer);

    public native void setSelectedVenue(@Nullable Venue venue);

    public VenueMap(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueMap.disposeNativeHandle(j);
            }
        });
    }
}
