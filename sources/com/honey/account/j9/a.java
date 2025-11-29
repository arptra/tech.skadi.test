package com.honey.account.j9;

import com.xingin.xhssharesdk.i.c;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f7449a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Throwable f;

    public /* synthetic */ a(c cVar, String str, int i, int i2, String str2, Throwable th) {
        this.f7449a = cVar;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = str2;
        this.f = th;
    }

    public final void run() {
        this.f7449a.f(this.b, this.c, this.d, this.e, this.f);
    }
}
