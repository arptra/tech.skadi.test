package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.p6.i;
import com.honey.account.p6.j;
import com.honey.account.p6.k;
import com.honey.account.p6.l;
import com.honey.account.p6.m;
import com.honey.account.p6.n;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;
import java.lang.reflect.Type;

public final class ISinkListenerAdapter extends Hub.Stub {
    private final ISinkListener adaptee;
    private final Gson gson = new Gson();

    public ISinkListenerAdapter(ISinkListener iSinkListener) {
        this.adaptee = iSinkListener;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0() {
        this.adaptee.onSinkStart();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1() {
        this.adaptee.onSinkConnected();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$2() {
        this.adaptee.onSinkDisconnected();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$3(int i, String str) {
        this.adaptee.onSinkError(i, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$4(int i, Bundle bundle) {
        this.adaptee.onSinkEvent(i, bundle);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$5(SourceDisplayConfig sourceDisplayConfig) {
        this.adaptee.onSinkStartWithConfig(sourceDisplayConfig);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onSinkStart".equals(string)) {
            MainThread.a(new i(this));
        } else if ("onSinkConnected".equals(string)) {
            MainThread.a(new j(this));
        } else if ("onSinkDisconnected".equals(string)) {
            MainThread.a(new k(this));
        } else if ("onSinkError".equals(string)) {
            MainThread.a(new l(this, bundle.getInt("error"), bundle.getString("message")));
        } else if ("onSinkSyncError".equals(string)) {
            this.adaptee.onSinkSyncError(bundle.getInt("errorCode"), bundle.getString("message"));
        } else if ("onSinkEvent".equals(string)) {
            MainThread.a(new m(this, bundle.getInt("event"), (Bundle) bundle.getParcelable("bundle")));
        } else if ("onSinkSyncEvent".equals(string)) {
            this.adaptee.onSinkSyncEvent(bundle.getInt("eventCode"), (Bundle) bundle.getParcelable("bundle"));
        } else if ("onSinkStartWithConfig".equals(string)) {
            Type type = new TypeToken<SourceDisplayConfig>() {
            }.getType();
            MainThread.a(new n(this, (SourceDisplayConfig) this.gson.fromJson(bundle.getString("config"), type)));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(ISinkListenerAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
