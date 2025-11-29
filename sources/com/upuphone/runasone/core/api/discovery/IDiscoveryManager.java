package com.upuphone.runasone.core.api.discovery;

import com.upuphone.hub.annotation.Callback;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;

public interface IDiscoveryManager {
    int cancelAuth(String str);

    void createBond(String str);

    void disableFastConnect();

    void enableFastConnect();

    int enableFastConnectWithTimeOut(long j);

    void removeBond(String str);

    void requestAuth(String str, byte[] bArr);

    int requestConnect(byte[] bArr);

    int requestConnectWithTime(byte[] bArr, long j);

    int setAdvertiseEnableMode(int i);

    void setDiscoveryFilter(DiscoveryFilter discoveryFilter);

    int setFastConnectProcess(int i);

    int setReconnectEnable(boolean z);

    void startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, @Callback IDiscoveryCallback iDiscoveryCallback);

    int startMultiDeviceFound();

    void stopDiscovery();

    int stopMultiDeviceFound(boolean z);

    int updateAdvParams(byte[] bArr);
}
