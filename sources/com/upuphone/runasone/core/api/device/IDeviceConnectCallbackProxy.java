package com.upuphone.runasone.core.api.device;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.device.StarryDevice;

public final class IDeviceConnectCallbackProxy implements IDeviceConnectCallback {
    private static final String TAG = "IDeviceConnectCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public IDeviceConnectCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onAuth(StarryDevice starryDevice) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onAuth");
        bundle.putString("peerDevice", this.gson.toJson((Object) starryDevice));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onAuthMessage(StarryDevice starryDevice, byte[] bArr, int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onAuthMessage");
        bundle.putString("peerDevice", this.gson.toJson((Object) starryDevice));
        bundle.putByteArray("data", bArr);
        bundle.putInt("authCode", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onBalanceConnectedChanged(StarryDevice starryDevice, boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onBalanceConnectedChanged");
        bundle.putString("peerDevice", this.gson.toJson((Object) starryDevice));
        bundle.putBoolean("connectState", z);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onBondStateChanged(int i, int i2, StarryDevice starryDevice) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onBondStateChanged");
        bundle.putInt("state", i);
        bundle.putInt("preState", i2);
        bundle.putString("peerDevice", this.gson.toJson((Object) starryDevice));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onBrConnectedChanged(StarryDevice starryDevice, boolean z) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onBrConnectedChanged");
        bundle.putString("peerDevice", this.gson.toJson((Object) starryDevice));
        bundle.putBoolean("isOpen", z);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onConnectFail(int i, StarryDevice starryDevice, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onConnectFail");
        bundle.putInt("type", i);
        bundle.putString("peerDevice", this.gson.toJson((Object) starryDevice));
        bundle.putInt("code", i2);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onConnectedChanged(StarryDevice starryDevice, int i, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onConnectedChanged");
        bundle.putString("peerDevice", this.gson.toJson((Object) starryDevice));
        bundle.putInt("preState", i);
        bundle.putInt("newState", i2);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
