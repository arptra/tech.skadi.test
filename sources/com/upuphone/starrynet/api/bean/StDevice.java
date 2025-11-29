package com.upuphone.starrynet.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.strategy.discovery.advertiser.codec.AdvCodes;
import java.util.Arrays;

public class StDevice implements Parcelable, Cloneable {
    public static final Parcelable.Creator<StDevice> CREATOR = new Parcelable.Creator<StDevice>() {
        public StDevice createFromParcel(Parcel parcel) {
            return new StDevice(parcel);
        }

        public StDevice[] newArray(int i) {
            return new StDevice[i];
        }
    };
    private static final byte SUPPORT_5G = 1;
    private static final byte SUPPORT_BLE_ENCRYPT = 2;
    protected String bleMac;
    protected int bondStatus;
    protected String brEdrMac;
    protected String carId;
    protected String categoryID;
    protected String categoryName;
    protected int characterCategory = -1;
    protected String companyID;
    protected String companyName;
    protected String deviceName;
    protected byte deviceType;
    protected byte discType;
    protected byte[] identifier;
    protected String ipAddress;
    protected String localIpAddress;
    protected int localVpnTcpPort;
    protected int localVpnUdpPort;
    private byte mStarryNetStackCap = 0;
    protected String modelID;
    protected String modelName;
    protected int port;
    protected int protocol;
    protected byte region;
    protected int rssi;
    protected int status;
    protected byte supportType;
    protected byte terminalType;
    private byte[] uupShareDeviceID;
    private byte[] uupShareModelID;
    protected byte version;
    protected String wifiMac;

    public StDevice() {
    }

    public static String bytes2HexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private String toStringStDevice() {
        return "identifier:" + bytes2HexString(this.identifier) + " device type:" + this.deviceType + " terminal type:" + getTerminalType() + " protocol:" + this.protocol + ",model ID:" + this.modelID + " Support Type:" + this.supportType + " Status:" + Integer.toBinaryString(this.status) + " rssi:" + this.rssi + " StarryNetStackCap:" + this.mStarryNetStackCap + " device name:" + this.deviceName + " ble mac:" + this.bleMac + " version:" + this.version + " characterCategory:" + this.characterCategory;
    }

    public void copyDeviceInfo(StDevice stDevice) {
        this.version = stDevice.version;
        this.identifier = stDevice.identifier;
        this.deviceType = stDevice.deviceType;
        this.uupShareDeviceID = stDevice.uupShareDeviceID;
        this.uupShareModelID = stDevice.uupShareDeviceID;
        this.bleMac = stDevice.bleMac;
        this.terminalType = stDevice.terminalType;
        this.protocol = stDevice.protocol;
        this.supportType = stDevice.supportType;
        this.status = stDevice.status;
        this.rssi = stDevice.rssi;
        this.companyID = stDevice.companyID;
        this.categoryID = stDevice.categoryID;
        this.modelID = stDevice.modelID;
        this.companyName = stDevice.companyName;
        this.categoryName = stDevice.categoryName;
        this.modelName = stDevice.modelName;
        this.deviceName = stDevice.deviceName;
        this.brEdrMac = stDevice.brEdrMac;
        this.wifiMac = stDevice.wifiMac;
        this.carId = stDevice.carId;
        this.characterCategory = stDevice.characterCategory;
        this.bondStatus = stDevice.bondStatus;
        this.mStarryNetStackCap = stDevice.getStarryNetStackCap();
        this.region = stDevice.region;
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
        return Arrays.equals(this.identifier, ((StDevice) obj).identifier);
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public int getBondStatus() {
        return this.bondStatus;
    }

    public String getBrEdrMac() {
        return this.brEdrMac;
    }

    public String getCarId() {
        return this.carId;
    }

    public String getCategoryID() {
        return this.categoryID;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getCharacterCategory() {
        return this.characterCategory;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public byte getDeviceType() {
        return this.deviceType;
    }

    public byte getDiscType() {
        return this.discType;
    }

    public byte[] getIdentifier() {
        return this.identifier;
    }

    public String getIdentifier2String() {
        return bytes2HexString(this.identifier);
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getLocalIpAddress() {
        return this.localIpAddress;
    }

    public int getLocalVpnTcpPort() {
        return this.localVpnTcpPort;
    }

    public int getLocalVpnUdpPort() {
        return this.localVpnUdpPort;
    }

    public String getModelID() {
        return this.modelID;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getPort() {
        return this.port;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public byte getRegion() {
        return this.region;
    }

    public int getRssi() {
        return this.rssi;
    }

    public byte getStarryNetStackCap() {
        return this.mStarryNetStackCap;
    }

    public int getStatus() {
        return this.status;
    }

    public byte getSupportType() {
        return this.supportType;
    }

    public byte getTerminalType() {
        byte b = this.terminalType;
        if (b == 0) {
            String str = this.categoryName;
            if (str == null) {
                return b;
            }
            if (str.toUpperCase().contains("XR")) {
                setTerminalType((byte) 2);
            } else if (this.categoryName.toUpperCase().contains("CAR")) {
                setTerminalType((byte) 3);
            } else if (this.categoryName.toUpperCase().contains("3RD")) {
                setTerminalType((byte) 4);
            } else if (this.categoryName.toUpperCase().contains("PHONE")) {
                setTerminalType((byte) 1);
            } else if (this.categoryName.toUpperCase().contains("RING")) {
                setTerminalType((byte) 5);
            } else if (this.categoryName.toUpperCase().contains("IPHONE")) {
                setTerminalType((byte) 6);
            } else if (this.categoryName.toUpperCase().contains("HUD")) {
                setTerminalType((byte) 7);
            } else if (this.categoryName.toUpperCase().contains("PAD")) {
                setTerminalType((byte) 9);
            }
        }
        return this.terminalType;
    }

    public byte[] getUupShareDeviceID() {
        return this.uupShareDeviceID;
    }

    public byte[] getUupShareModelID() {
        return this.uupShareModelID;
    }

    public byte getVersion() {
        return this.version;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public int hashCode() {
        return Arrays.hashCode(this.identifier);
    }

    public boolean isApConnected() {
        return (this.status & 4) != 0;
    }

    public boolean isBleConnected() {
        return (this.status & 1) != 0;
    }

    public boolean isBrEdrConnected() {
        return (this.status & 512) != 0;
    }

    public boolean isP2pConnected() {
        return (this.status & 2) != 0;
    }

    public boolean isSppConnected() {
        return (this.status & 32) != 0;
    }

    public boolean isSupport5G() {
        return (this.supportType & 1) == 1;
    }

    public boolean isSupportBleEncrypt() {
        return (this.supportType & 2) == 2;
    }

    public boolean isSupportStarryNetStack(byte b) {
        return (this.mStarryNetStackCap & b) != 0;
    }

    public boolean isUsbConnected() {
        return (this.status & 16) != 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.version = parcel.readByte();
        parcel.readByteArray(this.identifier);
        this.deviceType = parcel.readByte();
        parcel.readByteArray(this.uupShareDeviceID);
        parcel.readByteArray(this.uupShareModelID);
        this.bleMac = parcel.readString();
        this.terminalType = parcel.readByte();
        this.protocol = parcel.readInt();
        this.supportType = parcel.readByte();
        this.status = parcel.readInt();
        this.rssi = parcel.readInt();
        this.deviceName = parcel.readString();
        this.brEdrMac = parcel.readString();
        this.wifiMac = parcel.readString();
        this.carId = parcel.readString();
        this.discType = parcel.readByte();
        this.port = parcel.readInt();
        this.ipAddress = parcel.readString();
        this.characterCategory = parcel.readInt();
        this.bondStatus = parcel.readInt();
        this.localIpAddress = parcel.readString();
        this.localVpnTcpPort = parcel.readInt();
        this.localVpnUdpPort = parcel.readInt();
        this.mStarryNetStackCap = parcel.readByte();
        this.region = parcel.readByte();
    }

    public void setA2dpConnectStatus(boolean z) {
        setConnectStatus(z, 2048);
    }

    public void setAclConnectStatus(boolean z) {
        setConnectStatus(z, 512);
    }

    public void setApConnectStatus(boolean z) {
        setConnectStatus(z, 4);
    }

    public void setBleConnectStatus(boolean z) {
        setConnectStatus(z, 1);
    }

    public void setBleMac(String str) {
        this.bleMac = str;
    }

    public void setBondStatus(int i) {
        this.bondStatus = i;
    }

    public void setBrEdrMac(String str) {
        this.brEdrMac = str;
    }

    public void setCarId(String str) {
        this.carId = str;
    }

    public void setCategoryID(String str) {
        this.categoryID = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCharacterCategory(int i) {
        this.characterCategory = i;
    }

    public void setCompanyID(String str) {
        this.companyID = str;
    }

    public void setCompanyName(String str) {
        this.companyName = str;
    }

    public void setConnectStatus(boolean z, int i) {
        if (z) {
            this.status |= i;
        } else {
            this.status &= ~i;
        }
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(byte b) {
        this.deviceType = b;
    }

    public void setDiscType(byte b) {
        this.discType = b;
    }

    public void setHfpConnectStatus(boolean z) {
        setConnectStatus(z, 1024);
    }

    public void setIdentifier(byte[] bArr) {
        this.identifier = bArr;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setLocalIpAddress(String str) {
        this.localIpAddress = str;
    }

    public void setLocalVpnTcpPort(int i) {
        this.localVpnTcpPort = i;
    }

    public void setLocalVpnUdpPort(int i) {
        this.localVpnUdpPort = i;
    }

    public void setModelID(String str) {
        this.modelID = str;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public void setP2pConnectStatus(boolean z) {
        setConnectStatus(z, 2);
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public void setRegion(byte b) {
        this.region = b;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public void setSppConnectStatus(boolean z) {
        setConnectStatus(z, 32);
    }

    public void setStarryNetStackCap(byte b) {
        this.mStarryNetStackCap = b;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSupport5G(boolean z) {
        if (z) {
            this.supportType = (byte) (this.supportType | 1);
        } else {
            this.supportType = (byte) (this.supportType & AdvCodes.ITEM_TYPE_NOT_SUPPORT);
        }
    }

    public void setSupportBleEncrypt(boolean z) {
        if (z) {
            this.supportType = (byte) (this.supportType | 2);
        } else {
            this.supportType = (byte) (this.supportType & 253);
        }
    }

    public void setTerminalType(byte b) {
        this.terminalType = b;
    }

    public void setUsbConnectStatus(boolean z) {
        setConnectStatus(z, 16);
    }

    public void setUupShareDeviceID(byte[] bArr) {
        this.uupShareDeviceID = bArr;
    }

    public void setUupShareModelID(byte[] bArr) {
        this.uupShareModelID = bArr;
    }

    public void setVersion(byte b) {
        this.version = b;
    }

    public void setWifiMac(String str) {
        this.wifiMac = str;
    }

    @NonNull
    public String toString() {
        String stringStDevice = toStringStDevice();
        if (this.deviceType != 2) {
            return stringStDevice;
        }
        return stringStDevice + " DeviceID: " + bytes2HexString(this.uupShareDeviceID) + " ModelID: " + bytes2HexString(this.uupShareModelID);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(getVersion());
        parcel.writeByteArray(getIdentifier());
        parcel.writeByte(getDeviceType());
        parcel.writeByteArray(getUupShareDeviceID());
        parcel.writeByteArray(getUupShareModelID());
        parcel.writeString(getBleMac());
        parcel.writeByte(getTerminalType());
        parcel.writeInt(getProtocol());
        parcel.writeByte(getSupportType());
        parcel.writeInt(getStatus());
        parcel.writeInt(getRssi());
        parcel.writeString(getDeviceName());
        parcel.writeString(getBrEdrMac());
        parcel.writeString(getWifiMac());
        parcel.writeString(this.carId);
        parcel.writeByte(this.discType);
        parcel.writeInt(this.port);
        parcel.writeString(this.ipAddress);
        parcel.writeInt(this.characterCategory);
        parcel.writeInt(this.bondStatus);
        parcel.writeString(this.localIpAddress);
        parcel.writeInt(this.localVpnTcpPort);
        parcel.writeInt(this.localVpnUdpPort);
        parcel.writeByte(this.mStarryNetStackCap);
        parcel.writeByte(getRegion());
    }

    public StDevice clone() {
        try {
            return (StDevice) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public boolean isSupportStarryNetStack() {
        return this.mStarryNetStackCap != 0;
    }

    public StDevice(Parcel parcel) {
        this.version = parcel.readByte();
        this.identifier = parcel.createByteArray();
        this.deviceType = parcel.readByte();
        this.uupShareDeviceID = parcel.createByteArray();
        this.uupShareModelID = parcel.createByteArray();
        this.bleMac = parcel.readString();
        this.terminalType = parcel.readByte();
        this.protocol = parcel.readInt();
        this.supportType = parcel.readByte();
        this.status = parcel.readInt();
        this.rssi = parcel.readInt();
        this.deviceName = parcel.readString();
        this.brEdrMac = parcel.readString();
        this.wifiMac = parcel.readString();
        this.carId = parcel.readString();
        this.discType = parcel.readByte();
        this.port = parcel.readInt();
        this.ipAddress = parcel.readString();
        this.characterCategory = parcel.readInt();
        this.bondStatus = parcel.readInt();
        this.localIpAddress = parcel.readString();
        this.localVpnTcpPort = parcel.readInt();
        this.localVpnUdpPort = parcel.readInt();
        this.mStarryNetStackCap = parcel.readByte();
        this.region = parcel.readByte();
    }
}
