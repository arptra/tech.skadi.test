package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.o5.o;
import com.honey.account.o5.p;
import com.honey.account.o5.q;
import com.honey.account.o5.r;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import java.lang.reflect.Type;

public final class DeviceCallbackAdapter extends Hub.Stub {
    private final DeviceCallback adaptee;
    private final Gson gson = new Gson();

    public DeviceCallbackAdapter(DeviceCallback deviceCallback) {
        this.adaptee = deviceCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0() {
        this.adaptee.onLose();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(BleRawSession bleRawSession) {
        this.adaptee.onConnected(bleRawSession);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$2(int i) {
        this.adaptee.onDisconnected(i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$3(int i) {
        this.adaptee.onError(i);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onLose".equals(string)) {
            MainThread.a(new o(this));
        } else if ("onConnected".equals(string)) {
            Type type = new TypeToken<BleRawSession>() {
            }.getType();
            MainThread.a(new p(this, (BleRawSession) this.gson.fromJson(bundle.getString("bleRawSession"), type)));
        } else if ("onDisconnected".equals(string)) {
            MainThread.a(new q(this, bundle.getInt("reason")));
        } else if ("onError".equals(string)) {
            MainThread.a(new r(this, bundle.getInt("errorCode")));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(DeviceCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
