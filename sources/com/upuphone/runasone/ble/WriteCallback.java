package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Hub;

@Hub
public interface WriteCallback {
    void onWrite(int i);
}
