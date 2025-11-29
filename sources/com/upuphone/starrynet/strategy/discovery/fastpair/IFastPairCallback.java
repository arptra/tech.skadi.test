package com.upuphone.starrynet.strategy.discovery.fastpair;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;

public interface IFastPairCallback {
    void onDeviceConnectRequest(StDevice stDevice, byte[] bArr);

    void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i);
}
