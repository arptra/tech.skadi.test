package com.share.connect;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class Device implements Parcelable {
    public static final Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() {
        /* renamed from: a */
        public Device createFromParcel(Parcel parcel) {
            return new Device(parcel);
        }

        /* renamed from: b */
        public Device[] newArray(int i) {
            return new Device[i];
        }
    };
    public static final Device UNKNOWN_CAR = new Device().setVin("101010101010").setVid("0000").setVName("未知车企").setPName("未知车型").setPid("0000").setShortName("未知车型");
    private String mPName;
    private String mPid;
    private String mShortName;
    private String mVName;
    private String mVid;
    private String mVin;

    public Device() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof Device) {
            return TextUtils.equals(this.mVin, ((Device) obj).mVin);
        }
        return false;
    }

    public String getCertServerId() {
        return this.mVid + this.mPid;
    }

    public String getPName() {
        return this.mPName;
    }

    public String getPid() {
        return this.mPid;
    }

    public String getShortName() {
        return this.mShortName;
    }

    public String getVName() {
        return this.mVName;
    }

    public String getVid() {
        return this.mVid;
    }

    public String getVin() {
        return this.mVin;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Device setPName(String str) {
        this.mPName = str;
        return this;
    }

    public Device setPid(String str) {
        this.mPid = str;
        return this;
    }

    public Device setShortName(String str) {
        this.mShortName = str;
        return this;
    }

    public Device setVName(String str) {
        this.mVName = str;
        return this;
    }

    public Device setVid(String str) {
        this.mVid = str;
        return this;
    }

    public Device setVin(String str) {
        this.mVin = str;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mVin);
        parcel.writeString(this.mPName);
        parcel.writeString(this.mVName);
        parcel.writeString(this.mVid);
        parcel.writeString(this.mPid);
        parcel.writeString(this.mShortName);
    }

    public Device(Parcel parcel) {
        this.mVin = parcel.readString();
        this.mPName = parcel.readString();
        this.mVName = parcel.readString();
        this.mVid = parcel.readString();
        this.mPid = parcel.readString();
        this.mShortName = parcel.readString();
    }
}
