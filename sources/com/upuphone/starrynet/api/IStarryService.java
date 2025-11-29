package com.upuphone.starrynet.api;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.manager.IStarryConnectManager;
import com.upuphone.starrynet.api.manager.IStarryDiscoveryManager;
import com.upuphone.starrynet.api.manager.IStarryHidManager;
import com.upuphone.starrynet.api.manager.IStarryOperateManager;
import com.upuphone.starrynet.api.manager.IStarryTransferManager;
import java.util.List;

public interface IStarryService {
    List<StDevice> getBondedDevices();

    List<StDevice> getConnectedDevices(int i);

    String getDeviceDetailInfo(byte[] bArr, int i);

    int getDeviceState(byte[] bArr, int i);

    StDevice getOwnDevice();

    StDevice getStDevice(byte[] bArr);

    IStarryConnectManager getStarryConnectManager();

    IStarryDiscoveryManager getStarryDiscoveryManager();

    IStarryHidManager getStarryHidManager();

    IStarryNetConfig getStarryNetConfig();

    IStarryOperateManager getStarryOperateManager();

    IStarryTransferManager getStarryTransferManager();

    long startUp();

    long startUp(short s);
}
