package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class StarryNetMessage implements Parcelable {
    public static final Parcelable.Creator<StarryNetMessage> CREATOR = new Parcelable.Creator<StarryNetMessage>() {
        public StarryNetMessage createFromParcel(Parcel parcel) {
            return new StarryNetMessage(parcel);
        }

        public StarryNetMessage[] newArray(int i) {
            return new StarryNetMessage[i];
        }
    };
    private byte[] data;
    private String mId;
    private String mMessage;
    private String mReceiveUniteCode;
    private String mReceiverPkg;
    private String mSenderPkg;
    private int mTarget = 0;
    private int mVersion = 1;

    public StarryNetMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getId() {
        return this.mId;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getReceiveUniteCode() {
        return this.mReceiveUniteCode;
    }

    public String getReceiverPkg() {
        return this.mReceiverPkg;
    }

    public String getSenderPkg() {
        return this.mSenderPkg;
    }

    public int getTarget() {
        return this.mTarget;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setReceiveUniteCode(String str) {
        this.mReceiveUniteCode = str;
    }

    public void setReceiverPkg(String str) {
        this.mReceiverPkg = str;
    }

    public void setSenderPkg(String str) {
        this.mSenderPkg = str;
    }

    public void setTarget(int i) {
        this.mTarget = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mSenderPkg);
        parcel.writeString(this.mReceiverPkg);
        parcel.writeString(this.mMessage);
        parcel.writeByteArray(this.data);
        parcel.writeString(this.mReceiveUniteCode);
        parcel.writeInt(this.mVersion);
        parcel.writeInt(this.mTarget);
    }

    public StarryNetMessage(Parcel parcel) {
        this.mId = parcel.readString();
        this.mSenderPkg = parcel.readString();
        this.mReceiverPkg = parcel.readString();
        this.mMessage = parcel.readString();
        this.data = parcel.createByteArray();
        this.mReceiveUniteCode = parcel.readString();
        this.mVersion = parcel.readInt();
        this.mTarget = parcel.readInt();
    }
}
