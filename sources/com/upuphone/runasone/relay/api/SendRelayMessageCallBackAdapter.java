package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.e6.g;
import com.honey.account.e6.h;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.starrynet.payload.PayloadConstant;

public final class SendRelayMessageCallBackAdapter extends Hub.Stub {
    private final SendRelayMessageCallBack adaptee;
    private final Gson gson = new Gson();

    public SendRelayMessageCallBackAdapter(SendRelayMessageCallBack sendRelayMessageCallBack) {
        this.adaptee = sendRelayMessageCallBack;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0() {
        this.adaptee.onSuccess();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(int i, String str) {
        this.adaptee.onError(i, str);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onSuccess".equals(string)) {
            MainThread.a(new g(this));
        } else if ("onError".equals(string)) {
            MainThread.a(new h(this, bundle.getInt("code"), bundle.getString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG)));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(SendRelayMessageCallBackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
