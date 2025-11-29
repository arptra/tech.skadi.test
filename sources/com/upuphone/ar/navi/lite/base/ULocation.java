package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class ULocation implements Serializable {
    private double accuracy;
    private String adcode;
    private String address;
    private double altitude;
    private double bearing;
    private String city;
    private String citycode;
    private String country;
    private String description;
    private String district;
    private int errorCode;
    private String errorInfo;
    private double latitude;
    private int locationType;
    private double longitude;
    private String poiName;
    private String provider;
    private String province;
    private String road;
    private double speed;
    private String street;

    public double getAccuracy() {
        return this.accuracy;
    }

    public String getAdcode() {
        return this.adcode;
    }

    public String getAddress() {
        return this.address;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public double getBearing() {
        return this.bearing;
    }

    public String getCity() {
        return this.city;
    }

    public String getCitycode() {
        return this.citycode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDistrict() {
        return this.district;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getProvince() {
        return this.province;
    }

    public String getRoad() {
        return this.road;
    }

    public double getSpeed() {
        return this.speed;
    }

    public String getStreet() {
        return this.street;
    }

    public void setAccuracy(double d) {
        this.accuracy = d;
    }

    public void setAdcode(String str) {
        this.adcode = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public void setBearing(double d) {
        this.bearing = d;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCitycode(String str) {
        this.citycode = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLocationType(int i) {
        this.locationType = i;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setPoiname(String str) {
        this.poiName = str;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRoad(String str) {
        this.road = str;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public String toString() {
        return "ULocation{latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + ", accuracy=" + this.accuracy + ", bearing=" + this.bearing + ", speed=" + this.speed + ", address='" + this.address + '\'' + ", district='" + this.district + '\'' + ", road='" + this.road + '\'' + ", street='" + this.street + '\'' + ", poiName='" + this.poiName + '\'' + ", citycode='" + this.citycode + '\'' + ", city='" + this.city + '\'' + ", adcode='" + this.adcode + '\'' + ", country='" + this.country + '\'' + ", province='" + this.province + '\'' + ", errorCode=" + this.errorCode + ", errorInfo='" + this.errorInfo + '\'' + ", locationType=" + this.locationType + ", description='" + this.description + '\'' + ", provider='" + this.provider + '\'' + '}';
    }
}
