package com.ucar.vehiclesdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.ucar.vehiclesdk.UCarCommon;

public class MDevice implements Parcelable {
    public static final int CONNECT_TYPE_DEFAULT = 1;
    public static final int CONNECT_TYPE_SOFTAP = 3;
    public static final int CONNECT_TYPE_USB = 2;
    public static final int CONNECT_TYPE_WIFIP2P = 1;
    public static final Parcelable.Creator<MDevice> CREATOR = new Parcelable.Creator<MDevice>() {
        /* renamed from: a */
        public MDevice createFromParcel(Parcel parcel) {
            return new MDevice(parcel);
        }

        /* renamed from: b */
        public MDevice[] newArray(int i) {
            return new MDevice[i];
        }
    };
    public static final String DEFAULT_DEVICE_ID = "-1";
    private static final int DEFAULT_PORT = 7236;
    public static final String MANUFACTURERS_MEIZU = "meizu";
    public static final String MANUFACTURERS_OPPO = "oppo";
    public static final String MANUFACTURERS_VIVO = "vivo";
    public static final String MANUFACTURERS_XIAOMI = "xiaomi";
    private String mAddress = "";
    private int mConnectType = 1;
    private String mId = "-1";
    private String mManufacturers;
    private String mModel = "GENERIC PHONE";
    private String mName = "UNKNOWN";
    private int mPort = DEFAULT_PORT;
    private byte[] mProductIcon = new byte[0];
    private String mProductIconName = "ICCOA Carlink";
    private String mProductName = "ICCOA Carlink";
    private int mProtocolVersion = 1;
    private int mSelectedWorkMode = UCarCommon.WorkMode.c.k();

    public MDevice() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getConnectType() {
        return this.mConnectType;
    }

    public String getId() {
        return this.mId;
    }

    public String getManufacturers() {
        return this.mManufacturers;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getName() {
        return this.mName;
    }

    public int getPort() {
        return this.mPort;
    }

    public byte[] getProductIcon() {
        return this.mProductIcon;
    }

    public String getProductIconName() {
        return this.mProductIconName;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public int getProtocolVersion() {
        return this.mProtocolVersion;
    }

    public int getSelectedWorkMode() {
        return this.mSelectedWorkMode;
    }

    public boolean isWired() {
        return 2 == this.mConnectType;
    }

    public boolean isWireless() {
        int i = this.mConnectType;
        return 1 == i || 3 == i;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setConnectType(int i) {
        this.mConnectType = i;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setManufacturers(String str) {
        this.mManufacturers = str;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPort(int i) {
        this.mPort = i;
    }

    public void setProductIcon(byte[] bArr) {
        this.mProductIcon = bArr;
    }

    public void setProductIconName(String str) {
        if (str != null) {
            this.mProductIconName = str;
        }
    }

    public void setProductName(String str) {
        if (str != null) {
            this.mProductName = str;
        }
    }

    public void setProtocolVersion(int i) {
        this.mProtocolVersion = i;
    }

    public void setSelectedWorkMode(int i) {
        this.mSelectedWorkMode = i;
    }

    public UCarCommon.MobileDevice toDeviceInfo() {
        return new UCarCommon.MobileDevice(this.mId, this.mProductName, this.mProductIconName, this.mProductIcon, this.mModel, this.mConnectType);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CarDevice{id='");
        sb.append(this.mId);
        sb.append('\'');
        sb.append(", productName='");
        sb.append(this.mProductName);
        sb.append('\'');
        sb.append(", productIconName='");
        sb.append(this.mProductIconName);
        sb.append('\'');
        sb.append(", productIcon='");
        byte[] bArr = this.mProductIcon;
        sb.append(bArr == null ? null : Integer.valueOf(bArr.length));
        sb.append('\'');
        sb.append(", model='");
        sb.append(this.mModel);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.mName);
        sb.append('\'');
        sb.append(", address='");
        sb.append(this.mAddress);
        sb.append('\'');
        sb.append(", port='");
        sb.append(this.mPort);
        sb.append('\'');
        sb.append(", connectType=");
        sb.append(this.mConnectType);
        sb.append(", selectedWorkMode=");
        sb.append(this.mSelectedWorkMode);
        sb.append(", protocolVersion=");
        sb.append(this.mProtocolVersion);
        sb.append(", manufacturers=");
        sb.append(this.mManufacturers);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mProductName);
        parcel.writeString(this.mProductIconName);
        byte[] bArr = this.mProductIcon;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.mProductIcon);
        } else {
            parcel.writeInt(-1);
        }
        parcel.writeString(this.mModel);
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mPort);
        parcel.writeInt(this.mConnectType);
        parcel.writeInt(this.mSelectedWorkMode);
        parcel.writeInt(this.mProtocolVersion);
        parcel.writeString(this.mManufacturers);
    }

    public MDevice(Parcel parcel) {
        this.mId = parcel.readString();
        this.mProductName = parcel.readString();
        this.mProductIconName = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            byte[] bArr = new byte[readInt];
            this.mProductIcon = bArr;
            parcel.readByteArray(bArr);
        }
        this.mModel = parcel.readString();
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mPort = parcel.readInt();
        this.mConnectType = parcel.readInt();
        this.mSelectedWorkMode = parcel.readInt();
        this.mProtocolVersion = parcel.readInt();
        this.mManufacturers = parcel.readString();
    }
}
