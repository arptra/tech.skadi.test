package com.upuphone.starrynet.strategy.pair;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public interface IMYVURingStatusCallback {
    StConnectDevice getConnectDevice(String str);

    void onPairStatusChange(StDevice stDevice, int i, int i2);

    void onPrivateCmdExchange(StDevice stDevice, int i, int i2);

    void securityMessageSender(StDevice stDevice, byte[] bArr);
}
