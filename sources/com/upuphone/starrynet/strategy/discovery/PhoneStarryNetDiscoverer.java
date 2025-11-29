package com.upuphone.starrynet.strategy.discovery;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.simpleble.MyvuRingBleClientChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.AbsStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.DiscoveryActionObserver;
import com.upuphone.starrynet.strategy.discovery.advertiser.PhoneAdvertiserManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvertisePackUtil;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;
import com.upuphone.starrynet.strategy.discovery.fastpair.IFastPairCallback;

public class PhoneStarryNetDiscoverer extends AbsStarryNetDiscoverer implements IFastPairCallback {
    private static final String TAG = "PhoneStarryNetDiscoverer";
    DiscoveryActionObserver.DiscoveryStateChangeCallback discoveryStateChangeCallback = new DiscoveryActionObserver.DiscoveryStateChangeCallback() {
        public void onRecoverBLEScanFreq() {
            PhoneStarryNetDiscoverer.this.mStateMachine.setLimitScanFreqFlag(false);
            PhoneStarryNetDiscoverer.this.mStateMachine.sendMessage(7);
        }

        public void onReduceBLEScanFreq() {
            PhoneStarryNetDiscoverer.this.mStateMachine.setLimitScanFreqFlag(true);
            PhoneStarryNetDiscoverer.this.mStateMachine.sendMessage(8);
        }
    };
    private final FastPairManager mFastPairManager = new FastPairManager(StarryNetData.getInstance().getApplicationContext(), this);
    private UsbStarryNetDiscoverer mUsbStarryNetDiscoverer;

    public PhoneStarryNetDiscoverer() {
        this.mDiscoverHandler = new AbsStarryNetDiscoverer.DiscoverHanddler(Looper.getMainLooper());
        DiscoveryActionObserver.getInstance().init(StarryNetData.getInstance().getApplicationContext());
        DiscoveryActionObserver.getInstance().regDiscoveryActionCallback(this.discoveryStateChangeCallback);
    }

    public void callbackForTimeOut() {
        for (DiscoveryClient next : this.mListDiscovery) {
            if ((next.getFilter().getDeviceType() & 1) > 0) {
                next.getCallback().onDiscoveryError(StErrorCode.DISCOVERY_STRATEGY_REQUEST_CONNECT_TIMEOUT);
            }
        }
    }

    public int disableFastConnect() {
        stopStarryAdv();
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public void initAdvertiseManager() {
        if (this.mAdvertiseManager == null) {
            this.mAdvertiseManager = new PhoneAdvertiserManager();
        }
    }

    public void onBleConnected(String str, boolean z) {
        StLog.i(TAG, "onBleConnected, mac = " + str + ", isChannel = " + z);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                if (this.mDiscoverHandler.hasMessages(1)) {
                    this.mDiscoverHandler.removeMessages(1);
                }
                StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
                if (connectDeviceByBleMac != null && connectDeviceByBleMac.getTerminalType() == 2) {
                    this.mStateMachine.sendMessage(10);
                    return;
                }
                return;
            }
            this.mStateMachine.sendMessage(9);
        }
    }

    public void onBleDisconnected(String str) {
        this.mStateMachine.sendMessage(9);
    }

    public void onBluetoothNameChange(String str) {
        StLog.i(TAG, "onBluetoothNameChange");
        if (isStarryAdvertising()) {
            disableFastConnect();
        }
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2) {
        StLog.d(TAG, "onBondStateChanged: status = " + i + " old = " + i2);
        if (i == 1) {
            StarryDeviceManager.getInstance().addDelayLoseDevice(stConnectDevice.getIdentifier2String());
        } else if (i == 0 || i == 4) {
            StarryDeviceManager.getInstance().removeDelayLoseDevice(stConnectDevice.getIdentifier2String());
        }
    }

    public void onConnectFail(StDevice stDevice, int i, int i2) {
        StLog.d(TAG, "onConnectFail: code = " + i + " profile = " + i2);
        if (i2 != 1) {
            return;
        }
        if (i == 112002 || i == 112010) {
            this.mStateMachine.sendMessage(9);
        }
    }

    public void onDeviceConnectRequest(StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "onDeviceConnectRequest: " + stDevice);
        for (DiscoveryClient next : this.mListDiscovery) {
            if (next.getFilter().matches(stDevice)) {
                next.getCallback().onDeviceConnectRequest(stDevice.clone(), bArr);
            }
        }
    }

    public void onDiscovered(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getDeviceType() == 3) {
            StLog.v(TAG, "onDiscovered：" + stDiscoveryDevice + " getDiscoveryType：" + stDiscoveryDevice.getDiscoveryType());
            if (stDiscoveryDevice.getRssi() < stDiscoveryDevice.getIccoaMinAllowedRssi()) {
                StLog.d(TAG, "iccoa device weak rssi, ignore device:" + stDiscoveryDevice.getCarName());
                return;
            }
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDiscoveryDevice.getIdentifier());
            if (connectDevice != null && connectDevice.isProtocolConnected(8)) {
                StLog.d(TAG, "onDiscovered P2P is connected");
                return;
            }
        }
        checkAndResponseDeviceFoundAdv(stDiscoveryDevice);
        if (stDiscoveryDevice.getTerminalType() == 5) {
            MyvuRingBleClientChannel.notifyDiscoveryRing(stDiscoveryDevice);
        } else if (Byte.toUnsignedInt(stDiscoveryDevice.getAdvType()) == 64) {
            return;
        }
        for (DiscoveryClient next : this.mListDiscovery) {
            if (next.getFilter().matches(stDiscoveryDevice)) {
                byte[] userData = stDiscoveryDevice.getUserData();
                byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) 4);
                byte b = bArr != null ? bArr[0] : -1;
                Bundle bundle = new Bundle();
                bundle.putByteArray(StConstant.DEVICE_FOUND_BUNDLE_USER_DATA, userData);
                bundle.putByte(StConstant.DEVICE_FOUND_BUNDLE_CONNECT_STATUS, b);
                next.getCallback().onDeviceFound(stDiscoveryDevice.clone(), userData, bundle, next.getFilter());
            }
        }
    }

    public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i) {
        StLog.d(TAG, "onFastJudgment: " + stDiscoveryDevice);
        for (DiscoveryClient next : this.mListDiscovery) {
            if (next.getFilter().matches(stDiscoveryDevice)) {
                next.getCallback().onFastFound(stDiscoveryDevice.clone(), i, stDiscoveryDevice.getBeaconId());
            }
        }
    }

    public int requestConnect(byte[] bArr, long j) {
        if (bArr == null || bArr.length > 7) {
            return StErrorCode.DISCOVERY_STRATEGY_INVALID_PARAM;
        }
        byte[] deviceId = AdvertisePackUtil.getDeviceId(bArr);
        StDevice device = StarryDeviceManager.getInstance().getDevice(deviceId);
        if (device == null) {
            return StErrorCode.DISCOVERY_STRATEGY_UNKNOWN_DEVICE;
        }
        if (device.isBleConnected()) {
            StLog.i(TAG, "already connected cur device!");
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
        FastPairRecord.getInstance().setNotifyLabel(true);
        StLog.i(TAG, "requestConnect:" + Utils.bytes2HexString(bArr));
        stopStarryAdv();
        enableFastConnect();
        startNotifyAdv(AdvertisePackUtil.getNotifyData(1, deviceId));
        if (this.mDiscoverHandler.hasMessages(1)) {
            this.mDiscoverHandler.removeMessages(1);
        }
        this.mDiscoverHandler.sendEmptyMessageDelayed(1, j);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        this.mFastPairManager.setDeviceConnectable(z, i, str);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int setFastConnectProcess(int i) {
        this.mFastPairManager.setFastConnectProcess(i);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        StLog.i(TAG, "startDiscovery filter = " + discoveryFilter.getDeviceType() + " callback : " + System.identityHashCode(iStarryDiscoveryCallback));
        if ((discoveryFilter.getDeviceType() == 1 || discoveryFilter.getDeviceType() == 2) && !SysActionManager.getInstance().isBtOn()) {
            StLog.i(TAG, "Bluetooth off return");
            return StErrorCode.DISCOVERY_STRATEGY_BLUETOOTH_OFF;
        }
        if (discoveryFilter.getDeviceType() == 2) {
            if (SysActionManager.getInstance().isUupShareOn()) {
                startUupShareAdv();
            } else {
                StLog.d(TAG, "Uup Share off return");
                return StErrorCode.DISCOVERY_STRATEGY_UUP_SHARE_OFF;
            }
        }
        DiscoveryClient discoveryClient = new DiscoveryClient(discoveryFilter, iStarryDiscoveryCallback);
        if (this.mListDiscovery.contains(discoveryClient)) {
            StLog.d(TAG, "startDiscovery callback exist");
            return StErrorCode.DISCOVERY_STRATEGY_CALLBACK_EXIST;
        }
        this.mListDiscovery.add(discoveryClient);
        iStarryDiscoveryCallback.onDiscoveryRegistered(discoveryClient.getDiscoveryID());
        StLog.d(TAG, "onDiscoveryRegistered : " + discoveryClient.getDiscoveryID());
        if (discoveryFilter.getDeviceType() != 3) {
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
        StLog.d(TAG, "usb Start Discovery");
        this.mUsbStarryNetDiscoverer.startDiscovery();
        this.mStateMachine.sendMessage(7);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public void startUp(short s) {
        super.startUp(s);
        this.mStateMachine.sendMessage(7);
        this.mUsbStarryNetDiscoverer = new UsbStarryNetDiscoverer();
    }

    public void stopBleScan() {
        this.mStateMachine.sendMessage(10);
    }
}
