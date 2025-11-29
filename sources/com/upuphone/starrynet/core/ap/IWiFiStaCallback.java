package com.upuphone.starrynet.core.ap;

public interface IWiFiStaCallback {
    void onApDisconnectFail(int i);

    void onApDisconnected(byte[] bArr, String str);

    void onApStaConnectFail(byte[] bArr, int i);

    void onApStaConnected(byte[] bArr, String str, String str2);
}
