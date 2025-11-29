package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class PlaceBean implements Serializable {
    private String adCode = "";
    private String address = "";
    private String city = "";
    private String cityCode = "";
    public String country = "";
    public String countryCode = "";
    private int distance = 0;
    private String district = "";
    private int errorCode = -100;
    private String errorInfo = "";
    private double latitude = 0.0d;
    private double longitude = 0.0d;
    private String poiId = "";
    private String poiName = "";
    private String poiTypeCode = "";
    private String province = "";
    private String street = "";

    public String getAdCode() {
        return this.adCode;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public int getDistance() {
        return this.distance;
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

    public double getLongitude() {
        return this.longitude;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public String getPoiTypeCode() {
        return this.poiTypeCode;
    }

    public String getProvince() {
        return this.province;
    }

    public String getStreet() {
        return this.street;
    }

    public void setAdCode(String str) {
        this.adCode = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setDistance(int i) {
        this.distance = i;
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

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public void setPoiName(String str) {
        this.poiName = str;
    }

    public void setPoiTypeCode(String str) {
        this.poiTypeCode = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public String toString() {
        return "PlaceBean{adCode='" + this.adCode + '\'' + ", address='" + this.address + '\'' + ", city='" + this.city + '\'' + ", cityCode='" + this.cityCode + '\'' + ", district='" + this.district + '\'' + ", errorInfo='" + this.errorInfo + '\'' + ", latitude=" + this.latitude + '\'' + ", longitude=" + this.longitude + '\'' + ", poiName='" + this.poiName + '\'' + ", countryCode='" + this.countryCode + '\'' + ", country='" + this.country + '\'' + ", province='" + this.province + '\'' + ", street='" + this.street + '\'' + ", errorCode=" + this.errorCode + '\'' + ", distance=" + this.distance + '\'' + ", poiId='" + this.poiId + '\'' + ", poiTypeCode='" + this.poiTypeCode + '\'' + '}';
    }
}
