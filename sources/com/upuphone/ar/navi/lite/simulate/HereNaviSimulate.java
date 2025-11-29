package com.upuphone.ar.navi.lite.simulate;

import com.here.sdk.core.LocationListener;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.navigation.LocationSimulator;
import com.here.sdk.navigation.LocationSimulatorOptions;
import com.here.sdk.routing.Route;
import com.here.time.Duration;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public class HereNaviSimulate implements INaviSimulate {
    public static HereNaviSimulate b;

    /* renamed from: a  reason: collision with root package name */
    public LocationSimulator f5805a;

    public static HereNaviSimulate d() {
        if (b == null) {
            b = new HereNaviSimulate();
        }
        return b;
    }

    public void a() {
        LocationSimulator locationSimulator = this.f5805a;
        if (locationSimulator != null) {
            locationSimulator.stop();
            this.f5805a = null;
        }
    }

    public void b() {
        LocationSimulator locationSimulator = this.f5805a;
        if (locationSimulator != null) {
            locationSimulator.stop();
        }
        LocationSimulator c = c(HereNaviManager.v0().J0(), HereNaviManager.v0().t0());
        this.f5805a = c;
        c.start();
    }

    public final LocationSimulator c(LocationListener locationListener, Route route) {
        LocationSimulatorOptions locationSimulatorOptions = new LocationSimulatorOptions();
        locationSimulatorOptions.speedFactor = 2.0d;
        locationSimulatorOptions.notificationInterval = Duration.ofMillis(500);
        try {
            LocationSimulator locationSimulator = new LocationSimulator(route, locationSimulatorOptions);
            locationSimulator.setListener(locationListener);
            return locationSimulator;
        } catch (InstantiationErrorException e) {
            throw new RuntimeException("Initialization of LocationSimulator failed: " + e.error.name());
        }
    }
}
