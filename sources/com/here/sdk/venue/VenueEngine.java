package com.here.sdk.venue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.AuthenticationCallback;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.venue.control.VenueMap;
import com.here.sdk.venue.service.VenueService;

public final class VenueEngine extends NativeBase {
    public VenueEngine(@Nullable VenueEngineInitCallback venueEngineInitCallback) throws InstantiationErrorException {
        this(make(venueEngineInitCallback), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine, @Nullable VenueEngineInitCallback venueEngineInitCallback) throws InstantiationErrorException;

    private static native long make(@Nullable VenueEngineInitCallback venueEngineInitCallback) throws InstantiationErrorException;

    public native void destroy();

    @NonNull
    public native VenueMap getVenueMap();

    @NonNull
    public native VenueService getVenueService();

    public native void start(@Nullable AuthenticationCallback authenticationCallback);

    public native void start(@NonNull String str);

    public VenueEngine(@NonNull SDKNativeEngine sDKNativeEngine, @Nullable VenueEngineInitCallback venueEngineInitCallback) throws InstantiationErrorException {
        this(make(sDKNativeEngine, venueEngineInitCallback), (Object) null);
        cacheThisInstance();
    }

    public VenueEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueEngine.disposeNativeHandle(j);
            }
        });
    }
}
