package com.upuphone.starrynet.core.ble.client.listener;

public interface ServiceDiscoverListener extends GattResponseListener {
    void onServicesDiscovered(int i);
}
