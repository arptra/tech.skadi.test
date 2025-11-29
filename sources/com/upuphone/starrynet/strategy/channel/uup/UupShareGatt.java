package com.upuphone.starrynet.strategy.channel.uup;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@SuppressLint({"MissingPermission"})
class UupShareGatt {
    private static final int BLE_OPERATION_TIMEOUT = 20000;
    private static final int MSG_READ_DEVICE_INFO_TIMEOUT = 100;
    private static final int MSG_WRITE_P2P_INFO_TIMEOUT = 102;
    private static final String TAG = "UupShareGatt";
    private final IUupShareCallback mCallback;
    private StDevice mDevice;
    private final Gson mGson;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            UupShareGatt.this.dealWithMessage(message);
        }
    };

    public UupShareGatt(IUupShareCallback iUupShareCallback) {
        this.mCallback = iUupShareCallback;
        this.mGson = new Gson();
    }

    /* access modifiers changed from: private */
    public void dealWithMessage(Message message) {
        int i = message.what;
        if (i == 100) {
            onAuthResult(-18, "read device info timeout");
        } else if (i == 102) {
            onAuthResult(-23, "write p2p info timeout");
        }
    }

    private String getMasterKey(MasterKey masterKey) {
        GoInfo goInfo;
        byte[] secretKey;
        UupShareInfo uupShareInfo = null;
        if (masterKey == null || (goInfo = this.mCallback.getGoInfo()) == null) {
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

    private void handleDeviceInfo(byte[] bArr) {
        StLog.d(TAG, "handleDeviceInfo");
        MasterKey parseMasterKey = parseMasterKey(bArr);
        if (parseMasterKey == null) {
            onAuthResult(-21, "masterKeyV2 is null");
        } else if (parseMasterKey.getState() == 1) {
            onAuthResult(-20, "peer device is busy!!");
            BleConnectManager.getInstance().disconnect(this.mDevice.getBleMac());
        } else {
            String masterKey = getMasterKey(parseMasterKey);
            if (masterKey == null) {
                onAuthResult(-19, "p2p info  is null");
            } else {
                sendP2PInfo2PeerDevice(masterKey);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$0(int i, Bundle bundle) {
        StLog.d(TAG, "connectBle onResponse code = " + i + ", bundle = " + bundle);
        if (i != 0) {
            onConnectResult(i, "connect ble fail");
        } else {
            requestMtu();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$openNotify$2(int i, Void voidR) {
        BluetoothLog.log(TAG, "open notify(%s) code=%d", BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.toString(), Integer.valueOf(i));
        readDeviceInfo(this.mDevice);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$readDeviceInfo$3(int i, byte[] bArr) {
        stopTimer(100);
        if (i != 0) {
            onAuthResult(-17, "read uup share device info fail, code=" + i);
            return;
        }
        handleDeviceInfo(bArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMtu$1(int i, Integer num) {
        StLog.d(TAG, "requestMtu onResponse, code=%d,mtu=" + num, Integer.valueOf(i));
        if (i == 0) {
            BleClientCache.getInstance().updateMtu(this.mDevice.getBleMac(), num.intValue());
        } else {
            BleClientCache.getInstance().clearMtu(this.mDevice.getBleMac());
        }
        openNotify();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendP2PInfo2PeerDevice$4(int i, byte[] bArr) {
        stopTimer(102);
        if (i != 0) {
            onAuthResult(-22, "sendP2PInfo2PeerDevice fail: " + i);
            return;
        }
        onAuthResult(0, "uup share auth success");
    }

    private void onAuthResult(int i, String str) {
        StLog.d(TAG, "onAuthResult " + str + " code = " + i);
        if (i == 0) {
            this.mCallback.onBleMasterConnected(this.mDevice);
        }
    }

    private void onConnectResult(int i, String str) {
        StLog.d(TAG, "onConnectResult " + str + " code = " + i);
    }

    private void openNotify() {
        BleConnectManager.getInstance().notify(this.mDevice.getBleMac(), BluetoothConstants.STARRY_NET_SERVICE_UUID, BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID, new e(this));
    }

    private MasterKey parseMasterKey(byte[] bArr) {
        try {
            return (MasterKey) this.mGson.fromJson(new String(bArr), MasterKey.class);
        } catch (Exception e) {
            StLog.d(TAG, "parseMasterInfo error: " + e);
            return null;
        }
    }

    private void readDeviceInfo(StDevice stDevice) {
        startTimer(100);
        StLog.d(TAG, "readDeviceInfo, device name=" + stDevice.getDeviceName());
        BleConnectManager.getInstance().read(stDevice.getBleMac(), BleUtil.UUP_SHARE_CONNECT_SERVICE_UUID.getUuid(), BleUtil.UUP_SHARE_READ_UUID.getUuid(), new c(this));
    }

    private void requestMtu() {
        StLog.d(TAG, "start request mtu");
        BleConnectManager.getInstance().requestMtu(this.mDevice.getBleMac(), 512, new b(this));
    }

    private void sendP2PInfo2PeerDevice(String str) {
        StLog.d(TAG, "sendP2PInfo2PeerDevice");
        startTimer(102);
        BleConnectManager.getInstance().write(this.mDevice.getBleMac(), BleUtil.UUP_SHARE_CONNECT_SERVICE_UUID.getUuid(), BleUtil.UUP_SHARE_WRITE_UUID.getUuid(), str.getBytes(), new d(this));
    }

    private void startTimer(int i) {
        this.mHandler.removeMessages(i);
        this.mHandler.sendEmptyMessageDelayed(i, 20000);
    }

    private void stopTimer(int i) {
        this.mHandler.removeMessages(i);
    }

    public int connect(StDevice stDevice) {
        BluetoothAdapter defaultAdapter;
        String bleMac = stDevice.getBleMac();
        if (!BluetoothAdapter.checkBluetoothAddress(bleMac) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return 0;
        }
        if (defaultAdapter.getRemoteDevice(bleMac) == null) {
            StLog.d(TAG, "device null");
            return 0;
        }
        this.mDevice = stDevice;
        BleConnectManager.getInstance().connect(bleMac, (BleConnectResponse) new a(this));
        return 0;
    }

    public int disconnect() {
        StLog.d(TAG, "disconnect");
        if (this.mDevice == null) {
            return -1;
        }
        BleConnectManager.getInstance().disconnect(this.mDevice.getBleMac());
        return 0;
    }
}
