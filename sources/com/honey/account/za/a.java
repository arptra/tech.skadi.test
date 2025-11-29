package com.honey.account.za;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f7727a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String[] c;
    public final /* synthetic */ Handler d;
    public final /* synthetic */ Runnable e;

    public /* synthetic */ a(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f7727a = flutterLoader;
        this.b = context;
        this.c = strArr;
        this.d = handler;
        this.e = runnable;
    }

    public final void run() {
        this.f7727a.lambda$ensureInitializationCompleteAsync$1(this.b, this.c, this.d, this.e);
    }
}
