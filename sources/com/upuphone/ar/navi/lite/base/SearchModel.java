package com.upuphone.ar.navi.lite.base;

import com.upuphone.ar.navi.lite.util.NaviUtil;
import java.io.Serializable;

public class SearchModel implements Comparable<SearchModel>, Serializable {
    private String accountId = NaviUtil.t();
    private String acode;
    private String address;
    private String alias;
    private String city;
    private int distance;
    private String district;
    private String keywords;
    private double latitude;
    private double longitude;
    private String name;
    private int naviMode = -1;
    private int strategy;
    private int type;

    public String getAccountId() {
        return this.accountId;
    }

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

    public String getDistrict() {
        return this.district;
    }

    public String getKeywords() {
        return this.keywords;
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

    public int getStrategy() {
        return this.strategy;
    }

    public int getType() {
        return this.type;
    }

    public void setAccountId(String str) {
        this.accountId = str;
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

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setKeywords(String str) {
        this.keywords = str;
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

    public void setStrategy(int i) {
        this.strategy = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "SearchModel{name='" + this.name + '\'' + ", acode='" + this.acode + '\'' + ", address='" + this.address + '\'' + ", district='" + this.district + '\'' + ", city='" + this.city + '\'' + ", keywords='" + this.keywords + '\'' + ", distance=" + this.distance + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", type=" + this.type + ", naviMode=" + this.naviMode + ", strategy=" + this.strategy + ", alias='" + this.alias + '\'' + ", accountId='" + this.accountId + '\'' + '}';
    }

    public int compareTo(SearchModel searchModel) {
        try {
            return Integer.parseInt(getAcode()) - Integer.parseInt(searchModel.getAcode());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
