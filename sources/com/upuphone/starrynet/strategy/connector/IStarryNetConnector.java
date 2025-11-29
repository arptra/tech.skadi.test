package com.upuphone.starrynet.strategy.connector;

import android.os.Bundle;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.bean.StDevice;

public interface IStarryNetConnector {
    void cancelAuth(StDevice stDevice);

    void connectAp(StDevice stDevice);

    void connectBle(StDevice stDevice);

    void connectBrEdr(StDevice stDevice);

    void connectP2p(StDevice stDevice);

    void connectSpp(StDevice stDevice);

    void connectUsb(StDevice stDevice);

    void createBond(StDevice stDevice);

    void createBondBrEdr(StDevice stDevice);

    void disconnectAp(StDevice stDevice);

    void disconnectBle(StDevice stDevice, boolean z);

    void disconnectBrEdr(StDevice stDevice);

    void disconnectP2p(StDevice stDevice);

    void disconnectP2p(StDevice stDevice, boolean z);

    void disconnectSpp(StDevice stDevice);

    void disconnectUsb(StDevice stDevice);

    int getDeviceConnectable(StDevice stDevice);

    IPublisher.IHandler registerPublisher(IPublisher iPublisher);

    void removeBond(StDevice stDevice);

    void removeBondBrEdr(StDevice stDevice);

    void requestAuth(StDevice stDevice, byte[] bArr);

    void setDefaultPort(int i);

    boolean starryNetStackActionCmd(int i, Bundle bundle, StDevice stDevice);
}
