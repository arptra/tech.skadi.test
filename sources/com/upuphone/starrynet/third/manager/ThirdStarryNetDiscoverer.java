package com.upuphone.starrynet.third.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.here.odnp.config.OdnpConfigStatic;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.simpleble.MyvuRingBleClientChannel;
import com.upuphone.starrynet.strategy.data.IDiscoveryConnectCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.fastpair.IFastPairCallback;
import com.upuphone.starrynet.strategy.discovery.scanner.IDiscoveryListener;
import com.upuphone.starrynet.strategy.discovery.scanner.ScanManager;
import com.upuphone.starrynet.third.fastpair.ThirdFastPairManager;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.BooleanUtils;

public class ThirdStarryNetDiscoverer extends SysActionManager.StateChangeSimpleCallback implements IStarryNetDiscoverer, IDiscoveryListener, IFastPairCallback, IDiscoveryConnectCallback {
    private static final int MSG_BT_OFF = 11;
    private static final int MSG_CONNECTED = 3;
    private static final int MSG_DISCONNECTED = 4;
    private static final int MSG_SCAN_INTERVAL_MONITOR_CLEAR = 10;
    private static final int MSG_SCREEN_OFF = 2;
    private static final int MSG_SCREEN_OFF_DELAY = 9;
    private static final int MSG_SCREEN_OFF_SCAN_TIMEOUT = 7;
    private static final int MSG_SCREEN_ON = 1;
    private static final int MSG_SCREEN_ON_DELAY = 8;
    private static final int MSG_START_SCAN = 5;
    private static final int MSG_STOP_SCAN = 6;
    private static final int SCAN_MODE_HIGH_FREQUENCY = 1;
    private static final int SCAN_MODE_LOW_POWER = 2;
    private static final int SCAN_MODE_NONE = 0;
    private static final String TAG = "3rdDiscoverer";
    private static final int TIME_INTERVAL_SCAN_RESTART = 10000;
    private static final int TIME_INTERVAL_SCREEN_OFF_SCAN = 1800000;
    private IStarryDiscoveryCallback iDiscoveryCallback;
    /* access modifiers changed from: private */
    public int mCountScanDelayTime = 0;
    /* access modifiers changed from: private */
    public DiscoverHandler mDiscoverHandler = new DiscoverHandler(Looper.getMainLooper());
    private UUID mDiscoveryID;
    private final ThirdFastPairManager mFastPairManager;
    /* access modifiers changed from: private */
    public boolean mIsCurrentScreenOn;
    /* access modifiers changed from: private */
    public boolean mIsScanning = false;
    /* access modifiers changed from: private */
    public boolean mNeedAutoRestartScan = false;
    private final ScanManager mScanManager = new ScanManager(StarryNetData.getInstance().getApplicationContext());
    private int mScanMode = 0;

    public class DiscoverHandler extends Handler {
        public DiscoverHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            StLog.d(ThirdStarryNetDiscoverer.TAG, "handleMessage : " + message.what);
            switch (message.what) {
                case 1:
                    ThirdStarryNetDiscoverer.this.switchScanMode(true);
                    return;
                case 2:
                    ThirdStarryNetDiscoverer.this.switchScanMode(false);
                    return;
                case 3:
                    if (!ThirdStarryNetDiscoverer.this.needReconnectRing()) {
                        ThirdStarryNetDiscoverer.this.triggerScanStop();
                        boolean unused = ThirdStarryNetDiscoverer.this.mNeedAutoRestartScan = false;
                        ThirdStarryNetDiscoverer.this.mDiscoverHandler.removeMessages(8);
                        ThirdStarryNetDiscoverer.this.mDiscoverHandler.removeMessages(9);
                        return;
                    }
                    return;
                case 4:
                    if (!ThirdStarryNetDiscoverer.this.needReconnectXR()) {
                        return;
                    }
                    if (ThirdStarryNetDiscoverer.this.mIsCurrentScreenOn) {
                        ThirdStarryNetDiscoverer.this.triggerScanStart(true);
                        return;
                    } else {
                        ThirdStarryNetDiscoverer.this.triggerScanStart(false);
                        return;
                    }
                case 5:
                    if (!ThirdStarryNetDiscoverer.this.mIsScanning) {
                        ThirdStarryNetDiscoverer.this.startScan();
                        return;
                    } else {
                        StLog.w(ThirdStarryNetDiscoverer.TAG, "scan running, no need to restart");
                        return;
                    }
                case 6:
                    ThirdStarryNetDiscoverer.this.stopScan();
                    boolean unused2 = ThirdStarryNetDiscoverer.this.mNeedAutoRestartScan = false;
                    return;
                case 7:
                    StLog.i(ThirdStarryNetDiscoverer.TAG, "screen off timeout, need stop scan!");
                    ThirdStarryNetDiscoverer.this.stopScan();
                    return;
                case 8:
                    ThirdStarryNetDiscoverer.this.triggerScanStop();
                    ThirdStarryNetDiscoverer.this.triggerScanStart(true);
                    return;
                case 9:
                    if (ThirdStarryNetDiscoverer.this.mIsScanning) {
                        boolean unused3 = ThirdStarryNetDiscoverer.this.mNeedAutoRestartScan = true;
                    }
                    ThirdStarryNetDiscoverer.this.triggerScanStop();
                    if (ThirdStarryNetDiscoverer.this.needReconnectRing() || ThirdStarryNetDiscoverer.this.needReconnectXR()) {
                        StLog.d(ThirdStarryNetDiscoverer.TAG, "start low power background scan");
                        ThirdStarryNetDiscoverer.this.triggerScanStart(false);
                        return;
                    }
                    return;
                case 10:
                    int unused4 = ThirdStarryNetDiscoverer.this.mCountScanDelayTime = 0;
                    return;
                case 11:
                    boolean unused5 = ThirdStarryNetDiscoverer.this.mIsScanning = false;
                    return;
                default:
                    return;
            }
        }
    }

    public ThirdStarryNetDiscoverer() {
        ThirdFastPairManager thirdFastPairManager = new ThirdFastPairManager(StarryNetData.getInstance().getApplicationContext(), this);
        this.mFastPairManager = thirdFastPairManager;
        thirdFastPairManager.setFastConnectProcess(1);
        StarryDeviceManager.getInstance().addDiscoveryListener(this);
        SysActionManager.getInstance().registerSysAction(this);
        StarryDeviceManager.getInstance().setDiscoveryConnectCallback(this);
        this.mIsCurrentScreenOn = SysActionManager.getInstance().isScreenOn();
    }

    private StConnectDevice getBondedDeviceByType(int i) {
        List<StConnectDevice> bondedInfo = StarryDeviceManager.getInstance().getBondedInfo();
        if (bondedInfo == null || bondedInfo.size() == 0) {
            return null;
        }
        for (StConnectDevice next : bondedInfo) {
            if (next.getTerminalType() == i) {
                return next;
            }
        }
        return null;
    }

    private StConnectDevice getRingBondedDevice() {
        return getBondedDeviceByType(5);
    }

    private StConnectDevice getXRBondedDevice() {
        return getBondedDeviceByType(2);
    }

    /* access modifiers changed from: private */
    public boolean needReconnectRing() {
        StConnectDevice ringBondedDevice = getRingBondedDevice();
        if (ringBondedDevice != null) {
            return !ringBondedDevice.isBleConnected();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean needReconnectXR() {
        StConnectDevice xRBondedDevice = getXRBondedDevice();
        if (xRBondedDevice != null) {
            return !xRBondedDevice.isBleConnected();
        }
        return false;
    }

    private void sendClearScanDelayCountMessage() {
        if (!this.mDiscoverHandler.hasMessages(10)) {
            StLog.d(TAG, "start scan interval monitor");
            this.mDiscoverHandler.sendEmptyMessageDelayed(10, 10000);
        }
    }

    private void sendDelayedStopMessage() {
        if (this.mDiscoverHandler.hasMessages(7)) {
            this.mDiscoverHandler.removeMessages(7);
        }
        this.mDiscoverHandler.sendEmptyMessageDelayed(7, OdnpConfigStatic.OEM_MAX_MEDIUM_POWER_INTERVAL);
    }

    /* access modifiers changed from: private */
    public void startScan() {
        if (this.mIsCurrentScreenOn) {
            triggerScanStart(true);
        } else {
            triggerScanStart(false);
        }
    }

    /* access modifiers changed from: private */
    public void stopScan() {
        triggerScanStop();
    }

    /* access modifiers changed from: private */
    public void switchScanMode(boolean z) {
        if (this.mIsScanning || this.mNeedAutoRestartScan) {
            String str = BooleanUtils.OFF;
            StLog.d(TAG, "Screen %s (current: %s)", z ? BooleanUtils.ON : str, Boolean.valueOf(this.mIsCurrentScreenOn));
            int i = 9;
            int i2 = 8;
            if (z) {
                this.mIsCurrentScreenOn = true;
                i2 = 9;
                i = 8;
            } else {
                this.mIsCurrentScreenOn = false;
            }
            if (this.mDiscoverHandler.hasMessages(i)) {
                StLog.d(TAG, "duplicated screen on in %dms, ignore(should not happen)", 10000);
            } else if (this.mDiscoverHandler.hasMessages(i2)) {
                StLog.d(TAG, "no need to switch mode, keep current scan mode");
                this.mDiscoverHandler.removeMessages(i2);
            } else {
                if (z) {
                    str = BooleanUtils.ON;
                }
                StLog.d(TAG, "screen trigger switch scan mode(screen: %s) after %dms", str, Integer.valueOf(this.mCountScanDelayTime));
                this.mDiscoverHandler.sendEmptyMessageDelayed(i, (long) this.mCountScanDelayTime);
            }
        } else {
            StLog.d(TAG, "no need to switch scan mode");
        }
    }

    private void trackStartScanResult(int i) {
        StConnectDevice xRBondedDevice = getXRBondedDevice();
        if (xRBondedDevice != null && xRBondedDevice.getDevice() != null) {
            TrackerManager.getInstance().getDeviceSwitchStateTracker().bleStartScanResult(xRBondedDevice.getDevice().getTerminalType(), xRBondedDevice.getDevice().getIdentifier2String(), i).peerModelID(xRBondedDevice.getDevice().getModelID()).startReport();
        }
    }

    /* access modifiers changed from: private */
    public void triggerScanStart(boolean z) {
        if (this.mScanManager == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "Cannot triggerScanStart: bt status wrong");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("triggerScanStart: ");
        sb.append(z ? 1 : 2);
        StLog.d(TAG, sb.toString());
        this.mCountScanDelayTime = 10000;
        this.mIsScanning = true;
        sendClearScanDelayCountMessage();
        trackStartScanResult(z ? 1 : 2);
        if (z) {
            this.mScanManager.startHighFreqScan(false);
            this.mScanMode = 1;
            return;
        }
        this.mScanManager.startLowPowerBackgroundScan();
        this.mScanMode = 2;
        sendDelayedStopMessage();
    }

    /* access modifiers changed from: private */
    public void triggerScanStop() {
        if (this.mScanManager != null) {
            StLog.d(TAG, "triggerScanStop: " + this.mScanMode);
            this.mIsScanning = false;
            int i = this.mScanMode;
            if (i == 1) {
                this.mScanManager.stopHighFreqScan();
            } else if (i == 2) {
                this.mDiscoverHandler.removeMessages(7);
                this.mScanManager.stopLowPowerBackgroundScan();
            } else {
                StLog.w(TAG, "should not happen");
            }
            this.mScanMode = 0;
            this.mDiscoverHandler.removeMessages(10);
        }
    }

    public int disableFastConnect() {
        return 0;
    }

    public int enableFastConnect() {
        return 0;
    }

    public int enableFastConnectWithTimeOut(long j) {
        return 0;
    }

    public boolean getReconnectEnable() {
        return true;
    }

    public boolean isAdvEnable() {
        return true;
    }

    public boolean isCarActiveDisconnect(String str) {
        return false;
    }

    public boolean isCarActiveDisconnectPad() {
        return false;
    }

    public void onBatchDiscovered(List<StDevice> list) {
    }

    public void onBleConnected(String str, boolean z) {
        StLog.i(TAG, "onBleConnected, mac = " + str + ", isChannel = " + z);
        if (!TextUtils.isEmpty(str)) {
            if (this.iDiscoveryCallback == null) {
                StLog.e(TAG, "iDiscoveryCallback is null");
            } else if (z) {
                this.mDiscoverHandler.sendEmptyMessage(3);
            }
        }
    }

    public void onBleDisconnected(String str) {
        StLog.i(TAG, "onBleDisconnected, mac = " + str);
        if (this.iDiscoveryCallback == null) {
            StLog.e(TAG, "iDiscoveryCallback is null");
        } else {
            this.mDiscoverHandler.sendEmptyMessage(4);
        }
    }

    public void onBluetoothDisabled() {
        for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
            if (next.getDevice().isBrEdrConnected()) {
                StarryDeviceManager.getInstance().deviceDisconnected(next, 64);
            }
        }
        this.mDiscoverHandler.removeMessages(7);
        this.mDiscoverHandler.sendEmptyMessage(11);
    }

    public void onBluetoothEnabled() {
        StringBuilder sb = new StringBuilder();
        sb.append("onBluetoothEnabled :");
        sb.append(this.iDiscoveryCallback == null);
        StLog.d(TAG, sb.toString());
        this.mScanManager.onBluetoothEnabled();
        if (this.iDiscoveryCallback == null) {
            StLog.e(TAG, "iDiscoveryCallback is null");
        } else {
            this.mDiscoverHandler.sendEmptyMessage(5);
        }
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2) {
    }

    public void onConnectFail(StDevice stDevice, int i, int i2) {
    }

    public void onDeviceConnectRequest(StDevice stDevice, byte[] bArr) {
    }

    public void onDiscovered(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getDeviceType() != 2) {
            if (this.iDiscoveryCallback == null) {
                StLog.e(TAG, "iDiscoveryCallback is null");
                return;
            }
            if (stDiscoveryDevice.getTerminalType() == 5) {
                MyvuRingBleClientChannel.notifyDiscoveryRing(stDiscoveryDevice);
            }
            this.iDiscoveryCallback.onDeviceFound(stDiscoveryDevice.clone(), (byte[]) null, (Bundle) null, (DiscoveryFilter) null);
        }
    }

    public void onDiscoveredFail(int i) {
    }

    public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i) {
        StLog.d(TAG, "onFastJudgment: " + stDiscoveryDevice + ", type = " + i);
        IStarryDiscoveryCallback iStarryDiscoveryCallback = this.iDiscoveryCallback;
        if (iStarryDiscoveryCallback == null) {
            StLog.e(TAG, "iDiscoveryCallback is null");
        } else {
            iStarryDiscoveryCallback.onFastFound(stDiscoveryDevice.clone(), i, stDiscoveryDevice.getBeaconId());
        }
    }

    public void onLost(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getDeviceType() != 2) {
            IStarryDiscoveryCallback iStarryDiscoveryCallback = this.iDiscoveryCallback;
            if (iStarryDiscoveryCallback == null) {
                StLog.e(TAG, "iDiscoveryCallback is null");
            } else {
                iStarryDiscoveryCallback.onDeviceLose(stDiscoveryDevice.clone());
            }
        }
    }

    public void onP2pGoConnected(StConnectDevice stConnectDevice) {
    }

    public void onP2pGoDisconnected(StConnectDevice stConnectDevice) {
    }

    public void onScreenOff() {
        if (this.iDiscoveryCallback == null) {
            StLog.e(TAG, "iDiscoveryCallback is null");
        } else {
            this.mDiscoverHandler.sendEmptyMessage(2);
        }
    }

    public void onScreenOn() {
        if (this.iDiscoveryCallback == null) {
            StLog.e(TAG, "iDiscoveryCallback is null");
        } else {
            this.mDiscoverHandler.sendEmptyMessage(1);
        }
    }

    public int requestConnect(byte[] bArr, long j) {
        return 0;
    }

    public int reset() {
        return 0;
    }

    public int setAdvertiseEnableMode(int i) {
        return 0;
    }

    public void setCarActiveDisconnect(String str) {
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        this.mFastPairManager.setDeviceConnectable(z, i, str);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int setFastConnectProcess(int i) {
        if (i == 0) {
            return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
        }
        this.mFastPairManager.setFastConnectProcess(i);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int setReconnectEnable(boolean z) {
        return 0;
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        StLog.d(TAG, "startDiscovery callback : " + System.identityHashCode(iStarryDiscoveryCallback));
        boolean isBtOn = SysActionManager.getInstance().isBtOn();
        if (discoveryFilter.getDeviceType() != 2 || SysActionManager.getInstance().isUupShareOn()) {
            UUID randomUUID = UUID.randomUUID();
            this.mDiscoveryID = randomUUID;
            this.iDiscoveryCallback = iStarryDiscoveryCallback;
            iStarryDiscoveryCallback.onDiscoveryRegistered(randomUUID.toString());
            StLog.d(TAG, "onDiscoveryRegistered : " + this.mDiscoveryID);
            if (!isBtOn) {
                StLog.d(TAG, "Bluetooth off return");
                return StErrorCode.DISCOVERY_STRATEGY_BLUETOOTH_OFF;
            }
            this.mDiscoverHandler.sendEmptyMessage(5);
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
        StLog.d(TAG, "Uup Share off return");
        return StErrorCode.DISCOVERY_STRATEGY_UUP_SHARE_OFF;
    }

    public int startMultiDeviceFound() {
        return 0;
    }

    public void startUp(short s) {
    }

    public void stopBleScan() {
    }

    public int stopDiscovery(String str) {
        StLog.d(TAG, "stopDiscovery discoveryID: " + str);
        this.iDiscoveryCallback = null;
        if (!str.equals(this.mDiscoveryID.toString())) {
            return StErrorCode.DISCOVERY_STRATEGY_NOT_TARGET;
        }
        this.mDiscoverHandler.sendEmptyMessage(6);
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int stopMultiDeviceFound(boolean z) {
        return 0;
    }

    public void stopNotifyAdv() {
        StLog.d(TAG, "not support");
    }

    public int upDataAdvParams(byte[] bArr) {
        return 0;
    }
}
