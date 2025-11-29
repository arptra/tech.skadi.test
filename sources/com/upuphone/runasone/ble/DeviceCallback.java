package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Hub;

@Hub
public interface DeviceCallback {
    void onConnected(BleRawSession bleRawSession);

    void onDisconnected(int i);

    void onError(int i);

    void onLose();
}
