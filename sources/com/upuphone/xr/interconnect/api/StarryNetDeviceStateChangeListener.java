package com.upuphone.xr.interconnect.api;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;

public interface StarryNetDeviceStateChangeListener {
    void onBondStateChanged(StarryNetDevice starryNetDevice, int i);

    void onConnectFail(int i, StarryDevice starryDevice, int i2) {
    }

    void onConnectStateChanged(StarryNetDevice starryNetDevice, int i);

    void onReceivePairingKey(StarryNetDevice starryNetDevice, String str);
}
