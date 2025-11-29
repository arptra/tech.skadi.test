package com.here.sdk.mapview;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

class NetworkChangesObserver {
    private static final String TAG = "NetworkChangesObserver";
    private static NetworkChangeBroadcastReceiver sBroadcastReceiver;
    private static NetworkChangeCallback sNetworkChangeCallback;

    public interface Listener {
        void onConnected();

        void onDisconnected();
    }

    private NetworkChangesObserver() {
    }

    public static void startObserving(Context context, Listener listener) {
        if (sBroadcastReceiver == null && sNetworkChangeCallback == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkChangeCallback networkChangeCallback = new NetworkChangeCallback(listener, connectivityManager);
                sNetworkChangeCallback = networkChangeCallback;
                connectivityManager.registerDefaultNetworkCallback(networkChangeCallback);
                return;
            }
            sBroadcastReceiver = new NetworkChangeBroadcastReceiver(listener);
            context.registerReceiver(sBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public static void stopObserving(Context context) {
        if (sBroadcastReceiver != null || sNetworkChangeCallback != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                try {
                    connectivityManager.unregisterNetworkCallback(sNetworkChangeCallback);
                } catch (IllegalArgumentException unused) {
                    Log.w(TAG, "Tried to unregister network receiver which has not been registered.");
                }
                sNetworkChangeCallback = null;
                return;
            }
            try {
                context.unregisterReceiver(sBroadcastReceiver);
            } catch (IllegalArgumentException unused2) {
                Log.w(TAG, "Tried to unregister broadcast receiver which has not been registered.");
            }
            sBroadcastReceiver = null;
        }
    }
}
