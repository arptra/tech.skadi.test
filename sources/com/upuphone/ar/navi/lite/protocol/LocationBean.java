package com.upuphone.ar.navi.lite.protocol;

import java.io.Serializable;

public class LocationBean implements Serializable {
    private long ack;
    private String identity;
    private String naviSpeed;
    private double routeDegree;

    public LocationBean(double d, String str) {
        this.routeDegree = d;
        this.naviSpeed = str;
    }

    public long getAck() {
        return this.ack;
    }

    public String getIdentity() {
        return this.identity;
    }

    public String getNaviSpeed() {
        return this.naviSpeed;
    }

    public double getRouteDegree() {
        return this.routeDegree;
    }

    public void setAck(long j) {
        this.ack = j;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public void setNaviSpeed(String str) {
        this.naviSpeed = str;
    }

    public void setRouteDegree(double d) {
        this.routeDegree = d;
    }
}
