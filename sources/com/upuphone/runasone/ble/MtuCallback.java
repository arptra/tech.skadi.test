package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Hub;

@Hub
public interface MtuCallback {
    void onMtuChange(int i, int i2);
}
