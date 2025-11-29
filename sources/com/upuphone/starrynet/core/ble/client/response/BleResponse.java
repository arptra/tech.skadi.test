package com.upuphone.starrynet.core.ble.client.response;

public interface BleResponse<T> {
    void onResponse(int i, T t);
}
