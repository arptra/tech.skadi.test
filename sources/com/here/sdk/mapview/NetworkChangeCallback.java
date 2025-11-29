package com.here.sdk.mapview;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.NonNull;
import com.here.sdk.mapview.NetworkChangesObserver;

class NetworkChangeCallback extends ConnectivityManager.NetworkCallback {
    NetworkChangesObserver.Listener mObserver;

    public NetworkChangeCallback(NetworkChangesObserver.Listener listener, ConnectivityManager connectivityManager) {
        this.mObserver = listener;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            this.mObserver.onDisconnected();
            return;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
            this.mObserver.onDisconnected();
        } else {
            this.mObserver.onConnected();
        }
    }

    public void onAvailable(@NonNull Network network) {
        super.onAvailable(network);
        this.mObserver.onConnected();
    }

    public void onLost(@NonNull Network network) {
        super.onLost(network);
        this.mObserver.onDisconnected();
    }
}
