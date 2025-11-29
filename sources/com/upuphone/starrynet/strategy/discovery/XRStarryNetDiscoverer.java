package com.upuphone.starrynet.strategy.discovery;

import android.os.Looper;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.IDiscoveryInterceptor;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.AbsStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.advertiser.XRAdvertiserManager;
import java.util.Arrays;
import java.util.List;

public class XRStarryNetDiscoverer extends AbsStarryNetDiscoverer implements EventReceiver, IDiscoveryInterceptor {
    private static final String TAG = "XRStarryNetDiscovery";
    private long advTimeoutMills = 0;

    public XRStarryNetDiscoverer() {
        enableFastConnect();
        StarryDeviceManager.getInstance().addDiscoveryInterceptor(this);
        StLog.d(TAG, "Init");
    }

    public void callbackForTimeOut() {
        stopPassiveAdv();
        this.advTimeoutMills = 0;
    }

    public int disableFastConnect() {
        StLog.d(TAG, "disableFastConnect");
        stopStarryAdv();
        AbsStarryNetDiscoverer.DiscoverHanddler discoverHanddler = this.mDiscoverHandler;
        if (discoverHanddler == null || !discoverHanddler.hasMessages(2)) {
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
        this.mDiscoverHandler.removeMessages(2);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int enableFastConnect() {
        StLog.d(TAG, "enableFastConnect");
        super.enableFastConnect();
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        if (curBondInfo == null || curBondInfo.getBleBondStatus() != 4) {
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
        byte[] identifier = curBondInfo.getIdentifier();
        StLog.d(TAG, "startARFastConnectAdv peerMac =" + Utils.bytes2HexString(identifier));
        startReConnectAdv(identifier);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int enableFastConnectWithTimeOut(long j) {
        StLog.d(TAG, "enableFastConnectWithTimeOut, timeoutMils=" + j);
        if (!this.mListBleChannel.isEmpty()) {
            StLog.i(TAG, "device is connected, mListBleChannel size =" + this.mListBleChannel.size());
            return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
        }
        if (this.mDiscoverHandler == null) {
            this.mDiscoverHandler = new AbsStarryNetDiscoverer.DiscoverHanddler(Looper.getMainLooper());
        }
        if (!BluetoothUtils.isBluetoothEnabled()) {
            StLog.i(TAG, "adapter is disable");
            return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
        }
        if (isStarryAdvertising()) {
            if ((this.mStateMachine.getAdvState() & 2) > 0) {
                StLog.d(TAG, "passive adv already started, need reset");
                stopPassiveAdv();
                this.mDiscoverHandler.removeMessages(2);
            } else {
                StLog.i(TAG, "device is advertising");
                return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
            }
        }
        this.advTimeoutMills = j;
        return enableFastConnectXr();
    }

    public int enableFastConnectXr() {
        super.enableFastConnect();
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        if (curBondInfo != null && curBondInfo.getBleBondStatus() == 4) {
            return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
        }
        StLog.d(TAG, "startARFastConnectAdv peerMac default");
        startPassiveAdv(true);
        this.mDiscoverHandler.sendEmptyMessageDelayed(2, this.advTimeoutMills);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public void initAdvertiseManager() {
        if (this.mAdvertiseManager == null) {
            this.mAdvertiseManager = new XRAdvertiserManager();
        }
    }

    public void onBluetoothNameChange(String str) {
        StLog.d(TAG, "onBluetoothNameChange");
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2) {
        StLog.d(TAG, "onBondStateChanged: status = " + i + " old = " + i2);
        if (stConnectDevice != null && !stConnectDevice.isBleConnected() && i == 0) {
            stopReConnectAdv();
        }
    }

    public void onConnectFail(StDevice stDevice, int i, int i2) {
        StLog.d(TAG, "onConnectFail: code = " + i + " profile = " + i2);
        if (i2 == 8 && i == 112201 && stDevice.getTerminalType() == 6) {
            stopPassiveAdv();
        }
    }

    public boolean onDiscovery(StDiscoveryDevice stDiscoveryDevice) {
        int unsignedInt = Byte.toUnsignedInt(stDiscoveryDevice.getAdvType());
        if (stDiscoveryDevice.getTerminalType() != 5) {
            return false;
        }
        stDiscoveryDevice.setStatus(1);
        List<StConnectDevice> bondInfoByTerminal = StarryDeviceManager.getInstance().getBondInfoByTerminal(5);
        StConnectDevice stConnectDevice = (bondInfoByTerminal == null || bondInfoByTerminal.size() != 1) ? null : bondInfoByTerminal.get(0);
        if (unsignedInt == 64) {
            if (stConnectDevice == null) {
                StLog.d(TAG, "Do not have bonded ring, report: " + stDiscoveryDevice.getDeviceName() + "in wait-for-reconnect status");
                stDiscoveryDevice.setStatus(3);
                return false;
            } else if (Arrays.equals(stConnectDevice.getIdentifier(), stDiscoveryDevice.getIdentifier())) {
                StLog.d(TAG, "the ring is waiting for being reconnected. Do report: " + stDiscoveryDevice.getDeviceName());
                stDiscoveryDevice.setStatus(2);
                return false;
            } else {
                StLog.d(TAG, "the ring waiting for reconnect is not my bonded device, do not report: " + stDiscoveryDevice.getDeviceName());
                return true;
            }
        } else if (stConnectDevice == null || !Arrays.equals(stConnectDevice.getIdentifier(), stDiscoveryDevice.getIdentifier())) {
            StLog.d(TAG, "Do not have bonded ring , the ring is unbonded, do report: " + stDiscoveryDevice.getDeviceName());
            return false;
        } else {
            StLog.d(TAG, "bonded ring is: " + bondInfoByTerminal.size() + ", the ring is offline unbonded, do report");
            stDiscoveryDevice.setStatus(4);
            return false;
        }
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        if (discoveryFilter.getDeviceType() == 3) {
            StLog.v(TAG, "startDiscovery, xr not support scan iccoa!");
            return StErrorCode.DISCOVERY_STRATEGY_NOT_TARGET;
        }
        int startDiscovery = super.startDiscovery(discoveryFilter, discoverySettings, iStarryDiscoveryCallback);
        this.mStateMachine.sendMessage(7);
        return startDiscovery;
    }

    public int stopDiscovery(String str) {
        int stopDiscovery = super.stopDiscovery(str);
        if (stopDiscovery == 111000) {
            StLog.v(TAG, "stop ble scan");
            this.mStateMachine.sendMessage(10);
        }
        return stopDiscovery;
    }

    public int upDataAdvParams(byte[] bArr) {
        return StErrorCode.CONNECT_STRATEGY_BLE_OPERATE_NOT_SUPPORT;
    }
}
