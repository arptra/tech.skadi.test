package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IWifiConnectCallback;
import com.upuphone.xr.interconnect.common.IWifiInfoCallback;
import com.upuphone.xr.interconnect.common.IWifiManager;

public class WifiManagerImpl extends IWifiManager.Stub {
    public void connectWifi(String str, String str2, int i, IWifiConnectCallback iWifiConnectCallback) throws RemoteException {
        InterconnectManager.getInstance().getStarryNetWifiManager().connectWifi(str, str2, i, iWifiConnectCallback);
    }

    public void getConnectedWifiInfo(IWifiInfoCallback iWifiInfoCallback) throws RemoteException {
        InterconnectManager.getInstance().getStarryNetWifiManager().getConnectedWifiInfo(iWifiInfoCallback);
    }
}
