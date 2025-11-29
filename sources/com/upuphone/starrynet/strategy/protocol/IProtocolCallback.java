package com.upuphone.starrynet.strategy.protocol;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public interface IProtocolCallback {
    void dealConnectP2P(StConnectDevice stConnectDevice, IProtocol iProtocol);

    void onConnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol);

    void onDisconnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol);
}
