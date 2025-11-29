package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class NaviAbnormalRecod implements Serializable {
    private String acode;
    private String address;
    private String alias;
    private String city;
    private int distance;
    private double latitude;
    private double longitude;
    private String name;
    private int naviMode = -1;

    public String getAcode() {
        return this.acode;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCity() {
        return this.city;
    }

    public int getDistance() {
        return this.distance;
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

    public int getNaviMode() {
        return this.naviMode;
    }

    public void setAcode(String str) {
        this.acode = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setDistance(int i) {
        this.distance = i;
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

    public void setNaviMode(int i) {
        this.naviMode = i;
    }

    public String toString() {
        return "NaviAbnormalRecod{name='" + this.name + ", address='" + this.address + ", acode='" + this.acode + ", city='" + this.city + ", distance=" + this.distance + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", alias='" + this.alias + ", naviMode=" + this.naviMode + '}';
    }
}
