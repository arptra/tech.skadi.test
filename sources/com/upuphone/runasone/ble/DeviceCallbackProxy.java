package com.upuphone.runasone.ble;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class DeviceCallbackProxy implements DeviceCallback {
    private static final String TAG = "DeviceCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public DeviceCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onConnected(BleRawSession bleRawSession) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onConnected");
        bundle.putString("bleRawSession", this.gson.toJson((Object) bleRawSession));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDisconnected(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDisconnected");
        bundle.putInt("reason", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onError(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onError");
        bundle.putInt("errorCode", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onLose() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onLose");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
