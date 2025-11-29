package com.upuphone.starrynet.api.manager;

import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;

public interface IStarryDiscoveryManager {
    int disableFastConnect();

    int enableFastConnect();

    int enableFastConnectWithTimeOut(long j);

    int requestConnect(byte[] bArr);

    int requestConnectWithTime(byte[] bArr, long j);

    int setAdvertiseEnableMode(int i);

    int setDeviceConnectable(boolean z, int i, String str);

    void setDiscoveryFilter(DiscoveryFilter discoveryFilter);

    int setFastConnectProcess(int i);

    int setReconnectEnable(boolean z);

    int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback);

    int startMultiDeviceFound();

    int stopDiscovery(String str);

    int stopMultiDeviceFound(boolean z);

    int updateAdvParams(byte[] bArr);
}
