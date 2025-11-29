package com.upuphone.xr.interconnect.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class StarryNetFileInfo implements Parcelable {
    public static final Parcelable.Creator<StarryNetFileInfo> CREATOR = new Parcelable.Creator<StarryNetFileInfo>() {
        public StarryNetFileInfo createFromParcel(Parcel parcel) {
            return new StarryNetFileInfo(parcel);
        }

        public StarryNetFileInfo[] newArray(int i) {
            return new StarryNetFileInfo[i];
        }
    };
    private String mFileName;
    private long mFileSize;
    private transient Uri mFileUri;
    private String mimeType;

    public StarryNetFileInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public Uri getFileUri() {
        return this.mFileUri;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setFileSize(long j) {
        this.mFileSize = j;
    }

    public void setFileUri(Uri uri) {
        this.mFileUri = uri;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mFileName);
        parcel.writeString(this.mimeType);
        parcel.writeParcelable(this.mFileUri, i);
        parcel.writeLong(this.mFileSize);
    }

    public StarryNetFileInfo(Parcel parcel) {
        this.mFileName = parcel.readString();
        this.mimeType = parcel.readString();
        this.mFileUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mFileSize = parcel.readLong();
    }
}
