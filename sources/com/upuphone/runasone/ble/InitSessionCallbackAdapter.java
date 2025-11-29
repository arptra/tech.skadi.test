package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.o5.y;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class InitSessionCallbackAdapter extends Hub.Stub {
    private final InitSessionCallback adaptee;
    private final Gson gson = new Gson();

    public InitSessionCallbackAdapter(InitSessionCallback initSessionCallback) {
        this.adaptee = initSessionCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i) {
        this.adaptee.onInit(i);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onInit".equals(bundle.getString("method"))) {
            MainThread.a(new y(this, bundle.getInt("state")));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(InitSessionCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
