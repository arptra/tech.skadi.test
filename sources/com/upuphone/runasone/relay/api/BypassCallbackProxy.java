package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.payload.PayloadConstant;

public final class BypassCallbackProxy implements BypassCallback {
    private static final String TAG = "BypassCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public BypassCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onReceiveMessage(String str, String str2, String str3, int i, ArrayData arrayData) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onReceiveMessage");
        bundle.putString(Constants.DEVICE_ID, str);
        bundle.putString("serviceUuid", str2);
        bundle.putString("characterUuid", str3);
        bundle.putInt(StConstant.STARRY_MESSAGE_KEY_MSG_TYPE, i);
        bundle.putParcelable(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, arrayData);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
