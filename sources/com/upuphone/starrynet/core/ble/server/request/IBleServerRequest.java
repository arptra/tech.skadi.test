package com.upuphone.starrynet.core.ble.server.request;

import com.upuphone.starrynet.core.ble.server.BleServerRequestDispatcher;

public interface IBleServerRequest {
    void cancel();

    void process(BleServerRequestDispatcher bleServerRequestDispatcher);
}
