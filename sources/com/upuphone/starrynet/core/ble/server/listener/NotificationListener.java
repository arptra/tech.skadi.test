package com.upuphone.starrynet.core.ble.server.listener;

public interface NotificationListener extends GattServerResponseListener {
    void onNotificationSent(int i);
}
