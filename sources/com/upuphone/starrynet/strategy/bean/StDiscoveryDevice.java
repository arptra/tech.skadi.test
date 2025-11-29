package com.upuphone.starrynet.strategy.bean;

import android.bluetooth.BluetoothDevice;
import android.hardware.usb.UsbAccessory;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.StarryNetData;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class StDiscoveryDevice extends StDevice implements IDetailInfo {
    private byte beaconId;
    private transient BluetoothDevice bluetoothDevice;
    private int cVersion;
    private int callbackType;
    private String carName;
    private String carPinCode;
    private String carProductId;
    protected String carProtocolVersion;
    private String carVendorData;
    private String carVendorId;
    private final HashMap<Byte, byte[]> hsDeviceDetail = new HashMap<>();
    private int iccoaMinAllowedRssi;
    private String iccoaSerialNum;
    private byte[] mUserData;
    private int phoneBtMacCRC16;
    private final RingNameRecorder ringNameRecorder = new RingNameRecorder();
    private UsbAccessory usbAccessory;

    public static class RingNameRecorder {
        private static final byte SET_EXTRA_NAME_DONE = 2;
        private static final byte SET_NAME_COMPLETE_MASK = 3;
        private static final byte SET_SPEC_NAME_DONE = 1;
        private byte[] extraName;
        private byte ringNameComplete;
        private byte[] specName;

        private RingNameRecorder() {
            this.ringNameComplete = 0;
        }

        private boolean checkNameComplete() {
            return (this.ringNameComplete & 3) == 3;
        }

        public String getRingName() {
            byte[] bArr;
            byte[] bArr2;
            if (!checkNameComplete() || (bArr = this.specName) == null || (bArr2 = this.extraName) == null) {
                return "";
            }
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            byte[] bArr4 = this.extraName;
            System.arraycopy(bArr4, 0, bArr3, this.specName.length, bArr4.length);
            return new String(bArr3, StandardCharsets.UTF_8);
        }

        public void setExtraName(byte[] bArr) {
            this.ringNameComplete = (byte) (this.ringNameComplete | 2);
            this.extraName = bArr;
        }

        public void setSpecName(byte[] bArr) {
            this.ringNameComplete = (byte) (this.ringNameComplete | 1);
            this.specName = bArr;
        }
    }

    public void copyDeviceInfo(StDiscoveryDevice stDiscoveryDevice) {
        super.copyDeviceInfo(stDiscoveryDevice);
        this.beaconId = stDiscoveryDevice.beaconId;
        this.bluetoothDevice = stDiscoveryDevice.bluetoothDevice;
        getDeviceDetail().putAll(stDiscoveryDevice.getDeviceDetail());
        if (stDiscoveryDevice.getDeviceType() == 3) {
            this.carVendorId = stDiscoveryDevice.getCarVendorId();
            this.carProductId = stDiscoveryDevice.getCarProductId();
            this.carName = stDiscoveryDevice.getCarName();
            this.carVendorData = stDiscoveryDevice.getCarVendorData();
        }
    }

    public byte getAdvType() {
        byte[] bArr = this.version == 1 ? this.hsDeviceDetail.get((byte) 6) : this.hsDeviceDetail.get((byte) 1);
        if (bArr == null || bArr.length <= 0) {
            return 0;
        }
        return bArr[0];
    }

    public byte getBeaconId() {
        return this.beaconId;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public int getCallbackType() {
        return this.callbackType;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getCarPinCode() {
        return this.carPinCode;
    }

    public String getCarProductId() {
        return this.carProductId;
    }

    public String getCarProtocolVersion() {
        return this.carProtocolVersion;
    }

    public String getCarVendorData() {
        return this.carVendorData;
    }

    public String getCarVendorId() {
        return this.carVendorId;
    }

    public int getConnectVersion() {
        return this.cVersion;
    }

    public HashMap<Byte, byte[]> getDeviceDetail() {
        return this.hsDeviceDetail;
    }

    public byte getDiscoveryType() {
        return this.discType;
    }

    public int getICCOAPhoneBtMacCRC16() {
        return this.phoneBtMacCRC16;
    }

    public int getIccoaMinAllowedRssi() {
        return this.iccoaMinAllowedRssi;
    }

    public String getIccoaSerialNum() {
        return this.iccoaSerialNum;
    }

    public String getRingName() {
        String ringName;
        synchronized (this.ringNameRecorder) {
            ringName = this.ringNameRecorder.getRingName();
        }
        return ringName;
    }

    public UsbAccessory getUsbAccessory() {
        return this.usbAccessory;
    }

    public byte[] getUserData() {
        return this.version == 1 ? this.mUserData : this.hsDeviceDetail.get((byte) 8);
    }

    public void setBeaconId(byte b) {
        this.beaconId = b;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice2) {
        this.bluetoothDevice = bluetoothDevice2;
    }

    public void setCallbackType(int i) {
        this.callbackType = i;
    }

    public void setCarName(String str) {
        this.carName = str;
    }

    public void setCarPinCode(String str) {
        this.carPinCode = str;
    }

    public void setCarProductId(String str) {
        this.carProductId = str;
    }

    public void setCarProtocolVersion(String str) {
        this.carProtocolVersion = str;
    }

    public void setCarVendorData(String str) {
        this.carVendorData = str;
    }

    public void setCarVendorId(String str) {
        this.carVendorId = str;
    }

    public void setCategoryID(String str) {
        super.setCategoryID(str);
        StarryNetData.getInstance();
        setTerminalType(StarryNetData.getTerminalType(str));
    }

    public void setConnectVersion(int i) {
        this.cVersion = i;
    }

    public void setIccoaMinAllowedRssi(int i) {
        this.iccoaMinAllowedRssi = i;
    }

    public void setIccoaSerialNum(String str) {
        this.iccoaSerialNum = str;
    }

    public void setPhoneBtMacCRC16(int i) {
        this.phoneBtMacCRC16 = i;
    }

    public void setRingName(byte[] bArr, boolean z) {
        synchronized (this.ringNameRecorder) {
            if (z) {
                try {
                    this.ringNameRecorder.setSpecName(bArr);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                this.ringNameRecorder.setExtraName(bArr);
            }
        }
    }

    public void setUsbAccessory(UsbAccessory usbAccessory2) {
        this.usbAccessory = usbAccessory2;
    }

    public void setUserData(byte[] bArr) {
        this.mUserData = bArr;
    }

    public String toString() {
        return "StDiscoveryDevice{version=" + this.version + ", identifier=" + StDevice.bytes2HexString(this.identifier) + ", deviceType=" + this.deviceType + ", bleMac='" + this.bleMac + '\'' + ", rssi=" + this.rssi + ", companyID='" + this.companyID + '\'' + ", categoryID='" + this.categoryID + '\'' + ", modelID='" + this.modelID + '\'' + ", deviceName='" + this.deviceName + '\'' + ", brEdrMac='" + this.brEdrMac + '\'' + ", phoneBtMac16=" + this.phoneBtMacCRC16 + ", beaconId=" + this.beaconId + '}';
    }
}
