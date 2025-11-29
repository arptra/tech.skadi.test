package com.upuphone.runasone.share.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.upuphone.starryshare.bean.FileInfo;

public class BleFileInfo implements Parcelable {
    public static final Parcelable.Creator<BleFileInfo> CREATOR = new Parcelable.Creator<BleFileInfo>() {
        public BleFileInfo createFromParcel(Parcel parcel) {
            return new BleFileInfo(parcel);
        }

        public BleFileInfo[] newArray(int i) {
            return new BleFileInfo[i];
        }
    };
    private long chunkSize;
    private int count;
    private int currentNumber;
    private FileInfo info;
    private String packageName;
    private String storage;

    public BleFileInfo(Parcel parcel) {
        this.info = (FileInfo) parcel.readParcelable(FileInfo.class.getClassLoader());
        this.count = parcel.readInt();
        this.currentNumber = parcel.readInt();
        this.chunkSize = parcel.readLong();
        this.storage = parcel.readString();
        this.packageName = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public long getChunkSize() {
        return this.chunkSize;
    }

    public int getCount() {
        return this.count;
    }

    public int getCurrentNumber() {
        return this.currentNumber;
    }

    public FileInfo getInfo() {
        return this.info;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getStorage() {
        return this.storage;
    }

    public void setChunkSize(long j) {
        this.chunkSize = j;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCurrentNumber(int i) {
        this.currentNumber = i;
    }

    public void setInfo(FileInfo fileInfo) {
        this.info = fileInfo;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setStorage(String str) {
        this.storage = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.info, i);
        parcel.writeInt(this.count);
        parcel.writeInt(this.currentNumber);
        parcel.writeLong(this.chunkSize);
        parcel.writeString(this.storage);
        parcel.writeString(this.packageName);
    }

    public BleFileInfo() {
    }
}
