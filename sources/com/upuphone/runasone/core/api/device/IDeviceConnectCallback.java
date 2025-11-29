package com.upuphone.runasone.core.api.device;

import com.upuphone.hub.annotation.Hub;
import com.upuphone.runasone.device.StarryDevice;

@Hub
public interface IDeviceConnectCallback {
    void onAuth(StarryDevice starryDevice);

    void onAuthMessage(StarryDevice starryDevice, byte[] bArr, int i);

    void onBalanceConnectedChanged(StarryDevice starryDevice, boolean z);

    void onBondStateChanged(int i, int i2, StarryDevice starryDevice);

    void onBrConnectedChanged(StarryDevice starryDevice, boolean z);

    void onConnectFail(int i, StarryDevice starryDevice, int i2);

    void onConnectedChanged(StarryDevice starryDevice, int i, int i2);
}
