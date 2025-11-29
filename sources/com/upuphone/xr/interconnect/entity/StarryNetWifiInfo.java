package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class StarryNetWifiInfo implements Parcelable {
    public static final Parcelable.Creator<StarryNetWifiInfo> CREATOR = new Parcelable.Creator<StarryNetWifiInfo>() {
        public StarryNetWifiInfo createFromParcel(Parcel parcel) {
            return new StarryNetWifiInfo(parcel);
        }

        public StarryNetWifiInfo[] newArray(int i) {
            return new StarryNetWifiInfo[i];
        }
    };
    private String ssid;

    public StarryNetWifiInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void readFromParcel(Parcel parcel) {
        this.ssid = parcel.readString();
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ssid);
    }

    public StarryNetWifiInfo(Parcel parcel) {
        this.ssid = parcel.readString();
    }
}
