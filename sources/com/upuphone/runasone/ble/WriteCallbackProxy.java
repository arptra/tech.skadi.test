package com.upuphone.runasone.ble;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class WriteCallbackProxy implements WriteCallback {
    private static final String TAG = "WriteCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public WriteCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onWrite(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onWrite");
        bundle.putInt("state", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
