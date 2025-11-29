package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.p6.g;
import com.honey.account.p6.h;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class ISinkAudioListenerAdapter extends Hub.Stub {
    private final ISinkAudioListener adaptee;
    private final Gson gson = new Gson();

    public ISinkAudioListenerAdapter(ISinkAudioListener iSinkAudioListener) {
        this.adaptee = iSinkAudioListener;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i) {
        this.adaptee.onForceMuteStart(i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(int i) {
        this.adaptee.onForceMuteStop(i);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("convertAudioAttributes".equals(string)) {
            bundle2.putString("result", this.gson.toJson((Object) this.adaptee.convertAudioAttributes(bundle.getInt("audioType"))));
        } else if ("onForceMuteStart".equals(string)) {
            MainThread.a(new g(this, bundle.getInt("audioTypeMask")));
        } else if ("onForceMuteStop".equals(string)) {
            MainThread.a(new h(this, bundle.getInt("audioTypeMask")));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(ISinkAudioListenerAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
