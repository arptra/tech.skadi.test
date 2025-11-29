package com.upuphone.starrynetsdk.device.connection;

import com.upuphone.runasone.device.StarryDevice;

public interface ConnectionListener {
    void onAuth(StarryDevice starryDevice) {
    }

    void onAuthMessage(StarryDevice starryDevice, byte[] bArr) {
    }

    void onBalanceConnectedChanged(StarryDevice starryDevice, boolean z) {
    }

    void onBondStateChange(StarryDevice starryDevice, int i);

    void onBondStateChange(StarryDevice starryDevice, int i, int i2) {
    }

    void onBrConnectedChanged(StarryDevice starryDevice, boolean z) {
    }

    void onConnectFail(int i, StarryDevice starryDevice, int i2) {
    }

    void onConnectStateChange(StarryDevice starryDevice, int i);

    void onConnectStateChange(StarryDevice starryDevice, int i, int i2) {
    }

    void onAuthMessage(StarryDevice starryDevice, byte[] bArr, int i) {
    }
}
