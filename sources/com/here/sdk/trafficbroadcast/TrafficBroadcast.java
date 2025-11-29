package com.here.sdk.trafficbroadcast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Location;
import com.here.sdk.core.LocationListener;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.traffic.TrafficDataProvider;

public final class TrafficBroadcast extends NativeBase implements LocationListener {
    public TrafficBroadcast(@NonNull TrafficBroadcastParameters trafficBroadcastParameters) throws InstantiationErrorException {
        this(make(trafficBroadcastParameters), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull TrafficBroadcastParameters trafficBroadcastParameters) throws InstantiationErrorException;

    private static native long make(@NonNull TrafficBroadcastParameters trafficBroadcastParameters) throws InstantiationErrorException;

    public native void activate();

    public native void deactivate();

    @Nullable
    public native TrafficDataProvider getTrafficDataProvider();

    public native void onLocationUpdated(@NonNull Location location);

    public native void onTMCDataUpdated(@NonNull TMCData tMCData);

    public native void onTMCServiceProviderInfoUpdated(@NonNull TMCServiceProviderInfo tMCServiceProviderInfo);

    public TrafficBroadcast(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull TrafficBroadcastParameters trafficBroadcastParameters) throws InstantiationErrorException {
        this(make(sDKNativeEngine, trafficBroadcastParameters), (Object) null);
        cacheThisInstance();
    }

    public TrafficBroadcast(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficBroadcast.disposeNativeHandle(j);
            }
        });
    }
}
