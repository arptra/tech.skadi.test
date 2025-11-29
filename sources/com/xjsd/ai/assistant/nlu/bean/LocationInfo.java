package com.xjsd.ai.assistant.nlu.bean;

public class LocationInfo {
    private String latitude;
    private String longitude;
    private String type;

    public LocationInfo() {
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getType() {
        return "GCJ02";
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public LocationInfo(String str, String str2) {
        this.longitude = str;
        this.latitude = str2;
    }
}
