package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.o5.d0;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class WriteCallbackAdapter extends Hub.Stub {
    private final WriteCallback adaptee;
    private final Gson gson = new Gson();

    public WriteCallbackAdapter(WriteCallback writeCallback) {
        this.adaptee = writeCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i) {
        this.adaptee.onWrite(i);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onWrite".equals(bundle.getString("method"))) {
            MainThread.a(new d0(this, bundle.getInt("state")));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(WriteCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
