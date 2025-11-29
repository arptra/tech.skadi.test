package com.upuphone.runasone.relay;

import android.os.Parcel;
import android.os.Parcelable;

public class StarryTag implements Parcelable {
    public static final Parcelable.Creator<StarryTag> CREATOR = new Parcelable.Creator<StarryTag>() {
        public StarryTag createFromParcel(Parcel parcel) {
            return new StarryTag(parcel);
        }

        public StarryTag[] newArray(int i) {
            return new StarryTag[i];
        }
    };
    private String deviceId;
    private String receiveAppUniteCode;
    private String sendAppUniteCode;

    public StarryTag(String str, String str2, String str3) {
        this.deviceId = str;
        this.sendAppUniteCode = str2;
        this.receiveAppUniteCode = str3;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getReceiveAppUniteCode() {
        return this.receiveAppUniteCode;
    }

    public String getSendAppUniteCode() {
        return this.sendAppUniteCode;
    }

    public void readFromParcel(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.sendAppUniteCode = parcel.readString();
        this.receiveAppUniteCode = parcel.readString();
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setReceiveAppUniteCode(String str) {
        this.receiveAppUniteCode = str;
    }

    public void setSendAppUniteCode(String str) {
        this.sendAppUniteCode = str;
    }

    public String toString() {
        return "deviceId= " + this.deviceId + "  sendAppUniteCode= " + this.sendAppUniteCode + " receiveAppUniteCode = " + this.receiveAppUniteCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceId);
        parcel.writeString(this.sendAppUniteCode);
        parcel.writeString(this.receiveAppUniteCode);
    }

    public StarryTag(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.sendAppUniteCode = parcel.readString();
        this.receiveAppUniteCode = parcel.readString();
    }
}
