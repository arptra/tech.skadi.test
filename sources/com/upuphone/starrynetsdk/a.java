package com.upuphone.starrynetsdk;

import android.content.Context;
import com.upuphone.runasone.host.api.BaseComponent;
import com.upuphone.runasone.host.api.InitApplication;
import com.upuphone.starrynetsdk.Dispatcher;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dispatcher f6544a;
    public final /* synthetic */ InitApplication b;
    public final /* synthetic */ BaseComponent c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ Dispatcher.InitListener e;

    public /* synthetic */ a(Dispatcher dispatcher, InitApplication initApplication, BaseComponent baseComponent, Context context, Dispatcher.InitListener initListener) {
        this.f6544a = dispatcher;
        this.b = initApplication;
        this.c = baseComponent;
        this.d = context;
        this.e = initListener;
    }

    public final void run() {
        this.f6544a.lambda$initComponent$1(this.b, this.c, this.d, this.e);
    }
}
