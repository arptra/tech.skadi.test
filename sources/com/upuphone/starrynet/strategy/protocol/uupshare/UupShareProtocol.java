package com.upuphone.starrynet.strategy.protocol.uupshare;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.honey.account.k7.a;
import com.honey.account.k7.b;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.p2p.GcChannel;
import com.upuphone.starrynet.strategy.channel.p2p.GoChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.utils.AppUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@SuppressLint({"NewApi", "MissingPermission"})
public class UupShareProtocol extends BluetoothGattServerCallback implements IProtocol {
    public static final ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public static final String M_IV_PARAM_V_2 = "0102030405060708";
    private static final String TAG = "UupShareProtocol";
    public static final ParcelUuid UUP_SHARE_ADV_SERVICE_UUID = ParcelUuid.fromString("00003331-0000-1000-8000-008123456789");
    public static final ParcelUuid UUP_SHARE_CONNECT_SERVICE_UUID = ParcelUuid.fromString("00009955-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid UUP_SHARE_READ_UUID = ParcelUuid.fromString("00009954-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid UUP_SHARE_SERVICE_DATA_UUID = ParcelUuid.fromString("000001B4-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid UUP_SHARE_SERVICE_RESPONSE_DATA_UUID = ParcelUuid.fromString("00000100-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid UUP_SHARE_WRITE_UUID = ParcelUuid.fromString("00009953-0000-1000-8000-00805f9b34fb");
    private final Context mContext = StarryNetData.getInstance().getApplicationContext();
    private StConnectDevice mDevice;
    private BluetoothGattServer mGattServer;
    private final Gson mGson = new Gson();
    private KeyPair mKeyPairA;

    public UupShareProtocol() {
        StarryNetChannelManager.getInstance().addProtocol(this);
    }

    private byte[] getMasterKey() {
        GoInfo goInfo;
        KeyPair generatorECKeyPair = EncryptionUtil.generatorECKeyPair();
        this.mKeyPairA = generatorECKeyPair;
        if (generatorECKeyPair == null || (goInfo = getGoInfo()) == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mac", goInfo.getMac());
        jsonObject.addProperty("state", (Number) Integer.valueOf(StarryNetData.getInstance().isUupBusy() ? 1 : 0));
        jsonObject.addProperty(IntentKey.ACTIVITY.ACTION_KEY, Base64.getEncoder().encodeToString(this.mKeyPairA.getPublicKey()));
        return jsonObject.toString().getBytes();
    }

    private void handleDeviceInfo(StConnectDevice stConnectDevice, byte[] bArr) {
        StLog.d(TAG, "handleDeviceInfo");
        MasterKey parseMasterKey = parseMasterKey(bArr);
        if (parseMasterKey == null) {
            onAuthResult(stConnectDevice, -21, "masterKeyV2 is null");
        } else if (parseMasterKey.getState() == 1) {
            onAuthResult(stConnectDevice, -20, "peer device is busy!!");
            BleConnectManager.getInstance().disconnect(stConnectDevice.getBleMac());
        } else {
            String masterKey = getMasterKey(parseMasterKey);
            if (masterKey == null) {
                onAuthResult(stConnectDevice, -19, "p2p info  is null");
            } else {
                sendP2PInfo2PeerDevice(stConnectDevice, masterKey);
            }
        }
    }

    private void initUupService() {
        if (this.mGattServer != null) {
            BluetoothGattService bluetoothGattService = new BluetoothGattService(UUP_SHARE_CONNECT_SERVICE_UUID.getUuid(), 0);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UUP_SHARE_READ_UUID.getUuid(), 2, 1));
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UUP_SHARE_WRITE_UUID.getUuid(), 8, 16));
            boolean addService = this.mGattServer.addService(bluetoothGattService);
            StLog.d(TAG, "addUupShare : " + addService);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$readDeviceInfo$0(StConnectDevice stConnectDevice, int i, byte[] bArr) {
        if (i != 0) {
            onAuthResult(stConnectDevice, -17, "read uup share device info fail, code=" + i);
            return;
        }
        handleDeviceInfo(stConnectDevice, bArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendP2PInfo2PeerDevice$1(StConnectDevice stConnectDevice, int i, byte[] bArr) {
        if (i != 0) {
            onAuthResult(stConnectDevice, -22, "sendP2PInfo2PeerDevice fail: " + i);
            return;
        }
        onAuthResult(stConnectDevice, 0, "uup share auth success");
    }

    private void onAuthResult(StConnectDevice stConnectDevice, int i, String str) {
        StLog.d(TAG, "onAuthResult " + str + " code = " + i);
        if (i == 0) {
            StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, 2);
        } else {
            StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
        }
    }

    private void onBleSlaveConnected(UupShareInfo uupShareInfo, String str) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(uupShareInfo.getId().getBytes(StandardCharsets.UTF_8));
        if (connectDevice != null) {
            connectDevice.setBleMac(str);
            StarryDeviceManager.getInstance().deviceConnected(connectDevice, 1);
            connectP2p(uupShareInfo.getSsid(), uupShareInfo.getPsk(), uupShareInfo.getFreq(), uupShareInfo.getPort(), connectDevice.getIdentifier());
        }
    }

    private MasterKey parseMasterKey(byte[] bArr) {
        try {
            return (MasterKey) this.mGson.fromJson(new String(bArr), MasterKey.class);
        } catch (Exception e) {
            StLog.d(TAG, "parseMasterInfo error: " + e);
            return null;
        }
    }

    private void readDeviceInfo(StConnectDevice stConnectDevice) {
        StLog.d(TAG, "readDeviceInfo, device name=" + stConnectDevice.getDeviceName());
        BleConnectManager.getInstance().read(stConnectDevice.getBleMac(), BleUtil.UUP_SHARE_CONNECT_SERVICE_UUID.getUuid(), BleUtil.UUP_SHARE_READ_UUID.getUuid(), new a(this, stConnectDevice));
    }

    private void sendP2PInfo2PeerDevice(StConnectDevice stConnectDevice, String str) {
        StLog.d(TAG, "sendP2PInfo2PeerDevice");
        BleConnectManager.getInstance().write(stConnectDevice.getBleMac(), BleUtil.UUP_SHARE_CONNECT_SERVICE_UUID.getUuid(), BleUtil.UUP_SHARE_WRITE_UUID.getUuid(), str.getBytes(), new b(this, stConnectDevice));
    }

    public int connect(StDevice stDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        if (connectChannel == null) {
            return -1;
        }
        return connectChannel.connect(stDevice);
    }

    public void connectP2p(String str, String str2, int i, int i2, byte[] bArr) {
        boolean isWlanOn = SysActionManager.getInstance().isWlanOn();
        boolean isLocServiceEnable = AppUtil.isLocServiceEnable(this.mContext);
        if (!isWlanOn) {
            StLog.e(TAG, "connectP2P networkName(%s,%d),but wlan not open ,then return!!!", str, Integer.valueOf(i));
        } else if (!isLocServiceEnable) {
            StLog.e(TAG, "connectP2P networkName(%s,%d),location service not open ,then return!!!", str, Integer.valueOf(i));
        } else {
            GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
            if (gcChannel != null) {
                gcChannel.connect(str, str2, i, i2, bArr, (String) null);
            }
        }
    }

    public int disconnect(StDevice stDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        if (connectChannel == null) {
            return -1;
        }
        return connectChannel.disconnect(stDevice);
    }

    public GoInfo getGoInfo() {
        GoChannel goChannel = (GoChannel) StarryNetChannelManager.getInstance().getConnectChannel(10);
        if (goChannel == null) {
            return null;
        }
        return goChannel.getGoInfo();
    }

    public IMessageChannel getMessageChannel(StDevice stDevice) {
        return null;
    }

    public int getProfile() {
        return 2;
    }

    public void init() {
        this.mGattServer = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).openGattServer(this.mContext, this);
        initUupService();
    }

    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
    }

    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicReadRequest(bluetoothDevice, i, i2, bluetoothGattCharacteristic);
        if (UUP_SHARE_READ_UUID.getUuid().equals(bluetoothGattCharacteristic.getUuid())) {
            this.mGattServer.sendResponse(bluetoothDevice, i, 0, 0, getMasterKey());
        }
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        UupShareInfo parseSlaveKey;
        super.onCharacteristicWriteRequest(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr);
        if (z2) {
            this.mGattServer.sendResponse(bluetoothDevice, i, 0, 0, bArr);
        }
        if (UUP_SHARE_WRITE_UUID.getUuid().equals(bluetoothGattCharacteristic.getUuid()) && (parseSlaveKey = parseSlaveKey(bArr)) != null) {
            StLog.d(TAG, "onCharacteristicWriteRequest sendResponse");
            onBleSlaveConnected(parseSlaveKey, bluetoothDevice.getAddress());
        }
    }

    public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        int profile = iConnectChannel.getProfile();
        if (!(iConnectChannel instanceof IStarryNetChannel)) {
            return false;
        }
        if (profile == 1) {
            readDeviceInfo(stConnectDevice);
        }
        this.mDevice = stConnectDevice;
        return true;
    }

    public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        return false;
    }

    public void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel) {
    }

    public UupShareInfo parseSlaveKey(byte[] bArr) {
        UupShareInfo uupShareInfo = (UupShareInfo) new Gson().fromJson(new String(bArr), UupShareInfo.class);
        if (uupShareInfo == null) {
            return null;
        }
        if (TextUtils.isEmpty(uupShareInfo.getKey())) {
            return uupShareInfo;
        }
        StLog.d(TAG, "clientKeyV2 before:" + uupShareInfo);
        KeyPair keyPair = this.mKeyPairA;
        byte[] decode = Base64.getDecoder().decode(uupShareInfo.getKey());
        byte[] secretKey = EncryptionUtil.getSecretKey(decode, keyPair.getPrivateKey());
        String str = new String(EncryptionUtil.decryptCTR(Base64.getDecoder().decode(uupShareInfo.getMac()), secretKey, "0102030405060708".getBytes()));
        String str2 = new String(EncryptionUtil.decryptCTR(Base64.getDecoder().decode(uupShareInfo.getSsid()), secretKey, "0102030405060708".getBytes()));
        String str3 = new String(EncryptionUtil.decryptCTR(Base64.getDecoder().decode(uupShareInfo.getPsk()), secretKey, "0102030405060708".getBytes()));
        uupShareInfo.setMac(str);
        uupShareInfo.setSsid(str2);
        uupShareInfo.setPsk(str3);
        uupShareInfo.setKey(new String(decode));
        return uupShareInfo;
    }

    public int sendMsg(StDevice stDevice, byte[] bArr) {
        return 0;
    }

    public void connect(StDevice stDevice) {
        connect(stDevice, 1);
    }

    public void disconnect() {
        StConnectDevice stConnectDevice = this.mDevice;
        if (stConnectDevice != null) {
            disconnect(stConnectDevice.getDevice(), 1);
        }
    }

    private String getMasterKey(MasterKey masterKey) {
        GoInfo goInfo;
        byte[] secretKey;
        UupShareInfo uupShareInfo = null;
        if (masterKey == null || (goInfo = getGoInfo()) == null) {
            return null;
        }
        String arrays = Arrays.toString(StarryNetData.getInstance().getOwnDevice().getUupShareDeviceID());
        StLog.d(TAG, "masterKeyV2:" + masterKey);
        if (TextUtils.isEmpty(masterKey.getKey())) {
            uupShareInfo = new UupShareInfo();
            uupShareInfo.setId(arrays);
            uupShareInfo.setMac(goInfo.getMac());
            uupShareInfo.setPort(goInfo.getPort());
            uupShareInfo.setFreq(goInfo.getFreq());
            uupShareInfo.setSsid(goInfo.getSsid());
            uupShareInfo.setPsk(goInfo.getPwd());
        } else {
            byte[] decode = Base64.getDecoder().decode(masterKey.getKey());
            KeyPair generateECKeyPairByPublicKey = EncryptionUtil.generateECKeyPairByPublicKey(decode);
            if (!(generateECKeyPairByPublicKey == null || (secretKey = EncryptionUtil.getSecretKey(decode, generateECKeyPairByPublicKey.getPrivateKey())) == null)) {
                uupShareInfo = new UupShareInfo();
                uupShareInfo.setId(arrays);
                uupShareInfo.setPort(goInfo.getPort());
                uupShareInfo.setFreq(goInfo.getFreq());
                uupShareInfo.setMac(Base64.getEncoder().encodeToString(EncryptionUtil.encryptCTR(goInfo.getMac().getBytes(StandardCharsets.UTF_8), secretKey, "0102030405060708".getBytes())));
                uupShareInfo.setSsid(Base64.getEncoder().encodeToString(EncryptionUtil.encryptCTR(goInfo.getSsid().getBytes(), secretKey, "0102030405060708".getBytes())));
                uupShareInfo.setPsk(Base64.getEncoder().encodeToString(EncryptionUtil.encryptCTR(goInfo.getPwd().getBytes(), secretKey, "0102030405060708".getBytes())));
                uupShareInfo.setKey(Base64.getEncoder().encodeToString(generateECKeyPairByPublicKey.getPublicKey()));
            }
        }
        String json = this.mGson.toJson((Object) uupShareInfo);
        StLog.d(TAG, "generate : " + json);
        return json;
    }
}
