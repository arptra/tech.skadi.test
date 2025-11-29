package com.upuphone.starrynet.strategy.discovery.fastpair.judgment;

import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;

public interface IJudgmentCallback {
    int fastPairStatus(StDiscoveryDevice stDiscoveryDevice);

    void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i);
}
