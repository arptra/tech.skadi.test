package com.upuphone.runasone.share.api;

import android.net.Uri;
import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.l6.a;
import com.honey.account.l6.b;
import com.honey.account.l6.c;
import com.honey.account.l6.d;
import com.honey.account.l6.e;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class IHubUupShareStatusCallbackAdapter extends Hub.Stub {
    private final IHubUupShareStatusCallback adaptee;
    private final Gson gson = new Gson();

    public IHubUupShareStatusCallbackAdapter(IHubUupShareStatusCallback iHubUupShareStatusCallback) {
        this.adaptee = iHubUupShareStatusCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(String str, String str2) {
        this.adaptee.onStart(str, str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(String str, int i, Uri uri) {
        this.adaptee.onProgressChanged(str, i, uri);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$2(String str, Uri uri, Uri uri2) {
        this.adaptee.onFinish(str, uri, uri2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$3(String str) {
        this.adaptee.onSuccess(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$4(String str, boolean z, int i) {
        this.adaptee.onFailure(str, z, i);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onStart".equals(string)) {
            MainThread.a(new a(this, bundle.getString("id"), bundle.getString("extra")));
        } else if ("onProgressChanged".equals(string)) {
            MainThread.a(new b(this, bundle.getString("id"), bundle.getInt("currentProgress"), (Uri) bundle.getParcelable("uri")));
        } else if ("onFinish".equals(string)) {
            MainThread.a(new c(this, bundle.getString("id"), (Uri) bundle.getParcelable("oldUri"), (Uri) bundle.getParcelable("newUri")));
        } else if ("onSuccess".equals(string)) {
            MainThread.a(new d(this, bundle.getString("id")));
        } else if ("onFailure".equals(string)) {
            MainThread.a(new e(this, bundle.getString("id"), bundle.getBoolean("isRemote"), bundle.getInt("errorCode")));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(IHubUupShareStatusCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
