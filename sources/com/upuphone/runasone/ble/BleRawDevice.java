package com.upuphone.runasone.ble;

import android.os.Parcel;
import android.os.Parcelable;

public class BleRawDevice implements Parcelable {
    public static final Parcelable.Creator<BleRawDevice> CREATOR = new Parcelable.Creator<BleRawDevice>() {
        public BleRawDevice createFromParcel(Parcel parcel) {
            return new BleRawDevice(parcel);
        }

        public BleRawDevice[] newArray(int i) {
            return new BleRawDevice[i];
        }
    };
    private final String address;
    private final String deviceId;
    private final String deviceName;
    private final byte[] payload;
    private final String pid;
    private final String version;
    private final String vid;

    public BleRawDevice(String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr) {
        this.deviceId = str;
        this.vid = str2;
        this.pid = str3;
        this.version = str4;
        this.deviceName = str5;
        this.address = str6;
        this.payload = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public String getPid() {
        return this.pid;
    }

    public String getVersion() {
        return this.version;
    }

    public String getVid() {
        return this.vid;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceId);
        parcel.writeString(this.vid);
        parcel.writeString(this.pid);
        parcel.writeString(this.version);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.address);
        parcel.writeByteArray(this.payload);
    }

    public BleRawDevice(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.vid = parcel.readString();
        this.pid = parcel.readString();
        this.version = parcel.readString();
        this.deviceName = parcel.readString();
        this.address = parcel.readString();
        this.payload = parcel.createByteArray();
    }
}
