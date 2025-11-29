package com.upuphone.starrynet.strategy.service;

import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.manager.IStarryOperateManager;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.operater.StarryNetOperator;

public class StarryOperateManager implements IStarryOperateManager {
    private static final String TAG = "StarryOperateManager";
    private IStarryOperateCallback mOperateCallback;
    private final StarryNetOperator mOperateManager;

    public StarryOperateManager(StarryNetOperator starryNetOperator) {
        this.mOperateManager = starryNetOperator;
        StarryNetData.getInstance().setOperateMgr(starryNetOperator);
    }

    public void dial(String str) {
        StLog.d(TAG, "dial, number = " + str);
        this.mOperateManager.dial(str);
    }

    public StDevice getAudioPlayDevice() {
        StLog.d(TAG, "getAudioPlayDevice");
        return this.mOperateManager.getAudioPlayDevice();
    }

    public void operateAction(int i, int i2) {
        StLog.d(TAG, "operateAction, type = " + i + ", action = " + i2);
        if (i == 0) {
            this.mOperateManager.operateCallAction(i2);
        } else if (i == 1) {
            this.mOperateManager.pullPhoneBook();
        }
    }

    public void registerOperateCallback(IStarryOperateCallback iStarryOperateCallback) {
        StLog.d(TAG, "registerOperateCallback");
        if (iStarryOperateCallback != null) {
            this.mOperateCallback = iStarryOperateCallback;
            this.mOperateManager.registerOperateCallback(iStarryOperateCallback);
        }
    }

    public int switchAudioPlayDevice(StDevice stDevice) {
        StLog.d(TAG, "switchAudioPlayDevice");
        return this.mOperateManager.switchAudioPlayDevice(stDevice);
    }

    public void unRegisterOperateCallback() {
        StLog.d(TAG, "unRegisterOperateCallback");
        if (this.mOperateCallback != null) {
            this.mOperateManager.unRegisterOperateCallback();
            this.mOperateCallback = null;
        }
    }
}
