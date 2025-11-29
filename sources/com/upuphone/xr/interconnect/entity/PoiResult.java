package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class PoiResult implements Parcelable {
    public static final Parcelable.Creator<PoiResult> CREATOR = new Parcelable.Creator<PoiResult>() {
        public PoiResult createFromParcel(Parcel parcel) {
            return new PoiResult(parcel);
        }

        public PoiResult[] newArray(int i) {
            return new PoiResult[i];
        }
    };
    private String address;
    private int distance;
    private double latitude;
    private double longitude;
    private String name;
    private String poiId;

    public PoiResult() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public int getDistance() {
        return this.distance;
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

    public String getPoiId() {
        return this.poiId;
    }

    public void readFromParcel(Parcel parcel) {
        this.name = parcel.readString();
        this.distance = parcel.readInt();
        this.address = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.poiId = parcel.readString();
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setDistance(int i) {
        this.distance = i;
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

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.distance);
        parcel.writeString(this.address);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.poiId);
    }

    public PoiResult(String str, int i, String str2, double d, double d2, String str3) {
        this.name = str;
        this.distance = i;
        this.address = str2;
        this.latitude = d;
        this.longitude = d2;
        this.poiId = str3;
    }

    public PoiResult(Parcel parcel) {
        this.name = parcel.readString();
        this.distance = parcel.readInt();
        this.address = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.poiId = parcel.readString();
    }
}
