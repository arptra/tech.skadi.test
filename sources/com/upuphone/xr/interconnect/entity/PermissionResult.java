package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class PermissionResult implements Parcelable {
    public static final Parcelable.Creator<PermissionResult> CREATOR = new Parcelable.Creator<PermissionResult>() {
        public PermissionResult createFromParcel(Parcel parcel) {
            return new PermissionResult(parcel);
        }

        public PermissionResult[] newArray(int i) {
            return new PermissionResult[i];
        }
    };
    private ArrayList<String> deniedPermissionList;
    private boolean result;

    public PermissionResult(boolean z, ArrayList<String> arrayList) {
        this.result = z;
        this.deniedPermissionList = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<String> getDeniedPermissionList() {
        return this.deniedPermissionList;
    }

    public boolean isResult() {
        return this.result;
    }

    public void readFromParcel(Parcel parcel) {
        this.result = parcel.readByte() != 0;
        this.deniedPermissionList = parcel.createStringArrayList();
    }

    public void setDeniedPermissionList(ArrayList<String> arrayList) {
        this.deniedPermissionList = arrayList;
    }

    public void setResult(boolean z) {
        this.result = z;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte(this.result ? (byte) 1 : 0);
        parcel.writeStringList(this.deniedPermissionList);
    }

    public PermissionResult(Parcel parcel) {
        this.result = parcel.readByte() != 0;
        this.deniedPermissionList = parcel.createStringArrayList();
    }
}
