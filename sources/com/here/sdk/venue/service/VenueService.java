package com.here.sdk.venue.service;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

public final class VenueService extends NativeBase {
    public VenueService(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueService.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void add(@NonNull VenueListener venueListener);

    public native void add(@NonNull VenueServiceListener venueServiceListener);

    public native void addVenueToLoad(int i);

    @NonNull
    public native VenueServiceInitStatus getInitStatus();

    @NonNull
    public native String getLanguage();

    @NonNull
    public native List<String> getLanguages();

    public native boolean isInitialized();

    public native void loadTopologies();

    public native void remove(@NonNull VenueListener venueListener);

    public native void remove(@NonNull VenueServiceListener venueServiceListener);

    public native void setHrn(@NonNull String str);

    public native void setLabeltextPreference(@NonNull List<String> list);

    public native void setLanguage(@NonNull String str);

    public native void stop();
}
