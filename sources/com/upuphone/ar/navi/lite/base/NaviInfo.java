package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class NaviInfo implements Serializable {
    private int curStepRetainDistance;
    private String currentRoadName;
    private int iconType;
    private int naviSpeed;
    private String nextRoadName;
    private int pathDistance;
    private int pathRetainDistance;
    private int pathRetainTime;
    private int routeRemainLightCount;

    public int getCurStepRetainDistance() {
        return this.curStepRetainDistance;
    }

    public String getCurrentRoadName() {
        return this.currentRoadName;
    }

    public int getIconType() {
        return this.iconType;
    }

    public int getNaviSpeed() {
        return this.naviSpeed;
    }

    public String getNextRoadName() {
        return this.nextRoadName;
    }

    public int getPathDistance() {
        return this.pathDistance;
    }

    public int getPathRetainDistance() {
        return this.pathRetainDistance;
    }

    public int getPathRetainTime() {
        return this.pathRetainTime;
    }

    public int getRouteRemainLightCount() {
        return this.routeRemainLightCount;
    }

    public void setCurStepRetainDistance(int i) {
        this.curStepRetainDistance = i;
    }

    public void setCurrentRoadName(String str) {
        this.currentRoadName = str;
    }

    public void setIconType(int i) {
        this.iconType = i;
    }

    public void setNaviSpeed(int i) {
        this.naviSpeed = i;
    }

    public void setNextRoadName(String str) {
        this.nextRoadName = str;
    }

    public void setPathDistance(int i) {
        this.pathDistance = i;
    }

    public void setPathRetainDistance(int i) {
        this.pathRetainDistance = i;
    }

    public void setPathRetainTime(int i) {
        this.pathRetainTime = i;
    }

    public void setRouteRemainLightCount(int i) {
        this.routeRemainLightCount = i;
    }
}
