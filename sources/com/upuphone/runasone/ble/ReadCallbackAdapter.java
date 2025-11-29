package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.o5.b0;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;

public final class ReadCallbackAdapter extends Hub.Stub {
    private final ReadCallback adaptee;
    private final Gson gson = new Gson();

    public ReadCallbackAdapter(ReadCallback readCallback) {
        this.adaptee = readCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(int i, byte[] bArr) {
        this.adaptee.onRead(i, bArr);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("onRead".equals(bundle.getString("method"))) {
            MainThread.a(new b0(this, bundle.getInt("status"), bundle.getByteArray(AccountConstantKt.RESPONSE_VALUE)));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(ReadCallbackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
