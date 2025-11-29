package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.o5.a0;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class OpenNotifyCallbackAdapter extends Hub.Stub {
    private final OpenNotifyCallback adaptee;
    private final Gson gson = new Gson();

    public OpenNotifyCallbackAdapter(OpenNotifyCallback openNotifyCallback) {
        this.adaptee = openNotifyCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i) {
        this.adaptee.onOpen(i);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onOpen".equals(bundle.getString("method"))) {
            MainThread.a(new a0(this, bundle.getInt("state")));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(OpenNotifyCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
