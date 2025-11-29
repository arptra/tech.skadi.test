package com.upuphone.starrynet.strategy.discovery.scanner;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import java.util.List;

public interface IDiscoveryListener {
    void onBatchDiscovered(List<StDevice> list);

    void onDiscovered(StDiscoveryDevice stDiscoveryDevice);

    void onDiscoveredFail(int i);

    void onLost(StDiscoveryDevice stDiscoveryDevice);
}
