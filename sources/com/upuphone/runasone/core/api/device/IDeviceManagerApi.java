package com.upuphone.runasone.core.api.device;

import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.runasone.core.api.connection.IConnectionManager;
import com.upuphone.runasone.core.api.discovery.IDiscoveryManager;
import com.upuphone.runasone.device.StarryDevice;
import java.util.List;

@Hub
public interface IDeviceManagerApi extends IDiscoveryManager, IConnectionManager, IWifiInfo {
    List<StarryDevice> getConnectedDevices(int i);

    String getDeviceDetailInfo(String str, int i);

    List<String> getSupportAbility(String str);

    void registerDeviceStatusListener(String str, @Callback IDeviceConnectCallback iDeviceConnectCallback);

    void unRegisterDeviceStatusListener(String str);
}
