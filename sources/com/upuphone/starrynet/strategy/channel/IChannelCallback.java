package com.upuphone.starrynet.strategy.channel;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public interface IChannelCallback {
    void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2);

    void onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel);

    void onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel);

    void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel);
}
