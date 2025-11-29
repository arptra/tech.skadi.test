package com.upuphone.runasone.ble;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class OpenNotifyCallbackProxy implements OpenNotifyCallback {
    private static final String TAG = "OpenNotifyCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public OpenNotifyCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onOpen(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onOpen");
        bundle.putInt("state", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
