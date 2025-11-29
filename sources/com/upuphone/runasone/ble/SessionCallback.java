package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.ThrowException;

@Hub
public interface SessionCallback {
    @ThrowException
    void onNotify(String str, byte[] bArr);
}
