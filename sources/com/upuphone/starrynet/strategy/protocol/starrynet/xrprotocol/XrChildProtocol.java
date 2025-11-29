package com.upuphone.starrynet.strategy.protocol.starrynet.xrprotocol;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;

public interface XrChildProtocol {
    boolean dealStarryNetMsg(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper);

    int getTargetTerminalType();

    void onBleServerConnected(StConnectDevice stConnectDevice);

    boolean onBleServerDisconnected(StConnectDevice stConnectDevice);

    void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2);
}
