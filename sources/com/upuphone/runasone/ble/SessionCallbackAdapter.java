package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.o5.c0;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class SessionCallbackAdapter extends Hub.Stub {
    private final SessionCallback adaptee;
    private final Gson gson = new Gson();

    public SessionCallbackAdapter(SessionCallback sessionCallback) {
        this.adaptee = sessionCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(String str, byte[] bArr) {
        this.adaptee.onNotify(str, bArr);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onNotify".equals(bundle.getString("method"))) {
            MainThread.a(new c0(this, bundle.getString("notifyUUID"), bundle.getByteArray(AccountConstantKt.RESPONSE_VALUE)));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(SessionCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
