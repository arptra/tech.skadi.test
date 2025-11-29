package com.upuphone.runasone.relay.api;

import com.upuphone.hub.annotation.Hub;

@Hub
public interface SendRelayMessageCallBack {
    void onError(int i, String str);

    void onSuccess();
}
