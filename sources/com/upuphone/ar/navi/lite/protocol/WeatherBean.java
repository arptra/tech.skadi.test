package com.upuphone.ar.navi.lite.protocol;

import java.io.Serializable;

public class WeatherBean implements Serializable {
    private String areaName;
    private String city;
    private String province;
    private String sunriseTime;
    private String sunsetTime;

    public String getAreaName() {
        return this.areaName;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }

    public String getSunriseTime() {
        return this.sunriseTime;
    }

    public String getSunsetTime() {
        return this.sunsetTime;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setSunriseTime(String str) {
        this.sunriseTime = str;
    }

    public void setSunsetTime(String str) {
        this.sunsetTime = str;
    }

    public String toString() {
        return "WeatherBean{areaName='" + this.areaName + '\'' + ", city='" + this.city + '\'' + ", province='" + this.province + '\'' + ", sunriseTime='" + this.sunriseTime + '\'' + ", sunsetTime='" + this.sunsetTime + '\'' + '}';
    }
}
