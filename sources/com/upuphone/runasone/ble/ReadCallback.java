package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Hub;

@Hub
public interface ReadCallback {
    void onRead(int i, byte[] bArr);
}
