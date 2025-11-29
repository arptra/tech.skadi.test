package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.threading.TaskHandle;
import java.util.List;

class RoutingInterfaceImpl extends NativeBase implements RoutingInterface {
    public RoutingInterfaceImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RoutingInterfaceImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

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

    @NonNull
    @Deprecated
    public native TaskHandle returnToRoute(@NonNull Route route, @NonNull Waypoint waypoint, double d, @NonNull CalculateRouteCallback calculateRouteCallback);

    @NonNull
    public native TaskHandle returnToRoute(@NonNull Route route, @NonNull Waypoint waypoint, int i, int i2, @NonNull CalculateRouteCallback calculateRouteCallback);
}
