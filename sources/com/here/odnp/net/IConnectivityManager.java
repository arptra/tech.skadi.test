package com.here.odnp.net;

import com.here.posclient.INetworkManager;
import com.here.posclient.PosClientLib;

public interface IConnectivityManager extends INetworkManager {

    public interface IConnectivityListener {
        void onConnectionStateChanged(PosClientLib.ConnectionChangeAction connectionChangeAction, INetworkManager.Connection connection);
    }

    void close();

    void open(IConnectivityListener iConnectivityListener);
}
