package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class IVirtualDeviceEventListenerProxy implements IVirtualDeviceEventListener {
    private static final String TAG = "IVirtualDeviceEventListenerProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public IVirtualDeviceEventListenerProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onError(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onError");
        bundle.putInt("errorCode", i);
        bundle.putString("message", str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onEvent(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "onEvent");
        bundle2.putInt("eventCode", i);
        bundle2.putParcelable("bundle", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
