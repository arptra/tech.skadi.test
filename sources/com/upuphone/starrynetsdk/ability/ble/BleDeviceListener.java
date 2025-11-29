package com.upuphone.starrynetsdk.ability.ble;

public interface BleDeviceListener {
    void onConnected(BleSession bleSession);

    void onDisconnected(int i);

    void onError(int i);

    void onLose();
}
