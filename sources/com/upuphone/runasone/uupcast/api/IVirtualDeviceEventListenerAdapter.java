package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.p6.o;
import com.honey.account.p6.p;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class IVirtualDeviceEventListenerAdapter extends Hub.Stub {
    private final IVirtualDeviceEventListener adaptee;
    private final Gson gson = new Gson();

    public IVirtualDeviceEventListenerAdapter(IVirtualDeviceEventListener iVirtualDeviceEventListener) {
        this.adaptee = iVirtualDeviceEventListener;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i, Bundle bundle) {
        this.adaptee.onEvent(i, bundle);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(int i, String str) {
        this.adaptee.onError(i, str);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onEvent".equals(string)) {
            MainThread.a(new o(this, bundle.getInt("eventCode"), (Bundle) bundle.getParcelable("bundle")));
        } else if ("onError".equals(string)) {
            MainThread.a(new p(this, bundle.getInt("errorCode"), bundle.getString("message")));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(IVirtualDeviceEventListenerAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
