package com.upuphone.starrynet.strategy.bean;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.database.dao.BondInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.utils.BleUtil;

public class StConnectDevice extends BondInfo implements IDetailInfo {
    public static final int PROFILE_A2DP = 256;
    public static final int PROFILE_ACL = 64;
    public static final int PROFILE_AP = 16;
    public static final int PROFILE_BLE_CLIENT = 2;
    public static final int PROFILE_BLE_SERVER = 1;
    public static final int PROFILE_GC = 8;
    public static final int PROFILE_GO = 4;
    public static final int PROFILE_HFP = 128;
    public static final int PROFILE_SPP_CLIENT = 2048;
    public static final int PROFILE_SPP_SERVER = 1024;
    public static final int PROFILE_STA = 32;
    public static final int PROFILE_USB = 512;
    private static final String TAG = "StConnectDevice";
    private String address;
    private String bleMac;
    public int bluetoothDeviceType;
    private boolean cancelConfirm = false;
    private String carId;
    private String carName;
    private String carPinCode;
    private String carProductId;
    private String carProtocolVersion;
    private String carVendorData;
    private String carVendorId;
    protected int characterCategory = -1;
    private byte discType;
    private int encrypt;
    private int freq;
    private String iccoaSerialNum;
    private boolean isP2pPublish;
    private boolean isPreConnect;
    private boolean isSppOpenStatus = true;
    private byte mStarryNetStackCap = 0;
    private byte[] param;
    private int phoneBtMacCRC16;
    private int port;
    private int protocolStatus;
    private String pwd;
    private byte[] secret;
    private String ssid;
    private byte version;
    private String wifiMac;

    public StConnectDevice() {
    }

    public String getAddress() {
        return this.address;
    }

    public int getBleBondStatus() {
        return this.status & 15;
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public int getBluetoothDeviceType() {
        return this.bluetoothDeviceType;
    }

    @SuppressLint({"MissingPermission"})
    public int getBrEdrBondStatus() {
        BluetoothDevice bluetoothDevice = BleUtil.getBluetoothDevice(this.brEdrMac);
        if (bluetoothDevice == null) {
            int i = this.status & CircularProgressButton.MorphingAnimation.DURATION_NORMAL;
            if (i == 0) {
                return 16;
            }
            return i;
        }
        int bondState = bluetoothDevice.getBondState();
        if (bondState == 12) {
            return 48;
        }
        return bondState == 10 ? 16 : 32;
    }

    public String getCarId() {
        return this.carId;
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

    public String getCategoryName() {
        if (TextUtils.isEmpty(this.categoryName)) {
            this.categoryName = StarryNetData.getInstance().getCategoryName(this.categoryID);
        }
        return this.categoryName;
    }

    public int getCharacterCategory() {
        return this.characterCategory;
    }

    public byte[] getCipher() {
        byte[] bArr;
        byte[] bArr2 = this.cipher;
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bArr3 = this.secret;
        if (!(bArr3 == null || (bArr = this.param) == null)) {
            this.cipher = ByteUtils.append(bArr3, bArr);
        }
        return this.cipher;
    }

    public String getCompanyName() {
        if (TextUtils.isEmpty(this.companyName)) {
            this.companyName = StarryNetData.getInstance().getCompanyName(this.companyID);
        }
        return this.companyName;
    }

    public StDevice getDevice() {
        StDevice stDevice = new StDevice();
        stDevice.setIdentifier(this.identifier);
        stDevice.setDeviceType(this.deviceType);
        stDevice.setTerminalType(getTerminalType());
        stDevice.setProtocol(this.protocol);
        stDevice.setVersion(this.version);
        stDevice.setCompanyID(this.companyID);
        stDevice.setCategoryID(this.categoryID);
        stDevice.setModelID(this.modelID);
        stDevice.setCompanyName(getCompanyName());
        stDevice.setCategoryName(getCategoryName());
        stDevice.setModelName(getModelName());
        stDevice.setDeviceName(this.deviceName);
        stDevice.setBrEdrMac(this.brEdrMac);
        boolean isBleConnected = isBleConnected();
        if (isP2pConnected()) {
            isBleConnected |= true;
        }
        if (isSoftApConnected()) {
            isBleConnected |= true;
        }
        if (isProtocolConnected(64)) {
            isBleConnected |= true;
        }
        if (isProtocolConnected(128)) {
            isBleConnected |= true;
        }
        if (isProtocolConnected(256)) {
            isBleConnected |= true;
        }
        if (isProtocolConnected(512)) {
            isBleConnected |= true;
        }
        if (isSppConnected()) {
            isBleConnected |= true;
        }
        stDevice.setStatus(isBleConnected ? 1 : 0);
        stDevice.setWifiMac(this.wifiMac);
        stDevice.setBleMac(this.bleMac);
        stDevice.setBondStatus(this.status);
        if (stDevice.getDeviceType() == 3) {
            stDevice.setCarId(this.carId);
            stDevice.setDiscType(this.discType);
        }
        stDevice.setCharacterCategory(this.characterCategory);
        stDevice.setStarryNetStackCap(getStarryNetStackCap());
        return stDevice;
    }

    public byte getDiscoveryType() {
        return this.discType;
    }

    public int getEncrypt() {
        return this.encrypt;
    }

    public int getFreq() {
        return this.freq;
    }

    public int getICCOAPhoneBtMacCRC16() {
        return this.phoneBtMacCRC16;
    }

    public String getIccoaSerialNum() {
        return this.iccoaSerialNum;
    }

    public String getIdentifier2String() {
        return StDevice.bytes2HexString(this.identifier);
    }

    public String getModelName() {
        if (TextUtils.isEmpty(this.modelName)) {
            this.modelName = StarryNetData.getInstance().getModelName(this.modelID);
        }
        return this.modelName;
    }

    public byte[] getParam() {
        return this.param;
    }

    public int getPort() {
        return this.port;
    }

    public int getProtocolStatus() {
        return this.protocolStatus;
    }

    public String getPwd() {
        return this.pwd;
    }

    public byte[] getSecret() {
        return this.secret;
    }

    public String getSsid() {
        return this.ssid;
    }

    public byte getStarryNetStackCap() {
        return this.mStarryNetStackCap;
    }

    public byte getTerminalType() {
        if (this.terminalType == 0) {
            StarryNetData.getInstance();
            this.terminalType = StarryNetData.getTerminalType(this.categoryID);
        }
        return this.terminalType;
    }

    public byte getVersion() {
        return this.version;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public boolean isBleConnected() {
        return isProtocolConnected(2) || isProtocolConnected(1);
    }

    public boolean isBonding() {
        int bleBondStatus = getBleBondStatus();
        return bleBondStatus > 0 && bleBondStatus < 4;
    }

    public boolean isBtConnected() {
        return isProtocolConnected(64) || isProtocolConnected(256) || isProtocolConnected(128);
    }

    public boolean isCancelConfirm() {
        return this.cancelConfirm;
    }

    public boolean isConnected() {
        return this.protocolStatus > 0;
    }

    public boolean isP2pConnected() {
        return isProtocolConnected(4) || isProtocolConnected(8);
    }

    public boolean isP2pPublish() {
        return this.isP2pPublish;
    }

    public boolean isPreConnect() {
        return this.isPreConnect;
    }

    public boolean isProtocolConnected(int i) {
        return (this.protocolStatus & i) != 0;
    }

    public boolean isSoftApConnected() {
        return isProtocolConnected(16) || isProtocolConnected(32);
    }

    public boolean isSppChannelOpen() {
        return isSppConnected() && this.isSppOpenStatus;
    }

    public boolean isSppClient() {
        return isProtocolConnected(2);
    }

    public boolean isSppConnected() {
        return isProtocolConnected(1024) || isProtocolConnected(2048);
    }

    public boolean isSppServer() {
        return isProtocolConnected(1);
    }

    public boolean isUsbConnected() {
        return isProtocolConnected(512);
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBleMac(String str) {
        this.bleMac = str;
    }

    public void setBluetoothDeviceType(int i) {
        this.bluetoothDeviceType = i;
    }

    public void setBondInfo(BondInfo bondInfo) {
        if (bondInfo != null) {
            if (this.identifier == null) {
                this.identifier = bondInfo.getIdentifier();
            }
            if (this.deviceType == 0) {
                this.deviceType = (byte) bondInfo.getDeviceType();
            }
            if (this.terminalType == 0) {
                this.terminalType = bondInfo.getTerminalType();
            }
            if (TextUtils.isEmpty(this.companyID)) {
                this.companyID = bondInfo.getCompanyID();
            }
            if (TextUtils.isEmpty(this.categoryID)) {
                this.categoryID = bondInfo.getCategoryID();
            }
            if (TextUtils.isEmpty(this.modelID)) {
                this.modelID = bondInfo.getModelID();
                StLog.d(TAG, "setBondInfo setModelId " + this.modelID);
            }
            if (TextUtils.isEmpty(this.companyName)) {
                this.companyName = bondInfo.getCompanyName();
            }
            if (TextUtils.isEmpty(this.categoryName)) {
                this.categoryName = bondInfo.getCategoryName();
            }
            if (TextUtils.isEmpty(this.modelName)) {
                this.modelName = bondInfo.getModelName();
            }
            if (TextUtils.isEmpty(this.deviceName)) {
                this.deviceName = bondInfo.getDeviceName();
            }
            if (TextUtils.isEmpty(this.brEdrMac)) {
                this.brEdrMac = bondInfo.getBrEdrMac();
            }
            if (this.terminalType == 5) {
                this.bleMac = this.brEdrMac;
            }
            if (this.param == null || this.secret == null) {
                byte[] cipher = bondInfo.getCipher();
                this.cipher = cipher;
                if (cipher != null && cipher.length > 16) {
                    this.param = ByteUtils.subArray(cipher, cipher.length - 16);
                    byte[] bArr = this.cipher;
                    this.secret = ByteUtils.subArray(bArr, 0, bArr.length - 16);
                }
            }
            if (this.status == 0) {
                this.status = bondInfo.getStatus();
            }
            if (this.date == 0) {
                this.date = bondInfo.getDate();
            }
            if (this.cVersion == 0) {
                this.cVersion = bondInfo.getConnectVersion();
            }
        }
    }

    public void setCancelConfirm(boolean z) {
        this.cancelConfirm = z;
    }

    public void setCarId(String str) {
        this.carId = str;
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
        this.categoryID = str;
    }

    public void setCharacterCategory(int i) {
        this.characterCategory = i;
    }

    public void setCipher(byte[] bArr, byte[] bArr2) {
        this.secret = bArr;
        this.param = bArr2;
        this.cipher = ByteUtils.append(bArr, bArr2);
    }

    public void setCompanyID(String str) {
        this.companyID = str;
    }

    public void setDevice(StDevice stDevice) {
        if (stDevice != null) {
            if (this.identifier == null) {
                this.identifier = stDevice.getIdentifier();
            }
            byte version2 = stDevice.getVersion();
            if (version2 > 0) {
                this.version = version2;
            }
            byte deviceType = stDevice.getDeviceType();
            if (deviceType != 0) {
                this.deviceType = (byte) deviceType;
            }
            String bleMac2 = stDevice.getBleMac();
            if (!TextUtils.isEmpty(bleMac2)) {
                this.bleMac = bleMac2;
            }
            String brEdrMac = stDevice.getBrEdrMac();
            if (!TextUtils.isEmpty(brEdrMac)) {
                this.brEdrMac = brEdrMac;
            }
            String wifiMac2 = stDevice.getWifiMac();
            if (!TextUtils.isEmpty(wifiMac2)) {
                this.wifiMac = wifiMac2;
            }
            byte terminalType = stDevice.getTerminalType();
            if (terminalType != 0) {
                this.terminalType = (byte) terminalType;
            }
            String companyID = stDevice.getCompanyID();
            if (!TextUtils.isEmpty(companyID)) {
                this.companyID = companyID;
            }
            String categoryID = stDevice.getCategoryID();
            if (!TextUtils.isEmpty(categoryID)) {
                this.categoryID = categoryID;
            }
            String modelID = stDevice.getModelID();
            if (!TextUtils.isEmpty(modelID)) {
                this.modelID = modelID;
                StLog.d(TAG, "setDevice setModelId " + modelID);
            }
            String companyName = stDevice.getCompanyName();
            if (!TextUtils.isEmpty(companyName)) {
                this.companyName = companyName;
            }
            String categoryName = stDevice.getCategoryName();
            if (!TextUtils.isEmpty(categoryName)) {
                this.categoryName = categoryName;
            }
            String modelName = stDevice.getModelName();
            if (!TextUtils.isEmpty(modelName)) {
                this.modelName = modelName;
            }
            String deviceName = stDevice.getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                this.deviceName = deviceName;
            }
            if (stDevice.getDeviceType() == 3) {
                String carId2 = stDevice.getCarId();
                if (!TextUtils.isEmpty(carId2)) {
                    this.carId = carId2;
                }
                byte discType2 = stDevice.getDiscType();
                if (discType2 > 0) {
                    this.discType = discType2;
                }
            }
            if (stDevice.getCharacterCategory() >= 0) {
                this.characterCategory = stDevice.getCharacterCategory();
            }
            this.mStarryNetStackCap = stDevice.getStarryNetStackCap();
        }
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(byte b) {
        this.deviceType = b;
    }

    public void setEncrypt(int i) {
        this.encrypt = i;
    }

    public void setFreq(int i) {
        this.freq = i;
    }

    public void setIccoaSerialNum(String str) {
        this.iccoaSerialNum = str;
    }

    public void setIdentifier(byte[] bArr) {
        this.identifier = bArr;
    }

    public void setModelID(String str) {
        this.modelID = str;
        StLog.d(TAG, "setModelID " + str);
    }

    public void setP2pPublish(boolean z) {
        this.isP2pPublish = z;
    }

    public void setPhoneBtMacCRC16(int i) {
        this.phoneBtMacCRC16 = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPreConnect(boolean z) {
        this.isPreConnect = z;
    }

    public void setProtocolStatus(boolean z, int i) {
        if (z) {
            this.protocolStatus |= i;
        } else {
            this.protocolStatus &= ~i;
        }
        StLog.d(TAG, "setProtocolStatus status = " + this.protocolStatus);
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public void setSecretAndParam(byte[] bArr, byte[] bArr2) {
        this.secret = bArr;
        this.param = bArr2;
        this.cipher = null;
    }

    public void setSppStateOpen(boolean z) {
        this.isSppOpenStatus = z;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setStarryNetStackCap(byte b) {
        this.mStarryNetStackCap = b;
    }

    public void setStatus(int i) {
        StLog.d(TAG, "setStatus status = " + i + " old = " + this.status);
        if (i < 16) {
            this.status = i | (this.status & -16);
            return;
        }
        int i2 = this.status & -241;
        this.status = i2;
        if (i > 16) {
            this.status = i | i2;
        }
    }

    public void setTerminalType(byte b) {
        this.terminalType = b;
    }

    public void setWifiMac(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wifiMac = str;
        }
    }

    @NonNull
    public String toString() {
        return "StConnectDevice{id=" + getIdentifier2String() + " version=" + this.version + ", c version=" + this.cVersion + ", crypt='" + this.encrypt + ", model id=" + this.modelID + ", device type=" + this.deviceType + ", terminal type='" + this.terminalType + ", discovery type='" + this.discType + ", protocolStatus=" + Integer.toBinaryString(this.protocolStatus) + ", status=0x" + Integer.toHexString(this.status) + ", bleMac='" + this.bleMac + ", br der ='" + this.brEdrMac + ", mac='" + this.wifiMac + ", address='" + this.address + ", port=" + this.port + ", freq=" + this.freq + ", ssid='" + this.ssid + '\'' + '}';
    }

    public StConnectDevice(BondInfo bondInfo) {
        setBondInfo(bondInfo);
    }
}
