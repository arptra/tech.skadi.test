package com.upuphone.starrynet.strategy.operater;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.bredr.listener.IBrEdrActionStateCallback;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;

public abstract class StarryNetOperator {
    private static final String TAG = "StarryNetOperater";
    protected StDevice mAudioActiveDevice;
    protected IBrEdrActionStateCallback mBrEdrActionStateCallBack = new IBrEdrActionStateCallback() {
        public void onActiveDeviceChanged(BluetoothDevice bluetoothDevice, int i) {
            StLog.d(StarryNetOperator.TAG, "onActiveDeviceChanged device = " + bluetoothDevice + ", profile = " + i);
            if (i == 2) {
                StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bluetoothDevice);
                StarryNetOperator.this.mAudioActiveDevice = connectDevice == null ? StarryNetData.getInstance().getOwnDevice() : connectDevice.getDevice();
                StarryNetOperator starryNetOperator = StarryNetOperator.this;
                IStarryOperateCallback iStarryOperateCallback = starryNetOperator.mStarryOperateCallback;
                if (iStarryOperateCallback == null) {
                    StLog.d(StarryNetOperator.TAG, "onActiveDeviceChanged callback is null");
                } else {
                    iStarryOperateCallback.onBrEdrAudioDeviceChanged(starryNetOperator.mAudioActiveDevice);
                }
            }
        }

        public void onCallStateChanged(String str, int i) {
            StLog.d(StarryNetOperator.TAG, "onCallStateChange number = " + str + ", state = " + i);
            IStarryOperateCallback iStarryOperateCallback = StarryNetOperator.this.mStarryOperateCallback;
            if (iStarryOperateCallback == null) {
                StLog.d(StarryNetOperator.TAG, "onCallStateChanged callback is null");
            } else {
                iStarryOperateCallback.onCallStateChanged(str, i);
            }
        }

        public void onPullPhoneBookChanged(int i) {
            StLog.d(StarryNetOperator.TAG, "onPullPhoneBookChanged state = " + i);
            IStarryOperateCallback iStarryOperateCallback = StarryNetOperator.this.mStarryOperateCallback;
            if (iStarryOperateCallback == null) {
                StLog.d(StarryNetOperator.TAG, "onPullPhoneBookChanged callback is null");
            } else {
                iStarryOperateCallback.onPullPhoneBookChanged(i);
            }
        }
    };
    protected BrEdrChannel mBrEdrChannel;
    protected Context mContext = StarryNetData.getInstance().getApplicationContext();
    protected IStarryOperateCallback mStarryOperateCallback;

    public void clearPhoneBook() {
        this.mBrEdrChannel.clearPhoneBook();
    }

    public abstract void dial(String str);

    public abstract StDevice getAudioPlayDevice();

    public abstract void operateCallAction(int i);

    public abstract void pullPhoneBook();

    public void registerOperateCallback(IStarryOperateCallback iStarryOperateCallback) {
        this.mStarryOperateCallback = iStarryOperateCallback;
    }

    public abstract int switchAudioPlayDevice(StDevice stDevice);

    public void unRegisterOperateCallback() {
        this.mStarryOperateCallback = null;
    }
}
