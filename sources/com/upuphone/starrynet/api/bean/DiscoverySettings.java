package com.upuphone.starrynet.api.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DiscoverySettings implements Parcelable {
    public static final Parcelable.Creator<DiscoverySettings> CREATOR = new Parcelable.Creator<DiscoverySettings>() {
        public DiscoverySettings createFromParcel(Parcel parcel) {
            return new DiscoverySettings(parcel);
        }

        public DiscoverySettings[] newArray(int i) {
            return new DiscoverySettings[i];
        }
    };
    public static final int SCAN_MODE_FREQUENCY_HIGH = 0;
    public static final int SCAN_MODE_FREQUENCY_LOW = 1;
    private int mScanMode;

    public static final class Builder {
        private int mScanMode;

        public DiscoverySettings build() {
            return new DiscoverySettings(this.mScanMode);
        }

        public Builder setScanMode(int i) {
            this.mScanMode = i;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getScanMode() {
        return this.mScanMode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mScanMode);
    }

    private DiscoverySettings(int i) {
        this.mScanMode = i;
    }

    public DiscoverySettings(Parcel parcel) {
        this.mScanMode = parcel.readInt();
    }
}
