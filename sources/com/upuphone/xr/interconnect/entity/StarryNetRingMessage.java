package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class StarryNetRingMessage implements Parcelable {
    public static final Parcelable.Creator<StarryNetRingMessage> CREATOR = new Parcelable.Creator<StarryNetRingMessage>() {
        public StarryNetRingMessage createFromParcel(Parcel parcel) {
            return new StarryNetRingMessage(parcel);
        }

        public StarryNetRingMessage[] newArray(int i) {
            return new StarryNetRingMessage[i];
        }
    };
    private String characterUuid;
    private byte[] data;
    private String deviceId;
    private int msgType = 0;
    private String serviceUuid;

    public StarryNetRingMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public String getCharacterUuid() {
        return this.characterUuid;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getServiceUuid() {
        return this.serviceUuid;
    }

    public void setCharacterUuid(String str) {
        this.characterUuid = str;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setServiceUuid(String str) {
        this.serviceUuid = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceId);
        parcel.writeString(this.serviceUuid);
        parcel.writeString(this.characterUuid);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.msgType);
    }

    public StarryNetRingMessage(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.serviceUuid = parcel.readString();
        this.characterUuid = parcel.readString();
        this.data = parcel.createByteArray();
        this.msgType = parcel.readInt();
    }
}
