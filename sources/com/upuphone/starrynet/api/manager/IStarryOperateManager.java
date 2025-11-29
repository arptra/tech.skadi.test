package com.upuphone.starrynet.api.manager;

import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.bean.StDevice;

public interface IStarryOperateManager {
    void dial(String str);

    StDevice getAudioPlayDevice();

    void operateAction(int i, int i2);

    void registerOperateCallback(IStarryOperateCallback iStarryOperateCallback);

    int switchAudioPlayDevice(StDevice stDevice);

    void unRegisterOperateCallback();
}
