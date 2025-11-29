package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.p6.q;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class IccoaConnectListenerAdapter extends Hub.Stub {
    private final IccoaConnectListener adaptee;
    private final Gson gson = new Gson();

    public IccoaConnectListenerAdapter(IccoaConnectListener iccoaConnectListener) {
        this.adaptee = iccoaConnectListener;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i, Bundle bundle) {
        this.adaptee.onConnectEvent(i, bundle);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onConnectEvent".equals(bundle.getString("method"))) {
            MainThread.a(new q(this, bundle.getInt("event"), (Bundle) bundle.getParcelable("bundle")));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(IccoaConnectListenerAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
