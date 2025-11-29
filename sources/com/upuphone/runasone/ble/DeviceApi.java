package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Callback;

public interface DeviceApi {
    void connect(String str, ConnectConfig connectConfig);

    void disconnect(String str);

    void registerDeviceCallback(String str, @Callback DeviceCallback deviceCallback);

    void unregisterDeviceCallback(String str);
}
