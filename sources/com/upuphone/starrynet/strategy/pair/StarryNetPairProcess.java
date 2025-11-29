package com.upuphone.starrynet.strategy.pair;

import com.upuphone.starrynet.api.bean.StDevice;

public class StarryNetPairProcess {
    private final IPairChannel mChannel;

    public StarryNetPairProcess(IPairChannel iPairChannel) {
        this.mChannel = iPairChannel;
    }

    public void readMsg(StDevice stDevice, int i, byte[] bArr, IPairMsgCallback iPairMsgCallback) {
        this.mChannel.readMsg(stDevice, i, bArr, iPairMsgCallback);
    }

    public void sendMsgWithRsp(StDevice stDevice, int i, byte[] bArr, IPairMsgCallback iPairMsgCallback) {
        this.mChannel.sendMsg(stDevice, i, bArr, iPairMsgCallback);
    }
}
