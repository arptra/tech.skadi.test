package com.upuphone.starrynet.strategy.operater;

import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;

public class DefStarryNetOperator extends StarryNetOperator {
    private static final String TAG = "DefStarryNetOperator";

    public void dial(String str) {
    }

    public StDevice getAudioPlayDevice() {
        StLog.d(TAG, " not support getAudioPlayDevice");
        return new StDevice();
    }

    public void operateCallAction(int i) {
    }

    public void pullPhoneBook() {
    }

    public void registerOperateCallback(IStarryOperateCallback iStarryOperateCallback) {
        super.registerOperateCallback(iStarryOperateCallback);
    }

    public int switchAudioPlayDevice(StDevice stDevice) {
        StLog.d(TAG, " not support switchAudioPlayDevice");
        return 0;
    }
}
