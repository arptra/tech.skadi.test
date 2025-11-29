package com.upuphone.starrynet.strategy.encrypt;

import Starry.StarryLinkEncrypt;
import android.text.TextUtils;
import com.google.protobuf.ByteString;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StarryNetEncryptHelper {
    private static final String TAG = "StarryNetEncryptHelper";

    private StarryNetEncryptHelper() {
    }

    public static byte[] bleServerRequestClientDisconnectConnection() {
        StLog.d(TAG, "bleServerRequestClientDisconnectConnection");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.SEVER_REQUEST_CLIENT_DISCONNECT_CONNECTION).toByteArray();
    }

    private static StarryLinkEncrypt.LinkProtocol genLinkProtocol(StarryLinkEncrypt.COMMAND command) {
        byte[] identifier = StarryNetData.getInstance().getIdentifier();
        StLog.i(TAG, "identifier:" + Utils.bytesToHexString(identifier));
        return StarryLinkEncrypt.LinkProtocol.newBuilder().setDeviceId(ByteString.copyFrom(BleUtil.dealDeviceId(identifier))).setCmd(command).build();
    }

    public static byte[] generate3rdBrEdrMac(byte[] bArr) {
        StLog.d(TAG, "generate3rdBrEdrMac");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.SYNC_3RD_MAC, bArr).toByteArray();
    }

    public static byte[] generateActiveDisconnectP2p() {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.DISCONNECT_P2P_ACTIVE).toByteArray();
    }

    public static byte[] generateAdapterNameChange(byte[] bArr) {
        StLog.d(TAG, "generateAdapterNameChange");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.PEERS_NAME_CHANGE, bArr).toByteArray();
    }

    public static byte[] generateApConnected(byte[] bArr, byte[] bArr2, int i) {
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        byte[] subArray2 = ByteUtils.subArray(bArr, 0, bArr.length - 16);
        StLog.d(TAG, "generateApConnected");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.CONNECTED_AP, ByteString.copyFrom(EncryptionUtil.encrypt(bArr2, subArray2, subArray, i)).toByteArray()).toByteArray();
    }

    public static byte[] generateApDisconnected(byte[] bArr, byte[] bArr2, int i) {
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        byte[] subArray2 = ByteUtils.subArray(bArr, 0, bArr.length - 16);
        StLog.d(TAG, "generateApConnected");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.DISCONNECTED_AP, ByteString.copyFrom(EncryptionUtil.encrypt(bArr2, subArray2, subArray, i)).toByteArray()).toByteArray();
    }

    public static byte[] generateAuthMessage(byte[] bArr) {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.AUTH_MESSAGE, bArr).toByteArray();
    }

    public static byte[] generateAuthStatus() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        byte[] bArr = new byte[0];
        if (ownDevice != null && !TextUtils.isEmpty(ownDevice.getDeviceName())) {
            bArr = ownDevice.getDeviceName().getBytes();
        }
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.AUTH_STATUE, bArr).toByteArray();
    }

    public static byte[] generateBleStateChangeData(int i, StConnectDevice stConnectDevice) {
        StarryLinkEncrypt.IosBleSTATUS iosBleSTATUS = i != 16 ? i != 32 ? i != 48 ? null : StarryLinkEncrypt.IosBleSTATUS.BLE_BONDED : StarryLinkEncrypt.IosBleSTATUS.BLE_BONDING : StarryLinkEncrypt.IosBleSTATUS.BLE_NOBOND;
        if (iosBleSTATUS != null) {
            StarryLinkEncrypt.BLEConnectStatus build = StarryLinkEncrypt.BLEConnectStatus.newBuilder().setBtStatus(iosBleSTATUS).build();
            StLog.d(TAG, "generateBleStateChangeData bleStatus: " + iosBleSTATUS);
            return genLinkProtocol(StarryLinkEncrypt.COMMAND.BLE_STATUS_CHANGE, build.toByteArray()).toByteArray();
        }
        StLog.w(TAG, "generateBleStateChangeData bleStatus is null, profileState=" + i);
        return null;
    }

    public static byte[] generateBondMessage(byte[] bArr) {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.BOND_MSG_CHANGE, bArr).toByteArray();
    }

    public static byte[] generateBtConnectStateData(boolean z, StConnectDevice stConnectDevice) {
        StarryLinkEncrypt.BTSTATUS btstatus = StarryLinkEncrypt.BTSTATUS.DEFAULT;
        StarryLinkEncrypt.BTConnectStatus build = StarryLinkEncrypt.BTConnectStatus.newBuilder().setBtStatus(z ? StarryLinkEncrypt.BTSTATUS.EXIST_CONNECTED_BT : StarryLinkEncrypt.BTSTATUS.NO_CONNECTED_BT).build();
        StLog.d(TAG, "generateBtConnectStateData btConnectStatus: " + build);
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.BT_STATE_CHANGE, build.toByteArray()).toByteArray();
    }

    public static byte[] generateBtStateChangeData(int i, StConnectDevice stConnectDevice) {
        StLog.d(TAG, "generateBtStateChangeData bondInfo: " + stConnectDevice.getBrEdrBondStatus() + ",profileState=" + i);
        StarryLinkEncrypt.BTSTATUS btstatus = StarryLinkEncrypt.BTSTATUS.DEFAULT;
        if (i == -256) {
            btstatus = StarryLinkEncrypt.BTSTATUS.CONNECT_FAIL;
        } else if (i == -64) {
            btstatus = StarryLinkEncrypt.BTSTATUS.DISCONNECTED;
        } else if (i == 16) {
            btstatus = StarryLinkEncrypt.BTSTATUS.NOBOND;
        } else if (i == 32) {
            btstatus = StarryLinkEncrypt.BTSTATUS.BONDING;
        } else if (i == 64) {
            btstatus = StarryLinkEncrypt.BTSTATUS.CONNECTED_ACL;
        } else if (i == 128) {
            btstatus = StarryLinkEncrypt.BTSTATUS.CONNECTED_HFP;
        } else if (i == 256) {
            btstatus = StarryLinkEncrypt.BTSTATUS.CONNECTED_A2DP;
        } else if (i == 48) {
            btstatus = StarryLinkEncrypt.BTSTATUS.BOND;
        } else if (i == 49) {
            btstatus = StarryLinkEncrypt.BTSTATUS.BOND_CANCEL_OR_TIMEOUT;
        }
        StarryLinkEncrypt.BTConnectStatus build = StarryLinkEncrypt.BTConnectStatus.newBuilder().setBtStatus(btstatus).build();
        StLog.d(TAG, "generateBtStateChangeData btStatus: " + btstatus);
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.BT_STATE_CHANGE, build.toByteArray()).toByteArray();
    }

    public static byte[] generateCancelAuth() {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.CANCEL_AUTH).toByteArray();
    }

    public static byte[] generateClearData() {
        StLog.d(TAG, "generateClearData");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.UN_BONDED).toByteArray();
    }

    public static byte[] generateConnectAp(byte[] bArr, byte[] bArr2, int i) {
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        byte[] subArray2 = ByteUtils.subArray(bArr, 0, bArr.length - 16);
        StLog.d(TAG, "generateConnectAp");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.CONNECT_AP, ByteString.copyFrom(EncryptionUtil.encrypt(bArr2, subArray2, subArray, i)).toByteArray()).toByteArray();
    }

    public static byte[] generateConnectGc(byte[] bArr, String str, boolean z, int i) {
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        byte[] encrypt = EncryptionUtil.encrypt(StarryLinkEncrypt.WifiGcInfo.newBuilder().setMac(str).setIsConnected(z).build().toByteArray(), ByteUtils.subArray(bArr, 0, bArr.length - 16), subArray, i);
        StLog.d(TAG, "generateConnectGc deviceInfo: " + encrypt.length);
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.CONNECT_GC, encrypt).toByteArray();
    }

    public static byte[] generateConnectGo(byte[] bArr, String str, GoInfo goInfo, int i) {
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        byte[] subArray2 = ByteUtils.subArray(bArr, 0, bArr.length - 16);
        StLog.d(TAG, "go info " + goInfo + ", gc mac = " + str);
        StarryLinkEncrypt.WifiGoInfo.Builder address = StarryLinkEncrypt.WifiGoInfo.newBuilder().setMac(goInfo.getMac()).setPort(goInfo.getPort()).setFreq(goInfo.getFreq()).setSsid(goInfo.getSsid()).setPsk(goInfo.getPwd()).setAddress(goInfo.getAddress());
        if (!TextUtils.isEmpty(str)) {
            address.setGcMac(str);
        }
        byte[] byteArray = address.build().toByteArray();
        byte[] encrypt = EncryptionUtil.encrypt(byteArray, subArray2, subArray, i);
        StLog.d(TAG, "generateConnectGo deviceInfo: " + byteArray.length);
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.CONNECT_GO, encrypt).toByteArray();
    }

    public static byte[] generateCreateAp() {
        StLog.d(TAG, "generateCreateAp");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.CREATE_AP).toByteArray();
    }

    public static byte[] generateDeviceInfo(StConnectDevice stConnectDevice) {
        stConnectDevice.getIdentifier();
        StarryLinkEncrypt.BTSTATUS btstatus = StarryLinkEncrypt.BTSTATUS.DEFAULT;
        int brEdrBondStatus = stConnectDevice.getBrEdrBondStatus();
        if (brEdrBondStatus == 3) {
            btstatus = StarryLinkEncrypt.BTSTATUS.BONDING;
        } else if (brEdrBondStatus == 16) {
            btstatus = StarryLinkEncrypt.BTSTATUS.NOBOND;
        } else if (brEdrBondStatus == 48) {
            btstatus = StarryLinkEncrypt.BTSTATUS.BOND;
        }
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        return StarryLinkEncrypt.DeviceInfo.newBuilder().setBtMac(ownDevice.getBrEdrMac()).setCompanyId(ownDevice.getCompanyID()).setCategoryId(ownDevice.getCategoryID()).setModelId(ownDevice.getModelID()).setName(ByteString.copyFrom(ownDevice.getDeviceName() == null ? "" : ownDevice.getDeviceName(), StandardCharsets.UTF_8)).setBattery(BleUtil.getBatteryData()).setBtStatus(btstatus).build().toByteArray();
    }

    public static byte[] generateDeviceInfoSwitchData(StConnectDevice stConnectDevice) {
        byte[] cipher = stConnectDevice.getCipher();
        int encrypt = stConnectDevice.getEncrypt();
        if (cipher == null) {
            StLog.d(TAG, "generateDeviceInfoSwitchData cipher is null");
            return null;
        }
        byte[] subArray = ByteUtils.subArray(cipher, cipher.length - 16);
        byte[] subArray2 = ByteUtils.subArray(cipher, 0, cipher.length - 16);
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.WRITE_SWITCH_INFO, EncryptionUtil.encrypt(StarryLinkEncrypt.WriteSwitchInfo.newBuilder().setInfo(ByteString.copyFrom(EncryptionUtil.encrypt(generateDeviceInfo(stConnectDevice), subArray2, subArray, encrypt))).build().toByteArray(), subArray2, subArray, encrypt)).toByteArray();
    }

    public static byte[] generateDeviceUnBondedData() {
        byte[] byteArray = genLinkProtocol(StarryLinkEncrypt.COMMAND.UN_BONDED).toByteArray();
        StLog.d(TAG, "generateDeviceUnBondedData ,data=" + byteArray.length);
        return byteArray;
    }

    public static byte[] generateDisconnectAp(byte[] bArr, byte[] bArr2, int i) {
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        byte[] subArray2 = ByteUtils.subArray(bArr, 0, bArr.length - 16);
        StLog.d(TAG, "generateDisconnectAp");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.DISCONNECT_AP, ByteString.copyFrom(EncryptionUtil.encrypt(bArr2, subArray2, subArray, i)).toByteArray()).toByteArray();
    }

    public static byte[] generateDisconnectBle() {
        StLog.d(TAG, "generateDisconnectBle");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.DISCONNECT_BLE).toByteArray();
    }

    public static byte[] generateDisconnectP2p() {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.DISCONNECT_P2P).toByteArray();
    }

    public static byte[] generateGcIpAddress(byte[] bArr) {
        StLog.d(TAG, "generateGcIpAddress");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.SYNC_GC_IP, bArr).toByteArray();
    }

    public static byte[] generateKeySwitchData(byte[] bArr, StConnectDevice stConnectDevice) {
        if (bArr == null) {
            StLog.d(TAG, "generateKeySwitchData masterKey NULL return");
            return null;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        KeyPair generateECKeyPairByPublicKey = EncryptionUtil.generateECKeyPairByPublicKey(copyOf);
        if (generateECKeyPairByPublicKey == null) {
            StLog.d(TAG, "generateKeySwitchData keyPairB NULL return");
            return null;
        }
        byte[] secretKey = EncryptionUtil.getSecretKey(copyOf, generateECKeyPairByPublicKey.getPrivateKey());
        if (secretKey == null) {
            StLog.d(TAG, "generateKeySwitchData secretKeyC NULL return");
            return null;
        }
        byte[] bytes = EncryptionUtil.generateIV().getBytes();
        StLog.d(TAG, "generateKeySwitchData ivParam:" + bytes.length);
        StLog.d(TAG, "generateKeySwitchData deviceInfo: " + StarryNetData.getInstance().getOwnDevice().toString());
        StarryLinkEncrypt.LinkProtocol genLinkProtocol = genLinkProtocol(StarryLinkEncrypt.COMMAND.WRITE_SWITCH_KEY, StarryLinkEncrypt.WriteSwitchKey.newBuilder().setKey(ByteString.copyFrom(ByteUtils.append(generateECKeyPairByPublicKey.getPublicKey(), bytes))).setInfo(ByteString.copyFrom(EncryptionUtil.encrypt(generateDeviceInfo(stConnectDevice), secretKey, bytes, stConnectDevice.getEncrypt()))).build().toByteArray());
        stConnectDevice.setSecretAndParam(secretKey, bytes);
        StLog.d(TAG, "generateKeySwitchData, linkProtocol length:" + genLinkProtocol.toByteArray().length);
        return genLinkProtocol.toByteArray();
    }

    public static byte[] generateNotifyWifiDisable() {
        StLog.d(TAG, "generateNotifyWifiDisable");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.PEERS_DISABLE_WIFI).toByteArray();
    }

    public static byte[] generateRemoteStarryNetStack(byte[] bArr) {
        StLog.d(TAG, "generateRemoteStarryNet");
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.STARRY_NET_STACK, bArr).toByteArray();
    }

    public static byte[] generateSppServerRequestConnectMessage() {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.SPP_SERVER_REQUEST_CONNECT).toByteArray();
    }

    public static byte[] generateSppServerUUIDSyncMessage(byte[] bArr) {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.SPP_SERVER_UUID_SYNC, bArr).toByteArray();
    }

    public static byte[] getMasterEnsure() {
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.ENSURE).toByteArray();
    }

    public static byte[] getMasterInfo(byte[] bArr, String str, int i) {
        StLog.d(TAG, "getMasterInfo");
        if (bArr == null) {
            StLog.d(TAG, "getMasterInfo cipher is null");
            return null;
        }
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.READ_SWITCH_INFO, EncryptionUtil.encrypt(StarryLinkEncrypt.ReadSwitchInfo.newBuilder().setInfo(ByteString.copyFrom(Utils.getBytesFromAddress(str))).build().toByteArray(), ByteUtils.subArray(bArr, 0, bArr.length - 16), subArray, i)).toByteArray();
    }

    public static byte[] getMasterInfoViaWrite(byte[] bArr, String str, int i) {
        StLog.d(TAG, "getMasterInfo");
        if (bArr == null) {
            StLog.d(TAG, "getMasterInfo cipher is null");
            return null;
        }
        byte[] subArray = ByteUtils.subArray(bArr, bArr.length - 16);
        return genLinkProtocol(StarryLinkEncrypt.COMMAND.WRITE_SWITCH_INFO, EncryptionUtil.encrypt(StarryLinkEncrypt.WriteSwitchInfo.newBuilder().setInfo(ByteString.copyFrom(Utils.getBytesFromAddress(str))).build().toByteArray(), ByteUtils.subArray(bArr, 0, bArr.length - 16), subArray, i)).toByteArray();
    }

    public static byte[] getMasterKey(String str, String str2) {
        StLog.d(TAG, "getMasterKey");
        KeyPair generatorECKeyPair = EncryptionUtil.generatorECKeyPair();
        if (generatorECKeyPair == null) {
            StLog.d(TAG, "getMasterKey key is null");
            return null;
        }
        StarryLinkEncrypt.LinkProtocol genLinkProtocol = genLinkProtocol(StarryLinkEncrypt.COMMAND.READ_SWITCH_KEY, StarryLinkEncrypt.ReadSwitchKey.newBuilder().setKey(ByteString.copyFrom(generatorECKeyPair.getPublicKey())).setBtMac(ByteString.copyFrom(Utils.getBytesFromAddress(str2))).build().toByteArray());
        StLog.i(TAG, "getMasterKey key:" + ByteUtils.toHexString(generatorECKeyPair.getPublicKey()));
        StarryNetEncryptData.getInstance().saveKeyPair(str, generatorECKeyPair);
        return genLinkProtocol.toByteArray();
    }

    public static byte[] getMasterKeyViaWrite(String str, String str2) {
        KeyPair generatorECKeyPair = EncryptionUtil.generatorECKeyPair();
        if (generatorECKeyPair == null) {
            StLog.d(TAG, "getMasterKeyViaWrite key is null");
            return null;
        }
        StarryLinkEncrypt.LinkProtocol genLinkProtocol = genLinkProtocol(StarryLinkEncrypt.COMMAND.WRITE_SWITCH_KEY, StarryLinkEncrypt.WriteSwitchKey.newBuilder().setKey(ByteString.copyFrom(generatorECKeyPair.getPublicKey())).setInfo(ByteString.copyFrom(Utils.getBytesFromAddress(str2))).build().toByteArray());
        StLog.i(TAG, "getMasterKeyViaWrite key:" + ByteUtils.toHexString(generatorECKeyPair.getPublicKey()));
        StarryNetEncryptData.getInstance().saveKeyPair(str, generatorECKeyPair);
        return genLinkProtocol.toByteArray();
    }

    private static StarryLinkEncrypt.LinkProtocol genLinkProtocol(StarryLinkEncrypt.COMMAND command, byte[] bArr) {
        byte[] identifier = StarryNetData.getInstance().getIdentifier();
        StLog.i(TAG, "identifier:" + Utils.bytesToHexString(identifier));
        return StarryLinkEncrypt.LinkProtocol.newBuilder().setDeviceId(ByteString.copyFrom(BleUtil.dealDeviceId(identifier))).setCmd(command).setData(ByteString.copyFrom(bArr)).build();
    }
}
