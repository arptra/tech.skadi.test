package com.upuphone.starrynet.strategy.discovery;

import android.os.Looper;
import android.text.TextUtils;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.StConfiguration;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.ReLog;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.AbsStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.advertiser.PadAdvertiserManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;
import com.upuphone.starrynet.strategy.discovery.fastpair.IFastPairCallback;

public class PadStarryNetDiscoverer extends AbsStarryNetDiscoverer implements IFastPairCallback {
    private static final String TAG = "PadStarryNetDiscoverer";
    private final FastPairManager mFastPairManager = new FastPairManager(StarryNetData.getInstance().getApplicationContext(), this);

    public PadStarryNetDiscoverer() {
        this.mDiscoverHandler = new AbsStarryNetDiscoverer.DiscoverHanddler(Looper.getMainLooper());
        DiscoveryActionObserver.getInstance().init(StarryNetData.getInstance().getApplicationContext());
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
            this.mAdvertiseManager = new PadAdvertiserManager();
        }
    }

    public void onBleConnected(String str, boolean z) {
        StLog.i(TAG, "onBleConnected, mac = " + str + ", isChannel = " + z);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
                if (connectDeviceByBleMac != null) {
                    FastPairRecord.getInstance().removeActiveDisconnectPad(connectDeviceByBleMac.getIdentifier2String());
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

    public void onDeviceConnectRequest(StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "onDeviceConnectRequest: " + stDevice);
        for (DiscoveryClient next : this.mListDiscovery) {
            if (next.getFilter().matches(stDevice)) {
                next.getCallback().onDeviceConnectRequest(stDevice.clone(), bArr);
            }
        }
    }

    public void onDiscovered(StDiscoveryDevice stDiscoveryDevice) {
        if (!StConfiguration.getCarWithPadList().contains(stDiscoveryDevice.getModelID())) {
            ReLog.v(TAG, "Peer car device not support pad, deviceModel = " + stDiscoveryDevice.getModelID());
            return;
        }
        super.onDiscovered(stDiscoveryDevice);
    }

    public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i) {
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        StLog.i(TAG, "startDiscovery filter = " + discoveryFilter.getDeviceType() + " callback : " + System.identityHashCode(iStarryDiscoveryCallback));
        if ((discoveryFilter.getDeviceType() == 1 || discoveryFilter.getDeviceType() == 2) && !SysActionManager.getInstance().isBtOn()) {
            StLog.i(TAG, "Bluetooth off return");
            return StErrorCode.DISCOVERY_STRATEGY_BLUETOOTH_OFF;
        }
        DiscoveryClient discoveryClient = new DiscoveryClient(discoveryFilter, iStarryDiscoveryCallback);
        if (this.mListDiscovery.contains(discoveryClient)) {
            StLog.d(TAG, "startDiscovery callback exist");
            return StErrorCode.DISCOVERY_STRATEGY_CALLBACK_EXIST;
        }
        this.mListDiscovery.add(discoveryClient);
        iStarryDiscoveryCallback.onDiscoveryRegistered(discoveryClient.getDiscoveryID());
        StLog.d(TAG, "onDiscoveryRegistered : " + discoveryClient.getDiscoveryID());
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public void startUp(short s) {
        super.startUp(s);
        this.mStateMachine.sendMessage(7);
    }
}
