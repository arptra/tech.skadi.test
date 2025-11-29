package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class StarryDlnaMediaInfo implements Parcelable {
    public static final Parcelable.Creator<StarryDlnaMediaInfo> CREATOR = new Parcelable.Creator<StarryDlnaMediaInfo>() {
        public StarryDlnaMediaInfo createFromParcel(Parcel parcel) {
            return new StarryDlnaMediaInfo(parcel);
        }

        public StarryDlnaMediaInfo[] newArray(int i) {
            return new StarryDlnaMediaInfo[i];
        }
    };
    public int mCurrentPosition;
    public String mMeta;
    public int mTotalLength;
    public String mUrl;

    public StarryDlnaMediaInfo(String str, String str2, int i, int i2) {
        this.mUrl = str;
        this.mMeta = str2;
        this.mCurrentPosition = i;
        this.mTotalLength = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.mCurrentPosition = parcel.readInt();
        this.mTotalLength = parcel.readInt();
        this.mUrl = parcel.readString();
        this.mMeta = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCurrentPosition);
        parcel.writeInt(this.mTotalLength);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mMeta);
    }

    public StarryDlnaMediaInfo(Parcel parcel) {
        this.mCurrentPosition = parcel.readInt();
        this.mTotalLength = parcel.readInt();
        this.mUrl = parcel.readString();
        this.mMeta = parcel.readString();
    }
}
