package com.upuphone.runasone.ble;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.starrynet.api.StConstant;

public final class MtuCallbackProxy implements MtuCallback {
    private static final String TAG = "MtuCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public MtuCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onMtuChange(int i, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onMtuChange");
        bundle.putInt("status", i);
        bundle.putInt(StConstant.STARRY_NET_STACK_MTU, i2);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
