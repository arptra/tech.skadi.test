package com.upuphone.starrynet.strategy.operater;

import android.bluetooth.BluetoothAdapter;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;

public class PhoneStarryNetOperator extends StarryNetOperator {
    private static final String TAG = "PhoneStarryNetOperator";

    public PhoneStarryNetOperator() {
        BrEdrChannel brEdrChannel = (BrEdrChannel) StarryNetChannelManager.getInstance().getConnectChannel(20);
        this.mBrEdrChannel = brEdrChannel;
        brEdrChannel.setActionCallback(this.mBrEdrActionStateCallBack);
    }

    public void dial(String str) {
        StLog.d(TAG, " not support dial");
    }

    public StDevice getAudioPlayDevice() {
        if (this.mAudioActiveDevice == null) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(this.mBrEdrChannel.getActiveDevice());
            this.mAudioActiveDevice = connectDevice == null ? StarryNetData.getInstance().getOwnDevice() : connectDevice.getDevice();
        }
        return this.mAudioActiveDevice;
    }

    public void operateCallAction(int i) {
        StLog.d(TAG, " not support operateCallAction");
    }

    public void pullPhoneBook() {
        StLog.d(TAG, " not support pullPhoneBook");
    }

    public int switchAudioPlayDevice(StDevice stDevice) {
        if (stDevice.equals(StarryNetData.getInstance().getOwnDevice())) {
            StLog.d(TAG, "removeAudioActiveDevice");
            return this.mBrEdrChannel.removeAudioActiveDevice();
        }
        return this.mBrEdrChannel.switchAudioPlayDevice(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(Utils.getAddressStringFromByte(stDevice.getIdentifier())));
    }
}
