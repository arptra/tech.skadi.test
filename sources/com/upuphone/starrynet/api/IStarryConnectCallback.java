package com.upuphone.starrynet.api;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IStarryConnectCallback {
    void onApConnected(StDevice stDevice, String str);

    void onApCreated(int i);

    void onApDisconnected(StDevice stDevice);

    void onApRemoved();

    void onAuth(StDevice stDevice);

    void onAuthMessage(StDevice stDevice, byte[] bArr, int i);

    void onBind(StDevice stDevice);

    void onBleConnected(StDevice stDevice);

    void onBleDisconnected(StDevice stDevice);

    void onBleServerConnected(StDevice stDevice);

    void onBleServerDisconnected(StDevice stDevice);

    void onBondStateChanged(int i, int i2, StDevice stDevice);

    void onConnectFail(int i, StDevice stDevice, int i2);

    void onConnected(int i, StDevice stDevice);

    void onDisconnected(int i, StDevice stDevice);

    void onP2pGcConnected(int i, String str, StDevice stDevice);

    void onP2pGcDisconnected(StDevice stDevice);

    void onP2pGoConnected(StDevice stDevice);

    void onP2pGoCreated(int i, String str);

    void onP2pGoDisconnected(StDevice stDevice);

    void onP2pGoRemoved();

    void onRegister();

    void onReset(StDevice stDevice);

    void onSppClientConnected(StDevice stDevice);

    void onSppClientDisconnected(StDevice stDevice);

    void onSppServerConnected(StDevice stDevice);

    void onSppServerDisconnected(StDevice stDevice);

    void onStaConnected(int i, String str, StDevice stDevice);

    void onStaDisconnected(StDevice stDevice);

    void onUnRegister();

    void onUnbind(StDevice stDevice);

    void reportOwnDevice(StDevice stDevice);
}
