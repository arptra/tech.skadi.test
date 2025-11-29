package com.upuphone.starrynet.strategy.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class RingDevice implements Parcelable {
    public static final Parcelable.Creator<RingDevice> CREATOR = new Parcelable.Creator<RingDevice>() {
        public RingDevice createFromParcel(Parcel parcel) {
            return new RingDevice(parcel);
        }

        public RingDevice[] newArray(int i) {
            return new RingDevice[i];
        }
    };
    private String bleMac;
    private String deviceName;

    public RingDevice(String str, String str2) {
        this.bleMac = str;
        this.deviceName = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.bleMac.equals(((RingDevice) obj).bleMac);
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int hashCode() {
        return this.bleMac.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bleMac);
        parcel.writeString(this.deviceName);
    }

    public RingDevice(Parcel parcel) {
        this.bleMac = parcel.readString();
        this.deviceName = parcel.readString();
    }
}
