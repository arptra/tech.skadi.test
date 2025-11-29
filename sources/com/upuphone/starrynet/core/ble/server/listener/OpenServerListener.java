package com.upuphone.starrynet.core.ble.server.listener;

public interface OpenServerListener extends GattServerResponseListener {
    void onResult(int i);
}
