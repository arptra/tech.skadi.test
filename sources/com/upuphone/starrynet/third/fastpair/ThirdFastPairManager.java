package com.upuphone.starrynet.third.fastpair;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Message;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.strategy.StarryNetController;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairBaseController;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.IFastPairCallback;

public class ThirdFastPairManager extends FastPairManager {
    public static final String TAG = "ThirdFastPairManager";

    public ThirdFastPairManager(Context context, IFastPairCallback iFastPairCallback) {
        super(context, iFastPairCallback);
        this.mFastPairStar = new ThirdFastPairStar(context);
    }

    public int fastPairStatus(StDiscoveryDevice stDiscoveryDevice) {
        return 2;
    }

    public boolean isPairing(StDevice stDevice) {
        if (stDevice.getTerminalType() != 2) {
            return false;
        }
        return this.mFastPairStar.getPairing();
    }

    public void onBleConnectFail(StDevice stDevice, int i) {
        if (stDevice.getTerminalType() == 2) {
            FastPairBaseController.FastPairHandler fastPairHandler = this.mFastPairStar.mHandler;
            Message obtainMessage = fastPairHandler.obtainMessage(12, stDevice);
            obtainMessage.arg1 = i;
            fastPairHandler.sendMessage(obtainMessage);
        }
    }

    public void onBleConnected(StDevice stDevice) {
        if (stDevice.getTerminalType() == 2) {
            this.mFastPairStar.onBleConnected(stDevice);
        }
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2) {
        if (stConnectDevice == null) {
            StLog.i(TAG, "onBondStateChanged bondInfo is null");
            return;
        }
        StDevice device = stConnectDevice.getDevice();
        if (device == null) {
            StLog.i(TAG, "onBondStateChanged device is null");
            return;
        }
        if (i == 32) {
            TrackerManager.getInstance().getBluetoothConnectionTracker().startConnectBt(device.getTerminalType(), stConnectDevice.getIdentifier2String());
        }
        if (!isPairing(device)) {
            StLog.i(TAG, "onBondStateChanged device not in pairing");
        } else if (i == 0 && device.getTerminalType() == 2) {
            FastPairBaseController.FastPairHandler fastPairHandler = this.mFastPairStar.mHandler;
            fastPairHandler.sendMessage(fastPairHandler.obtainMessage(6, device));
        }
    }

    public void onBrConnectFail(StDevice stDevice, int i) {
        if (stDevice.getTerminalType() == 2) {
            BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stDevice);
            if (!(bluetoothDevice == null || bluetoothDevice.getBondState() == 12)) {
                StarryNetController.getConnectManager().removeBond(stDevice);
            }
            FastPairBaseController.FastPairHandler fastPairHandler = this.mFastPairStar.mHandler;
            Message obtainMessage = fastPairHandler.obtainMessage(12, stDevice);
            obtainMessage.arg1 = i;
            fastPairHandler.sendMessage(obtainMessage);
        }
    }

    public void onConnectFail(StDevice stDevice, int i, int i2) {
        if (i2 == 1) {
            onBleConnectFail(stDevice, i);
        } else if (i2 == 8) {
            onBrConnectFail(stDevice, i);
        }
    }

    public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i) {
        StLog.i(TAG, "onFastJudgment, device = " + stDiscoveryDevice + ", result = " + i + ", process type = " + this.mProcessType);
        if (i == 4 || i == 1 || i == 7 || i == 0) {
            starPair(stDiscoveryDevice, i, this.mProcessType);
        }
        if (this.mFastPairJudgment != null) {
            this.mFastPairCallback.onFastJudgment(stDiscoveryDevice, i);
        }
    }

    public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice) {
        return this.mFastPairJudgment.startFastPair(stDiscoveryDevice);
    }
}
