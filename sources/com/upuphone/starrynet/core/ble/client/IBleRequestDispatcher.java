package com.upuphone.starrynet.core.ble.client;

import com.upuphone.starrynet.core.ble.client.request.BleRequest;

public interface IBleRequestDispatcher {
    void onRequestCompleted(BleRequest bleRequest);
}
