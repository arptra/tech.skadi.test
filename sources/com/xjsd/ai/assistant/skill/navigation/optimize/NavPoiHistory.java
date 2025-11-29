package com.xjsd.ai.assistant.skill.navigation.optimize;

import com.upuphone.xr.interconnect.entity.PoiResult;

public class NavPoiHistory extends PoiResult {
    private String navMode;
    private String routeMode;

    public NavPoiHistory() {
    }

    public String getNavMode() {
        return this.navMode;
    }

    public String getRouteMode() {
        return this.routeMode;
    }

    public void setNavMode(String str) {
        this.navMode = str;
    }

    public void setRouteMode(String str) {
        this.routeMode = str;
    }

    public NavPoiHistory(PoiResult poiResult, String str, String str2) {
        setName(poiResult.getName());
        setDistance(poiResult.getDistance());
        setAddress(poiResult.getAddress());
        setLatitude(poiResult.getLatitude());
        setLongitude(poiResult.getLongitude());
        setPoiId(poiResult.getPoiId());
        this.navMode = str;
        this.routeMode = str2;
    }
}
