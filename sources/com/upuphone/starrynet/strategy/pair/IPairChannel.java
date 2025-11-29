package com.upuphone.starrynet.strategy.pair;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public interface IPairChannel {
    void disconnect(StDevice stDevice);

    void disconnectP2p(StDevice stDevice);

    void readMsg(StDevice stDevice, int i, byte[] bArr, IPairMsgCallback iPairMsgCallback);

    void sendMsg(StDevice stDevice, int i, byte[] bArr, IPairMsgCallback iPairMsgCallback);

    boolean sendP2pMsg(StConnectDevice stConnectDevice, byte[] bArr);

    void updateBondStateChanged(StDevice stDevice, int i);
}
