package com.upuphone.starrynet.api;

import com.upuphone.starrynet.api.bean.StDevice;

public interface ILanConnectCallback {
    boolean isLanGcConnected(StDevice stDevice);

    void onLanDisconnected(StDevice stDevice);

    void onLanGcConnected(int i, String str, StDevice stDevice);

    void onLanGoConnected(int i, String str, StDevice stDevice);
}
