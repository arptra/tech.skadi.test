package com.upuphone.runasone.core.api.discovery;

import android.os.Bundle;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;

@Hub
public interface IDiscoveryCallback {
    void onDeviceConnectRequest(StarryDevice starryDevice, byte[] bArr);

    void onDeviceFound(StarryDevice starryDevice, byte[] bArr, @Parcelable Bundle bundle, DiscoveryFilter discoveryFilter);

    void onDeviceLose(StarryDevice starryDevice);

    void onDiscoveryError(int i);

    void onDiscoveryTimeout();

    void onFastFound(StarryDevice starryDevice, int i, int i2);
}
