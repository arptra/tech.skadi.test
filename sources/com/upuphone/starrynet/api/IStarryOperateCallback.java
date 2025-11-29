package com.upuphone.starrynet.api;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IStarryOperateCallback {
    void onBrEdrAudioDeviceChanged(StDevice stDevice);

    void onCallStateChanged(String str, int i);

    void onPullPhoneBookChanged(int i);
}
