package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.TaskHandle;
import com.here.sdk.traffic.TrafficDataProvider;
import java.util.List;

public final class OfflineRoutingEngine extends NativeBase implements RoutingInterface {
    public OfflineRoutingEngine() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull OfflineRoutingEngineOptions offlineRoutingEngineOptions) throws InstantiationErrorException;

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull BicycleOptions bicycleOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull BusOptions busOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull CarOptions carOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull EVCarOptions eVCarOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull EVTruckOptions eVTruckOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull PedestrianOptions pedestrianOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull PrivateBusOptions privateBusOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull ScooterOptions scooterOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull TaxiOptions taxiOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle calculateRoute(@NonNull List<Waypoint> list, @NonNull TruckOptions truckOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @Nullable
    public native TrafficDataProvider getTrafficDataProvider();

    @NonNull
    @Deprecated
    public native TaskHandle returnToRoute(@NonNull Route route, @NonNull Waypoint waypoint, double d, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle returnToRoute(@NonNull Route route, @NonNull Waypoint waypoint, int i, int i2, @NonNull CalculateRouteCallback calculateRouteCallback);

    public native void setTrafficDataProvider(@Nullable TrafficDataProvider trafficDataProvider);

    public OfflineRoutingEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public OfflineRoutingEngine(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull OfflineRoutingEngineOptions offlineRoutingEngineOptions) throws InstantiationErrorException {
        this(make(sDKNativeEngine, offlineRoutingEngineOptions), (Object) null);
        cacheThisInstance();
    }

    public OfflineRoutingEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OfflineRoutingEngine.disposeNativeHandle(j);
            }
        });
    }
}
