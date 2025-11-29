package com.upuphone.starrynet.strategy.data;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public interface IDiscoveryConnectCallback {
    void onBleConnected(String str, boolean z);

    void onBleDisconnected(String str);

    void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2);

    void onConnectFail(StDevice stDevice, int i, int i2);

    void onP2pGoConnected(StConnectDevice stConnectDevice);

    void onP2pGoDisconnected(StConnectDevice stConnectDevice);
}
