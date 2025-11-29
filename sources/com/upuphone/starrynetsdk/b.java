package com.upuphone.starrynetsdk;

import android.content.Context;
import com.upuphone.runasone.host.api.BaseComponent;
import com.upuphone.runasone.host.api.InitApplication;
import com.upuphone.runasone.host.api.InitCallback;
import com.upuphone.starrynetsdk.Dispatcher;

public final /* synthetic */ class b implements InitCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dispatcher f6548a;
    public final /* synthetic */ InitApplication b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ Dispatcher.InitListener d;

    public /* synthetic */ b(Dispatcher dispatcher, InitApplication initApplication, Context context, Dispatcher.InitListener initListener) {
        this.f6548a = dispatcher;
        this.b = initApplication;
        this.c = context;
        this.d = initListener;
    }

    public final void onComplete(BaseComponent baseComponent) {
        this.f6548a.lambda$initComponent$2(this.b, this.c, this.d, baseComponent);
    }
}
