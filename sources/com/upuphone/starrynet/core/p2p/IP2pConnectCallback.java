package com.upuphone.starrynet.core.p2p;

import com.upuphone.starrynet.core.p2p.bean.GoInfo;

public interface IP2pConnectCallback {
    void onConnectedFail(int i, byte[] bArr);

    void onP2pGcConnected(int i, String str, byte[] bArr, String str2);

    void onP2pGcDisconnected(String str, byte[] bArr);

    void onP2pGoConnected(String str);

    void onP2pGoCreated(GoInfo goInfo);

    void onP2pGoDisconnected(String str);

    void onP2pGoRemoved();
}
