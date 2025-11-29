package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import java.util.List;

public class StarryNetFile implements Parcelable {
    public static final Parcelable.Creator<StarryNetFile> CREATOR = new Parcelable.Creator<StarryNetFile>() {
        public StarryNetFile createFromParcel(Parcel parcel) {
            return new StarryNetFile(parcel);
        }

        public StarryNetFile[] newArray(int i) {
            return new StarryNetFile[i];
        }
    };
    private List<StarryNetFileInfo> lstFiles;
    private String mId;
    private String mReceiverPkg;
    private String mSenderPkg;
    private String savePath;

    public StarryNetFile() {
    }

    public StarryNetFile addFile(StarryNetFileInfo... starryNetFileInfoArr) {
        List lstFiles2 = getLstFiles();
        if (lstFiles2 == null) {
            lstFiles2 = new DeDuplicateArrayList();
            setLstFiles(lstFiles2);
        }
        for (StarryNetFileInfo starryNetFileInfo : starryNetFileInfoArr) {
            if (!lstFiles2.contains(starryNetFileInfo)) {
                lstFiles2.add(starryNetFileInfo);
            }
        }
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.mId;
    }

    public List<StarryNetFileInfo> getLstFiles() {
        return this.lstFiles;
    }

    public String getReceiverPkg() {
        return this.mReceiverPkg;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getSenderPkg() {
        return this.mSenderPkg;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setLstFiles(List<StarryNetFileInfo> list) {
        this.lstFiles = list;
    }

    public void setReceiverPkg(String str) {
        this.mReceiverPkg = str;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public void setSenderPkg(String str) {
        this.mSenderPkg = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mSenderPkg);
        parcel.writeString(this.mReceiverPkg);
        parcel.writeTypedList(this.lstFiles);
        parcel.writeString(this.savePath);
    }

    public StarryNetFile(Parcel parcel) {
        this.mId = parcel.readString();
        this.mSenderPkg = parcel.readString();
        this.mReceiverPkg = parcel.readString();
        this.lstFiles = parcel.createTypedArrayList(StarryNetFileInfo.CREATOR);
        this.savePath = parcel.readString();
    }
}
