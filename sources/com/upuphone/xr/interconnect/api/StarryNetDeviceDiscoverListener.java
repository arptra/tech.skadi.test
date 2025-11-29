package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;

public interface StarryNetDeviceDiscoverListener {
    void onDeviceFound(StarryNetDevice starryNetDevice);

    void onDeviceLose(StarryNetDevice starryNetDevice);

    void onError(int i);

    @Deprecated
    void onFastFound(StarryNetDevice starryNetDevice, int i) {
    }

    void onTimeout();

    void onFastFound(StarryNetDevice starryNetDevice, int i, int i2) {
    }
}
