package com.upuphone.xr.interconnect.listener;

import android.os.IBinder;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IWifiConnectCallback;

public abstract class WifiConnectCallback extends IWifiConnectCallback.Stub {
    public IBinder asBinder() {
        return null;
    }

    public void onResult(int i) throws RemoteException {
    }
}
