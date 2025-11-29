package com.upuphone.runasone.relay.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.e6.b;
import com.honey.account.e6.c;
import com.honey.account.e6.d;
import com.honey.account.e6.e;
import com.honey.account.e6.f;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.lang.reflect.Type;
import java.util.List;

public final class RelayCallbackAdapter extends Hub.Stub {
    private final RelayCallback adaptee;
    private final Gson gson = new Gson();

    public RelayCallbackAdapter(RelayCallback relayCallback) {
        this.adaptee = relayCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(StarryTag starryTag, ArrayData arrayData, StarryParam starryParam) {
        this.adaptee.onReceiveMessage(starryTag, arrayData, starryParam);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(String str, List list) {
        this.adaptee.onDeviceListChanged(str, list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$2(StarryTag starryTag, StarryParam starryParam) {
        this.adaptee.onRemoteStart(starryTag, starryParam);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$3(StarryTag starryTag, int i, String str, StarryParam starryParam) {
        this.adaptee.onRemoteError(starryTag, i, str, starryParam);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$4(StarryTag starryTag, StarryParam starryParam) {
        this.adaptee.onRemoteStop(starryTag, starryParam);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onReceiveMessage".equals(string)) {
            Type type = new TypeToken<StarryParam>() {
            }.getType();
            MainThread.a(new b(this, (StarryTag) bundle.getParcelable("tag"), (ArrayData) bundle.getParcelable(PayloadConstant.PARAMS_KEY_CALLBACK_MSG), (StarryParam) this.gson.fromJson(bundle.getString("param"), type)));
        } else if ("onDeviceListChanged".equals(string)) {
            String string2 = bundle.getString("appUniteCode");
            Type type2 = new TypeToken<List<StarryDevice>>() {
            }.getType();
            MainThread.a(new c(this, string2, (List) this.gson.fromJson(bundle.getString("devList"), type2)));
        } else if ("onRemoteStart".equals(string)) {
            Type type3 = new TypeToken<StarryParam>() {
            }.getType();
            MainThread.a(new d(this, (StarryTag) bundle.getParcelable("tag"), (StarryParam) this.gson.fromJson(bundle.getString("param"), type3)));
        } else if ("onRemoteError".equals(string)) {
            int i = bundle.getInt("code");
            String string3 = bundle.getString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            Type type4 = new TypeToken<StarryParam>() {
            }.getType();
            MainThread.a(new e(this, (StarryTag) bundle.getParcelable("tag"), i, string3, (StarryParam) this.gson.fromJson(bundle.getString("param"), type4)));
        } else if ("onRemoteStop".equals(string)) {
            Type type5 = new TypeToken<StarryParam>() {
            }.getType();
            MainThread.a(new f(this, (StarryTag) bundle.getParcelable("tag"), (StarryParam) this.gson.fromJson(bundle.getString("param"), type5)));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(RelayCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
