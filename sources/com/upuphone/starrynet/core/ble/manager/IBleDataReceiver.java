package com.upuphone.starrynet.core.ble.manager;

import java.util.UUID;

public interface IBleDataReceiver {
    UUID getFocusUuid();

    boolean isClient();

    boolean isSticky();

    void receiveData(BleReceiveData bleReceiveData);
}
