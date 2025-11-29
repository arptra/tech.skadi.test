package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.transport.TransportMode;

public final class RefreshRouteOptions extends NativeBase {
    public RefreshRouteOptions(@NonNull TransportMode transportMode) {
        this(make(transportMode), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull BicycleOptions bicycleOptions);

    private static native long make(@NonNull BusOptions busOptions);

    private static native long make(@NonNull CarOptions carOptions);

    private static native long make(@NonNull EVCarOptions eVCarOptions);

    private static native long make(@NonNull EVTruckOptions eVTruckOptions);

    private static native long make(@NonNull PedestrianOptions pedestrianOptions);

    private static native long make(@NonNull PrivateBusOptions privateBusOptions);

    private static native long make(@NonNull ScooterOptions scooterOptions);

    private static native long make(@NonNull TaxiOptions taxiOptions);

    private static native long make(@NonNull TruckOptions truckOptions);

    private static native long make(@NonNull TransportMode transportMode);

    public RefreshRouteOptions(@NonNull CarOptions carOptions) {
        this(make(carOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull TruckOptions truckOptions) {
        this(make(truckOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull PedestrianOptions pedestrianOptions) {
        this(make(pedestrianOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull ScooterOptions scooterOptions) {
        this(make(scooterOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull TaxiOptions taxiOptions) {
        this(make(taxiOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull EVCarOptions eVCarOptions) {
        this(make(eVCarOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull EVTruckOptions eVTruckOptions) {
        this(make(eVTruckOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull BicycleOptions bicycleOptions) {
        this(make(bicycleOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull BusOptions busOptions) {
        this(make(busOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(@NonNull PrivateBusOptions privateBusOptions) {
        this(make(privateBusOptions), (Object) null);
        cacheThisInstance();
    }

    public RefreshRouteOptions(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RefreshRouteOptions.disposeNativeHandle(j);
            }
        });
    }
}
