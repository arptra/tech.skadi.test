package com.upuphone.starrynetsdk.ability.relay;

public interface RemoteListener {
    void onFailure(String str, int i);

    void onSuccess(String str);
}
