package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.List;

public final class RelayCallbackProxy implements RelayCallback {
    private static final String TAG = "RelayCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public RelayCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onDeviceListChanged(String str, List<StarryDevice> list) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDeviceListChanged");
        bundle.putString("appUniteCode", str);
        bundle.putString("devList", this.gson.toJson((Object) list));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onReceiveMessage(StarryTag starryTag, ArrayData arrayData, StarryParam starryParam) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onReceiveMessage");
        bundle.putParcelable("tag", starryTag);
        bundle.putParcelable(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, arrayData);
        bundle.putString("param", this.gson.toJson((Object) starryParam));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            throw new HubException((Throwable) e);
        }
    }

    public void onRemoteError(StarryTag starryTag, int i, String str, StarryParam starryParam) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onRemoteError");
        bundle.putParcelable("tag", starryTag);
        bundle.putInt("code", i);
        bundle.putString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, str);
        bundle.putString("param", this.gson.toJson((Object) starryParam));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onRemoteStart(StarryTag starryTag, StarryParam starryParam) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onRemoteStart");
        bundle.putParcelable("tag", starryTag);
        bundle.putString("param", this.gson.toJson((Object) starryParam));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onRemoteStop(StarryTag starryTag, StarryParam starryParam) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onRemoteStop");
        bundle.putParcelable("tag", starryTag);
        bundle.putString("param", this.gson.toJson((Object) starryParam));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
