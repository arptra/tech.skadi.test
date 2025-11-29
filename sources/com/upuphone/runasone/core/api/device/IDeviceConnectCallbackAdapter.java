package com.upuphone.runasone.core.api.device;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.z5.a;
import com.honey.account.z5.b;
import com.honey.account.z5.c;
import com.honey.account.z5.d;
import com.honey.account.z5.e;
import com.honey.account.z5.f;
import com.honey.account.z5.g;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.runasone.device.StarryDevice;
import java.lang.reflect.Type;

public final class IDeviceConnectCallbackAdapter extends Hub.Stub {
    private final IDeviceConnectCallback adaptee;
    private final Gson gson = new Gson();

    public IDeviceConnectCallbackAdapter(IDeviceConnectCallback iDeviceConnectCallback) {
        this.adaptee = iDeviceConnectCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(StarryDevice starryDevice, int i, int i2) {
        this.adaptee.onConnectedChanged(starryDevice, i, i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(StarryDevice starryDevice, boolean z) {
        this.adaptee.onBrConnectedChanged(starryDevice, z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$2(int i, int i2, StarryDevice starryDevice) {
        this.adaptee.onBondStateChanged(i, i2, starryDevice);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$3(StarryDevice starryDevice) {
        this.adaptee.onAuth(starryDevice);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$4(StarryDevice starryDevice, byte[] bArr, int i) {
        this.adaptee.onAuthMessage(starryDevice, bArr, i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$5(int i, StarryDevice starryDevice, int i2) {
        this.adaptee.onConnectFail(i, starryDevice, i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$6(StarryDevice starryDevice, boolean z) {
        this.adaptee.onBalanceConnectedChanged(starryDevice, z);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onConnectedChanged".equals(string)) {
            Type type = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new a(this, (StarryDevice) this.gson.fromJson(bundle.getString("peerDevice"), type), bundle.getInt("preState"), bundle.getInt("newState")));
        } else if ("onBrConnectedChanged".equals(string)) {
            Type type2 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new b(this, (StarryDevice) this.gson.fromJson(bundle.getString("peerDevice"), type2), bundle.getBoolean("isOpen")));
        } else if ("onBondStateChanged".equals(string)) {
            int i = bundle.getInt("state");
            int i2 = bundle.getInt("preState");
            Type type3 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new c(this, i, i2, (StarryDevice) this.gson.fromJson(bundle.getString("peerDevice"), type3)));
        } else if ("onAuth".equals(string)) {
            Type type4 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new d(this, (StarryDevice) this.gson.fromJson(bundle.getString("peerDevice"), type4)));
        } else if ("onAuthMessage".equals(string)) {
            Type type5 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new e(this, (StarryDevice) this.gson.fromJson(bundle.getString("peerDevice"), type5), bundle.getByteArray("data"), bundle.getInt("authCode")));
        } else if ("onConnectFail".equals(string)) {
            int i3 = bundle.getInt("type");
            Type type6 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new f(this, i3, (StarryDevice) this.gson.fromJson(bundle.getString("peerDevice"), type6), bundle.getInt("code")));
        } else if ("onBalanceConnectedChanged".equals(string)) {
            Type type7 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new g(this, (StarryDevice) this.gson.fromJson(bundle.getString("peerDevice"), type7), bundle.getBoolean("connectState")));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(IDeviceConnectCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
