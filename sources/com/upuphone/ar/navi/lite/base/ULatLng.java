package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class ULatLng implements Serializable {
    public double latitude;
    public double longitude;

    public ULatLng(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public String toString() {
        return "CLatLng{latitude=" + this.latitude + '\'' + ", longitude=" + this.longitude + '\'' + '}';
    }
}
