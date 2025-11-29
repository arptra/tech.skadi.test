package com.upuphone.starrynetsdk.device.discovery;

import android.os.Bundle;
import com.upuphone.runasone.device.StarryDevice;

public interface DiscoverListener {
    void onDeviceFound(StarryDevice starryDevice, Bundle bundle) {
    }

    void onDeviceFound(StarryDevice starryDevice, byte[] bArr);

    void onDeviceLose(StarryDevice starryDevice);

    void onDeviceRequestConnect(StarryDevice starryDevice, byte[] bArr);

    void onError(int i);

    void onFastFound(StarryDevice starryDevice, int i) {
    }

    void onTimeout();

    void onFastFound(StarryDevice starryDevice, int i, int i2) {
    }
}
