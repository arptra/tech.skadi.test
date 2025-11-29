package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.LocationListener;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.routing.Route;

public final class LocationSimulator extends NativeBase {
    public LocationSimulator(@NonNull Route route, @NonNull LocationSimulatorOptions locationSimulatorOptions) throws InstantiationErrorException {
        this(make(route, locationSimulatorOptions), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull GPXTrack gPXTrack, @NonNull LocationSimulatorOptions locationSimulatorOptions) throws InstantiationErrorException;

    private static native long make(@NonNull Route route, @NonNull LocationSimulatorOptions locationSimulatorOptions) throws InstantiationErrorException;

    @Nullable
    public native LocationListener getListener();

    public native void pause();

    public native void resume();

    public native void setListener(@Nullable LocationListener locationListener);

    public native void start();

    public native void stop();

    public LocationSimulator(@NonNull GPXTrack gPXTrack, @NonNull LocationSimulatorOptions locationSimulatorOptions) throws InstantiationErrorException {
        this(make(gPXTrack, locationSimulatorOptions), (Object) null);
        cacheThisInstance();
    }

    public LocationSimulator(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationSimulator.disposeNativeHandle(j);
            }
        });
    }
}
