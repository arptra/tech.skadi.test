package com.upuphone.starrynet.core.spp.callback;

public interface IConnectionEventListener {
    void onConnectionStateChanged(String str, int i);

    void onMessageDispatched(String str, byte[] bArr, int i);

    void onMessageReceived(String str, byte[] bArr);
}
