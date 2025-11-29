package com.upuphone.starrynet.third.fastpair;

import android.content.Context;
import android.os.Message;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.FastPairStar;

public final class ThirdFastPairStar extends FastPairStar implements EventReceiver {
    private static final String TAG = "FastPairStar";

    public ThirdFastPairStar(Context context) {
        super(context);
    }

    public void dealBondFailMessage(Message message) {
        resetDeviceConnectState();
        this.mFastPairConnectDevice = null;
        this.mHandler.removeMessages(8);
        setPairing(false);
    }

    public void dealBondOkMessage(Message message) {
        this.mFastPairConnectDevice = null;
        this.mHandler.removeMessages(8);
        setPairing(false);
    }

    public void dealClickConnectMessage(Message message) {
        StDevice stDevice = (StDevice) message.obj;
        if (stDevice == null) {
            StLog.i(TAG, "dealClickConnectMessage device is null");
        } else if (!StarryDeviceManager.getInstance().getConnectedDevicesBySpecialDevice(stDevice.getCategoryID()).isEmpty()) {
            StLog.e(TAG, "exit same category is connected" + stDevice.getDeviceName());
        } else {
            connectStDevice(stDevice);
        }
    }

    public void dealConnectTimeoutMessage(Message message) {
        resetDeviceConnectState();
        this.mFastPairConnectDevice = null;
        setPairing(false);
    }

    public void onBleConnected(StDevice stDevice) {
        if (stDevice.isBrEdrConnected() && stDevice.isBleConnected()) {
            onBluetoothConnected(stDevice);
        }
    }

    public void onBrEdrConnected(StDevice stDevice) {
        if (stDevice.isBrEdrConnected() && stDevice.isBleConnected()) {
            onBluetoothConnected(stDevice);
        }
    }
}
