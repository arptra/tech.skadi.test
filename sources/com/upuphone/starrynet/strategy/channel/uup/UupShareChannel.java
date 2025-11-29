package com.upuphone.starrynet.strategy.channel.uup;

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
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.util.Base64;

@SuppressLint({"MissingPermission"})
public class UupShareChannel extends BluetoothGattServerCallback implements IUupShareCallback {
    public static final ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public static final String M_IV_PARAM_V_2 = "0102030405060708";
    private static final String TAG = "UupShareChannel";
    public static final ParcelUuid UUP_SHARE_ADV_SERVICE_UUID = ParcelUuid.fromString("00003331-0000-1000-8000-008123456789");
    public static final ParcelUuid UUP_SHARE_CONNECT_SERVICE_UUID = ParcelUuid.fromString("00009955-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid UUP_SHARE_READ_UUID = ParcelUuid.fromString("00009954-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid UUP_SHARE_SERVICE_DATA_UUID = ParcelUuid.fromString("000001B4-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid UUP_SHARE_SERVICE_RESPONSE_DATA_UUID = ParcelUuid.fromString("00000100-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid UUP_SHARE_WRITE_UUID = ParcelUuid.fromString("00009953-0000-1000-8000-00805f9b34fb");
    private IUupShareCallback mCallback;
    private final UupShareGatt mGatt = new UupShareGatt(this);
    private BluetoothGattServer mGattServer;
    private KeyPair mKeyPairA;

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

    private void initUupService() {
        if (this.mGattServer != null) {
            BluetoothGattService bluetoothGattService = new BluetoothGattService(UUP_SHARE_CONNECT_SERVICE_UUID.getUuid(), 0);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UUP_SHARE_READ_UUID.getUuid(), 2, 1));
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UUP_SHARE_WRITE_UUID.getUuid(), 8, 16));
            boolean addService = this.mGattServer.addService(bluetoothGattService);
            StLog.d(TAG, "addUupShare : " + addService);
        }
    }

    public int connect(StDevice stDevice) {
        return this.mGatt.connect(stDevice);
    }

    public int disconnect() {
        return this.mGatt.disconnect();
    }

    public GoInfo getGoInfo() {
        return this.mCallback.getGoInfo();
    }

    public void init(Context context) {
        this.mGattServer = ((BluetoothManager) context.getSystemService("bluetooth")).openGattServer(context, this);
        initUupService();
    }

    public void onBleMasterConnected(StDevice stDevice) {
        IUupShareCallback iUupShareCallback = this.mCallback;
        if (iUupShareCallback != null) {
            iUupShareCallback.onBleMasterConnected(stDevice);
        }
    }

    public void onBleSlaveConnected(UupShareInfo uupShareInfo, String str) {
        IUupShareCallback iUupShareCallback = this.mCallback;
        if (iUupShareCallback != null) {
            iUupShareCallback.onBleSlaveConnected(uupShareInfo, str);
        }
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
        StLog.d(TAG, "requestId: " + i + " responseNeeded: " + z2);
        if (z2) {
            this.mGattServer.sendResponse(bluetoothDevice, i, 0, 0, bArr);
        }
        if (UUP_SHARE_WRITE_UUID.getUuid().equals(bluetoothGattCharacteristic.getUuid()) && (parseSlaveKey = parseSlaveKey(bArr)) != null) {
            StLog.d(TAG, "onCharacteristicWriteRequest sendResponse");
            onBleSlaveConnected(parseSlaveKey, bluetoothDevice.getAddress());
        }
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

    public void setCallback(IUupShareCallback iUupShareCallback) {
        this.mCallback = iUupShareCallback;
    }
}
