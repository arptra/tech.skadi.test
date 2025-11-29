package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Location;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.TaskHandle;
import java.util.List;

public final class RoutingEngine extends NativeBase implements RoutingInterface {
    public RoutingEngine() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @NonNull
    public native TaskHandle calculateIsoline(@NonNull Waypoint waypoint, @NonNull IsolineOptions isolineOptions, @NonNull CalculateIsolineCallback calculateIsolineCallback);

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
    public native String getLocalJsonResponse();

    @NonNull
    public native TaskHandle importRoute(@NonNull RouteHandle routeHandle, @NonNull RefreshRouteOptions refreshRouteOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull BicycleOptions bicycleOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull BusOptions busOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull CarOptions carOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull EVCarOptions eVCarOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull EVTruckOptions eVTruckOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull PedestrianOptions pedestrianOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull PrivateBusOptions privateBusOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull ScooterOptions scooterOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull TaxiOptions taxiOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull TruckOptions truckOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull BicycleOptions bicycleOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull BusOptions busOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull CarOptions carOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull EVCarOptions eVCarOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull EVTruckOptions eVTruckOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull PedestrianOptions pedestrianOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull PrivateBusOptions privateBusOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull ScooterOptions scooterOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull TaxiOptions taxiOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle importRoute(@NonNull List<Location> list, @NonNull List<RouteStop> list2, @NonNull TruckOptions truckOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    public native boolean isTestEnv();

    @NonNull
    public native TaskHandle refreshRoute(@NonNull RouteHandle routeHandle, @NonNull Waypoint waypoint, @NonNull RefreshRouteOptions refreshRouteOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle refreshRoute(@NonNull RouteHandle routeHandle, @Nullable Waypoint waypoint, @Nullable Integer num, @Nullable Integer num2, @NonNull RefreshRouteOptions refreshRouteOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    @Deprecated
    public native TaskHandle returnToRoute(@NonNull Route route, @NonNull Waypoint waypoint, double d, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle returnToRoute(@NonNull Route route, @NonNull Waypoint waypoint, int i, int i2, @NonNull CalculateRouteCallback calculateRouteCallback);

    @Nullable
    public native RoutingError setCustomOption(@NonNull String str, @Nullable String str2);

    public native void setLocalJsonResponse(@Nullable String str);

    public native void setTestEnv(boolean z);

    public RoutingEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public RoutingEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RoutingEngine.disposeNativeHandle(j);
            }
        });
    }
}
