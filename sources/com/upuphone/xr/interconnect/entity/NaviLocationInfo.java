package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class NaviLocationInfo implements Parcelable {
    public static final Parcelable.Creator<NaviLocationInfo> CREATOR = new Parcelable.Creator<NaviLocationInfo>() {
        public NaviLocationInfo createFromParcel(Parcel parcel) {
            return new NaviLocationInfo(parcel);
        }

        public NaviLocationInfo[] newArray(int i) {
            return new NaviLocationInfo[i];
        }
    };
    private String adCode = "";
    private String address = "";
    private String city = "";
    private String cityCode = "";
    private String district = "";
    private int errorCode = -100;
    private String errorInfo = "";
    private double latitude = 0.0d;
    private double longitude = 0.0d;
    private String poiName = "";
    private String province = "";
    private String street = "";

    public NaviLocationInfo() {
    }

    public int describeContents() {
        return 0;
    }

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

    public String getPoiName() {
        return this.poiName;
    }

    public String getProvince() {
        return this.province;
    }

    public String getStreet() {
        return this.street;
    }

    public void readFromParcel(Parcel parcel) {
        this.adCode = parcel.readString();
        this.address = parcel.readString();
        this.city = parcel.readString();
        this.cityCode = parcel.readString();
        this.district = parcel.readString();
        this.errorInfo = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.poiName = parcel.readString();
        this.province = parcel.readString();
        this.street = parcel.readString();
        this.errorCode = parcel.readInt();
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

    public void setPoiName(String str) {
        this.poiName = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.adCode);
        parcel.writeString(this.address);
        parcel.writeString(this.city);
        parcel.writeString(this.cityCode);
        parcel.writeString(this.district);
        parcel.writeString(this.errorInfo);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.poiName);
        parcel.writeString(this.province);
        parcel.writeString(this.street);
        parcel.writeInt(this.errorCode);
    }

    public NaviLocationInfo(Parcel parcel) {
        this.adCode = parcel.readString();
        this.address = parcel.readString();
        this.city = parcel.readString();
        this.cityCode = parcel.readString();
        this.district = parcel.readString();
        this.errorInfo = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.poiName = parcel.readString();
        this.province = parcel.readString();
        this.street = parcel.readString();
        this.errorCode = parcel.readInt();
    }
}
