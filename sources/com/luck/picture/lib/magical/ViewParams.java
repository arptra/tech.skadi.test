package com.luck.picture.lib.magical;

import android.os.Parcel;
import android.os.Parcelable;

public class ViewParams implements Parcelable {
    public static final Parcelable.Creator<ViewParams> CREATOR = new Parcelable.Creator<ViewParams>() {
        /* renamed from: a */
        public ViewParams createFromParcel(Parcel parcel) {
            return new ViewParams(parcel);
        }

        /* renamed from: b */
        public ViewParams[] newArray(int i) {
            return new ViewParams[i];
        }
    };
    public int height;
    public int left;

    /* renamed from: top  reason: collision with root package name */
    public int f9433top;
    public int width;

    public ViewParams() {
    }

    public int describeContents() {
        return 0;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLeft() {
        return this.left;
    }

    public int getTop() {
        return this.f9433top;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public void setTop(int i) {
        this.f9433top = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.left);
        parcel.writeInt(this.f9433top);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public ViewParams(Parcel parcel) {
        this.left = parcel.readInt();
        this.f9433top = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
