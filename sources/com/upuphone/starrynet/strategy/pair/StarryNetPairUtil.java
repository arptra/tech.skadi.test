package com.upuphone.starrynet.strategy.pair;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.utils.BleUtil;

public class StarryNetPairUtil {
    public static byte[] handleBleBondReq(String str) {
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        String bluetoothAddress = BleUtil.getBluetoothAddress();
        return curBondInfo != null ? StarryNetEncryptHelper.getMasterInfo(curBondInfo.getCipher(), bluetoothAddress, curBondInfo.getEncrypt()) : StarryNetEncryptHelper.getMasterKey(str, bluetoothAddress);
    }

    public static byte[] handleReadInfo(StConnectDevice stConnectDevice, String str) {
        return StarryNetEncryptHelper.getMasterInfo(stConnectDevice.getCipher(), str, stConnectDevice.getEncrypt());
    }

    public static byte[] handleReadKey(String str, String str2) {
        return StarryNetEncryptHelper.getMasterKey(str, str2);
    }

    public static byte[] handleWriteInfo(StConnectDevice stConnectDevice) {
        return StarryNetEncryptHelper.generateDeviceInfoSwitchData(stConnectDevice);
    }

    public static byte[] handleWriteKey(byte[] bArr, StConnectDevice stConnectDevice) {
        return StarryNetEncryptHelper.generateKeySwitchData(bArr, stConnectDevice);
    }

    public static byte[] switchExMsg(byte b, byte b2, byte[] bArr) {
        byte[] bArr2 = {b, b2};
        if (bArr == null || bArr.length <= 0) {
            return StarryNetEncryptHelper.generateBondMessage(bArr2);
        }
        byte[] bArr3 = new byte[(bArr.length + 2)];
        System.arraycopy(bArr2, 0, bArr3, 0, 2);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        return StarryNetEncryptHelper.generateBondMessage(bArr3);
    }

    public static byte[] switchInfo(StConnectDevice stConnectDevice) {
        return StarryNetEncryptHelper.generateDeviceInfoSwitchData(stConnectDevice);
    }

    public static byte[] unPair() {
        return StarryNetEncryptHelper.generateDeviceUnBondedData();
    }

    public static byte[] writeInfo(StConnectDevice stConnectDevice, String str) {
        return StarryNetEncryptHelper.getMasterInfoViaWrite(stConnectDevice.getCipher(), str, stConnectDevice.getEncrypt());
    }

    public static byte[] writeKey(String str, String str2) {
        return StarryNetEncryptHelper.getMasterKeyViaWrite(str, str2);
    }
}
