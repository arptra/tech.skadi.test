package com.upuphone.runasone.core.api.sys;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.b6.a;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import java.lang.reflect.Type;

public final class SystemCallBackAdapter extends Hub.Stub {
    private final SystemCallBack adaptee;
    private final Gson gson = new Gson();

    public SystemCallBackAdapter(SystemCallBack systemCallBack) {
        this.adaptee = systemCallBack;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(SysCallData sysCallData) {
        this.adaptee.callBackData(sysCallData);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("callBackData".equals(bundle.getString("method"))) {
            Type type = new TypeToken<SysCallData>() {
            }.getType();
            MainThread.a(new a(this, (SysCallData) this.gson.fromJson(bundle.getString("data"), type)));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(SystemCallBackAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
