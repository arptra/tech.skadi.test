package com.upuphone.runasone.share.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class StarryNetFiles implements Parcelable {
    public static final Parcelable.Creator<StarryNetFiles> CREATOR = new Parcelable.Creator<StarryNetFiles>() {
        public StarryNetFiles createFromParcel(Parcel parcel) {
            return new StarryNetFiles(parcel);
        }

        public StarryNetFiles[] newArray(int i) {
            return new StarryNetFiles[i];
        }
    };
    private List<StarryNetFile> lstFiles;
    private int mFileCount;
    private String mFileName;
    private long mFileTotalSize;
    private String mMimeType;
    private String mSenderName;
    private String mTaskId;
    private int mTbHeight;
    private int mTbWidth;

    public StarryNetFiles(String str, String str2, String str3, int i, String str4, long j, int i2, int i3, List<StarryNetFile> list) {
        this.mTaskId = str;
        this.mSenderName = str2;
        this.mFileName = str3;
        this.mFileCount = i;
        this.mMimeType = str4;
        this.mFileTotalSize = j;
        this.mTbWidth = i2;
        this.mTbHeight = i3;
        this.lstFiles = list;
    }

    public int describeContents() {
        return 0;
    }

    public int getFileCount() {
        return this.mFileCount;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public long getFileTotalSize() {
        return this.mFileTotalSize;
    }

    public List<StarryNetFile> getLstFiles() {
        return this.lstFiles;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String getSenderName() {
        return this.mSenderName;
    }

    public String getTaskId() {
        return this.mTaskId;
    }

    public int getTbHeight() {
        return this.mTbHeight;
    }

    public int getTbWidth() {
        return this.mTbWidth;
    }

    public void setFileCount(int i) {
        this.mFileCount = i;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setFileTotalSize(long j) {
        this.mFileTotalSize = j;
    }

    public void setLstFiles(List<StarryNetFile> list) {
        this.lstFiles = list;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public void setSenderName(String str) {
        this.mSenderName = str;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public void setTbHeight(int i) {
        this.mTbHeight = i;
    }

    public void setTbWidth(int i) {
        this.mTbWidth = i;
    }

    public String toString() {
        return "StarryNetFiles{taskId=" + this.mTaskId + ",senderName=" + this.mSenderName + ",fileName=" + this.mFileName + ",fileCount=" + this.mFileCount + ",mimeType=" + this.mMimeType + ",totalSize=" + this.mFileTotalSize + ",tbWidth=" + this.mTbWidth + ",tbHeight=" + this.mTbHeight + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTaskId);
        parcel.writeString(this.mSenderName);
        parcel.writeString(this.mFileName);
        parcel.writeInt(this.mFileCount);
        parcel.writeString(this.mMimeType);
        parcel.writeLong(this.mFileTotalSize);
        parcel.writeInt(this.mTbWidth);
        parcel.writeInt(this.mTbHeight);
        parcel.writeList(this.lstFiles);
    }

    public StarryNetFiles(Parcel parcel) {
        this.mTaskId = parcel.readString();
        this.mSenderName = parcel.readString();
        this.mFileName = parcel.readString();
        this.mFileCount = parcel.readInt();
        this.mMimeType = parcel.readString();
        this.mFileTotalSize = parcel.readLong();
        this.mTbWidth = parcel.readInt();
        this.mTbHeight = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.lstFiles = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }
}
