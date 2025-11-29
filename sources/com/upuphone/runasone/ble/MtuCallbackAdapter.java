package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.o5.z;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.starrynet.api.StConstant;

public final class MtuCallbackAdapter extends Hub.Stub {
    private final MtuCallback adaptee;
    private final Gson gson = new Gson();

    public MtuCallbackAdapter(MtuCallback mtuCallback) {
        this.adaptee = mtuCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i, int i2) {
        this.adaptee.onMtuChange(i, i2);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onMtuChange".equals(bundle.getString("method"))) {
            MainThread.a(new z(this, bundle.getInt("status"), bundle.getInt(StConstant.STARRY_NET_STACK_MTU)));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(MtuCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
