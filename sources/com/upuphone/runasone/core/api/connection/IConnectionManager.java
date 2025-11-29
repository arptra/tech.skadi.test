package com.upuphone.runasone.core.api.connection;

import com.upuphone.runasone.device.StarryDevice;
import java.util.List;

public interface IConnectionManager {
    int balanceConnect(String str);

    int connect(String str, int i);

    int disBalanceConnect(String str);

    int disconnect(String str, int i);

    int disconnectAll(String str);

    List<StarryDevice> getBondedDevice();

    List<StarryDevice> getConnectedDevice();

    int getCurDeviceState(String str);

    int getDeviceConnectable(String str);

    int getPreDeviceState(String str);

    StarryDevice getSelfDevice();

    int getVirtualChannelStatus(String str);

    boolean isBRConnect(String str);

    boolean isBalanceConnect(String str);

    int setDeviceConnectable(boolean z, int i, String str);
}
