package com.here.sdk.mapview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.here.sdk.mapview.NetworkChangesObserver;

class NetworkChangeBroadcastReceiver extends BroadcastReceiver {
    private BroadcastReceiver receiver;

    public NetworkChangeBroadcastReceiver(final NetworkChangesObserver.Listener listener) {
        this.receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    listener.onDisconnected();
                } else {
                    listener.onConnected();
                }
            }
        };
    }

    public void onReceive(Context context, Intent intent) {
        this.receiver.onReceive(context, intent);
    }
}
