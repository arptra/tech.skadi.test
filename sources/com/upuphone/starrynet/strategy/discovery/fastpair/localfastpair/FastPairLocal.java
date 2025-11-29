package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StTestConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.common.utils.tracker.detail.BluetoothConnectionTracker;
import com.upuphone.starrynet.strategy.StarryNetController;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairBaseController;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;

public abstract class FastPairLocal extends FastPairBaseController {
    protected static final String ACTION_PAIRING_CANCEL = "android.bluetooth.device.action.PAIRING_CANCEL";
    protected static final int CONNECT_TIMEOUT = 25000;
    protected static final String SETTING_KEY_FAST_PAIR = "setting_fast_pair";
    protected static final String SETTING_VALUE_NULL = "";
    protected static final int STATE_CONNECTING = 1;
    protected static final int STATE_CONNECT_FAILED = 3;
    protected static final int STATE_CONNECT_SUCCESS = 2;
    private static final String TAG = "FastPairLocal";
    protected volatile StDevice mFastPairConnectDevice;
    protected volatile StDevice mFastPairShowDevice;

    public FastPairLocal(Context context) {
        super(context);
    }

    private void trackConnection(StDevice stDevice) {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        boolean z = false;
        boolean z2 = connectDevice == null || connectDevice.getBleBondStatus() != 4;
        BluetoothConnectionTracker start = TrackerManager.getInstance().getBluetoothConnectionTracker().start(z2, stDevice.getTerminalType(), stDevice.getIdentifier2String());
        if (terminalType != 2) {
            z = true;
        }
        start.isPhone(z);
        if (!z2 && connectDevice.isBtConnected()) {
            TrackerManager.getInstance().getBluetoothConnectionTracker().btConnected(stDevice.getTerminalType(), stDevice.getIdentifier2String(), stDevice.getModelID());
        }
    }

    private void trackOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice) {
        TrackerManager.getInstance().getUnpairDeviceTracker().startUnpair(stDiscoveryDevice.getTerminalType(), stDiscoveryDevice.getIdentifier2String()).way(0).peerModelID(stDiscoveryDevice.getModelID()).result(stDiscoveryDevice.getTerminalType(), stDiscoveryDevice.getIdentifier2String(), 0).startReport();
    }

    public void connectStDevice(StDevice stDevice) {
        if (stDevice == null) {
            StLog.i(TAG, "connectStDevice is null");
        } else if (TextUtils.isEmpty(stDevice.getBleMac())) {
            StLog.i(TAG, "ble mac is null");
        } else {
            if (this.mHandler.hasMessages(8)) {
                this.mHandler.removeMessages(8);
            }
            this.mHandler.sendEmptyMessageDelayed(8, 25000);
            this.mFastPairConnectDevice = stDevice;
            IStarryNetConnector connectManager = StarryNetController.getConnectManager();
            if (connectManager != null) {
                StLog.d(TAG, StTestConstant.POINT_BLE_CONNECT_START);
                trackConnection(stDevice);
                connectManager.connectBle(stDevice);
            }
        }
    }

    public void dealAutoConnectTimeoutMessage(Message message) {
        this.mFastPairConnectDevice = null;
        updateForConnectTimeout((StDiscoveryDevice) message.obj);
    }

    public void dealClassicBondMessage(Message message) {
        StarryNetController.getConnectManager().createBondBrEdr(this.mFastPairConnectDevice);
    }

    public void dealClickCancelMessage(Message message) {
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
        FastPairBaseController.FastPairHandler fastPairHandler = this.mHandler;
        fastPairHandler.sendMessage(fastPairHandler.obtainMessage(2));
    }

    public void dealDispatchToAppMessage(Message message) {
    }

    public void dealRemoveBondMessage(Message message) {
        StConnectDevice connectDevice;
        StDiscoveryDevice stDiscoveryDevice = (StDiscoveryDevice) message.obj;
        if (stDiscoveryDevice != null && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDiscoveryDevice.getIdentifier())) != null && !StarryDeviceManager.getInstance().isBleLinked(connectDevice.getBleMac())) {
            trackOfflineRemoveBond(stDiscoveryDevice);
            StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void onBleConnected(StDevice stDevice) {
        if (stDevice != null) {
            StLog.d(TAG, "onBleConnected ");
            if (this.mFastPairConnectDevice != null && this.mHandler.hasMessages(9)) {
                StLog.d(TAG, "onBleconnected ,name =%s, remove auto connect timeout message", stDevice.getDeviceName());
                this.mHandler.removeMessages(9);
            }
        }
    }

    public void onBluetoothDisabled() {
        StLog.d(TAG, "onBluetoothDisabled");
        if (this.mFastPairConnectDevice != null) {
            FastPairBaseController.FastPairHandler fastPairHandler = this.mHandler;
            fastPairHandler.sendMessage(fastPairHandler.obtainMessage(6, this.mFastPairConnectDevice));
        }
    }

    public void onBrEdrConnected(StDevice stDevice) {
    }

    public void resetDeviceConnectState() {
        StConnectDevice connectDevice;
        StLog.d(TAG, "resetDeviceConnectState");
        if (this.mFastPairConnectDevice != null && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(this.mFastPairConnectDevice.getIdentifier())) != null) {
            if (connectDevice.isBleConnected()) {
                StarryNetController.getConnectManager().disconnectBle(connectDevice.getDevice(), false);
            }
            if (connectDevice.getBleBondStatus() == 4 && connectDevice.getBrEdrBondStatus() != 48) {
                StLog.d(TAG, "Peer device bredr not bond, Unbond ble");
                StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
                StarryDeviceManager.getInstance().connectFail(connectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BR_EDR_CONNECT_FAIL, 8);
            }
        }
    }

    public void updateForBondOk(byte[] bArr) {
        StLog.d(TAG, "updateForBondOk: " + Utils.getAddressStringFromByte(bArr));
        StConnectDevice connectDevice = this.mDeviceManager.getConnectDevice(bArr);
        if (bArr != null && connectDevice != null) {
            connectDevice.setStatus(4);
            connectDevice.setDate(System.currentTimeMillis());
            this.mDeviceManager.updateBondInfo(connectDevice, 4);
        }
    }

    public void updateForConnectTimeout(StDiscoveryDevice stDiscoveryDevice) {
        StConnectDevice connectDevice;
        StLog.e(TAG, "auto connect timeout");
        if (stDiscoveryDevice != null) {
            byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) 3);
            if (ByteUtils.equals(StarryNetData.getInstance().getIdentifier(), bArr) && (connectDevice = this.mDeviceManager.getConnectDevice(bArr)) != null && connectDevice.getBleBondStatus() == 4) {
                StLog.d(TAG, "remove pairRecord for device=%s", stDiscoveryDevice.getDeviceName());
                FastPairRecord.getInstance().removePairRecord(connectDevice.getIdentifier());
            }
        }
    }
}
