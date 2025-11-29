package com.upuphone.starrynet.core.database.dao;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.utils.Utils;
import java.util.Arrays;
import java.util.Objects;

public class BondInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<BondInfo> CREATOR = new Parcelable.Creator<BondInfo>() {
        public BondInfo createFromParcel(Parcel parcel) {
            return new BondInfo(parcel);
        }

        public BondInfo[] newArray(int i) {
            return new BondInfo[i];
        }
    };
    protected String brEdrMac;
    protected int cVersion;
    protected String categoryID;
    protected String categoryName;
    protected byte[] cipher;
    protected String companyID;
    protected String companyName;
    protected long date;
    protected String deviceName;
    protected byte deviceType;
    protected byte[] identifier;
    protected String modelID;
    protected String modelName;
    protected int protocol;
    protected int status;
    protected byte terminalType;

    public BondInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BondInfo bondInfo = (BondInfo) obj;
        return this.deviceType == bondInfo.deviceType && Arrays.equals(this.identifier, bondInfo.identifier);
    }

    public String getBrEdrMac() {
        return this.brEdrMac;
    }

    public String getCategoryID() {
        return this.categoryID;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public byte[] getCipher() {
        return this.cipher;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public int getConnectVersion() {
        return this.cVersion;
    }

    public long getDate() {
        return this.date;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public byte[] getIdentifier() {
        return this.identifier;
    }

    public String getModelID() {
        return this.modelID;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getStatus() {
        return this.status;
    }

    public byte getTerminalType() {
        return this.terminalType;
    }

    public int hashCode() {
        return (Objects.hash(new Object[]{Byte.valueOf(this.deviceType)}) * 31) + Arrays.hashCode(this.identifier);
    }

    public void setBrEdrMac(String str) {
        this.brEdrMac = str;
    }

    public void setConnectVersion(int i) {
        this.cVersion = i;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    @NonNull
    public String toString() {
        return "BondInfo{type='" + this.deviceType + '\'' + ", TerminateDevice ='" + this.terminalType + '\'' + ", companyID='" + this.companyID + '\'' + ", categoryID='" + this.categoryID + '\'' + ", modelID='" + this.modelID + '\'' + ", companyName='" + this.companyName + '\'' + ", categoryName='" + this.categoryName + '\'' + ", modelName='" + this.modelName + '\'' + ", identifier='" + Utils.bytesToHexString(this.identifier) + '\'' + ", deviceName='" + this.deviceName + '\'' + ", brEdrMac='" + this.brEdrMac + '\'' + ", cipher=" + Arrays.toString(getCipher()) + ", date=" + this.date + ", status=0x" + Integer.toHexString(this.status) + ", cVersion=0x" + Integer.toHexString(this.cVersion) + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.identifier);
        parcel.writeInt(this.deviceType);
        parcel.writeByte(this.terminalType);
        parcel.writeInt(this.protocol);
        parcel.writeString(this.companyID);
        parcel.writeString(this.categoryID);
        parcel.writeString(this.modelID);
        parcel.writeString(this.companyName);
        parcel.writeString(this.categoryName);
        parcel.writeString(this.modelName);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.brEdrMac);
        parcel.writeByteArray(this.cipher);
        parcel.writeLong(this.date);
        parcel.writeInt(this.status);
        parcel.writeInt(this.cVersion);
    }

    public BondInfo(Parcel parcel) {
        this.identifier = parcel.createByteArray();
        this.deviceType = parcel.readByte();
        this.terminalType = parcel.readByte();
        this.protocol = parcel.readInt();
        this.companyID = parcel.readString();
        this.categoryID = parcel.readString();
        this.modelID = parcel.readString();
        this.companyName = parcel.readString();
        this.categoryName = parcel.readString();
        this.modelName = parcel.readString();
        this.deviceName = parcel.readString();
        this.brEdrMac = parcel.readString();
        this.cipher = parcel.createByteArray();
        this.date = parcel.readLong();
        this.status = parcel.readInt();
        this.cVersion = parcel.readInt();
    }

    @NonNull
    public BondInfo clone() {
        try {
            return (BondInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
