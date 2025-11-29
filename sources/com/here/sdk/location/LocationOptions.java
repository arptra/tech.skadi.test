package com.here.sdk.location;

import androidx.annotation.NonNull;

public final class LocationOptions {
    @NonNull
    public CellularPositioningOptions cellularPositioningOptions;
    @NonNull
    public NotificationOptions notificationOptions;
    @NonNull
    public SatellitePositioningOptions satellitePositioningOptions;
    @NonNull
    public SensorOptions sensorOptions;
    @NonNull
    public WifiPositioningOptions wifiPositioningOptions;

    public LocationOptions() {
        LocationOptions make = make();
        this.notificationOptions = make.notificationOptions;
        this.sensorOptions = make.sensorOptions;
        this.cellularPositioningOptions = make.cellularPositioningOptions;
        this.satellitePositioningOptions = make.satellitePositioningOptions;
        this.wifiPositioningOptions = make.wifiPositioningOptions;
    }

    private static native LocationOptions make();

    private static native LocationOptions make(@NonNull LocationAccuracy locationAccuracy);

    public LocationOptions(@NonNull LocationAccuracy locationAccuracy) {
        LocationOptions make = make(locationAccuracy);
        this.notificationOptions = make.notificationOptions;
        this.sensorOptions = make.sensorOptions;
        this.cellularPositioningOptions = make.cellularPositioningOptions;
        this.satellitePositioningOptions = make.satellitePositioningOptions;
        this.wifiPositioningOptions = make.wifiPositioningOptions;
    }
}
