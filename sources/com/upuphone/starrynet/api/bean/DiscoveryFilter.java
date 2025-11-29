package com.upuphone.starrynet.api.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DiscoveryFilter implements Parcelable {
    public static final Parcelable.Creator<DiscoveryFilter> CREATOR = new Parcelable.Creator<DiscoveryFilter>() {
        public DiscoveryFilter createFromParcel(Parcel parcel) {
            return new DiscoveryFilter(parcel);
        }

        public DiscoveryFilter[] newArray(int i) {
            return new DiscoveryFilter[i];
        }
    };
    private String mCategory;
    private String mCompany;
    private String mDeviceMac;
    private int mDeviceType;

    public static final class Builder {
        private String mCategory;
        private String mCompany;
        private int mDeviceType;

        public DiscoveryFilter build() {
            return new DiscoveryFilter(this.mDeviceType, this.mCompany, this.mCategory);
        }

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setCompany(String str) {
            this.mCompany = str;
            return this;
        }

        public Builder setDeviceType(int i) {
            this.mDeviceType = i;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getCompany() {
        return this.mCompany;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public boolean matches(StDevice stDevice) {
        if (stDevice == null) {
            return false;
        }
        int i = this.mDeviceType;
        if (i != 0 && i != stDevice.getDeviceType()) {
            return false;
        }
        String str = this.mCompany;
        if (str != null && !str.equals(stDevice.getCompanyName())) {
            return false;
        }
        String str2 = this.mCategory;
        return str2 == null || str2.equals(stDevice.getCategoryName());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mDeviceType);
        parcel.writeString(this.mCompany);
        parcel.writeString(this.mCategory);
        parcel.writeString(this.mDeviceMac);
    }

    private DiscoveryFilter(int i, String str, String str2) {
        this.mDeviceType = i;
        this.mCompany = str;
        this.mCategory = str2;
    }

    public DiscoveryFilter(Parcel parcel) {
        this.mDeviceType = 1;
        this.mDeviceType = parcel.readInt();
        this.mCompany = parcel.readString();
        this.mCategory = parcel.readString();
        this.mDeviceMac = parcel.readString();
    }
}
