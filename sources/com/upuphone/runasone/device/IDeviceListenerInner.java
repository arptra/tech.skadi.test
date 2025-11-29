package com.upuphone.runasone.device;

public interface IDeviceListenerInner {
    boolean isLanConnected(String str);

    void onApConnectedChanged(String str, boolean z);

    void onApCreated(int i);

    void onApRemoved();

    void onAuth(StarryDevice starryDevice);

    void onAuthMessage(StarryDevice starryDevice, byte[] bArr, int i);

    void onBRConnectedChanged(int i, String str);

    void onBleConnectedChanged(String str, boolean z);

    void onBondStateChanged(int i, int i2, StarryDevice starryDevice);

    void onConnectFail(int i, StarryDevice starryDevice, int i2);

    void onLanConnected(String str, boolean z);

    void onLanDisConnected(String str);

    void onP2PConnectedChanged(String str, boolean z);

    void onP2pGoCreated(int i);

    void onP2pGoRemoved();

    void onSPPConnectedChanged(String str, boolean z);

    void onStarrynetServiceError();
}
