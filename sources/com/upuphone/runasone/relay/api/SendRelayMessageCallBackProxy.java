package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.starrynet.payload.PayloadConstant;

public final class SendRelayMessageCallBackProxy implements SendRelayMessageCallBack {
    private static final String TAG = "SendRelayMessageCallBackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public SendRelayMessageCallBackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onError(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onError");
        bundle.putInt("code", i);
        bundle.putString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSuccess() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSuccess");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
