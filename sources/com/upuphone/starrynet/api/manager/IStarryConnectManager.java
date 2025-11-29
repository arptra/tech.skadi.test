package com.upuphone.starrynet.api.manager;

import android.os.Bundle;
import com.upuphone.starrynet.api.IDirectConnectCallBack;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.IStarryConnectCallback;
import com.upuphone.starrynet.api.bean.StDevice;

public interface IStarryConnectManager {
    int cancelAuth(byte[] bArr);

    int connect(StDevice stDevice, int i);

    int createBond(byte[] bArr);

    int disconnect(StDevice stDevice, int i);

    int getDeviceConnectable(byte[] bArr);

    IPublisher.IHandler registerPublisher(IPublisher iPublisher);

    int removeBond(byte[] bArr);

    void removeConnectionStateChangeCallback();

    void removeDirectConnectCallBack();

    int requestAuth(byte[] bArr, byte[] bArr2);

    void setConnectionStateChangeCallback(IStarryConnectCallback iStarryConnectCallback);

    void setDefaultPort(int i);

    void setDirectConnectCallBack(IDirectConnectCallBack iDirectConnectCallBack);

    boolean starryNetStackActionCmd(int i, Bundle bundle, StDevice stDevice);
}
