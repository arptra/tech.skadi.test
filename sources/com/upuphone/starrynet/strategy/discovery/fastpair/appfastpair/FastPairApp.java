package com.upuphone.starrynet.strategy.discovery.fastpair.appfastpair;

import android.content.Context;
import android.os.Message;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.TrackManagerUtils;
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
import com.upuphone.starrynet.strategy.discovery.fastpair.IFastPairCallback;
import com.upuphone.starrynet.strategy.utils.BleUtil;

public class FastPairApp extends FastPairBaseController {
    private static final int CONNECT_TIMEOUT = 25000;
    private static final String TAG = "FastPairApp";
    private volatile boolean isPairing = false;
    private volatile IFastPairCallback mFastPairCallback;

    public FastPairApp(Context context, IFastPairCallback iFastPairCallback) {
        super(context);
        this.mContext = context;
        this.mFastPairCallback = iFastPairCallback;
    }

    private void trackConnection(StDevice stDevice) {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        boolean z = false;
        BluetoothConnectionTracker start = TrackerManager.getInstance().getBluetoothConnectionTracker().start(connectDevice == null || connectDevice.getBleBondStatus() != 4, stDevice.getTerminalType(), stDevice.getIdentifier2String());
        if (terminalType == 1) {
            z = true;
        }
        start.isPhone(z);
    }

    private void updateForConnectTimeoutOrFail(StDiscoveryDevice stDiscoveryDevice) {
        StConnectDevice connectDevice;
        StLog.e(TAG, "auto connect timeout or fail");
        if (stDiscoveryDevice == null) {
            StLog.e(TAG, "updateForConnectTimeout device is null");
            return;
        }
        if (BleUtil.getBluetoothAddress().equals(Utils.getAddressStringFromByte(stDiscoveryDevice.getDeviceDetail().get((byte) 17))) && (connectDevice = this.mDeviceManager.getConnectDevice(stDiscoveryDevice.getIdentifier())) != null) {
            if (connectDevice.getBleBondStatus() == 4) {
                StLog.d(TAG, "remove pairRecord for device=%s", stDiscoveryDevice.getDeviceName());
                FastPairRecord.getInstance().removePairRecord(connectDevice.getIdentifier());
            }
            if (connectDevice.getBleBondStatus() == 15) {
                StLog.d(TAG, "correct clear status");
                connectDevice.setStatus(0);
                StarryDeviceManager.getInstance().updateBondInfo(connectDevice);
            }
        }
    }

    public void connectStDevice(StDevice stDevice) {
        IStarryNetConnector connectManager = stDevice.getTerminalType() != 1 ? StarryNetController.getConnectManager() : null;
        if (connectManager == null) {
            StLog.d(TAG, "connectManager is null");
            return;
        }
        TrackManagerUtils.trackBleConnectStart();
        connectManager.connectBle(stDevice);
        trackConnection(stDevice);
        if (this.mHandler.hasMessages(9)) {
            this.mHandler.removeMessages(9);
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(9, stDevice), 25000);
    }

    public void dealAutoConnectTimeoutMessage(Message message) {
        updateForConnectTimeoutOrFail(this.mDeviceManager.getDiscoveryDevice(((StDevice) message.obj).getIdentifier()));
        setPairing(false);
    }

    public void dealBondFailMessage(Message message) {
        setPairing(false);
        if (this.mHandler.hasMessages(9)) {
            this.mHandler.removeMessages(9);
            updateForConnectTimeoutOrFail(this.mDeviceManager.getDiscoveryDevice(((StDevice) message.obj).getIdentifier()));
        }
    }

    public void dealBondOkMessage(Message message) {
        setPairing(false);
        if (this.mHandler.hasMessages(9)) {
            this.mHandler.removeMessages(9);
        }
        StDevice stDevice = (StDevice) message.obj;
        if (stDevice == null) {
            StLog.d(TAG, "dealBondOkMessage device is null");
            return;
        }
        updateForBondOk(stDevice.getIdentifier());
        FastPairRecord.getInstance().removePairRecord(stDevice.getIdentifier());
    }

    public void dealClassicBondMessage(Message message) {
    }

    public void dealClickCancelMessage(Message message) {
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
        FastPairBaseController.FastPairHandler fastPairHandler = this.mHandler;
        fastPairHandler.sendMessage(fastPairHandler.obtainMessage(2));
    }

    public void dealClickConnectMessage(Message message) {
        connectStDevice((StDiscoveryDevice) message.obj);
    }

    public void dealConnectTimeoutMessage(Message message) {
    }

    public void dealDismissWindowMessage(Message message) {
    }

    public void dealDispatchToAppMessage(Message message) {
        StDiscoveryDevice stDiscoveryDevice = (StDiscoveryDevice) message.obj;
        if (this.mFastPairCallback != null) {
            this.mFastPairCallback.onDeviceConnectRequest(stDiscoveryDevice.clone(), ByteUtils.append(stDiscoveryDevice.getDeviceDetail().get((byte) -1), stDiscoveryDevice.getDeviceDetail().get((byte) 17)));
        }
    }

    public void dealRemoveBondMessage(Message message) {
    }

    public void dealShowWindowMessage(Message message) {
    }

    public boolean getPairing() {
        return this.isPairing;
    }

    public void setPairing(boolean z) {
        this.isPairing = z;
    }

    public void updateForBondOk(byte[] bArr) {
        StLog.d(TAG, "MESSAGE_BOND_OK: " + Utils.getAddressStringFromByte(bArr));
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (bArr != null && connectDevice != null) {
            this.mDiscoveryDeviceManager.updateBondInfo(connectDevice, 4);
        }
    }
}
