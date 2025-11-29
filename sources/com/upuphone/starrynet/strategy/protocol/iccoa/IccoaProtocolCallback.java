package com.upuphone.starrynet.strategy.protocol.iccoa;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IccoaProtocolCallback {
    boolean isBleAuthCompleted();

    void onConnectFail(int i);

    void onConnected(String str);

    void onDisConnected(String str);

    void onRecv(StDevice stDevice, byte[] bArr, int i);
}
