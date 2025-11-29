package com.upuphone.starrynet.api;

import android.os.Bundle;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.StDevice;

public interface IStarryDiscoveryCallback {
    void onDeviceConnectRequest(StDevice stDevice, byte[] bArr);

    void onDeviceFound(StDevice stDevice, byte[] bArr, Bundle bundle, DiscoveryFilter discoveryFilter);

    void onDeviceLose(StDevice stDevice);

    void onDiscoveryError(int i);

    void onDiscoveryRegistered(String str);

    void onDiscoveryTimeout();

    void onFastFound(StDevice stDevice, int i, int i2);
}
