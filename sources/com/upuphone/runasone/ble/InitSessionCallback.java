package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Hub;

@Hub
public interface InitSessionCallback {
    void onInit(int i);
}
