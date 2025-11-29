package com.upuphone.starrynet.strategy.operater;

import android.bluetooth.BluetoothDevice;
import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import java.util.Map;

public class XRStarryNetOperator extends StarryNetOperator {
    private static final String TAG = "XRStarryNetOperator";

    public XRStarryNetOperator() {
        BrEdrChannel brEdrChannel = (BrEdrChannel) StarryNetChannelManager.getInstance().getConnectChannel(21);
        this.mBrEdrChannel = brEdrChannel;
        brEdrChannel.setActionCallback(this.mBrEdrActionStateCallBack);
    }

    public void dial(String str) {
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        if (curBondInfo != null) {
            StLog.d(TAG, "dial");
            BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(curBondInfo.getDevice());
            if (bluetoothDevice != null) {
                this.mBrEdrChannel.dial(bluetoothDevice, str);
            }
        }
    }

    public StDevice getAudioPlayDevice() {
        StLog.d(TAG, " not support getAudioPlayDevice");
        return null;
    }

    public void operateCallAction(int i) {
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        if (curBondInfo != null) {
            StLog.d(TAG, "operateCallAction, action = " + i);
            BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(curBondInfo.getDevice());
            if (bluetoothDevice != null) {
                this.mBrEdrChannel.operateCallAction(bluetoothDevice, i);
            }
        }
    }

    public void pullPhoneBook() {
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        if (curBondInfo != null) {
            StLog.d(TAG, "pullPhoneBook");
            BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(curBondInfo.getDevice());
            if (bluetoothDevice != null) {
                this.mBrEdrChannel.pullPhoneBook(bluetoothDevice);
            }
        }
    }

    public void registerOperateCallback(IStarryOperateCallback iStarryOperateCallback) {
        super.registerOperateCallback(iStarryOperateCallback);
        if (iStarryOperateCallback == null) {
            StLog.d(TAG, "onCallStateChanged callback is null");
            return;
        }
        Map<String, Integer> callList = this.mBrEdrChannel.getCallList();
        if (callList != null) {
            for (Map.Entry next : callList.entrySet()) {
                StLog.d(TAG, "number = " + ((String) next.getKey()) + ", state = " + next.getValue());
                this.mStarryOperateCallback.onCallStateChanged((String) next.getKey(), ((Integer) next.getValue()).intValue());
            }
            return;
        }
        StLog.d(TAG, "number = null, state = 8");
        this.mStarryOperateCallback.onCallStateChanged((String) null, 8);
    }

    public int switchAudioPlayDevice(StDevice stDevice) {
        StLog.d(TAG, " not support switchAudioPlayDevice");
        return 0;
    }
}
