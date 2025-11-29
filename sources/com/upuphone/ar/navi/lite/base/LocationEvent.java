package com.upuphone.ar.navi.lite.base;

public class LocationEvent {
    private final double latitude;
    private final double longitude;

    public LocationEvent(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
