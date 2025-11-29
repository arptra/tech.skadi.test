package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.p6.a;
import com.honey.account.p6.b;
import com.honey.account.p6.c;
import com.honey.account.p6.d;
import com.honey.account.p6.e;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class IDisplayListenerAdapter extends Hub.Stub {
    private final IDisplayListener adaptee;
    private final Gson gson = new Gson();

    public IDisplayListenerAdapter(IDisplayListener iDisplayListener) {
        this.adaptee = iDisplayListener;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0() {
        this.adaptee.onDisplayConnected();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1() {
        this.adaptee.onDisplayDisconnected();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$2(int i, String str) {
        this.adaptee.onDisplayError(i, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$3(String str) {
        this.adaptee.onUibcCustomEvent(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$4(int i, Bundle bundle) {
        this.adaptee.onDisplayEvent(i, bundle);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onDisplayConnected".equals(string)) {
            MainThread.a(new a(this));
        } else if ("onDisplayDisconnected".equals(string)) {
            MainThread.a(new b(this));
        } else if ("onDisplayError".equals(string)) {
            MainThread.a(new c(this, bundle.getInt("error"), bundle.getString("message")));
        } else if ("onDisplaySyncError".equals(string)) {
            this.adaptee.onDisplaySyncError(bundle.getInt("errorCode"), bundle.getString("message"));
        } else if ("onUibcCustomEvent".equals(string)) {
            MainThread.a(new d(this, bundle.getString("message")));
        } else if ("onDisplayEvent".equals(string)) {
            MainThread.a(new e(this, bundle.getInt("event"), (Bundle) bundle.getParcelable("bundle")));
        } else if ("onDisplaySyncEvent".equals(string)) {
            this.adaptee.onDisplaySyncEvent(bundle.getInt("eventCode"), (Bundle) bundle.getParcelable("bundle"));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(IDisplayListenerAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
