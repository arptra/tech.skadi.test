package com.upuphone.runasone.ble;

import android.os.Parcel;
import android.os.Parcelable;

public class BleRawSession implements Parcelable {
    public static final Parcelable.Creator<BleRawSession> CREATOR = new Parcelable.Creator<BleRawSession>() {
        public BleRawSession createFromParcel(Parcel parcel) {
            return new BleRawSession(parcel);
        }

        public BleRawSession[] newArray(int i) {
            return new BleRawSession[i];
        }
    };
    private final String deviceId;
    private final String sessionId;

    public BleRawSession(String str, String str2) {
        this.deviceId = str;
        this.sessionId = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceId);
        parcel.writeString(this.sessionId);
    }

    public BleRawSession(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.sessionId = parcel.readString();
    }
}
