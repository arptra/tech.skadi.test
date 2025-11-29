package com.upuphone.runasone.core.api.discovery;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;

public final class IDiscoveryCallbackProxy implements IDiscoveryCallback {
    private static final String TAG = "IDiscoveryCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public IDiscoveryCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onDeviceConnectRequest(StarryDevice starryDevice, byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDeviceConnectRequest");
        bundle.putString("device", this.gson.toJson((Object) starryDevice));
        bundle.putByteArray("data", bArr);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDeviceFound(StarryDevice starryDevice, byte[] bArr, Bundle bundle, DiscoveryFilter discoveryFilter) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "onDeviceFound");
        bundle2.putString("device", this.gson.toJson((Object) starryDevice));
        bundle2.putByteArray("data", bArr);
        bundle2.putParcelable("bundle", bundle);
        bundle2.putString("filter", this.gson.toJson((Object) discoveryFilter));
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDeviceLose(StarryDevice starryDevice) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDeviceLose");
        bundle.putString("device", this.gson.toJson((Object) starryDevice));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDiscoveryError(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDiscoveryError");
        bundle.putInt("errorCode", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDiscoveryTimeout() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDiscoveryTimeout");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onFastFound(StarryDevice starryDevice, int i, int i2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onFastFound");
        bundle.putString("device", this.gson.toJson((Object) starryDevice));
        bundle.putInt("type", i);
        bundle.putInt("beaconId", i2);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
