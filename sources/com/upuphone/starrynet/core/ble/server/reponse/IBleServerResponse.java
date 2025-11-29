package com.upuphone.starrynet.core.ble.server.reponse;

public interface IBleServerResponse<T> {
    void onResponse(int i, T t);
}
