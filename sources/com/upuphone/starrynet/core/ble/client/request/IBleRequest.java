package com.upuphone.starrynet.core.ble.client.request;

import com.upuphone.starrynet.core.ble.client.IBleRequestDispatcher;

public interface IBleRequest {
    void cancel();

    void process(IBleRequestDispatcher iBleRequestDispatcher);
}
