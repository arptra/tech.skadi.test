package com.upuphone.starrynet.strategy.data;

import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;

public interface IDiscoveryInterceptor {
    boolean onDiscovery(StDiscoveryDevice stDiscoveryDevice);
}
