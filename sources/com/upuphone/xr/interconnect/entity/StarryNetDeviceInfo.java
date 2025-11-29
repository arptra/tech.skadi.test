package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class StarryNetDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<StarryNetDeviceInfo> CREATOR = new Parcelable.Creator<StarryNetDeviceInfo>() {
        public StarryNetDeviceInfo createFromParcel(Parcel parcel) {
            return new StarryNetDeviceInfo(parcel);
        }

        public StarryNetDeviceInfo[] newArray(int i) {
            return new StarryNetDeviceInfo[i];
        }
    };
    private String mBluetoothAddress;
    private String mBuildNumber;
    private String mDeviceName;
    private long mFreeStorageSize;
    private String mMacAddress;
    private String mModel;
    private String mSerialNumber;
    private long mTotalStorageSize;

    public StarryNetDeviceInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public String getBluetoothAddress() {
        return this.mBluetoothAddress;
    }

    public String getBuildNumber() {
        return this.mBuildNumber;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public long getFreeStorageSize() {
        return this.mFreeStorageSize;
    }

    public String getMacAddress() {
        return this.mMacAddress;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getSerialNumber() {
        return this.mSerialNumber;
    }

    public long getTotalStorageSize() {
        return this.mTotalStorageSize;
    }

    public void readFromParcel(Parcel parcel) {
        this.mDeviceName = parcel.readString();
        this.mMacAddress = parcel.readString();
        this.mBluetoothAddress = parcel.readString();
        this.mSerialNumber = parcel.readString();
        this.mModel = parcel.readString();
        this.mBuildNumber = parcel.readString();
        this.mTotalStorageSize = parcel.readLong();
        this.mFreeStorageSize = parcel.readLong();
    }

    public void setBluetoothAddress(String str) {
        this.mBluetoothAddress = str;
    }

    public void setBuildNumber(String str) {
        this.mBuildNumber = str;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public void setFreeStorageSize(long j) {
        this.mFreeStorageSize = j;
    }

    public void setMacAddress(String str) {
        this.mMacAddress = str;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public void setSerialNumber(String str) {
        this.mSerialNumber = str;
    }

    public void setTotalStorageSize(long j) {
        this.mTotalStorageSize = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDeviceName);
        parcel.writeString(this.mMacAddress);
        parcel.writeString(this.mBluetoothAddress);
        parcel.writeString(this.mSerialNumber);
        parcel.writeString(this.mModel);
        parcel.writeString(this.mBuildNumber);
        parcel.writeLong(this.mTotalStorageSize);
        parcel.writeLong(this.mFreeStorageSize);
    }

    public StarryNetDeviceInfo(Parcel parcel) {
        this.mDeviceName = parcel.readString();
        this.mMacAddress = parcel.readString();
        this.mBluetoothAddress = parcel.readString();
        this.mSerialNumber = parcel.readString();
        this.mModel = parcel.readString();
        this.mBuildNumber = parcel.readString();
        this.mTotalStorageSize = parcel.readLong();
        this.mFreeStorageSize = parcel.readLong();
    }
}
