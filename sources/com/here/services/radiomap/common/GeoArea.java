package com.here.services.radiomap.common;

import android.os.Parcel;
import android.os.Parcelable;

public class GeoArea implements Parcelable {
    public static final Parcelable.Creator<GeoArea> CREATOR = new Parcelable.Creator<GeoArea>() {
        public GeoArea createFromParcel(Parcel parcel) {
            GeoArea geoArea = new GeoArea();
            geoArea.east = parcel.readDouble();
            geoArea.west = parcel.readDouble();
            geoArea.south = parcel.readDouble();
            geoArea.north = parcel.readDouble();
            return geoArea;
        }

        public GeoArea[] newArray(int i) {
            return new GeoArea[i];
        }
    };
    public double east;
    public double north;
    public double south;
    public double west;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.east);
        parcel.writeDouble(this.west);
        parcel.writeDouble(this.south);
        parcel.writeDouble(this.north);
    }
}
