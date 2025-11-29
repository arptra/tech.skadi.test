package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.e6.a;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.payload.PayloadConstant;

public final class BypassCallbackAdapter extends Hub.Stub {
    private final BypassCallback adaptee;
    private final Gson gson = new Gson();

    public BypassCallbackAdapter(BypassCallback bypassCallback) {
        this.adaptee = bypassCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(String str, String str2, String str3, int i, ArrayData arrayData) {
        this.adaptee.onReceiveMessage(str, str2, str3, i, arrayData);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onReceiveMessage".equals(bundle.getString("method"))) {
            MainThread.a(new a(this, bundle.getString(Constants.DEVICE_ID), bundle.getString("serviceUuid"), bundle.getString("characterUuid"), bundle.getInt(StConstant.STARRY_MESSAGE_KEY_MSG_TYPE), (ArrayData) bundle.getParcelable(PayloadConstant.PARAMS_KEY_CALLBACK_MSG)));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(BypassCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
