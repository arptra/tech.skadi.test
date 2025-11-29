package com.upuphone.starrynet.core.ap;

public interface IWiFiApCallback {
    void onApClosed();

    void onApCreated(WiFiApInfo wiFiApInfo);
}
