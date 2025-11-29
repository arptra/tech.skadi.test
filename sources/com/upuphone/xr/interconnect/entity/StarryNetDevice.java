package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class StarryNetDevice implements Parcelable {
    public static final Parcelable.Creator<StarryNetDevice> CREATOR = new Parcelable.Creator<StarryNetDevice>() {
        public StarryNetDevice createFromParcel(Parcel parcel) {
            return new StarryNetDevice(parcel);
        }

        public StarryNetDevice[] newArray(int i) {
            return new StarryNetDevice[i];
        }
    };
    private String mBleMac;
    private String mBrEdrMac;
    private String mCategoryId;
    private String mCategoryName;
    private String mCompanyId;
    private String mCompanyName;
    private String mDeviceId;
    private String mDeviceName;
    private String mModelId;
    private String mModelName;
    private int mStatus;
    private byte mTerminalType;
    private String mWifiMac;
    private int region;

    public StarryNetDevice() {
    }

    public int describeContents() {
        return 0;
    }

    public String getBleMac() {
        return this.mBleMac;
    }

    public String getBrEdrMac() {
        return this.mBrEdrMac;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public String getCompanyId() {
        return this.mCompanyId;
    }

    public String getCompanyName() {
        return this.mCompanyName;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public String getModelId() {
        return this.mModelId;
    }

    public String getModelName() {
        return this.mModelName;
    }

    public int getRegion() {
        return this.region;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public byte getTerminalType() {
        return this.mTerminalType;
    }

    public String getWifiMac() {
        return this.mWifiMac;
    }

    public void readFromParcel(Parcel parcel) {
        this.mDeviceId = parcel.readString();
        this.mDeviceName = parcel.readString();
        this.mCategoryId = parcel.readString();
        this.mCategoryName = parcel.readString();
        this.mCompanyId = parcel.readString();
        this.mCompanyName = parcel.readString();
        this.mModelId = parcel.readString();
        this.mModelName = parcel.readString();
        this.mBrEdrMac = parcel.readString();
        this.mBleMac = parcel.readString();
        this.mWifiMac = parcel.readString();
        this.mTerminalType = parcel.readByte();
        this.mStatus = parcel.readInt();
        this.region = parcel.readInt();
    }

    public void setBleMac(String str) {
        this.mBleMac = str;
    }

    public void setBrEdrMac(String str) {
        this.mBrEdrMac = str;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    public void setCompanyId(String str) {
        this.mCompanyId = str;
    }

    public void setCompanyName(String str) {
        this.mCompanyName = str;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public void setModelId(String str) {
        this.mModelId = str;
    }

    public void setModelName(String str) {
        this.mModelName = str;
    }

    public void setRegion(int i) {
        this.region = i;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setTerminalType(byte b) {
        this.mTerminalType = b;
    }

    public void setWifiMac(String str) {
        this.mWifiMac = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StarryNetDevice{mDeviceId='");
        sb.append(this.mDeviceId);
        sb.append('\'');
        sb.append(", mDeviceName='");
        sb.append(this.mDeviceName);
        sb.append('\'');
        sb.append(", mCategoryId='");
        sb.append(this.mCategoryId);
        sb.append('\'');
        sb.append(", mCategoryName='");
        sb.append(this.mCategoryName);
        sb.append('\'');
        sb.append(", mCompanyId='");
        sb.append(this.mCompanyId);
        sb.append('\'');
        sb.append(", mCompanyName='");
        sb.append(this.mCompanyName);
        sb.append('\'');
        sb.append(", mModelId='");
        sb.append(this.mModelId);
        sb.append('\'');
        sb.append(", mModelName='");
        sb.append(this.mModelName);
        sb.append('\'');
        sb.append(", mBrEdrMac='");
        boolean z = false;
        sb.append(this.mBrEdrMac == null);
        sb.append('\'');
        sb.append(", mBleMac='");
        sb.append(this.mBleMac == null);
        sb.append('\'');
        sb.append(", mWifiMac='");
        if (this.mWifiMac == null) {
            z = true;
        }
        sb.append(z);
        sb.append('\'');
        sb.append(", mTerminalType='");
        sb.append(this.mTerminalType);
        sb.append('\'');
        sb.append(", mStatus='");
        sb.append(this.mStatus);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mDeviceId);
        parcel.writeString(this.mDeviceName);
        parcel.writeString(this.mCategoryId);
        parcel.writeString(this.mCategoryName);
        parcel.writeString(this.mCompanyId);
        parcel.writeString(this.mCompanyName);
        parcel.writeString(this.mModelId);
        parcel.writeString(this.mModelName);
        parcel.writeString(this.mBrEdrMac);
        parcel.writeString(this.mBleMac);
        parcel.writeString(this.mWifiMac);
        parcel.writeByte(this.mTerminalType);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.region);
    }

    public StarryNetDevice(Parcel parcel) {
        this.mDeviceId = parcel.readString();
        this.mDeviceName = parcel.readString();
        this.mCategoryId = parcel.readString();
        this.mCategoryName = parcel.readString();
        this.mCompanyId = parcel.readString();
        this.mCompanyName = parcel.readString();
        this.mModelId = parcel.readString();
        this.mModelName = parcel.readString();
        this.mBrEdrMac = parcel.readString();
        this.mBleMac = parcel.readString();
        this.mWifiMac = parcel.readString();
        this.mTerminalType = parcel.readByte();
        this.mStatus = parcel.readInt();
        this.region = parcel.readInt();
    }
}
