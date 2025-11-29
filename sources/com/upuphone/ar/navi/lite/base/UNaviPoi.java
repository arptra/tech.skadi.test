package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class UNaviPoi implements Serializable {
    private double latitude;
    private double longitude;
    private String name;
    private String poiId;

    public UNaviPoi(String str, String str2, double d, double d2) {
        this.name = str;
        this.poiId = str2;
        this.latitude = d;
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public String toString() {
        return "UNaviPoi{name='" + this.name + '\'' + ", poiId='" + this.poiId + '\'' + ", latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }
}
