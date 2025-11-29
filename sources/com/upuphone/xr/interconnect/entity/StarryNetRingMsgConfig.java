package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class StarryNetRingMsgConfig implements Parcelable {
    public static final Parcelable.Creator<StarryNetRingMsgConfig> CREATOR = new Parcelable.Creator<StarryNetRingMsgConfig>() {
        public StarryNetRingMsgConfig createFromParcel(Parcel parcel) {
            return new StarryNetRingMsgConfig(parcel);
        }

        public StarryNetRingMsgConfig[] newArray(int i) {
            return new StarryNetRingMsgConfig[i];
        }
    };
    private String characteristic;
    private String serviceData;
    private String version;

    public StarryNetRingMsgConfig() {
    }

    public int describeContents() {
        return 0;
    }

    public String getCharacteristic() {
        return this.characteristic;
    }

    public String getServiceData() {
        return this.serviceData;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCharacteristic(String str) {
        this.characteristic = str;
    }

    public void setServiceData(String str) {
        this.serviceData = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.serviceData);
        parcel.writeString(this.characteristic);
        parcel.writeString(this.version);
    }

    public StarryNetRingMsgConfig(Parcel parcel) {
        this.serviceData = parcel.readString();
        this.characteristic = parcel.readString();
        this.version = parcel.readString();
    }
}
