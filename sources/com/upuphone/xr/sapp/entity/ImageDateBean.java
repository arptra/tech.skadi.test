package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

@Keep
public class ImageDateBean implements Parcelable {
    public static final Parcelable.Creator<ImageDateBean> CREATOR = new Parcelable.Creator<ImageDateBean>() {
        public ImageDateBean createFromParcel(Parcel parcel) {
            return new ImageDateBean(parcel);
        }

        public ImageDateBean[] newArray(int i) {
            return new ImageDateBean[i];
        }
    };
    private String cdnUrl;
    private String fileSize;
    private String fileSuffix;
    private String newFileName;
    private String originFileName;
    private String srcPath;

    public ImageDateBean(Parcel parcel) {
        this.originFileName = parcel.readString();
        this.fileSuffix = parcel.readString();
        this.newFileName = parcel.readString();
        this.cdnUrl = parcel.readString();
        this.fileSize = parcel.readString();
        this.srcPath = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCdnUrl() {
        return this.cdnUrl;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public String getFileSuffix() {
        return this.fileSuffix;
    }

    public String getNewFileName() {
        return this.newFileName;
    }

    public String getOriginFileName() {
        return this.originFileName;
    }

    public String getSrcPath() {
        return this.srcPath;
    }

    public void setCdnUrl(String str) {
        this.cdnUrl = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public void setFileSuffix(String str) {
        this.fileSuffix = str;
    }

    public void setNewFileName(String str) {
        this.newFileName = str;
    }

    public void setOriginFileName(String str) {
        this.originFileName = str;
    }

    public void setSrcPath(String str) {
        this.srcPath = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.originFileName);
        parcel.writeString(this.fileSuffix);
        parcel.writeString(this.newFileName);
        parcel.writeString(this.cdnUrl);
        parcel.writeString(this.fileSize);
        parcel.writeString(this.srcPath);
    }
}
