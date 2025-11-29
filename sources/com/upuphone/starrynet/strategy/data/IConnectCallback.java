package com.upuphone.starrynet.strategy.data;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public interface IConnectCallback {
    void onApCreated(WiFiApInfo wiFiApInfo);

    void onApRemoved();

    void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2);

    void onConnectFail(StDevice stDevice, int i, int i2);

    void onConnected(StConnectDevice stConnectDevice, int i);

    void onDisconnected(StConnectDevice stConnectDevice, int i);

    void onP2pGoCreated(GoInfo goInfo);

    void onP2pGoRemoved();
}
