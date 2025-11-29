package com.upuphone.ar.navi.lite.protocol;

import java.io.Serializable;

public class NaviInfoBean implements Serializable {
    private int adjustBrightness;
    private int gpsStatus;
    private int iconType;
    private String naviSpeed;
    private int nextRoadDistance;
    private String nextRoadName;
    private int pathDistance;
    private int pathRemainTime;
    private int pathRetainDistance;
    private int rideDistance;
    private int roadClass;
    private double routeDegree;
    private int routeRemainLightCount;

    public int getAdjustBrightness() {
        return this.adjustBrightness;
    }

    public int getGpsStatus() {
        return this.gpsStatus;
    }

    public int getIconType() {
        return this.iconType;
    }

    public String getNaviSpeed() {
        return this.naviSpeed;
    }

    public int getNextRoadDistance() {
        return this.nextRoadDistance;
    }

    public String getNextRoadName() {
        return this.nextRoadName;
    }

    public int getPathDistance() {
        return this.pathDistance;
    }

    public int getPathRemainTime() {
        return this.pathRemainTime;
    }

    public int getPathRetainDistance() {
        return this.pathRetainDistance;
    }

    public int getRideDistance() {
        return this.rideDistance;
    }

    public int getRoadClass() {
        return this.roadClass;
    }

    public double getRouteDegree() {
        return this.routeDegree;
    }

    public int getRouteRemainLightCount() {
        return this.routeRemainLightCount;
    }

    public void setAdjustBrightness(int i) {
        this.adjustBrightness = i;
    }

    public void setGpsStatus(int i) {
        this.gpsStatus = i;
    }

    public void setIconType(int i) {
        this.iconType = i;
    }

    public void setNaviSpeed(String str) {
        this.naviSpeed = str;
    }

    public void setNextRoadDistance(int i) {
        this.nextRoadDistance = i;
    }

    public void setNextRoadName(String str) {
        this.nextRoadName = str;
    }

    public void setPathDistance(int i) {
        this.pathDistance = i;
    }

    public void setPathRemainTime(int i) {
        this.pathRemainTime = i;
    }

    public void setPathRetainDistance(int i) {
        this.pathRetainDistance = i;
    }

    public void setRideDistance(int i) {
        this.rideDistance = i;
    }

    public void setRoadClass(int i) {
        this.roadClass = i;
    }

    public void setRouteDegree(double d) {
        this.routeDegree = d;
    }

    public void setRouteRemainLightCount(int i) {
        this.routeRemainLightCount = i;
    }

    public String toString() {
        return "NaviInfoBean{pathDistance=" + this.pathDistance + "pathRetainDistance=" + this.pathRetainDistance + ", pathRemainTime=" + this.pathRemainTime + ", iconType=" + this.iconType + ", nextRoadName='" + this.nextRoadName + '\'' + ", nextRoadDistance=" + this.nextRoadDistance + ", routeDegree=" + this.routeDegree + ", naviSpeed='" + this.naviSpeed + '\'' + ", gpsStatus=" + this.gpsStatus + ", rideDistance=" + this.rideDistance + ", roadClass=" + this.roadClass + ", adjustBrightness=" + this.adjustBrightness + ", routeRemainLightCount=" + this.routeRemainLightCount + '}';
    }
}
