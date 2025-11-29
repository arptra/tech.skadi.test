package com.upuphone.starrynet.strategy.pair;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public interface IChannelModulePair {
    void createBond(StDevice stDevice, byte[] bArr);

    void onEvent(String str, byte[] bArr);

    void removeBond(StConnectDevice stConnectDevice, byte[] bArr);
}
