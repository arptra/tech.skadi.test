package com.upuphone.runasone.core.api.sys;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;

public final class LifecycleApiAdapter {
    private final LifecycleApi adaptee;
    private final Gson gson = new Gson();

    public LifecycleApiAdapter(LifecycleApi lifecycleApi) {
        this.adaptee = lifecycleApi;
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("registerLifecycleObserver".equals(string)) {
            this.adaptee.registerLifecycleObserver(bundle.getString(AccountConstantKt.REQUEST_HEADER_PKG));
        } else if ("unRegisterLifecycleObserver".equals(string)) {
            this.adaptee.unRegisterLifecycleObserver(bundle.getString(AccountConstantKt.REQUEST_HEADER_PKG));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }
}
