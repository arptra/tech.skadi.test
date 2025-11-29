package com.here.odnp.adaptations;

import com.here.odnp.net.IConnectivityManager;
import com.here.odnp.util.Log;
import com.here.posclient.INetworkManager;
import com.here.posclient.PosClientLib;

public class NetworkManager implements INetworkManager {
    private static final String TAG = "odnp.adaptations.NetworkManager";
    /* access modifiers changed from: private */
    public final IConnectivityManager.IConnectivityListener mConnChangeListener;
    private final IConnectivityManager.IConnectivityListener mConnectivityListener = new IConnectivityManager.IConnectivityListener() {
        public void onConnectionStateChanged(PosClientLib.ConnectionChangeAction connectionChangeAction, INetworkManager.Connection connection) {
            NetworkManager.this.mConnChangeListener.onConnectionStateChanged(connectionChangeAction, connection);
        }
    };
    private IConnectivityManager mConnectivityManager;

    public NetworkManager(IConnectivityManager.IConnectivityListener iConnectivityListener) {
        if (iConnectivityListener != null) {
            this.mConnChangeListener = iConnectivityListener;
            return;
        }
        throw new IllegalArgumentException("connectivityListener is null");
    }

    private void startListeningConnectivityChanges() {
        IConnectivityManager iConnectivityManager = this.mConnectivityManager;
        if (iConnectivityManager == null) {
            Log.w(TAG, "startListeningConnectivityChanges: connectivity manager not set => ignored", new Object[0]);
        } else {
            iConnectivityManager.open(this.mConnectivityListener);
        }
    }

    private void stopListeningConnectivityChanges() {
        IConnectivityManager iConnectivityManager = this.mConnectivityManager;
        if (iConnectivityManager == null) {
            Log.w(TAG, "stopListeningConnectivityChanges: connectivity manager not set => ignored", new Object[0]);
            return;
        }
        iConnectivityManager.close();
        this.mConnectivityManager = null;
    }

    public void close() {
        stopListeningConnectivityChanges();
    }

    public INetworkManager.Connection[] getConnections() {
        IConnectivityManager iConnectivityManager = this.mConnectivityManager;
        if (iConnectivityManager != null) {
            return iConnectivityManager.getConnections();
        }
        Log.w(TAG, "getConnections: connectivity manager not set => ignored", new Object[0]);
        return null;
    }

    public INetworkManager.Connection getDataConnection() {
        IConnectivityManager iConnectivityManager = this.mConnectivityManager;
        if (iConnectivityManager != null) {
            return iConnectivityManager.getDataConnection();
        }
        Log.w(TAG, "getDataConnection: connectivity manager not set => ignored", new Object[0]);
        return null;
    }

    public INetworkManager.Proxy getProxy(String str) {
        IConnectivityManager iConnectivityManager = this.mConnectivityManager;
        if (iConnectivityManager != null) {
            return iConnectivityManager.getProxy(str);
        }
        Log.w(TAG, "getProxy: connectivity manager not set => ignored", new Object[0]);
        return null;
    }

    public void open() {
        startListeningConnectivityChanges();
    }

    public NetworkManager setConnectivityManager(IConnectivityManager iConnectivityManager) {
        stopListeningConnectivityChanges();
        if (iConnectivityManager != null) {
            this.mConnectivityManager = iConnectivityManager;
            return this;
        }
        throw new IllegalArgumentException("connectivityManager is null");
    }
}
