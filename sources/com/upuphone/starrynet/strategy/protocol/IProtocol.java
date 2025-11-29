package com.upuphone.starrynet.strategy.protocol;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;

public interface IProtocol {
    int connect(StDevice stDevice, int i);

    int disconnect(StDevice stDevice, int i);

    IMessageChannel getMessageChannel(StDevice stDevice);

    int getProfile();

    void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2);

    boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel);

    boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel);

    void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel);

    int sendMsg(StDevice stDevice, byte[] bArr);
}
