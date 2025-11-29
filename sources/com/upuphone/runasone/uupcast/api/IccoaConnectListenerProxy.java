package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class IccoaConnectListenerProxy implements IccoaConnectListener {
    private static final String TAG = "IccoaConnectListenerProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public IccoaConnectListenerProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onConnectEvent(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "onConnectEvent");
        bundle2.putInt("event", i);
        bundle2.putParcelable("bundle", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
