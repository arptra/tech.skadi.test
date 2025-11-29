package com.upuphone.starrynet.core.ble.manager;

public interface IBleMultiDataReceiver extends IBleDataReceiver {
    void onReceiveFullData(String str, int i, byte[] bArr);
}
