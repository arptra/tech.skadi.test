package com.share.connect;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import org.apache.commons.lang3.StringUtils;

public class WifiOwnerConfig implements Parcelable {
    public static final int CONN_WIFI_AP = 1002;
    public static final int CONN_WIFI_P2P = 1001;
    public static final Parcelable.Creator<WifiOwnerConfig> CREATOR = new Parcelable.Creator<WifiOwnerConfig>() {
        /* renamed from: a */
        public WifiOwnerConfig createFromParcel(Parcel parcel) {
            return new WifiOwnerConfig(parcel);
        }

        /* renamed from: b */
        public WifiOwnerConfig[] newArray(int i) {
            return new WifiOwnerConfig[i];
        }
    };
    private int mFrequency;
    private String mIpAddress;
    private String mMac;
    private String mPassphrase;
    private String mSsid;
    private int mType;

    public WifiOwnerConfig() {
    }

    public int describeContents() {
        return 0;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public String getIpAddress() {
        return this.mIpAddress;
    }

    public String getMac() {
        return this.mMac;
    }

    public String getPassphrase() {
        return this.mPassphrase;
    }

    public String getSsid() {
        return this.mSsid;
    }

    public int getType() {
        return this.mType;
    }

    public void readFromParcel(Parcel parcel) {
        this.mSsid = parcel.readString();
        this.mPassphrase = parcel.readString();
        this.mMac = parcel.readString();
        this.mFrequency = parcel.readInt();
        this.mType = parcel.readInt();
        this.mIpAddress = parcel.readString();
    }

    public void setFrequency(int i) {
        this.mFrequency = i;
    }

    public void setIpAddress(String str) {
        this.mIpAddress = str;
    }

    public void setMac(String str) {
        this.mMac = str;
    }

    public void setPassphrase(String str) {
        this.mPassphrase = str;
    }

    public void setSsid(String str) {
        this.mSsid = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @NonNull
    public String toString() {
        return "wifi info: ssid = " + this.mSsid + " channel: " + this.mFrequency + " mac: " + this.mMac + " connect type: " + this.mType + " ip address: " + this.mIpAddress + StringUtils.LF;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSsid);
        parcel.writeString(this.mPassphrase);
        parcel.writeString(this.mMac);
        parcel.writeInt(this.mFrequency);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mIpAddress);
    }

    public WifiOwnerConfig(Parcel parcel) {
        this.mSsid = parcel.readString();
        this.mPassphrase = parcel.readString();
        this.mMac = parcel.readString();
        this.mFrequency = parcel.readInt();
        this.mType = parcel.readInt();
        this.mIpAddress = parcel.readString();
    }
}
