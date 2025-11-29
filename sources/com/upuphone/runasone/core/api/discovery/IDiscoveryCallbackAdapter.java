package com.upuphone.runasone.core.api.discovery;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.a6.a;
import com.honey.account.a6.b;
import com.honey.account.a6.c;
import com.honey.account.a6.d;
import com.honey.account.a6.e;
import com.honey.account.a6.f;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import java.lang.reflect.Type;

public final class IDiscoveryCallbackAdapter extends Hub.Stub {
    private final IDiscoveryCallback adaptee;
    private final Gson gson = new Gson();

    public IDiscoveryCallbackAdapter(IDiscoveryCallback iDiscoveryCallback) {
        this.adaptee = iDiscoveryCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i) {
        this.adaptee.onDiscoveryError(i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$1(StarryDevice starryDevice, byte[] bArr, Bundle bundle, DiscoveryFilter discoveryFilter) {
        this.adaptee.onDeviceFound(starryDevice, bArr, bundle, discoveryFilter);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$2(StarryDevice starryDevice) {
        this.adaptee.onDeviceLose(starryDevice);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$3() {
        this.adaptee.onDiscoveryTimeout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$4(StarryDevice starryDevice, byte[] bArr) {
        this.adaptee.onDeviceConnectRequest(starryDevice, bArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$5(StarryDevice starryDevice, int i, int i2) {
        this.adaptee.onFastFound(starryDevice, i, i2);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("onDiscoveryError".equals(string)) {
            MainThread.a(new a(this, bundle.getInt("errorCode")));
        } else if ("onDeviceFound".equals(string)) {
            Type type = new TypeToken<StarryDevice>() {
            }.getType();
            String string2 = bundle.getString("device");
            Type type2 = new TypeToken<DiscoveryFilter>() {
            }.getType();
            MainThread.a(new b(this, (StarryDevice) this.gson.fromJson(string2, type), bundle.getByteArray("data"), (Bundle) bundle.getParcelable("bundle"), (DiscoveryFilter) this.gson.fromJson(bundle.getString("filter"), type2)));
        } else if ("onDeviceLose".equals(string)) {
            Type type3 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new c(this, (StarryDevice) this.gson.fromJson(bundle.getString("device"), type3)));
        } else if ("onDiscoveryTimeout".equals(string)) {
            MainThread.a(new d(this));
        } else if ("onDeviceConnectRequest".equals(string)) {
            Type type4 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new e(this, (StarryDevice) this.gson.fromJson(bundle.getString("device"), type4), bundle.getByteArray("data")));
        } else if ("onFastFound".equals(string)) {
            Type type5 = new TypeToken<StarryDevice>() {
            }.getType();
            MainThread.a(new f(this, (StarryDevice) this.gson.fromJson(bundle.getString("device"), type5), bundle.getInt("type"), bundle.getInt("beaconId")));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(IDiscoveryCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
