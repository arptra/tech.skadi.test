package com.honey.account.za;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f7728a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String[] c;
    public final /* synthetic */ Handler d;
    public final /* synthetic */ Runnable e;

    public /* synthetic */ b(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f7728a = flutterLoader;
        this.b = context;
        this.c = strArr;
        this.d = handler;
        this.e = runnable;
    }

    public final void run() {
        this.f7728a.lambda$ensureInitializationCompleteAsync$0(this.b, this.c, this.d, this.e);
    }
}
